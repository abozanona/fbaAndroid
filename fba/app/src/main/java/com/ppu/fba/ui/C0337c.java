package com.ppu.fba.ui;

import android.support.v4.app.C0017n;
import android.support.v4.app.C0023t;
import android.support.v4.app.Fragment;
import com.google.android.vending.licensing.APKExpansionPolicy;
import com.ppu.fba.free.R;
import java.util.Locale;

public class C0337c extends C0023t {
    final /* synthetic */ DashboardActivity dashboardActivity;

    public C0337c(DashboardActivity dashboardActivity, C0017n c0017n) {
        this.dashboardActivity = dashboardActivity;
        super(c0017n);
    }

    public Fragment mo757a(int i) {
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                return this.dashboardActivity.f1448o;
            case 1:
                return this.dashboardActivity.f1449p;
            case 2:
                return this.dashboardActivity.f1450q;
            default:
                return null;
        }
    }

    public int mo756b() {
        return 3;
    }

    public CharSequence mo758c(int i) {
        Locale locale = Locale.getDefault();
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                return this.dashboardActivity.getString(R.string.title_section1).toUpperCase(locale);
            case 1:
                return this.dashboardActivity.getString(R.string.title_section2).toUpperCase(locale);
            case 2:
                return this.dashboardActivity.getString(R.string.title_section3).toUpperCase(locale);
            default:
                return null;
        }
    }
}
