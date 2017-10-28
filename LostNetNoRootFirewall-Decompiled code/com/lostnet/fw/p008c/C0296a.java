package com.lostnet.fw.p008c;

import android.text.format.Time;

public class C0296a {
    private static Time f1372a = new Time();

    public static synchronized long m1928a() {
        long c;
        synchronized (C0296a.class) {
            c = C0296a.m1930c() / 86400000;
        }
        return c;
    }

    public static synchronized long m1929b() {
        long c;
        synchronized (C0296a.class) {
            c = C0296a.m1930c() / 3600000;
        }
        return c;
    }

    public static synchronized long m1930c() {
        long toMillis;
        synchronized (C0296a.class) {
            f1372a.setToNow();
            f1372a.normalize(false);
            toMillis = f1372a.toMillis(false) + (f1372a.gmtoff * 1000);
        }
        return toMillis;
    }

    public static synchronized long m1931d() {
        long j;
        synchronized (C0296a.class) {
            j = f1372a.gmtoff * 1000;
        }
        return j;
    }
}
