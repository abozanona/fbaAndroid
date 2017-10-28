package com.google.tagmanager.protobuf;

import java.io.InputStream;

class af extends InputStream {
    final /* synthetic */ aa f1211a;
    private ad f1212b;
    private C0239x f1213c;
    private int f1214d;
    private int f1215e;
    private int f1216f;
    private int f1217g;

    public af(aa aaVar) {
        this.f1211a = aaVar;
        m1780a();
    }

    private int m1779a(byte[] bArr, int i, int i2) {
        int i3 = i2;
        int i4 = i;
        while (i3 > 0) {
            m1781b();
            if (this.f1213c == null) {
                if (i3 == i2) {
                    return -1;
                }
                return i2 - i3;
            }
            int min = Math.min(this.f1214d - this.f1215e, i3);
            if (bArr != null) {
                this.f1213c.copyTo(bArr, this.f1215e, i4, min);
                i4 += min;
            }
            this.f1215e += min;
            i3 -= min;
        }
        return i2 - i3;
    }

    private void m1780a() {
        this.f1212b = new ad(this.f1211a);
        this.f1213c = this.f1212b.m1777a();
        this.f1214d = this.f1213c.size();
        this.f1215e = 0;
        this.f1216f = 0;
    }

    private void m1781b() {
        if (this.f1213c != null && this.f1215e == this.f1214d) {
            this.f1216f += this.f1214d;
            this.f1215e = 0;
            if (this.f1212b.hasNext()) {
                this.f1213c = this.f1212b.m1777a();
                this.f1214d = this.f1213c.size();
                return;
            }
            this.f1213c = null;
            this.f1214d = 0;
        }
    }

    public int available() {
        return this.f1211a.size() - (this.f1216f + this.f1215e);
    }

    public void mark(int i) {
        this.f1217g = this.f1216f + this.f1215e;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        m1781b();
        if (this.f1213c == null) {
            return -1;
        }
        C0239x c0239x = this.f1213c;
        int i = this.f1215e;
        this.f1215e = i + 1;
        return c0239x.byteAt(i) & 255;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException();
        } else if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
            return m1779a(bArr, i, i2);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public synchronized void reset() {
        m1780a();
        m1779a(null, 0, this.f1217g);
    }

    public long skip(long j) {
        if (j < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (j > 2147483647L) {
            j = 2147483647L;
        }
        return (long) m1779a(null, 0, (int) j);
    }
}
