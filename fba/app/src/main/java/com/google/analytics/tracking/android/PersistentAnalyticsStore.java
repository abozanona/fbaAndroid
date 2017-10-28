package com.google.analytics.tracking.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.protobuf.WireFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class PersistentAnalyticsStore implements AnalyticsStore {
	private static final String CREATE_HITS_TABLE;
	private static final String DATABASE_FILENAME = "google_analytics_v2.db";
	@VisibleForTesting
	static final String HITS_TABLE = "hits2";
	@VisibleForTesting
	static final String HIT_APP_ID = "hit_app_id";
	@VisibleForTesting
	static final String HIT_ID = "hit_id";
	@VisibleForTesting
	static final String HIT_STRING = "hit_string";
	@VisibleForTesting
	static final String HIT_TIME = "hit_time";
	@VisibleForTesting
	static final String HIT_URL = "hit_url";
	private Clock mClock;
	private final Context mContext;
	private final String mDatabaseName;
	private final AnalyticsDatabaseHelper mDbHelper;
	private volatile Dispatcher mDispatcher;
	private long mLastDeleteStaleHitsTime;
	private final AnalyticsStoreStateListener mListener;

	@VisibleForTesting
	class AnalyticsDatabaseHelper extends SQLiteOpenHelper {
		private boolean mBadDatabase;
		private long mLastDatabaseCheckTime;

		AnalyticsDatabaseHelper(Context context, String databaseName) {
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
			Cursor c = db.rawQuery("SELECT * FROM hits2 WHERE 0", null);
			Set<String> columns = new HashSet();
			String[] columnNames = c.getColumnNames();
			int i = 0;
			while (i < columnNames.length) {
				columns.add(columnNames[i]);
				i++;
			}
			c.close();
			if (!columns.remove(HIT_ID) || !columns.remove(HIT_URL) || !columns.remove(HIT_STRING) || !columns.remove(HIT_TIME)) {
				throw new SQLiteException("Database column missing");
			} else {
				boolean needsAppId;
				needsAppId = !columns.remove(HIT_APP_ID);
				if (!columns.isEmpty()) {
					throw new SQLiteException("Database has extra columns");
				} else {
					if (needsAppId) {
						db.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
					}
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
		Object[] r1_Object_A = new Object[6];
		r1_Object_A[0] = HITS_TABLE;
		r1_Object_A[1] = HIT_ID;
		r1_Object_A[2] = HIT_TIME;
		r1_Object_A[3] = HIT_URL;
		r1_Object_A[4] = HIT_STRING;
		r1_Object_A[5] = HIT_APP_ID;
		CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", r1_Object_A);
	}

	PersistentAnalyticsStore(AnalyticsStoreStateListener listener, Context ctx) {
		this(listener, ctx, DATABASE_FILENAME);
	}

	@VisibleForTesting
	PersistentAnalyticsStore(AnalyticsStoreStateListener listener, Context ctx, String databaseName) {
		this.mContext = ctx.getApplicationContext();
		this.mDatabaseName = databaseName;
		this.mListener = listener;
		this.mClock = new Clock() {
			public long currentTimeMillis() {
				return System.currentTimeMillis();
			}
		};
		this.mDbHelper = new AnalyticsDatabaseHelper(this.mContext, this.mDatabaseName);
		this.mDispatcher = new SimpleNetworkDispatcher(new DefaultHttpClient(), this.mContext);
		this.mLastDeleteStaleHitsTime = 0;
	}

	private void fillVersionParameter(Map<String, String> wireFormatParams, Collection<Command> commands) {
		String clientVersionParam = "&_v".substring(1);
		if (commands != null) {
			Iterator i$ = commands.iterator();
			while (i$.hasNext()) {
				Command command = (Command) i$.next();
				if (Command.APPEND_VERSION.equals(command.getId())) {
					wireFormatParams.put(clientVersionParam, command.getValue());
				}
			}
		}
	}

	static String generateHitString(Map<String, String> urlParams) {
		Iterable keyAndValues = new ArrayList(urlParams.size());
		Iterator i$ = urlParams.entrySet().iterator();
		while (i$.hasNext()) {
			Entry<String, String> entry = (Entry) i$.next();
			keyAndValues.add(HitBuilder.encode((String) entry.getKey()) + "=" + HitBuilder.encode((String) entry.getValue()));
		}
		return TextUtils.join("&", keyAndValues);
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

	private void writeHitToDatabase(Map<String, String> hit, long hitTimeInMilliseconds, String path) {
		SQLiteDatabase db = getWritableDatabase("Error opening database for putHit");
		if (db == null) {
		} else {
			ContentValues content = new ContentValues();
			content.put(HIT_STRING, generateHitString(hit));
			content.put(HIT_TIME, Long.valueOf(hitTimeInMilliseconds));
			long appSystemId = 0;
			if (hit.containsKey(Fields.ANDROID_APP_UID)) {
				try {
					appSystemId = Long.parseLong((String) hit.get(Fields.ANDROID_APP_UID));
				} catch (NumberFormatException e) {
				}
			}
			content.put(HIT_APP_ID, Long.valueOf(appSystemId));
			if (path == null) {
				path = "http://www.google-analytics.com/collect";
			}
			if (path.length() == 0) {
				Log.w("Empty path: not sending hit");
			} else {
				content.put(HIT_URL, path);
				try {
					db.insert(HITS_TABLE, null, content);
					this.mListener.reportStoreIsEmpty(false);
				} catch (SQLiteException e_2) {
					Log.w("Error storing hit");
				}
			}
		}
	}

	public void clearHits(long appId) {
		boolean r2z = true;
		SQLiteDatabase db = getWritableDatabase("Error opening database for clearHits");
		if (db != null) {
			if (appId == 0) {
				db.delete(HITS_TABLE, null, null);
			} else {
				String[] params = new String[1];
				params[0] = Long.valueOf(appId).toString();
				db.delete(HITS_TABLE, "hit_app_id = ?", params);
			}
			AnalyticsStoreStateListener r4_AnalyticsStoreStateListener = this.mListener;
			if (getNumStoredHits() == 0) {
				r4_AnalyticsStoreStateListener.reportStoreIsEmpty(r2z);
			} else {
				r2z = false;
				r4_AnalyticsStoreStateListener.reportStoreIsEmpty(r2z);
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

	@Deprecated
	void deleteHits(Collection<Hit> hits) {
		if (hits == null || hits.isEmpty()) {
			Log.w("Empty/Null collection passed to deleteHits.");
			return;
		} else {
			String[] hitIds = new String[hits.size()];
			int i = 0;
			Iterator i$ = hits.iterator();
			while (i$.hasNext()) {
				hitIds[i] = String.valueOf(((Hit) i$.next()).getHitId());
				i = i + 1;
			}
			deleteHits(hitIds);
		}
	}

	void deleteHits(String[] hitIds) {
		boolean r3z = true;
		if (hitIds == null || hitIds.length == 0) {
			Log.w("Empty hitIds passed to deleteHits.");
			return;
		} else {
			SQLiteDatabase db = getWritableDatabase("Error opening database for deleteHits.");
			if (db != null) {
				AnalyticsStoreStateListener r5_AnalyticsStoreStateListener;
				Object[] r6_Object_A = new Object[1];
				r6_Object_A[0] = TextUtils.join(",", Collections.nCopies(hitIds.length, "?"));
				String whereClause = String.format("HIT_ID in (%s)", r6_Object_A);
				try {
					db.delete(HITS_TABLE, whereClause, hitIds);
					r5_AnalyticsStoreStateListener = this.mListener;
					if (getNumStoredHits() == 0) {
						r5_AnalyticsStoreStateListener.reportStoreIsEmpty(r3z);
					} else {
						r3z = false;
						r5_AnalyticsStoreStateListener.reportStoreIsEmpty(r3z);
					}
				} catch (SQLiteException e) {
					Log.w("Error deleting hits " + hitIds);
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
				AnalyticsStoreStateListener r8_AnalyticsStoreStateListener = this.mListener;
				if (getNumStoredHits() == 0) {
					r8_AnalyticsStoreStateListener.reportStoreIsEmpty(r6z);
					return rslt;
				} else {
					r6z = false;
					r8_AnalyticsStoreStateListener.reportStoreIsEmpty(r6z);
					return rslt;
				}
			}
			return 0;
		}
	}

	public void dispatch() {
		Log.v("Dispatch running...");
		if (!this.mDispatcher.okToDispatch()) {
		} else {
			List<Hit> hits = peekHits(40);
			if (hits.isEmpty()) {
				Log.v("...nothing to dispatch");
				this.mListener.reportStoreIsEmpty(true);
			} else {
				int hitsDispatched = this.mDispatcher.dispatchHits(hits);
				Log.v("sent " + hitsDispatched + " of " + hits.size() + " hits");
				deleteHits(hits.subList(0, Math.min(hitsDispatched, hits.size())));
				if (hitsDispatched != hits.size() || getNumStoredHits() <= 0) {
				} else {
					GAServiceManager.getInstance().dispatchLocalHits();
				}
			}
		}
	}

	@VisibleForTesting
	public AnalyticsDatabaseHelper getDbHelper() {
		return this.mDbHelper;
	}

	public Dispatcher getDispatcher() {
		return this.mDispatcher;
	}

	@VisibleForTesting
	AnalyticsDatabaseHelper getHelper() {
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
				cursor = db.rawQuery("SELECT COUNT(*) from hits2", null);
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
	public java.util.List<com.google.analytics.tracking.android.Hit> peekHits(int r23_maxHits) {
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
		r2 = "hits2";
		r3 = 2;
		r3 = new java.lang.String[r3];	 //Catch:{ SQLiteException -> 0x00dc }
		r4 = 0;
		r5 = "hit_id";
		r3[r4] = r5;	 //Catch:{ SQLiteException -> 0x00dc }
		r4 = 1;
		r5 = "hit_time";
		r3[r4] = r5;	 //Catch:{ SQLiteException -> 0x00dc }
		r4 = 0;
		r5 = 0;
		r6 = 0;
		r7 = 0;
		r8 = "%s ASC";
		r9 = 1;
		r9 = new java.lang.Object[r9];	 //Catch:{ SQLiteException -> 0x00dc }
		r10 = 0;
		r11 = "hit_id";
		r9[r10] = r11;	 //Catch:{ SQLiteException -> 0x00dc }
		r8 = java.lang.String.format(r8, r9);	 //Catch:{ SQLiteException -> 0x00dc }
		r9 = java.lang.Integer.toString(r23_maxHits);	 //Catch:{ SQLiteException -> 0x00dc }
		r13_cursor = r1_db.query(r2, r3, r4, r5, r6, r7, r8, r9);	 //Catch:{ SQLiteException -> 0x00dc }
		r18 = new java.util.ArrayList;	 //Catch:{ SQLiteException -> 0x00dc }
		r18.<init>();	 //Catch:{ SQLiteException -> 0x00dc }
		r3 = r13_cursor.moveToFirst();	 //Catch:{ SQLiteException -> 0x0184, all -> 0x017f }
		if (r3 == 0) goto L_0x0062;
	L_0x0047:
		r2 = new com.google.analytics.tracking.android.Hit;	 //Catch:{ SQLiteException -> 0x0184, all -> 0x017f }
		r3 = 0;
		r4 = 0;
		r4 = r13_cursor.getLong(r4);	 //Catch:{ SQLiteException -> 0x0184, all -> 0x017f }
		r6 = 1;
		r6 = r13_cursor.getLong(r6);	 //Catch:{ SQLiteException -> 0x0184, all -> 0x017f }
		r2.<init>(r3, r4, r6);	 //Catch:{ SQLiteException -> 0x0184, all -> 0x017f }
		r0 = r18_hits;
		r0.add(r2_hit);	 //Catch:{ SQLiteException -> 0x0184, all -> 0x017f }
		r3 = r13_cursor.moveToNext();	 //Catch:{ SQLiteException -> 0x0184, all -> 0x017f }
		if (r3 != 0) goto L_0x0047;
	L_0x0062:
		if (r13_cursor == 0) goto L_0x0067;
	L_0x0064:
		r13_cursor.close();
	L_0x0067:
		r12 = 0;
		r4 = "hits2";
		r3 = 3;
		r5 = new java.lang.String[r3];	 //Catch:{ SQLiteException -> 0x0127 }
		r3 = 0;
		r6 = "hit_id";
		r5[r3] = r6;	 //Catch:{ SQLiteException -> 0x0127 }
		r3 = 1;
		r6 = "hit_string";
		r5[r3] = r6;	 //Catch:{ SQLiteException -> 0x0127 }
		r3 = 2;
		r6 = "hit_url";
		r5[r3] = r6;	 //Catch:{ SQLiteException -> 0x0127 }
		r6 = 0;
		r7 = 0;
		r8 = 0;
		r9 = 0;
		r3 = "%s ASC";
		r10 = 1;
		r10 = new java.lang.Object[r10];	 //Catch:{ SQLiteException -> 0x0127 }
		r11 = 0;
		r21 = "hit_id";
		r10[r11] = r21;	 //Catch:{ SQLiteException -> 0x0127 }
		r10 = java.lang.String.format(r3, r10);	 //Catch:{ SQLiteException -> 0x0127 }
		r11 = java.lang.Integer.toString(r23_maxHits);	 //Catch:{ SQLiteException -> 0x0127 }
		r3 = r1_db;
		r13_cursor = r3.query(r4, r5, r6, r7, r8, r9, r10, r11);	 //Catch:{ SQLiteException -> 0x0127 }
		r3 = r13_cursor.moveToFirst();	 //Catch:{ SQLiteException -> 0x0127 }
		if (r3 == 0) goto L_0x00d3;
	L_0x009d:
		r0 = r13_cursor;
		r0 = (android.database.sqlite.SQLiteCursor) r0;	 //Catch:{ SQLiteException -> 0x0127 }
		r3 = r0;
		r14 = r3.getWindow();	 //Catch:{ SQLiteException -> 0x0127 }
		r3 = r14_cw.getNumRows();	 //Catch:{ SQLiteException -> 0x0127 }
		if (r3 <= 0) goto L_0x0107;
	L_0x00ab:
		r0 = r18_hits;
		r3 = r0.get(r12_count);	 //Catch:{ SQLiteException -> 0x0127 }
		r3 = (com.google.analytics.tracking.android.Hit) r3;	 //Catch:{ SQLiteException -> 0x0127 }
		r4 = 1;
		r4 = r13_cursor.getString(r4);	 //Catch:{ SQLiteException -> 0x0127 }
		r3.setHitString(r4);	 //Catch:{ SQLiteException -> 0x0127 }
		r0 = r18_hits;
		r3 = r0.get(r12_count);	 //Catch:{ SQLiteException -> 0x0127 }
		r3 = (com.google.analytics.tracking.android.Hit) r3;	 //Catch:{ SQLiteException -> 0x0127 }
		r4 = 2;
		r4 = r13_cursor.getString(r4);	 //Catch:{ SQLiteException -> 0x0127 }
		r3.setHitUrl(r4);	 //Catch:{ SQLiteException -> 0x0127 }
	L_0x00cb:
		r12_count++;
		r3 = r13_cursor.moveToNext();	 //Catch:{ SQLiteException -> 0x0127 }
		if (r3 != 0) goto L_0x009d;
	L_0x00d3:
		if (r13_cursor == 0) goto L_0x00d8;
	L_0x00d5:
		r13_cursor.close();
	L_0x00d8:
		r17_hits = r18_hits;
		goto L_0x0011;
	L_0x00dc:
		r15 = move-exception;
	L_0x00dd:
		r3 = new java.lang.StringBuilder;	 //Catch:{ all -> 0x0100 }
		r3.<init>();	 //Catch:{ all -> 0x0100 }
		r4 = "Error in peekHits fetching hitIds: ";
		r3 = r3.append(r4);	 //Catch:{ all -> 0x0100 }
		r4 = r15_e.getMessage();	 //Catch:{ all -> 0x0100 }
		r3 = r3.append(r4);	 //Catch:{ all -> 0x0100 }
		r3 = r3.toString();	 //Catch:{ all -> 0x0100 }
		com.google.analytics.tracking.android.Log.w(r3);	 //Catch:{ all -> 0x0100 }
		if (r13_cursor == 0) goto L_0x00fc;
	L_0x00f9:
		r13_cursor.close();
	L_0x00fc:
		r18_hits = r17_hits;
		goto L_0x0011;
	L_0x0100:
		r3 = move-exception;
	L_0x0101:
		if (r13_cursor == 0) goto L_0x0106;
	L_0x0103:
		r13_cursor.close();
	L_0x0106:
		throw r3;
	L_0x0107:
		r4 = "HitString for hitId %d too large.  Hit will be deleted.";
		r3 = 1;
		r5 = new java.lang.Object[r3];	 //Catch:{ SQLiteException -> 0x0127 }
		r6 = 0;
		r0 = r18_hits;
		r3 = r0.get(r12_count);	 //Catch:{ SQLiteException -> 0x0127 }
		r3 = (com.google.analytics.tracking.android.Hit) r3;	 //Catch:{ SQLiteException -> 0x0127 }
		r7 = r3.getHitId();	 //Catch:{ SQLiteException -> 0x0127 }
		r3 = java.lang.Long.valueOf(r7);	 //Catch:{ SQLiteException -> 0x0127 }
		r5[r6] = r3;	 //Catch:{ SQLiteException -> 0x0127 }
		r3 = java.lang.String.format(r4, r5);	 //Catch:{ SQLiteException -> 0x0127 }
		com.google.analytics.tracking.android.Log.w(r3);	 //Catch:{ SQLiteException -> 0x0127 }
		goto L_0x00cb;
	L_0x0127:
		r15_e = move-exception;
		r3 = new java.lang.StringBuilder;	 //Catch:{ all -> 0x0178 }
		r3.<init>();	 //Catch:{ all -> 0x0178 }
		r4 = "Error in peekHits fetching hitString: ";
		r3 = r3.append(r4);	 //Catch:{ all -> 0x0178 }
		r4 = r15_e.getMessage();	 //Catch:{ all -> 0x0178 }
		r3 = r3.append(r4);	 //Catch:{ all -> 0x0178 }
		r3 = r3.toString();	 //Catch:{ all -> 0x0178 }
		com.google.analytics.tracking.android.Log.w(r3);	 //Catch:{ all -> 0x0178 }
		r20 = new java.util.ArrayList;	 //Catch:{ all -> 0x0178 }
		r20.<init>();	 //Catch:{ all -> 0x0178 }
		r16 = 0;
		r19 = r18_hits.iterator();	 //Catch:{ all -> 0x0178 }
	L_0x014d:
		r3 = r19_i$.hasNext();	 //Catch:{ all -> 0x0178 }
		if (r3 == 0) goto L_0x0165;
	L_0x0153:
		r2_hit = r19_i$.next();	 //Catch:{ all -> 0x0178 }
		r2_hit = (com.google.analytics.tracking.android.Hit) r2_hit;	 //Catch:{ all -> 0x0178 }
		r3 = r2_hit.getHitParams();	 //Catch:{ all -> 0x0178 }
		r3 = android.text.TextUtils.isEmpty(r3);	 //Catch:{ all -> 0x0178 }
		if (r3 == 0) goto L_0x0172;
	L_0x0163:
		if (r16_foundOneBadHit == 0) goto L_0x0170;
	L_0x0165:
		if (r13_cursor == 0) goto L_0x016a;
	L_0x0167:
		r13_cursor.close();
	L_0x016a:
		r17_hits = r18_hits;
		r18_hits = r20_partialHits;
		goto L_0x0011;
	L_0x0170:
		r16_foundOneBadHit = 1;
	L_0x0172:
		r0 = r20_partialHits;
		r0.add(r2_hit);	 //Catch:{ all -> 0x0178 }
		goto L_0x014d;
	L_0x0178:
		r3 = move-exception;
		if (r13_cursor == 0) goto L_0x017e;
	L_0x017b:
		r13_cursor.close();
	L_0x017e:
		throw r3;
	L_0x017f:
		r3 = move-exception;
		r17_hits = r18_hits;
		goto L_0x0101;
	L_0x0184:
		r15 = move-exception;
		r17_hits = r18_hits;
		goto L_0x00dd;
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
				String[] r3_String_A = new String[2];
				r3_String_A[0] = HIT_ID;
				r3_String_A[1] = HIT_TIME;
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
						hits_2.add(new Hit(null, cursor.getLong(0), cursor.getLong(1)));
					} while (cursor.moveToNext());
					if (cursor == null) {
						cursor.close();
					}
					count = 0;
					try {
						r4_String = HITS_TABLE;
						r5_String_A = new String[3];
						r5_String_A[0] = HIT_ID;
						r5_String_A[1] = HIT_STRING;
						r5_String_A[2] = HIT_URL;
						r10_Object_A = new Object[1];
						r10_Object_A[0] = HIT_ID;
						cursor = db.query(r4_String, r5_String_A, null, null, null, null, String.format("%s ASC", r10_Object_A), Integer.toString(maxHits));
						if (cursor.moveToFirst()) {
							do {
								if (((SQLiteCursor) cursor).getWindow().getNumRows() > 0) {
									((Hit) hits_2.get(count)).setHitString(cursor.getString(1));
									((Hit) hits_2.get(count)).setHitUrl(cursor.getString(WireFormat.WIRETYPE_LENGTH_DELIMITED));
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
						Log.w("Error in peekHits fetching hitString: " + e.getMessage());
						List<Hit> partialHits = new ArrayList();
						boolean foundOneBadHit = false;
						Iterator i$ = hits_2.iterator();
						while (i$.hasNext()) {
							Hit hit = i$.next();
							if (TextUtils.isEmpty(hit.getHitParams())) {
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
					r5_String_A = new String[3];
					r5_String_A[0] = HIT_ID;
					r5_String_A[1] = HIT_STRING;
					r5_String_A[2] = HIT_URL;
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
								((Hit) hits_2.get(count)).setHitString(cursor.getString(1));
								((Hit) hits_2.get(count)).setHitUrl(cursor.getString(WireFormat.WIRETYPE_LENGTH_DELIMITED));
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
					r5_String_A = new String[3];
					r5_String_A[0] = HIT_ID;
					r5_String_A[1] = HIT_STRING;
					r5_String_A[2] = HIT_URL;
					r10_Object_A = new Object[1];
					r10_Object_A[0] = HIT_ID;
					cursor = db.query(r4_String, r5_String_A, null, null, null, null, String.format("%s ASC", r10_Object_A), Integer.toString(maxHits));
					if (cursor.moveToFirst()) {
						do {
							if (((SQLiteCursor) cursor).getWindow().getNumRows() > 0) {
								((Hit) hits_2.get(count)).setHitString(cursor.getString(1));
								((Hit) hits_2.get(count)).setHitUrl(cursor.getString(WireFormat.WIRETYPE_LENGTH_DELIMITED));
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

	public void putHit(Map<String, String> wireFormatParams, long hitTimeInMilliseconds, String path, Collection<Command> commands) {
		deleteStaleHits();
		removeOldHitIfFull();
		fillVersionParameter(wireFormatParams, commands);
		writeHitToDatabase(wireFormatParams, hitTimeInMilliseconds, path);
	}

	@VisibleForTesting
	public void setClock(Clock clock) {
		this.mClock = clock;
	}

	public void setDispatch(boolean dispatch) {
		this.mDispatcher = (dispatch) ? new SimpleNetworkDispatcher(new DefaultHttpClient(), this.mContext) : new NoopDispatcher();
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
