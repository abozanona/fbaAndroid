package com.google.tagmanager;

import android.util.LruCache;
import com.google.tagmanager.CacheFactory.CacheSizeManager;

class bo extends LruCache {
    final /* synthetic */ CacheSizeManager f1011a;
    final /* synthetic */ bn f1012b;

    bo(bn bnVar, int i, CacheSizeManager cacheSizeManager) {
        this.f1012b = bnVar;
        this.f1011a = cacheSizeManager;
        super(i);
    }

    protected int sizeOf(Object obj, Object obj2) {
        return this.f1011a.sizeOf(obj, obj2);
    }
}
