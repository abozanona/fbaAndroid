package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class cw extends eh {
    private static final String f1056a = FunctionType.REGEX.toString();
    private static final String f1057b = Key.IGNORE_CASE.toString();

    public cw() {
        super(f1056a);
    }

    protected boolean mo608a(String str, String str2, Map map) {
        try {
            return Pattern.compile(str2, es.m1682e((Value) map.get(f1057b)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
