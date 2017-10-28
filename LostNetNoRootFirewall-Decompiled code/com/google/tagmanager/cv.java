package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class cv extends as {
    private static final String f1051a = FunctionType.REGEX_GROUP.toString();
    private static final String f1052b = Key.ARG0.toString();
    private static final String f1053c = Key.ARG1.toString();
    private static final String f1054d = Key.IGNORE_CASE.toString();
    private static final String f1055e = Key.GROUP.toString();

    public cv() {
        super(f1051a, f1052b, f1053c);
    }

    public Value mo591a(Map map) {
        Value value = (Value) map.get(f1052b);
        Value value2 = (Value) map.get(f1053c);
        if (value == null || value == es.m1686f() || value2 == null || value2 == es.m1686f()) {
            return es.m1686f();
        }
        int i = 64;
        if (es.m1682e((Value) map.get(f1054d)).booleanValue()) {
            i = 66;
        }
        Value value3 = (Value) map.get(f1055e);
        int intValue;
        if (value3 != null) {
            Long c = es.m1675c(value3);
            if (c == es.m1667a()) {
                return es.m1686f();
            }
            intValue = c.intValue();
            if (intValue < 0) {
                return es.m1686f();
            }
        }
        intValue = 1;
        try {
            CharSequence a = es.m1668a(value);
            Object obj = null;
            Matcher matcher = Pattern.compile(es.m1668a(value2), i).matcher(a);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? es.m1686f() : es.m1687f(obj);
        } catch (PatternSyntaxException e) {
            return es.m1686f();
        }
    }

    public boolean mo592a() {
        return true;
    }
}
