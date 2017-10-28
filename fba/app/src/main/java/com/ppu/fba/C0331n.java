package com.ppu.fba;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.ppu.fba.ui.StatusChangeReceiver;

class C0331n implements Runnable {
    final /* synthetic */ Context f1442a;
    final /* synthetic */ FirewallVPNStop f1443b;

    C0331n(FirewallVPNStop firewallVPNStop, Context context) {
        this.f1443b = firewallVPNStop;
        this.f1442a = context;
    }

    public void run() {
        try {
            Thread.sleep(3600000);
        } catch (InterruptedException e) {
        }
        Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f1442a).edit();
        edit.putBoolean("status_on", true);
        edit.commit();
        Intent intent = new Intent(this.f1442a, StatusChangeReceiver.class);
        intent.setAction("com.ppu.fba.ui.StatusChangeReceiver.CHANGE");
        this.f1442a.sendBroadcast(intent);
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            a.m1863a(new C0288a(1));
        }
    }
}
