package com.google.tagmanager;

import com.google.tagmanager.CacheFactory.CacheSizeManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class ef implements C0218k {
    private final Map f1144a = new HashMap();
    private final int f1145b;
    private final CacheSizeManager f1146c;
    private int f1147d;

    ef(int i, CacheSizeManager cacheSizeManager) {
        this.f1145b = i;
        this.f1146c = cacheSizeManager;
    }

    public synchronized Object mo627a(Object obj) {
        return this.f1144a.get(obj);
    }

    public synchronized void mo628a(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        this.f1147d += this.f1146c.sizeOf(obj, obj2);
        if (this.f1147d > this.f1145b) {
            Iterator it = this.f1144a.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.f1147d -= this.f1146c.sizeOf(entry.getKey(), entry.getValue());
                it.remove();
                if (this.f1147d <= this.f1145b) {
                    break;
                }
            }
        }
        this.f1144a.put(obj, obj2);
    }
}
