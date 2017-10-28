package com.androidplot.xy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.util.AttributeSet;
import com.androidplot.Plot;
import com.androidplot.Plot.RenderMode;
import com.androidplot.ui.AnchorPosition;
import com.androidplot.ui.DynamicTableModel;
import com.androidplot.ui.SizeLayoutType;
import com.androidplot.ui.SizeMetrics;
import com.androidplot.ui.TextOrientationType;
import com.androidplot.ui.XLayoutStyle;
import com.androidplot.ui.YLayoutStyle;
import com.androidplot.ui.widget.TextLabelWidget;
import com.androidplot.util.PixelUtils;
import java.text.Format;
import java.util.ArrayList;

public class XYPlot extends Plot {
    private Number f689A = null;
    private Number f690B = null;
    private Number f691C = null;
    private Number f692D = null;
    private Number f693E = null;
    private Number f694F = null;
    private XYFramingModel f695G = XYFramingModel.EDGE;
    private XYFramingModel f696H = XYFramingModel.EDGE;
    private Number f697I;
    private Number f698J;
    private Number f699K;
    private Number f700L;
    private Number f701M = null;
    private Number f702N = null;
    private BoundaryMode f703O = BoundaryMode.AUTO;
    private BoundaryMode f704P = BoundaryMode.AUTO;
    private BoundaryMode f705Q = BoundaryMode.AUTO;
    private BoundaryMode f706R = BoundaryMode.AUTO;
    private boolean f707S = true;
    private boolean f708T = true;
    private RectRegion f709U;
    ArrayList f710a;
    ArrayList f711b;
    private BoundaryMode f712c;
    private BoundaryMode f713d;
    private XYLegendWidget f714e;
    private XYGraphWidget f715f;
    private TextLabelWidget f716g;
    private TextLabelWidget f717h;
    private XYStepMode f718i = XYStepMode.SUBDIVIDE;
    private double f719j = 10.0d;
    private XYStepMode f720k = XYStepMode.SUBDIVIDE;
    private double f721l = 10.0d;
    private Number f722m;
    private Number f723n;
    private Number f724o;
    private Number f725p;
    private Number f726q;
    private Number f727r;
    private Number f728s;
    private Number f729t;
    private Number f730u;
    private Number f731v;
    private Number f732w;
    private Number f733x;
    private Number f734y = null;
    private Number f735z = null;

