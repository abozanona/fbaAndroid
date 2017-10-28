package com.lostnet.fw.ui;

import com.lostnet.fw.p008c.C0298c;
import com.lostnet.fw.p009d.C0308e;
import java.util.Comparator;
import java.util.HashMap;

class ag implements Comparator {
    final /* synthetic */ ad f1566a;
    final /* synthetic */ HashMap f1567b;

    ag(ad adVar, HashMap hashMap) {
        this.f1566a = adVar;
        this.f1567b = hashMap;
    }

    public int m2080a(Integer num, Integer num2) {
        C0298c c0298c = (C0298c) this.f1567b.get(num);
        C0298c c0298c2 = (C0298c) this.f1567b.get(num2);
        if (c0298c == null || c0298c2 == null) {
            return 0;
        }
        int compareTo = c0298c2.f1379b.add(c0298c2.f1378a).compareTo(c0298c.f1379b.add(c0298c.f1378a));
        return compareTo == 0 ? C0308e.m1964a(num.intValue()).compareTo(C0308e.m1964a(num2.intValue())) : compareTo;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2080a((Integer) obj, (Integer) obj2);
    }
}
