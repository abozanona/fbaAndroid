package com.google.tagmanager;

import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

abstract class cp extends as {
    private static final String f943a = Key.ARG0.toString();
    private static final String f944b = Key.ARG1.toString();

    public cp(String str) {
        super(str, f943a, f944b);
    }

    public Value mo591a(Map map) {
        for (Value value : map.values()) {
            if (value == es.m1686f()) {
                return es.m1687f(Boolean.valueOf(false));
            }
        }
        Value value2 = (Value) map.get(f943a);
        Value value3 = (Value) map.get(f944b);
        boolean a = (value2 == null || value3 == null) ? false : mo607a(value2, value3, map);
        return es.m1687f(Boolean.valueOf(a));
    }

    public boolean mo592a() {
        return true;
    }

    protected abstract boolean mo607a(Value value, Value value2, Map map);
}
