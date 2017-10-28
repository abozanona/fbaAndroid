package com.androidplot.xy;

final /* synthetic */ class C0147i {
    static final /* synthetic */ int[] f787a = new int[XYAxisType.values().length];
    static final /* synthetic */ int[] f788b = new int[XYStepMode.values().length];

    static {
        try {
            f788b[XYStepMode.INCREMENT_BY_VAL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f788b[XYStepMode.INCREMENT_BY_PIXELS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f788b[XYStepMode.SUBDIVIDE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f787a[XYAxisType.DOMAIN.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f787a[XYAxisType.RANGE.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
    }
}
