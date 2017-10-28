package com.androidplot.util;

import android.graphics.PointF;
import android.graphics.RectF;

public class ValPixConverter {
    public static double pixToVal(float f, double d, double d2, float f2, boolean z) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("pixel values cannot be negative.");
        } else if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Length in pixels must be greater than 0.");
        } else {
            if (z) {
                f = f2 - f;
            }
            return ((range(d, d2) / ((double) f2)) * ((double) f)) + d;
        }
    }

    public static double range(double d, double d2) {
        return d2 - d;
    }

    public static double valPerPix(double d, double d2, float f) {
        return range(d, d2) / ((double) f);
    }

    public static float valToPix(double d, double d2, double d3, float f, boolean z) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Length in pixels must be greater than 0.");
        }
        float range = (float) ((((double) f) / range(d2, d3)) * (d - d2));
        return z ? f - range : range;
    }

    public static PointF valToPix(Number number, Number number2, RectF rectF, Number number3, Number number4, Number number5, Number number6) {
        return new PointF(valToPix(number.doubleValue(), number3.doubleValue(), number4.doubleValue(), rectF.width(), false) + rectF.left, valToPix(number2.doubleValue(), number5.doubleValue(), number6.doubleValue(), rectF.height(), true) + rectF.top);
    }
}
