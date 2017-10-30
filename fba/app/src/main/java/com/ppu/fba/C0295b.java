package com.ppu.fba;

import com.ppu.fba.p009d.Log1;

class C0295b implements Runnable {
    final /* synthetic */ FirewallManagerService f1371a;

    C0295b(FirewallManagerService firewallManagerService) {
        this.f1371a = firewallManagerService;
    }

    public void run() {
        FirewallManagerService firewallManagerService = this.f1371a;
        Log1.LogF1("FWManagerService", "timer_run");
        NativeWrapper.jni_dicka(firewallManagerService);
        while (!this.f1371a.f1300k) {
            NativeWrapper.jni_dickn();
            Log1.LogF1("FWManagerService", "timer_run: iteration");
        }
        NativeWrapper.jni_dickc();
        Log1.LogF1("FWManagerService", "timer_run: stop " + firewallManagerService.getPackageName());
    }
}
