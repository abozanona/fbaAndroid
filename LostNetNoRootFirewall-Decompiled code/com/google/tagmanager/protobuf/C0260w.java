package com.google.tagmanager.protobuf;

import java.util.AbstractList;
import java.util.List;

class C0260w extends AbstractList {
    private final List f1274a;

    C0260w(List list) {
        this.f1274a = list;
    }

    public byte[] m1839a(int i) {
        Object obj = this.f1274a.get(i);
        Object access$000 = LazyStringArrayList.asByteArray(obj);
        if (access$000 != obj) {
            this.f1274a.set(i, access$000);
        }
        return access$000;
    }

    public byte[] m1840a(int i, byte[] bArr) {
        return LazyStringArrayList.asByteArray(this.f1274a.set(i, bArr));
    }

    public /* synthetic */ void add(int i, Object obj) {
        m1841b(i, (byte[]) obj);
    }

    public void m1841b(int i, byte[] bArr) {
        this.f1274a.add(i, bArr);
        this.modCount++;
    }

    public byte[] m1842b(int i) {
        Object remove = this.f1274a.remove(i);
        this.modCount++;
        return LazyStringArrayList.asByteArray(remove);
    }

    public /* synthetic */ Object get(int i) {
        return m1839a(i);
    }

    public /* synthetic */ Object remove(int i) {
        return m1842b(i);
    }

    public /* synthetic */ Object set(int i, Object obj) {
        return m1840a(i, (byte[]) obj);
    }

    public int size() {
        return this.f1274a.size();
    }
}
