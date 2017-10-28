package com.google.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class cx extends as {
    private static final String f1058a = FunctionType.RESOLUTION.toString();
    private final Context f1059b;

    public cx(Context context) {
        super(f1058a, new String[0]);
        this.f1059b = context;
    }

    public Value mo591a(Map map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f1059b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return es.m1687f(i + "x" + displayMetrics.heightPixels);
    }

    public boolean mo592a() {
        return true;
    }
}
