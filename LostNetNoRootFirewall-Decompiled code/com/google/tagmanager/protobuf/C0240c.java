package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.ByteString.ByteIterator;

class C0240c extends C0239x {
    private final int f1241b;
    private final int f1242c;

    C0240c(byte[] bArr, int i, int i2) {
        super(bArr);
        if (i < 0) {
            throw new IllegalArgumentException("Offset too small: " + i);
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Length too small: " + i);
        } else if (((long) i) + ((long) i2) > ((long) bArr.length)) {
            throw new IllegalArgumentException("Offset+Length too large: " + i + "+" + i2);
        } else {
            this.f1241b = i;
            this.f1242c = i2;
        }
    }

    protected int mo719a() {
        return this.f1241b;
    }

    public byte byteAt(int i) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index too small: " + i);
        } else if (i < size()) {
            return this.a[this.f1241b + i];
        } else {
            throw new ArrayIndexOutOfBoundsException("Index too large: " + i + ", " + size());
        }
    }

    protected void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.a, mo719a() + i, bArr, i2, i3);
    }

    public ByteIterator iterator() {
        return new C0242e();
    }

    public int size() {
        return this.f1242c;
    }
}
