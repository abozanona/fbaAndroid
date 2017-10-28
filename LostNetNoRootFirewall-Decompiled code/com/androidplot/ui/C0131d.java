package com.androidplot.ui;

final /* synthetic */ class C0131d {
    static final /* synthetic */ int[] f562a = new int[TableOrder.values().length];

    static {
        try {
            f562a[TableOrder.ROW_MAJOR.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f562a[TableOrder.COLUMN_MAJOR.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
