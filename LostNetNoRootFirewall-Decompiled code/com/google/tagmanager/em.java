package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class em extends as {
    private static final String f1151a = FunctionType.TIME.toString();

    public em() {
        super(f1151a, new String[0]);
    }

    public Value mo591a(Map map) {
        return es.m1687f(Long.valueOf(System.currentTimeMillis()));
    }

    public boolean mo592a() {
        return false;
    }
}
