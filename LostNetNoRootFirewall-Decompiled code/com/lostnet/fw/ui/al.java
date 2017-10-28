package com.lostnet.fw.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.C0288a;
import com.lostnet.fw.FirewallManagerService;
import com.lostnet.fw.p007b.C0289a;
import com.lostnet.fw.p009d.C0318o;

class al implements OnClickListener {
    final /* synthetic */ ai f1589a;
    final /* synthetic */ C0289a f1590b;
    final /* synthetic */ Context f1591c;
    final /* synthetic */ Integer f1592d;
    final /* synthetic */ String f1593e;

    al(ai aiVar, C0289a c0289a, Context context, Integer num, String str) {
        this.f1589a = aiVar;
        this.f1590b = c0289a;
        this.f1591c = context;
        this.f1592d = num;
        this.f1593e = str;
    }

    public void onClick(View view) {
        this.f1590b.m1920a(2);
        FirewallManagerService a = FirewallManagerService.m1852a(this.f1591c);
        if (a != null) {
            a.f1294c.f1366a.put(this.f1592d, this.f1590b);
            a.m1863a(new C0288a(5));
        }
        C0318o.m2031a(MapBuilder.createEvent("listApps", "clickBlock", this.f1593e, null).build());
    }
}
