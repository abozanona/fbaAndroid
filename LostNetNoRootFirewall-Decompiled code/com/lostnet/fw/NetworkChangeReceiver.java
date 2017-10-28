package com.lostnet.fw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.lostnet.fw.p009d.C0315l;

public class NetworkChangeReceiver extends BroadcastReceiver {
    private static boolean f1325a = false;

    public void onReceive(Context context, Intent intent) {
        boolean z = false;
        Context a = FirewallApplication.m1851a();
        int i;
        try {
            i = a.getPackageManager().getPackageInfo(a.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            i = 0;
        }
        C0315l.m2018a("ConnReceiver", "onReceive");
        if (!f1325a) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a());
            boolean z2 = defaultSharedPreferences.getBoolean("status_on", false);
            int i2 = a.getSharedPreferences("experience", 0).getInt("lastRunVersion", 0);
            if (z2 && i2 != 0 && i2 < r0) {
                Editor edit = defaultSharedPreferences.edit();
                edit.putBoolean("status_on", true);
                edit.commit();
                z = true;
            }
            f1325a = true;
        }
        FirewallManagerService a2 = FirewallManagerService.m1852a(a);
        if (a2 != null) {
            if (z) {
                a2.m1863a(new C0288a(1));
            }
            a2.m1863a(new C0288a(3));
            a2.m1863a(new C0288a(5));
        }
    }
}
