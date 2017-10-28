package com.lostnet.fw.ui;

import android.app.ActionBar;
import android.support.v4.view.br;
import com.google.android.vending.licensing.APKExpansionPolicy;

class C0335a extends br {
    final /* synthetic */ DashboardActivity f1554a;
    final /* synthetic */ ActionBar f1555b;

    C0335a(DashboardActivity dashboardActivity, ActionBar actionBar) {
        this.f1554a = dashboardActivity;
        this.f1555b = actionBar;
    }

    public void mo100a(int i) {
        this.f1555b.setSelectedNavigationItem(i);
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                this.f1554a.f1448o.m2056b(this.f1554a);
                return;
            case 1:
                this.f1554a.f1449p.m2056b(this.f1554a);
                return;
            case 2:
                this.f1554a.f1450q.m2056b(this.f1554a);
                return;
            default:
                return;
        }
    }
}
