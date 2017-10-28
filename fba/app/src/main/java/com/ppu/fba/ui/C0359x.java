package com.ppu.fba.ui;

import com.ppu.fba.p008c.C0298c;
import com.ppu.fba.p009d.C0308e;
import java.util.Comparator;
import java.util.HashMap;

class C0359x implements Comparator {
    final /* synthetic */ DetailsGeoActivity f1907a;
    final /* synthetic */ HashMap f1908b;

    C0359x(DetailsGeoActivity detailsGeoActivity, HashMap hashMap) {
        this.f1907a = detailsGeoActivity;
        this.f1908b = hashMap;
    }

    public int m2153a(Integer num, Integer num2) {
        C0298c c0298c = (C0298c) this.f1908b.get(num);
        C0298c c0298c2 = (C0298c) this.f1908b.get(num2);
        int compareTo = c0298c2.f1379b.add(c0298c2.f1378a).compareTo(c0298c.f1379b.add(c0298c.f1378a));
        return compareTo != 0 ? compareTo : C0308e.m1964a(num.intValue()).compareTo(C0308e.m1964a(num2.intValue()));
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2153a((Integer) obj, (Integer) obj2);
    }
}
