package com.ppu.fba.ui;

import com.ppu.fba.p008c.C0298c;
import com.ppu.fba.p009d.C0309f;
import java.util.Comparator;
import java.util.HashMap;

public class dw implements Comparator {
    final /* synthetic */ HashMap f1786a;
    final /* synthetic */ SectionGeoListFragment f1787b;

    dw(SectionGeoListFragment sectionGeoListFragment, HashMap hashMap) {
        this.f1787b = sectionGeoListFragment;
        this.f1786a = hashMap;
    }

    public int m2129a(String str, String str2) {
        if (str == null || str2 == null) {
            return -1;
        }
        C0298c c0298c = (C0298c) this.f1786a.get(str);
        C0298c c0298c2 = (C0298c) this.f1786a.get(str2);
        if (c0298c == null || c0298c2 == null || c0298c2.f1379b == null || c0298c2.f1378a == null || c0298c.f1379b == null || c0298c.f1378a == null) {
            return -1;
        }
        int compareTo = c0298c2.f1379b.add(c0298c2.f1378a).compareTo(c0298c.f1379b.add(c0298c.f1378a));
        if (compareTo != 0) {
            return compareTo;
        }
        String c = C0309f.m1980c(str);
        String c2 = C0309f.m1980c(str2);
        return (c == null || c2 == null) ? -1 : c.compareTo(c2);
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2129a((String) obj, (String) obj2);
    }
}
