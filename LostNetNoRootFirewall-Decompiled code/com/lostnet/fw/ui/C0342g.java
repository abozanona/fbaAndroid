package com.lostnet.fw.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.C0288a;
import com.lostnet.fw.FirewallManagerService;
import com.lostnet.fw.p007b.C0289a;
import com.lostnet.fw.p009d.C0318o;

class C0342g implements OnCheckedChangeListener {
    final /* synthetic */ DetailsAppActivity f1864a;
    final /* synthetic */ C0289a f1865b;
    final /* synthetic */ String f1866c;

    C0342g(DetailsAppActivity detailsAppActivity, C0289a c0289a, String str) {
        this.f1864a = detailsAppActivity;
        this.f1865b = c0289a;
        this.f1866c = str;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f1865b.m1922b(32);
        } else {
            this.f1865b.m1923c(32);
        }
        FirewallManagerService a = FirewallManagerService.m1852a(this.f1864a);
        if (a != null) {
            a.m1863a(new C0288a(5));
        }
        C0318o.m2031a(MapBuilder.createEvent("detApps", z ? "officeSet" : "officeClear", this.f1866c, null).build());
    }
}
