package com.lostnet.fw.ui;

import android.support.v4.view.br;
import android.widget.TabHost;

class bf extends br {
    final /* synthetic */ SectionGeoListFragment f1660a;
    final /* synthetic */ TabHost f1661b;

    bf(SectionGeoListFragment sectionGeoListFragment, TabHost tabHost) {
        this.f1660a = sectionGeoListFragment;
        this.f1661b = tabHost;
    }

    public void mo100a(int i) {
        this.f1661b.setCurrentTab(i);
    }
}
