package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class C0221d extends as {
    private static final String f1060a = FunctionType.ADWORDS_CLICK_REFERRER.toString();
    private static final String f1061b = Key.COMPONENT.toString();
    private static final String f1062c = Key.CONVERSION_ID.toString();
    private final Context f1063d;

    public C0221d(Context context) {
        super(f1060a, f1062c);
        this.f1063d = context;
    }

    public Value mo591a(Map map) {
        Value value = (Value) map.get(f1062c);
        if (value == null) {
            return es.m1686f();
        }
        String a = es.m1668a(value);
        value = (Value) map.get(f1061b);
        Object a2 = bi.m1414a(this.f1063d, a, value != null ? es.m1668a(value) : null);
        return a2 != null ? es.m1687f(a2) : es.m1686f();
    }

    public boolean mo592a() {
        return true;
    }
}
