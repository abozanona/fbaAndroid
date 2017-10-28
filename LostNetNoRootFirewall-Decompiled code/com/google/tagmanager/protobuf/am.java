package com.google.tagmanager.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

class am implements Iterator {
    final /* synthetic */ ag f1228a;
    private int f1229b;
    private boolean f1230c;
    private Iterator f1231d;

    private am(ag agVar) {
        this.f1228a = agVar;
        this.f1229b = -1;
    }

    private Iterator m1804b() {
        if (this.f1231d == null) {
            this.f1231d = this.f1228a.f1220c.entrySet().iterator();
        }
        return this.f1231d;
    }

    public Entry m1805a() {
        this.f1230c = true;
        int i = this.f1229b + 1;
        this.f1229b = i;
        return i < this.f1228a.f1219b.size() ? (Entry) this.f1228a.f1219b.get(this.f1229b) : (Entry) m1804b().next();
    }

    public boolean hasNext() {
        return this.f1229b + 1 < this.f1228a.f1219b.size() || m1804b().hasNext();
    }

    public /* synthetic */ Object next() {
        return m1805a();
    }

    public void remove() {
        if (this.f1230c) {
            this.f1230c = false;
            this.f1228a.m1789e();
            if (this.f1229b < this.f1228a.f1219b.size()) {
                ag agVar = this.f1228a;
                int i = this.f1229b;
                this.f1229b = i - 1;
                agVar.m1787c(i);
                return;
            }
            m1804b().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
