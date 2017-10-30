package com.ppu.fba;

import com.ppu.fba.p009d.Log1;

class C0319d implements Runnable {
    final /* synthetic */ FirewallVpnService f1425a;

    C0319d(FirewallVpnService firewallVpnService) {
        this.f1425a = firewallVpnService;
    }

    public void run() {
        FirewallVpnService firewallVpnService = this.f1425a;
        Log1.LogF1("FWVpnService", "dns_run");
        NativeWrapper.jni_dickb(firewallVpnService);
        while (!this.f1425a.f1321f) {
            NativeWrapper.jni_dickx();
            Log1.LogF1("FWVpnService", "dns_run: iteration");
        }
        NativeWrapper.jni_dickc();
        Log1.LogF1("FWVpnService", "dns_run: stop " + firewallVpnService.getPackageName());
    }
}
