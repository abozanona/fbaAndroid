package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Logger.LogLevel;

final class bs {
    @VisibleForTesting
    static Logger f1016a = new ah();

    public static Logger m1436a() {
        return f1016a.getClass() == by.class ? null : f1016a;
    }

    public static void m1437a(Logger logger) {
        if (logger == null) {
            f1016a = new by();
        } else {
            f1016a = logger;
        }
    }

    public static void m1438a(String str) {
        f1016a.mo611e(str);
    }

    public static void m1439a(String str, Throwable th) {
        f1016a.mo612e(str, th);
    }

    public static LogLevel m1440b() {
        return f1016a.getLogLevel();
    }

    public static void m1441b(String str) {
        f1016a.mo619w(str);
    }

    public static void m1442b(String str, Throwable th) {
        f1016a.mo620w(str, th);
    }

    public static void m1443c(String str) {
        f1016a.mo614i(str);
    }

    public static void m1444d(String str) {
        f1016a.mo609d(str);
    }

    public static void m1445e(String str) {
        f1016a.mo617v(str);
    }
}
