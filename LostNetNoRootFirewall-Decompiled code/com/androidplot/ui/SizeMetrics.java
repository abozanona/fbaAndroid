package com.androidplot.ui;

import android.graphics.RectF;
import com.androidplot.util.PixelUtils;

public class SizeMetrics {
    private SizeMetric f535a;
    private SizeMetric f536b;

    public SizeMetrics(float f, SizeLayoutType sizeLayoutType, float f2, SizeLayoutType sizeLayoutType2) {
        this.f535a = new SizeMetric(f, sizeLayoutType);
        this.f536b = new SizeMetric(f2, sizeLayoutType2);
    }

    public SizeMetrics(SizeMetric sizeMetric, SizeMetric sizeMetric2) {
        this.f535a = sizeMetric;
        this.f536b = sizeMetric2;
    }

    public SizeMetric getHeightMetric() {
        return this.f535a;
    }

    public RectF getRectF(RectF rectF) {
        return new RectF(0.0f, 0.0f, this.f536b.getPixelValue(rectF.width()), this.f535a.getPixelValue(rectF.height()));
    }

    public RectF getRoundedRect(RectF rectF) {
        return PixelUtils.nearestPixRect(0.0f, 0.0f, this.f536b.getPixelValue(rectF.width()), this.f535a.getPixelValue(rectF.height()));
    }

    public SizeMetric getWidthMetric() {
        return this.f536b;
    }

    public void setHeightMetric(SizeMetric sizeMetric) {
        this.f535a = sizeMetric;
    }

    public void setWidthMetric(SizeMetric sizeMetric) {
        this.f536b = sizeMetric;
    }
}
