package com.lostnet.fw.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.C0288a;
import com.lostnet.fw.FirewallManagerService;
import com.lostnet.fw.p007b.C0289a;
import com.lostnet.fw.p009d.C0318o;

class ak implements OnClickListener {
    final /* synthetic */ ai f1584a;
    final /* synthetic */ C0289a f1585b;
    final /* synthetic */ Context f1586c;
    final /* synthetic */ Integer f1587d;
    final /* synthetic */ String f1588e;

    ak(ai aiVar, C0289a c0289a, Context context, Integer num, String str) {
        this.f1584a = aiVar;
        this.f1585b = c0289a;
        this.f1586c = context;
        this.f1587d = num;
        this.f1588e = str;
    }

    public void onClick(View view) {
        this.f1585b.m1920a(1);
        FirewallManagerService a = FirewallManagerService.m1852a(this.f1586c);
        if (a != null) {
            a.f1294c.f1366a.put(this.f1587d, this.f1585b);
            a.m1863a(new C0288a(5));
        }
        C0318o.m2031a(MapBuilder.createEvent("listApps", "clickWiFi", this.f1588e, null).build());
    }
}
