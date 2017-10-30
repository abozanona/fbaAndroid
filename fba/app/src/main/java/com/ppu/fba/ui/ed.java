package com.ppu.fba.ui;

import com.ppu.fba.p008c.C0298c;
import java.util.Comparator;
import java.util.HashMap;

public class ed implements Comparator {
    final /* synthetic */ HashMap f1798a;
    final /* synthetic */ SectionGeoListFragment f1799b;

    ed(SectionGeoListFragment sectionGeoListFragment, HashMap hashMap) {
        this.f1799b = sectionGeoListFragment;
        this.f1798a = hashMap;
    }

    public int m2131a(String str, String str2) {
        if (str == null || str2 == null) {
            return -1;
        }
        C0298c c0298c = (C0298c) this.f1798a.get(str);
        C0298c c0298c2 = (C0298c) this.f1798a.get(str2);
        if (c0298c == null || c0298c2 == null || c0298c2.f1379b == null || c0298c2.f1378a == null || c0298c.f1379b == null || c0298c.f1378a == null) {
            return -1;
        }
        int compareTo = c0298c2.f1379b.add(c0298c2.f1378a).compareTo(c0298c.f1379b.add(c0298c.f1378a));
        return compareTo == 0 ? str.compareTo(str2) : compareTo;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2131a((String) obj, (String) obj2);
    }
}
