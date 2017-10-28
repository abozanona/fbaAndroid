package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class ar extends as {
    private static final String f968a = FunctionType.EVENT.toString();
    private final dn f969b;

    public ar(dn dnVar) {
        super(f968a, new String[0]);
        this.f969b = dnVar;
    }

    public Value mo591a(Map map) {
        Object a = this.f969b.m1594a();
        return a == null ? es.m1686f() : es.m1687f(a);
    }

    public boolean mo592a() {
        return false;
    }
}
