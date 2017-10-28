package com.ppu.fba.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.google.android.vending.licensing.APKExpansionPolicy;

class eb implements OnItemSelectedListener {
    final /* synthetic */ SectionGeoListFragment f1796a;

    eb(SectionGeoListFragment sectionGeoListFragment) {
        this.f1796a = sectionGeoListFragment;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                this.f1796a.f1508Q = bn.TODAY;
                break;
            case 1:
                this.f1796a.f1508Q = bn.TEN_DAYS;
                break;
            case 2:
                this.f1796a.f1508Q = bn.THIRTY_DAYS;
                break;
        }
        this.f1796a.m2057c(adapterView.getContext());
    }

    public void onNothingSelected(AdapterView adapterView) {
        this.f1796a.f1508Q = bn.TODAY;
        this.f1796a.m2057c(adapterView.getContext());
    }
}
