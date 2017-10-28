package com.google.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class dd implements C0222u {
    private final String f1072a;
    private final Context f1073b;
    private final ScheduledExecutorService f1074c;
    private final dg f1075d;
    private ScheduledFuture f1076e;
    private boolean f1077f;
    private ad f1078g;
    private String f1079h;
    private LoadCallback f1080i;

    public dd(Context context, String str, ad adVar) {
        this(context, str, adVar, null, null);
    }

    @VisibleForTesting
    dd(Context context, String str, ad adVar, dh dhVar, dg dgVar) {
        this.f1078g = adVar;
        this.f1073b = context;
        this.f1072a = str;
        if (dhVar == null) {
            dhVar = new de(this);
        }
        this.f1074c = dhVar.mo660a();
        if (dgVar == null) {
            this.f1075d = new df(this);
        } else {
            this.f1075d = dgVar;
        }
    }

    private dc m1555b(String str) {
        dc a = this.f1075d.mo661a(this.f1078g);
        a.m1547a(this.f1080i);
        a.m1548a(this.f1079h);
        a.m1549b(str);
        return a;
    }

    private synchronized void m1557b() {
        if (this.f1077f) {
            throw new IllegalStateException("called method after closed");
        }
    }

    public synchronized void mo656a() {
        m1557b();
        if (this.f1076e != null) {
            this.f1076e.cancel(false);
        }
        this.f1074c.shutdown();
        this.f1077f = true;
    }

    public synchronized void mo657a(long j, String str) {
        bs.m1445e("loadAfterDelay: containerId=" + this.f1072a + " delay=" + j);
        m1557b();
        if (this.f1080i == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.f1076e != null) {
            this.f1076e.cancel(true);
        }
        this.f1076e = this.f1074c.schedule(m1555b(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void mo658a(LoadCallback loadCallback) {
        m1557b();
        this.f1080i = loadCallback;
    }

    public synchronized void mo659a(String str) {
        m1557b();
        this.f1079h = str;
    }
}
