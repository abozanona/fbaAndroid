package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.tagmanager.CacheFactory.CacheSizeManager;
import com.google.tagmanager.ResourceUtil.ExpandedFunctionCall;

class C0224do implements CacheSizeManager {
    final /* synthetic */ dn f1102a;

    C0224do(dn dnVar) {
        this.f1102a = dnVar;
    }

    public int m1601a(ExpandedFunctionCall expandedFunctionCall, ci ciVar) {
        return ((Value) ciVar.m1496a()).toByteArray().length;
    }

    public /* synthetic */ int sizeOf(Object obj, Object obj2) {
        return m1601a((ExpandedFunctionCall) obj, (ci) obj2);
    }
}
