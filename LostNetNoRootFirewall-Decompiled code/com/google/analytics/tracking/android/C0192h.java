package com.google.analytics.tracking.android;

class C0192h extends Thread {
    final /* synthetic */ C0191g f853a;

    C0192h(C0191g c0191g, String str) {
        this.f853a = c0191g;
        super(str);
    }

    public void run() {
        synchronized (this.f853a.f852f) {
            this.f853a.f850d = this.f853a.m1203d();
            this.f853a.f851e = true;
            this.f853a.f852f.notifyAll();
        }
    }
}
