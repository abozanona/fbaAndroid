package com.google.tagmanager.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

class C0259v implements Iterator {
    private Iterator f1273a;

    public C0259v(Iterator it) {
        this.f1273a = it;
    }

    public Entry m1838a() {
        Entry entry = (Entry) this.f1273a.next();
        return entry.getValue() instanceof C0256s ? new C0258u(entry) : entry;
    }

    public boolean hasNext() {
        return this.f1273a.hasNext();
    }

    public /* synthetic */ Object next() {
        return m1838a();
    }

    public void remove() {
        this.f1273a.remove();
    }
}
