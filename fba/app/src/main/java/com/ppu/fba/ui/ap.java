package com.ppu.fba.ui;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ppu.fba.C0288a;
import com.ppu.fba.FirewallApplication;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p009d.Log1;
import com.ppu.fba.p009d.Log1;

public class ap implements OnCheckedChangeListener {
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
            Log1.LogAction("settings", "on_off", "on", null);
        } else {
            i = 2;
            Log1.LogAction("settings", "on_off", "off", null);
        }
        C0288a c0288a = new C0288a(i, new aq(this, z, compoundButton));
        FirewallManagerService a = FirewallManagerService.m1852a(FirewallApplication.m1851a());
        if (a != null) {
            a.m1863a(c0288a);
            a.m1863a(new C0288a(5));
            return;
        }
        Log1.LogF1("SectionDashboardFragment", "no manager found");
    }
}
