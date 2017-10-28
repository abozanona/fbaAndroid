package com.google.tagmanager.protobuf;

import java.util.Map.Entry;

class al implements Comparable, Entry {
    final /* synthetic */ ag f1225a;
    private final Comparable f1226b;
    private Object f1227c;

    al(ag agVar, Comparable comparable, Object obj) {
        this.f1225a = agVar;
        this.f1226b = comparable;
        this.f1227c = obj;
    }

    al(ag agVar, Entry entry) {
        this(agVar, (Comparable) entry.getKey(), entry.getValue());
    }

    private boolean m1801a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public int m1802a(al alVar) {
        return m1803a().compareTo(alVar.m1803a());
    }

    public Comparable m1803a() {
        return this.f1226b;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m1802a((al) obj);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return m1801a(this.f1226b, entry.getKey()) && m1801a(this.f1227c, entry.getValue());
    }

    public /* synthetic */ Object getKey() {
        return m1803a();
    }

    public Object getValue() {
        return this.f1227c;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f1226b == null ? 0 : this.f1226b.hashCode();
        if (this.f1227c != null) {
            i = this.f1227c.hashCode();
        }
        return hashCode ^ i;
    }

    public Object setValue(Object obj) {
        this.f1225a.m1789e();
        Object obj2 = this.f1227c;
        this.f1227c = obj;
        return obj2;
    }

    public String toString() {
        return this.f1226b + "=" + this.f1227c;
    }
}
