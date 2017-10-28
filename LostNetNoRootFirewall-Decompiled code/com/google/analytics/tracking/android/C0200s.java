package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.Intent;
import com.google.analytics.tracking.android.AnalyticsGmsCoreClient.OnConnectedListener;
import com.google.analytics.tracking.android.AnalyticsGmsCoreClient.OnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;

class C0200s implements OnConnectedListener, OnConnectionFailedListener, ao {
    private volatile long f861a;
    private volatile C0204w f862b;
    private volatile C0182a f863c;
    private C0184c f864d;
    private C0184c f865e;
    private final GoogleAnalytics f866f;
    private final C0183e f867g;
    private final Context f868h;
    private final Queue f869i;
    private volatile int f870j;
    private volatile Timer f871k;
    private volatile Timer f872l;
    private volatile Timer f873m;
    private boolean f874n;
    private boolean f875o;
    private boolean f876p;
    private boolean f877q;
    private C0185i f878r;
    private long f879s;

    C0200s(Context context, C0183e c0183e) {
        this(context, c0183e, null, GoogleAnalytics.getInstance(context));
    }

    @VisibleForTesting
    C0200s(Context context, C0183e c0183e, C0184c c0184c, GoogleAnalytics googleAnalytics) {
        this.f869i = new ConcurrentLinkedQueue();
        this.f879s = 300000;
        this.f865e = c0184c;
        this.f868h = context;
        this.f867g = c0183e;
        this.f866f = googleAnalytics;
        this.f878r = new C0201t(this);
        this.f870j = 0;
        this.f862b = C0204w.DISCONNECTED;
    }

