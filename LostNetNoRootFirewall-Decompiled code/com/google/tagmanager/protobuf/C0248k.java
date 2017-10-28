package com.google.tagmanager.protobuf;

import java.io.OutputStream;
import java.nio.ByteBuffer;

class C0248k extends OutputStream {
    private final ByteBuffer f1251a;

    public C0248k(ByteBuffer byteBuffer) {
        this.f1251a = byteBuffer;
    }

    public void write(int i) {
        this.f1251a.put((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.f1251a.put(bArr, i, i2);
    }
}
