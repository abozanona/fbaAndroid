package com.ppu.fba.ui;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.C0313j;

public class ab extends PagerAdapter {
    final /* synthetic */ DetailsGeoActivity f1560a;

    public ab(DetailsGeoActivity detailsGeoActivity) {
        this.f1560a = detailsGeoActivity;
    }

    public Object mo754a(View view, int i) {
        int i2 = 0;
        switch (i) {
            case 0 /*0*/:
                i2 = R.id.detailsSlideHourly;
                break;
            case 1:
                i2 = R.id.detailsSlideDaily;
                break;
            case 2:
                if (!"com.ppu.fba.free".equals(this.f1560a.getResources().getString(R.string.package_name)) && C0313j.m2004a(this.f1560a)) {
                    i2 = R.id.detailsSlideMonth;
                    break;
                }
                i2 = R.id.detailsSlideEmpty;
                break;
        }
        return this.f1560a.findViewById(i2);
    }

    public void mo755a(View view, int i, Object obj) {
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == ((View) obj);
    }

    public int getCount() {
        return 3;
    }
}
