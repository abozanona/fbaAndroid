package com.google.tagmanager.protobuf;

import java.io.IOException;

class C0256s {
    private final MessageLite f1267a;
    private final ExtensionRegistryLite f1268b;
    private ByteString f1269c;
    private volatile MessageLite f1270d;
    private volatile boolean f1271e;

    private void m1834c() {
        if (this.f1270d == null) {
            synchronized (this) {
                if (this.f1270d != null) {
                    return;
                }
                try {
                    if (this.f1269c != null) {
                        this.f1270d = (MessageLite) this.f1267a.getParserForType().parseFrom(this.f1269c, this.f1268b);
                    }
                } catch (IOException e) {
                }
            }
        }
    }

    public MessageLite m1835a() {
        m1834c();
        return this.f1270d;
    }

    public MessageLite m1836a(MessageLite messageLite) {
        MessageLite messageLite2 = this.f1270d;
        this.f1270d = messageLite;
        this.f1269c = null;
        this.f1271e = true;
        return messageLite2;
    }

    public int m1837b() {
        return this.f1271e ? this.f1270d.getSerializedSize() : this.f1269c.size();
    }

    public boolean equals(Object obj) {
        m1834c();
        return this.f1270d.equals(obj);
    }

    public int hashCode() {
        m1834c();
        return this.f1270d.hashCode();
    }

    public String toString() {
        m1834c();
        return this.f1270d.toString();
    }
}
