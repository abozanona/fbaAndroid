package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

abstract class ch extends cp {
    public ch(String str) {
        super(str);
    }

    protected boolean mo607a(Value value, Value value2, Map map) {
        er b = es.m1670b(value);
        er b2 = es.m1670b(value2);
        return (b == es.m1678d() || b2 == es.m1678d()) ? false : mo622a(b, b2, map);
    }

    protected abstract boolean mo622a(er erVar, er erVar2, Map map);
}
