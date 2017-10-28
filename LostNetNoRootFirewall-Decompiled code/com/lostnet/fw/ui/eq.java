package com.lostnet.fw.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.google.android.vending.licensing.APKExpansionPolicy;

class eq implements OnItemClickListener {
    final /* synthetic */ boolean f1830a;
    final /* synthetic */ TextView f1831b;
    final /* synthetic */ SettingsActivity f1832c;

    eq(SettingsActivity settingsActivity, boolean z, TextView textView) {
        this.f1832c = settingsActivity;
        this.f1830a = z;
        this.f1831b = textView;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                this.f1832c.startActivityForResult(new Intent(this.f1832c, ProfileSelectActivity.class), 17);
                return;
            case 4:
                if (this.f1830a) {
                    new bt(this.f1831b).show(this.f1832c.getFragmentManager(), "officeWifi");
                    return;
                }
                return;
            case 5:
                if (this.f1830a) {
                    this.f1832c.m2066a();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
