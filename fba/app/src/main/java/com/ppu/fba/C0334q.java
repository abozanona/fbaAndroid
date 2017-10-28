package com.ppu.fba;

import com.ppu.fba.p009d.C0315l;

class C0334q extends C0323r {
    final /* synthetic */ FirewallVpnService f1446a;

    public C0334q(FirewallVpnService firewallVpnService, boolean z) {
        this.f1446a = firewallVpnService;
        super(firewallVpnService);
        C0315l.m2018a("DCVpnService", "DCVpnService.Builder");
        addAddress("172.17.39.1", 24);
        addDnsServer("172.17.39.2");
        m2037a();
        setMtu(1280);
        setSession(firewallVpnService.getResources().getText(R.string.app_name).toString());
    }
}
