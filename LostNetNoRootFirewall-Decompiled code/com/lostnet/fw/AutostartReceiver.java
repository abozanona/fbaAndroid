package com.lostnet.fw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.p009d.C0313j;
import com.lostnet.fw.p009d.C0315l;
import com.lostnet.fw.p009d.C0318o;

public class AutostartReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Context a = FirewallApplication.m1851a();
        Resources resources = a.getResources();
        C0315l.m2018a("Autostart", "started");
        C0318o.m2031a(MapBuilder.createEvent("state", "autoStart", null, null).build());
        if (!("com.lostnet.fw.free".equals(resources.getString(C0330m.package_name)) && C0313j.m2005a("com.lostnet.fw.pro")) && PreferenceManager.getDefaultSharedPreferences(a).getBoolean("status_on", false)) {
            FirewallManagerService a2 = FirewallManagerService.m1852a(a);
            if (a2 != null) {
                a2.m1863a(new C0288a(1));
                a2.m1863a(new C0288a(3));
                a2.m1863a(new C0288a(5));
            }
        }
    }
}
