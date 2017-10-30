package com.ppu.fba.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ae implements OnItemSelectedListener {
    final /* synthetic */ ad f1564a;

    ae(ad adVar) {
        this.f1564a = adVar;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        switch (i) {
            case 0 /*0*/:
                this.f1564a.f1561P = ah.ALL;
                break;
            case 1:
                this.f1564a.f1561P = ah.SEEN;
                break;
            case 2:
                this.f1564a.f1561P = ah.DOWNLOADED;
                break;
            case 3:
                this.f1564a.f1561P = ah.SYSTEM;
                break;
            case 4:
                this.f1564a.f1561P = ah.ALLOWED;
                break;
            case 5:
                this.f1564a.f1561P = ah.WIFIONLY;
                break;
            case 6:
                this.f1564a.f1561P = ah.BLOCKED;
                break;
        }
        this.f1564a.m2057c(adapterView.getContext());
    }

    public void onNothingSelected(AdapterView adapterView) {
        this.f1564a.f1561P = ah.DOWNLOADED;
        this.f1564a.m2057c(adapterView.getContext());
    }
}