    public XYPlot(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public XYPlot(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public XYPlot(Context context, String str) {
        super(context, str);
    }

    public XYPlot(Context context, String str, RenderMode renderMode) {
        super(context, str, renderMode);
    }

    private static double m998a(double d, double d2) {
        return d > d2 ? d - d2 : d2 - d;
    }

    private static Number m999a(Number number, Number number2, Number number3) {
        Number number4 = (number2 == null || number.doubleValue() > number2.doubleValue()) ? number : number2;
        return (number3 == null || number4.doubleValue() < number3.doubleValue()) ? number4 : number3;
    }

    private synchronized void m1000a(BoundaryMode boundaryMode) {
        this.f703O = boundaryMode;
    }

    private synchronized void m1001a(Number number) {
        this.f723n = number;
    }

    private static boolean m1002a(double d, Number number, Number number2) {
        boolean z = number == null || d >= number.doubleValue();
        boolean z2 = number2 == null || d <= number2.doubleValue();
        return z && z2;
    }

    private synchronized void m1003b(BoundaryMode boundaryMode) {
        this.f704P = boundaryMode;
    }

    private synchronized void m1004b(Number number) {
        this.f722m = number;
    }

    private synchronized void m1005c(BoundaryMode boundaryMode) {
        this.f705Q = boundaryMode;
    }

    private synchronized void m1006c(Number number) {
        this.f725p = number;
    }

    private synchronized void m1007d(BoundaryMode boundaryMode) {
        this.f706R = boundaryMode;
    }

    private synchronized void m1008d(Number number) {
        this.f724o = number;
    }

    protected final void mo152a() {
        this.f714e = new XYLegendWidget(getLayoutManager(), this, new SizeMetrics(PixelUtils.dpToPix(10.0f), SizeLayoutType.ABSOLUTE, 0.5f, SizeLayoutType.RELATIVE), new DynamicTableModel(0, 1), new SizeMetrics(PixelUtils.dpToPix(7.0f), SizeLayoutType.ABSOLUTE, PixelUtils.dpToPix(7.0f), SizeLayoutType.ABSOLUTE));
        this.f715f = new XYGraphWidget(getLayoutManager(), this, new SizeMetrics(PixelUtils.dpToPix(18.0f), SizeLayoutType.FILL, PixelUtils.dpToPix(10.0f), SizeLayoutType.FILL));
        Paint paint = new Paint();
        paint.setColor(-12303292);
        paint.setStyle(Style.FILL);
        this.f715f.setBackgroundPaint(paint);
        this.f716g = new TextLabelWidget(getLayoutManager(), new SizeMetrics(PixelUtils.dpToPix(10.0f), SizeLayoutType.ABSOLUTE, PixelUtils.dpToPix(80.0f), SizeLayoutType.ABSOLUTE), TextOrientationType.HORIZONTAL);
        this.f717h = new TextLabelWidget(getLayoutManager(), new SizeMetrics(PixelUtils.dpToPix(50.0f), SizeLayoutType.ABSOLUTE, PixelUtils.dpToPix(10.0f), SizeLayoutType.ABSOLUTE), TextOrientationType.VERTICAL_ASCENDING);
        this.f714e.position(PixelUtils.dpToPix(40.0f), XLayoutStyle.ABSOLUTE_FROM_RIGHT, PixelUtils.dpToPix(0.0f), YLayoutStyle.ABSOLUTE_FROM_BOTTOM, AnchorPosition.RIGHT_BOTTOM);
        this.f715f.position(PixelUtils.dpToPix(0.0f), XLayoutStyle.ABSOLUTE_FROM_RIGHT, PixelUtils.dpToPix(0.0f), YLayoutStyle.ABSOLUTE_FROM_CENTER, AnchorPosition.RIGHT_MIDDLE);
        this.f716g.position(PixelUtils.dpToPix(20.0f), XLayoutStyle.ABSOLUTE_FROM_LEFT, PixelUtils.dpToPix(0.0f), YLayoutStyle.ABSOLUTE_FROM_BOTTOM, AnchorPosition.LEFT_BOTTOM);
        this.f717h.position(PixelUtils.dpToPix(0.0f), XLayoutStyle.ABSOLUTE_FROM_LEFT, PixelUtils.dpToPix(0.0f), YLayoutStyle.ABSOLUTE_FROM_CENTER, AnchorPosition.LEFT_MIDDLE);
        getLayoutManager().moveToTop(getTitleWidget());
        getLayoutManager().moveToTop(getLegendWidget());
        this.f715f.setMarginTop(PixelUtils.dpToPix(3.0f));
        this.f715f.setMarginRight(PixelUtils.dpToPix(3.0f));
        getDomainLabelWidget().pack();
        getRangeLabelWidget().pack();
        setPlotMarginLeft(PixelUtils.dpToPix(2.0f));
        setPlotMarginRight(PixelUtils.dpToPix(2.0f));
        setPlotMarginBottom(PixelUtils.dpToPix(2.0f));
        this.f711b = new ArrayList();
        this.f710a = new ArrayList();
        setDefaultBounds(new RectRegion(Integer.valueOf(-1), Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(1)));
    }

    public boolean addMarker(XValueMarker xValueMarker) {
        return !this.f711b.contains(xValueMarker) && this.f711b.add(xValueMarker);
    }

    public boolean addMarker(YValueMarker yValueMarker) {
        return this.f710a.contains(yValueMarker) ? false : this.f710a.add(yValueMarker);
    }

    public void calculateMinMaxVals() {
        this.f730u = this.f726q;
        this.f731v = this.f727r;
        this.f732w = this.f728s;
        this.f733x = this.f729t;
        this.f726q = this.f722m;
        this.f727r = this.f723n;
        this.f728s = this.f724o;
        this.f729t = this.f725p;
        for (XYSeries xYSeries : getSeriesSet()) {
            for (int i = 0; i < xYSeries.size(); i++) {
                Number x = xYSeries.getX(i);
                Number y = xYSeries.getY(i);
                Object obj = (x == null || y == null) ? null : (m1002a(y.doubleValue(), this.f724o, this.f725p) && m1002a(x.doubleValue(), this.f722m, this.f723n)) ? 1 : null;
                if (obj != null) {
                    if (this.f722m == null && x != null && (this.f726q == null || x.doubleValue() < this.f726q.doubleValue())) {
                        this.f726q = x;
                    }
                    if (this.f723n == null && x != null && (this.f727r == null || x.doubleValue() > this.f727r.doubleValue())) {
                        this.f727r = x;
                    }
                    if (this.f724o == null && y != null && (this.f728s == null || y.doubleValue() < this.f728s.doubleValue())) {
                        this.f728s = y;
                    }
                    if (this.f725p == null && y != null && (this.f729t == null || y.doubleValue() > this.f729t.doubleValue())) {
                        this.f729t = y;
                    }
                }
            }
        }
        switch (C0145g.f781a[this.f695G.ordinal()]) {
            case 1:
                updateDomainMinMaxForOriginModel();
                break;
            case 2:
                switch (C0145g.f782b[this.f703O.ordinal()]) {
                    case 1:
                    case 2:
                        break;
                    case 3:
                        if (this.f731v != null && this.f727r.doubleValue() <= this.f731v.doubleValue()) {
                            this.f727r = this.f731v;
                            break;
                        }
                    case 4:
                        if (this.f731v != null && this.f727r.doubleValue() >= this.f731v.doubleValue()) {
                            this.f727r = this.f731v;
                            break;
                        }
                    default:
                        throw new UnsupportedOperationException("DomainUpperBoundaryMode not yet implemented: " + this.f703O);
                }
                switch (C0145g.f782b[this.f704P.ordinal()]) {
                    case 1:
                    case 2:
                        break;
                    case 3:
                        if (this.f730u != null && this.f726q.doubleValue() >= this.f730u.doubleValue()) {
                            this.f726q = this.f730u;
                            break;
                        }
                    case 4:
                        if (this.f730u != null && this.f726q.doubleValue() <= this.f730u.doubleValue()) {
                            this.f726q = this.f730u;
                            break;
                        }
                    default:
                        throw new UnsupportedOperationException("DomainLowerBoundaryMode not supported: " + this.f704P);
                }
                this.f726q = m999a(this.f726q, this.f691C, this.f692D);
                this.f727r = m999a(this.f727r, this.f693E, this.f694F);
                break;
            default:
                throw new UnsupportedOperationException("Domain Framing Model not yet supported: " + this.f695G);
        }
        switch (C0145g.f781a[this.f696H.ordinal()]) {
            case 1:
                updateRangeMinMaxForOriginModel();
                break;
            case 2:
                if (getSeriesSet().size() > 0) {
                    updateRangeMinMaxForEdgeModel();
                    this.f728s = m999a(this.f728s, this.f689A, this.f690B);
                    this.f729t = m999a(this.f729t, this.f734y, this.f735z);
                    break;
                }
                break;
            default:
                throw new UnsupportedOperationException("Range Framing Model not yet supported: " + this.f695G);
        }
        this.f699K = this.f697I != null ? this.f697I : getCalculatedMinX();
        this.f700L = this.f698J != null ? this.f698J : getCalculatedMinY();
    }

    public void centerOnDomainOrigin(Number number) {
        centerOnDomainOrigin(number, null, BoundaryMode.AUTO);
    }

    public void centerOnDomainOrigin(Number number, Number number2, BoundaryMode boundaryMode) {
        if (number == null) {
            throw new NullPointerException("Origin param cannot be null.");
        }
        this.f695G = XYFramingModel.ORIGIN;
        setUserDomainOrigin(number);
        this.f701M = number2;
        this.f712c = boundaryMode;
        if (this.f712c == BoundaryMode.FIXED) {
            double doubleValue = this.f697I.doubleValue();
            double doubleValue2 = this.f701M.doubleValue();
            this.f723n = Double.valueOf(doubleValue + doubleValue2);
            this.f722m = Double.valueOf(doubleValue - doubleValue2);
            return;
        }
        this.f723n = null;
        this.f722m = null;
    }

    public void centerOnRangeOrigin(Number number) {
        centerOnRangeOrigin(number, null, BoundaryMode.AUTO);
    }

    public void centerOnRangeOrigin(Number number, Number number2, BoundaryMode boundaryMode) {
        if (number == null) {
            throw new NullPointerException("Origin param cannot be null.");
        }
        this.f696H = XYFramingModel.ORIGIN;
        setUserRangeOrigin(number);
        this.f702N = number2;
        this.f713d = boundaryMode;
        if (this.f713d == BoundaryMode.FIXED) {
            double doubleValue = this.f698J.doubleValue();
            double doubleValue2 = this.f702N.doubleValue();
            this.f725p = Double.valueOf(doubleValue + doubleValue2);
            this.f724o = Double.valueOf(doubleValue - doubleValue2);
            return;
        }
        this.f725p = null;
        this.f724o = null;
    }

    public boolean containsPoint(float f, float f2) {
        return getGraphWidget().getGridRect() != null ? getGraphWidget().getGridRect().contains(f, f2) : false;
    }

    public boolean containsPoint(PointF pointF) {
        return containsPoint(pointF.x, pointF.y);
    }

    public Number getCalculatedMaxX() {
        return this.f727r != null ? this.f727r : getDefaultBounds().getMaxX();
    }

    public Number getCalculatedMaxY() {
        return this.f729t != null ? this.f729t : getDefaultBounds().getMaxY();
    }

    public Number getCalculatedMinX() {
        return this.f726q != null ? this.f726q : getDefaultBounds().getMinX();
    }

    public Number getCalculatedMinY() {
        return this.f728s != null ? this.f728s : getDefaultBounds().getMinY();
    }

    public RectRegion getDefaultBounds() {
        return this.f709U;
    }

    public XYFramingModel getDomainFramingModel() {
        return this.f695G;
    }

    public String getDomainLabel() {
        return getDomainLabelWidget().getText();
    }

    public TextLabelWidget getDomainLabelWidget() {
        return this.f716g;
    }

    public Number getDomainLeftMax() {
        return this.f692D;
    }

    public Number getDomainLeftMin() {
        return this.f691C;
    }

    public Number getDomainOrigin() {
        return this.f699K;
    }

    public Number getDomainRightMax() {
        return this.f694F;
    }

    public Number getDomainRightMin() {
        return this.f693E;
    }

    public XYStepMode getDomainStepMode() {
        return this.f718i;
    }

    public double getDomainStepValue() {
        return this.f719j;
    }

    public Format getDomainValueFormat() {
        return this.f715f.getDomainValueFormat();
    }

    public XYGraphWidget getGraphWidget() {
        return this.f715f;
    }

    public XYLegendWidget getLegendWidget() {
        return this.f714e;
    }

    public Number getRangeBottomMax() {
        return this.f690B;
    }

    public Number getRangeBottomMin() {
        return this.f689A;
    }

    public XYFramingModel getRangeFramingModel() {
        return this.f696H;
    }

    public String getRangeLabel() {
        return getRangeLabelWidget().getText();
    }

    public TextLabelWidget getRangeLabelWidget() {
        return this.f717h;
    }

    public Number getRangeOrigin() {
        return this.f700L;
    }

    public XYStepMode getRangeStepMode() {
        return this.f720k;
    }

    public double getRangeStepValue() {
        return this.f721l;
    }

    public Number getRangeTopMax() {
        return this.f735z;
    }

    public Number getRangeTopMin() {
        return this.f734y;
    }

    public Format getRangeValueFormat() {
        return this.f715f.getRangeValueFormat();
    }

    public int getTicksPerDomainLabel() {
        return this.f715f.getTicksPerDomainLabel();
    }

    public int getTicksPerRangeLabel() {
        return this.f715f.getTicksPerRangeLabel();
    }

    public Number getXVal(PointF pointF) {
        return getGraphWidget().getXVal(pointF);
    }

    public Number getYVal(PointF pointF) {
        return getGraphWidget().getYVal(pointF);
    }

    public boolean isDrawDomainOriginEnabled() {
        return this.f707S;
    }

    public boolean isDrawRangeOriginEnabled() {
        return this.f708T;
    }

    protected final void notifyListenersBeforeDraw(Canvas canvas) {
        super.notifyListenersBeforeDraw(canvas);
        calculateMinMaxVals();
    }

    public XValueMarker removeMarker(XValueMarker xValueMarker) {
        int indexOf = this.f711b.indexOf(xValueMarker);
        return indexOf == -1 ? null : (XValueMarker) this.f711b.remove(indexOf);
    }

    public YValueMarker removeMarker(YValueMarker yValueMarker) {
        int indexOf = this.f710a.indexOf(yValueMarker);
        return indexOf == -1 ? null : (YValueMarker) this.f710a.remove(indexOf);
    }

    public int removeMarkers() {
        return removeXMarkers() + removeYMarkers();
    }

    public int removeXMarkers() {
        int size = this.f711b.size();
        this.f711b.clear();
        return size;
    }

    public int removeYMarkers() {
        int size = this.f710a.size();
        this.f710a.clear();
        return size;
    }

    public void setCursorPosition(float f, float f2) {
        getGraphWidget().setCursorPosition(f, f2);
    }

    public void setCursorPosition(PointF pointF) {
        getGraphWidget().setCursorPosition(pointF);
    }

    public void setDefaultBounds(RectRegion rectRegion) {
        this.f709U = rectRegion;
    }

    public synchronized void setDomainBoundaries(Number number, BoundaryMode boundaryMode, Number number2, BoundaryMode boundaryMode2) {
        setDomainLowerBoundary(number, boundaryMode);
        setDomainUpperBoundary(number2, boundaryMode2);
    }

    public synchronized void setDomainBoundaries(Number number, Number number2, BoundaryMode boundaryMode) {
        setDomainBoundaries(number, boundaryMode, number2, boundaryMode);
    }

    public void setDomainLabel(String str) {
        getDomainLabelWidget().setText(str);
    }

    public void setDomainLabelWidget(TextLabelWidget textLabelWidget) {
        this.f716g = textLabelWidget;
    }

    public synchronized void setDomainLeftMax(Number number) {
        this.f692D = number;
    }

    public synchronized void setDomainLeftMin(Number number) {
        this.f691C = number;
    }

    public synchronized void setDomainLowerBoundary(Number number, BoundaryMode boundaryMode) {
        if (boundaryMode != BoundaryMode.FIXED) {
            number = null;
        }
        m1004b(number);
        m1003b(boundaryMode);
        this.f695G = XYFramingModel.EDGE;
    }

    public synchronized void setDomainRightMax(Number number) {
        this.f694F = number;
    }

    public synchronized void setDomainRightMin(Number number) {
        this.f693E = number;
    }

    public void setDomainStep(XYStepMode xYStepMode, double d) {
        setDomainStepMode(xYStepMode);
        setDomainStepValue(d);
    }

    public void setDomainStepMode(XYStepMode xYStepMode) {
        this.f718i = xYStepMode;
    }

    public void setDomainStepValue(double d) {
        this.f719j = d;
    }

    public synchronized void setDomainUpperBoundary(Number number, BoundaryMode boundaryMode) {
        if (boundaryMode != BoundaryMode.FIXED) {
            number = null;
        }
        m1001a(number);
        m1000a(boundaryMode);
        this.f695G = XYFramingModel.EDGE;
    }

    public void setDomainValueFormat(Format format) {
        this.f715f.setDomainValueFormat(format);
    }

    public void setDrawDomainOriginEnabled(boolean z) {
        this.f707S = z;
    }

    public void setDrawRangeOriginEnabled(boolean z) {
        this.f708T = z;
    }

    public void setGraphWidget(XYGraphWidget xYGraphWidget) {
        this.f715f = xYGraphWidget;
    }

    public void setGridPadding(float f, float f2, float f3, float f4) {
        getGraphWidget().setGridPaddingTop(f2);
        getGraphWidget().setGridPaddingBottom(f4);
        getGraphWidget().setGridPaddingLeft(f);
        getGraphWidget().setGridPaddingRight(f3);
    }

    public void setLegendWidget(XYLegendWidget xYLegendWidget) {
        this.f714e = xYLegendWidget;
    }

    public synchronized void setRangeBottomMax(Number number) {
        this.f690B = number;
    }

    public synchronized void setRangeBottomMin(Number number) {
        this.f689A = number;
    }

    public synchronized void setRangeBoundaries(Number number, BoundaryMode boundaryMode, Number number2, BoundaryMode boundaryMode2) {
        setRangeLowerBoundary(number, boundaryMode);
        setRangeUpperBoundary(number2, boundaryMode2);
    }

    public synchronized void setRangeBoundaries(Number number, Number number2, BoundaryMode boundaryMode) {
        setRangeBoundaries(number, boundaryMode, number2, boundaryMode);
    }

    public void setRangeLabel(String str) {
        getRangeLabelWidget().setText(str);
    }

    public void setRangeLabelWidget(TextLabelWidget textLabelWidget) {
        this.f717h = textLabelWidget;
    }

    public synchronized void setRangeLowerBoundary(Number number, BoundaryMode boundaryMode) {
        if (boundaryMode != BoundaryMode.FIXED) {
            number = null;
        }
        m1008d(number);
        m1007d(boundaryMode);
        this.f696H = XYFramingModel.EDGE;
    }

    public void setRangeStep(XYStepMode xYStepMode, double d) {
        setRangeStepMode(xYStepMode);
        setRangeStepValue(d);
    }

    public void setRangeStepMode(XYStepMode xYStepMode) {
        this.f720k = xYStepMode;
    }

    public void setRangeStepValue(double d) {
        this.f721l = d;
    }

    public synchronized void setRangeTopMax(Number number) {
        this.f735z = number;
    }

    public synchronized void setRangeTopMin(Number number) {
        this.f734y = number;
    }

    public synchronized void setRangeUpperBoundary(Number number, BoundaryMode boundaryMode) {
        if (boundaryMode != BoundaryMode.FIXED) {
            number = null;
        }
        m1006c(number);
        m1005c(boundaryMode);
        this.f696H = XYFramingModel.EDGE;
    }

    public void setRangeValueFormat(Format format) {
        this.f715f.setRangeValueFormat(format);
    }

    public void setTicksPerDomainLabel(int i) {
        this.f715f.setTicksPerDomainLabel(i);
    }

    public void setTicksPerRangeLabel(int i) {
        this.f715f.setTicksPerRangeLabel(i);
    }

    public synchronized void setUserDomainOrigin(Number number) {
        if (number == null) {
            throw new NullPointerException("Origin value cannot be null.");
        }
        this.f697I = number;
    }

    public synchronized void setUserRangeOrigin(Number number) {
        if (number == null) {
            throw new NullPointerException("Origin value cannot be null.");
        }
        this.f698J = number;
    }

    public void updateDomainMinMaxForOriginModel() {
        double doubleValue = this.f697I.doubleValue();
        double a = m998a(this.f727r.doubleValue(), doubleValue);
        double a2 = m998a(this.f726q.doubleValue(), doubleValue);
        if (a <= a2) {
            a = a2;
        }
        a2 = doubleValue - a;
        a += doubleValue;
        switch (C0145g.f782b[this.f712c.ordinal()]) {
            case 1:
                return;
            case 2:
                this.f726q = Double.valueOf(a2);
                this.f727r = Double.valueOf(a);
                return;
            case 3:
                if (this.f730u == null || a2 < this.f730u.doubleValue()) {
                    this.f726q = Double.valueOf(a2);
                } else {
                    this.f726q = this.f730u;
                }
                if (this.f731v == null || a > this.f731v.doubleValue()) {
                    this.f727r = Double.valueOf(a);
                    return;
                } else {
                    this.f727r = this.f731v;
                    return;
                }
            case 4:
                if (this.f730u == null || a2 > this.f730u.doubleValue()) {
                    this.f726q = Double.valueOf(a2);
                } else {
                    this.f726q = this.f730u;
                }
                if (this.f731v == null || a < this.f731v.doubleValue()) {
                    this.f727r = Double.valueOf(a);
                    return;
                } else {
                    this.f727r = this.f731v;
                    return;
                }
            default:
                throw new UnsupportedOperationException("Domain Origin Boundary Mode not yet supported: " + this.f712c);
        }
    }

    public void updateRangeMinMaxForEdgeModel() {
        switch (C0145g.f782b[this.f705Q.ordinal()]) {
            case 1:
            case 2:
                break;
            case 3:
                if (this.f733x != null && this.f729t.doubleValue() <= this.f733x.doubleValue()) {
                    this.f729t = this.f733x;
                    break;
                }
            case 4:
                if (this.f733x != null && this.f729t.doubleValue() >= this.f733x.doubleValue()) {
                    this.f729t = this.f733x;
                    break;
                }
            default:
                throw new UnsupportedOperationException("RangeUpperBoundaryMode not supported: " + this.f705Q);
        }
        switch (C0145g.f782b[this.f706R.ordinal()]) {
            case 1:
            case 2:
                return;
            case 3:
                if (this.f732w != null && this.f728s.doubleValue() >= this.f732w.doubleValue()) {
                    this.f728s = this.f732w;
                    return;
                }
                return;
            case 4:
                if (this.f732w != null && this.f728s.doubleValue() <= this.f732w.doubleValue()) {
                    this.f728s = this.f732w;
                    return;
                }
                return;
            default:
                throw new UnsupportedOperationException("RangeLowerBoundaryMode not supported: " + this.f706R);
        }
    }

    public void updateRangeMinMaxForOriginModel() {
        switch (C0145g.f782b[this.f713d.ordinal()]) {
            case 2:
                double doubleValue = this.f698J.doubleValue();
                double a = m998a(this.f729t.doubleValue(), doubleValue);
                double a2 = m998a(this.f728s.doubleValue(), doubleValue);
                if (a > a2) {
                    this.f728s = Double.valueOf(doubleValue - a);
                    this.f729t = Double.valueOf(doubleValue + a);
                    return;
                }
                this.f728s = Double.valueOf(doubleValue - a2);
                this.f729t = Double.valueOf(doubleValue + a2);
                return;
            default:
                throw new UnsupportedOperationException("Range Origin Boundary Mode not yet supported: " + this.f713d);
        }
    }
}
