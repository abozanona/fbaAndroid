package com.androidplot.xy;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import com.androidplot.ui.LayoutManager;
import com.androidplot.ui.SizeMetrics;
import com.androidplot.ui.XPositionMetric;
import com.androidplot.ui.YPositionMetric;
import com.androidplot.ui.widget.Widget;
import com.androidplot.util.FontUtils;
import com.androidplot.util.ValPixConverter;
import com.androidplot.util.ZHash;
import com.androidplot.util.ZIndexable;
import java.text.DecimalFormat;
import java.text.Format;

public class XYGraphWidget extends Widget {
    private Format f639A;
    private Format f640B;
    private Paint f641C;
    private Paint f642D;
    private Paint f643E;
    private Paint f644F;
    private RectF f645G;
    private RectF f646H;
    private float f647I;
    private float f648J;
    private boolean f649K = true;
    private boolean f650L = true;
    private boolean f651M = true;
    private boolean f652N = true;
    private float f653O;
    private float f654P;
    private ZHash f655Q;
    private float f656a = 15.0f;
    private float f657b = 41.0f;
    private float f658c = -5.0f;
    private float f659d = 0.0f;
    private float f660e = 1.0f;
    private float f661f = 0.0f;
    private int f662g = 1;
    private int f663h = 1;
    private float f664i = 0.0f;
    private float f665j = 0.0f;
    private float f666k = 0.0f;
    private float f667l = 0.0f;
    private int f668m = 5;
    private int f669n = 5;
    private Paint f670o = new Paint();
    private Paint f671p;
    private Paint f672q;
    private Paint f673r;
    private Paint f674s;
    private Paint f675t;
    private Paint f676u;
    private Paint f677v;
    private Paint f678w;
    private Paint f679x;
    private Paint f680y;
    private XYPlot f681z;

    public enum XYPlotOrientation {
        HORIZONTAL,
        VERTICAL
    }

    public XYGraphWidget(LayoutManager layoutManager, XYPlot xYPlot, SizeMetrics sizeMetrics) {
        super(layoutManager, sizeMetrics);
        this.f670o.setColor(Color.rgb(140, 140, 140));
        this.f670o.setStyle(Style.FILL);
        this.f671p = new Paint();
        this.f671p.setColor(Color.rgb(180, 180, 180));
        this.f671p.setAntiAlias(true);
        this.f671p.setStyle(Style.STROKE);
        this.f673r = new Paint(this.f671p);
        this.f674s = new Paint(this.f673r);
        this.f672q = new Paint(this.f671p);
        this.f641C = new Paint();
        this.f641C.setColor(-1);
        this.f641C.setAntiAlias(true);
        this.f642D = new Paint();
        this.f642D.setColor(-1);
        this.f642D.setAntiAlias(true);
        this.f643E = new Paint();
        this.f643E.setColor(-1);
        this.f643E.setAntiAlias(true);
        this.f643E.setTextAlign(Align.CENTER);
        this.f644F = new Paint();
        this.f644F.setColor(-1);
        this.f644F.setAntiAlias(true);
        this.f644F.setTextAlign(Align.RIGHT);
        this.f675t = new Paint();
        this.f675t.setColor(-3355444);
        this.f675t.setAntiAlias(true);
        this.f675t.setTextAlign(Align.CENTER);
        this.f676u = new Paint();
        this.f676u.setColor(-3355444);
        this.f676u.setAntiAlias(true);
        this.f676u.setTextAlign(Align.RIGHT);
        this.f677v = new Paint();
        this.f677v.setColor(-256);
        this.f678w = new Paint();
        this.f678w.setColor(-256);
        this.f679x = new Paint();
        this.f679x.setColor(-256);
        this.f680y = new Paint();
        this.f680y.setColor(Color.argb(100, 50, 50, 50));
        setMarginTop(7.0f);
        setMarginRight(4.0f);
        setMarginBottom(4.0f);
        this.f639A = new DecimalFormat("0.0");
        this.f640B = new DecimalFormat("0.0");
        this.f655Q = new ZHash();
        this.f681z = xYPlot;
    }

