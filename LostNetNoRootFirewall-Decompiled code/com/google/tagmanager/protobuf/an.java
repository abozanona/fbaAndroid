package com.google.tagmanager.protobuf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class an extends AbstractSet {
    final /* synthetic */ ag f1232a;

    private an(ag agVar) {
        this.f1232a = agVar;
    }

    public boolean m1806a(Entry entry) {
        if (contains(entry)) {
            return false;
        }
        this.f1232a.m1792a((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public /* synthetic */ boolean add(Object obj) {
        return m1806a((Entry) obj);
    }

    public void clear() {
        this.f1232a.clear();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.f1232a.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public Iterator iterator() {
        return new am(this.f1232a, null);
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f1232a.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.f1232a.size();
    }
}
