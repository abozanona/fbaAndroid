package android.support.v4.p002c;

import java.util.Map;

public class C0033l {
    static Object[] f226b;
    static int f227c;
    static Object[] f228d;
    static int f229e;
    int[] f230f = C0037c.f238a;
    Object[] f231g = C0037c.f240c;
    int f232h = 0;

    private static void m267a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0034a.class) {
                if (f229e < 10) {
                    objArr[0] = f228d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f228d = objArr;
                    f229e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0034a.class) {
                if (f227c < 10) {
                    objArr[0] = f226b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f226b = objArr;
                    f227c++;
                }
            }
        }
    }

    private void m268e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0034a.class) {
                if (f228d != null) {
                    objArr = f228d;
                    this.f231g = objArr;
                    f228d = (Object[]) objArr[0];
                    this.f230f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f229e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0034a.class) {
                if (f226b != null) {
                    objArr = f226b;
                    this.f231g = objArr;
                    f226b = (Object[]) objArr[0];
                    this.f230f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f227c--;
                    return;
                }
            }
        }
        this.f230f = new int[i];
        this.f231g = new Object[(i << 1)];
    }

    int m269a() {
        int i = this.f232h;
        if (i == 0) {
            return -1;
        }
        int a = C0037c.m306a(this.f230f, i, 0);
        if (a < 0 || this.f231g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f230f[i2] == 0) {
            if (this.f231g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f230f[a] == 0) {
            if (this.f231g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    int m270a(Object obj) {
        int i = 1;
        int i2 = this.f232h * 2;
        Object[] objArr = this.f231g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    int m271a(Object obj, int i) {
        int i2 = this.f232h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0037c.m306a(this.f230f, i2, i);
        if (a < 0 || obj.equals(this.f231g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f230f[i3] == i) {
            if (obj.equals(this.f231g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f230f[a] == i) {
            if (obj.equals(this.f231g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    public Object m272a(int i, Object obj) {
        int i2 = (i << 1) + 1;
        Object obj2 = this.f231g[i2];
        this.f231g[i2] = obj;
        return obj2;
    }

    public void m273a(int i) {
        if (this.f230f.length < i) {
            Object obj = this.f230f;
            Object obj2 = this.f231g;
            m268e(i);
            if (this.f232h > 0) {
                System.arraycopy(obj, 0, this.f230f, 0, this.f232h);
                System.arraycopy(obj2, 0, this.f231g, 0, this.f232h << 1);
            }
            C0033l.m267a(obj, obj2, this.f232h);
        }
    }

    public Object m274b(int i) {
        return this.f231g[i << 1];
    }

    public Object m275c(int i) {
        return this.f231g[(i << 1) + 1];
    }

    public void clear() {
        if (this.f232h != 0) {
            C0033l.m267a(this.f230f, this.f231g, this.f232h);
            this.f230f = C0037c.f238a;
            this.f231g = C0037c.f240c;
            this.f232h = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return obj == null ? m269a() >= 0 : m271a(obj, obj.hashCode()) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m270a(obj) >= 0;
    }

    public Object m276d(int i) {
        int i2 = 8;
        Object obj = this.f231g[(i << 1) + 1];
        if (this.f232h <= 1) {
            C0033l.m267a(this.f230f, this.f231g, this.f232h);
            this.f230f = C0037c.f238a;
            this.f231g = C0037c.f240c;
            this.f232h = 0;
        } else if (this.f230f.length <= 8 || this.f232h >= this.f230f.length / 3) {
            this.f232h--;
            if (i < this.f232h) {
                System.arraycopy(this.f230f, i + 1, this.f230f, i, this.f232h - i);
                System.arraycopy(this.f231g, (i + 1) << 1, this.f231g, i << 1, (this.f232h - i) << 1);
            }
            this.f231g[this.f232h << 1] = null;
            this.f231g[(this.f232h << 1) + 1] = null;
        } else {
            if (this.f232h > 8) {
                i2 = this.f232h + (this.f232h >> 1);
            }
            Object obj2 = this.f230f;
            Object obj3 = this.f231g;
            m268e(i2);
            this.f232h--;
            if (i > 0) {
                System.arraycopy(obj2, 0, this.f230f, 0, i);
                System.arraycopy(obj3, 0, this.f231g, 0, i << 1);
            }
            if (i < this.f232h) {
                System.arraycopy(obj2, i + 1, this.f230f, i, this.f232h - i);
                System.arraycopy(obj3, (i + 1) << 1, this.f231g, i << 1, (this.f232h - i) << 1);
            }
        }
        return obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f232h) {
            try {
                Object b = m274b(i);
                Object c = m275c(i);
                Object obj2 = map.get(b);
                if (c == null) {
                    if (obj2 != null || !map.containsKey(b)) {
                        return false;
                    }
                } else if (!c.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public Object get(Object obj) {
        int a = obj == null ? m269a() : m271a(obj, obj.hashCode());
        return a >= 0 ? this.f231g[(a << 1) + 1] : null;
    }

    public int hashCode() {
        int[] iArr = this.f230f;
        Object[] objArr = this.f231g;
        int i = this.f232h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.f232h <= 0;
    }

    public Object put(Object obj, Object obj2) {
        int a;
        int i;
        int i2 = 8;
        if (obj == null) {
            a = m269a();
            i = 0;
        } else {
            i = obj.hashCode();
            a = m271a(obj, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            Object obj3 = this.f231g[i3];
            this.f231g[i3] = obj2;
            return obj3;
        }
        a ^= -1;
        if (this.f232h >= this.f230f.length) {
            if (this.f232h >= 8) {
                i2 = this.f232h + (this.f232h >> 1);
            } else if (this.f232h < 4) {
                i2 = 4;
            }
            Object obj4 = this.f230f;
            Object obj5 = this.f231g;
            m268e(i2);
            if (this.f230f.length > 0) {
                System.arraycopy(obj4, 0, this.f230f, 0, obj4.length);
                System.arraycopy(obj5, 0, this.f231g, 0, obj5.length);
            }
            C0033l.m267a(obj4, obj5, this.f232h);
        }
        if (a < this.f232h) {
            System.arraycopy(this.f230f, a, this.f230f, a + 1, this.f232h - a);
            System.arraycopy(this.f231g, a << 1, this.f231g, (a + 1) << 1, (this.f232h - a) << 1);
        }
        this.f230f[a] = i;
        this.f231g[a << 1] = obj;
        this.f231g[(a << 1) + 1] = obj2;
        this.f232h++;
        return null;
    }

    public Object remove(Object obj) {
        int a = obj == null ? m269a() : m271a(obj, obj.hashCode());
        return a >= 0 ? m276d(a) : null;
    }

    public int size() {
        return this.f232h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f232h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f232h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0033l b = m274b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m275c(i);
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
