package com.androidplot.xy;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.androidplot.ui.SeriesRenderer;

public class BarFormatter extends LineAndPointFormatter {
    private Paint f608a = new Paint();
    private Paint f609b;

    public BarFormatter() {
        this.f608a.setStyle(Style.FILL);
        this.f608a.setAlpha(100);
        this.f609b = new Paint();
        this.f609b.setStyle(Style.STROKE);
        this.f609b.setAlpha(100);
    }

    public BarFormatter(int i, int i2) {
        this.f608a.setStyle(Style.FILL);
        this.f608a.setAlpha(100);
        this.f609b = new Paint();
        this.f609b.setStyle(Style.STROKE);
        this.f609b.setAlpha(100);
        this.f608a.setColor(i);
        this.f609b.setColor(i2);
    }

    public Paint getBorderPaint() {
        return this.f609b;
    }

    public Paint getFillPaint() {
        return this.f608a;
    }

    public Class getRendererClass() {
        return BarRenderer.class;
    }

    public SeriesRenderer getRendererInstance(XYPlot xYPlot) {
        return new BarRenderer(xYPlot);
    }

    public void setBorderPaint(Paint paint) {
        this.f609b = paint;
    }

    public void setFillPaint(Paint paint) {
        this.f608a = paint;
    }
}
