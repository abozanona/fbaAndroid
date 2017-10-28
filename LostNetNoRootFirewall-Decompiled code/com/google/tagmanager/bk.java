package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;

/* synthetic */ class bk {
    static final /* synthetic */ int[] f1004a = new int[Type.values().length];
    static final /* synthetic */ int[] f1005b = new int[bl.values().length];

    static {
        try {
            f1005b[bl.URL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1005b[bl.BACKSLASH.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1005b[bl.NONE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1004a[Type.LIST.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f1004a[Type.MAP.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
    }
}
