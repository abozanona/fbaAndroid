package com.lostnet.fw;

import com.lostnet.fw.p009d.C0315l;

class C0322f implements Runnable {
    final /* synthetic */ FirewallVpnService f1439a;

    C0322f(FirewallVpnService firewallVpnService) {
        this.f1439a = firewallVpnService;
    }

    public void run() {
        FirewallVpnService firewallVpnService = this.f1439a;
        C0315l.m2018a("DCVpnService", "tcptp_run");
        NativeWrapper.jni_dickb(firewallVpnService);
        while (!this.f1439a.f1321f) {
            NativeWrapper.jni_dickl();
            synchronized (this.f1439a) {
                C0315l.m2018a("DCVpnService", "tcptp_run: iteration");
            }
        }
        NativeWrapper.jni_dickc();
        C0315l.m2018a("DCVpnService", "tcptp_run: stop " + firewallVpnService.getPackageName());
    }
}
