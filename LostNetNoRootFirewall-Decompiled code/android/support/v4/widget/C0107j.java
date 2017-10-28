package android.support.v4.widget;

import android.os.Build.VERSION;

public class C0107j {
    static final C0108k f409b;
    Object f410a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f409b = new C0111n();
        } else if (i >= 9) {
            f409b = new C0110m();
        } else {
            f409b = new C0109l();
        }
    }

    public void m860a(int i, int i2, int i3, int i4, int i5) {
        f409b.mo142a(this.f410a, i, i2, i3, i4, i5);
    }

    public boolean m861a() {
        return f409b.mo143a(this.f410a);
    }

    public int m862b() {
        return f409b.mo144b(this.f410a);
    }

    public int m863c() {
        return f409b.mo145c(this.f410a);
    }

    public int m864d() {
        return f409b.mo148f(this.f410a);
    }

    public int m865e() {
        return f409b.mo149g(this.f410a);
    }

    public boolean m866f() {
        return f409b.mo146d(this.f410a);
    }

    public void m867g() {
        f409b.mo147e(this.f410a);
    }
}