    private Timer m1211a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private void m1217e() {
        this.f871k = m1211a(this.f871k);
        this.f872l = m1211a(this.f872l);
        this.f873m = m1211a(this.f873m);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m1219f() {
        /*
        r7 = this;
        monitor-enter(r7);
        r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0074 }
        r2 = r7.f867g;	 Catch:{ all -> 0x0074 }
        r2 = r2.mo551e();	 Catch:{ all -> 0x0074 }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x0021;
    L_0x0011:
        r1 = r7.f867g;	 Catch:{ all -> 0x0074 }
        r1 = r1.mo550d();	 Catch:{ all -> 0x0074 }
        r2 = new com.google.analytics.tracking.android.u;	 Catch:{ all -> 0x0074 }
        r2.<init>(r7);	 Catch:{ all -> 0x0074 }
        r1.add(r2);	 Catch:{ all -> 0x0074 }
    L_0x001f:
        monitor-exit(r7);
        return;
    L_0x0021:
        r1 = r7.f875o;	 Catch:{ all -> 0x0074 }
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        r7.mo576b();	 Catch:{ all -> 0x0074 }
    L_0x0028:
        r1 = com.google.analytics.tracking.android.C0203v.f882a;	 Catch:{ all -> 0x0074 }
        r2 = r7.f862b;	 Catch:{ all -> 0x0074 }
        r2 = r2.ordinal();	 Catch:{ all -> 0x0074 }
        r1 = r1[r2];	 Catch:{ all -> 0x0074 }
        switch(r1) {
            case 1: goto L_0x0036;
            case 2: goto L_0x007f;
            case 3: goto L_0x0035;
            case 4: goto L_0x0035;
            case 5: goto L_0x0035;
            case 6: goto L_0x00da;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x0074 }
    L_0x0035:
        goto L_0x001f;
    L_0x0036:
        r1 = r7.f869i;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x0077;
    L_0x003e:
        r1 = r7.f869i;	 Catch:{ all -> 0x0074 }
        r1 = r1.poll();	 Catch:{ all -> 0x0074 }
        r0 = r1;
        r0 = (com.google.analytics.tracking.android.C0207z) r0;	 Catch:{ all -> 0x0074 }
        r6 = r0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r1.<init>();	 Catch:{ all -> 0x0074 }
        r2 = "Sending hit to store  ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0074 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0074 }
        r1 = r1.toString();	 Catch:{ all -> 0x0074 }
        com.google.analytics.tracking.android.Log.m1078v(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.f864d;	 Catch:{ all -> 0x0074 }
        r2 = r6.m1235a();	 Catch:{ all -> 0x0074 }
        r3 = r6.m1236b();	 Catch:{ all -> 0x0074 }
        r5 = r6.m1237c();	 Catch:{ all -> 0x0074 }
        r6 = r6.m1238d();	 Catch:{ all -> 0x0074 }
        r1.mo559a(r2, r3, r5, r6);	 Catch:{ all -> 0x0074 }
        goto L_0x0036;
    L_0x0074:
        r1 = move-exception;
        monitor-exit(r7);
        throw r1;
    L_0x0077:
        r1 = r7.f874n;	 Catch:{ all -> 0x0074 }
        if (r1 == 0) goto L_0x001f;
    L_0x007b:
        r7.m1221g();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x007f:
        r1 = r7.f869i;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x00d0;
    L_0x0087:
        r1 = r7.f869i;	 Catch:{ all -> 0x0074 }
        r1 = r1.peek();	 Catch:{ all -> 0x0074 }
        r0 = r1;
        r0 = (com.google.analytics.tracking.android.C0207z) r0;	 Catch:{ all -> 0x0074 }
        r6 = r0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r1.<init>();	 Catch:{ all -> 0x0074 }
        r2 = "Sending hit to service   ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0074 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0074 }
        r1 = r1.toString();	 Catch:{ all -> 0x0074 }
        com.google.analytics.tracking.android.Log.m1078v(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.f866f;	 Catch:{ all -> 0x0074 }
        r1 = r1.isDryRunEnabled();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x00ca;
    L_0x00af:
        r1 = r7.f863c;	 Catch:{ all -> 0x0074 }
        r2 = r6.m1235a();	 Catch:{ all -> 0x0074 }
        r3 = r6.m1236b();	 Catch:{ all -> 0x0074 }
        r5 = r6.m1237c();	 Catch:{ all -> 0x0074 }
        r6 = r6.m1238d();	 Catch:{ all -> 0x0074 }
        r1.mo535a(r2, r3, r5, r6);	 Catch:{ all -> 0x0074 }
    L_0x00c4:
        r1 = r7.f869i;	 Catch:{ all -> 0x0074 }
        r1.poll();	 Catch:{ all -> 0x0074 }
        goto L_0x007f;
    L_0x00ca:
        r1 = "Dry run enabled. Hit not actually sent to service.";
        com.google.analytics.tracking.android.Log.m1078v(r1);	 Catch:{ all -> 0x0074 }
        goto L_0x00c4;
    L_0x00d0:
        r1 = r7.f878r;	 Catch:{ all -> 0x0074 }
        r1 = r1.mo561a();	 Catch:{ all -> 0x0074 }
        r7.f861a = r1;	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x00da:
        r1 = "Need to reconnect";
        com.google.analytics.tracking.android.Log.m1078v(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.f869i;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x001f;
    L_0x00e7:
        r7.m1224i();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.tracking.android.s.f():void");
    }

    private void m1221g() {
        this.f864d.mo557a();
        this.f874n = false;
    }

    private synchronized void m1223h() {
        if (this.f862b != C0204w.CONNECTED_LOCAL) {
            m1217e();
            Log.m1078v("falling back to local store");
            if (this.f865e != null) {
                this.f864d = this.f865e;
            } else {
                GAServiceManager instance = GAServiceManager.getInstance();
                instance.initialize(this.f868h, this.f867g);
                this.f864d = instance.getStore();
            }
            this.f862b = C0204w.CONNECTED_LOCAL;
            m1219f();
        }
    }

    private synchronized void m1224i() {
        if (this.f877q || this.f863c == null || this.f862b == C0204w.CONNECTED_LOCAL) {
            Log.m1079w("client not initialized.");
            m1223h();
        } else {
            try {
                this.f870j++;
                m1211a(this.f872l);
                this.f862b = C0204w.CONNECTING;
                this.f872l = new Timer("Failed Connect");
                this.f872l.schedule(new C0206y(), 3000);
                Log.m1078v("connecting to Analytics service");
                this.f863c.mo536b();
            } catch (SecurityException e) {
                Log.m1079w("security exception on connectToService");
                m1223h();
            }
        }
    }

    private synchronized void m1227j() {
        if (this.f863c != null && this.f862b == C0204w.CONNECTED_SERVICE) {
            this.f862b = C0204w.PENDING_DISCONNECT;
            this.f863c.mo537c();
        }
    }

    private void m1228k() {
        this.f871k = m1211a(this.f871k);
        this.f871k = new Timer("Service Reconnect");
        this.f871k.schedule(new aa(), 5000);
    }

    public void mo574a() {
        switch (C0203v.f882a[this.f862b.ordinal()]) {
            case 1:
                m1221g();
                return;
            case 2:
                return;
            default:
                this.f874n = true;
                return;
        }
    }

    public void mo575a(Map map, long j, String str, List list) {
        Log.m1078v("putHit called");
        this.f869i.add(new C0207z(map, j, str, list));
        m1219f();
    }

    public void mo576b() {
        Log.m1078v("clearHits called");
        this.f869i.clear();
        switch (C0203v.f882a[this.f862b.ordinal()]) {
            case 1:
                this.f864d.mo558a(0);
                this.f875o = false;
                return;
            case 2:
                this.f863c.mo534a();
                this.f875o = false;
                return;
            default:
                this.f875o = true;
                return;
        }
    }

    public synchronized void mo577c() {
        if (!this.f877q) {
            Log.m1078v("setForceLocalDispatch called.");
            this.f877q = true;
            switch (C0203v.f882a[this.f862b.ordinal()]) {
                case 1:
                case 4:
                case 5:
                case 6:
                    break;
                case 2:
                    m1227j();
                    break;
                case 3:
                    this.f876p = true;
                    break;
                default:
                    break;
            }
        }
    }

    public void mo578d() {
        if (this.f863c == null) {
            this.f863c = new AnalyticsGmsCoreClient(this.f868h, this, this);
            m1224i();
        }
    }

    public synchronized void onConnected() {
        this.f872l = m1211a(this.f872l);
        this.f870j = 0;
        Log.m1078v("Connected to service");
        this.f862b = C0204w.CONNECTED_SERVICE;
        if (this.f876p) {
            m1227j();
            this.f876p = false;
        } else {
            m1219f();
            this.f873m = m1211a(this.f873m);
            this.f873m = new Timer("disconnect check");
            this.f873m.schedule(new C0205x(), this.f879s);
        }
    }

    public synchronized void onConnectionFailed(int i, Intent intent) {
        this.f862b = C0204w.PENDING_CONNECTION;
        if (this.f870j < 2) {
            Log.m1079w("Service unavailable (code=" + i + "), will retry.");
            m1228k();
        } else {
            Log.m1079w("Service unavailable (code=" + i + "), using local store.");
            m1223h();
        }
    }

    public synchronized void onDisconnected() {
        if (this.f862b == C0204w.PENDING_DISCONNECT) {
            Log.m1078v("Disconnected from service");
            m1217e();
            this.f862b = C0204w.DISCONNECTED;
        } else {
            Log.m1078v("Unexpected disconnect.");
            this.f862b = C0204w.PENDING_CONNECTION;
            if (this.f870j < 2) {
                m1228k();
            } else {
                m1223h();
            }
        }
    }
}
