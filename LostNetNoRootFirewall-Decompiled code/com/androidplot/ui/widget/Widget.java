package com.androidplot.ui.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import com.androidplot.ui.AnchorPosition;
import com.androidplot.ui.BoxModel;
import com.androidplot.ui.BoxModelable;
import com.androidplot.ui.LayoutManager;
import com.androidplot.ui.PositionMetrics;
import com.androidplot.ui.Resizable;
import com.androidplot.ui.SizeLayoutType;
import com.androidplot.ui.SizeMetric;
import com.androidplot.ui.SizeMetrics;
import com.androidplot.ui.XLayoutStyle;
import com.androidplot.ui.YLayoutStyle;
import com.androidplot.util.DisplayDimensions;
import com.androidplot.util.PixelUtils;

public abstract class Widget implements BoxModelable, Resizable {
    private Paint f477a;
    private Paint f478b;
    private boolean f479c;
    private BoxModel f480d;
    private SizeMetrics f481e;
    private DisplayDimensions f482f;
    private DisplayDimensions f483g;
    private boolean f484h;
    private PositionMetrics f485i;
    private LayoutManager f486j;

    public Widget(LayoutManager layoutManager, SizeMetric sizeMetric, SizeMetric sizeMetric2) {
        this(layoutManager, new SizeMetrics(sizeMetric, sizeMetric2));
    }

    public Widget(LayoutManager layoutManager, SizeMetrics sizeMetrics) {
        this.f479c = true;
        this.f480d = new BoxModel();
        this.f482f = new DisplayDimensions();
        this.f483g = new DisplayDimensions();
        this.f484h = true;
        this.f486j = layoutManager;
        setSize(sizeMetrics);
        mo193a();
    }

    public static PointF getAnchorCoordinates(float f, float f2, float f3, float f4, AnchorPosition anchorPosition) {
        return getAnchorCoordinates(new RectF(f, f2, f + f3, f2 + f4), anchorPosition);
    }

    public static PointF getAnchorCoordinates(RectF rectF, AnchorPosition anchorPosition) {
        return PixelUtils.add(new PointF(rectF.left, rectF.top), getAnchorOffset(rectF.width(), rectF.height(), anchorPosition));
    }

    public static PointF getAnchorOffset(float f, float f2, AnchorPosition anchorPosition) {
        PointF pointF = new PointF();
        switch (C0137b.f574a[anchorPosition.ordinal()]) {
            case 1:
                break;
            case 2:
                pointF.set(0.0f, f2 / 2.0f);
                break;
            case 3:
                pointF.set(0.0f, f2);
                break;
            case 4:
                pointF.set(f, 0.0f);
                break;
            case 5:
                pointF.set(f, f2);
                break;
            case 6:
                pointF.set(f, f2 / 2.0f);
                break;
            case 7:
                pointF.set(f / 2.0f, 0.0f);
                break;
            case 8:
                pointF.set(f / 2.0f, f2);
                break;
            case 9:
                pointF.set(f / 2.0f, f2 / 2.0f);
                break;
            default:
                throw new IllegalArgumentException("Unsupported anchor location: " + anchorPosition);
        }
        return pointF;
    }

    protected void mo193a() {
    }

    public boolean containsPoint(PointF pointF) {
        return this.f483g.canvasRect.contains(pointF.x, pointF.y);
    }

    protected abstract void doOnDraw(Canvas canvas, RectF rectF);

    public void draw(Canvas canvas, RectF rectF) {
        if (isVisible()) {
            if (this.f478b != null) {
                canvas.drawRect(this.f483g.canvasRect, this.f478b);
            }
            doOnDraw(canvas, this.f483g.paddedRect);
            if (this.f477a != null) {
                canvas.drawRect(this.f483g.paddedRect, this.f477a);
            }
        }
    }

    public AnchorPosition getAnchor() {
        return getPositionMetrics().getAnchor();
    }

    public Paint getBackgroundPaint() {
        return this.f478b;
    }

    public Paint getBorderPaint() {
        return this.f477a;
    }

    public PointF getElementCoordinates(float f, float f2, RectF rectF, PositionMetrics positionMetrics) {
        return PixelUtils.sub(new PointF(positionMetrics.getXPositionMetric().getPixelValue(rectF.width()) + rectF.left, positionMetrics.getYPositionMetric().getPixelValue(rectF.height()) + rectF.top), getAnchorOffset(f2, f, positionMetrics.getAnchor()));
    }

    public SizeMetric getHeightMetric() {
        return this.f481e.getHeightMetric();
    }

    public float getHeightPix(float f) {
        return this.f481e.getHeightMetric().getPixelValue(f);
    }

    public float getMarginBottom() {
        return this.f480d.getMarginBottom();
    }

    public float getMarginLeft() {
        return this.f480d.getMarginLeft();
    }

