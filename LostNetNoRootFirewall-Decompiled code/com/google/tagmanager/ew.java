package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import java.net.URLEncoder;
import java.util.List;

class ew {
    private static ci m1703a(ci ciVar) {
        try {
            return new ci(es.m1687f(m1706a(((Value) ciVar.m1496a()).getString())), ciVar.m1497b());
        } catch (Throwable e) {
            bs.m1439a("Escape URI: unsupported encoding", e);
            return ciVar;
        }
    }

    private static ci m1704a(ci ciVar, Escaping escaping) {
        if (m1707a((Value) ciVar.m1496a())) {
            switch (ex.f1180a[escaping.ordinal()]) {
                case 1:
                    return m1703a(ciVar);
                default:
                    bs.m1438a("Unsupported Value Escaping: " + escaping);
                    return ciVar;
            }
        }
        bs.m1438a("Escaping can only be applied to strings.");
        return ciVar;
    }

    static ci m1705a(ci ciVar, List list) {
        for (Escaping a : list) {
            ciVar = m1704a(ciVar, a);
        }
        return ciVar;
    }

    static String m1706a(String str) {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean m1707a(Value value) {
        return value.hasType() && value.getType().equals(Type.STRING) && value.hasString();
    }
}
