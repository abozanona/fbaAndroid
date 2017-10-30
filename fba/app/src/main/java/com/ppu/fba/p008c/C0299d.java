package com.ppu.fba.p008c;

import android.content.Context;
import com.ppu.fba.p009d.C0311h;
import com.ppu.fba.p009d.Log1;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public abstract class C0299d {
    private String f1382a;
    private HashMap f1383b;
    private transient long f1384c = 0;
    private HashMap f1385d;

    public C0299d(String str) {
        this.f1382a = str;
        this.f1384c = 0;
        this.f1383b = new HashMap();
        this.f1385d = new HashMap();
    }

    private void m1950a(Context context, Long l, C0297b c0297b) {
        Log1.LogF1("Storage", "saveStats");
        C0311h.m1999a(context, c0297b, this.f1382a + "/" + String.valueOf(l), false);
    }

    public abstract long mo740a();

    public synchronized C0297b m1952a(long j) {
        C0297b c0297b;
        c0297b = (C0297b) this.f1383b.get(Long.valueOf(j));
        if (c0297b == null) {
            c0297b = new C0297b();
            c0297b.f1377e = true;
            this.f1383b.put(Long.valueOf(j), c0297b);
        }
        return c0297b;
    }

    public void m1953a(Context context) {
        Log1.LogF1("Storage", "save");
        C0311h.m1999a(context, this.f1385d, this.f1382a + "/total", false);
        Set keySet = this.f1383b.keySet();
        Long[] lArr = (Long[]) keySet.toArray(new Long[keySet.size()]);
        long a = mo740a();
        for (Long l : lArr) {
            if (l.longValue() < a) {
                Log1.LogF1("Storage", "save: remove");
                this.f1383b.remove(l);
            } else {
                Log1.LogF1("Storage", "save: entry");
                C0297b c0297b = (C0297b) this.f1383b.get(l);
                if (c0297b.m1947c()) {
                    m1950a(context, l, c0297b);
                }
            }
        }
    }

    public synchronized C0298c m1954b(long j) {
        C0298c c0298c;
        c0298c = (C0298c) this.f1385d.get(Long.valueOf(j));
        if (c0298c == null) {
            //todo abozanona
            c0298c = new C0302g(c0298c);
            this.f1385d.put(Long.valueOf(j), c0298c);
        }
        return c0298c;
    }

    public synchronized void m1955b(Context context) {
        long c = C0296a.m1930c();
        if (this.f1384c > c) {
            this.f1384c = 0;
        }
        Log1.LogF1("Storage", "saveMaybe " + this.f1382a + " " + this.f1384c + " " + c);
        if (this.f1384c + 60000 < c) {
            m1953a(context);
            this.f1384c = c;
        }
    }

    public synchronized void m1956c(Context context) {
        Iterator it;
        C0298c c0298c;
        Log1.LogF1("Storage", "restore");
        Object a = C0311h.m1997a(context, this.f1382a + "/total");
        if (a != null) {
            Log1.LogF1("Storage", "restore: read " + a.getClass().getCanonicalName());
        }
        if (a != null && (a instanceof HashMap)) {
            Log1.LogF1("Storage", "restore: put");
            HashMap hashMap = (HashMap) a;
            it = new ArrayList(hashMap.keySet()).iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                c0298c = (C0298c) hashMap.get(l);
                if (!(c0298c instanceof C0302g)) {
                    hashMap.put(l, new C0302g(c0298c));
                }
            }
            this.f1385d = hashMap;
        }
        Long valueOf = Long.valueOf(mo740a());
        String str = context.getFilesDir().getPath() + "/" + this.f1382a;
        for (String str2 : new File(str).list()) {
            if (!"total".equals(str2)) {
                Long valueOf2 = Long.valueOf(str2);
                Log1.LogF1("Storage", "restore: " + str2);
                if (valueOf2 != null && valueOf2.longValue() > 0) {
                    if (valueOf2.longValue() < valueOf.longValue()) {
                        Log1.LogF1("Storage", "restore: delete");
                        new File(str + "/" + str2).delete();
                    } else {
                        a = C0311h.m1997a(context, this.f1382a + "/" + str2);
                        if (a != null) {
                            Log1.LogF1("Storage", "restore: read " + a.getClass().getCanonicalName());
                        }
                        if (a != null && (a instanceof C0297b)) {
                            Integer num;
                            HashMap hashMap2;
                            Iterator it2;
                            Integer num2;
                            C0298c c0298c2;
                            Log1.LogF1("Storage", "restore: put");
                            C0297b c0297b = (C0297b) a;
                            it = new ArrayList(c0297b.f1375c.keySet()).iterator();
                            while (it.hasNext()) {
                                num = (Integer) it.next();
                                c0298c = (C0298c) c0297b.f1375c.get(num);
                                if (!(c0298c instanceof C0302g)) {
                                    c0297b.f1375c.put(num, new C0302g(c0298c));
                                }
                            }
                            it = new ArrayList(c0297b.f1373a.keySet()).iterator();
                            while (it.hasNext()) {
                                num = (Integer) it.next();
                                c0298c = (C0298c) c0297b.f1373a.get(num);
                                if (!(c0298c instanceof C0302g)) {
                                    c0297b.f1373a.put(num, new C0302g(c0298c));
                                }
                            }
                            Iterator it3 = new ArrayList(c0297b.f1376d.keySet()).iterator();
                            while (it3.hasNext()) {
                                hashMap2 = (HashMap) c0297b.f1376d.get((Integer) it3.next());
                                it2 = new ArrayList(hashMap2.keySet()).iterator();
                                while (it2.hasNext()) {
                                    num2 = (Integer) it2.next();
                                    c0298c2 = (C0298c) hashMap2.get(num2);
                                    if (!(c0298c2 instanceof C0302g)) {
                                        hashMap2.put(num2, new C0302g(c0298c2));
                                    }
                                }
                            }
                            it3 = new ArrayList(c0297b.f1374b.keySet()).iterator();
                            while (it3.hasNext()) {
                                hashMap2 = (HashMap) c0297b.f1374b.get((Integer) it3.next());
                                it2 = new ArrayList(hashMap2.keySet()).iterator();
                                while (it2.hasNext()) {
                                    num2 = (Integer) it2.next();
                                    c0298c2 = (C0298c) hashMap2.get(num2);
                                    if (!(c0298c2 instanceof C0302g)) {
                                        hashMap2.put(num2, new C0302g(c0298c2));
                                    }
                                }
                            }
                            this.f1383b.put(valueOf2, c0297b);
                        }
                    }
                }
            }
        }
    }
}
