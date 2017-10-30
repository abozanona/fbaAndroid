package com.ppu.fba.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.ppu.fba.C0288a;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p007b.C0289a;
import com.ppu.fba.p009d.Log1;

public class C0344i implements OnClickListener {
    final /* synthetic */ DetailsAppActivity f1871a;
    final /* synthetic */ C0289a f1872b;
    final /* synthetic */ Boolean f1873c;
    final /* synthetic */ String f1874d;

    C0344i(DetailsAppActivity detailsAppActivity, C0289a c0289a, Boolean bool, String str) {
        this.f1871a = detailsAppActivity;
        this.f1872b = c0289a;
        this.f1873c = bool;
        this.f1874d = str;
    }

    public void onClick(View view) {
        this.f1872b.m1920a(1);
        FirewallManagerService a = FirewallManagerService.m1852a(this.f1871a);
        if (a != null) {
            a.m1863a(new C0288a(5));
        }
        this.f1871a.f1465m.setEnabled(true);
        if (this.f1873c.booleanValue()) {
            this.f1871a.f1466n.setEnabled(true);
            this.f1871a.f1467o.setEnabled(true);
        }
        Log1.LogAction("detApps", "buttonWiFi", this.f1874d, null);
    }
}
