package com.lostnet.fw.ui;

import com.lostnet.fw.p009d.C0309f;
import java.util.Comparator;

class dy implements Comparator {
    final /* synthetic */ bg f1790a;

    dy(bg bgVar) {
        this.f1790a = bgVar;
    }

    public int m2130a(String str, String str2) {
        return (str == null || str2 == null) ? -1 : C0309f.m1980c(str).compareTo(C0309f.m1980c(str2));
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2130a((String) obj, (String) obj2);
    }
}
