package com.ppu.fba.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.google.android.vending.licensing.APKExpansionPolicy;

class af implements OnItemSelectedListener {
    final /* synthetic */ ad f1565a;

    af(ad adVar) {
        this.f1565a = adVar;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                this.f1565a.f1562Q = an.TODAY;
                break;
            case 1:
                this.f1565a.f1562Q = an.SEVEN_DAYS;
                break;
            case 2:
                this.f1565a.f1562Q = an.THIRTY_DAYS;
                break;
        }
        this.f1565a.m2057c(adapterView.getContext());
    }

    public void onNothingSelected(AdapterView adapterView) {
        this.f1565a.f1562Q = an.TODAY;
        this.f1565a.m2057c(adapterView.getContext());
    }
}
