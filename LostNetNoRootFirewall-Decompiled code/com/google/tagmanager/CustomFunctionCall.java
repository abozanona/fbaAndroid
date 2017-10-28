package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class CustomFunctionCall extends as {
    private static final String f930a = FunctionType.FUNCTION_CALL.toString();
    private static final String f931b = Key.FUNCTION_CALL_NAME.toString();
    private static final String f932c = Key.ADDITIONAL_PARAMS.toString();
    private final CustomEvaluator f933d;

    public interface CustomEvaluator {
        Object evaluate(String str, Map map);
    }

    public CustomFunctionCall(CustomEvaluator customEvaluator) {
        super(f930a, f931b);
        this.f933d = customEvaluator;
    }

    public Value mo591a(Map map) {
        String a = es.m1668a((Value) map.get(f931b));
        Map hashMap = new HashMap();
        Value value = (Value) map.get(f932c);
        if (value != null) {
            Object f = es.m1688f(value);
            if (f instanceof Map) {
                for (Entry entry : ((Map) f).entrySet()) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                bs.m1441b("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return es.m1686f();
            }
        }
        try {
            return es.m1687f(this.f933d.evaluate(a, hashMap));
        } catch (Exception e) {
            bs.m1441b("Custom macro/tag " + a + " threw exception " + e.getMessage());
            return es.m1686f();
        }
    }

    public boolean mo592a() {
        return false;
    }
}
