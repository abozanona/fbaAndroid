package com.google.tagmanager;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.util.VisibleForTesting;

class dz extends dy {
    private static final Object f1124a = new Object();
    private static dz f1125n;
    private Context f1126b;
    private bd f1127c;
    private volatile ba f1128d;
    private int f1129e = 1800;
    private boolean f1130f = true;
    private boolean f1131g = false;
    private boolean f1132h = true;
    private boolean f1133i = true;
    private be f1134j = new ea(this);
    private Handler f1135k;
    private bx f1136l;
    private boolean f1137m = false;

    private dz() {
    }

    public static dz m1627b() {
        if (f1125n == null) {
            f1125n = new dz();
        }
        return f1125n;
    }

    private void m1632f() {
        this.f1136l = new bx(this);
        this.f1136l.m1454a(this.f1126b);
    }

    private void m1633g() {
        this.f1135k = new Handler(this.f1126b.getMainLooper(), new eb(this));
        if (this.f1129e > 0) {
            this.f1135k.sendMessageDelayed(this.f1135k.obtainMessage(1, f1124a), (long) (this.f1129e * 1000));
        }
    }

    synchronized void mo671a() {
        if (!this.f1137m && this.f1132h && this.f1129e > 0) {
            this.f1135k.removeMessages(1, f1124a);
            this.f1135k.sendMessage(this.f1135k.obtainMessage(1, f1124a));
        }
    }

    synchronized void m1635a(Context context, ba baVar) {
        if (this.f1126b == null) {
            this.f1126b = context.getApplicationContext();
            if (this.f1128d == null) {
                this.f1128d = baVar;
            }
        }
    }

    synchronized void mo672a(boolean z) {
        m1637a(this.f1137m, z);
    }

    @VisibleForTesting
    synchronized void m1637a(boolean z, boolean z2) {
        if (!(this.f1137m == z && this.f1132h == z2)) {
            if (z || !z2) {
                if (this.f1129e > 0) {
                    this.f1135k.removeMessages(1, f1124a);
                }
            }
            if (!z && z2 && this.f1129e > 0) {
                this.f1135k.sendMessageDelayed(this.f1135k.obtainMessage(1, f1124a), (long) (this.f1129e * 1000));
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            bs.m1445e(append.append(str).toString());
            this.f1137m = z;
            this.f1132h = z2;
        }
    }

    synchronized bd m1638c() {
        if (this.f1127c == null) {
            if (this.f1126b == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.f1127c = new ck(this.f1134j, this.f1126b);
        }
        if (this.f1135k == null) {
            m1633g();
        }
        this.f1131g = true;
        if (this.f1130f) {
            m1639d();
            this.f1130f = false;
        }
        if (this.f1136l == null && this.f1133i) {
            m1632f();
        }
        return this.f1127c;
    }

    public synchronized void m1639d() {
        if (this.f1131g) {
            this.f1128d.mo623a(new ec(this));
        } else {
            bs.m1445e("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.f1130f = true;
        }
    }
}
