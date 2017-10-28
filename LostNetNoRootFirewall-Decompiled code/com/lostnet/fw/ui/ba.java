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

class ba implements OnClickListener {
    final /* synthetic */ aw f1641a;
    final /* synthetic */ C0289a f1642b;
    final /* synthetic */ Context f1643c;
    final /* synthetic */ int f1644d;
    final /* synthetic */ String f1645e;

    ba(aw awVar, C0289a c0289a, Context context, int i, String str) {
        this.f1641a = awVar;
        this.f1642b = c0289a;
        this.f1643c = context;
        this.f1644d = i;
        this.f1645e = str;
    }

    public void onClick(View view) {
        this.f1642b.m1920a(0);
        FirewallManagerService a = FirewallManagerService.m1852a(this.f1643c);
        if (a != null) {
            a.m1863a(new C0288a(5));
        }
        C0285c.m1913a(new C0285c(C0284b.APPLICATION, this.f1644d, C0286d.ALLOW));
        C0318o.m2031a(MapBuilder.createEvent("suggApps", "buttonAllow", this.f1645e, null).build());
        this.f1641a.f1623a.m2057c(this.f1643c);
    }
}
