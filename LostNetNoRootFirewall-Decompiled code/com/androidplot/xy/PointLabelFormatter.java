package com.androidplot.xy;

import android.graphics.Paint;
import android.graphics.Paint.Align;
import com.androidplot.util.PixelUtils;

public class PointLabelFormatter {
    private Paint f619a;
    public float hOffset;
    public float vOffset;

    public PointLabelFormatter() {
        this(-1);
    }

    public PointLabelFormatter(int i) {
        this(i, PixelUtils.dpToPix(0.0f), PixelUtils.dpToPix(-4.0f));
    }

    public PointLabelFormatter(int i, float f, float f2) {
        Integer valueOf = Integer.valueOf(i);
        if (valueOf == null) {
            setTextPaint(null);
        } else {
            setTextPaint(new Paint());
            getTextPaint().setAntiAlias(true);
            getTextPaint().setColor(valueOf.intValue());
            getTextPaint().setTextAlign(Align.CENTER);
            getTextPaint().setTextSize(PixelUtils.spToPix(12.0f));
        }
        this.hOffset = f;
        this.vOffset = f2;
    }

    public Paint getTextPaint() {
        return this.f619a;
    }

    public void setTextPaint(Paint paint) {
        this.f619a = paint;
    }
}
