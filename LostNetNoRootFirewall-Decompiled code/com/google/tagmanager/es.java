package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class es {
    private static final Object f1158a = null;
    private static Long f1159b = new Long(0);
    private static Double f1160c = new Double(0.0d);
    private static er f1161d = er.m1657a(0);
    private static String f1162e = new String("");
    private static Boolean f1163f = new Boolean(false);
    private static List f1164g = new ArrayList(0);
    private static Map f1165h = new HashMap();
    private static Value f1166i = m1687f(f1162e);

    public static Value m1666a(String str) {
        return Value.newBuilder().setType(Type.FUNCTION_ID).setFunctionId(str).build();
    }

    public static Long m1667a() {
        return f1159b;
    }

    public static String m1668a(Value value) {
        return m1669a(m1688f(value));
    }

    public static String m1669a(Object obj) {
        return obj == null ? f1162e : obj.toString();
    }

    public static er m1670b(Value value) {
        return m1671b(m1688f(value));
    }

    public static er m1671b(Object obj) {
        return obj instanceof er ? (er) obj : m1691i(obj) ? er.m1657a(m1692j(obj)) : m1689g(obj) ? er.m1658a(Double.valueOf(m1690h(obj))) : m1672b(m1669a(obj));
    }

    private static er m1672b(String str) {
        try {
            return er.m1659a(str);
        } catch (NumberFormatException e) {
            bs.m1438a("Failed to convert '" + str + "' to a number.");
            return f1161d;
        }
    }

    public static Double m1673b() {
        return f1160c;
    }

    public static Boolean m1674c() {
        return f1163f;
    }

    public static Long m1675c(Value value) {
        return m1676c(m1688f(value));
    }

    public static Long m1676c(Object obj) {
        return m1691i(obj) ? Long.valueOf(m1692j(obj)) : m1677c(m1669a(obj));
    }

    private static Long m1677c(String str) {
        er b = m1672b(str);
        return b == f1161d ? f1159b : Long.valueOf(b.longValue());
    }

    public static er m1678d() {
        return f1161d;
    }

    public static Double m1679d(Value value) {
        return m1680d(m1688f(value));
    }

    public static Double m1680d(Object obj) {
        return m1689g(obj) ? Double.valueOf(m1690h(obj)) : m1681d(m1669a(obj));
    }

    private static Double m1681d(String str) {
        er b = m1672b(str);
        return b == f1161d ? f1160c : Double.valueOf(b.doubleValue());
    }

    public static Boolean m1682e(Value value) {
        return m1683e(m1688f(value));
    }

    public static Boolean m1683e(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : m1684e(m1669a(obj));
    }

    private static Boolean m1684e(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : f1163f;
    }

    public static String m1685e() {
        return f1162e;
    }

    public static Value m1686f() {
        return f1166i;
    }

    public static Value m1687f(Object obj) {
        boolean z = false;
        Builder newBuilder = Value.newBuilder();
        if (obj instanceof Value) {
            return (Value) obj;
        }
        if (obj instanceof String) {
            newBuilder.setType(Type.STRING).setString((String) obj);
        } else if (obj instanceof List) {
            newBuilder.setType(Type.LIST);
            r0 = false;
            for (Object f : (List) obj) {
                Value f2 = m1687f(f);
                if (f2 == f1166i) {
                    return f1166i;
                }
                r0 = r0 || f2.getContainsReferences();
                newBuilder.addListItem(f2);
            }
            z = r0;
        } else if (obj instanceof Map) {
            newBuilder.setType(Type.MAP);
            boolean z2 = false;
            for (Entry entry : ((Map) obj).entrySet()) {
                Value f3 = m1687f(entry.getKey());
                Value f4 = m1687f(entry.getValue());
                if (f3 == f1166i || f4 == f1166i) {
                    return f1166i;
                }
                r0 = z2 || f3.getContainsReferences() || f4.getContainsReferences();
                newBuilder.addMapKey(f3);
                newBuilder.addMapValue(f4);
                z2 = r0;
            }
            z = z2;
        } else if (m1689g(obj)) {
            newBuilder.setType(Type.STRING).setString(obj.toString());
        } else if (m1691i(obj)) {
            newBuilder.setType(Type.INTEGER).setInteger(m1692j(obj));
        } else if (obj instanceof Boolean) {
            newBuilder.setType(Type.BOOLEAN).setBoolean(((Boolean) obj).booleanValue());
        } else {
            bs.m1438a("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return f1166i;
        }
        if (z) {
            newBuilder.setContainsReferences(true);
        }
        return newBuilder.build();
    }

    public static Object m1688f(Value value) {
        if (value == null) {
            return f1158a;
        }
        switch (et.f1167a[value.getType().ordinal()]) {
            case 1:
                return value.getString();
            case 2:
                ArrayList arrayList = new ArrayList(value.getListItemCount());
                for (Value f : value.getListItemList()) {
                    Object f2 = m1688f(f);
                    if (f2 == f1158a) {
                        return f1158a;
                    }
                    arrayList.add(f2);
                }
                return arrayList;
            case 3:
                if (value.getMapKeyCount() != value.getMapValueCount()) {
                    bs.m1438a("Converting an invalid value to object: " + value.toString());
                    return f1158a;
                }
                Map hashMap = new HashMap(value.getMapValueCount());
                for (int i = 0; i < value.getMapKeyCount(); i++) {
                    Object f3 = m1688f(value.getMapKey(i));
                    Object f4 = m1688f(value.getMapValue(i));
                    if (f3 == f1158a || f4 == f1158a) {
                        return f1158a;
                    }
                    hashMap.put(f3, f4);
                }
                return hashMap;
            case 4:
                bs.m1438a("Trying to convert a macro reference to object");
                return f1158a;
            case 5:
                bs.m1438a("Trying to convert a function id to object");
                return f1158a;
            case 6:
                return Long.valueOf(value.getInteger());
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                for (Value f5 : value.getTemplateTokenList()) {
                    String a = m1668a(f5);
                    if (a == f1162e) {
                        return f1158a;
                    }
                    stringBuffer.append(a);
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(value.getBoolean());
            default:
                bs.m1438a("Failed to convert a value of type: " + value.getType());
                return f1158a;
        }
    }

    private static boolean m1689g(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof er) && ((er) obj).m1661a());
    }

    private static double m1690h(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        bs.m1438a("getDouble received non-Number");
        return 0.0d;
    }

    private static boolean m1691i(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof er) && ((er) obj).m1662b());
    }

    private static long m1692j(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        bs.m1438a("getInt64 received non-Number");
        return 0;
    }
}
