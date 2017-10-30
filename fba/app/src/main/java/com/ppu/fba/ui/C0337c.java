package com.ppu.fba.ui;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.Fragment;
import com.ppu.fba.free.R;
import java.util.Locale;

public class C0337c extends FragmentStatePagerAdapter {
    final /* synthetic */ DashboardActivity dashboardActivity;

    public C0337c(DashboardActivity dashboardActivity, FragmentManager c0017n) {
        super(c0017n);
        this.dashboardActivity = dashboardActivity;
    }

    public cd getItem(int i) {
        switch (i) {
            case 0 /*0*/:
                return this.dashboardActivity.f1448o;
            case 1:
                return this.dashboardActivity.f1449p;
            case 2:
                return this.dashboardActivity.f1450q;
            default:
                return null;
        }
    }

    public int getCount() {
        return 3;
    }

    public CharSequence mo758c(int i) {
        Locale locale = Locale.getDefault();
        switch (i) {
            case 0 /*0*/:
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
