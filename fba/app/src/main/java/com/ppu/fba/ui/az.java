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
import com.ppu.fba.p009d.Log1;

class az implements OnClickListener {
    final /* synthetic */ aw f1634a;
    final /* synthetic */ C0292d f1635b;
    final /* synthetic */ Context f1636c;
    final /* synthetic */ int f1637d;
    final /* synthetic */ String f1638e;

    az(aw awVar, C0292d c0292d, Context context, int i, String str) {
        this.f1634a = awVar;
        this.f1635b = c0292d;
        this.f1636c = context;
        this.f1637d = i;
        this.f1638e = str;
    }

    public void onClick(View view) {
        this.f1635b.f1369c = 2;
        this.f1635b.f1368b = true;
        FirewallManagerService a = FirewallManagerService.m1852a(this.f1636c);
        if (a != null) {
            a.m1863a(new C0288a(5));
        }
        C0285c.m1913a(new C0285c(C0284b.COUNTRY, this.f1637d, C0286d.BLOCK));
        Log1.LogAction(("suggCnts", "buttonBlock", this.f1638e, null));
        this.f1634a.f1623a.m2057c(this.f1636c);
    }
}
