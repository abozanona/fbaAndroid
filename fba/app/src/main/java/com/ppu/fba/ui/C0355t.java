package com.ppu.fba.ui;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.widget.TabHost;
import com.ppu.fba.p009d.C0312i;

public class C0355t extends SimpleOnPageChangeListener {
    final /* synthetic */ DetailsGeoActivity f1897a;
    final /* synthetic */ TabHost f1898b;

    C0355t(DetailsGeoActivity detailsGeoActivity, TabHost tabHost) {
        this.f1897a = detailsGeoActivity;
        this.f1898b = tabHost;
    }

    public void onPageSelected(int i) {
        this.f1898b.setCurrentTab(i);
        if (i == 0) {
            this.f1897a.f1472e.setText(C0312i.m2001a(this.f1897a.getApplicationContext(), this.f1897a.f1476i));
            this.f1897a.f1473f.setText(C0312i.m2001a(this.f1897a.getApplicationContext(), this.f1897a.f1477j));
        } else if (i == 1) {
            this.f1897a.f1472e.setText(C0312i.m2001a(this.f1897a.getApplicationContext(), this.f1897a.f1474g));
            this.f1897a.f1473f.setText(C0312i.m2001a(this.f1897a.getApplicationContext(), this.f1897a.f1475h));
        } else {
            this.f1897a.f1472e.setText(C0312i.m2001a(this.f1897a.getApplicationContext(), this.f1897a.f1478k));
            this.f1897a.f1473f.setText(C0312i.m2001a(this.f1897a.getApplicationContext(), this.f1897a.f1479l));
        }
    }
}
