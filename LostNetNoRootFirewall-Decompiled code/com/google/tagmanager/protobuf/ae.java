package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.ByteString.ByteIterator;

class ae implements ByteIterator {
    int f1207a;
    final /* synthetic */ aa f1208b;
    private final ad f1209c;
    private ByteIterator f1210d;

    private ae(aa aaVar) {
        this.f1208b = aaVar;
        this.f1209c = new ad(aaVar);
        this.f1210d = this.f1209c.m1777a().iterator();
        this.f1207a = aaVar.size();
    }

    public Byte m1778a() {
        return Byte.valueOf(nextByte());
    }

    public boolean hasNext() {
        return this.f1207a > 0;
    }

    public /* synthetic */ Object next() {
        return m1778a();
    }

    public byte nextByte() {
        if (!this.f1210d.hasNext()) {
            this.f1210d = this.f1209c.m1777a().iterator();
        }
        this.f1207a--;
        return this.f1210d.nextByte();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
