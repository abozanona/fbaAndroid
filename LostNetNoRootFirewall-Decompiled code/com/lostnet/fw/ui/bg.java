package com.lostnet.fw.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.lostnet.fw.p009d.C0309f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class bg implements OnItemSelectedListener {
    final /* synthetic */ SectionGeoListFragment f1662a;

    bg(SectionGeoListFragment sectionGeoListFragment) {
        this.f1662a = sectionGeoListFragment;
    }

    private void m2087a() {
        this.f1662a.f1512V.setAdapter(new em(this.f1662a, this.f1662a.m30b(), C0309f.m1976a(), new HashMap(), false));
    }

    private void m2088b() {
        Object arrayList = new ArrayList(C0309f.m1979b());
        Collections.sort(arrayList, new dy(this));
        this.f1662a.f1512V.setAdapter(new ee(this.f1662a, this.f1662a.m30b(), arrayList, new HashMap(), false));
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (i == 0) {
            m2087a();
        } else {
            m2088b();
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
        m2087a();
    }
}
