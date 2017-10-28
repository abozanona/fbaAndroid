package com.google.tagmanager.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList implements LazyStringList, RandomAccess {
    private final LazyStringList list;

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.list = lazyStringList;
    }

    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public void add(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public boolean addAllByteArray(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAllByteString(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public List asByteArrayList() {
        return Collections.unmodifiableList(this.list.asByteArrayList());
    }

    public String get(int i) {
        return (String) this.list.get(i);
    }

    public byte[] getByteArray(int i) {
        return this.list.getByteArray(i);
    }

    public ByteString getByteString(int i) {
        return this.list.getByteString(i);
    }

    public List getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    public Iterator iterator() {
        return new ap(this);
    }

    public ListIterator listIterator(int i) {
        return new ao(this, i);
    }

    public void mergeFrom(LazyStringList lazyStringList) {
        throw new UnsupportedOperationException();
    }

    public void set(int i, ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public void set(int i, byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.list.size();
    }
}
