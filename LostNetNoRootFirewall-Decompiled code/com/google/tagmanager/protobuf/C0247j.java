package com.google.tagmanager.protobuf;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

class C0247j implements C0246i {
    final /* synthetic */ CodedInputStream f1248a;
    private int f1249b;
    private ByteArrayOutputStream f1250c;

    private C0247j(CodedInputStream codedInputStream) {
        this.f1248a = codedInputStream;
        this.f1249b = this.f1248a.bufferPos;
    }

    public void mo720a() {
        if (this.f1250c == null) {
            this.f1250c = new ByteArrayOutputStream();
        }
        this.f1250c.write(this.f1248a.buffer, this.f1249b, this.f1248a.bufferPos - this.f1249b);
        this.f1249b = 0;
    }

    ByteBuffer m1832b() {
        if (this.f1250c == null) {
            return ByteBuffer.wrap(this.f1248a.buffer, this.f1249b, this.f1248a.bufferPos - this.f1249b);
        }
        this.f1250c.write(this.f1248a.buffer, this.f1249b, this.f1248a.bufferPos);
        return ByteBuffer.wrap(this.f1250c.toByteArray());
    }
}
