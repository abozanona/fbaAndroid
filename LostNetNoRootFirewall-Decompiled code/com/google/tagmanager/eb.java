package com.google.tagmanager;

import android.os.Handler.Callback;
import android.os.Message;

class eb implements Callback {
    final /* synthetic */ dz f1141a;

    eb(dz dzVar) {
        this.f1141a = dzVar;
    }

    public boolean handleMessage(Message message) {
        if (1 == message.what && dz.f1124a.equals(message.obj)) {
            this.f1141a.m1639d();
            if (this.f1141a.f1129e > 0 && !this.f1141a.f1137m) {
                this.f1141a.f1135k.sendMessageDelayed(this.f1141a.f1135k.obtainMessage(1, dz.f1124a), (long) (this.f1141a.f1129e * 1000));
            }
        }
        return true;
    }
}
