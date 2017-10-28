package com.ppu.fba;

import com.ppu.fba.p009d.C0315l;

class C0332o implements Runnable {
    final /* synthetic */ FirewallVpnService f1444a;

    C0332o(FirewallVpnService firewallVpnService) {
        this.f1444a = firewallVpnService;
    }

    public void run() {
        FirewallVpnService firewallVpnService = this.f1444a;
        C0315l.m2018a("DCVpnService", "udptp_run");
        NativeWrapper.jni_dickb(firewallVpnService);
        while (!this.f1444a.f1321f) {
            NativeWrapper.jni_dickm();
            synchronized (this.f1444a) {
                C0315l.m2018a("DCVpnService", "udptp_run: iteration");
            }
        }
        NativeWrapper.jni_dickc();
        C0315l.m2018a("DCVpnService", "udptp_run: stop " + firewallVpnService.getPackageName());
    }
}
