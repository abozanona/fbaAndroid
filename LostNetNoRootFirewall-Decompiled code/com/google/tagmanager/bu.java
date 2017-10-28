package com.google.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

class bu extends as {
    private static final String f1017a = FunctionType.MOBILE_ADWORDS_UNIQUE_ID.toString();
    private final Context f1018b;

    public bu(Context context) {
        super(f1017a, new String[0]);
        this.f1018b = context;
    }

    public Value mo591a(Map map) {
        Object a = m1449a(this.f1018b);
        return a == null ? es.m1686f() : es.m1687f(a);
    }

    @VisibleForTesting
    protected String m1449a(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean mo592a() {
        return true;
    }
}
