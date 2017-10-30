package com.ppu.fba.ui;

import com.ppu.fba.p008c.C0298c;
import com.ppu.fba.p009d.C0309f;
import java.util.Comparator;
import java.util.HashMap;

public class bl implements Comparator {
    final /* synthetic */ HashMap f1678a;
    final /* synthetic */ DetailsAppActivity f1679b;

    bl(DetailsAppActivity detailsAppActivity, HashMap hashMap) {
        this.f1679b = detailsAppActivity;
        this.f1678a = hashMap;
    }

    public int m2089a(Integer num, Integer num2) {
        C0298c c0298c = (C0298c) this.f1678a.get(num);
        C0298c c0298c2 = (C0298c) this.f1678a.get(num2);
        int compareTo = c0298c2.f1379b.add(c0298c2.f1378a).compareTo(c0298c.f1379b.add(c0298c.f1378a));
        return compareTo != 0 ? compareTo : C0309f.m1980c(C0309f.m1974a(num.intValue())).compareTo(C0309f.m1980c(C0309f.m1974a(num2.intValue())));
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2089a((Integer) obj, (Integer) obj2);
    }
}
