package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class ag extends as {
    private static final String f947a = FunctionType.CUSTOM_VAR.toString();
    private static final String f948b = Key.NAME.toString();
    private static final String f949c = Key.DEFAULT_VALUE.toString();
    private final DataLayer f950d;

    public ag(DataLayer dataLayer) {
        super(f947a, f948b);
        this.f950d = dataLayer;
    }

    public Value mo591a(Map map) {
        Object obj = this.f950d.get(es.m1668a((Value) map.get(f948b)));
        if (obj != null) {
            return es.m1687f(obj);
        }
        Value value = (Value) map.get(f949c);
        return value != null ? value : es.m1686f();
    }

    public boolean mo592a() {
        return false;
    }
}
