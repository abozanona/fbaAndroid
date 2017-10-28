package com.lostnet.fw;

import com.lostnet.fw.p009d.C0315l;

class C0333p implements Runnable {
    final /* synthetic */ FirewallVpnService f1445a;

    C0333p(FirewallVpnService firewallVpnService) {
        this.f1445a = firewallVpnService;
    }

    public void run() {
        FirewallVpnService firewallVpnService = this.f1445a;
        C0315l.m2018a("DCVpnService", "bouncer_run");
        NativeWrapper.jni_dickb(firewallVpnService);
        while (!this.f1445a.f1321f) {
            NativeWrapper.jni_dickk();
            synchronized (this.f1445a) {
                C0315l.m2018a("DCVpnService", "bouncer_run: iteration");
            }
        }
        NativeWrapper.jni_dickc();
    }
}
