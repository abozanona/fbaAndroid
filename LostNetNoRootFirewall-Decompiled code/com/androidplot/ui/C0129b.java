package com.androidplot.ui;

import com.androidplot.ui.TableModel.Axis;

final /* synthetic */ class C0129b {
    static final /* synthetic */ int[] f555a = new int[Axis.values().length];
    static final /* synthetic */ int[] f556b = new int[TableOrder.values().length];

    static {
        try {
            f556b[TableOrder.ROW_MAJOR.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f556b[TableOrder.COLUMN_MAJOR.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f555a[Axis.ROW.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f555a[Axis.COLUMN.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
    }
}
