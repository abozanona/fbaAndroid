package com.ppu.fba;

import android.app.Activity;
import android.content.Intent;
import android.net.VpnService;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.p009d.Log1;
import com.ppu.fba.p009d.Log1;

public class FirewallVPNStart extends Activity {
    public static FirewallVPNStart f1314a = null;
    private String f1315b;

    public FirewallVPNStart() {
        setVisible(false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Log1.LogF1("FWVPNStart", "onActivityResult");
        f1314a = null;
        if (i2 != 0) {
            Log1.LogF1("FWVPNStart", "onActivityResult: OK");
            startService(new Intent(FirewallApplication.m1851a(), FirewallVpnService.class));
        } else {
            Log1.LogF1("FWVPNStart", "onActivityResult: NOT OK: " + i2);
            Log1.LogAction("state", "vpnFail", "notOk", null);
            FirewallManagerService a = FirewallManagerService.m1852a(null);
            if (a != null) {
                a.m1863a(new C0288a(2));
            }
            Intent intent2 = new Intent(this, FirewallVPNStop.class);
            intent2.setFlags(268435456);
            startActivity(intent2);
        }
        Log1.LogF1("FWVPNStart", "onActivityResult: end");
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
        Log1.LogF1("FWVPNStart", "onStart");
        f1314a = this;
        this.f1315b = getIntent().getStringExtra("waiter");
        if (this.f1315b != null) {
            synchronized (this.f1315b) {
                Intent prepare = VpnService.prepare(this);
                if (prepare != null) {
                    Log1.LogF1("FWVPNStart", "about to launch VPN");
                    startActivityForResult(prepare, 0);
                } else {
                    Log1.LogF1("FWVPNStart", "calling onActivityResult manually");
                    onActivityResult(0, -1, null);
                }
            }
        } else {
            finish();
        }
        Log1.LogF1("FWVPNStart", "onStart: end");
    }
}
