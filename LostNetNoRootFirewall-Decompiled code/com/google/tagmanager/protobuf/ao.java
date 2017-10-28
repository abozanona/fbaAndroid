package com.google.tagmanager.protobuf;

import java.util.ListIterator;

class ao implements ListIterator {
    ListIterator f1233a = this.f1235c.list.listIterator(this.f1234b);
    final /* synthetic */ int f1234b;
    final /* synthetic */ UnmodifiableLazyStringList f1235c;

    ao(UnmodifiableLazyStringList unmodifiableLazyStringList, int i) {
        this.f1235c = unmodifiableLazyStringList;
        this.f1234b = i;
    }

    public String m1807a() {
        return (String) this.f1233a.next();
    }

    public void m1808a(String str) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ void add(Object obj) {
        m1810b((String) obj);
    }

    public String m1809b() {
        return (String) this.f1233a.previous();
    }

    public void m1810b(String str) {
        throw new UnsupportedOperationException();
    }

    public boolean hasNext() {
        return this.f1233a.hasNext();
    }

    public boolean hasPrevious() {
        return this.f1233a.hasPrevious();
    }

    public /* synthetic */ Object next() {
        return m1807a();
    }

    public int nextIndex() {
        return this.f1233a.nextIndex();
    }

    public /* synthetic */ Object previous() {
        return m1809b();
    }

    public int previousIndex() {
        return this.f1233a.previousIndex();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ void set(Object obj) {
        m1808a((String) obj);
    }
}
