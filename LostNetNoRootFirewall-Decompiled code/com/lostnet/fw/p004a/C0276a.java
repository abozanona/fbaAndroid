package com.lostnet.fw.p004a;

import java.io.Serializable;

public class C0276a implements Serializable {
    private static final long serialVersionUID = 4707787693569753824L;
    private C0284b f1329a;
    private int f1330b;
    private C0271f f1331c;

    public C0276a(C0284b c0284b, int i, C0271f c0271f) {
        this.f1329a = c0284b;
        this.f1330b = i;
        this.f1331c = c0271f;
    }

    public C0284b m1886a() {
        return this.f1329a;
    }

    public int m1887b() {
        return this.f1330b;
    }

    public String m1888c() {
        return this.f1331c.m1871a();
    }
}
