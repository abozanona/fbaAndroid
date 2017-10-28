package com.androidplot.xy;

final /* synthetic */ class C0145g {
    static final /* synthetic */ int[] f781a = new int[XYFramingModel.values().length];
    static final /* synthetic */ int[] f782b = new int[BoundaryMode.values().length];

    static {
        try {
            f782b[BoundaryMode.FIXED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f782b[BoundaryMode.AUTO.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f782b[BoundaryMode.GROW.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f782b[BoundaryMode.SHRINNK.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f781a[XYFramingModel.ORIGIN.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f781a[XYFramingModel.EDGE.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
    }
}
