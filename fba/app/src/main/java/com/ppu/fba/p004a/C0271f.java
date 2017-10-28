package com.ppu.fba.p004a;

import com.ppu.fba.FirewallApplication;
import java.io.Serializable;

public abstract class C0271f implements Serializable {
    private static final long serialVersionUID = -6324093806192634259L;

    public String m1871a() {
        return FirewallApplication.m1851a().getResources().getString(mo734e());
    }

    protected boolean m1872a(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str2 != null && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public abstract int mo734e();
}
