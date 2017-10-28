package com.androidplot.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.androidplot.ui.widget.Widget;
import com.androidplot.util.DisplayDimensions;
import com.androidplot.util.ZLinkedList;

public class LayoutManager extends ZLinkedList implements OnTouchListener, Resizable {
    private boolean f512a = false;
    private Paint f513b = new Paint();
    private boolean f514c = false;
    private Paint f515d;
    private boolean f516e = false;
    private Paint f517f;
    private boolean f518g = false;
    private Paint f519h;
    private boolean f520i = false;
    private Paint f521j;
    private DisplayDimensions f522k = new DisplayDimensions();

    public LayoutManager() {
        this.f513b.setStyle(Style.FILL);
        this.f513b.setColor(-16711936);
        this.f515d = new Paint();
        this.f515d.setColor(-16711936);
        this.f515d.setStyle(Style.STROKE);
        this.f519h = new Paint();
        this.f519h.setColor(-256);
        this.f519h.setStyle(Style.FILL);
        this.f519h.setAlpha(200);
        this.f521j = new Paint();
        this.f521j.setColor(-16776961);
        this.f521j.setStyle(Style.FILL);
        this.f521j.setAlpha(200);
    }

    private static void m959a(Canvas canvas, RectF rectF, RectF rectF2, Paint paint) {
        try {
            canvas.save(31);
            canvas.clipRect(rectF2, Op.DIFFERENCE);
            canvas.drawRect(rectF, paint);
        } finally {
            canvas.restore();
        }
    }

    public void draw(Canvas canvas) {
        if (isDrawMarginsEnabled()) {
            m959a(canvas, this.f522k.canvasRect, this.f522k.marginatedRect, this.f519h);
        }
        if (isDrawPaddingEnabled()) {
            m959a(canvas, this.f522k.marginatedRect, this.f522k.paddedRect, this.f521j);
        }
        for (Widget widget : elements()) {
            try {
                canvas.save(31);
                PositionMetrics positionMetrics = widget.getPositionMetrics();
                float widthPix = widget.getWidthPix(this.f522k.paddedRect.width());
                float heightPix = widget.getHeightPix(this.f522k.paddedRect.height());
                PointF elementCoordinates = widget.getElementCoordinates(heightPix, widthPix, this.f522k.paddedRect, positionMetrics);
                DisplayDimensions widgetDimensions = widget.getWidgetDimensions();
                if (this.f516e) {
                    canvas.drawRect(widgetDimensions.canvasRect, this.f517f);
                }
                if (widget.isClippingEnabled()) {
                    canvas.clipRect(widgetDimensions.canvasRect, Op.INTERSECT);
                }
                widget.draw(canvas, widgetDimensions.canvasRect);
                if (this.f518g) {
                    m959a(canvas, widgetDimensions.canvasRect, widgetDimensions.marginatedRect, getMarginPaint());
                }
                if (this.f520i) {
                    m959a(canvas, widgetDimensions.marginatedRect, widgetDimensions.paddedRect, getPaddingPaint());
                }
                if (this.f512a) {
                    PointF anchorCoordinates = Widget.getAnchorCoordinates(elementCoordinates.x, elementCoordinates.y, widthPix, heightPix, positionMetrics.getAnchor());
                    canvas.drawRect(anchorCoordinates.x - 4.0f, anchorCoordinates.y - 4.0f, anchorCoordinates.x + 4.0f, 4.0f + anchorCoordinates.y, this.f513b);
                }
                if (this.f514c) {
                    this.f515d.setAntiAlias(true);
                    canvas.drawRect(widgetDimensions.canvasRect, this.f515d);
                }
                canvas.restore();
            } catch (Throwable th) {
                canvas.restore();
            }
        }
    }

    public Paint getMarginPaint() {
        return this.f519h;
    }

    public Paint getOutlinePaint() {
        return this.f515d;
    }

    public Paint getOutlineShadowPaint() {
        return this.f517f;
    }

    public Paint getPaddingPaint() {
        return this.f521j;
    }

    public boolean isDrawAnchorsEnabled() {
        return this.f512a;
    }

    public boolean isDrawMarginsEnabled() {
        return this.f518g;
    }

    public boolean isDrawOutlineShadowsEnabled() {
        return this.f516e;
    }

    public boolean isDrawOutlinesEnabled() {
        return this.f514c;
    }

    public boolean isDrawPaddingEnabled() {
        return this.f520i;
    }

    public void layout(DisplayDimensions displayDimensions) {
        this.f522k = displayDimensions;
        refreshLayout();
    }

    public synchronized void onPostInit() {
        for (Widget onPostInit : elements()) {
            onPostInit.onPostInit();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public void refreshLayout() {
        for (Widget layout : elements()) {
            layout.layout(this.f522k);
        }
    }

    public void setDrawAnchorsEnabled(boolean z) {
        this.f512a = z;
    }

    public void setDrawMarginsEnabled(boolean z) {
        this.f518g = z;
    }

    public void setDrawOutlineShadowsEnabled(boolean z) {
        this.f516e = z;
        if (z && this.f517f == null) {
            this.f517f = new Paint();
            this.f517f.setColor(-12303292);
            this.f517f.setStyle(Style.FILL);
            this.f517f.setShadowLayer(3.0f, 5.0f, 5.0f, -16777216);
        }
    }

    public void setDrawOutlinesEnabled(boolean z) {
        this.f514c = z;
    }

    public void setDrawPaddingEnabled(boolean z) {
        this.f520i = z;
    }

    public void setMarginPaint(Paint paint) {
        this.f519h = paint;
    }

    public void setMarkupEnabled(boolean z) {
        setDrawOutlinesEnabled(z);
        setDrawAnchorsEnabled(z);
        setDrawMarginsEnabled(z);
        setDrawPaddingEnabled(z);
        setDrawOutlineShadowsEnabled(z);
    }

    public void setOutlinePaint(Paint paint) {
        this.f515d = paint;
    }

    public void setOutlineShadowPaint(Paint paint) {
        this.f517f = paint;
    }

    public void setPaddingPaint(Paint paint) {
        this.f521j = paint;
    }
}
