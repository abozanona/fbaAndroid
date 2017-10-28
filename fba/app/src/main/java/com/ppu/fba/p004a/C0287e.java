package com.ppu.fba.p004a;

import android.content.Context;
import com.ppu.fba.p004a.p005a.C0273a;
import com.ppu.fba.p004a.p005a.C0274b;
import com.ppu.fba.p004a.p005a.C0275c;
import com.ppu.fba.p004a.p006b.C0278a;
import com.ppu.fba.p004a.p006b.C0279b;
import com.ppu.fba.p004a.p006b.C0280c;
import com.ppu.fba.p004a.p006b.C0281d;
import com.ppu.fba.p004a.p006b.C0282e;
import com.ppu.fba.p004a.p006b.C0283f;
import com.ppu.fba.p007b.C0289a;
import com.ppu.fba.p007b.C0291c;
import com.ppu.fba.p007b.C0292d;
import com.ppu.fba.p007b.C0294f;
import java.util.ArrayList;
import java.util.Iterator;

public class C0287e {
    private static C0272g[] f1356a = new C0272g[]{new C0273a(), new C0274b(), new C0275c()};
    private static C0277h[] f1357b = new C0277h[]{new C0283f(), new C0282e(), new C0281d(), new C0279b(), new C0280c(), new C0278a()};

