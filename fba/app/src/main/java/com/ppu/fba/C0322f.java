package com.ppu.fba;

import com.ppu.fba.p009d.Log1;

class C0322f implements Runnable {
    final /* synthetic */ FirewallVpnService f1439a;

    C0322f(FirewallVpnService firewallVpnService) {
        this.f1439a = firewallVpnService;
    }

    public void run() {
        FirewallVpnService firewallVpnService = this.f1439a;
        Log1.LogF1("DCVpnService", "tcptp_run");
        NativeWrapper.jni_dickb(firewallVpnService);
        while (!this.f1439a.f1321f) {
            NativeWrapper.jni_dickl();
            synchronized (this.f1439a) {
                Log1.LogF1("DCVpnService", "tcptp_run: iteration");
            }
        }
        NativeWrapper.jni_dickc();
        Log1.LogF1("DCVpnService", "tcptp_run: stop " + firewallVpnService.getPackageName());
    }
}
