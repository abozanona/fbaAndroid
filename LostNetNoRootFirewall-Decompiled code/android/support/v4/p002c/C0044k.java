package android.support.v4.p002c;

import java.util.Collection;
import java.util.Iterator;

final class C0044k implements Collection {
    final /* synthetic */ C0035f f254a;

    C0044k(C0035f c0035f) {
        this.f254a = c0035f;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f254a.mo28c();
    }

    public boolean contains(Object obj) {
        return this.f254a.mo26b(obj) >= 0;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f254a.mo20a() == 0;
    }

    public Iterator iterator() {
        return new C0040g(this.f254a, 1);
    }

    public boolean remove(Object obj) {
        int b = this.f254a.mo26b(obj);
        if (b < 0) {
            return false;
        }
        this.f254a.mo24a(b);
        return true;
    }

    public boolean removeAll(Collection collection) {
        int i = 0;
        int a = this.f254a.mo20a();
        boolean z = false;
        while (i < a) {
            if (collection.contains(this.f254a.mo22a(i, 1))) {
                this.f254a.mo24a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public boolean retainAll(Collection collection) {
        int i = 0;
        int a = this.f254a.mo20a();
        boolean z = false;
        while (i < a) {
            if (!collection.contains(this.f254a.mo22a(i, 1))) {
                this.f254a.mo24a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public int size() {
        return this.f254a.mo20a();
    }

    public Object[] toArray() {
        return this.f254a.m291b(1);
    }

    public Object[] toArray(Object[] objArr) {
        return this.f254a.m288a(objArr, 1);
    }
}