    private String m987a(Number number) {
        return this.f639A.format(number);
    }

    private void m988a(Canvas canvas) {
        if (this.f670o != null) {
            canvas.drawRect(this.f645G, this.f670o);
        }
        float valToPix = this.f681z.getDomainOrigin() != null ? ValPixConverter.valToPix(this.f681z.getDomainOrigin().doubleValue(), this.f681z.getCalculatedMinX().doubleValue(), this.f681z.getCalculatedMaxX().doubleValue(), this.f646H.width(), false) + this.f646H.left : this.f646H.left;
        XYStep step = XYStepCalculator.getStep(this.f681z, XYAxisType.DOMAIN, this.f646H, Double.valueOf(this.f681z.getCalculatedMinX().doubleValue()), Double.valueOf(this.f681z.getCalculatedMaxX().doubleValue()));
        if (valToPix >= this.f646H.left && valToPix <= this.f646H.right) {
            if (this.f641C != null) {
                this.f641C.setTextAlign(Align.CENTER);
            }
            m989a(canvas, valToPix, Double.valueOf(this.f681z.getDomainOrigin().doubleValue()), this.f643E, this.f641C, false);
        }
        int i = 1;
        float stepPix = valToPix - step.getStepPix();
        while (stepPix >= this.f646H.left) {
            double doubleValue = this.f681z.getDomainOrigin().doubleValue() - (((double) i) * step.getStepVal());
            if (stepPix >= this.f646H.left && stepPix <= this.f646H.right) {
                if (i % getTicksPerDomainLabel() == 0) {
                    m989a(canvas, stepPix, Double.valueOf(doubleValue), this.f675t, this.f673r, false);
                } else {
                    m989a(canvas, stepPix, Double.valueOf(doubleValue), this.f675t, this.f674s, true);
                }
            }
            i++;
            stepPix = valToPix - (((float) i) * step.getStepPix());
        }
        i = 1;
        stepPix = valToPix + step.getStepPix();
        while (stepPix <= this.f646H.right) {
            doubleValue = this.f681z.getDomainOrigin().doubleValue() + (((double) i) * step.getStepVal());
            if (stepPix >= this.f646H.left && stepPix <= this.f646H.right) {
                if (i % getTicksPerDomainLabel() == 0) {
                    m989a(canvas, stepPix, Double.valueOf(doubleValue), this.f675t, this.f673r, false);
                } else {
                    m989a(canvas, stepPix, Double.valueOf(doubleValue), this.f675t, this.f674s, true);
                }
            }
            i++;
            stepPix = valToPix + (((float) i) * step.getStepPix());
        }
        valToPix = this.f681z.getRangeOrigin() != null ? ValPixConverter.valToPix(this.f681z.getRangeOrigin().doubleValue(), this.f681z.getCalculatedMinY().doubleValue(), this.f681z.getCalculatedMaxY().doubleValue(), this.f646H.height(), true) + this.f646H.top : this.f646H.bottom;
        step = XYStepCalculator.getStep(this.f681z, XYAxisType.RANGE, this.f646H, Double.valueOf(this.f681z.getCalculatedMinY().doubleValue()), Double.valueOf(this.f681z.getCalculatedMaxY().doubleValue()));
        if (valToPix >= this.f646H.top && valToPix <= this.f646H.bottom) {
            if (this.f642D != null) {
                this.f642D.setTextAlign(Align.RIGHT);
            }
            drawRangeTick(canvas, valToPix, Double.valueOf(this.f681z.getRangeOrigin().doubleValue()), this.f644F, this.f642D, false);
        }
        i = 1;
        stepPix = valToPix - step.getStepPix();
        while (stepPix >= this.f646H.top) {
            doubleValue = this.f681z.getRangeOrigin().doubleValue() + (((double) i) * step.getStepVal());
            if (stepPix >= this.f646H.top && stepPix <= this.f646H.bottom) {
                if (i % getTicksPerRangeLabel() == 0) {
                    drawRangeTick(canvas, stepPix, Double.valueOf(doubleValue), this.f676u, this.f671p, false);
                } else {
                    drawRangeTick(canvas, stepPix, Double.valueOf(doubleValue), this.f676u, this.f672q, true);
                }
            }
            i++;
            stepPix = valToPix - (((float) i) * step.getStepPix());
        }
        i = 1;
        stepPix = valToPix + step.getStepPix();
        while (stepPix <= this.f646H.bottom) {
            doubleValue = this.f681z.getRangeOrigin().doubleValue() - (((double) i) * step.getStepVal());
            if (stepPix >= this.f646H.top && stepPix <= this.f646H.bottom) {
                if (i % getTicksPerRangeLabel() == 0) {
                    drawRangeTick(canvas, stepPix, Double.valueOf(doubleValue), this.f676u, this.f671p, false);
                } else {
                    drawRangeTick(canvas, stepPix, Double.valueOf(doubleValue), this.f676u, this.f672q, true);
                }
            }
            i++;
            stepPix = valToPix + (((float) i) * step.getStepPix());
        }
    }

