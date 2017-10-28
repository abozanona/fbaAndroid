package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class bh extends as {
    private static final String f994a = FunctionType.INSTALL_REFERRER.toString();
    private static final String f995b = Key.COMPONENT.toString();
    private final Context f996c;

    public bh(Context context) {
        super(f994a, new String[0]);
        this.f996c = context;
    }

    public Value mo591a(Map map) {
        Object b = bi.m1418b(this.f996c, ((Value) map.get(f995b)) != null ? es.m1668a((Value) map.get(f995b)) : null);
        return b != null ? es.m1687f(b) : es.m1686f();
    }

    public boolean mo592a() {
        return true;
    }
}
