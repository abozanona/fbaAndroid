package com.google.tagmanager;

class bc implements Runnable {
    final /* synthetic */ ba f988a;
    final /* synthetic */ long f989b;
    final /* synthetic */ String f990c;
    final /* synthetic */ bb f991d;

    bc(bb bbVar, ba baVar, long j, String str) {
        this.f991d = bbVar;
        this.f988a = baVar;
        this.f989b = j;
        this.f990c = str;
    }

    public void run() {
        if (this.f991d.f986e == null) {
            dz b = dz.m1627b();
            b.m1635a(this.f991d.f987f, this.f988a);
            this.f991d.f986e = b.m1638c();
        }
        this.f991d.f986e.mo651a(this.f989b, this.f990c);
    }
}
