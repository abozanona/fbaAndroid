package com.google.tagmanager;

import com.google.tagmanager.CustomFunctionCall.CustomEvaluator;
import java.util.Map;

class C0266t implements CustomEvaluator {
    final /* synthetic */ Container f1282a;

    private C0266t(Container container) {
        this.f1282a = container;
    }

    public Object evaluate(String str, Map map) {
        this.f1282a.getFunctionCallTagHandler(str).execute(str, map);
        return es.m1685e();
    }
}
