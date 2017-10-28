package com.androidplot.ui;

import com.androidplot.ui.PositionMetric.LayoutMode;
import com.androidplot.ui.PositionMetric.Origin;

public class XPositionMetric extends PositionMetric {
    public XPositionMetric(float f, XLayoutStyle xLayoutStyle) {
        super(f, xLayoutStyle);
        m965a(f, xLayoutStyle);
    }

    private static void m965a(float f, XLayoutStyle xLayoutStyle) {
        switch (C0134g.f566a[xLayoutStyle.ordinal()]) {
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
        switch (C0134g.f566a[((XLayoutStyle) getLayoutType()).ordinal()]) {
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
