package com.ppu.fba.p008c;

import java.io.Serializable;
import java.math.BigInteger;

public class C0302g extends C0298c implements Serializable {
    private static final long serialVersionUID = -2224157893163891331L;
    public BigInteger f1386e = new BigInteger("0", 10);
    public int f1387f;
    public int f1388g;

    public C0302g(C0298c c0298c) {
        this.a = c0298c.f1378a;
        this.b = c0298c.f1379b;
        this.f1386e = BigInteger.ZERO;
        this.c = c0298c.f1380c;
        this.d = c0298c.f1381d;
        this.f1387f = 0;
        this.f1388g = 0;
    }

    public void m1959a(BigInteger bigInteger, BigInteger bigInteger2, int i, int i2, int i3, int i4, int i5) {
        this.a = this.a.add(bigInteger);
        this.b = this.b.add(bigInteger2);
        this.c += i;
        this.d += i2;
        this.f1387f += i3;
        this.f1388g += i4;
        this.f1386e = this.f1386e.add(BigInteger.valueOf((long) i5));
    }
}
