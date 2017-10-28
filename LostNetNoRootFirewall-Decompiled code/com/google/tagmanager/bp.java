package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Locale;
import java.util.Map;

class bp extends as {
    private static final String f1013a = FunctionType.LANGUAGE.toString();

    public bp() {
        super(f1013a, new String[0]);
    }

    public Value mo591a(Map map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return es.m1686f();
        }
        String language = locale.getLanguage();
        return language == null ? es.m1686f() : es.m1687f(language.toLowerCase());
    }

    public boolean mo592a() {
        return false;
    }
}
