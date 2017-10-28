package com.ppu.fba.p004a;

import android.content.Context;
import com.ppu.fba.p008c.C0296a;
import com.ppu.fba.p009d.C0311h;
import java.io.Serializable;
import java.util.ArrayList;

public class C0285c implements Serializable {
    private static transient ArrayList f1346e = null;
    private static final long serialVersionUID = 7132254386569750041L;
    public C0284b f1347a;
    public int f1348b;
    public Long f1349c = Long.valueOf(C0296a.m1930c());
    public C0286d f1350d;

    public C0285c(C0284b c0284b, int i, C0286d c0286d) {
        this.f1347a = c0284b;
        this.f1348b = i;
        this.f1350d = c0286d;
    }

    public static ArrayList m1912a(Context context) {
        if (f1346e == null) {
            try {
                Object a = C0311h.m1997a(context, "decisionsMade");
                if (a != null && (a instanceof ArrayList)) {
                    Object obj = ((ArrayList) a).get(0);
                    if (obj != null && (obj instanceof C0285c)) {
                        f1346e = (ArrayList) a;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (f1346e == null) {
            f1346e = new ArrayList();
        }
        return f1346e;
    }

    public static void m1913a(C0285c c0285c) {
        f1346e.add(c0285c);
    }
}
