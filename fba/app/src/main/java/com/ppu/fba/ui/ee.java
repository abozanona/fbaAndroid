package com.ppu.fba.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ppu.fba.p008c.C0298c;
import com.ppu.fba.p009d.C0309f;
import java.util.ArrayList;
import java.util.HashMap;

class ee extends eg {
    final /* synthetic */ SectionGeoListFragment f1802a;
    private final ArrayList f1803c;
    private final HashMap f1804d;

    public ee(SectionGeoListFragment sectionGeoListFragment, Context context, ArrayList arrayList, HashMap hashMap, boolean z) {
        this.f1802a = sectionGeoListFragment;
        super(sectionGeoListFragment, z);
        this.f1803c = arrayList;
        this.f1804d = hashMap;
    }

    public View mo765a(int i, View view, ViewGroup viewGroup, boolean z) {
        String str = (String) this.f1803c.get(i);
        String c = C0309f.m1980c(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return m2133a(C0309f.m1984e(str), c, (C0298c) this.f1804d.get(str), arrayList, i, view, viewGroup, z);
    }

    public int getCount() {
        return this.f1803c.size();
    }

    public Object getItem(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C0309f.m1980c((String) this.f1803c.get(i)));
        return arrayList;
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
