package com.ppu.fba.p008c;

import android.annotation.SuppressLint;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class C0297b implements Serializable {
    private static final long serialVersionUID = 5597154495154243882L;
    protected HashMap f1373a = new HashMap();
    protected HashMap f1374b = new HashMap();
    protected HashMap f1375c = new HashMap();
    protected HashMap f1376d = new HashMap();
    public transient boolean f1377e = false;

    private C0298c m1932a(HashMap hashMap, int i) {
        Integer valueOf = Integer.valueOf(i);
        C0298c c0298c = (C0298c) hashMap.get(valueOf);
        if (c0298c != null) {
            return c0298c;
        }
        //todo abozanona
        c0298c = new C0302g(c0298c);
        hashMap.put(valueOf, c0298c);
        return c0298c;
    }

    private synchronized void m1933a(HashMap hashMap, int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, int i3, int i4, int i5, int i6, int i7) {
        HashMap hashMap2;
        HashMap hashMap3 = (HashMap) hashMap.get(Integer.valueOf(i));
        if (hashMap3 == null) {
            hashMap2 = new HashMap();
            hashMap.put(Integer.valueOf(i), hashMap2);
        } else {
            hashMap2 = hashMap3;
        }
        m1940a(hashMap2, i2, bigInteger, bigInteger2, i3, i4, i5, i6, i7);
        this.f1377e = true;
    }

    private HashMap m1934b(HashMap hashMap, int i) {
        Integer valueOf = Integer.valueOf(i);
        HashMap hashMap2 = (HashMap) hashMap.get(valueOf);
        if (hashMap2 != null) {
            return hashMap2;
        }
        hashMap2 = new HashMap();
        hashMap.put(valueOf, hashMap2);
        return hashMap2;
    }

    public synchronized C0298c m1935a(int i) {
        return m1932a(this.f1373a, i);
    }

    public synchronized C0298c m1936a(int i, int i2) {
        return m1932a(m1942b(i), i2);
    }

    public Set m1937a() {
        return this.f1373a.keySet();
    }

    public void m1938a(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, int i3, int i4, int i5, int i6, int i7) {
        m1933a(this.f1374b, i, i2, bigInteger, bigInteger2, i3, i4, i5, i6, i7);
    }

    public void m1939a(int i, BigInteger bigInteger, BigInteger bigInteger2, int i2, int i3, int i4, int i5, int i6) {
        m1940a(this.f1373a, i, bigInteger, bigInteger2, i2, i3, i4, i5, i6);
    }

    public synchronized void m1940a(HashMap hashMap, int i, BigInteger bigInteger, BigInteger bigInteger2, int i2, int i3, int i4, int i5, int i6) {
        Integer valueOf = Integer.valueOf(i);
        C0298c c0298c = (C0298c) hashMap.get(valueOf);
        if (c0298c == null) {
            //todo abozanona
            c0298c = new C0302g(c0298c);
            hashMap.put(valueOf, c0298c);
        }
        c0298c.f1378a = c0298c.f1378a.add(bigInteger);
        c0298c.f1379b = c0298c.f1379b.add(bigInteger2);
        c0298c.f1380c += i2;
        c0298c.f1381d += i3;
        C0302g c0302g = (C0302g) c0298c;
        c0302g.f1387f += i4;
        c0302g.f1388g += i5;
        c0302g.f1386e = c0302g.f1386e.add(BigInteger.valueOf((long) i6));
        this.f1377e = true;
    }

    public synchronized C0298c m1941b(int i, int i2) {
        return m1932a(m1948d(i), i2);
    }

    public synchronized HashMap m1942b(int i) {
        return m1934b(this.f1374b, i);
    }

    public Set m1943b() {
        return this.f1375c.keySet();
    }

    public void m1944b(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, int i3, int i4, int i5, int i6, int i7) {
        m1933a(this.f1376d, i, i2, bigInteger, bigInteger2, i3, i4, i5, i6, i7);
    }

    public void m1945b(int i, BigInteger bigInteger, BigInteger bigInteger2, int i2, int i3, int i4, int i5, int i6) {
        m1940a(this.f1375c, i, bigInteger, bigInteger2, i2, i3, i4, i5, i6);
    }

    public synchronized C0298c m1946c(int i) {
        return m1932a(this.f1375c, i);
    }

    public boolean m1947c() {
        return this.f1377e;
    }

    public synchronized HashMap m1948d(int i) {
        return m1934b(this.f1376d, i);
    }
}
