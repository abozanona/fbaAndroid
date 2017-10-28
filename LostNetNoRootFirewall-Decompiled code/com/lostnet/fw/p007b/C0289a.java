package com.lostnet.fw.p007b;

import java.io.Serializable;

public class C0289a implements Serializable {
    private static final long serialVersionUID = 1589480455993179491L;
    public int f1363a;
    public transient boolean f1364b = true;
    private int f1365c;

    public C0289a(int i) {
        this.f1363a = i;
        this.f1365c = 0;
        this.f1364b = true;
    }

    public int m1919a() {
        return this.f1365c & 3;
    }

    public void m1920a(int i) {
        this.f1365c = (this.f1365c & 56) | i;
        this.f1364b = true;
    }

    public int m1921b() {
        return this.f1365c & 56;
    }

    public void m1922b(int i) {
        this.f1365c |= i;
        this.f1364b = true;
    }

    public void m1923c(int i) {
        this.f1365c &= i ^ -1;
        this.f1364b = true;
    }
}
