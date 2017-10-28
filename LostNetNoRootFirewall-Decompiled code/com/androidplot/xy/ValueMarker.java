package com.androidplot.xy;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.androidplot.ui.PositionMetric;

public abstract class ValueMarker {
    private Number f629a;
    private Paint f630b;
    private Paint f631c;
    private TextOrientation f632d;
    private int f633e;
    private PositionMetric f634f;
    private String f635g;

    public enum TextOrientation {
        HORIZONTAL,
        VERTICAL
    }

    public ValueMarker(Number number, String str, PositionMetric positionMetric) {
        this.f633e = 2;
        this.f630b = new Paint();
        this.f630b.setColor(-65536);
        this.f630b.setAntiAlias(true);
        this.f630b.setStyle(Style.STROKE);
        this.f631c = new Paint();
        this.f631c.setAntiAlias(true);
        this.f631c.setColor(-65536);
        this.f629a = number;
        this.f634f = positionMetric;
        this.f635g = str;
    }

    public ValueMarker(Number number, String str, PositionMetric positionMetric, int i, int i2) {
        this(number, str, positionMetric);
        this.f630b.setColor(i);
        this.f631c.setColor(i2);
    }

    public ValueMarker(Number number, String str, PositionMetric positionMetric, Paint paint, Paint paint2) {
        this(number, str, positionMetric);
        this.f630b = paint;
        this.f631c = paint2;
    }

    public Paint getLinePaint() {
        return this.f630b;
    }

    public String getText() {
        return this.f635g;
    }

    public int getTextMargin() {
        return this.f633e;
    }

    public TextOrientation getTextOrientation() {
        return this.f632d;
    }

    public Paint getTextPaint() {
        return this.f631c;
    }

    public PositionMetric getTextPosition() {
        return this.f634f;
    }

    public Number getValue() {
        return this.f629a;
    }

    public void setLinePaint(Paint paint) {
        this.f630b = paint;
    }

    public void setText(String str) {
        this.f635g = str;
    }

    public void setTextMargin(int i) {
        this.f633e = i;
    }

    public void setTextOrientation(TextOrientation textOrientation) {
        this.f632d = textOrientation;
    }

    public void setTextPaint(Paint paint) {
        this.f631c = paint;
    }

    public void setTextPosition(PositionMetric positionMetric) {
        this.f634f = positionMetric;
    }

    public void setValue(Number number) {
        this.f629a = number;
    }
}
