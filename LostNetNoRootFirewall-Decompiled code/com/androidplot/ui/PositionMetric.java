package com.androidplot.ui;

public abstract class PositionMetric extends C0127i {

    public enum LayoutMode {
        ABSOLUTE,
        RELATIVE
    }

    public enum Origin {
        FROM_BEGINING,
        FROM_CENTER,
        FROM_END
    }

    public PositionMetric(float f, Enum enumR) {
        super(f, enumR);
    }

    protected static void m961a(float f, LayoutMode layoutMode) {
        switch (C0132e.f563a[layoutMode.ordinal()]) {
            case 1:
                return;
            case 2:
                if (f < -1.0f || f > 1.0f) {
                    throw new IllegalArgumentException("Relative layout values must be within the range of -1 to 1.");
                }
                return;
            default:
                throw new IllegalArgumentException("Unknown LayoutMode: " + layoutMode);
        }
    }

    protected final float m962a(float f, Origin origin) {
        switch (C0132e.f564b[origin.ordinal()]) {
            case 1:
                return getValue();
            case 2:
                return (f / 2.0f) + getValue();
            case 3:
                return f - getValue();
            default:
                throw new IllegalArgumentException("Unsupported Origin: " + origin);
        }
    }

    protected final float m963b(float f, Origin origin) {
        switch (C0132e.f564b[origin.ordinal()]) {
            case 1:
                return getValue() * f;
            case 2:
                return (f / 2.0f) + ((f / 2.0f) * getValue());
            case 3:
                return (getValue() * f) + f;
            default:
                throw new IllegalArgumentException("Unsupported Origin: " + origin);
        }
    }

    public /* bridge */ /* synthetic */ Enum getLayoutType() {
        return super.getLayoutType();
    }

    public /* bridge */ /* synthetic */ float getValue() {
        return super.getValue();
    }

    public /* bridge */ /* synthetic */ void set(float f, Enum enumR) {
        super.set(f, enumR);
    }

    public /* bridge */ /* synthetic */ void setLayoutType(Enum enumR) {
        super.setLayoutType(enumR);
    }

    public /* bridge */ /* synthetic */ void setValue(float f) {
        super.setValue(f);
    }
}
