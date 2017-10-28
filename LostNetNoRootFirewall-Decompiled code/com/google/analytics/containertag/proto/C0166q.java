package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Serving.CacheOption.CacheLevel;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;

final class C0166q implements EnumLiteMap {
    C0166q() {
    }

    public CacheLevel m1036a(int i) {
        return CacheLevel.valueOf(i);
    }

    public /* synthetic */ EnumLite findValueByNumber(int i) {
        return m1036a(i);
    }
}
