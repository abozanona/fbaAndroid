package com.google.tagmanager.protobuf;

import java.util.Iterator;

class ap implements Iterator {
    Iterator f1236a = this.f1237b.list.iterator();
    final /* synthetic */ UnmodifiableLazyStringList f1237b;

    ap(UnmodifiableLazyStringList unmodifiableLazyStringList) {
        this.f1237b = unmodifiableLazyStringList;
    }

    public String m1811a() {
        return (String) this.f1236a.next();
    }

    public boolean hasNext() {
        return this.f1236a.hasNext();
    }

    public /* synthetic */ Object next() {
        return m1811a();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
