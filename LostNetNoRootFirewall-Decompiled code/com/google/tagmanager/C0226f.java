package com.google.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class C0226f extends as {
    private static final String f1181a = FunctionType.APP_NAME.toString();
    private final Context f1182b;

    public C0226f(Context context) {
        super(f1181a, new String[0]);
        this.f1182b = context;
    }

    public Value mo591a(Map map) {
        try {
            PackageManager packageManager = this.f1182b.getPackageManager();
            return es.m1687f(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.f1182b.getPackageName(), 0)).toString());
        } catch (Throwable e) {
            bs.m1439a("App name is not found.", e);
            return es.m1686f();
        }
    }

    public boolean mo592a() {
        return true;
    }
}
