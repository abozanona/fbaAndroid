package com.google.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import com.google.android.gms.common.util.VisibleForTesting;

class ServiceManagerImpl extends ServiceManager {
	private static final int MSG_KEY = 1;
	private static final Object MSG_OBJECT;
	private static ServiceManagerImpl instance;
	private boolean connected;
	private Context ctx;
	private int dispatchPeriodInSeconds;
	private Handler handler;
	private boolean listenForNetwork;
	private HitStoreStateListener listener;
	private NetworkReceiver networkReceiver;
	private boolean pendingDispatch;
	private boolean readyToDispatch;
	private HitStore store;
	private boolean storeIsEmpty;
	private volatile HitSendingThread thread;


	static {
		MSG_OBJECT = new Object();
	}

	private ServiceManagerImpl() {
		this.dispatchPeriodInSeconds = 1800;
		this.pendingDispatch = true;
		this.readyToDispatch = false;
		this.connected = true;
		this.listenForNetwork = true;
		this.listener = new HitStoreStateListener() {
			public void reportStoreIsEmpty(boolean isEmpty) {
				updatePowerSaveMode(isEmpty, connected);
			}
		};
		this.storeIsEmpty = false;
	}

	@VisibleForTesting
	ServiceManagerImpl(Context ctx, HitSendingThread thread, HitStore store, boolean listenForNetwork) {
		this.dispatchPeriodInSeconds = 1800;
		this.pendingDispatch = true;
		this.readyToDispatch = false;
		this.connected = true;
		this.listenForNetwork = true;
		this.listener = new HitStoreStateListener() {
			public void reportStoreIsEmpty(boolean isEmpty) {
				updatePowerSaveMode(isEmpty, connected);
			}
		};
		this.storeIsEmpty = false;
		this.store = store;
		this.thread = thread;
		this.listenForNetwork = listenForNetwork;
		initialize(ctx, thread);
	}

	@VisibleForTesting
	static void clearInstance() {
		instance = null;
	}

	public static ServiceManagerImpl getInstance() {
		if (instance == null) {
			instance = new ServiceManagerImpl();
		}
		return instance;
	}

	private void initializeHandler() {
		this.handler = new Handler(this.ctx.getMainLooper(), new Callback() {
			public boolean handleMessage(Message msg) {
				if (1 != msg.what || !MSG_OBJECT.equals(msg.obj)) {
					return true;
				} else {
					dispatch();
					if (dispatchPeriodInSeconds <= 0 || storeIsEmpty) {
						return true;
					} else {
						handler.sendMessageDelayed(handler.obtainMessage(MSG_KEY, MSG_OBJECT), (long) (dispatchPeriodInSeconds * 1000));
						return true;
					}
				}
			}
		});
		if (this.dispatchPeriodInSeconds > 0) {
			this.handler.sendMessageDelayed(this.handler.obtainMessage(MSG_KEY, MSG_OBJECT), (long) (this.dispatchPeriodInSeconds * 1000));
		}
	}

	private void initializeNetworkReceiver() {
		this.networkReceiver = new NetworkReceiver(this);
		this.networkReceiver.register(this.ctx);
	}

	public synchronized void dispatch() {
		synchronized(this) {
			if (!(this.readyToDispatch)) {
				Log.v("Dispatch call queued. Dispatch will run once initialization is complete.");
				this.pendingDispatch = true;
			} else {
				this.thread.queueToThread(new Runnable() {
			public void run() {
				store.dispatch();
			}
		});
			}
		}
	}

	@VisibleForTesting
	HitStoreStateListener getListener() {
		return this.listener;
	}

	synchronized HitStore getStore() {
		HitStore r0_HitStore;
		synchronized(this) {
			if (this.store == null) {
				if (this.ctx == null) {
					throw new IllegalStateException("Cant get a store unless we have a context");
				} else {
					this.store = new PersistentHitStore(this.listener, this.ctx);
				}
			}
			if (this.handler == null) {
				initializeHandler();
			}
			this.readyToDispatch = true;
			if (this.pendingDispatch) {
				dispatch();
				this.pendingDispatch = false;
			}
			if (this.networkReceiver != null || !(this.listenForNetwork)) {
				r0_HitStore = this.store;
			} else {
				initializeNetworkReceiver();
				r0_HitStore = this.store;
			}
		}
		return r0_HitStore;
	}

	synchronized void initialize(Context ctx, HitSendingThread thread) {
		synchronized(this) {
			if (this.ctx != null) {
			} else {
				this.ctx = ctx.getApplicationContext();
				if (this.thread == null) {
					this.thread = thread;
				}
			}
		}
	}

	synchronized void onRadioPowered() {
		synchronized(this) {
			if (this.storeIsEmpty || !(this.connected) || this.dispatchPeriodInSeconds <= 0) {
			} else {
				this.handler.removeMessages(MSG_KEY, MSG_OBJECT);
				this.handler.sendMessage(this.handler.obtainMessage(MSG_KEY, MSG_OBJECT));
			}
		}
	}

