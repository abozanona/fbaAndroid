package com.ppu.fba.ui;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import com.ppu.fba.free.R;

public class en extends PagerAdapter {
    final /* synthetic */ SectionGeoListFragment f1825a;

    public en(SectionGeoListFragment sectionGeoListFragment) {
        this.f1825a = sectionGeoListFragment;
    }

    public Object mo754a(View view, int i) {
        int i2 = 0;
        switch (i) {
            case 0 /*0*/:
                i2 = R.id.geoMap;
                break;
            case 1:
                i2 = R.id.geoList;
                break;
        }
        return view.findViewById(i2);
    }

    public void mo755a(View view, int i, Object obj) {
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == ((View) obj);
    }

    public int getCount() {
        return 2;
    }
}
