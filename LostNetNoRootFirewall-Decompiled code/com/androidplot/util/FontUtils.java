package com.androidplot.util;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;

public class FontUtils {
    public static float getFontHeight(Paint paint) {
        FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent + (-fontMetrics.ascent);
    }

    public static Rect getPackedStringDimensions(String str, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }

    public static Rect getStringDimensions(String str, Paint paint) {
        Rect rect = new Rect();
        if (str == null || str.length() == 0) {
            return null;
        }
        paint.getTextBounds(str, 0, str.length(), rect);
        rect.bottom = rect.top + ((int) getFontHeight(paint));
        return rect;
    }
}
