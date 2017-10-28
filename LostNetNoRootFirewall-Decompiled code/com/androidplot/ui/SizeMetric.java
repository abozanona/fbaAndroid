package com.androidplot.ui;

public class SizeMetric extends C0127i {
    public SizeMetric(float f, SizeLayoutType sizeLayoutType) {
        super(f, sizeLayoutType);
    }

    protected final /* synthetic */ void mo191a(float f, Enum enumR) {
        switch (C0133f.f565a[((SizeLayoutType) enumR).ordinal()]) {
            case 1:
                if (f < 0.0f || f > 1.0f) {
                    throw new IllegalArgumentException("SizeMetric Relative and Hybrid layout values must be within the range of 0 to 1.");
                }
                return;
            default:
                return;
        }
    }

    public float getPixelValue(float f) {
        switch (C0133f.f565a[((SizeLayoutType) getLayoutType()).ordinal()]) {
            case 1:
                return getValue() * f;
            case 2:
                return getValue();
            case 3:
                return f - getValue();
            default:
                throw new IllegalArgumentException("Unsupported LayoutType: " + getLayoutType());
        }
    }

    public /* bridge */ /* synthetic */ float getValue() {
        return super.getValue();
    }

    public /* bridge */ /* synthetic */ void setValue(float f) {
        super.setValue(f);
    }
}
