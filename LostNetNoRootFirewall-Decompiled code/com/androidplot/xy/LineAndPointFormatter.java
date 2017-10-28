package com.androidplot.xy;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import com.androidplot.ui.SeriesRenderer;
import com.androidplot.util.PixelUtils;

public class LineAndPointFormatter extends XYSeriesFormatter {
    private PointLabeler f602a;
    private FillDirection f603b;
    private Paint f604c;
    private Paint f605d;
    private Paint f606e;
    private PointLabelFormatter f607f;

    public LineAndPointFormatter() {
        this(Integer.valueOf(-65536), Integer.valueOf(-16711936), Integer.valueOf(-16776961), null);
    }

    public LineAndPointFormatter(Integer num, Integer num2, Integer num3, PointLabelFormatter pointLabelFormatter) {
        this(num, num2, num3, pointLabelFormatter, FillDirection.BOTTOM);
    }

    public LineAndPointFormatter(Integer num, Integer num2, Integer num3, PointLabelFormatter pointLabelFormatter, FillDirection fillDirection) {
        this.f602a = new C0149k(this);
        this.f603b = FillDirection.BOTTOM;
        m981a(Integer.valueOf(-16777216));
        m981a(num);
        if (num2 == null) {
            this.f605d = null;
        } else {
            this.f605d = new Paint();
            this.f605d.setAntiAlias(true);
            this.f605d.setStrokeWidth(PixelUtils.dpToPix(4.5f));
            this.f605d.setColor(num2.intValue());
            this.f605d.setStrokeCap(Cap.ROUND);
        }
        m982b(num3);
        setFillDirection(fillDirection);
        setPointLabelFormatter(pointLabelFormatter);
    }

    protected final void m981a(Integer num) {
        if (num == null) {
            this.f604c = null;
            return;
        }
        this.f604c = new Paint();
        this.f604c.setAntiAlias(true);
        this.f604c.setStrokeWidth(PixelUtils.dpToPix(1.5f));
        this.f604c.setColor(num.intValue());
        this.f604c.setStyle(Style.STROKE);
    }

    protected final void m982b(Integer num) {
        if (num == null) {
            this.f606e = null;
            return;
        }
        this.f606e = new Paint();
        this.f606e.setAntiAlias(true);
        this.f606e.setColor(num.intValue());
    }

    public void disableShadows() {
        this.f604c.setShadowLayer(0.0f, 0.0f, 0.0f, -16777216);
        this.f605d.setShadowLayer(0.0f, 0.0f, 0.0f, -16777216);
    }

    public void enableShadows() {
        this.f604c.setShadowLayer(1.0f, 3.0f, 3.0f, -16777216);
        this.f605d.setShadowLayer(1.0f, 3.0f, 3.0f, -16777216);
    }

    public FillDirection getFillDirection() {
        return this.f603b;
    }

    public Paint getFillPaint() {
        return this.f606e;
    }

    public Paint getLinePaint() {
        return this.f604c;
    }

    public PointLabelFormatter getPointLabelFormatter() {
        return this.f607f;
    }

    public PointLabeler getPointLabeler() {
        return this.f602a;
    }

    public Class getRendererClass() {
        return LineAndPointRenderer.class;
    }

    public SeriesRenderer getRendererInstance(XYPlot xYPlot) {
        return new LineAndPointRenderer(xYPlot);
    }

    public Paint getVertexPaint() {
        return this.f605d;
    }

    public void setFillDirection(FillDirection fillDirection) {
        this.f603b = fillDirection;
    }

    public void setFillPaint(Paint paint) {
        this.f606e = paint;
    }

    public void setLinePaint(Paint paint) {
        this.f604c = paint;
    }

    public void setPointLabelFormatter(PointLabelFormatter pointLabelFormatter) {
        this.f607f = pointLabelFormatter;
    }

    public void setPointLabeler(PointLabeler pointLabeler) {
        this.f602a = pointLabeler;
    }

    public void setVertexPaint(Paint paint) {
        this.f605d = paint;
    }
}
