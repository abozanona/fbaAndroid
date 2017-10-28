package com.google.tagmanager.protobuf;

import java.io.Serializable;

final class C0253p implements Serializable {
    private String f1262a;
    private byte[] f1263b;

    C0253p(MessageLite messageLite) {
        this.f1262a = messageLite.getClass().getName();
        this.f1263b = messageLite.toByteArray();
    }
}
