package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class C0217b extends as {
    private static final String f981a = FunctionType.ADVERTISING_TRACKING_ENABLED.toString();

    public C0217b() {
        super(f981a, new String[0]);
    }

    public Value mo591a(Map map) {
        return es.m1687f(Boolean.valueOf(true));
    }

    public boolean mo592a() {
        return true;
    }
}
