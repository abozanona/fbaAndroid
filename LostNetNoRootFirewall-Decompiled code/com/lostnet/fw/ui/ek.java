package com.lostnet.fw.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import java.util.ArrayList;

class ek implements OnCheckedChangeListener {
    ArrayList f1815a;
    final /* synthetic */ SectionGeoListFragment f1816b;

    public ek(SectionGeoListFragment sectionGeoListFragment, ArrayList arrayList) {
        this.f1816b = sectionGeoListFragment;
        arrayList.clear();
        this.f1815a = arrayList;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f1815a.add(Boolean.TRUE);
        } else {
            this.f1815a.clear();
        }
    }
}
