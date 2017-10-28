package com.google.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.SimpleNetworkDispatcher.DispatchListener;
import com.google.tagmanager.protobuf.WireFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class PersistentHitStore implements HitStore {
	private static final String CREATE_HITS_TABLE;
	private static final String DATABASE_FILENAME = "gtm_urls.db";
	@VisibleForTesting
	static final String HITS_TABLE = "gtm_hits";
	static final long HIT_DISPATCH_RETRY_WINDOW = 14400000;
	@VisibleForTesting
	static final String HIT_FIRST_DISPATCH_TIME = "hit_first_send_time";
	@VisibleForTesting
	static final String HIT_ID = "hit_id";
	private static final String HIT_ID_WHERE_CLAUSE = "hit_id=?";
	@VisibleForTesting
	static final String HIT_TIME = "hit_time";
	@VisibleForTesting
	static final String HIT_URL = "hit_url";
	private Clock mClock;
	private final Context mContext;
	private final String mDatabaseName;
	private final UrlDatabaseHelper mDbHelper;
	private volatile Dispatcher mDispatcher;
	private long mLastDeleteStaleHitsTime;
	private final HitStoreStateListener mListener;

	@VisibleForTesting
	class StoreDispatchListener implements DispatchListener {
		StoreDispatchListener() {
		}

		public void onHitDispatched(Hit hit) {
			deleteHit(hit.getHitId());
		}

		public void onHitPermanentDispatchFailure(Hit hit) {
			deleteHit(hit.getHitId());
			Log.v("Permanent failure dispatching hitId: " + hit.getHitId());
		}

		public void onHitTransientDispatchFailure(Hit hit) {
			long firstDispatchTime = hit.getHitFirstDispatchTime();
			if (firstDispatchTime == 0) {
				setHitFirstDispatchTime(hit.getHitId(), mClock.currentTimeMillis());
				return;
			} else {
				if (14400000 + firstDispatchTime < mClock.currentTimeMillis()) {
					deleteHit(hit.getHitId());
					Log.v("Giving up on failed hitId: " + hit.getHitId());
				}
			}
		}
	}

	@VisibleForTesting
	class UrlDatabaseHelper extends SQLiteOpenHelper {
		private boolean mBadDatabase;
		private long mLastDatabaseCheckTime;

		UrlDatabaseHelper(Context context, String databaseName) {
			super(context, databaseName, null, 1);
			this.mLastDatabaseCheckTime = 0;
		}

		private boolean tablePresent(String table, SQLiteDatabase db) {
			Cursor cursor;
			boolean r0z;
			try {
				String[] r2_String_A = new String[1];
				r2_String_A[0] = "name";
				String[] r4_String_A = new String[1];
				r4_String_A[0] = table;
				cursor = db.query("SQLITE_MASTER", r2_String_A, "name=?", r4_String_A, null, null, null);
				r0z = cursor.moveToFirst();
				if (cursor != null) {
					cursor.close();
					return r0z;
				}
				return r0z;
			} catch (SQLiteException e) {
				Log.w("Error querying for table " + table);
				if (false) {
					null.close();
				}
				return false;
			}
		}

		private void validateColumnsPresent(SQLiteDatabase db) {
			Cursor c = db.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
			Set<String> columns = new HashSet();
			String[] columnNames = c.getColumnNames();
			int i = 0;
			while (i < columnNames.length) {
				columns.add(columnNames[i]);
				i++;
			}
			c.close();
			if (!columns.remove(HIT_ID) || !columns.remove(HIT_URL) || !columns.remove(HIT_TIME) || !columns.remove(HIT_FIRST_DISPATCH_TIME)) {
				throw new SQLiteException("Database column missing");
			} else {
				if (!columns.isEmpty()) {
					throw new SQLiteException("Database has extra columns");
				}
			}
		}

		public SQLiteDatabase getWritableDatabase() {
			if (!(this.mBadDatabase) || this.mLastDatabaseCheckTime + 3600000 <= mClock.currentTimeMillis()) {
				SQLiteDatabase db = null;
				this.mBadDatabase = true;
				this.mLastDatabaseCheckTime = mClock.currentTimeMillis();
				try {
					db = super.getWritableDatabase();
				} catch (SQLiteException e) {
					mContext.getDatabasePath(mDatabaseName).delete();
				}
				if (db == null) {
					db = super.getWritableDatabase();
				}
				this.mBadDatabase = false;
				return db;
			} else {
				throw new SQLiteException("Database creation failed");
			}
		}

		boolean isBadDatabase() {
			return this.mBadDatabase;
		}

		public void onCreate(SQLiteDatabase db) {
			FutureApis.setOwnerOnlyReadWrite(db.getPath());
		}

		public void onOpen(SQLiteDatabase db) {
			if (VERSION.SDK_INT < 15) {
				Cursor cursor = db.rawQuery("PRAGMA journal_mode=memory", null);
				cursor.moveToFirst();
				cursor.close();
			}
			if (!tablePresent(HITS_TABLE, db)) {
				db.execSQL(CREATE_HITS_TABLE);
				return;
			} else {
				validateColumnsPresent(db);
			}
		}

		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		}

		void setBadDatabase(boolean badDatabase) {
			this.mBadDatabase = badDatabase;
		}
	}


	static {
		Object[] r1_Object_A = new Object[5];
		r1_Object_A[0] = HITS_TABLE;
		r1_Object_A[1] = HIT_ID;
		r1_Object_A[2] = HIT_TIME;
		r1_Object_A[3] = HIT_URL;
		r1_Object_A[4] = HIT_FIRST_DISPATCH_TIME;
		CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", r1_Object_A);
	}

	PersistentHitStore(HitStoreStateListener listener, Context ctx) {
		this(listener, ctx, DATABASE_FILENAME);
	}

	@VisibleForTesting
	PersistentHitStore(HitStoreStateListener listener, Context ctx, String databaseName) {
		this.mContext = ctx.getApplicationContext();
		this.mDatabaseName = databaseName;
		this.mListener = listener;
		this.mClock = new Clock() {
			public long currentTimeMillis() {
				return System.currentTimeMillis();
			}
		};
		this.mDbHelper = new UrlDatabaseHelper(this.mContext, this.mDatabaseName);
		this.mDispatcher = new SimpleNetworkDispatcher(new DefaultHttpClient(), this.mContext, new StoreDispatchListener());
		this.mLastDeleteStaleHitsTime = 0;
	}

	private void deleteHit(long hitId) {
		String[] r0_String_A = new String[1];
		r0_String_A[0] = String.valueOf(hitId);
		deleteHits(r0_String_A);
	}

	private SQLiteDatabase getWritableDatabase(String errorMessage) {
		try {
			return this.mDbHelper.getWritableDatabase();
		} catch (SQLiteException e) {
			Log.w(errorMessage);
			return null;
		}
	}

	private void removeOldHitIfFull() {
		int hitsOverLimit = (getNumStoredHits() - 2000) + 1;
		if (hitsOverLimit > 0) {
			List<String> hitsToDelete = peekHitIds(hitsOverLimit);
			Log.v("Store full, deleting " + hitsToDelete.size() + " hits to make room.");
			deleteHits((String[]) hitsToDelete.toArray(new String[0]));
		}
	}

	private void setHitFirstDispatchTime(long hitId, long firstDispatchTime) {
		SQLiteDatabase db = getWritableDatabase("Error opening database for getNumStoredHits.");
		if (db == null) {
		} else {
			ContentValues cv = new ContentValues();
			cv.put(HIT_FIRST_DISPATCH_TIME, Long.valueOf(firstDispatchTime));
			try {
				String r3_String = HITS_TABLE;
				String r4_String = HIT_ID_WHERE_CLAUSE;
				String[] r5_String_A = new String[1];
				r5_String_A[0] = String.valueOf(hitId);
				db.update(r3_String, cv, r4_String, r5_String_A);
			} catch (SQLiteException e) {
				Log.w("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + hitId);
				deleteHit(hitId);
			}
		}
	}

	private void writeHitToDatabase(long hitTimeInMilliseconds, String path) {
		SQLiteDatabase db = getWritableDatabase("Error opening database for putHit");
		if (db == null) {
		} else {
			ContentValues content = new ContentValues();
			content.put(HIT_TIME, Long.valueOf(hitTimeInMilliseconds));
			content.put(HIT_URL, path);
			content.put(HIT_FIRST_DISPATCH_TIME, Integer.valueOf(0));
			try {
				db.insert(HITS_TABLE, null, content);
				this.mListener.reportStoreIsEmpty(false);
			} catch (SQLiteException e) {
				Log.w("Error storing hit");
			}
		}
	}

	public void close() {
		try {
			this.mDbHelper.getWritableDatabase().close();
			this.mDispatcher.close();
		} catch (SQLiteException e) {
			Log.w("Error opening database for close");
		}
	}

	void deleteHits(String[] hitIds) {
		boolean r3z = true;
		if (hitIds == null || hitIds.length == 0) {
		} else {
			SQLiteDatabase db = getWritableDatabase("Error opening database for deleteHits.");
			if (db != null) {
				HitStoreStateListener r5_HitStoreStateListener;
				Object[] r6_Object_A = new Object[1];
				r6_Object_A[0] = TextUtils.join(",", Collections.nCopies(hitIds.length, "?"));
				String whereClause = String.format("HIT_ID in (%s)", r6_Object_A);
				try {
					db.delete(HITS_TABLE, whereClause, hitIds);
					r5_HitStoreStateListener = this.mListener;
					if (getNumStoredHits() == 0) {
						r5_HitStoreStateListener.reportStoreIsEmpty(r3z);
					} else {
						r3z = false;
						r5_HitStoreStateListener.reportStoreIsEmpty(r3z);
					}
				} catch (SQLiteException e) {
					Log.w("Error deleting hits");
				}
			}
		}
	}

	int deleteStaleHits() {
		boolean r6z = true;
		long now = this.mClock.currentTimeMillis();
		if (now <= this.mLastDeleteStaleHitsTime + 86400000) {
			return 0;
		} else {
			this.mLastDeleteStaleHitsTime = now;
			SQLiteDatabase db = getWritableDatabase("Error opening database for deleteStaleHits.");
			if (db != null) {
				String r8_String = HITS_TABLE;
				String[] r10_String_A = new String[1];
				r10_String_A[0] = Long.toString(this.mClock.currentTimeMillis() - 2592000000L);
				int rslt = db.delete(r8_String, "HIT_TIME < ?", r10_String_A);
				HitStoreStateListener r8_HitStoreStateListener = this.mListener;
				if (getNumStoredHits() == 0) {
					r8_HitStoreStateListener.reportStoreIsEmpty(r6z);
					return rslt;
				} else {
					r6z = false;
					r8_HitStoreStateListener.reportStoreIsEmpty(r6z);
					return rslt;
				}
			}
			return 0;
		}
	}

	public void dispatch() {
		Log.v("GTM Dispatch running...");
		if (!this.mDispatcher.okToDispatch()) {
		} else {
			List<Hit> hits = peekHits(40);
			if (hits.isEmpty()) {
				Log.v("...nothing to dispatch");
				this.mListener.reportStoreIsEmpty(true);
			} else {
				this.mDispatcher.dispatchHits(hits);
				if (getNumStoredUntriedHits() > 0) {
					ServiceManagerImpl.getInstance().dispatch();
				}
			}
		}
	}

	@VisibleForTesting
	public UrlDatabaseHelper getDbHelper() {
		return this.mDbHelper;
	}

	public Dispatcher getDispatcher() {
		return this.mDispatcher;
	}

	@VisibleForTesting
	UrlDatabaseHelper getHelper() {
		return this.mDbHelper;
	}

	int getNumStoredHits() {
		int numStoredHits = 0;
		SQLiteDatabase db = getWritableDatabase("Error opening database for getNumStoredHits.");
		if (db == null) {
			return 0;
		} else {
			Cursor cursor;
			try {
				cursor = db.rawQuery("SELECT COUNT(*) from gtm_hits", null);
				if (cursor.moveToFirst()) {
					numStoredHits = (int) cursor.getLong(0);
				}
				if (cursor != null) {
					cursor.close();
				}
			} catch (SQLiteException e) {
				Log.w("Error getting numStoredHits");
				if (false) {
					null.close();
				}
			}
			return numStoredHits;
		}
	}

	int getNumStoredUntriedHits() {
		int numStoredHits = 0;
		SQLiteDatabase db = getWritableDatabase("Error opening database for getNumStoredHits.");
		if (db == null) {
			return 0;
		} else {
			Cursor cursor;
			try {
				String r1_String = HITS_TABLE;
				String[] r2_String_A = new String[2];
				r2_String_A[0] = HIT_ID;
				r2_String_A[1] = HIT_FIRST_DISPATCH_TIME;
				cursor = db.query(r1_String, r2_String_A, "hit_first_send_time=0", null, null, null, null);
				numStoredHits = cursor.getCount();
				if (cursor != null) {
					cursor.close();
				}
			} catch (SQLiteException e) {
				Log.w("Error getting num untried hits");
				if (false) {
					null.close();
				}
			}
			return numStoredHits;
		}
	}

	List<String> peekHitIds(int maxHits) {
		List<String> hitIds = new ArrayList();
		if (maxHits <= 0) {
			Log.w("Invalid maxHits specified. Skipping");
		} else {
			SQLiteDatabase db = getWritableDatabase("Error opening database for peekHitIds.");
			if (db != null) {
				Cursor cursor;
				try {
					String r1_String = HITS_TABLE;
					String[] r2_String_A = new String[1];
					r2_String_A[0] = HIT_ID;
					Object[] r8_Object_A = new Object[1];
					r8_Object_A[0] = HIT_ID;
					cursor = db.query(r1_String, r2_String_A, null, null, null, null, String.format("%s ASC", r8_Object_A), Integer.toString(maxHits));
				} catch (SQLiteException e) {
					SQLiteException e_2 = e;
					Log.w("Error in peekHits fetching hitIds: " + e_2.getMessage());
					if (false) {
						null.close();
					}
				}
				if (cursor.moveToFirst()) {
					do {
						hitIds.add(String.valueOf(cursor.getLong(0)));
					} while (cursor.moveToNext());
					if (cursor == null) {
						cursor.close();
					}
				} else if (cursor == null) {
					return hitIds;
				} else {
					cursor.close();
				}
			}
		}
		return hitIds;
	}

	/* JADX WARNING: inconsistent code */
	/*
	public java.util.List<com.google.tagmanager.Hit> peekHits(int r23_maxHits) {
		r22_this = this;
		r17 = new java.util.ArrayList;
		r17.<init>();
		r3 = "Error opening database for peekHits";
		r0 = r22;
		r1 = r0.getWritableDatabase(r3);
		if (r1_db != 0) goto L_0x0012;
	L_0x000f:
		r18 = r17_hits;
	L_0x0011:
		return r18;
	L_0x0012:
		r13 = 0;
		r2 = "gtm_hits";
		r3 = 3;
		r3 = new java.lang.String[r3];	 //Catch:{ SQLiteException -> 0x00d0 }
		r4 = 0;
		r5 = "hit_id";
		r3[r4] = r5;	 //Catch:{ SQLiteException -> 0x00d0 }
		r4 = 1;
		r5 = "hit_time";
		r3[r4] = r5;	 //Catch:{ SQLiteException -> 0x00d0 }
		r4 = 2;
		r5 = "hit_first_send_time";
		r3[r4] = r5;	 //Catch:{ SQLiteException -> 0x00d0 }
		r4 = 0;
		r5 = 0;
		r6 = 0;
		r7 = 0;
		r8 = "%s ASC";
		r9 = 1;
		r9 = new java.lang.Object[r9];	 //Catch:{ SQLiteException -> 0x00d0 }
		r10 = 0;
		r11 = "hit_id";
		r9[r10] = r11;	 //Catch:{ SQLiteException -> 0x00d0 }
		r8 = java.lang.String.format(r8, r9);	 //Catch:{ SQLiteException -> 0x00d0 }
		r9 = java.lang.Integer.toString(r23_maxHits);	 //Catch:{ SQLiteException -> 0x00d0 }
		r13_cursor = r1_db.query(r2, r3, r4, r5, r6, r7, r8, r9);	 //Catch:{ SQLiteException -> 0x00d0 }
		r18 = new java.util.ArrayList;	 //Catch:{ SQLiteException -> 0x00d0 }
		r18.<init>();	 //Catch:{ SQLiteException -> 0x00d0 }
		r3 = r13_cursor.moveToFirst();	 //Catch:{ SQLiteException -> 0x0178, all -> 0x0173 }
		if (r3 == 0) goto L_0x006b;
	L_0x004c:
		r2 = new com.google.tagmanager.Hit;	 //Catch:{ SQLiteException -> 0x0178, all -> 0x0173 }
		r3 = 0;
		r3 = r13_cursor.getLong(r3);	 //Catch:{ SQLiteException -> 0x0178, all -> 0x0173 }
		r5 = 1;
		r5 = r13_cursor.getLong(r5);	 //Catch:{ SQLiteException -> 0x0178, all -> 0x0173 }
		r7 = 2;
		r7 = r13_cursor.getLong(r7);	 //Catch:{ SQLiteException -> 0x0178, all -> 0x0173 }
		r2.<init>(r3, r5, r7);	 //Catch:{ SQLiteException -> 0x0178, all -> 0x0173 }
		r0 = r18_hits;
		r0.add(r2_hit);	 //Catch:{ SQLiteException -> 0x0178, all -> 0x0173 }
		r3 = r13_cursor.moveToNext();	 //Catch:{ SQLiteException -> 0x0178, all -> 0x0173 }
		if (r3 != 0) goto L_0x004c;
	L_0x006b:
		if (r13_cursor == 0) goto L_0x0070;
	L_0x006d:
		r13_cursor.close();
	L_0x0070:
		r12 = 0;
		r4 = "gtm_hits";
		r3 = 2;
		r5 = new java.lang.String[r3];	 //Catch:{ SQLiteException -> 0x011b }
		r3 = 0;
		r6 = "hit_id";
		r5[r3] = r6;	 //Catch:{ SQLiteException -> 0x011b }
		r3 = 1;
		r6 = "hit_url";
		r5[r3] = r6;	 //Catch:{ SQLiteException -> 0x011b }
		r6 = 0;
		r7 = 0;
		r8 = 0;
		r9 = 0;
		r3 = "%s ASC";
		r10 = 1;
		r10 = new java.lang.Object[r10];	 //Catch:{ SQLiteException -> 0x011b }
		r11 = 0;
		r21 = "hit_id";
		r10[r11] = r21;	 //Catch:{ SQLiteException -> 0x011b }
		r10 = java.lang.String.format(r3, r10);	 //Catch:{ SQLiteException -> 0x011b }
		r11 = java.lang.Integer.toString(r23_maxHits);	 //Catch:{ SQLiteException -> 0x011b }
		r3 = r1_db;
		r13_cursor = r3.query(r4, r5, r6, r7, r8, r9, r10, r11);	 //Catch:{ SQLiteException -> 0x011b }
		r3 = r13_cursor.moveToFirst();	 //Catch:{ SQLiteException -> 0x011b }
		if (r3 == 0) goto L_0x00c7;
	L_0x00a1:
		r0 = r13_cursor;
		r0 = (android.database.sqlite.SQLiteCursor) r0;	 //Catch:{ SQLiteException -> 0x011b }
		r3 = r0;
		r14 = r3.getWindow();	 //Catch:{ SQLiteException -> 0x011b }
		r3 = r14_cw.getNumRows();	 //Catch:{ SQLiteException -> 0x011b }
		if (r3 <= 0) goto L_0x00fb;
	L_0x00af:
		r0 = r18_hits;
		r3 = r0.get(r12_count);	 //Catch:{ SQLiteException -> 0x011b }
		r3 = (com.google.tagmanager.Hit) r3;	 //Catch:{ SQLiteException -> 0x011b }
		r4 = 1;
		r4 = r13_cursor.getString(r4);	 //Catch:{ SQLiteException -> 0x011b }
		r3.setHitUrl(r4);	 //Catch:{ SQLiteException -> 0x011b }
	L_0x00bf:
		r12_count++;
		r3 = r13_cursor.moveToNext();	 //Catch:{ SQLiteException -> 0x011b }
		if (r3 != 0) goto L_0x00a1;
	L_0x00c7:
		if (r13_cursor == 0) goto L_0x00cc;
	L_0x00c9:
		r13_cursor.close();
	L_0x00cc:
		r17_hits = r18_hits;
		goto L_0x0011;
	L_0x00d0:
		r15 = move-exception;
	L_0x00d1:
		r3 = new java.lang.StringBuilder;	 //Catch:{ all -> 0x00f4 }
		r3.<init>();	 //Catch:{ all -> 0x00f4 }
		r4 = "Error in peekHits fetching hitIds: ";
		r3 = r3.append(r4);	 //Catch:{ all -> 0x00f4 }
		r4 = r15_e.getMessage();	 //Catch:{ all -> 0x00f4 }
		r3 = r3.append(r4);	 //Catch:{ all -> 0x00f4 }
		r3 = r3.toString();	 //Catch:{ all -> 0x00f4 }
		com.google.tagmanager.Log.w(r3);	 //Catch:{ all -> 0x00f4 }
		if (r13_cursor == 0) goto L_0x00f0;
	L_0x00ed:
		r13_cursor.close();
	L_0x00f0:
		r18_hits = r17_hits;
		goto L_0x0011;
	L_0x00f4:
		r3 = move-exception;
	L_0x00f5:
		if (r13_cursor == 0) goto L_0x00fa;
	L_0x00f7:
		r13_cursor.close();
	L_0x00fa:
		throw r3;
	L_0x00fb:
		r4 = "HitString for hitId %d too large.  Hit will be deleted.";
		r3 = 1;
		r5 = new java.lang.Object[r3];	 //Catch:{ SQLiteException -> 0x011b }
		r6 = 0;
		r0 = r18_hits;
		r3 = r0.get(r12_count);	 //Catch:{ SQLiteException -> 0x011b }
		r3 = (com.google.tagmanager.Hit) r3;	 //Catch:{ SQLiteException -> 0x011b }
		r7 = r3.getHitId();	 //Catch:{ SQLiteException -> 0x011b }
		r3 = java.lang.Long.valueOf(r7);	 //Catch:{ SQLiteException -> 0x011b }
		r5[r6] = r3;	 //Catch:{ SQLiteException -> 0x011b }
		r3 = java.lang.String.format(r4, r5);	 //Catch:{ SQLiteException -> 0x011b }
		com.google.tagmanager.Log.w(r3);	 //Catch:{ SQLiteException -> 0x011b }
		goto L_0x00bf;
	L_0x011b:
		r15_e = move-exception;
		r3 = new java.lang.StringBuilder;	 //Catch:{ all -> 0x016c }
		r3.<init>();	 //Catch:{ all -> 0x016c }
		r4 = "Error in peekHits fetching hit url: ";
		r3 = r3.append(r4);	 //Catch:{ all -> 0x016c }
		r4 = r15_e.getMessage();	 //Catch:{ all -> 0x016c }
		r3 = r3.append(r4);	 //Catch:{ all -> 0x016c }
		r3 = r3.toString();	 //Catch:{ all -> 0x016c }
		com.google.tagmanager.Log.w(r3);	 //Catch:{ all -> 0x016c }
		r20 = new java.util.ArrayList;	 //Catch:{ all -> 0x016c }
		r20.<init>();	 //Catch:{ all -> 0x016c }
		r16 = 0;
		r19 = r18_hits.iterator();	 //Catch:{ all -> 0x016c }
	L_0x0141:
		r3 = r19_i$.hasNext();	 //Catch:{ all -> 0x016c }
		if (r3 == 0) goto L_0x0159;
	L_0x0147:
		r2_hit = r19_i$.next();	 //Catch:{ all -> 0x016c }
		r2_hit = (com.google.tagmanager.Hit) r2_hit;	 //Catch:{ all -> 0x016c }
		r3 = r2_hit.getHitUrl();	 //Catch:{ all -> 0x016c }
		r3 = android.text.TextUtils.isEmpty(r3);	 //Catch:{ all -> 0x016c }
		if (r3 == 0) goto L_0x0166;
	L_0x0157:
		if (r16_foundOneBadHit == 0) goto L_0x0164;
	L_0x0159:
		if (r13_cursor == 0) goto L_0x015e;
	L_0x015b:
		r13_cursor.close();
	L_0x015e:
		r17_hits = r18_hits;
		r18_hits = r20_partialHits;
		goto L_0x0011;
	L_0x0164:
		r16_foundOneBadHit = 1;
	L_0x0166:
		r0 = r20_partialHits;
		r0.add(r2_hit);	 //Catch:{ all -> 0x016c }
		goto L_0x0141;
	L_0x016c:
		r3 = move-exception;
		if (r13_cursor == 0) goto L_0x0172;
	L_0x016f:
		r13_cursor.close();
	L_0x0172:
		throw r3;
	L_0x0173:
		r3 = move-exception;
		r17_hits = r18_hits;
		goto L_0x00f5;
	L_0x0178:
		r15 = move-exception;
		r17_hits = r18_hits;
		goto L_0x00d1;
	}
	*/
	public List<Hit> peekHits(int maxHits) {
		List<Hit> hits;
		Cursor cursor;
		List<Hit> hits_2;
		SQLiteException e;
		hits = new ArrayList();
		SQLiteDatabase db = getWritableDatabase("Error opening database for peekHits");
		if (db == null) {
			return hits;
		} else {
			cursor = null;
			try {
				String r2_String = HITS_TABLE;
				String[] r3_String_A = new String[3];
				r3_String_A[0] = HIT_ID;
				r3_String_A[1] = HIT_TIME;
				r3_String_A[2] = HIT_FIRST_DISPATCH_TIME;
				Object[] r9_Object_A = new Object[1];
				r9_Object_A[0] = HIT_ID;
				cursor = db.query(r2_String, r3_String_A, null, null, null, null, String.format("%s ASC", r9_Object_A), Integer.toString(maxHits));
				hits_2 = new ArrayList();
				int count;
				String r4_String;
				String[] r5_String_A;
				Object[] r10_Object_A;
				Object[] r5_Object_A;
				if (cursor.moveToFirst()) {
					do {
						hits_2.add(new Hit(cursor.getLong(0), cursor.getLong(1), cursor.getLong(WireFormat.WIRETYPE_LENGTH_DELIMITED)));
					} while (cursor.moveToNext());
					if (cursor == null) {
						cursor.close();
					}
					count = 0;
					try {
						r4_String = HITS_TABLE;
						r5_String_A = new String[2];
						r5_String_A[0] = HIT_ID;
						r5_String_A[1] = HIT_URL;
						r10_Object_A = new Object[1];
						r10_Object_A[0] = HIT_ID;
						cursor = db.query(r4_String, r5_String_A, null, null, null, null, String.format("%s ASC", r10_Object_A), Integer.toString(maxHits));
						if (cursor.moveToFirst()) {
							do {
								if (((SQLiteCursor) cursor).getWindow().getNumRows() > 0) {
									((Hit) hits_2.get(count)).setHitUrl(cursor.getString(1));
								} else {
									r5_Object_A = new Object[1];
									r5_Object_A[0] = Long.valueOf(((Hit) hits_2.get(count)).getHitId());
									Log.w(String.format("HitString for hitId %d too large.  Hit will be deleted.", r5_Object_A));
								}
								count++;
							} while (cursor.moveToNext());
							if (cursor == null) {
								cursor.close();
							}
							hits = hits_2;
							return hits_2;
						} else if (cursor == null) {
							hits = hits_2;
							return hits_2;
						} else {
							cursor.close();
							hits = hits_2;
							return hits_2;
						}
					} catch (SQLiteException e_2) {
						e = e_2;
						Log.w("Error in peekHits fetching hit url: " + e.getMessage());
						List<Hit> partialHits = new ArrayList();
						boolean foundOneBadHit = false;
						Iterator i$ = hits_2.iterator();
						while (i$.hasNext()) {
							Hit hit = i$.next();
							if (TextUtils.isEmpty(hit.getHitUrl())) {
								if (foundOneBadHit) {
									if (cursor == null) {
										cursor.close();
									}
								} else {
									foundOneBadHit = true;
								}
							}
							partialHits.add(hit);
						}
						if (cursor == null) {
							hits = hits_2;
							return partialHits;
						} else {
							cursor.close();
							hits = hits_2;
							return partialHits;
						}
					}
				} else if (cursor == null) {
					count = 0;
					r4_String = HITS_TABLE;
					r5_String_A = new String[2];
					r5_String_A[0] = HIT_ID;
					r5_String_A[1] = HIT_URL;
					r10_Object_A = new Object[1];
					r10_Object_A[0] = HIT_ID;
					cursor = db.query(r4_String, r5_String_A, null, null, null, null, String.format("%s ASC", r10_Object_A), Integer.toString(maxHits));
					if (cursor.moveToFirst()) {
						if (cursor == null) {
							cursor.close();
						}
						hits = hits_2;
						return hits_2;
					} else {
						do {
							if (((SQLiteCursor) cursor).getWindow().getNumRows() > 0) {
								r5_Object_A = new Object[1];
								r5_Object_A[0] = Long.valueOf(((Hit) hits_2.get(count)).getHitId());
								Log.w(String.format("HitString for hitId %d too large.  Hit will be deleted.", r5_Object_A));
							} else {
								((Hit) hits_2.get(count)).setHitUrl(cursor.getString(1));
							}
							count++;
						} while (cursor.moveToNext());
						if (cursor == null) {
							hits = hits_2;
							return hits_2;
						} else {
							cursor.close();
							hits = hits_2;
							return hits_2;
						}
					}
				} else {
					cursor.close();
					count = 0;
					r4_String = HITS_TABLE;
					r5_String_A = new String[2];
					r5_String_A[0] = HIT_ID;
					r5_String_A[1] = HIT_URL;
					r10_Object_A = new Object[1];
					r10_Object_A[0] = HIT_ID;
					cursor = db.query(r4_String, r5_String_A, null, null, null, null, String.format("%s ASC", r10_Object_A), Integer.toString(maxHits));
					if (cursor.moveToFirst()) {
						do {
							if (((SQLiteCursor) cursor).getWindow().getNumRows() > 0) {
								((Hit) hits_2.get(count)).setHitUrl(cursor.getString(1));
							} else {
								r5_Object_A = new Object[1];
								r5_Object_A[0] = Long.valueOf(((Hit) hits_2.get(count)).getHitId());
								Log.w(String.format("HitString for hitId %d too large.  Hit will be deleted.", r5_Object_A));
							}
							count++;
						} while (cursor.moveToNext());
						if (cursor == null) {
							cursor.close();
						}
						hits = hits_2;
						return hits_2;
					} else if (cursor == null) {
						hits = hits_2;
						return hits_2;
					} else {
						cursor.close();
						hits = hits_2;
						return hits_2;
					}
				}
			} catch (SQLiteException e_3) {
				e = e_3;
			}
		}
	}

	public void putHit(long hitTimeInMilliseconds, String path) {
		deleteStaleHits();
		removeOldHitIfFull();
		writeHitToDatabase(hitTimeInMilliseconds, path);
	}

	@VisibleForTesting
	public void setClock(Clock clock) {
		this.mClock = clock;
	}

	@VisibleForTesting
	void setDispatcher(Dispatcher dispatcher) {
		this.mDispatcher = dispatcher;
	}

	@VisibleForTesting
	void setLastDeleteStaleHitsTime(long timeInMilliseconds) {
		this.mLastDeleteStaleHitsTime = timeInMilliseconds;
	}
}
