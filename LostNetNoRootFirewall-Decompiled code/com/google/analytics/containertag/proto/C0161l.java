package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.MutableServing.CacheOption.CacheLevel;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;

final class C0161l implements EnumLiteMap {
    C0161l() {
    }

    public CacheLevel m1032a(int i) {
        return CacheLevel.valueOf(i);
    }

    public /* synthetic */ EnumLite findValueByNumber(int i) {
        return m1032a(i);
    }
}
