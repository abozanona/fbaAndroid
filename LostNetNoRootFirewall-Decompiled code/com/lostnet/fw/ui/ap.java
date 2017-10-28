package com.lostnet.fw.ui;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.C0288a;
import com.lostnet.fw.FirewallApplication;
import com.lostnet.fw.FirewallManagerService;
import com.lostnet.fw.p009d.C0315l;
import com.lostnet.fw.p009d.C0318o;

class ap implements OnCheckedChangeListener {
    final /* synthetic */ ao f1612a;
    final /* synthetic */ Context f1613b;

    ap(ao aoVar, Context context) {
        this.f1612a = aoVar;
        this.f1613b = context;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int i;
        compoundButton.setEnabled(false);
        if (z) {
            i = 1;
            C0318o.m2031a(MapBuilder.createEvent("settings", "on_off", "on", null).build());
        } else {
            i = 2;
            C0318o.m2031a(MapBuilder.createEvent("settings", "on_off", "off", null).build());
        }
        C0288a c0288a = new C0288a(i, new aq(this, z, compoundButton));
        FirewallManagerService a = FirewallManagerService.m1852a(FirewallApplication.m1851a());
        if (a != null) {
            a.m1863a(c0288a);
            a.m1863a(new C0288a(5));
            return;
        }
        C0315l.m2018a("SectionDashboardFragment", "no manager found");
    }
}
