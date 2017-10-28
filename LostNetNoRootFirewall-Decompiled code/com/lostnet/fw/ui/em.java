package com.lostnet.fw.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.lostnet.fw.p008c.C0298c;
import com.lostnet.fw.p009d.C0309f;
import java.util.ArrayList;
import java.util.HashMap;

class em extends eg {
    final /* synthetic */ SectionGeoListFragment f1822a;
    private final ArrayList f1823c;
    private final HashMap f1824d;

    public em(SectionGeoListFragment sectionGeoListFragment, Context context, ArrayList arrayList, HashMap hashMap, boolean z) {
        this.f1822a = sectionGeoListFragment;
        super(sectionGeoListFragment, z);
        this.f1823c = arrayList;
        this.f1824d = hashMap;
    }

    public View mo765a(int i, View view, ViewGroup viewGroup, boolean z) {
        String str = (String) this.f1823c.get(i);
        return m2133a(null, str, (C0298c) this.f1824d.get(str), C0309f.m1978b(str), i, view, viewGroup, z);
    }

    public int getCount() {
        return this.f1823c.size();
    }

    public Object getItem(int i) {
        return C0309f.m1978b((String) this.f1823c.get(i));
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
