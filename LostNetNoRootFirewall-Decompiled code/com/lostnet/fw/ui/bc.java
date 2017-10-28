package com.lostnet.fw.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.C0288a;
import com.lostnet.fw.FirewallManagerService;
import com.lostnet.fw.p004a.C0284b;
import com.lostnet.fw.p004a.C0285c;
import com.lostnet.fw.p004a.C0286d;
import com.lostnet.fw.p007b.C0289a;
import com.lostnet.fw.p009d.C0318o;

class bc implements OnClickListener {
    final /* synthetic */ aw f1651a;
    final /* synthetic */ C0289a f1652b;
    final /* synthetic */ Context f1653c;
    final /* synthetic */ int f1654d;
    final /* synthetic */ String f1655e;

    bc(aw awVar, C0289a c0289a, Context context, int i, String str) {
        this.f1651a = awVar;
        this.f1652b = c0289a;
        this.f1653c = context;
        this.f1654d = i;
        this.f1655e = str;
    }

    public void onClick(View view) {
        this.f1652b.m1920a(2);
        FirewallManagerService a = FirewallManagerService.m1852a(this.f1653c);
        if (a != null) {
            a.m1863a(new C0288a(5));
        }
        C0285c.m1913a(new C0285c(C0284b.APPLICATION, this.f1654d, C0286d.BLOCK));
        C0318o.m2031a(MapBuilder.createEvent("suggApps", "buttonBlock", this.f1655e, null).build());
        this.f1651a.f1623a.m2057c(this.f1653c);
    }
}
