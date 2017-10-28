package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.ByteString.ByteIterator;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aa extends ByteString {
    private static final int[] f1197a;
    private final int f1198b;
    private final ByteString f1199c;
    private final ByteString f1200d;
    private final int f1201e;
    private final int f1202f;
    private int f1203g;

    static {
        int i = 1;
        List arrayList = new ArrayList();
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.valueOf(Integer.MAX_VALUE));
        f1197a = new int[arrayList.size()];
        for (i2 = 0; i2 < f1197a.length; i2++) {
            f1197a[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
    }

    private aa(ByteString byteString, ByteString byteString2) {
        this.f1203g = 0;
        this.f1199c = byteString;
        this.f1200d = byteString2;
        this.f1201e = byteString.size();
        this.f1198b = this.f1201e + byteString2.size();
        this.f1202f = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    static ByteString m1764a(ByteString byteString, ByteString byteString2) {
        aa aaVar = byteString instanceof aa ? (aa) byteString : null;
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return m1769b(byteString, byteString2);
        }
        if (aaVar != null && aaVar.f1200d.size() + byteString2.size() < 128) {
            return new aa(aaVar.f1199c, m1769b(aaVar.f1200d, byteString2));
        } else if (aaVar == null || aaVar.f1199c.getTreeDepth() <= aaVar.f1200d.getTreeDepth() || aaVar.getTreeDepth() <= byteString2.getTreeDepth()) {
            return size >= f1197a[Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1] ? new aa(byteString, byteString2) : new ac().m1771a(byteString, byteString2);
        } else {
            return new aa(aaVar.f1199c, new aa(aaVar.f1200d, byteString2));
        }
    }

    private boolean m1766a(ByteString byteString) {
        Iterator adVar = new ad(this);
        C0239x c0239x = (C0239x) adVar.next();
        Iterator adVar2 = new ad(byteString);
        C0239x c0239x2 = (C0239x) adVar2.next();
        int i = 0;
        C0239x c0239x3 = c0239x;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = c0239x3.size() - i2;
            int size2 = c0239x2.size() - i;
            int min = Math.min(size, size2);
            if (!(i2 == 0 ? c0239x3.m1825a(c0239x2, i, min) : c0239x2.m1825a(c0239x3, i2, min))) {
                return false;
            }
            int i4 = i3 + min;
            if (i4 >= this.f1198b) {
                break;
            }
            boolean z;
            if (min == size) {
                c0239x3 = (C0239x) adVar.next();
                i2 = 0;
            } else {
                i2 += min;
            }
            if (min == size2) {
                c0239x = (C0239x) adVar2.next();
                z = false;
            } else {
                C0239x c0239x4 = c0239x2;
                z = i + min;
                c0239x = c0239x4;
            }
            boolean z2 = z;
            c0239x2 = c0239x;
            i3 = i4;
        }
        if (i4 == this.f1198b) {
            return true;
        }
        throw new IllegalStateException();
    }

    private static C0239x m1769b(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[(size + size2)];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return new C0239x(bArr);
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public List asReadOnlyByteBufferList() {
        List arrayList = new ArrayList();
        ad adVar = new ad(this);
        while (adVar.hasNext()) {
            arrayList.add(adVar.m1777a().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    public byte byteAt(int i) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        } else if (i <= this.f1198b) {
            return i < this.f1201e ? this.f1199c.byteAt(i) : this.f1200d.byteAt(i - this.f1201e);
        } else {
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + this.f1198b);
        }
    }

    public void copyTo(ByteBuffer byteBuffer) {
        this.f1199c.copyTo(byteBuffer);
        this.f1200d.copyTo(byteBuffer);
    }

    protected void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        if (i + i3 <= this.f1201e) {
            this.f1199c.copyToInternal(bArr, i, i2, i3);
        } else if (i >= this.f1201e) {
            this.f1200d.copyToInternal(bArr, i - this.f1201e, i2, i3);
        } else {
            int i4 = this.f1201e - i;
            this.f1199c.copyToInternal(bArr, i, i2, i4);
            this.f1200d.copyToInternal(bArr, 0, i2 + i4, i3 - i4);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.f1198b != byteString.size()) {
            return false;
        }
        if (this.f1198b == 0) {
            return true;
        }
        if (this.f1203g != 0) {
            int peekCachedHashCode = byteString.peekCachedHashCode();
            if (!(peekCachedHashCode == 0 || this.f1203g == peekCachedHashCode)) {
                return false;
            }
        }
        return m1766a(byteString);
    }

    protected int getTreeDepth() {
        return this.f1202f;
    }

    public int hashCode() {
        int i = this.f1203g;
        if (i == 0) {
            i = partialHash(this.f1198b, 0, this.f1198b);
            if (i == 0) {
                i = 1;
            }
            this.f1203g = i;
        }
        return i;
    }

    protected boolean isBalanced() {
        return this.f1198b >= f1197a[this.f1202f];
    }

    public boolean isValidUtf8() {
        return this.f1200d.partialIsValidUtf8(this.f1199c.partialIsValidUtf8(0, 0, this.f1201e), 0, this.f1200d.size()) == 0;
    }

    public ByteIterator iterator() {
        return new ae();
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(new af(this));
    }

    public InputStream newInput() {
        return new af(this);
    }

    protected int partialHash(int i, int i2, int i3) {
        if (i2 + i3 <= this.f1201e) {
            return this.f1199c.partialHash(i, i2, i3);
        }
        if (i2 >= this.f1201e) {
            return this.f1200d.partialHash(i, i2 - this.f1201e, i3);
        }
        int i4 = this.f1201e - i2;
        return this.f1200d.partialHash(this.f1199c.partialHash(i, i2, i4), 0, i3 - i4);
    }

    protected int partialIsValidUtf8(int i, int i2, int i3) {
        if (i2 + i3 <= this.f1201e) {
            return this.f1199c.partialIsValidUtf8(i, i2, i3);
        }
        if (i2 >= this.f1201e) {
            return this.f1200d.partialIsValidUtf8(i, i2 - this.f1201e, i3);
        }
        int i4 = this.f1201e - i2;
        return this.f1200d.partialIsValidUtf8(this.f1199c.partialIsValidUtf8(i, i2, i4), 0, i3 - i4);
    }

    protected int peekCachedHashCode() {
        return this.f1203g;
    }

    public int size() {
        return this.f1198b;
    }

    public ByteString substring(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 > this.f1198b) {
            throw new IndexOutOfBoundsException("End index: " + i2 + " > " + this.f1198b);
        } else {
            int i3 = i2 - i;
            if (i3 >= 0) {
                return i3 == 0 ? ByteString.EMPTY : i3 != this.f1198b ? i2 <= this.f1201e ? this.f1199c.substring(i, i2) : i >= this.f1201e ? this.f1200d.substring(i - this.f1201e, i2 - this.f1201e) : new aa(this.f1199c.substring(i), this.f1200d.substring(0, i2 - this.f1201e)) : this;
            } else {
                throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
            }
        }
    }

    public String toString(String str) {
        return new String(toByteArray(), str);
    }

    public void writeTo(OutputStream outputStream) {
        this.f1199c.writeTo(outputStream);
        this.f1200d.writeTo(outputStream);
    }

    void writeToInternal(OutputStream outputStream, int i, int i2) {
        if (i + i2 <= this.f1201e) {
            this.f1199c.writeToInternal(outputStream, i, i2);
        } else if (i >= this.f1201e) {
            this.f1200d.writeToInternal(outputStream, i - this.f1201e, i2);
        } else {
            int i3 = this.f1201e - i;
            this.f1199c.writeToInternal(outputStream, i, i3);
            this.f1200d.writeToInternal(outputStream, 0, i2 - i3);
        }
    }
}
