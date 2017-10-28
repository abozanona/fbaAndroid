package com.lostnet.fw.ui;

import android.support.v4.view.br;
import android.widget.TabHost;
import com.lostnet.fw.p009d.C0312i;

class C0355t extends br {
    final /* synthetic */ DetailsGeoActivity f1897a;
    final /* synthetic */ TabHost f1898b;

    C0355t(DetailsGeoActivity detailsGeoActivity, TabHost tabHost) {
        this.f1897a = detailsGeoActivity;
        this.f1898b = tabHost;
    }

    public void mo100a(int i) {
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
