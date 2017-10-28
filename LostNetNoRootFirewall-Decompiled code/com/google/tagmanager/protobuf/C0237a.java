package com.google.tagmanager.protobuf;

import java.io.FilterInputStream;
import java.io.InputStream;

final class C0237a extends FilterInputStream {
    private int f1196a;

    C0237a(InputStream inputStream, int i) {
        super(inputStream);
        this.f1196a = i;
    }

    public int available() {
        return Math.min(super.available(), this.f1196a);
    }

    public int read() {
        if (this.f1196a <= 0) {
            return -1;
        }
        int read = super.read();
        if (read < 0) {
            return read;
        }
        this.f1196a--;
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.f1196a <= 0) {
            return -1;
        }
        int read = super.read(bArr, i, Math.min(i2, this.f1196a));
        if (read < 0) {
            return read;
        }
        this.f1196a -= read;
        return read;
    }

    public long skip(long j) {
        long skip = super.skip(Math.min(j, (long) this.f1196a));
        if (skip >= 0) {
            this.f1196a = (int) (((long) this.f1196a) - skip);
        }
        return skip;
    }
}
