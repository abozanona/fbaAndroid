package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

abstract class eh extends cp {
    public eh(String str) {
        super(str);
    }

    protected boolean mo607a(Value value, Value value2, Map map) {
        String a = es.m1668a(value);
        String a2 = es.m1668a(value2);
        return (a == es.m1685e() || a2 == es.m1685e()) ? false : mo608a(a, a2, map);
    }

    protected abstract boolean mo608a(String str, String str2, Map map);
}
