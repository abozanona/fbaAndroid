package com.lostnet.fw.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.C0288a;
import com.lostnet.fw.FirewallManagerService;
import com.lostnet.fw.p007b.C0292d;
import com.lostnet.fw.p007b.C0294f;
import com.lostnet.fw.p009d.C0309f;
import com.lostnet.fw.p009d.C0318o;
import java.util.Iterator;

class C0353r implements OnClickListener {
    final /* synthetic */ DetailsGeoActivity f1893a;
    final /* synthetic */ String f1894b;

    C0353r(DetailsGeoActivity detailsGeoActivity, String str) {
        this.f1893a = detailsGeoActivity;
        this.f1894b = str;
    }

    public void onClick(View view) {
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            C0294f c0294f = a.f1295d;
            synchronized (c0294f) {
                Iterator it = this.f1893a.f1468a.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    int d = C0309f.m1982d(str);
                    C0292d c0292d = (C0292d) c0294f.f1370a.get(Integer.valueOf(d));
                    if (c0292d == null) {
                        c0292d = new C0292d(str, d);
                    }
                    c0292d.f1369c = 2;
                    c0292d.f1368b = true;
                    c0294f.f1370a.put(Integer.valueOf(d), c0292d);
                }
            }
            a.m1863a(new C0288a(5));
        }
        C0318o.m2031a(MapBuilder.createEvent("detGeo", "buttonBlock", this.f1894b, null).build());
    }
}
