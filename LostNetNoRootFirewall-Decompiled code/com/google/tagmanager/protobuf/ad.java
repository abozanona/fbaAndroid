package com.google.tagmanager.protobuf;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ad implements Iterator {
    private final Deque f1205a;
    private C0239x f1206b;

    private ad(ByteString byteString) {
        this.f1205a = new ArrayDeque(aa.f1197a.length);
        this.f1206b = m1775a(byteString);
    }

    private C0239x m1775a(ByteString byteString) {
        ByteString byteString2 = byteString;
        while (byteString2 instanceof aa) {
            aa aaVar = (aa) byteString2;
            this.f1205a.push(aaVar);
            byteString2 = aaVar.f1199c;
        }
        return (C0239x) byteString2;
    }

    private C0239x m1776b() {
        while (!this.f1205a.isEmpty()) {
            C0239x a = m1775a(((aa) this.f1205a.pop()).f1200d);
            if (!a.isEmpty()) {
                return a;
            }
        }
        return null;
    }

    public C0239x m1777a() {
        if (this.f1206b == null) {
            throw new NoSuchElementException();
        }
        C0239x c0239x = this.f1206b;
        this.f1206b = m1776b();
        return c0239x;
    }

    public boolean hasNext() {
        return this.f1206b != null;
    }

    public /* synthetic */ Object next() {
        return m1777a();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
