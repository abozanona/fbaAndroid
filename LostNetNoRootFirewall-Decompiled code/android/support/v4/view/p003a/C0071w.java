package android.support.v4.view.p003a;

import android.os.Build.VERSION;

public class C0071w {
    private static final C0047z f323a;
    private final Object f324b;

    static {
        if (VERSION.SDK_INT >= 16) {
            f323a = new aa();
        } else if (VERSION.SDK_INT >= 15) {
            f323a = new C0049y();
        } else if (VERSION.SDK_INT >= 14) {
            f323a = new C0048x();
        } else {
            f323a = new ab();
        }
    }

    public C0071w(Object obj) {
        this.f324b = obj;
    }

    public static C0071w m507a() {
        return new C0071w(f323a.mo29a());
    }

    public void m508a(int i) {
        f323a.mo32b(this.f324b, i);
    }

    public void m509a(boolean z) {
        f323a.mo31a(this.f324b, z);
    }

    public void m510b(int i) {
        f323a.mo30a(this.f324b, i);
    }

    public void m511c(int i) {
        f323a.mo33c(this.f324b, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0071w c0071w = (C0071w) obj;
        return this.f324b == null ? c0071w.f324b == null : this.f324b.equals(c0071w.f324b);
    }

    public int hashCode() {
        return this.f324b == null ? 0 : this.f324b.hashCode();
    }
}
