package com.google.tagmanager;

import com.google.tagmanager.LoadCallback.Failure;

/* synthetic */ class C0264r {
    static final /* synthetic */ int[] f1280a = new int[Failure.values().length];

    static {
        try {
            f1280a[Failure.NOT_AVAILABLE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1280a[Failure.IO_ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1280a[Failure.SERVER_ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
