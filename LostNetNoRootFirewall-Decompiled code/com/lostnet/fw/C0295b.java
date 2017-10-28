package com.lostnet.fw;

import com.lostnet.fw.p009d.C0315l;

class C0295b implements Runnable {
    final /* synthetic */ FirewallManagerService f1371a;

    C0295b(FirewallManagerService firewallManagerService) {
        this.f1371a = firewallManagerService;
    }

    public void run() {
        FirewallManagerService firewallManagerService = this.f1371a;
        C0315l.m2018a("FWManagerService", "timer_run");
        NativeWrapper.jni_dicka(firewallManagerService);
        while (!this.f1371a.f1300k) {
            NativeWrapper.jni_dickn();
            C0315l.m2018a("FWManagerService", "timer_run: iteration");
        }
        NativeWrapper.jni_dickc();
        C0315l.m2018a("FWManagerService", "timer_run: stop " + firewallManagerService.getPackageName());
    }
}
