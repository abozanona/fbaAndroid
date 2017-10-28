package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class C0216a extends as {
    private static final String f938a = FunctionType.ADVERTISER_ID.toString();
    private final Context f939b;

    public C0216a(Context context) {
        super(f938a, new String[0]);
        this.f939b = context;
    }

    public Value mo591a(Map map) {
        return es.m1686f();
    }

    public boolean mo592a() {
        return true;
    }
}
