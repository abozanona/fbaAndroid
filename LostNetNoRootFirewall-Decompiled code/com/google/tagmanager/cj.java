package com.google.tagmanager;

import android.os.Build.VERSION;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class cj extends as {
    private static final String f1024a = FunctionType.OS_VERSION.toString();

    public cj() {
        super(f1024a, new String[0]);
    }

    public Value mo591a(Map map) {
        return es.m1687f(VERSION.RELEASE);
    }

    public boolean mo592a() {
        return true;
    }
}
