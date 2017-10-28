package com.androidplot.pie;

import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import com.androidplot.ui.Formatter;
import com.androidplot.ui.SeriesRenderer;

public class SegmentFormatter extends Formatter {
    private Paint f490a;
    private Paint f491b;
    private Paint f492c;
    private Paint f493d;
    private Paint f494e;
    private Paint f495f;

    public SegmentFormatter() {
        setFillPaint(new Paint());
        setOuterEdgePaint(new Paint());
        getOuterEdgePaint().setStyle(Style.STROKE);
        getOuterEdgePaint().setStrokeWidth(3.0f);
        getOuterEdgePaint().setAntiAlias(true);
        setInnerEdgePaint(new Paint());
        getInnerEdgePaint().setStyle(Style.STROKE);
        getInnerEdgePaint().setStrokeWidth(3.0f);
        getInnerEdgePaint().setAntiAlias(true);
        setRadialEdgePaint(new Paint());
        getRadialEdgePaint().setStyle(Style.STROKE);
        getRadialEdgePaint().setStrokeWidth(3.0f);
        getRadialEdgePaint().setAntiAlias(true);
        setLabelPaint(new Paint());
        getLabelPaint().setColor(-1);
        getLabelPaint().setTextSize(18.0f);
        getLabelPaint().setAntiAlias(true);
        getLabelPaint().setTextAlign(Align.CENTER);
        setLabelMarkerPaint(new Paint());
        getLabelMarkerPaint().setColor(-1);
        getLabelMarkerPaint().setStrokeWidth(3.0f);
    }

    public SegmentFormatter(Integer num) {
        setFillPaint(new Paint());
        setOuterEdgePaint(new Paint());
        getOuterEdgePaint().setStyle(Style.STROKE);
        getOuterEdgePaint().setStrokeWidth(3.0f);
        getOuterEdgePaint().setAntiAlias(true);
        setInnerEdgePaint(new Paint());
        getInnerEdgePaint().setStyle(Style.STROKE);
        getInnerEdgePaint().setStrokeWidth(3.0f);
        getInnerEdgePaint().setAntiAlias(true);
        setRadialEdgePaint(new Paint());
        getRadialEdgePaint().setStyle(Style.STROKE);
        getRadialEdgePaint().setStrokeWidth(3.0f);
        getRadialEdgePaint().setAntiAlias(true);
        setLabelPaint(new Paint());
        getLabelPaint().setColor(-1);
        getLabelPaint().setTextSize(18.0f);
        getLabelPaint().setAntiAlias(true);
        getLabelPaint().setTextAlign(Align.CENTER);
        setLabelMarkerPaint(new Paint());
        getLabelMarkerPaint().setColor(-1);
        getLabelMarkerPaint().setStrokeWidth(3.0f);
        if (num != null) {
            getFillPaint().setColor(num.intValue());
        } else {
            getFillPaint().setColor(0);
        }
    }

    public SegmentFormatter(Integer num, Integer num2) {
        this(num);
        getInnerEdgePaint().setColor(num2.intValue());
        getOuterEdgePaint().setColor(num2.intValue());
        getRadialEdgePaint().setColor(num2.intValue());
    }

    public SegmentFormatter(Integer num, Integer num2, Integer num3, Integer num4) {
        this(num);
        if (getOuterEdgePaint() != null) {
            getOuterEdgePaint().setColor(num2.intValue());
        } else {
            this.f491b = new Paint();
            getOuterEdgePaint().setColor(-16777216);
        }
        if (getInnerEdgePaint() != null) {
            getInnerEdgePaint().setColor(num3.intValue());
        } else {
            this.f491b = new Paint();
            getInnerEdgePaint().setColor(-16777216);
        }
        if (getRadialEdgePaint() != null) {
            getRadialEdgePaint().setColor(num4.intValue());
            return;
        }
        this.f492c = new Paint();
        getRadialEdgePaint().setColor(-16777216);
    }

    public Paint getFillPaint() {
        return this.f493d;
    }

    public Paint getInnerEdgePaint() {
        return this.f490a;
    }

    public Paint getLabelMarkerPaint() {
        return this.f495f;
    }

    public Paint getLabelPaint() {
        return this.f494e;
    }

    public Paint getOuterEdgePaint() {
        return this.f491b;
    }

    public Paint getRadialEdgePaint() {
        return this.f492c;
    }

    public Class getRendererClass() {
        return PieRenderer.class;
    }

    public SeriesRenderer getRendererInstance(PieChart pieChart) {
        return new PieRenderer(pieChart);
    }

    public void setFillPaint(Paint paint) {
        this.f493d = paint;
    }

    public void setInnerEdgePaint(Paint paint) {
        this.f490a = paint;
    }

    public void setLabelMarkerPaint(Paint paint) {
        this.f495f = paint;
    }

    public void setLabelPaint(Paint paint) {
        this.f494e = paint;
    }

    public void setOuterEdgePaint(Paint paint) {
        this.f491b = paint;
    }

    public void setRadialEdgePaint(Paint paint) {
        this.f492c = paint;
    }
}
