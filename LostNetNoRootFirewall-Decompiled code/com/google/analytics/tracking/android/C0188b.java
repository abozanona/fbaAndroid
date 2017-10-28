package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.IAnalyticsService.Stub;

final class C0188b implements ServiceConnection {
    final /* synthetic */ AnalyticsGmsCoreClient f840a;

    C0188b(AnalyticsGmsCoreClient analyticsGmsCoreClient) {
        this.f840a = analyticsGmsCoreClient;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.m1078v("service connected, binder: " + iBinder);
        try {
            if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(iBinder.getInterfaceDescriptor())) {
                Log.m1078v("bound to service");
                this.f840a.f793e = Stub.asInterface(iBinder);
                this.f840a.m1062g();
                return;
            }
        } catch (RemoteException e) {
        }
        this.f840a.f792d.unbindService(this);
        this.f840a.f789a = null;
        this.f840a.f791c.onConnectionFailed(2, null);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Log.m1078v("service disconnected: " + componentName);
        this.f840a.f789a = null;
        this.f840a.f790b.onDisconnected();
    }
}
