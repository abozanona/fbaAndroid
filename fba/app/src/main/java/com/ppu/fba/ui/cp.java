package com.ppu.fba.ui;

import android.support.v4.view.ViewPager;
import android.widget.TabHost.OnTabChangeListener;

class cp implements OnTabChangeListener {
    final /* synthetic */ ViewPager f1738a;
    final /* synthetic */ LogsActivity f1739b;

    cp(LogsActivity logsActivity, ViewPager viewPager) {
        this.f1739b = logsActivity;
        this.f1738a = viewPager;
    }

    public void onTabChanged(String str) {
        if (str.equals("malware")) {
            this.f1738a.m346a(this.f1739b.f1482b, true);
        } else if (str.equals("apps")) {
            this.f1738a.m346a(this.f1739b.f1483c, true);
        } else if (str.equals("geo")) {
            this.f1738a.m346a(this.f1739b.f1484d, true);
        } else if (str.equals("ads")) {
            this.f1738a.m346a(this.f1739b.f1485e, true);
        } else {
            this.f1738a.m346a(this.f1739b.f1486f, true);
        }
    }
}
