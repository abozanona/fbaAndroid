package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class ct extends as {
    private static final String f1050a = FunctionType.RANDOM.toString();

    public ct() {
        super(f1050a, new String[0]);
    }

    public Value mo591a(Map map) {
        return es.m1687f(Long.valueOf(Math.round(Math.random() * 2.147483647E9d)));
    }

    public boolean mo592a() {
        return false;
    }
}
