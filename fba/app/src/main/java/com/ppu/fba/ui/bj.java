package com.ppu.fba.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import java.util.ArrayList;

public class bj implements OnCheckedChangeListener {
    ArrayList f1673a;
    final /* synthetic */ DashboardActivity f1674b;

    public bj(DashboardActivity dashboardActivity, ArrayList arrayList) {
        this.f1674b = dashboardActivity;
        arrayList.clear();
        this.f1673a = arrayList;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f1673a.add(Boolean.TRUE);
        } else {
            this.f1673a.clear();
        }
    }
}
