package com.google.tagmanager.protobuf;

import java.util.Collection;
import java.util.List;

public interface LazyStringList extends List {
    void add(ByteString byteString);

    void add(byte[] bArr);

    boolean addAllByteArray(Collection collection);

    boolean addAllByteString(Collection collection);

    List asByteArrayList();

    byte[] getByteArray(int i);

    ByteString getByteString(int i);

    List getUnderlyingElements();

    void mergeFrom(LazyStringList lazyStringList);

    void set(int i, ByteString byteString);

    void set(int i, byte[] bArr);
}
