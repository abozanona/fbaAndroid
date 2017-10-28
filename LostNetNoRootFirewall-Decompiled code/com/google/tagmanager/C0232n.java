package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class C0232n extends as {
    private static final String f1187a = FunctionType.CONSTANT.toString();
    private static final String f1188b = Key.VALUE.toString();

    public C0232n() {
        super(f1187a, f1188b);
    }

    public static String m1717b() {
        return f1187a;
    }

    public static String m1718c() {
        return f1188b;
    }

    public Value mo591a(Map map) {
        return (Value) map.get(f1188b);
    }

    public boolean mo592a() {
        return true;
    }
}
