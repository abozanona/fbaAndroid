package com.google.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

class aj extends as {
    private static final String f958a = FunctionType.DEVICE_ID.toString();
    private final Context f959b;

    public aj(Context context) {
        super(f958a, new String[0]);
        this.f959b = context;
    }

    public Value mo591a(Map map) {
        Object a = m1354a(this.f959b);
        return a == null ? es.m1686f() : es.m1687f(a);
    }

    @VisibleForTesting
    protected String m1354a(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean mo592a() {
        return true;
    }
}
