package com.google.analytics.tracking.android;

import android.os.Handler.Callback;
import android.os.Message;

class C0199r implements Callback {
    final /* synthetic */ GAServiceManager f860a;

    C0199r(GAServiceManager gAServiceManager) {
        this.f860a = gAServiceManager;
    }

    public boolean handleMessage(Message message) {
        if (1 == message.what && GAServiceManager.MSG_OBJECT.equals(message.obj)) {
            GAUsage.m1070a().m1072a(true);
            this.f860a.dispatchLocalHits();
            GAUsage.m1070a().m1072a(false);
            if (this.f860a.dispatchPeriodInSeconds > 0 && !this.f860a.storeIsEmpty) {
                this.f860a.handler.sendMessageDelayed(this.f860a.handler.obtainMessage(1, GAServiceManager.MSG_OBJECT), (long) (this.f860a.dispatchPeriodInSeconds * 1000));
            }
        }
        return true;
    }
}
