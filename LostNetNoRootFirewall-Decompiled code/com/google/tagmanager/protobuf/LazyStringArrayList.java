package com.google.tagmanager.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends AbstractList implements LazyStringList, RandomAccess {
    public static final LazyStringList EMPTY = new UnmodifiableLazyStringList(new LazyStringArrayList());
    private final List list;

    public LazyStringArrayList() {
        this.list = new ArrayList();
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.list = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    public LazyStringArrayList(List list) {
        this.list = new ArrayList(list);
    }

    private static byte[] asByteArray(Object obj) {
        return obj instanceof byte[] ? (byte[]) obj : obj instanceof String ? Internal.toByteArray((String) obj) : ((ByteString) obj).toByteArray();
    }

    private static ByteString asByteString(Object obj) {
        return obj instanceof ByteString ? (ByteString) obj : obj instanceof String ? ByteString.copyFromUtf8((String) obj) : ByteString.copyFrom((byte[]) obj);
    }

    private static String asString(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof ByteString ? ((ByteString) obj).toStringUtf8() : Internal.toStringUtf8((byte[]) obj);
    }

    public void add(int i, String str) {
        this.list.add(i, str);
        this.modCount++;
    }

    public void add(ByteString byteString) {
        this.list.add(byteString);
        this.modCount++;
    }

    public void add(byte[] bArr) {
        this.list.add(bArr);
        this.modCount++;
    }

    public boolean addAll(int i, Collection collection) {
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean addAll = this.list.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    public boolean addAllByteArray(Collection collection) {
        boolean addAll = this.list.addAll(collection);
        this.modCount++;
        return addAll;
    }

    public boolean addAllByteString(Collection collection) {
        boolean addAll = this.list.addAll(collection);
        this.modCount++;
        return addAll;
    }

    public List asByteArrayList() {
        return new C0260w(this.list);
    }

    public void clear() {
        this.list.clear();
        this.modCount++;
    }

    public String get(int i) {
        Object obj = this.list.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        String toStringUtf8;
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.list.set(i, toStringUtf8);
            }
            return toStringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        toStringUtf8 = Internal.toStringUtf8(bArr);
        if (Internal.isValidUtf8(bArr)) {
            this.list.set(i, toStringUtf8);
        }
        return toStringUtf8;
    }

    public byte[] getByteArray(int i) {
        Object obj = this.list.get(i);
        Object asByteArray = asByteArray(obj);
        if (asByteArray != obj) {
            this.list.set(i, asByteArray);
        }
        return asByteArray;
    }

    public ByteString getByteString(int i) {
        ByteString byteString = this.list.get(i);
        ByteString asByteString = asByteString(byteString);
        if (asByteString != byteString) {
            this.list.set(i, asByteString);
        }
        return asByteString;
    }

    public List getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    public void mergeFrom(LazyStringList lazyStringList) {
        for (Object next : lazyStringList.getUnderlyingElements()) {
            if (next instanceof byte[]) {
                byte[] bArr = (byte[]) next;
                this.list.add(Arrays.copyOf(bArr, bArr.length));
            } else {
                this.list.add(next);
            }
        }
    }

    public String remove(int i) {
        Object remove = this.list.remove(i);
        this.modCount++;
        return asString(remove);
    }

    public String set(int i, String str) {
        return asString(this.list.set(i, str));
    }

    public void set(int i, ByteString byteString) {
        this.list.set(i, byteString);
    }

    public void set(int i, byte[] bArr) {
        this.list.set(i, bArr);
    }

    public int size() {
        return this.list.size();
    }
}
