package com.google.tagmanager.protobuf;

final class C0244g {
    private final CodedOutputStream f1246a;
    private final byte[] f1247b;

    private C0244g(int i) {
        this.f1247b = new byte[i];
        this.f1246a = CodedOutputStream.newInstance(this.f1247b);
    }

    public ByteString m1828a() {
        this.f1246a.checkNoSpaceLeft();
        return new C0239x(this.f1247b);
    }

    public CodedOutputStream m1829b() {
        return this.f1246a;
    }
}
