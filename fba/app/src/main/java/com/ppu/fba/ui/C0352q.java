package com.ppu.fba.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.ppu.fba.C0288a;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p007b.C0292d;
import com.ppu.fba.p007b.C0294f;
import com.ppu.fba.p009d.C0309f;
import com.ppu.fba.p009d.Log1;
import java.util.Iterator;

public class C0352q implements OnClickListener {
    final /* synthetic */ DetailsGeoActivity f1891a;
    final /* synthetic */ String f1892b;

    C0352q(DetailsGeoActivity detailsGeoActivity, String str) {
        this.f1891a = detailsGeoActivity;
        this.f1892b = str;
    }

    public void onClick(View view) {
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            C0294f c0294f = a.f1295d;
            synchronized (c0294f) {
                Iterator it = this.f1891a.f1468a.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    int d = C0309f.m1982d(str);
                    C0292d c0292d = (C0292d) c0294f.f1370a.get(Integer.valueOf(d));
                    if (c0292d == null) {
                        c0292d = new C0292d(str, d);
                    }
                    c0292d.f1369c = 0;
                    c0292d.f1368b = true;
                    c0294f.f1370a.put(Integer.valueOf(d), c0292d);
                }
            }
            a.m1863a(new C0288a(5));
        }
        Log1.LogAction("detGeo", "buttonAllow", this.f1892b, null);
    }
}
