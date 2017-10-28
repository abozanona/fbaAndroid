package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class am extends as {
    private static final String f961a = FunctionType.ENCODE.toString();
    private static final String f962b = Key.ARG0.toString();
    private static final String f963c = Key.NO_PADDING.toString();
    private static final String f964d = Key.INPUT_FORMAT.toString();
    private static final String f965e = Key.OUTPUT_FORMAT.toString();

    public am() {
        super(f961a, f962b);
    }

    public Value mo591a(Map map) {
        Value value = (Value) map.get(f962b);
        if (value == null || value == es.m1686f()) {
            return es.m1686f();
        }
        String a = es.m1668a(value);
        value = (Value) map.get(f964d);
        String a2 = value == null ? "text" : es.m1668a(value);
        value = (Value) map.get(f965e);
        String a3 = value == null ? "base16" : es.m1668a(value);
        value = (Value) map.get(f964d);
        value = (Value) map.get(f963c);
        int i = (value == null || !es.m1682e(value).booleanValue()) ? 0 : 1;
        try {
            byte[] bytes;
            Object a4;
            if ("text".equals(a2)) {
                bytes = a.getBytes();
            } else if ("base16".equals(a2)) {
                bytes = C0229i.m1713a(a);
            } else if ("base64".equals(a2)) {
                bytes = C0230j.m1716a(a, i);
            } else if ("base64url".equals(a2)) {
                bytes = C0230j.m1716a(a, i | 2);
            } else {
                bs.m1438a("Encode: unknown input format: " + a2);
                return es.m1686f();
            }
            if ("base16".equals(a3)) {
                a4 = C0229i.m1712a(bytes);
            } else if ("base64".equals(a3)) {
                a4 = C0230j.m1715a(bytes, i);
            } else if ("base64url".equals(a3)) {
                a4 = C0230j.m1715a(bytes, i | 2);
            } else {
                bs.m1438a("Encode: unknown output format: " + a3);
                return es.m1686f();
            }
            return es.m1687f(a4);
        } catch (IllegalArgumentException e) {
            bs.m1438a("Encode: invalid input:");
            return es.m1686f();
        }
    }

    public boolean mo592a() {
        return true;
    }
}
