package com.lostnet.fw.p007b;

import java.io.Serializable;

public class C0292d implements Serializable {
    private static final long serialVersionUID = 505635745611124599L;
    public final int f1367a;
    public transient boolean f1368b;
    public int f1369c;

    public C0292d(int i, int i2) {
        this.f1368b = true;
        this.f1367a = i;
        this.f1369c = i2;
        this.f1368b = true;
    }

    public C0292d(String str, int i) {
        this(i, 0);
    }
}
