package com.lostnet.fw.ui;

import android.support.v4.view.ae;
import android.view.View;
import com.google.android.vending.licensing.APKExpansionPolicy;
import com.lostnet.fw.C0328k;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.p009d.C0313j;

class ab extends ae {
    final /* synthetic */ DetailsGeoActivity f1560a;

    private ab(DetailsGeoActivity detailsGeoActivity) {
        this.f1560a = detailsGeoActivity;
    }

    public Object mo754a(View view, int i) {
        int i2 = 0;
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                i2 = C0328k.detailsSlideHourly;
                break;
            case 1:
                i2 = C0328k.detailsSlideDaily;
                break;
            case 2:
                if (!"com.lostnet.fw.free".equals(this.f1560a.getResources().getString(C0330m.package_name)) && C0313j.m2004a(this.f1560a)) {
                    i2 = C0328k.detailsSlideMonth;
                    break;
                }
                i2 = C0328k.detailsSlideEmpty;
                break;
                break;
        }
        return this.f1560a.findViewById(i2);
    }

    public void mo755a(View view, int i, Object obj) {
    }

    public boolean mo17a(View view, Object obj) {
        return view == ((View) obj);
    }

    public int mo756b() {
        return 3;
    }
}
