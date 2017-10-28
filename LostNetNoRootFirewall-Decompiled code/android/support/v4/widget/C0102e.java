package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public class C0102e {
    private static final C0103h f407b;
    private Object f408a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f407b = new C0105g();
        } else {
            f407b = new C0104f();
        }
    }

    public C0102e(Context context) {
        this.f408a = f407b.mo135a(context);
    }

    public void m826a(int i, int i2) {
        f407b.mo136a(this.f408a, i, i2);
    }

    public boolean m827a() {
        return f407b.mo137a(this.f408a);
    }

    public boolean m828a(float f) {
        return f407b.mo138a(this.f408a, f);
    }

    public boolean m829a(Canvas canvas) {
        return f407b.mo139a(this.f408a, canvas);
    }

    public void m830b() {
        f407b.mo140b(this.f408a);
    }

    public boolean m831c() {
        return f407b.mo141c(this.f408a);
    }
}
