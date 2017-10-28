package com.lostnet.fw.p007b;

import android.content.ContextWrapper;

public class C0294f {
    public C0293e f1370a = new C0293e();

    private void m1926a(ContextWrapper contextWrapper, C0293e c0293e) {
    }

    public void m1927a(ContextWrapper contextWrapper) {
        C0293e c0293e = new C0293e();
        m1926a(contextWrapper, c0293e);
        for (C0292d c0292d : c0293e.values()) {
            int i = c0292d.f1367a;
            if (((C0292d) this.f1370a.get(Integer.valueOf(i))) == null) {
                this.f1370a.put(Integer.valueOf(i), c0292d);
            }
        }
    }
}
