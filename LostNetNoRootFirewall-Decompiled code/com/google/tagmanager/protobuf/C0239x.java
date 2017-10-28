package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.ByteString.ByteIterator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class C0239x extends ByteString {
    protected final byte[] f1239a;
    private int f1240b = 0;

    C0239x(byte[] bArr) {
        this.f1239a = bArr;
    }

    static int m1822a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static int m1823a(byte[] bArr) {
        int a = C0239x.m1822a(bArr.length, bArr, 0, bArr.length);
        return a == 0 ? 1 : a;
    }

    protected int mo719a() {
        return 0;
    }

    boolean m1825a(C0239x c0239x, int i, int i2) {
        if (i2 > c0239x.size()) {
            throw new IllegalArgumentException("Length too large: " + i2 + size());
        } else if (i + i2 > c0239x.size()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + c0239x.size());
        } else {
            byte[] bArr = this.f1239a;
            byte[] bArr2 = c0239x.f1239a;
            int a = mo719a() + i2;
            int a2 = mo719a();
            int a3 = c0239x.mo719a() + i;
            while (a2 < a) {
                if (bArr[a2] != bArr2[a3]) {
                    return false;
                }
                a2++;
                a3++;
            }
            return true;
        }
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(this.f1239a, mo719a(), size()).asReadOnlyBuffer();
    }

    public List asReadOnlyByteBufferList() {
        List arrayList = new ArrayList(1);
        arrayList.add(asReadOnlyByteBuffer());
        return arrayList;
    }

    public byte byteAt(int i) {
        return this.f1239a[i];
    }

    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.f1239a, mo719a(), size());
    }

    protected void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f1239a, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        if (size() != ((ByteString) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof C0239x) {
            return m1825a((C0239x) obj, 0, size());
        }
        if (obj instanceof aa) {
            return obj.equals(this);
        }
        throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + obj.getClass());
    }

    protected int getTreeDepth() {
        return 0;
    }

    public int hashCode() {
        int i = this.f1240b;
        if (i == 0) {
            i = size();
            i = partialHash(i, 0, i);
            if (i == 0) {
                i = 1;
            }
            this.f1240b = i;
        }
        return i;
    }

    protected boolean isBalanced() {
        return true;
    }

    public boolean isValidUtf8() {
        int a = mo719a();
        return aq.m1817a(this.f1239a, a, size() + a);
    }

    public ByteIterator iterator() {
        return new C0262z();
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this);
    }

    public InputStream newInput() {
        return new ByteArrayInputStream(this.f1239a, mo719a(), size());
    }

    protected int partialHash(int i, int i2, int i3) {
        return C0239x.m1822a(i, this.f1239a, mo719a() + i2, i3);
    }

    protected int partialIsValidUtf8(int i, int i2, int i3) {
        int a = mo719a() + i2;
        return aq.m1815a(i, this.f1239a, a, a + i3);
    }

    protected int peekCachedHashCode() {
        return this.f1240b;
    }

    public int size() {
        return this.f1239a.length;
    }

    public ByteString substring(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 > size()) {
            throw new IndexOutOfBoundsException("End index: " + i2 + " > " + size());
        } else {
            int i3 = i2 - i;
            if (i3 >= 0) {
                return i3 == 0 ? ByteString.EMPTY : new C0240c(this.f1239a, mo719a() + i, i3);
            } else {
                throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
            }
        }
    }

    public String toString(String str) {
        return new String(this.f1239a, mo719a(), size(), str);
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.write(toByteArray());
    }

    void writeToInternal(OutputStream outputStream, int i, int i2) {
        outputStream.write(this.f1239a, mo719a() + i, i2);
    }
}
