package com.google.tagmanager.protobuf;

import java.io.Serializable;

final class C0255r implements Serializable {
    private String f1265a;
    private byte[] f1266b;

    C0255r(MutableMessageLite mutableMessageLite) {
        this.f1265a = mutableMessageLite.getClass().getName();
        this.f1266b = mutableMessageLite.toByteArray();
    }
}
