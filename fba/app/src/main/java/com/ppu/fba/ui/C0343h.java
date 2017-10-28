package com.ppu.fba.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.C0288a;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p007b.C0289a;
import com.ppu.fba.p009d.C0318o;

class C0343h implements OnClickListener {
    final /* synthetic */ DetailsAppActivity f1867a;
    final /* synthetic */ C0289a f1868b;
    final /* synthetic */ Boolean f1869c;
    final /* synthetic */ String f1870d;

    C0343h(DetailsAppActivity detailsAppActivity, C0289a c0289a, Boolean bool, String str) {
        this.f1867a = detailsAppActivity;
        this.f1868b = c0289a;
        this.f1869c = bool;
        this.f1870d = str;
    }

    public void onClick(View view) {
        this.f1868b.m1920a(0);
        FirewallManagerService a = FirewallManagerService.m1852a(this.f1867a);
        if (a != null) {
            a.m1863a(new C0288a(5));
        }
        this.f1867a.f1465m.setEnabled(true);
        if (this.f1869c.booleanValue()) {
            this.f1867a.f1466n.setEnabled(true);
            this.f1867a.f1467o.setEnabled(true);
        }
        C0318o.m2031a(MapBuilder.createEvent("detApps", "buttonAllow", this.f1870d, null).build());
    }
}
