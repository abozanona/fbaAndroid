package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.IAnalyticsService;
import java.util.List;
import java.util.Map;

class AnalyticsGmsCoreClient implements C0182a {
    private ServiceConnection f789a;
    private OnConnectedListener f790b;
    private OnConnectionFailedListener f791c;
    private Context f792d;
    private IAnalyticsService f793e;

    public interface OnConnectedListener {
        void onConnected();

        void onDisconnected();
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(int i, Intent intent);
    }

    public AnalyticsGmsCoreClient(Context context, OnConnectedListener onConnectedListener, OnConnectionFailedListener onConnectionFailedListener) {
        this.f792d = context;
        if (onConnectedListener == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.f790b = onConnectedListener;
        if (onConnectionFailedListener == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.f791c = onConnectionFailedListener;
    }

    private IAnalyticsService m1061f() {
        m1068d();
        return this.f793e;
    }

    private void m1062g() {
        m1063h();
    }

    private void m1063h() {
        this.f790b.onConnected();
    }

    public void mo534a() {
        try {
            m1061f().clearHits();
        } catch (RemoteException e) {
            Log.m1076e("clear hits failed: " + e);
        }
    }

    public void mo535a(Map map, long j, String str, List list) {
        try {
            m1061f().sendHit(map, j, str, list);
        } catch (RemoteException e) {
            Log.m1076e("sendHit failed: " + e);
        }
    }

    public void mo536b() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra("app_package_name", this.f792d.getPackageName());
        if (this.f789a != null) {
            Log.m1076e("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.f789a = new C0188b(this);
        boolean bindService = this.f792d.bindService(intent, this.f789a, 129);
        Log.m1078v("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.f789a = null;
            this.f791c.onConnectionFailed(1, null);
        }
    }

    public void mo537c() {
        this.f793e = null;
        if (this.f789a != null) {
            try {
                this.f792d.unbindService(this.f789a);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.f789a = null;
            this.f790b.onDisconnected();
        }
    }

    protected void m1068d() {
        if (!m1069e()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public boolean m1069e() {
        return this.f793e != null;
    }
}
