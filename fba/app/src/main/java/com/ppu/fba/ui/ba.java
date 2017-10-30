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

public class ba implements OnClickListener {
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
        Log1.LogAction("suggApps", "buttonAllow", this.f1645e, null);
        this.f1641a.f1623a.m2057c(this.f1643c);
    }
}
