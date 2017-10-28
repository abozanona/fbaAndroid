package com.google.tagmanager;

import android.text.TextUtils;

class ay {
    private final long f977a;
    private final long f978b;
    private final long f979c;
    private String f980d;

    ay(long j, long j2, long j3) {
        this.f977a = j;
        this.f978b = j2;
        this.f979c = j3;
    }

    long m1381a() {
        return this.f977a;
    }

    void m1382a(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.f980d = str;
        }
    }

    long m1383b() {
        return this.f979c;
    }

    String m1384c() {
        return this.f980d;
    }
}
