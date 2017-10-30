package com.ppu.fba.ui;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.widget.TabHost;

public class cq extends SimpleOnPageChangeListener {
    final /* synthetic */ TabHost f1740a;
    final /* synthetic */ LogsActivity f1741b;

    cq(LogsActivity logsActivity, TabHost tabHost) {
        this.f1741b = logsActivity;
        this.f1740a = tabHost;
    }

    public void onPageSelected(int i) {
        this.f1740a.setCurrentTab(i);
        if (i == 0 || i != 1) {
        }
    }
}
