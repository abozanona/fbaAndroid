package com.ppu.fba.ui;

import android.support.v4.view.ViewPager;
import android.widget.TabHost.OnTabChangeListener;
import com.ppu.fba.p009d.C0312i;

class C0346k implements OnTabChangeListener {
    final /* synthetic */ DetailsAppActivity f1878a;
    final /* synthetic */ ViewPager f1879b;

    C0346k(DetailsAppActivity detailsAppActivity, ViewPager viewPager) {
        this.f1878a = detailsAppActivity;
        this.f1879b = viewPager;
    }

    public void onTabChanged(String str) {
        if (str.equals("one")) {
            this.f1879b.m346a(0, true);
            this.f1878a.f1457e.setText(C0312i.m2001a(this.f1878a.getApplicationContext(), this.f1878a.f1459g));
            this.f1878a.f1458f.setText(C0312i.m2001a(this.f1878a.getApplicationContext(), this.f1878a.f1460h));
        } else if (str.equals("seven")) {
            this.f1879b.m346a(1, true);
            this.f1878a.f1457e.setText(C0312i.m2001a(this.f1878a.getApplicationContext(), this.f1878a.f1461i));
            this.f1878a.f1458f.setText(C0312i.m2001a(this.f1878a.getApplicationContext(), this.f1878a.f1462j));
        } else {
            this.f1879b.m346a(2, true);
            this.f1878a.f1457e.setText(C0312i.m2001a(this.f1878a.getApplicationContext(), this.f1878a.f1463k));
            this.f1878a.f1458f.setText(C0312i.m2001a(this.f1878a.getApplicationContext(), this.f1878a.f1464l));
        }
    }
}
