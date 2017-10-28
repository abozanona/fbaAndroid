package com.lostnet.fw;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.p009d.C0315l;
import com.lostnet.fw.p009d.C0318o;
import com.lostnet.fw.ui.RestartActivity;
import com.lostnet.fw.ui.StatusChangeReceiver;

public class FirewallVPNStop extends Activity {
    public FirewallVPNStop() {
        setVisible(false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Context a = FirewallApplication.m1851a();
        C0315l.m2018a("FWVPNStop", "onActivityResult");
        Editor edit;
        Intent intent2;
        if (i2 != 0) {
            C0315l.m2018a("FWVPNStop", "onActivityResult: OK");
            if (i2 == 1) {
                C0318o.m2031a(MapBuilder.createEvent("state", "vpnLater", null, null).build());
                new Thread(new C0331n(this, a)).start();
            } else {
                edit = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a()).edit();
                edit.putBoolean("status_on", true);
                edit.commit();
                intent2 = new Intent(a, StatusChangeReceiver.class);
                intent2.setAction("com.lostnet.fw.ui.StatusChangeReceiver.CHANGE");
                a.sendBroadcast(intent2);
                FirewallManagerService a2 = FirewallManagerService.m1852a(null);
                if (a2 != null) {
                    a2.m1863a(new C0288a(1));
                }
            }
        } else {
            C0315l.m2018a("FWVPNStop", "onActivityResult: NOT OK: " + i2);
            C0318o.m2031a(MapBuilder.createEvent("state", "vpnCanc", null, null).build());
            edit = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a()).edit();
            edit.putBoolean("status_on", false);
            edit.commit();
            intent2 = new Intent(a, StatusChangeReceiver.class);
            intent2.setAction("com.lostnet.fw.ui.StatusChangeReceiver.CHANGE");
            a.sendBroadcast(intent2);
        }
        C0315l.m2018a("FWVPNStop", "onActivityResult: end");
        super.onActivityResult(i, i2, intent);
        finish();
    }

    public void onStart() {
        super.onStart();
        C0318o.m2030a((Activity) this);
        C0315l.m2018a("FWVPNStop", "onStart");
        Intent intent = new Intent(this, RestartActivity.class);
        intent.setFlags(536870912);
        startActivityForResult(intent, 17);
        C0315l.m2018a("FWVPNStop", "onStart: end");
    }

    public void onStop() {
        super.onStop();
        C0318o.m2032b(this);
    }
}
