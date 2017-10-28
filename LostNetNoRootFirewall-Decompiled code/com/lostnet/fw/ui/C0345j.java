package com.lostnet.fw.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.C0288a;
import com.lostnet.fw.FirewallManagerService;
import com.lostnet.fw.p007b.C0289a;
import com.lostnet.fw.p009d.C0318o;

class C0345j implements OnClickListener {
    final /* synthetic */ DetailsAppActivity f1875a;
    final /* synthetic */ C0289a f1876b;
    final /* synthetic */ String f1877c;

    C0345j(DetailsAppActivity detailsAppActivity, C0289a c0289a, String str) {
        this.f1875a = detailsAppActivity;
        this.f1876b = c0289a;
        this.f1877c = str;
    }

    public void onClick(View view) {
        this.f1876b.m1920a(2);
        FirewallManagerService a = FirewallManagerService.m1852a(this.f1875a);
        if (a != null) {
            a.m1863a(new C0288a(5));
        }
        this.f1875a.f1465m.setEnabled(false);
        this.f1875a.f1466n.setEnabled(false);
        this.f1875a.f1467o.setEnabled(false);
        C0318o.m2031a(MapBuilder.createEvent("detApps", "buttonBlock", this.f1877c, null).build());
    }
}
