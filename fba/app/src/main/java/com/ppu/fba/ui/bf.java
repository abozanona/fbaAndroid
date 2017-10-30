package com.ppu.fba.ui;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.widget.TabHost;

public class bf extends SimpleOnPageChangeListener {
    final /* synthetic */ SectionGeoListFragment f1660a;
    final /* synthetic */ TabHost f1661b;

    bf(SectionGeoListFragment sectionGeoListFragment, TabHost tabHost) {
        this.f1660a = sectionGeoListFragment;
        this.f1661b = tabHost;
    }

    public void onPageSelected(int i) {
        this.f1661b.setCurrentTab(i);
    }
}
