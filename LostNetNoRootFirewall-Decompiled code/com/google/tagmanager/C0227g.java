package com.google.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class C0227g extends as {
    private static final String f1183a = FunctionType.APP_VERSION.toString();
    private final Context f1184b;

    public C0227g(Context context) {
        super(f1183a, new String[0]);
        this.f1184b = context;
    }

    public Value mo591a(Map map) {
        try {
            return es.m1687f(Integer.valueOf(this.f1184b.getPackageManager().getPackageInfo(this.f1184b.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            bs.m1438a("Package name " + this.f1184b.getPackageName() + " not found. " + e.getMessage());
            return es.m1686f();
        }
    }

    public boolean mo592a() {
        return true;
    }
}
