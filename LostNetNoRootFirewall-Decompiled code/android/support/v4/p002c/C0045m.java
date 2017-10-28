package android.support.v4.p002c;

public class C0045m implements Cloneable {
    private static final Object f255a = new Object();
    private boolean f256b;
    private int[] f257c;
    private Object[] f258d;
    private int f259e;

    public C0045m() {
        this(10);
    }

    public C0045m(int i) {
        this.f256b = false;
        if (i == 0) {
            this.f257c = C0037c.f238a;
            this.f258d = C0037c.f240c;
        } else {
            int a = C0037c.m305a(i);
            this.f257c = new int[a];
            this.f258d = new Object[a];
        }
        this.f259e = 0;
    }

    private void m313d() {
        int i = this.f259e;
        int[] iArr = this.f257c;
        Object[] objArr = this.f258d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f255a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f256b = false;
        this.f259e = i2;
    }

    public int m314a(int i) {
        if (this.f256b) {
            m313d();
        }
        return this.f257c[i];
    }

    public C0045m m315a() {
        try {
            C0045m c0045m = (C0045m) super.clone();
            try {
                c0045m.f257c = (int[]) this.f257c.clone();
                c0045m.f258d = (Object[]) this.f258d.clone();
                return c0045m;
            } catch (CloneNotSupportedException e) {
                return c0045m;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public int m316b() {
        if (this.f256b) {
            m313d();
        }
        return this.f259e;
    }

    public Object m317b(int i) {
        if (this.f256b) {
            m313d();
        }
        return this.f258d[i];
    }

    public void m318c() {
        int i = this.f259e;
        Object[] objArr = this.f258d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f259e = 0;
        this.f256b = false;
    }

    public /* synthetic */ Object clone() {
        return m315a();
    }

    public String toString() {
        if (m316b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f259e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f259e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m314a(i));
            stringBuilder.append('=');
            C0045m b = m317b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
