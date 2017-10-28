package android.support.v4.p002c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class C0042i implements Set {
    final /* synthetic */ C0035f f249a;

    C0042i(C0035f c0035f) {
        this.f249a = c0035f;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f249a.mo28c();
    }

    public boolean contains(Object obj) {
        return this.f249a.mo21a(obj) >= 0;
    }

    public boolean containsAll(Collection collection) {
        return C0035f.m278a(this.f249a.mo27b(), collection);
    }

    public boolean equals(Object obj) {
        return C0035f.m279a((Set) this, obj);
    }

    public int hashCode() {
        int i = 0;
        for (int a = this.f249a.mo20a() - 1; a >= 0; a--) {
            Object a2 = this.f249a.mo22a(a, 0);
            i += a2 == null ? 0 : a2.hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f249a.mo20a() == 0;
    }

    public Iterator iterator() {
        return new C0040g(this.f249a, 0);
    }

    public boolean remove(Object obj) {
        int a = this.f249a.mo21a(obj);
        if (a < 0) {
            return false;
        }
        this.f249a.mo24a(a);
        return true;
    }

    public boolean removeAll(Collection collection) {
        return C0035f.m280b(this.f249a.mo27b(), collection);
    }

    public boolean retainAll(Collection collection) {
        return C0035f.m281c(this.f249a.mo27b(), collection);
    }

    public int size() {
        return this.f249a.mo20a();
    }

    public Object[] toArray() {
        return this.f249a.m291b(0);
    }

    public Object[] toArray(Object[] objArr) {
        return this.f249a.m288a(objArr, 0);
    }
}
