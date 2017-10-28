package com.ppu.fba.ui;

import com.ppu.fba.p009d.C0308e;
import java.util.Comparator;

class fa implements Comparator {
    final /* synthetic */ ToolSnifferActivity f1846a;

    fa(ToolSnifferActivity toolSnifferActivity) {
        this.f1846a = toolSnifferActivity;
    }

    public int m2142a(Integer num, Integer num2) {
        String a = C0308e.m1964a(num.intValue());
        String a2 = C0308e.m1964a(num2.intValue());
        return (a == null || a2 == null) ? 0 : a.compareTo(a2);
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2142a((Integer) obj, (Integer) obj2);
    }
}
