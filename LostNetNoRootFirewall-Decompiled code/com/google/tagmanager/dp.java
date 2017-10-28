package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.tagmanager.CacheFactory.CacheSizeManager;

class dp implements CacheSizeManager {
    final /* synthetic */ dn f1103a;

    dp(dn dnVar) {
        this.f1103a = dnVar;
    }

    public int m1602a(String str, ci ciVar) {
        return ((Value) ciVar.m1496a()).toByteArray().length + str.length();
    }

    public /* synthetic */ int sizeOf(Object obj, Object obj2) {
        return m1602a((String) obj, (ci) obj2);
    }
}
