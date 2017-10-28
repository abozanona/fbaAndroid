package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;

/* synthetic */ class ds {
    static final /* synthetic */ int[] f1110a = new int[Type.values().length];

    static {
        try {
            f1110a[Type.LIST.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1110a[Type.MAP.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1110a[Type.MACRO_REFERENCE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1110a[Type.TEMPLATE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
