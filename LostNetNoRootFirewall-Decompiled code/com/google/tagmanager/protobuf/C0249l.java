package com.google.tagmanager.protobuf;

final class C0249l {
    private final Object f1252a;
    private final int f1253b;

    C0249l(Object obj, int i) {
        this.f1252a = obj;
        this.f1253b = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0249l)) {
            return false;
        }
        C0249l c0249l = (C0249l) obj;
        return this.f1252a == c0249l.f1252a && this.f1253b == c0249l.f1253b;
    }

    public int hashCode() {
        return (System.identityHashCode(this.f1252a) * 65535) + this.f1253b;
    }
}
