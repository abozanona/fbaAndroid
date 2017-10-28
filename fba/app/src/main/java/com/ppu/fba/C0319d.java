package com.ppu.fba;

import com.ppu.fba.p009d.C0315l;

class C0319d implements Runnable {
    final /* synthetic */ FirewallVpnService f1425a;

    C0319d(FirewallVpnService firewallVpnService) {
        this.f1425a = firewallVpnService;
    }

    public void run() {
        FirewallVpnService firewallVpnService = this.f1425a;
        C0315l.m2018a("FWVpnService", "dns_run");
        NativeWrapper.jni_dickb(firewallVpnService);
        while (!this.f1425a.f1321f) {
            NativeWrapper.jni_dickx();
            C0315l.m2018a("FWVpnService", "dns_run: iteration");
        }
        NativeWrapper.jni_dickc();
        C0315l.m2018a("FWVpnService", "dns_run: stop " + firewallVpnService.getPackageName());
    }
}
