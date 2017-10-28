package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.FieldSet.FieldDescriptorLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.MessageLite.Builder;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import com.google.tagmanager.protobuf.WireFormat.JavaType;

final class C0252o implements FieldDescriptorLite {
    final EnumLiteMap f1257a;
    final int f1258b;
    final FieldType f1259c;
    final boolean f1260d;
    final boolean f1261e;

    C0252o(EnumLiteMap enumLiteMap, int i, FieldType fieldType, boolean z, boolean z2) {
        this.f1257a = enumLiteMap;
        this.f1258b = i;
        this.f1259c = fieldType;
        this.f1260d = z;
        this.f1261e = z2;
    }

    public int m1833a(C0252o c0252o) {
        return this.f1258b - c0252o.f1258b;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m1833a((C0252o) obj);
    }

    public EnumLiteMap getEnumType() {
        return this.f1257a;
    }

    public JavaType getLiteJavaType() {
        return this.f1259c.getJavaType();
    }

    public FieldType getLiteType() {
        return this.f1259c;
    }

    public int getNumber() {
        return this.f1258b;
    }

    public Builder internalMergeFrom(Builder builder, MessageLite messageLite) {
        return ((GeneratedMessageLite.Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
    }

    public MutableMessageLite internalMergeFrom(MutableMessageLite mutableMessageLite, MutableMessageLite mutableMessageLite2) {
        return ((GeneratedMutableMessageLite) mutableMessageLite).mergeFrom((GeneratedMutableMessageLite) mutableMessageLite2);
    }

    public boolean isPacked() {
        return this.f1261e;
    }

    public boolean isRepeated() {
        return this.f1260d;
    }
}
