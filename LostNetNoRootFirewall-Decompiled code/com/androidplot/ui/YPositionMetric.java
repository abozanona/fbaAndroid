package com.androidplot.ui;

import com.androidplot.ui.PositionMetric.LayoutMode;
import com.androidplot.ui.PositionMetric.Origin;

public class YPositionMetric extends PositionMetric {
    public YPositionMetric(float f, YLayoutStyle yLayoutStyle) {
        super(f, yLayoutStyle);
    }

    protected final /* synthetic */ void mo191a(float f, Enum enumR) {
        switch (C0135h.f567a[((YLayoutStyle) enumR).ordinal()]) {
            case 1:
            case 2:
            case 3:
                PositionMetric.m961a(f, LayoutMode.ABSOLUTE);
                return;
            case 4:
            case 5:
            case 6:
                PositionMetric.m961a(f, LayoutMode.RELATIVE);
                return;
            default:
                return;
        }
    }

    public float getPixelValue(float f) {
        switch (C0135h.f567a[((YLayoutStyle) getLayoutType()).ordinal()]) {
            case 1:
                return m962a(f, Origin.FROM_BEGINING);
            case 2:
                return m962a(f, Origin.FROM_END);
            case 3:
                return m962a(f, Origin.FROM_CENTER);
            case 4:
                return m963b(f, Origin.FROM_BEGINING);
            case 5:
                return m963b(f, Origin.FROM_END);
            case 6:
                return m963b(f, Origin.FROM_CENTER);
            default:
                throw new IllegalArgumentException("Unsupported LayoutType: " + getLayoutType());
        }
    }
}
