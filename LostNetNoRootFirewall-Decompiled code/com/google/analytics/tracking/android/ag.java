package com.google.analytics.tracking.android;

import android.text.TextUtils;

class ag {
    private String f813a;
    private final long f814b;
    private final long f815c;
    private String f816d = "https:";

    ag(String str, long j, long j2) {
        this.f813a = str;
        this.f814b = j;
        this.f815c = j2;
    }

    String m1110a() {
        return this.f813a;
    }

    void m1111a(String str) {
        this.f813a = str;
    }

    long m1112b() {
        return this.f814b;
    }

    void m1113b(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim()) && str.toLowerCase().startsWith("http:")) {
            this.f816d = "http:";
        }
    }

    long m1114c() {
        return this.f815c;
    }

    String m1115d() {
        return this.f816d;
    }
}
