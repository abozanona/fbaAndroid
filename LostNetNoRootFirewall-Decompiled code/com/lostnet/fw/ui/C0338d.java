package com.lostnet.fw.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.C0288a;
import com.lostnet.fw.FirewallManagerService;
import com.lostnet.fw.p007b.C0289a;
import com.lostnet.fw.p009d.C0318o;

class C0338d implements OnCheckedChangeListener {
    final /* synthetic */ DetailsAppActivity f1757a;
    final /* synthetic */ C0289a f1758b;
    final /* synthetic */ String f1759c;

    C0338d(DetailsAppActivity detailsAppActivity, C0289a c0289a, String str) {
        this.f1757a = detailsAppActivity;
        this.f1758b = c0289a;
        this.f1759c = str;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f1758b.m1922b(8);
        } else {
            this.f1758b.m1923c(8);
        }
        FirewallManagerService a = FirewallManagerService.m1852a(this.f1757a);
        if (a != null) {
            a.m1863a(new C0288a(5));
        }
        C0318o.m2031a(MapBuilder.createEvent("detApps", z ? "bgSet" : "bgClear", this.f1759c, null).build());
    }
}
