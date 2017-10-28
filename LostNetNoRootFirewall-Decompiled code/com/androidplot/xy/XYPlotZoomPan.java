package com.androidplot.xy;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.androidplot.Plot.RenderMode;
import com.google.android.vending.licensing.APKExpansionPolicy;

public class XYPlotZoomPan extends XYPlot implements OnTouchListener {
    private C0146h f736c = C0146h.NONE;
    private float f737d = Float.MAX_VALUE;
    private float f738e = Float.MAX_VALUE;
    private float f739f = Float.MAX_VALUE;
    private float f740g = Float.MAX_VALUE;
    private float f741h = Float.MAX_VALUE;
    private float f742i = Float.MAX_VALUE;
    private float f743j = Float.MAX_VALUE;
    private float f744k = Float.MAX_VALUE;
    private PointF f745l;
    private float f746m;
    private boolean f747n;
    private boolean f748o;
    private boolean f749p;
    private boolean f750q;
    private boolean f751r;
    private boolean f752s;
    private boolean f753t;

    public XYPlotZoomPan(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (this.f747n || !this.f751r) {
            setZoomEnabled(true);
        }
        if (!this.f753t) {
            this.f749p = true;
        }
        if (!this.f752s) {
            this.f748o = true;
        }
    }

    public XYPlotZoomPan(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (this.f747n || !this.f751r) {
            setZoomEnabled(true);
        }
        if (!this.f753t) {
            this.f749p = true;
        }
        if (!this.f752s) {
            this.f748o = true;
        }
    }

    public XYPlotZoomPan(Context context, String str) {
        super(context, str);
    }

    public XYPlotZoomPan(Context context, String str, RenderMode renderMode) {
        super(context, str, renderMode);
        setZoomEnabled(true);
    }

    private static float m1010a(MotionEvent motionEvent) {
        return motionEvent.getX(0) - motionEvent.getX(1);
    }

    private void m1011a(float f, PointF pointF, boolean z) {
        float g;
        float f2;
        if (z) {
            g = m1018g();
            f2 = g - m1017f();
        } else {
            g = m1020i();
            f2 = g - m1019h();
        }
        g -= f2 / 2.0f;
        f2 = (f2 * f) / 2.0f;
        pointF.x = g - f2;
        pointF.y = f2 + g;
        if (z) {
            if (pointF.x < m1013b()) {
                pointF.x = m1013b();
            }
            if (pointF.y > m1014c()) {
                pointF.y = m1014c();
                return;
            }
            return;
        }
        if (pointF.x < m1015d()) {
            pointF.x = m1015d();
        }
        if (pointF.y > m1016e()) {
            pointF.y = m1016e();
        }
    }

    private void m1012a(PointF pointF, PointF pointF2, boolean z) {
        float width;
        if (z) {
            pointF2.x = m1017f();
            pointF2.y = m1018g();
            width = (pointF.x - this.f745l.x) * ((pointF2.y - pointF2.x) / ((float) getWidth()));
        } else {
            pointF2.x = m1019h();
            pointF2.y = m1020i();
            width = (-(pointF.y - this.f745l.y)) * ((pointF2.y - pointF2.x) / ((float) getHeight()));
        }
        pointF2.x += width;
        pointF2.y = width + pointF2.y;
        width = pointF2.y - pointF2.x;
        if (z) {
            if (pointF2.x < m1013b()) {
                pointF2.x = m1013b();
                pointF2.y = pointF2.x + width;
            }
            if (pointF2.y > m1014c()) {
                pointF2.y = m1014c();
                pointF2.x = pointF2.y - width;
                return;
            }
            return;
        }
        if (pointF2.x < m1015d()) {
            pointF2.x = m1015d();
            pointF2.y = pointF2.x + width;
        }
        if (pointF2.y > m1016e()) {
            pointF2.y = m1016e();
            pointF2.x = pointF2.y - width;
        }
    }

    private float m1013b() {
        if (this.f737d == Float.MAX_VALUE) {
            this.f737d = getCalculatedMinX().floatValue();
            this.f741h = this.f737d;
        }
        return this.f737d;
    }

    private float m1014c() {
        if (this.f738e == Float.MAX_VALUE) {
            this.f738e = getCalculatedMaxX().floatValue();
            this.f742i = this.f738e;
        }
        return this.f738e;
    }

    private float m1015d() {
        if (this.f739f == Float.MAX_VALUE) {
            this.f739f = getCalculatedMinY().floatValue();
            this.f743j = this.f739f;
        }
        return this.f739f;
    }

    private float m1016e() {
        if (this.f740g == Float.MAX_VALUE) {
            this.f740g = getCalculatedMaxY().floatValue();
            this.f744k = this.f740g;
        }
        return this.f740g;
    }

    private float m1017f() {
        if (this.f741h == Float.MAX_VALUE) {
            this.f741h = getCalculatedMinX().floatValue();
        }
        return this.f741h;
    }

    private float m1018g() {
        if (this.f742i == Float.MAX_VALUE) {
            this.f742i = getCalculatedMaxX().floatValue();
        }
        return this.f742i;
    }

    private float m1019h() {
        if (this.f743j == Float.MAX_VALUE) {
            this.f743j = getCalculatedMinY().floatValue();
        }
        return this.f743j;
    }

    private float m1020i() {
        if (this.f744k == Float.MAX_VALUE) {
            this.f744k = getCalculatedMaxY().floatValue();
        }
        return this.f744k;
    }

    public boolean getZoomEnabled() {
        return this.f747n;
    }

    public boolean getZoomHorizontally() {
        return this.f749p;
    }

