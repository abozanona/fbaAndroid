package com.androidplot.util;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PixelUtils {
    private static DisplayMetrics f578a;
    private static final Pattern f579b = Pattern.compile("^\\s*(\\d+(\\.\\d+)*)\\s*([a-zA-Z]+)\\s*$");
    public static final Map dimensionConstantLookup;

    static {
        Map hashMap = new HashMap();
        hashMap.put("px", Integer.valueOf(0));
        hashMap.put("dip", Integer.valueOf(1));
        hashMap.put("dp", Integer.valueOf(1));
        hashMap.put("sp", Integer.valueOf(2));
        hashMap.put("pt", Integer.valueOf(3));
        hashMap.put("in", Integer.valueOf(4));
        hashMap.put("mm", Integer.valueOf(5));
        dimensionConstantLookup = Collections.unmodifiableMap(hashMap);
    }

    public static PointF add(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float dpToPix(float f) {
        return TypedValue.applyDimension(1, f, f578a);
    }

    public static float fractionToPixH(float f) {
        return ((float) f578a.heightPixels) * f;
    }

    public static float fractionToPixW(float f) {
        return ((float) f578a.widthPixels) * f;
    }

    public static void init(Context context) {
        f578a = context.getResources().getDisplayMetrics();
    }

    public static RectF nearestPixRect(float f, float f2, float f3, float f4) {
        return new RectF((float) ((int) (f + 0.5f)), (float) ((int) (f2 + 0.5f)), (float) ((int) (f3 + 0.5f)), (float) ((int) (0.5f + f4)));
    }

    public static RectF sink(RectF rectF) {
        return nearestPixRect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public static float spToPix(float f) {
        return TypedValue.applyDimension(2, f, f578a);
    }

    public static float stringToDimension(String str) {
        Matcher matcher = f579b.matcher(str);
        if (matcher.matches()) {
            float floatValue = Float.valueOf(matcher.group(1)).floatValue();
            Integer num = (Integer) dimensionConstantLookup.get(matcher.group(3).toLowerCase());
            if (num == null) {
                throw new NumberFormatException();
            }
            C0138a c0138a = new C0138a(floatValue, num.intValue());
            return TypedValue.applyDimension(c0138a.f599b, c0138a.f598a, f578a);
        }
        throw new NumberFormatException();
    }

    public static PointF sub(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x - pointF2.x, pointF.y - pointF2.y);
    }
}
