package com.lostnet.fw.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.C0288a;
import com.lostnet.fw.FirewallManagerService;
import com.lostnet.fw.p007b.C0289a;
import com.lostnet.fw.p009d.C0318o;

class C0341f implements OnCheckedChangeListener {
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
        C0318o.m2031a(MapBuilder.createEvent("detApps", z ? "nightSet" : "nightClear", this.f1845c, null).build());
    }
}
