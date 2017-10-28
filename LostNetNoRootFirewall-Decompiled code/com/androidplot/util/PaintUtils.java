package com.androidplot.util;

import android.graphics.Paint;

public class PaintUtils {
    public static void setFontSizeDp(Paint paint, float f) {
        paint.setTextSize(PixelUtils.dpToPix(f));
    }

    public static void setLineSizeDp(Paint paint, float f) {
        paint.setStrokeWidth(PixelUtils.dpToPix(f));
    }

    public static void setShadowDp(Paint paint, float f, float f2, float f3, int i) {
        paint.setShadowLayer(PixelUtils.dpToPix(f), PixelUtils.dpToPix(f2), PixelUtils.dpToPix(f3), i);
    }
}
