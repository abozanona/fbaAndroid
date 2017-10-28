package com.ppu.fba;

import android.app.Activity;
import android.content.Intent;
import android.net.VpnService;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.p009d.C0315l;
import com.ppu.fba.p009d.C0318o;

public class FirewallVPNStart extends Activity {
    public static FirewallVPNStart f1314a = null;
    private String f1315b;

    public FirewallVPNStart() {
        setVisible(false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        C0315l.m2018a("FWVPNStart", "onActivityResult");
        f1314a = null;
        if (i2 != 0) {
            C0315l.m2018a("FWVPNStart", "onActivityResult: OK");
            startService(new Intent(FirewallApplication.m1851a(), FirewallVpnService.class));
        } else {
            C0315l.m2018a("FWVPNStart", "onActivityResult: NOT OK: " + i2);
            C0318o.m2031a(MapBuilder.createEvent("state", "vpnFail", "notOk", null).build());
            FirewallManagerService a = FirewallManagerService.m1852a(null);
            if (a != null) {
                a.m1863a(new C0288a(2));
            }
            Intent intent2 = new Intent(this, FirewallVPNStop.class);
            intent2.setFlags(268435456);
            startActivity(intent2);
        }
        C0315l.m2018a("FWVPNStart", "onActivityResult: end");
        if (this.f1315b != null) {
            synchronized (this.f1315b) {
                this.f1315b.notifyAll();
            }
        }
        super.onActivityResult(i, i2, intent);
        finish();
    }

    public void onStart() {
        super.onStart();
        C0315l.m2018a("FWVPNStart", "onStart");
        f1314a = this;
        this.f1315b = getIntent().getStringExtra("waiter");
        if (this.f1315b != null) {
            synchronized (this.f1315b) {
                Intent prepare = VpnService.prepare(this);
                if (prepare != null) {
                    C0315l.m2018a("FWVPNStart", "about to launch VPN");
                    startActivityForResult(prepare, 0);
                } else {
                    C0315l.m2018a("FWVPNStart", "calling onActivityResult manually");
                    onActivityResult(0, -1, null);
                }
            }
        } else {
            finish();
        }
        C0315l.m2018a("FWVPNStart", "onStart: end");
    }
}
