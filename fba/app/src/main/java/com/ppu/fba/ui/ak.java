package com.ppu.fba.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.ppu.fba.C0288a;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p007b.C0289a;
import com.ppu.fba.p009d.Log1;

public class ak implements OnClickListener {
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
        Log1.LogAction("listApps", "clickWiFi", this.f1588e, null);
    }
}
