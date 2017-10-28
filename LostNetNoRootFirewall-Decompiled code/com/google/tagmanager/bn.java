package com.google.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;
import com.google.tagmanager.CacheFactory.CacheSizeManager;

@TargetApi(12)
class bn implements C0218k {
    private LruCache f1010a;

    bn(int i, CacheSizeManager cacheSizeManager) {
        this.f1010a = new bo(this, i, cacheSizeManager);
    }

    public Object mo627a(Object obj) {
        return this.f1010a.get(obj);
    }

    public void mo628a(Object obj, Object obj2) {
        this.f1010a.put(obj, obj2);
    }
}
