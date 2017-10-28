package com.androidplot.util;

import android.graphics.RectF;

public class DisplayDimensions {
    private static final RectF f576a = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
    public final RectF canvasRect;
    public final RectF marginatedRect;
    public final RectF paddedRect;

    public DisplayDimensions() {
        this(f576a, f576a, f576a);
    }

    public DisplayDimensions(RectF rectF, RectF rectF2, RectF rectF3) {
        this.canvasRect = rectF;
        this.marginatedRect = rectF2;
        this.paddedRect = rectF3;
    }
}
