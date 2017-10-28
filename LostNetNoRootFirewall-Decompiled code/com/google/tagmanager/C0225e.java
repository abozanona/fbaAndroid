package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class C0225e extends as {
    private static final String f1138a = FunctionType.APP_ID.toString();
    private final Context f1139b;

    public C0225e(Context context) {
        super(f1138a, new String[0]);
        this.f1139b = context;
    }

    public Value mo591a(Map map) {
        return es.m1687f(this.f1139b.getPackageName());
    }

    public boolean mo592a() {
        return true;
    }
}