    private void m989a(Canvas canvas, float f, Number number, Paint paint, Paint paint2, boolean z) {
        if (!z) {
            if (paint2 != null) {
                if (this.f652N) {
                    canvas.drawLine(f, this.f645G.top, f, this.f645G.bottom + ((float) this.f668m), paint2);
                } else {
                    canvas.drawLine(f, this.f645G.top - ((float) this.f668m), f, this.f645G.bottom, paint2);
                }
            }
            if (paint != null) {
                m990a(canvas, XYAxisType.DOMAIN, number, f + this.f659d, this.f652N ? ((this.f645G.bottom + ((float) this.f668m)) + this.f658c) + FontUtils.getFontHeight(paint) : (this.f645G.top - ((float) this.f668m)) - this.f658c, paint);
            }
        } else if (paint2 != null) {
            canvas.drawLine(f, this.f645G.top, f, this.f645G.bottom, paint2);
        }
    }

    private void m990a(Canvas canvas, XYAxisType xYAxisType, Number number, float f, float f2, Paint paint) {
        double doubleValue = number.doubleValue();
        int save = canvas.save();
        try {
            AxisValueLabelFormatter axisValueLabelFormatter;
            String str;
            AxisValueLabelFormatter axisValueLabelFormatterForDomainVal;
            String b;
            switch (C0144f.f780a[xYAxisType.ordinal()]) {
                case 1:
                    axisValueLabelFormatterForDomainVal = getAxisValueLabelFormatterForDomainVal(doubleValue);
                    b = m992b(number);
                    canvas.rotate(getDomainLabelOrientation(), f, f2);
                    axisValueLabelFormatter = axisValueLabelFormatterForDomainVal;
                    str = b;
                    break;
                case 2:
                    axisValueLabelFormatterForDomainVal = getAxisValueLabelFormatterForRangeVal(doubleValue);
                    b = m987a(number);
                    canvas.rotate(getRangeLabelOrientation(), f, f2);
                    axisValueLabelFormatter = axisValueLabelFormatterForDomainVal;
                    str = b;
                    break;
                default:
                    str = null;
                    axisValueLabelFormatter = null;
                    break;
            }
            if (axisValueLabelFormatter != null) {
                Paint paint2 = new Paint(paint);
                paint2.setColor(axisValueLabelFormatter.getColor());
                paint = paint2;
            }
            canvas.drawText(str, f, f2, paint);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    private void m991a(Canvas canvas, String str, ValueMarker valueMarker, float f, float f2) {
        float f3 = f + 2.0f;
        float f4 = f2 - 2.0f;
        RectF rectF = new RectF(FontUtils.getStringDimensions(str, valueMarker.getTextPaint()));
        rectF.offsetTo(f3, f4 - rectF.height());
        if (rectF.right > this.f646H.right) {
            rectF.offset(-(rectF.right - this.f646H.right), 0.0f);
        }
        if (rectF.top < this.f646H.top) {
            rectF.offset(0.0f, this.f646H.top - rectF.top);
        }
        canvas.drawText(str, rectF.left, rectF.bottom, valueMarker.getTextPaint());
    }

    private String m992b(Number number) {
        return this.f640B.format(number);
    }

    private void m993b(Canvas canvas) {
        for (ValueMarker valueMarker : this.f681z.f710a) {
            float pixelValue;
            if (valueMarker.getValue() != null) {
                float valToPix = ValPixConverter.valToPix(valueMarker.getValue().doubleValue(), this.f681z.getCalculatedMinY().doubleValue(), this.f681z.getCalculatedMaxY().doubleValue(), this.f646H.height(), true) + this.f646H.top;
                canvas.drawLine(this.f646H.left, valToPix, this.f646H.right, valToPix, valueMarker.getLinePaint());
                pixelValue = ((XPositionMetric) valueMarker.getTextPosition()).getPixelValue(this.f646H.width()) + this.f646H.left;
                if (valueMarker.getText() != null) {
                    m991a(canvas, valueMarker.getText(), valueMarker, pixelValue, valToPix);
                } else {
                    m991a(canvas, m987a(valueMarker.getValue()), valueMarker, pixelValue, valToPix);
                }
            }
        }
        for (ValueMarker valueMarker2 : this.f681z.f711b) {
            if (valueMarker2.getValue() != null) {
                float valToPix2 = this.f646H.left + ValPixConverter.valToPix(valueMarker2.getValue().doubleValue(), this.f681z.getCalculatedMinX().doubleValue(), this.f681z.getCalculatedMaxX().doubleValue(), this.f646H.width(), false);
                canvas.drawLine(valToPix2, this.f646H.top, valToPix2, this.f646H.bottom, valueMarker2.getLinePaint());
                pixelValue = ((YPositionMetric) valueMarker2.getTextPosition()).getPixelValue(this.f646H.height()) + this.f646H.top;
                if (valueMarker2.getText() != null) {
                    m991a(canvas, valueMarker2.getText(), valueMarker2, valToPix2, pixelValue);
                } else {
                    m991a(canvas, m992b(valueMarker2.getValue()), valueMarker2, valToPix2, pixelValue);
                }
            }
        }
    }

    private void m994c(Canvas canvas) {
        try {
            canvas.save(31);
            canvas.clipRect(this.f645G, Op.INTERSECT);
            for (XYSeriesRenderer render : this.f681z.getRendererList()) {
                render.render(canvas, this.f646H);
            }
        } finally {
            canvas.restore();
        }
    }

    public void addAxisValueLabelRegion(RectRegion rectRegion, AxisValueLabelFormatter axisValueLabelFormatter) {
        this.f655Q.addToTop(rectRegion, axisValueLabelFormatter);
    }

    public void addDomainAxisValueLabelRegion(double d, double d2, AxisValueLabelFormatter axisValueLabelFormatter) {
        addAxisValueLabelRegion(new RectRegion(Double.valueOf(d), Double.valueOf(d2), Double.valueOf(Double.POSITIVE_INFINITY), Double.valueOf(Double.NEGATIVE_INFINITY), null), axisValueLabelFormatter);
    }

    public void addRangeAxisValueLabelRegion(double d, double d2, AxisValueLabelFormatter axisValueLabelFormatter) {
        addAxisValueLabelRegion(new RectRegion(Double.valueOf(Double.POSITIVE_INFINITY), Double.valueOf(Double.NEGATIVE_INFINITY), Double.valueOf(d), Double.valueOf(d2), null), axisValueLabelFormatter);
    }

    protected void doOnDraw(Canvas canvas, RectF rectF) {
        Object obj = null;
        float f = 1.0f;
        float f2 = rectF.left + (this.f651M ? this.f657b : 1.0f);
        float f3 = rectF.top + (this.f652N ? 1.0f : this.f656a);
        float f4 = rectF.right - (this.f651M ? 1.0f : this.f657b);
        float f5 = rectF.bottom;
        if (this.f652N) {
            f = this.f656a;
        }
        this.f645G = new RectF(f2, f3, f4, f5 - f);
        RectF rectF2 = this.f645G;
        this.f646H = new RectF(rectF2.left + this.f666k, rectF2.top + this.f664i, rectF2.right - this.f667l, rectF2.bottom - this.f665j);
        if (this.f646H.height() > 0.0f && this.f646H.width() > 0.0f && this.f681z.getCalculatedMinX() != null && this.f681z.getCalculatedMaxX() != null && this.f681z.getCalculatedMinY() != null && this.f681z.getCalculatedMaxY() != null) {
            m988a(canvas);
            m994c(canvas);
            Object obj2;
            if (this.f677v == null || this.f647I > this.f646H.right || this.f647I < this.f646H.left) {
                obj2 = null;
            } else {
                canvas.drawLine(this.f647I, this.f646H.top, this.f647I, this.f646H.bottom, this.f677v);
                obj2 = 1;
            }
            if (this.f678w != null && this.f648J >= this.f646H.top && this.f648J <= this.f646H.bottom) {
                canvas.drawLine(this.f646H.left, this.f648J, this.f646H.right, this.f648J, this.f678w);
                obj = 1;
            }
            if (!(!this.f649K || this.f679x == null || r8 == null || r6 == null)) {
                String str = ("X=" + getDomainValueFormat().format(getDomainCursorVal())) + " Y=" + getRangeValueFormat().format(getRangeCursorVal());
                RectF rectF3 = new RectF(FontUtils.getPackedStringDimensions(str, this.f679x));
                rectF3.offsetTo(this.f647I, this.f648J - rectF3.height());
                if (rectF3.right >= this.f646H.right) {
                    rectF3.offsetTo(this.f647I - rectF3.width(), rectF3.top);
                }
                if (rectF3.top <= this.f646H.top) {
                    rectF3.offsetTo(rectF3.left, this.f648J);
                }
                if (this.f680y != null) {
                    canvas.drawRect(rectF3, this.f680y);
                }
                canvas.drawText(str, rectF3.left, rectF3.bottom, this.f679x);
            }
            if (isDrawMarkersEnabled()) {
                m993b(canvas);
            }
        }
    }

    public void drawRangeTick(Canvas canvas, float f, Number number, Paint paint, Paint paint2, boolean z) {
        if (!z) {
            if (paint2 != null) {
                if (this.f651M) {
                    canvas.drawLine(this.f645G.left - ((float) this.f669n), f, this.f645G.right, f, paint2);
                } else {
                    canvas.drawLine(this.f645G.left, f, this.f645G.right + ((float) this.f669n), f, paint2);
                }
            }
            if (paint != null) {
                m990a(canvas, XYAxisType.RANGE, number, this.f651M ? this.f645G.left - (((float) this.f669n) + this.f660e) : this.f645G.right + (((float) this.f669n) + this.f660e), f - this.f661f, paint);
            }
        } else if (paint2 != null) {
            canvas.drawLine(this.f645G.left, f, this.f645G.right, f, paint2);
        }
    }

    public AxisValueLabelFormatter getAxisValueLabelFormatterForDomainVal(double d) {
        for (RectRegion rectRegion : this.f655Q.elements()) {
            if (rectRegion.containsDomainValue(Double.valueOf(d))) {
                return (AxisValueLabelFormatter) this.f655Q.get(rectRegion);
            }
        }
        return null;
    }

    public AxisValueLabelFormatter getAxisValueLabelFormatterForRangeVal(double d) {
        for (RectRegion rectRegion : this.f655Q.elements()) {
            if (rectRegion.containsRangeValue(Double.valueOf(d))) {
                return (AxisValueLabelFormatter) this.f655Q.get(rectRegion);
            }
        }
        return null;
    }

    public AxisValueLabelFormatter getAxisValueLabelFormatterForVal(double d, double d2) {
        for (RectRegion rectRegion : this.f655Q.elements()) {
            if (rectRegion.containsValue(Double.valueOf(d), Double.valueOf(d2))) {
                return (AxisValueLabelFormatter) this.f655Q.get(rectRegion);
            }
        }
        return null;
    }

    public ZIndexable getAxisValueLabelRegions() {
        return this.f655Q;
    }

    public Paint getCursorLabelBackgroundPaint() {
        return this.f680y;
    }

    public Paint getCursorLabelPaint() {
        return this.f679x;
    }

    public float getDomainCursorPosition() {
        return this.f647I;
    }

    public Double getDomainCursorVal() {
        return getXVal(getDomainCursorPosition());
    }

    public Paint getDomainGridLinePaint() {
        return this.f673r;
    }

    public float getDomainLabelHorizontalOffset() {
        return this.f659d;
    }

    public float getDomainLabelOrientation() {
        return this.f654P;
    }

    public Paint getDomainLabelPaint() {
        return this.f675t;
    }

    public int getDomainLabelTickExtension() {
        return this.f668m;
    }

    public float getDomainLabelVerticalOffset() {
        return this.f658c;
    }

    public float getDomainLabelWidth() {
        return this.f656a;
    }

    public Paint getDomainOriginLabelPaint() {
        return this.f643E;
    }

    public Paint getDomainOriginLinePaint() {
        return this.f641C;
    }

    public Paint getDomainSubGridLinePaint() {
        return this.f674s;
    }

    public Format getDomainValueFormat() {
        return this.f640B;
    }

    public Paint getGridBackgroundPaint() {
        return this.f670o;
    }

    public float getGridPaddingBottom() {
        return this.f665j;
    }

    public float getGridPaddingLeft() {
        return this.f666k;
    }

    public float getGridPaddingRight() {
        return this.f667l;
    }

    public float getGridPaddingTop() {
        return this.f664i;
    }

    public RectF getGridRect() {
        return this.f646H;
    }

    public float getRangeCursorPosition() {
        return this.f648J;
    }

    public Double getRangeCursorVal() {
        return getYVal(getRangeCursorPosition());
    }

    public Paint getRangeGridLinePaint() {
        return this.f671p;
    }

    public float getRangeLabelHorizontalOffset() {
        return this.f660e;
    }

    public float getRangeLabelOrientation() {
        return this.f653O;
    }

    public Paint getRangeLabelPaint() {
        return this.f676u;
    }

    public int getRangeLabelTickExtension() {
        return this.f669n;
    }

    public float getRangeLabelVerticalOffset() {
        return this.f661f;
    }

    public float getRangeLabelWidth() {
        return this.f657b;
    }

    public Paint getRangeOriginLabelPaint() {
        return this.f644F;
    }

    public Paint getRangeOriginLinePaint() {
        return this.f642D;
    }

    public Paint getRangeSubGridLinePaint() {
        return this.f672q;
    }

    public Format getRangeValueFormat() {
        return this.f639A;
    }

    public int getTicksPerDomainLabel() {
        return this.f663h;
    }

    public int getTicksPerRangeLabel() {
        return this.f662g;
    }

    public Double getXVal(float f) {
        return (this.f681z.getCalculatedMinX() == null || this.f681z.getCalculatedMaxX() == null) ? null : Double.valueOf(ValPixConverter.pixToVal(f - this.f646H.left, this.f681z.getCalculatedMinX().doubleValue(), this.f681z.getCalculatedMaxX().doubleValue(), this.f646H.width(), false));
    }

    public Double getXVal(PointF pointF) {
        return getXVal(pointF.x);
    }

    public Double getYVal(float f) {
        return (this.f681z.getCalculatedMinY() == null || this.f681z.getCalculatedMaxY() == null) ? null : Double.valueOf(ValPixConverter.pixToVal(f - this.f646H.top, this.f681z.getCalculatedMinY().doubleValue(), this.f681z.getCalculatedMaxY().doubleValue(), this.f646H.height(), true));
    }

    public Double getYVal(PointF pointF) {
        return getYVal(pointF.y);
    }

    public boolean isDomainAxisBottom() {
        return this.f652N;
    }

    public boolean isDrawMarkersEnabled() {
        return this.f650L;
    }

    public boolean isRangeAxisLeft() {
        return this.f651M;
    }

    public void setCursorLabelBackgroundPaint(Paint paint) {
        this.f680y = paint;
    }

    public void setCursorLabelPaint(Paint paint) {
        this.f679x = paint;
    }

    public void setCursorPosition(float f, float f2) {
        setDomainCursorPosition(f);
        setRangeCursorPosition(f2);
    }

    public void setCursorPosition(PointF pointF) {
        setCursorPosition(pointF.x, pointF.y);
    }

    public void setDomainAxisBottom(boolean z) {
        this.f652N = z;
    }

    public void setDomainAxisPosition(boolean z, boolean z2, int i, String str) {
        setDomainAxisBottom(z);
        Paint domainLabelPaint;
        if (z2) {
            setDomainLabelWidth(1.0f);
            setDomainLabelVerticalOffset(2.0f);
            setDomainLabelTickExtension(0);
            domainLabelPaint = getDomainLabelPaint();
            if (domainLabelPaint != null) {
                Rect packedStringDimensions = FontUtils.getPackedStringDimensions(str, domainLabelPaint);
                if (z) {
                    setDomainLabelVerticalOffset((float) (packedStringDimensions.top * 2));
                    return;
                } else {
                    setDomainLabelVerticalOffset(((float) packedStringDimensions.top) - 1.0f);
                    return;
                }
            }
            return;
        }
        setDomainLabelWidth(1.0f);
        setDomainLabelTickExtension(i);
        domainLabelPaint = getDomainLabelPaint();
        if (domainLabelPaint != null) {
            float fontHeight = FontUtils.getFontHeight(domainLabelPaint);
            if (z) {
                setDomainLabelVerticalOffset(-4.0f);
            } else {
                setDomainLabelVerticalOffset(1.0f);
            }
            setDomainLabelWidth(fontHeight + ((float) getDomainLabelTickExtension()));
        }
    }

    public void setDomainCursorPosition(float f) {
        this.f647I = f;
    }

    public void setDomainGridLinePaint(Paint paint) {
        this.f673r = paint;
    }

    public void setDomainLabelHorizontalOffset(float f) {
        this.f659d = f;
    }

    public void setDomainLabelOrientation(float f) {
        this.f654P = f;
    }

    public void setDomainLabelPaint(Paint paint) {
        this.f675t = paint;
    }

    public void setDomainLabelTickExtension(int i) {
        this.f668m = i;
    }

    public void setDomainLabelVerticalOffset(float f) {
        this.f658c = f;
    }

    public void setDomainLabelWidth(float f) {
        this.f656a = f;
    }

    public void setDomainOriginLabelPaint(Paint paint) {
        this.f643E = paint;
    }

    public void setDomainOriginLinePaint(Paint paint) {
        this.f641C = paint;
    }

    public void setDomainSubGridLinePaint(Paint paint) {
        this.f674s = paint;
    }

    public void setDomainValueFormat(Format format) {
        this.f640B = format;
    }

    public void setDrawMarkersEnabled(boolean z) {
        this.f650L = z;
    }

    public void setGridBackgroundPaint(Paint paint) {
        this.f670o = paint;
    }

    public void setGridPadding(float f, float f2, float f3, float f4) {
        setGridPaddingLeft(f);
        setGridPaddingTop(f2);
        setGridPaddingRight(f3);
        setGridPaddingBottom(f4);
    }

    public void setGridPaddingBottom(float f) {
        this.f665j = f;
    }

    public void setGridPaddingLeft(float f) {
        this.f666k = f;
    }

    public void setGridPaddingRight(float f) {
        this.f667l = f;
    }

    public void setGridPaddingTop(float f) {
        this.f664i = f;
    }

    public void setRangeAxisLeft(boolean z) {
        this.f651M = z;
    }

    public void setRangeAxisPosition(boolean z, boolean z2, int i, String str) {
        setRangeAxisLeft(z);
        Paint rangeLabelPaint;
        if (z2) {
            setRangeLabelWidth(1.0f);
            setRangeLabelHorizontalOffset(-2.0f);
            setRangeLabelVerticalOffset(2.0f);
            rangeLabelPaint = getRangeLabelPaint();
            if (rangeLabelPaint != null) {
                rangeLabelPaint.setTextAlign(z ? Align.LEFT : Align.RIGHT);
            }
            rangeLabelPaint = getRangeOriginLabelPaint();
            if (rangeLabelPaint != null) {
                rangeLabelPaint.setTextAlign(z ? Align.LEFT : Align.RIGHT);
            }
            setRangeLabelTickExtension(0);
            return;
        }
        setRangeLabelWidth(1.0f);
        setRangeLabelHorizontalOffset(1.0f);
        setRangeLabelTickExtension(i);
        rangeLabelPaint = getRangeLabelPaint();
        if (rangeLabelPaint != null) {
            rangeLabelPaint.setTextAlign(!z ? Align.LEFT : Align.RIGHT);
            Rect packedStringDimensions = FontUtils.getPackedStringDimensions(str, rangeLabelPaint);
            setRangeLabelVerticalOffset((float) (packedStringDimensions.top / 2));
            setRangeLabelWidth((float) (packedStringDimensions.right + getRangeLabelTickExtension()));
        }
        rangeLabelPaint = getRangeOriginLabelPaint();
        if (rangeLabelPaint != null) {
            rangeLabelPaint.setTextAlign(!z ? Align.LEFT : Align.RIGHT);
        }
    }

    public void setRangeCursorPosition(float f) {
        this.f648J = f;
    }

    public void setRangeGridLinePaint(Paint paint) {
        this.f671p = paint;
    }

    public void setRangeLabelHorizontalOffset(float f) {
        this.f660e = f;
    }

    public void setRangeLabelOrientation(float f) {
        this.f653O = f;
    }

    public void setRangeLabelPaint(Paint paint) {
        this.f676u = paint;
    }

    public void setRangeLabelTickExtension(int i) {
        this.f669n = i;
    }

    public void setRangeLabelVerticalOffset(float f) {
        this.f661f = f;
    }

    public void setRangeLabelWidth(float f) {
        this.f657b = f;
    }

    public void setRangeOriginLabelPaint(Paint paint) {
        this.f644F = paint;
    }

    public void setRangeOriginLinePaint(Paint paint) {
        this.f642D = paint;
    }

    public void setRangeSubGridLinePaint(Paint paint) {
        this.f672q = paint;
    }

    public void setRangeValueFormat(Format format) {
        this.f639A = format;
    }

    public void setTicksPerDomainLabel(int i) {
        this.f663h = i;
    }

    public void setTicksPerRangeLabel(int i) {
        this.f662g = i;
    }
}
