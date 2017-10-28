package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.WireFormat.FieldType;
import com.google.tagmanager.protobuf.WireFormat.JavaType;

enum at extends FieldType {
    at(String str, int i, JavaType javaType, int i2) {
        super(str, i, javaType, i2);
    }

    public boolean isPackable() {
        return false;
    }
}
