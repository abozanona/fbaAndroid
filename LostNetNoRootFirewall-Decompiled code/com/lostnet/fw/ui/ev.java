package com.lostnet.fw.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.android.vending.licensing.APKExpansionPolicy;

class ev extends BaseAdapter {
    final /* synthetic */ SettingsActivity f1837a;

    public ev(SettingsActivity settingsActivity) {
        this.f1837a = settingsActivity;
    }

    public int getCount() {
        return 6;
    }

    public Object getItem(int i) {
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                return this.f1837a.f1514a;
            case 1:
                return this.f1837a.f1515b;
            case 2:
                return this.f1837a.f1516c;
            case 3:
                return this.f1837a.f1517d;
            case 4:
                return this.f1837a.f1518e;
            case 5:
                return this.f1837a.f1519f;
            default:
                return null;
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                return this.f1837a.f1514a;
            case 1:
                return this.f1837a.f1515b;
            case 2:
                return this.f1837a.f1516c;
            case 3:
                return this.f1837a.f1517d;
            case 4:
                return this.f1837a.f1518e;
            case 5:
                return this.f1837a.f1519f;
            default:
                return null;
        }
    }
}
