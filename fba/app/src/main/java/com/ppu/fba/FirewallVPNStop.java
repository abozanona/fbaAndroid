package com.ppu.fba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.p009d.Log1;
import com.ppu.fba.p009d.Log1;
import com.ppu.fba.ui.RestartActivity;
import com.ppu.fba.ui.StatusChangeReceiver;

public class FirewallVPNStop extends Activity {
    public FirewallVPNStop() {
        setVisible(false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Context a = FirewallApplication.m1851a();
        Log1.LogF1("FWVPNStop", "onActivityResult");
        Editor edit;
        Intent intent2;
        if (i2 != 0) {
            Log1.LogF1("FWVPNStop", "onActivityResult: OK");
            if (i2 == 1) {
                Log1.LogAction(("state", "vpnLater", null, null));
                new Thread(new C0331n(this, a)).start();
            } else {
                edit = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a()).edit();
                edit.putBoolean("status_on", true);
                edit.commit();
                intent2 = new Intent(a, StatusChangeReceiver.class);
                intent2.setAction("com.ppu.fba.ui.StatusChangeReceiver.CHANGE");
                a.sendBroadcast(intent2);
                FirewallManagerService a2 = FirewallManagerService.m1852a(null);
                if (a2 != null) {
                    a2.m1863a(new C0288a(1));
                }
            }
        } else {
            Log1.LogF1("FWVPNStop", "onActivityResult: NOT OK: " + i2);
            Log1.LogAction(("state", "vpnCanc", null, null));
            edit = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a()).edit();
            edit.putBoolean("status_on", false);
            edit.commit();
            intent2 = new Intent(a, StatusChangeReceiver.class);
            intent2.setAction("com.ppu.fba.ui.StatusChangeReceiver.CHANGE");
            a.sendBroadcast(intent2);
        }
        Log1.LogF1("FWVPNStop", "onActivityResult: end");
        super.onActivityResult(i, i2, intent);
        finish();
    }

    public void onStart() {
        super.onStart();
        Log1.LogF1("FWVPNStop", "onStart");
        Intent intent = new Intent(this, RestartActivity.class);
        intent.setFlags(536870912);
        startActivityForResult(intent, 17);
        Log1.LogF1("FWVPNStop", "onStart: end");
    }

    public void onStop() {
        super.onStop();
    }
}