	public synchronized void setDispatchPeriod(int dispatchPeriodInSeconds) {
		synchronized(this) {
			if (this.handler == null) {
				Log.v("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
				this.dispatchPeriodInSeconds = dispatchPeriodInSeconds;
			} else if (this.storeIsEmpty || !(this.connected) || this.dispatchPeriodInSeconds <= 0) {
				this.dispatchPeriodInSeconds = dispatchPeriodInSeconds;
				if (dispatchPeriodInSeconds <= 0 || this.storeIsEmpty || !(this.connected)) {
				} else {
					this.handler.sendMessageDelayed(this.handler.obtainMessage(MSG_KEY, MSG_OBJECT), (long) (dispatchPeriodInSeconds * 1000));
				}
			} else {
				this.handler.removeMessages(MSG_KEY, MSG_OBJECT);
				this.dispatchPeriodInSeconds = dispatchPeriodInSeconds;
				if (dispatchPeriodInSeconds <= 0 || this.storeIsEmpty || !(this.connected)) {
				} else {
					this.handler.sendMessageDelayed(this.handler.obtainMessage(MSG_KEY, MSG_OBJECT), (long) (dispatchPeriodInSeconds * 1000));
				}
			}
		}
	}

	synchronized void updateConnectivityStatus(boolean connected) {
		synchronized(this) {
			updatePowerSaveMode(this.storeIsEmpty, connected);
		}
	}

	/* JADX WARNING: inconsistent code */
	/*
	@com.google.android.gms.common.util.VisibleForTesting
	synchronized void updatePowerSaveMode(boolean r5_storeIsEmpty, boolean r6_connected) {
		r4_this = this;
		monitor-enter(r4);
		r0 = r4.storeIsEmpty;	 //Catch:{ all -> 0x0057 }
		if (r0 != r5_storeIsEmpty) goto L_0x000b;
	L_0x0005:
		r0 = r4.connected;	 //Catch:{ all -> 0x0057 }
		if (r0 != r6_connected) goto L_0x000b;
	L_0x0009:
		monitor-exit(r4);
		return;
	L_0x000b:
		if (r5_storeIsEmpty != 0) goto L_0x000f;
	L_0x000d:
		if (r6_connected != 0) goto L_0x001b;
	L_0x000f:
		r0 = r4.dispatchPeriodInSeconds;	 //Catch:{ all -> 0x0057 }
		if (r0 <= 0) goto L_0x001b;
	L_0x0013:
		r0 = r4.handler;	 //Catch:{ all -> 0x0057 }
		r1 = 1;
		r2 = MSG_OBJECT;	 //Catch:{ all -> 0x0057 }
		r0.removeMessages(r1, r2);	 //Catch:{ all -> 0x0057 }
	L_0x001b:
		if (r5_storeIsEmpty != 0) goto L_0x0036;
	L_0x001d:
		if (r6_connected == 0) goto L_0x0036;
	L_0x001f:
		r0 = r4.dispatchPeriodInSeconds;	 //Catch:{ all -> 0x0057 }
		if (r0 <= 0) goto L_0x0036;
	L_0x0023:
		r0 = r4.handler;	 //Catch:{ all -> 0x0057 }
		r1 = r4.handler;	 //Catch:{ all -> 0x0057 }
		r2 = 1;
		r3 = MSG_OBJECT;	 //Catch:{ all -> 0x0057 }
		r1 = r1.obtainMessage(r2, r3);	 //Catch:{ all -> 0x0057 }
		r2 = r4.dispatchPeriodInSeconds;	 //Catch:{ all -> 0x0057 }
		r2 *= 1000;
		r2 = (long) r2;	 //Catch:{ all -> 0x0057 }
		r0.sendMessageDelayed(r1, r2);	 //Catch:{ all -> 0x0057 }
	L_0x0036:
		r0 = new java.lang.StringBuilder;	 //Catch:{ all -> 0x0057 }
		r0.<init>();	 //Catch:{ all -> 0x0057 }
		r1 = "PowerSaveMode ";
		r1 = r0.append(r1);	 //Catch:{ all -> 0x0057 }
		if (r5_storeIsEmpty != 0) goto L_0x0045;
	L_0x0043:
		if (r6_connected != 0) goto L_0x005a;
	L_0x0045:
		r0 = "initiated.";
	L_0x0047:
		r0 = r1.append(r0);	 //Catch:{ all -> 0x0057 }
		r0 = r0.toString();	 //Catch:{ all -> 0x0057 }
		com.google.tagmanager.Log.v(r0);	 //Catch:{ all -> 0x0057 }
		r4.storeIsEmpty = r5_storeIsEmpty;	 //Catch:{ all -> 0x0057 }
		r4.connected = r6_connected;	 //Catch:{ all -> 0x0057 }
		goto L_0x0009;
	L_0x0057:
		r0 = move-exception;
		monitor-exit(r4);
		throw r0;
	L_0x005a:
		r0 = "terminated.";
		goto L_0x0047;
	}
	*/
	@VisibleForTesting
	synchronized void updatePowerSaveMode(boolean storeIsEmpty, boolean connected) {
		synchronized(this) {
			if (this.storeIsEmpty != storeIsEmpty || this.connected != connected) {
				if (this.dispatchPeriodInSeconds > 0) {
					this.handler.removeMessages(MSG_KEY, MSG_OBJECT);
				}
				StringBuilder r1_StringBuilder;
				String r0_String;
				if (storeIsEmpty || !connected || this.dispatchPeriodInSeconds <= 0) {
					r1_StringBuilder = new StringBuilder().append("PowerSaveMode ");
					r0_String = (storeIsEmpty || !connected) ? "initiated." : "terminated.";
					Log.v(r1_StringBuilder.append(r0_String).toString());
					this.storeIsEmpty = storeIsEmpty;
					this.connected = connected;
				} else {
					this.handler.sendMessageDelayed(this.handler.obtainMessage(MSG_KEY, MSG_OBJECT), (long) (this.dispatchPeriodInSeconds * 1000));
					r1_StringBuilder = new StringBuilder().append("PowerSaveMode ");
					if (storeIsEmpty || !connected) {
					}
					Log.v(r1_StringBuilder.append(r0_String).toString());
					this.storeIsEmpty = storeIsEmpty;
					this.connected = connected;
				}
			}
		}
	}
}
