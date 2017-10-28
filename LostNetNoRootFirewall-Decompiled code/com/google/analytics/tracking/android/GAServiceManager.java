package com.google.analytics.tracking.android;

import android.content.Context;
import android.os.Handler;
import com.google.analytics.tracking.android.GAUsage.Field;
import com.google.android.gms.common.util.VisibleForTesting;

public class GAServiceManager extends ServiceManager {
    private static final int MSG_KEY = 1;
    private static final Object MSG_OBJECT = new Object();
    private static GAServiceManager instance;
    private boolean connected = true;
    private Context ctx;
    private int dispatchPeriodInSeconds = 1800;
    private Handler handler;
    private boolean listenForNetwork = true;
    private C0189d listener = new C0198q(this);
    private C0197p networkReceiver;
    private boolean pendingDispatch = true;
    private boolean pendingForceLocalDispatch;
    private String pendingHostOverride;
    private C0184c store;
    private boolean storeIsEmpty = false;
    private volatile C0183e thread;

    private GAServiceManager() {
    }

    @VisibleForTesting
    GAServiceManager(Context context, C0183e c0183e, C0184c c0184c, boolean z) {
        this.store = c0184c;
        this.thread = c0183e;
        this.listenForNetwork = z;
        initialize(context, c0183e);
    }

    @VisibleForTesting
    static void clearInstance() {
        instance = null;
    }

    public static GAServiceManager getInstance() {
        if (instance == null) {
            instance = new GAServiceManager();
        }
        return instance;
    }

    private void initializeHandler() {
        this.handler = new Handler(this.ctx.getMainLooper(), new C0199r(this));
        if (this.dispatchPeriodInSeconds > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, MSG_OBJECT), (long) (this.dispatchPeriodInSeconds * 1000));
        }
    }

    private void initializeNetworkReceiver() {
        this.networkReceiver = new C0197p(this);
        this.networkReceiver.m1209a(this.ctx);
    }

    @Deprecated
    public synchronized void dispatchLocalHits() {
        if (this.thread == null) {
            Log.m1078v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.pendingDispatch = true;
        } else {
            GAUsage.m1070a().m1071a(Field.DISPATCH);
            this.thread.mo546a();
        }
    }

    @VisibleForTesting
    C0189d getListener() {
        return this.listener;
    }

    synchronized C0184c getStore() {
        if (this.store == null) {
            if (this.ctx == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.store = new ak(this.listener, this.ctx);
            if (this.pendingHostOverride != null) {
                this.store.mo560b().mo564a(this.pendingHostOverride);
                this.pendingHostOverride = null;
            }
        }
        if (this.handler == null) {
            initializeHandler();
        }
        if (this.networkReceiver == null && this.listenForNetwork) {
            initializeNetworkReceiver();
        }
        return this.store;
    }

    synchronized void initialize(Context context, C0183e c0183e) {
        if (this.ctx == null) {
            this.ctx = context.getApplicationContext();
            if (this.thread == null) {
                this.thread = c0183e;
                if (this.pendingDispatch) {
                    dispatchLocalHits();
                    this.pendingDispatch = false;
                }
                if (this.pendingForceLocalDispatch) {
                    setForceLocalDispatch();
                    this.pendingForceLocalDispatch = false;
                }
            }
        }
    }

    synchronized void onRadioPowered() {
        if (!this.storeIsEmpty && this.connected && this.dispatchPeriodInSeconds > 0) {
            this.handler.removeMessages(1, MSG_OBJECT);
            this.handler.sendMessage(this.handler.obtainMessage(1, MSG_OBJECT));
        }
    }

    @VisibleForTesting
    synchronized void overrideHostUrl(String str) {
        if (this.store == null) {
            this.pendingHostOverride = str;
        } else {
            this.store.mo560b().mo564a(str);
        }
    }

    @Deprecated
    public void setForceLocalDispatch() {
        if (this.thread == null) {
            Log.m1078v("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.pendingForceLocalDispatch = true;
            return;
        }
        GAUsage.m1070a().m1071a(Field.SET_FORCE_LOCAL_DISPATCH);
        this.thread.mo549c();
    }

    @Deprecated
    public synchronized void setLocalDispatchPeriod(int i) {
        if (this.handler == null) {
            Log.m1078v("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
            this.dispatchPeriodInSeconds = i;
        } else {
            GAUsage.m1070a().m1071a(Field.SET_DISPATCH_PERIOD);
            if (!this.storeIsEmpty && this.connected && this.dispatchPeriodInSeconds > 0) {
                this.handler.removeMessages(1, MSG_OBJECT);
            }
            this.dispatchPeriodInSeconds = i;
            if (i > 0 && !this.storeIsEmpty && this.connected) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, MSG_OBJECT), (long) (i * 1000));
            }
        }
    }

    synchronized void updateConnectivityStatus(boolean z) {
        updatePowerSaveMode(this.storeIsEmpty, z);
    }

    @VisibleForTesting
    synchronized void updatePowerSaveMode(boolean z, boolean z2) {
        if (!(this.storeIsEmpty == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.dispatchPeriodInSeconds > 0) {
                    this.handler.removeMessages(1, MSG_OBJECT);
                }
            }
            if (!z && z2 && this.dispatchPeriodInSeconds > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, MSG_OBJECT), (long) (this.dispatchPeriodInSeconds * 1000));
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            Log.m1078v(append.append(str).toString());
            this.storeIsEmpty = z;
            this.connected = z2;
        }
    }
}
