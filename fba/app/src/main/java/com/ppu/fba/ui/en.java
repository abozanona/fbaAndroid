package com.ppu.fba.ui;

import android.support.v4.view.ae;
import android.view.View;
import com.google.android.vending.licensing.APKExpansionPolicy;

class en extends ae {
    final /* synthetic */ SectionGeoListFragment f1825a;

    private en(SectionGeoListFragment sectionGeoListFragment) {
        this.f1825a = sectionGeoListFragment;
    }

    public Object mo754a(View view, int i) {
        int i2 = 0;
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
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

    public boolean mo17a(View view, Object obj) {
        return view == ((View) obj);
    }

    public int mo756b() {
        return 2;
    }
}
