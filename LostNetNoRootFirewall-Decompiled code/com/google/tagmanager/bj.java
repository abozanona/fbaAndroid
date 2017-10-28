package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import java.util.Set;

class bj extends as {
    private static final String f999a = FunctionType.JOINER.toString();
    private static final String f1000b = Key.ARG0.toString();
    private static final String f1001c = Key.ITEM_SEPARATOR.toString();
    private static final String f1002d = Key.KEY_VALUE_SEPARATOR.toString();
    private static final String f1003e = Key.ESCAPE.toString();

    public bj() {
        super(f999a, f1000b);
    }

    private String m1420a(String str, bl blVar, Set set) {
        switch (bk.f1005b[blVar.ordinal()]) {
            case 1:
                try {
                    return ew.m1706a(str);
                } catch (Throwable e) {
                    bs.m1439a("Joiner: unsupported encoding", e);
                    return str;
                }
            case 2:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    str2 = str2.replace(ch2, "\\" + ch2);
                }
                return str2;
            default:
                return str;
        }
    }

    private void m1421a(StringBuilder stringBuilder, String str, bl blVar, Set set) {
        stringBuilder.append(m1420a(str, blVar, set));
    }

    private void m1422a(Set set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value mo591a(java.util.Map r11) {
        /*
        r10 = this;
        r6 = 0;
        r0 = f1000b;
        r0 = r11.get(r0);
        r0 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value) r0;
        if (r0 != 0) goto L_0x0010;
    L_0x000b:
        r0 = com.google.tagmanager.es.m1686f();
    L_0x000f:
        return r0;
    L_0x0010:
        r1 = f1001c;
        r1 = r11.get(r1);
        r1 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value) r1;
        if (r1 == 0) goto L_0x0070;
    L_0x001a:
        r1 = com.google.tagmanager.es.m1668a(r1);
        r2 = r1;
    L_0x001f:
        r1 = f1002d;
        r1 = r11.get(r1);
        r1 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value) r1;
        if (r1 == 0) goto L_0x0074;
    L_0x0029:
        r1 = com.google.tagmanager.es.m1668a(r1);
        r3 = r1;
    L_0x002e:
        r5 = com.google.tagmanager.bl.NONE;
        r1 = f1003e;
        r1 = r11.get(r1);
        r1 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value) r1;
        r4 = 0;
        if (r1 == 0) goto L_0x00fd;
    L_0x003b:
        r1 = com.google.tagmanager.es.m1668a(r1);
        r5 = "url";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x0078;
    L_0x0047:
        r1 = com.google.tagmanager.bl.URL;
        r9 = r4;
        r4 = r1;
        r1 = r9;
    L_0x004c:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r7 = com.google.tagmanager.bk.f1004a;
        r8 = r0.getType();
        r8 = r8.ordinal();
        r7 = r7[r8];
        switch(r7) {
            case 1: goto L_0x00b3;
            case 2: goto L_0x00d6;
            default: goto L_0x0060;
        };
    L_0x0060:
        r0 = com.google.tagmanager.es.m1668a(r0);
        r10.m1421a(r5, r0, r4, r1);
    L_0x0067:
        r0 = r5.toString();
        r0 = com.google.tagmanager.es.m1687f(r0);
        goto L_0x000f;
    L_0x0070:
        r1 = "";
        r2 = r1;
        goto L_0x001f;
    L_0x0074:
        r1 = "=";
        r3 = r1;
        goto L_0x002e;
    L_0x0078:
        r4 = "backslash";
        r4 = r4.equals(r1);
        if (r4 == 0) goto L_0x0097;
    L_0x0080:
        r4 = com.google.tagmanager.bl.BACKSLASH;
        r1 = new java.util.HashSet;
        r1.<init>();
        r10.m1422a(r1, r2);
        r10.m1422a(r1, r3);
        r5 = 92;
        r5 = java.lang.Character.valueOf(r5);
        r1.remove(r5);
        goto L_0x004c;
    L_0x0097:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "Joiner: unsupported escape type: ";
        r0 = r0.append(r2);
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.google.tagmanager.bs.m1438a(r0);
        r0 = com.google.tagmanager.es.m1686f();
        goto L_0x000f;
    L_0x00b3:
        r3 = 1;
        r0 = r0.getListItemList();
        r7 = r0.iterator();
    L_0x00bc:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x0067;
    L_0x00c2:
        r0 = r7.next();
        r0 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value) r0;
        if (r3 != 0) goto L_0x00cd;
    L_0x00ca:
        r5.append(r2);
    L_0x00cd:
        r0 = com.google.tagmanager.es.m1668a(r0);
        r10.m1421a(r5, r0, r4, r1);
        r3 = r6;
        goto L_0x00bc;
    L_0x00d6:
        r7 = r0.getMapKeyCount();
        if (r6 >= r7) goto L_0x0067;
    L_0x00dc:
        if (r6 <= 0) goto L_0x00e1;
    L_0x00de:
        r5.append(r2);
    L_0x00e1:
        r7 = r0.getMapKey(r6);
        r7 = com.google.tagmanager.es.m1668a(r7);
        r8 = r0.getMapValue(r6);
        r8 = com.google.tagmanager.es.m1668a(r8);
        r10.m1421a(r5, r7, r4, r1);
        r5.append(r3);
        r10.m1421a(r5, r8, r4, r1);
        r6 = r6 + 1;
        goto L_0x00d6;
    L_0x00fd:
        r1 = r4;
        r4 = r5;
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.tagmanager.bj.a(java.util.Map):com.google.analytics.midtier.proto.containertag.TypeSystem$Value");
    }

    public boolean mo592a() {
        return true;
    }
}
