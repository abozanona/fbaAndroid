package com.lostnet.fw.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.google.android.vending.licensing.APKExpansionPolicy;

class ea implements OnItemSelectedListener {
    final /* synthetic */ SectionGeoListFragment f1795a;

    ea(SectionGeoListFragment sectionGeoListFragment) {
        this.f1795a = sectionGeoListFragment;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                this.f1795a.f1507P = bi.REGION_ALL;
                break;
            case 1:
                this.f1795a.f1507P = bi.COUNTRY_ALL;
                break;
            case 2:
                this.f1795a.f1507P = bi.REGION_SEEN;
                break;
            case 3:
                this.f1795a.f1507P = bi.COUNTRY_SEEN;
                break;
            case 4:
                this.f1795a.f1507P = bi.REGION_ALLOWED;
                break;
            case 5:
                this.f1795a.f1507P = bi.COUNTRY_ALLOWED;
                break;
            case 6:
                this.f1795a.f1507P = bi.REGION_BLOCKED;
                break;
            case 7:
                this.f1795a.f1507P = bi.COUNTRY_BLOCKED;
                break;
        }
        this.f1795a.m2057c(adapterView.getContext());
    }

    public void onNothingSelected(AdapterView adapterView) {
        this.f1795a.f1507P = bi.REGION_ALL;
        this.f1795a.m2057c(adapterView.getContext());
    }
}
