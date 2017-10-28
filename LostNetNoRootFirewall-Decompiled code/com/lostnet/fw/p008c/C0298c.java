package com.lostnet.fw.p008c;

import java.io.Serializable;
import java.math.BigInteger;

public class C0298c implements Serializable {
    private static final long serialVersionUID = 8105362775792899560L;
    public BigInteger f1378a = new BigInteger("0", 10);
    public BigInteger f1379b = new BigInteger("0", 10);
    public int f1380c;
    public int f1381d;

    public void m1949a(C0298c c0298c) {
        if (c0298c != null) {
            this.f1378a = this.f1378a.add(c0298c.f1378a);
            this.f1379b = this.f1379b.add(c0298c.f1379b);
            this.f1380c += c0298c.f1380c;
            this.f1381d = c0298c.f1381d;
        }
    }
}
