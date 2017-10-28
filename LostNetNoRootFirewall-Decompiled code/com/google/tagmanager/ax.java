package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ax extends as {
    private static final String f973a = FunctionType.HASH.toString();
    private static final String f974b = Key.ARG0.toString();
    private static final String f975c = Key.ALGORITHM.toString();
    private static final String f976d = Key.INPUT_FORMAT.toString();

    public ax() {
        super(f973a, f974b);
    }

    private byte[] m1378a(String str, byte[] bArr) {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public Value mo591a(Map map) {
        Value value = (Value) map.get(f974b);
        if (value == null || value == es.m1686f()) {
            return es.m1686f();
        }
        byte[] bytes;
        String a = es.m1668a(value);
        value = (Value) map.get(f975c);
        String a2 = value == null ? "MD5" : es.m1668a(value);
        value = (Value) map.get(f976d);
        String a3 = value == null ? "text" : es.m1668a(value);
        if ("text".equals(a3)) {
            bytes = a.getBytes();
        } else if ("base16".equals(a3)) {
            bytes = C0229i.m1713a(a);
        } else {
            bs.m1438a("Hash: unknown input format: " + a3);
            return es.m1686f();
        }
        try {
            return es.m1687f(C0229i.m1712a(m1378a(a2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            bs.m1438a("Hash: unknown algorithm: " + a2);
            return es.m1686f();
        }
    }

    public boolean mo592a() {
        return true;
    }
}
