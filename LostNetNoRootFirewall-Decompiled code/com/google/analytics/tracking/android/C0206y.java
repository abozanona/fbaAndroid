package com.google.analytics.tracking.android;

import java.util.TimerTask;

class C0206y extends TimerTask {
    final /* synthetic */ C0200s f892a;

    private C0206y(C0200s c0200s) {
        this.f892a = c0200s;
    }

    public void run() {
        if (this.f892a.f862b == C0204w.CONNECTING) {
            this.f892a.m1223h();
        }
    }
}
