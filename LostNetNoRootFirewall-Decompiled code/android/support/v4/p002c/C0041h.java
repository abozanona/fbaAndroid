package android.support.v4.p002c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class C0041h implements Set {
    final /* synthetic */ C0035f f248a;

    C0041h(C0035f c0035f) {
        this.f248a = c0035f;
    }

    public boolean m311a(Entry entry) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ boolean add(Object obj) {
        return m311a((Entry) obj);
    }

    public boolean addAll(Collection collection) {
        int a = this.f248a.mo20a();
        for (Entry entry : collection) {
            this.f248a.mo25a(entry.getKey(), entry.getValue());
        }
        return a != this.f248a.mo20a();
    }

    public void clear() {
        this.f248a.mo28c();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        int a = this.f248a.mo21a(entry.getKey());
        return a >= 0 ? C0037c.m307a(this.f248a.mo22a(a, 1), entry.getValue()) : false;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        return C0035f.m279a((Set) this, obj);
    }

    public int hashCode() {
        int a = this.f248a.mo20a() - 1;
        int i = 0;
        while (a >= 0) {
            Object a2 = this.f248a.mo22a(a, 0);
            Object a3 = this.f248a.mo22a(a, 1);
            a--;
            i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f248a.mo20a() == 0;
    }

    public Iterator iterator() {
        return new C0043j(this.f248a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f248a.mo20a();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray(Object[] objArr) {
        throw new UnsupportedOperationException();
    }
}
