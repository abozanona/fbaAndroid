package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

abstract class eq extends as {
    public eq(String str, String... strArr) {
        super(str, strArr);
    }

    public Value mo591a(Map map) {
        mo593b(map);
        return es.m1686f();
    }

    public boolean mo592a() {
        return false;
    }

    public abstract void mo593b(Map map);
}
