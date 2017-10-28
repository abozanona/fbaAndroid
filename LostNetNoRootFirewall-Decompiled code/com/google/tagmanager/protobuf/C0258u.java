package com.google.tagmanager.protobuf;

import java.util.Map.Entry;

class C0258u implements Entry {
    private Entry f1272a;

    private C0258u(Entry entry) {
        this.f1272a = entry;
    }

    public Object getKey() {
        return this.f1272a.getKey();
    }

    public Object getValue() {
        C0256s c0256s = (C0256s) this.f1272a.getValue();
        return c0256s == null ? null : c0256s.m1835a();
    }

    public Object setValue(Object obj) {
        if (obj instanceof MessageLite) {
            return ((C0256s) this.f1272a.getValue()).m1836a((MessageLite) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
