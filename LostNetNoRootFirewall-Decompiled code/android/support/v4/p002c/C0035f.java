package android.support.v4.p002c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class C0035f {
    C0041h f234b;
    C0042i f235c;
    C0044k f236d;

    C0035f() {
    }

    public static boolean m278a(Map map, Collection collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static boolean m279a(Set set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static boolean m280b(Map map, Collection collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static boolean m281c(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int mo20a();

    protected abstract int mo21a(Object obj);

    protected abstract Object mo22a(int i, int i2);

    protected abstract Object mo23a(int i, Object obj);

    protected abstract void mo24a(int i);

    protected abstract void mo25a(Object obj, Object obj2);

    public Object[] m288a(Object[] objArr, int i) {
        int a = mo20a();
        Object[] objArr2 = objArr.length < a ? (Object[]) Array.newInstance(objArr.getClass().getComponentType(), a) : objArr;
        for (int i2 = 0; i2 < a; i2++) {
            objArr2[i2] = mo22a(i2, i);
        }
        if (objArr2.length > a) {
            objArr2[a] = null;
        }
        return objArr2;
    }

    protected abstract int mo26b(Object obj);

    protected abstract Map mo27b();

    public Object[] m291b(int i) {
        int a = mo20a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo22a(i2, i);
        }
        return objArr;
    }

    protected abstract void mo28c();

    public Set m293d() {
        if (this.f234b == null) {
            this.f234b = new C0041h(this);
        }
        return this.f234b;
    }

    public Set m294e() {
        if (this.f235c == null) {
            this.f235c = new C0042i(this);
        }
        return this.f235c;
    }

    public Collection m295f() {
        if (this.f236d == null) {
            this.f236d = new C0044k(this);
        }
        return this.f236d;
    }
}
