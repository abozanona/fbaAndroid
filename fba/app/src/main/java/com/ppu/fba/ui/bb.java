package com.ppu.fba.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.ppu.fba.C0288a;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p004a.C0284b;
import com.ppu.fba.p004a.C0285c;
import com.ppu.fba.p004a.C0286d;
import com.ppu.fba.p007b.C0289a;
import com.ppu.fba.p009d.Log1;

public class bb implements OnClickListener {
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
        Log1.LogAction("suggApps", "buttonWiFi", this.f1650e, null);
        this.f1646a.f1623a.m2057c(this.f1648c);
    }
}
