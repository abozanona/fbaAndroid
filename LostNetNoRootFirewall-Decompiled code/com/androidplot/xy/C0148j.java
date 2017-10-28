package com.androidplot.xy;

import java.util.Comparator;
import java.util.Map.Entry;

final class C0148j implements Comparator {
    /* synthetic */ C0148j() {
        this((byte) 0);
    }

    private C0148j(byte b) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((String) ((Entry) obj).getValue()).compareTo((String) ((Entry) obj2).getValue());
    }
}
