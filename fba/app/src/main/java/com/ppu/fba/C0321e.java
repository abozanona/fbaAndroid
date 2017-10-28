package com.ppu.fba;

import com.ppu.fba.p009d.C0315l;

class C0321e implements Runnable {
    final /* synthetic */ FirewallVpnService f1438a;

    C0321e(FirewallVpnService firewallVpnService) {
        this.f1438a = firewallVpnService;
    }

    public void run() {
        FirewallVpnService firewallVpnService = this.f1438a;
        C0315l.m2018a("FWVpnService", "squid_run");
        NativeWrapper.jni_dickb(firewallVpnService);
        while (!this.f1438a.f1321f) {
            NativeWrapper.jni_dickr();
            C0315l.m2018a("FWVpnService", "squid_run: iteration");
        }
        NativeWrapper.jni_dickc();
        C0315l.m2018a("FWVpnService", "squid_run: stop " + firewallVpnService.getPackageName());
    }
}
