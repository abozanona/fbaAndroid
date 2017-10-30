package com.ppu.fba.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ppu.fba.C0288a;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p007b.C0289a;
import com.ppu.fba.p009d.Log1;

public class C0341f implements OnCheckedChangeListener {
    final /* synthetic */ DetailsAppActivity f1843a;
    final /* synthetic */ C0289a f1844b;
    final /* synthetic */ String f1845c;

    C0341f(DetailsAppActivity detailsAppActivity, C0289a c0289a, String str) {
        this.f1843a = detailsAppActivity;
        this.f1844b = c0289a;
        this.f1845c = str;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f1844b.m1922b(16);
        } else {
            this.f1844b.m1923c(16);
        }
        FirewallManagerService a = FirewallManagerService.m1852a(this.f1843a);
        if (a != null) {
            a.m1863a(new C0288a(5));
        }
        Log1.LogAction("detApps", z ? "nightSet" : "nightClear", this.f1845c, null);
    }
}
