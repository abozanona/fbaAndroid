package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.ByteString.ByteIterator;
import java.util.NoSuchElementException;

class C0262z implements ByteIterator {
    final /* synthetic */ C0239x f1275a;
    private int f1276b;
    private final int f1277c;

    private C0262z(C0239x c0239x) {
        this.f1275a = c0239x;
        this.f1276b = 0;
        this.f1277c = c0239x.size();
    }

    public Byte m1843a() {
        return Byte.valueOf(nextByte());
    }

    public boolean hasNext() {
        return this.f1276b < this.f1277c;
    }

    public /* synthetic */ Object next() {
        return m1843a();
    }

    public byte nextByte() {
        try {
            byte[] bArr = this.f1275a.f1239a;
            int i = this.f1276b;
            this.f1276b = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
