package com.ppu.fba.p007b;

import android.content.ContextWrapper;
import com.ppu.fba.p009d.C0308e;
import com.ppu.fba.free.R;


public class C0291c {
    public C0290b f1366a = new C0290b();

    //todo abozanona has changed here
    private void m1924a(ContextWrapper contextWrapper, C0290b c0290b) {
        for (Object put : C0308e.m1965a()) {
            c0290b.put((Integer)put, new C0289a(0));
        }
    }

    public synchronized void m1925a(ContextWrapper contextWrapper) {
        C0290b c0290b = new C0290b();
        m1924a(contextWrapper, c0290b);
        //todo abozanona has changed here
        for (Object c0289a : c0290b.values()) {
            int i = ((C0289a)c0289a).f1363a;
            if (((C0289a) this.f1366a.get(Integer.valueOf(i))) == null) {
                this.f1366a.put(Integer.valueOf(i), c0289a);
            }
        }
    }
}