    public boolean getZoomVertically() {
        return this.f748o;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                this.f745l = new PointF(motionEvent.getX(), motionEvent.getY());
                this.f736c = C0146h.ONE_FINGER_DRAG;
                break;
            case 2:
                PointF pointF;
                if (this.f736c != C0146h.ONE_FINGER_DRAG) {
                    if (this.f736c == C0146h.TWO_FINGERS_DRAG) {
                        float f = this.f746m;
                        float a = m1010a(motionEvent);
                        if ((f <= 0.0f || a >= 0.0f) && (f >= 0.0f || a <= 0.0f)) {
                            this.f746m = a;
                            f /= this.f746m;
                            if (!(Float.isInfinite(f) || Float.isNaN(f) || (((double) f) > -0.001d && ((double) f) < 0.001d))) {
                                pointF = new PointF();
                                if (this.f749p) {
                                    m1011a(f, pointF, true);
                                    this.f750q = true;
                                    super.setDomainBoundaries(Float.valueOf(pointF.x), Float.valueOf(pointF.y), BoundaryMode.FIXED);
                                    this.f741h = pointF.x;
                                    this.f742i = pointF.y;
                                }
                                if (this.f748o) {
                                    m1011a(f, pointF, false);
                                    this.f750q = true;
                                    super.setRangeBoundaries(Float.valueOf(pointF.x), Float.valueOf(pointF.y), BoundaryMode.FIXED);
                                    this.f743j = pointF.x;
                                    this.f744k = pointF.y;
                                }
                                redraw();
                                break;
                            }
                        }
                    }
                }
                PointF pointF2 = this.f745l;
                this.f745l = new PointF(motionEvent.getX(), motionEvent.getY());
                pointF = new PointF();
                if (this.f749p) {
                    m1012a(pointF2, pointF, true);
                    this.f750q = true;
                    super.setDomainBoundaries(Float.valueOf(pointF.x), Float.valueOf(pointF.y), BoundaryMode.FIXED);
                    this.f741h = pointF.x;
                    this.f742i = pointF.y;
                }
                if (this.f748o) {
                    m1012a(pointF2, pointF, false);
                    this.f750q = true;
                    super.setRangeBoundaries(Float.valueOf(pointF.x), Float.valueOf(pointF.y), BoundaryMode.FIXED);
                    this.f743j = pointF.x;
                    this.f744k = pointF.y;
                }
                redraw();
                break;
                break;
            case 5:
                this.f746m = m1010a(motionEvent);
                if (this.f746m > 5.0f || this.f746m < -5.0f) {
                    this.f736c = C0146h.TWO_FINGERS_DRAG;
                    break;
                }
            case 6:
                this.f736c = C0146h.NONE;
                break;
        }
        return true;
    }

    public synchronized void setDomainBoundaries(Number number, BoundaryMode boundaryMode, Number number2, BoundaryMode boundaryMode2) {
        super.setDomainBoundaries(number, boundaryMode, number2, boundaryMode2);
        if (this.f750q) {
            this.f750q = false;
        } else {
            this.f737d = boundaryMode == BoundaryMode.FIXED ? number.floatValue() : getCalculatedMinX().floatValue();
            this.f738e = boundaryMode2 == BoundaryMode.FIXED ? number2.floatValue() : getCalculatedMaxX().floatValue();
            this.f741h = this.f737d;
            this.f742i = this.f738e;
        }
    }

    public synchronized void setDomainBoundaries(Number number, Number number2, BoundaryMode boundaryMode) {
        super.setDomainBoundaries(number, number2, boundaryMode);
        if (this.f750q) {
            this.f750q = false;
        } else {
            this.f737d = boundaryMode == BoundaryMode.FIXED ? number.floatValue() : getCalculatedMinX().floatValue();
            this.f738e = boundaryMode == BoundaryMode.FIXED ? number2.floatValue() : getCalculatedMaxX().floatValue();
            this.f741h = this.f737d;
            this.f742i = this.f738e;
        }
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        if (onTouchListener != this) {
            this.f747n = false;
        }
        super.setOnTouchListener(onTouchListener);
    }

    public synchronized void setRangeBoundaries(Number number, BoundaryMode boundaryMode, Number number2, BoundaryMode boundaryMode2) {
        super.setRangeBoundaries(number, boundaryMode, number2, boundaryMode2);
        if (this.f750q) {
            this.f750q = false;
        } else {
            this.f739f = boundaryMode == BoundaryMode.FIXED ? number.floatValue() : getCalculatedMinY().floatValue();
            this.f740g = boundaryMode2 == BoundaryMode.FIXED ? number2.floatValue() : getCalculatedMaxY().floatValue();
            this.f743j = this.f739f;
            this.f744k = this.f740g;
        }
    }

    public synchronized void setRangeBoundaries(Number number, Number number2, BoundaryMode boundaryMode) {
        super.setRangeBoundaries(number, number2, boundaryMode);
        if (this.f750q) {
            this.f750q = false;
        } else {
            this.f739f = boundaryMode == BoundaryMode.FIXED ? number.floatValue() : getCalculatedMinY().floatValue();
            this.f740g = boundaryMode == BoundaryMode.FIXED ? number2.floatValue() : getCalculatedMaxY().floatValue();
            this.f743j = this.f739f;
            this.f744k = this.f740g;
        }
    }

    public void setZoomEnabled(boolean z) {
        if (z) {
            setOnTouchListener(this);
        } else {
            setOnTouchListener(null);
        }
        this.f747n = z;
        this.f751r = true;
    }

    public void setZoomHorizontally(boolean z) {
        this.f749p = z;
        this.f753t = true;
    }

    public void setZoomVertically(boolean z) {
        this.f748o = z;
        this.f752s = true;
    }
}
