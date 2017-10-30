package com.ppu.fba.ui;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.widget.TabHost;
import com.ppu.fba.p009d.C0312i;

public class C0347l extends SimpleOnPageChangeListener {
    final /* synthetic */ DetailsAppActivity f1880a;
    final /* synthetic */ TabHost f1881b;

    C0347l(DetailsAppActivity detailsAppActivity, TabHost tabHost) {
        this.f1880a = detailsAppActivity;
        this.f1881b = tabHost;
    }

    public void onPageSelected(int i) {
        this.f1881b.setCurrentTab(i);
        if (i == 0) {
            this.f1880a.f1457e.setText(C0312i.m2001a(this.f1880a.getApplicationContext(), this.f1880a.f1459g));
            this.f1880a.f1458f.setText(C0312i.m2001a(this.f1880a.getApplicationContext(), this.f1880a.f1460h));
        } else if (i == 1) {
            this.f1880a.f1457e.setText(C0312i.m2001a(this.f1880a.getApplicationContext(), this.f1880a.f1461i));
            this.f1880a.f1458f.setText(C0312i.m2001a(this.f1880a.getApplicationContext(), this.f1880a.f1462j));
        } else {
            this.f1880a.f1457e.setText(C0312i.m2001a(this.f1880a.getApplicationContext(), this.f1880a.f1463k));
            this.f1880a.f1458f.setText(C0312i.m2001a(this.f1880a.getApplicationContext(), this.f1880a.f1464l));
        }
    }
}
