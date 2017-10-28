package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Debug.EventInfo.EventType;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;

final class C0154e implements EnumLiteMap {
    C0154e() {
    }

    public EventType m1025a(int i) {
        return EventType.valueOf(i);
    }

    public /* synthetic */ EnumLite findValueByNumber(int i) {
        return m1025a(i);
    }
}
