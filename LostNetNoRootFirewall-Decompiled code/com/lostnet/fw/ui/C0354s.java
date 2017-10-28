package com.lostnet.fw.ui;

import android.support.v4.view.ViewPager;
import android.widget.TabHost.OnTabChangeListener;
import com.lostnet.fw.p009d.C0312i;

class C0354s implements OnTabChangeListener {
    final /* synthetic */ DetailsGeoActivity f1895a;
    final /* synthetic */ ViewPager f1896b;

    C0354s(DetailsGeoActivity detailsGeoActivity, ViewPager viewPager) {
        this.f1895a = detailsGeoActivity;
        this.f1896b = viewPager;
    }

    public void onTabChanged(String str) {
        if (str.equals("one")) {
            this.f1896b.m346a(0, true);
            this.f1895a.f1472e.setText(C0312i.m2001a(this.f1895a.getApplicationContext(), this.f1895a.f1476i));
            this.f1895a.f1473f.setText(C0312i.m2001a(this.f1895a.getApplicationContext(), this.f1895a.f1477j));
        } else if (str.equals("seven")) {
            this.f1896b.m346a(1, true);
            this.f1895a.f1472e.setText(C0312i.m2001a(this.f1895a.getApplicationContext(), this.f1895a.f1474g));
            this.f1895a.f1473f.setText(C0312i.m2001a(this.f1895a.getApplicationContext(), this.f1895a.f1475h));
        } else {
            this.f1896b.m346a(2, true);
            this.f1895a.f1472e.setText(C0312i.m2001a(this.f1895a.getApplicationContext(), this.f1895a.f1478k));
            this.f1895a.f1473f.setText(C0312i.m2001a(this.f1895a.getApplicationContext(), this.f1895a.f1479l));
        }
    }
}
