package com.google.analytics.tracking.android;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class ClientIdDefaultProvider implements DefaultProvider {
	private static ClientIdDefaultProvider sInstance;
	private static final Object sInstanceLock;
	private String mClientId;
	private boolean mClientIdLoaded;
	private final Object mClientIdLock;
	private final Context mContext;

	class AnonymousClass_1 extends Thread {
		AnonymousClass_1(String x0) {
			super(x0);
		}

		public void run() {
			Object r1_Object = mClientIdLock;
			synchronized(r1_Object) {
				mClientId = initializeClientId();
				mClientIdLoaded = true;
				mClientIdLock.notifyAll();
			}
		}
	}


	static {
		sInstanceLock = new Object();
	}

	protected ClientIdDefaultProvider(Context c) {
		this.mClientIdLoaded = false;
		this.mClientIdLock = new Object();
		this.mContext = c;
		asyncInitializeClientId();
	}

	private void asyncInitializeClientId() {
		new AnonymousClass_1("client_id_fetcher").start();
	}

	private String blockingGetClientId() {
		if (!(this.mClientIdLoaded)) {
			Object r2_Object = this.mClientIdLock;
			synchronized(r2_Object) {
				if (!(this.mClientIdLoaded)) {
					Log.v("Waiting for clientId to load");
					do {
						try {
							this.mClientIdLock.wait();
						} catch (InterruptedException e) {
							InterruptedException e_2 = e;
							Log.e("Exception while waiting for clientId: " + e_2);
						}
					} while (!(this.mClientIdLoaded));
				}
			}
		}
		Log.v("Loaded clientId");
		return this.mClientId;
	}

	@VisibleForTesting
	static void dropInstance() {
		Object r1_Object = sInstanceLock;
		synchronized(r1_Object) {
			sInstance = null;
		}
	}

	public static ClientIdDefaultProvider getProvider() {
		ClientIdDefaultProvider r0_ClientIdDefaultProvider;
		Object r1_Object = sInstanceLock;
		synchronized(r1_Object) {
			r0_ClientIdDefaultProvider = sInstance;
		}
		return r0_ClientIdDefaultProvider;
	}

	public static void initializeProvider(Context c) {
		Object r1_Object = sInstanceLock;
		synchronized(r1_Object) {
			if (sInstance == null) {
				sInstance = new ClientIdDefaultProvider(c);
			}
		}
	}

	private boolean storeClientId(String clientId) {
		try {
			Log.v("Storing clientId.");
			FileOutputStream fos = this.mContext.openFileOutput("gaClientId", 0);
			fos.write(clientId.getBytes());
			fos.close();
			return true;
		} catch (FileNotFoundException e) {
			Log.e("Error creating clientId file.");
			return false;
		} catch (IOException e_2) {
			Log.e("Error writing to clientId file.");
			return false;
		}
	}

	protected String generateClientId() {
		String result = UUID.randomUUID().toString().toLowerCase();
		if (!storeClientId(result)) {
			return "0";
		}
		return result;
	}

	public String getValue(String field) {
		return (Fields.CLIENT_ID.equals(field)) ? blockingGetClientId() : null;
	}

	/* JADX WARNING: inconsistent code */
	/*
	@com.google.android.gms.common.util.VisibleForTesting
	java.lang.String initializeClientId() {
		r8_this = this;
		r4 = 0;
		r6 = r8.mContext;	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
		r7 = "gaClientId";
		r2 = r6.openFileInput(r7);	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
		r6 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
		r0 = new byte[r6];	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
		r6 = 0;
		r7 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
		r3_readLen = r2_input.read(r0_bytes, r6, r7);	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
		r6 = r2_input.available();	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
		if (r6 <= 0) goto L_0x0030;
	L_0x001a:
		r6 = "clientId file seems corrupted, deleting it.";
		com.google.analytics.tracking.android.Log.e(r6);	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
		r2_input.close();	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
		r6 = r8.mContext;	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
		r7 = "gaClientId";
		r6.deleteFile(r7);	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
	L_0x0029:
		if (r4_rslt != 0) goto L_0x002f;
	L_0x002b:
		r4_rslt = r8.generateClientId();
	L_0x002f:
		return r4_rslt;
	L_0x0030:
		if (r3_readLen > 0) goto L_0x0044;
	L_0x0032:
		r6 = "clientId file seems empty, deleting it.";
		com.google.analytics.tracking.android.Log.e(r6);	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
		r2_input.close();	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
		r6 = r8.mContext;	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
		r7 = "gaClientId";
		r6.deleteFile(r7);	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
		goto L_0x0029;
	L_0x0042:
		r6 = move-exception;
		goto L_0x0029;
	L_0x0044:
		r5 = new java.lang.String;	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
		r6 = 0;
		r5.<init>(r0_bytes, r6, r3_readLen);	 //Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x004f }
		r2_input.close();	 //Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005d }
		r4_rslt = r5_rslt;
		goto L_0x0029;
	L_0x004f:
		r1 = move-exception;
	L_0x0050:
		r6 = "Error reading clientId file, deleting it.";
		com.google.analytics.tracking.android.Log.e(r6);
		r6 = r8.mContext;
		r7 = "gaClientId";
		r6.deleteFile(r7);
		goto L_0x0029;
	L_0x005d:
		r1_e = move-exception;
		r4_rslt = r5_rslt;
		goto L_0x0050;
	L_0x0060:
		r6 = move-exception;
		r4_rslt = r5_rslt;
		goto L_0x0029;
	}
	*/
	@VisibleForTesting
	String initializeClientId() {
		FileInputStream input;
		byte[] bytes;
		int readLen;
		String rslt = null;
		try {
			input = this.mContext.openFileInput("gaClientId");
			bytes = new byte[128];
			readLen = input.read(bytes, 0, 128);
			if (input.available() > 0) {
				Log.e("clientId file seems corrupted, deleting it.");
				input.close();
				this.mContext.deleteFile("gaClientId");
				if (rslt == null) {
				}
			} else if (readLen <= 0) {
				Log.e("clientId file seems empty, deleting it.");
				input.close();
				this.mContext.deleteFile("gaClientId");
				return (rslt == null) ? rslt : generateClientId();
			} else {
				String rslt_2 = new String(bytes, 0, readLen);
				try {
					input.close();
					rslt = rslt_2;
				} catch (FileNotFoundException e) {
					rslt = rslt_2;
				} catch (IOException e_2) {
					rslt = rslt_2;
				}
				if (rslt == null) {
				}
			}
		} catch (FileNotFoundException e_3) {
		} catch (IOException e_4) {
		}
	}

	public boolean providesField(String field) {
		return Fields.CLIENT_ID.equals(field);
	}
}
