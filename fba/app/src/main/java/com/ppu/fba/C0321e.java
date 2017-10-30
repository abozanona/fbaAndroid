package com.ppu.fba;

import com.ppu.fba.p009d.Log1;

class C0321e implements Runnable {
    final /* synthetic */ FirewallVpnService f1438a;

    C0321e(FirewallVpnService firewallVpnService) {
        this.f1438a = firewallVpnService;
    }

    public void run() {
        FirewallVpnService firewallVpnService = this.f1438a;
        Log1.LogF1("FWVpnService", "squid_run");
        NativeWrapper.jni_dickb(firewallVpnService);
        while (!this.f1438a.f1321f) {
            NativeWrapper.jni_dickr();
            Log1.LogF1("FWVpnService", "squid_run: iteration");
        }
        NativeWrapper.jni_dickc();
        Log1.LogF1("FWVpnService", "squid_run: stop " + firewallVpnService.getPackageName());
    }
}
