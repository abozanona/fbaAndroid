package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.ByteString.ByteIterator;
import java.util.NoSuchElementException;

class C0242e implements ByteIterator {
    final /* synthetic */ C0240c f1243a;
    private int f1244b;
    private final int f1245c;

    private C0242e(C0240c c0240c) {
        this.f1243a = c0240c;
        this.f1244b = c0240c.mo719a();
        this.f1245c = this.f1244b + c0240c.size();
    }

    public Byte m1827a() {
        return Byte.valueOf(nextByte());
    }

    public boolean hasNext() {
        return this.f1244b < this.f1245c;
    }

    public /* synthetic */ Object next() {
        return m1827a();
    }

    public byte nextByte() {
        if (this.f1244b >= this.f1245c) {
            throw new NoSuchElementException();
        }
        byte[] bArr = this.f1243a.a;
        int i = this.f1244b;
        this.f1244b = i + 1;
        return bArr[i];
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
