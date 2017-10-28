package com.ppu.fba.p004a;

import android.content.pm.ApplicationInfo;

public abstract class C0272g extends C0271f {
    private static final long serialVersionUID = 2708125601726505742L;

    public boolean m1874a(ApplicationInfo applicationInfo) {
        return applicationInfo == null ? false : m1872a(applicationInfo.packageName, mo735b());
    }

    public boolean m1875b(ApplicationInfo applicationInfo) {
        return applicationInfo == null ? false : m1872a(applicationInfo.packageName, mo736c());
    }

    protected String[] mo735b() {
        return new String[0];
    }

    public boolean m1877c(ApplicationInfo applicationInfo) {
        return applicationInfo == null ? false : m1872a(applicationInfo.packageName, mo733d());
    }

    protected String[] mo736c() {
        return new String[0];
    }

    protected String[] mo733d() {
        return new String[0];
    }
}
