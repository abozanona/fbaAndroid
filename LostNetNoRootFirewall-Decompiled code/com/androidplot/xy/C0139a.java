package com.androidplot.xy;

import com.androidplot.xy.BarRenderer.BarRenderStyle;
import com.androidplot.xy.BarRenderer.BarWidthStyle;

final /* synthetic */ class C0139a {
    static final /* synthetic */ int[] f759a = new int[BarWidthStyle.values().length];
    static final /* synthetic */ int[] f760b = new int[BarRenderStyle.values().length];

    static {
        try {
            f760b[BarRenderStyle.OVERLAID.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f760b[BarRenderStyle.SIDE_BY_SIDE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f760b[BarRenderStyle.STACKED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f759a[BarWidthStyle.FIXED_WIDTH.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f759a[BarWidthStyle.VARIABLE_WIDTH.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
    }
}
