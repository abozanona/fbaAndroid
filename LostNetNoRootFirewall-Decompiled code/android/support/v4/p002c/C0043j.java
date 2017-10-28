package android.support.v4.p002c;

import java.util.Iterator;
import java.util.Map.Entry;

final class C0043j implements Iterator, Entry {
    int f250a;
    int f251b;
    boolean f252c = false;
    final /* synthetic */ C0035f f253d;

    C0043j(C0035f c0035f) {
        this.f253d = c0035f;
        this.f250a = c0035f.mo20a() - 1;
        this.f251b = -1;
    }

    public Entry m312a() {
        this.f251b++;
        this.f252c = true;
        return this;
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (!this.f252c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry entry = (Entry) obj;
            if (!(C0037c.m307a(entry.getKey(), this.f253d.mo22a(this.f251b, 0)) && C0037c.m307a(entry.getValue(), this.f253d.mo22a(this.f251b, 1)))) {
                z = false;
            }
            return z;
        }
    }

    public Object getKey() {
        if (this.f252c) {
            return this.f253d.mo22a(this.f251b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public Object getValue() {
        if (this.f252c) {
            return this.f253d.mo22a(this.f251b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public boolean hasNext() {
        return this.f251b < this.f250a;
    }

    public final int hashCode() {
        int i = 0;
        if (this.f252c) {
            Object a = this.f253d.mo22a(this.f251b, 0);
            Object a2 = this.f253d.mo22a(this.f251b, 1);
            int hashCode = a == null ? 0 : a.hashCode();
            if (a2 != null) {
                i = a2.hashCode();
            }
            return i ^ hashCode;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public /* synthetic */ Object next() {
        return m312a();
    }

    public void remove() {
        if (this.f252c) {
            this.f253d.mo24a(this.f251b);
            this.f251b--;
            this.f250a--;
            this.f252c = false;
            return;
        }
        throw new IllegalStateException();
    }

    public Object setValue(Object obj) {
        if (this.f252c) {
            return this.f253d.mo23a(this.f251b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
