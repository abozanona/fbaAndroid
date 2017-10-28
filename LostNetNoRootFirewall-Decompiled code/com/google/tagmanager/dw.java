package com.google.tagmanager;

import android.os.Build.VERSION;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class dw extends as {
    private static final String f1118a = FunctionType.SDK_VERSION.toString();

    public dw() {
        super(f1118a, new String[0]);
    }

    public Value mo591a(Map map) {
        return es.m1687f(Integer.valueOf(VERSION.SDK_INT));
    }

    public boolean mo592a() {
        return true;
    }
}
