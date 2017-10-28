package com.androidplot.pie;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.androidplot.ui.Formatter;
import com.androidplot.ui.SeriesRenderer;
import java.util.Set;

public class PieRenderer extends SeriesRenderer {
    private float f474a = 0.0f;
    private float f475b = 0.5f;
    private DonutMode f476c = DonutMode.PERCENT;

    public enum DonutMode {
        PERCENT,
        DP,
        PIXELS
    }

    public PieRenderer(PieChart pieChart) {
        super(pieChart);
    }

    private static double m954a(double[] dArr) {
        double d = 0.0d;
        for (double d2 : dArr) {
            d += d2;
        }
        return 1.0d / d;
    }

    private PointF m955a(float f, float f2, float f3, float f4) {
        PointF pointF = new PointF(f, f2);
        double d = (((double) f4) * 3.141592653589793d) / 180.0d;
        double cos = ((double) f3) * Math.cos(d);
        return new PointF(((float) cos) + pointF.x, pointF.y + ((float) (Math.sin(d) * ((double) f3))));
    }

    private double[] m956a() {
        double[] dArr = new double[((PieChart) getPlot()).getSeriesSet().size()];
        int i = 0;
        for (Segment value : ((PieChart) getPlot()).getSeriesSet()) {
            dArr[i] = value.getValue().doubleValue();
            i++;
        }
        return dArr;
    }

    protected /* synthetic */ void doDrawLegendIcon(Canvas canvas, RectF rectF, Formatter formatter) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public float getRadius(RectF rectF) {
        return rectF.width() < rectF.height() ? rectF.width() / 2.0f : rectF.height() / 2.0f;
    }

    public void onRender(Canvas canvas, RectF rectF) {
        float radius = getRadius(rectF);
        PointF pointF = new PointF(rectF.centerX(), rectF.centerY());
        double[] a = m956a();
        double a2 = m954a(a);
        float f = this.f474a;
        Set<Segment> seriesSet = ((PieChart) getPlot()).getSeriesSet();
        RectF rectF2 = new RectF(pointF.x - radius, pointF.y - radius, pointF.x + radius, pointF.y + radius);
        int i = 0;
        float f2 = f;
        for (Segment segment : seriesSet) {
            float f3;
            float f4 = (float) ((a[i] * a2) * 360.0d);
            float f5 = f2 + f4;
            SegmentFormatter segmentFormatter = (SegmentFormatter) ((PieChart) getPlot()).getFormatter(segment, PieRenderer.class);
            canvas.save();
            float centerX = rectF2.centerX();
            float centerY = rectF2.centerY();
            switch (this.f476c) {
                case PERCENT:
                    f3 = this.f475b * radius;
                    break;
                case PIXELS:
                    f3 = this.f475b > 0.0f ? this.f475b : this.f475b + radius;
                    break;
                default:
                    throw new UnsupportedOperationException("Not yet implemented.");
            }
            PointF a3 = m955a(centerX, centerY, radius, f2);
            pointF = m955a(centerX, centerY, f3, f2);
            PointF a4 = m955a(centerX, centerY, radius, f2 + f4);
            PointF a5 = m955a(centerX, centerY, f3, f2 + f4);
            Path path = new Path();
            path.arcTo(new RectF(rectF2.left - radius, rectF2.top - radius, rectF2.right + radius, rectF2.bottom + radius), f2, f4);
            path.lineTo(centerX, centerY);
            path.close();
            canvas.clipPath(path);
            path = new Path();
            path.arcTo(rectF2, f2, f4);
            path.lineTo(a5.x, a5.y);
            path.arcTo(new RectF(centerX - f3, centerY - f3, centerX + f3, centerY + f3), f2 + f4, -f4);
            path.close();
            canvas.drawPath(path, segmentFormatter.getFillPaint());
            canvas.drawLine(pointF.x, pointF.y, a3.x, a3.y, segmentFormatter.getRadialEdgePaint());
            canvas.drawLine(a5.x, a5.y, a4.x, a4.y, segmentFormatter.getRadialEdgePaint());
            canvas.drawCircle(centerX, centerY, f3, segmentFormatter.getInnerEdgePaint());
            canvas.drawCircle(centerX, centerY, radius, segmentFormatter.getOuterEdgePaint());
            canvas.restore();
            a3 = m955a(centerX, centerY, radius - ((radius - f3) / 2.0f), (f4 / 2.0f) + f2);
            canvas.drawText(segment.getTitle(), a3.x, a3.y, segmentFormatter.getLabelPaint());
            i++;
            f2 = f5;
        }
    }

    public void setDonutSize(float f, DonutMode donutMode) {
        switch (donutMode) {
            case PERCENT:
                if (f < 0.0f || f > 1.0f) {
                    throw new IllegalArgumentException("Size parameter must be between 0 and 1 when operating in PERCENT mode.");
                }
            case PIXELS:
                break;
            default:
                throw new UnsupportedOperationException("Not yet implemented.");
        }
        this.f476c = donutMode;
        this.f475b = f;
    }

    public void setEndDeg(float f) {
    }

    public void setStartDeg(float f) {
        this.f474a = f;
    }
}
