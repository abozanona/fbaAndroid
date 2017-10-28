package com.google.tagmanager;

import com.google.tagmanager.Container.FunctionCallMacroHandler;
import com.google.tagmanager.CustomFunctionCall.CustomEvaluator;
import java.util.Map;

class C0265s implements CustomEvaluator {
    final /* synthetic */ Container f1281a;

    private C0265s(Container container) {
        this.f1281a = container;
    }

    public Object evaluate(String str, Map map) {
        FunctionCallMacroHandler functionCallMacroHandler = this.f1281a.getFunctionCallMacroHandler(str);
        return functionCallMacroHandler == null ? null : functionCallMacroHandler.getValue(str, map);
    }
}
