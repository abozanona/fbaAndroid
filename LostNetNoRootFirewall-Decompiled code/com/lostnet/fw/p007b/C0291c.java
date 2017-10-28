package com.lostnet.fw.p007b;

import android.content.ContextWrapper;
import com.lostnet.fw.p009d.C0308e;

public class C0291c {
    public C0290b f1366a = new C0290b();

    private void m1924a(ContextWrapper contextWrapper, C0290b c0290b) {
        for (Integer put : C0308e.m1965a()) {
            c0290b.put(put, new C0289a(0));
        }
    }

    public synchronized void m1925a(ContextWrapper contextWrapper) {
        C0290b c0290b = new C0290b();
        m1924a(contextWrapper, c0290b);
        for (C0289a c0289a : c0290b.values()) {
            int i = c0289a.f1363a;
            if (((C0289a) this.f1366a.get(Integer.valueOf(i))) == null) {
                this.f1366a.put(Integer.valueOf(i), c0289a);
            }
        }
    }
}