    public float getMarginRight() {
        return this.f480d.getMarginRight();
    }

    public float getMarginTop() {
        return this.f480d.getMarginTop();
    }

    public RectF getMarginatedRect(RectF rectF) {
        return this.f480d.getMarginatedRect(rectF);
    }

    public RectF getPaddedRect(RectF rectF) {
        return this.f480d.getPaddedRect(rectF);
    }

    public float getPaddingBottom() {
        return this.f480d.getPaddingBottom();
    }

    public float getPaddingLeft() {
        return this.f480d.getPaddingLeft();
    }

    public float getPaddingRight() {
        return this.f480d.getPaddingRight();
    }

    public float getPaddingTop() {
        return this.f480d.getPaddingTop();
    }

    public PositionMetrics getPositionMetrics() {
        return this.f485i;
    }

    public DisplayDimensions getWidgetDimensions() {
        return this.f483g;
    }

    public SizeMetric getWidthMetric() {
        return this.f481e.getWidthMetric();
    }

    public float getWidthPix(float f) {
        return this.f481e.getWidthMetric().getPixelValue(f);
    }

    public boolean isClippingEnabled() {
        return this.f479c;
    }

    public boolean isVisible() {
        return this.f484h;
    }

    public synchronized void layout(DisplayDimensions displayDimensions) {
        this.f482f = displayDimensions;
        refreshLayout();
    }

    public void onPostInit() {
    }

    public void position(float f, XLayoutStyle xLayoutStyle, float f2, YLayoutStyle yLayoutStyle) {
        position(f, xLayoutStyle, f2, yLayoutStyle, AnchorPosition.LEFT_TOP);
    }

    public void position(float f, XLayoutStyle xLayoutStyle, float f2, YLayoutStyle yLayoutStyle, AnchorPosition anchorPosition) {
        setPositionMetrics(new PositionMetrics(f, xLayoutStyle, f2, yLayoutStyle, anchorPosition));
        this.f486j.addToTop(this);
    }

    public synchronized void refreshLayout() {
        if (this.f485i != null) {
            float widthPix = getWidthPix(this.f482f.paddedRect.width());
            float heightPix = getHeightPix(this.f482f.paddedRect.height());
            PointF elementCoordinates = getElementCoordinates(heightPix, widthPix, this.f482f.paddedRect, this.f485i);
            RectF rectF = new RectF(elementCoordinates.x, elementCoordinates.y, widthPix + elementCoordinates.x, heightPix + elementCoordinates.y);
            RectF marginatedRect = getMarginatedRect(rectF);
            this.f483g = new DisplayDimensions(rectF, marginatedRect, getPaddedRect(marginatedRect));
        }
    }

    public void setAnchor(AnchorPosition anchorPosition) {
        getPositionMetrics().setAnchor(anchorPosition);
    }

    public void setBackgroundPaint(Paint paint) {
        this.f478b = paint;
    }

    public void setBorderPaint(Paint paint) {
        this.f477a = paint;
    }

    public void setClippingEnabled(boolean z) {
        this.f479c = z;
    }

    public void setHeight(float f) {
        this.f481e.getHeightMetric().setValue(f);
    }

    public void setHeight(float f, SizeLayoutType sizeLayoutType) {
        this.f481e.getHeightMetric().set(f, sizeLayoutType);
    }

    public void setMarginBottom(float f) {
        this.f480d.setMarginBottom(f);
    }

    public void setMarginLeft(float f) {
        this.f480d.setMarginLeft(f);
    }

    public void setMarginRight(float f) {
        this.f480d.setMarginRight(f);
    }

    public void setMarginTop(float f) {
        this.f480d.setMarginTop(f);
    }

    public void setMargins(float f, float f2, float f3, float f4) {
        this.f480d.setMargins(f, f2, f3, f4);
    }

    public void setPadding(float f, float f2, float f3, float f4) {
        this.f480d.setPadding(f, f2, f3, f4);
    }

    public void setPaddingBottom(float f) {
        this.f480d.setPaddingBottom(f);
    }

    public void setPaddingLeft(float f) {
        this.f480d.setPaddingLeft(f);
    }

    public void setPaddingRight(float f) {
        this.f480d.setPaddingRight(f);
    }

    public void setPaddingTop(float f) {
        this.f480d.setPaddingTop(f);
    }

    public void setPositionMetrics(PositionMetrics positionMetrics) {
        this.f485i = positionMetrics;
    }

    public void setSize(SizeMetrics sizeMetrics) {
        this.f481e = sizeMetrics;
    }

    public void setVisible(boolean z) {
        this.f484h = z;
    }

    public void setWidth(float f) {
        this.f481e.getWidthMetric().setValue(f);
    }

    public void setWidth(float f, SizeLayoutType sizeLayoutType) {
        this.f481e.getWidthMetric().set(f, sizeLayoutType);
    }
}