    public static ArrayList m1914a(Context context, C0291c c0291c, C0294f c0294f) {
        ArrayList b;
        synchronized (c0291c) {
            synchronized (c0294f) {
                b = C0287e.m1915b(context, c0291c, c0294f);
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList a = C0285c.m1912a(context);
        Iterator it = b.iterator();
        while (it.hasNext()) {
            C0276a c0276a = (C0276a) it.next();
            C0284b a2 = c0276a.m1886a();
            int b2 = c0276a.m1887b();
            Object obj = 1;
            C0286d c0286d = C0286d.ALLOW;
            if (a2 == C0284b.APPLICATION) {
                C0286d c0286d2 = C0286d.ALLOW;//todo add by abozanona
                C0289a c0289a = (C0289a) c0291c.f1366a.get(Integer.valueOf(b2));
                if (c0289a != null) {
                    int a3 = c0289a.m1919a();
                    if (a3 == 1) {
                        c0286d2 = C0286d.WIFIONLY;
                    } else if (a3 == 2) {
                        c0286d2 = C0286d.BLOCK;
                    }
                    c0286d = c0286d2;
                }
                c0286d2 = c0286d;
                c0286d = c0286d2;
            } else {
                C0292d c0292d = (C0292d) c0294f.f1370a.get(Integer.valueOf(b2));
                if (c0292d != null && c0292d.f1369c == 2) {
                    c0286d = C0286d.BLOCK;
                }
            }
            Iterator it2 = a.iterator();
            while (it2.hasNext()) {
                C0285c c0285c = (C0285c) it2.next();
                Object obj2 = (c0285c.f1347a == a2 && c0285c.f1348b == b2 && (c0285c.f1350d == C0286d.CANCEL || c0285c.f1350d == c0286d)) ? null : obj;
                obj = obj2;
            }
            if (obj != null) {
                arrayList.add(c0276a);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList m1915b(android.content.Context r13, com.ppu.fba.p007b.C0291c r14, com.ppu.fba.p007b.C0294f r15) {
        /*
        r5 = new java.util.ArrayList;
        r5.<init>();
        r0 = r13.getApplicationInfo();
        r4 = r0.uid;
        r0 = com.ppu.fba.p009d.C0308e.m1965a();
        r6 = r0.iterator();
    L_0x0013:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x00ab;
    L_0x0019:
        r0 = r6.next();
        r0 = (java.lang.Integer) r0;
        r7 = r0.intValue();
        r8 = com.ppu.fba.p009d.C0308e.m1962a(r0);
        if (r7 == 0) goto L_0x0013;
    L_0x0029:
        if (r7 == r4) goto L_0x0013;
    L_0x002b:
        r0 = r14.f1366a;
        r1 = java.lang.Integer.valueOf(r7);
        r0 = r0.get(r1);
        r0 = (com.ppu.fba.p007b.C0289a) r0;
        r1 = 0;
        if (r0 == 0) goto L_0x003e;
    L_0x003a:
        r1 = r0.m1919a();
    L_0x003e:
        r2 = 0;
        r9 = f1356a;
        r10 = r9.length;
        r3 = 0;
    L_0x0043:
        if (r3 >= r10) goto L_0x005c;
    L_0x0045:
        r11 = r9[r3];
        r12 = r11.m1874a(r8);
        if (r12 == 0) goto L_0x00a2;
    L_0x004d:
        if (r0 == 0) goto L_0x005b;
    L_0x004f:
        if (r1 == 0) goto L_0x005b;
    L_0x0051:
        r2 = new com.ppu.fba.a.a;
        r3 = com.ppu.fba.p004a.C0284b.APPLICATION;
        r2.<init>(r3, r7, r11);
        r5.add(r2);
    L_0x005b:
        r2 = 1;
    L_0x005c:
        if (r2 != 0) goto L_0x0013;
    L_0x005e:
        if (r0 == 0) goto L_0x0063;
    L_0x0060:
        r2 = 2;
        if (r1 == r2) goto L_0x0013;
    L_0x0063:
        r2 = 0;
        r7 = f1356a;
        r9 = r7.length;
        r3 = 0;
    L_0x0068:
        if (r3 >= r9) goto L_0x007f;
    L_0x006a:
        r10 = r7[r3];
        r11 = r10.m1875b(r8);
        if (r11 == 0) goto L_0x00a5;
    L_0x0072:
        r2 = new com.ppu.fba.a.a;
        r3 = com.ppu.fba.p004a.C0284b.APPLICATION;
        r7 = r8.uid;
        r2.<init>(r3, r7, r10);
        r5.add(r2);
        r2 = 1;
    L_0x007f:
        if (r2 != 0) goto L_0x0013;
    L_0x0081:
        if (r0 == 0) goto L_0x0086;
    L_0x0083:
        r0 = 1;
        if (r1 == r0) goto L_0x0013;
    L_0x0086:
        r1 = f1356a;
        r2 = r1.length;
        r0 = 0;
    L_0x008a:
        if (r0 >= r2) goto L_0x0013;
    L_0x008c:
        r3 = r1[r0];
        r7 = r3.m1877c(r8);
        if (r7 == 0) goto L_0x00a8;
    L_0x0094:
        r0 = new com.ppu.fba.a.a;
        r1 = com.ppu.fba.p004a.C0284b.APPLICATION;
        r2 = r8.uid;
        r0.<init>(r1, r2, r3);
        r5.add(r0);
        goto L_0x0013;
    L_0x00a2:
        r3 = r3 + 1;
        goto L_0x0043;
    L_0x00a5:
        r3 = r3 + 1;
        goto L_0x0068;
    L_0x00a8:
        r0 = r0 + 1;
        goto L_0x008a;
    L_0x00ab:
        r0 = 0;
        r1 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x015b }
        if (r1 == 0) goto L_0x00b6;
    L_0x00b2:
        r0 = r1.getCountry();	 Catch:{ Exception -> 0x015b }
    L_0x00b6:
        if (r0 == 0) goto L_0x00c0;
    L_0x00b8:
        r1 = "";
        r1 = r0.equals(r1);	 Catch:{ Exception -> 0x015b }
        if (r1 == 0) goto L_0x00d0;
    L_0x00c0:
        r1 = r13.getResources();	 Catch:{ Exception -> 0x015b }
        r1 = r1.getConfiguration();	 Catch:{ Exception -> 0x015b }
        r1 = r1.locale;	 Catch:{ Exception -> 0x015b }
        if (r1 == 0) goto L_0x00d0;
    L_0x00cc:
        r0 = r1.getCountry();	 Catch:{ Exception -> 0x015b }
    L_0x00d0:
        r1 = r0;
    L_0x00d1:
        if (r1 == 0) goto L_0x00db;
    L_0x00d3:
        r0 = "";
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x015f }
        if (r0 == 0) goto L_0x017a;
    L_0x00db:
        r0 = "phone";
        r0 = r13.getSystemService(r0);	 Catch:{ Exception -> 0x015f }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Exception -> 0x015f }
        if (r0 == 0) goto L_0x017a;
    L_0x00e5:
        r0 = r0.getSimCountryIso();	 Catch:{ Exception -> 0x015f }
    L_0x00e9:
        if (r0 == 0) goto L_0x00f3;
    L_0x00eb:
        r1 = "";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0177;
    L_0x00f3:
        r0 = "US";
        r2 = r0;
    L_0x00f6:
        r0 = com.ppu.fba.p009d.C0309f.m1981c();
        r6 = r0.iterator();
    L_0x00fe:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0176;
    L_0x0104:
        r0 = r6.next();
        r0 = (java.lang.String) r0;
        r7 = com.ppu.fba.p009d.C0309f.m1982d(r0);
        r1 = r15.f1370a;
        r3 = java.lang.Integer.valueOf(r7);
        r1 = r1.get(r3);
        r1 = (com.ppu.fba.p007b.C0292d) r1;
        r3 = 0;
        r4 = r0.equals(r2);
        if (r4 == 0) goto L_0x0122;
    L_0x0121:
        r3 = 1;
    L_0x0122:
        r8 = f1357b;
        r9 = r8.length;
        r4 = 0;
    L_0x0126:
        if (r4 >= r9) goto L_0x0141;
    L_0x0128:
        r10 = r8[r4];
        r11 = r10.m1889a(r0);
        if (r11 == 0) goto L_0x0162;
    L_0x0130:
        if (r1 == 0) goto L_0x0140;
    L_0x0132:
        r3 = r1.f1369c;
        if (r3 == 0) goto L_0x0140;
    L_0x0136:
        r3 = new com.ppu.fba.a.a;
        r4 = com.ppu.fba.p004a.C0284b.COUNTRY;
        r3.<init>(r4, r7, r10);
        r5.add(r3);
    L_0x0140:
        r3 = 1;
    L_0x0141:
        if (r3 != 0) goto L_0x00fe;
    L_0x0143:
        if (r1 == 0) goto L_0x014a;
    L_0x0145:
        r1 = r1.f1369c;
        r3 = 2;
        if (r1 == r3) goto L_0x00fe;
    L_0x014a:
        r3 = f1357b;
        r4 = r3.length;
        r1 = 0;
    L_0x014e:
        if (r1 >= r4) goto L_0x00fe;
    L_0x0150:
        r8 = r3[r1];
        r9 = r8.m1892c(r2);
        if (r9 == 0) goto L_0x0165;
    L_0x0158:
        r1 = r1 + 1;
        goto L_0x014e;
    L_0x015b:
        r1 = move-exception;
        r1 = r0;
        goto L_0x00d1;
    L_0x015f:
        r0 = move-exception;
        r0 = r1;
        goto L_0x00e9;
    L_0x0162:
        r4 = r4 + 1;
        goto L_0x0126;
    L_0x0165:
        r9 = r8.m1890b(r0);
        if (r9 == 0) goto L_0x0158;
    L_0x016b:
        r0 = new com.ppu.fba.a.a;
        r1 = com.ppu.fba.p004a.C0284b.COUNTRY;
        r0.<init>(r1, r7, r8);
        r5.add(r0);
        goto L_0x00fe;
    L_0x0176:
        return r5;
    L_0x0177:
        r2 = r0;
        goto L_0x00f6;
    L_0x017a:
        r0 = r1;
        goto L_0x00e9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ppu.fba.a.e.b(android.content.Context, com.ppu.fba.b.c, com.ppu.fba.b.f):java.util.ArrayList");
    }
}
