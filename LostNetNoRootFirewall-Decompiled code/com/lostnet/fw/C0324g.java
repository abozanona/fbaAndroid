package com.lostnet.fw;

import com.lostnet.fw.p009d.C0315l;
import java.net.InetAddress;
import java.net.UnknownHostException;

class C0324g extends C0323r {
    final /* synthetic */ FirewallVpnService f1441a;

    public C0324g(FirewallVpnService firewallVpnService, boolean z) {
        InetAddress byAddress;
        this.f1441a = firewallVpnService;
        super(firewallVpnService);
        C0315l.m2018a("DCVpnService", "DCVpnService.Builder");
        try {
            byAddress = InetAddress.getByAddress(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) -84, (byte) 17, (byte) 39, (byte) 1});
        } catch (UnknownHostException e) {
            e.printStackTrace();
            byAddress = null;
        }
        if (byAddress != null) {
            addAddress("::ffff:172.17.39.1", 0);
            addAddress("fe80::17", 64);
        }
        addAddress("172.17.39.1", 24);
        addDnsServer("172.17.39.2");
        if (byAddress != null) {
            m2037a();
            setMtu(1280);
            setSession(firewallVpnService.getResources().getText(C0330m.app_name).toString());
        } else {
            m2037a();
            setMtu(1280);
            setSession(firewallVpnService.getResources().getText(C0330m.app_name).toString());
        }
    }
}
