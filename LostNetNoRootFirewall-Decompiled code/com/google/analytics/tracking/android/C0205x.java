package com.google.analytics.tracking.android;

import java.util.TimerTask;

class C0205x extends TimerTask {
    final /* synthetic */ C0200s f891a;

    private C0205x(C0200s c0200s) {
        this.f891a = c0200s;
    }

    public void run() {
        if (this.f891a.f862b == C0204w.CONNECTED_SERVICE && this.f891a.f869i.isEmpty() && this.f891a.f861a + this.f891a.f879s < this.f891a.f878r.mo561a()) {
            Log.m1078v("Disconnecting due to inactivity");
            this.f891a.m1227j();
            return;
        }
        this.f891a.f873m.schedule(new C0205x(this.f891a), this.f891a.f879s);
    }
}
