package com.google.tagmanager;

import android.os.Build;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class ak extends as {
    private static final String f960a = FunctionType.DEVICE_NAME.toString();

    public ak() {
        super(f960a, new String[0]);
    }

    public Value mo591a(Map map) {
        String str = Build.MANUFACTURER;
        Object obj = Build.MODEL;
        if (!(obj.startsWith(str) || str.equals("unknown"))) {
            obj = str + " " + obj;
        }
        return es.m1687f(obj);
    }

    public boolean mo592a() {
        return true;
    }
}
