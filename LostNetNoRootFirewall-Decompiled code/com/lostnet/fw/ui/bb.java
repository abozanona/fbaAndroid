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

class bb implements OnClickListener {
    final /* synthetic */ aw f1646a;
    final /* synthetic */ C0289a f1647b;
    final /* synthetic */ Context f1648c;
    final /* synthetic */ int f1649d;
    final /* synthetic */ String f1650e;

    bb(aw awVar, C0289a c0289a, Context context, int i, String str) {
        this.f1646a = awVar;
        this.f1647b = c0289a;
        this.f1648c = context;
        this.f1649d = i;
        this.f1650e = str;
    }

    public void onClick(View view) {
        this.f1647b.m1920a(1);
        FirewallManagerService a = FirewallManagerService.m1852a(this.f1648c);
        if (a != null) {
            a.m1863a(new C0288a(5));
        }
        C0285c.m1913a(new C0285c(C0284b.APPLICATION, this.f1649d, C0286d.WIFIONLY));
        C0318o.m2031a(MapBuilder.createEvent("suggApps", "buttonWiFi", this.f1650e, null).build());
        this.f1646a.f1623a.m2057c(this.f1648c);
    }
}
