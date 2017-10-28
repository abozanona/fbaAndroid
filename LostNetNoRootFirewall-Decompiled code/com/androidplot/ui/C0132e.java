package com.androidplot.ui;

import com.androidplot.ui.PositionMetric.LayoutMode;
import com.androidplot.ui.PositionMetric.Origin;

final /* synthetic */ class C0132e {
    static final /* synthetic */ int[] f563a = new int[LayoutMode.values().length];
    static final /* synthetic */ int[] f564b = new int[Origin.values().length];

    static {
        try {
            f564b[Origin.FROM_BEGINING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f564b[Origin.FROM_CENTER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f564b[Origin.FROM_END.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f563a[LayoutMode.ABSOLUTE.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f563a[LayoutMode.RELATIVE.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
    }
}
