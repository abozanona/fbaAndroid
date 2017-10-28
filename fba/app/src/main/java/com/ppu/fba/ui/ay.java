package com.ppu.fba.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.C0288a;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p004a.C0284b;
import com.ppu.fba.p004a.C0285c;
import com.ppu.fba.p004a.C0286d;
import com.ppu.fba.p007b.C0292d;
import com.ppu.fba.p009d.C0318o;

class ay implements OnClickListener {
    final /* synthetic */ aw f1629a;
    final /* synthetic */ C0292d f1630b;
    final /* synthetic */ Context f1631c;
    final /* synthetic */ int f1632d;
    final /* synthetic */ String f1633e;

    ay(aw awVar, C0292d c0292d, Context context, int i, String str) {
        this.f1629a = awVar;
        this.f1630b = c0292d;
        this.f1631c = context;
        this.f1632d = i;
        this.f1633e = str;
    }

    public void onClick(View view) {
        this.f1630b.f1369c = 0;
        this.f1630b.f1368b = true;
        FirewallManagerService a = FirewallManagerService.m1852a(this.f1631c);
        if (a != null) {
            a.m1863a(new C0288a(5));
        }
        C0285c.m1913a(new C0285c(C0284b.COUNTRY, this.f1632d, C0286d.ALLOW));
        C0318o.m2031a(MapBuilder.createEvent("suggCnts", "buttonAllow", this.f1633e, null).build());
        this.f1629a.f1623a.m2057c(this.f1631c);
    }
}
