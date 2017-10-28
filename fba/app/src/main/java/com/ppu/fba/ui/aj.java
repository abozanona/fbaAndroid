package com.ppu.fba.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.C0288a;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p007b.C0289a;
import com.ppu.fba.p009d.C0318o;

class aj implements OnClickListener {
    final /* synthetic */ ai f1579a;
    final /* synthetic */ C0289a f1580b;
    final /* synthetic */ Context f1581c;
    final /* synthetic */ Integer f1582d;
    final /* synthetic */ String f1583e;

    aj(ai aiVar, C0289a c0289a, Context context, Integer num, String str) {
        this.f1579a = aiVar;
        this.f1580b = c0289a;
        this.f1581c = context;
        this.f1582d = num;
        this.f1583e = str;
    }

    public void onClick(View view) {
        this.f1580b.m1920a(0);
        FirewallManagerService a = FirewallManagerService.m1852a(this.f1581c);
        if (a != null) {
            synchronized (a.f1294c) {
                a.f1294c.f1366a.put(this.f1582d, this.f1580b);
            }
            a.m1863a(new C0288a(5));
        }
        C0318o.m2031a(MapBuilder.createEvent("listApps", "clickAllow", this.f1583e, null).build());
    }
}
