package com.androidplot.xy;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Pair;
import com.androidplot.util.ValPixConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LineAndPointRenderer extends XYSeriesRenderer {
    public LineAndPointRenderer(XYPlot xYPlot) {
        super(xYPlot);
    }

    private void m983a(Canvas canvas, RectF rectF, Path path, PointF pointF, PointF pointF2, LineAndPointFormatter lineAndPointFormatter) {
        Path path2 = new Path(path);
        switch (C0142d.f778a[lineAndPointFormatter.getFillDirection().ordinal()]) {
            case 1:
                path.lineTo(pointF2.x, rectF.bottom);
                path.lineTo(pointF.x, rectF.bottom);
                path.close();
                break;
            case 2:
                path.lineTo(pointF2.x, rectF.top);
                path.lineTo(pointF.x, rectF.top);
                path.close();
                break;
            case 3:
                float valToPix = ValPixConverter.valToPix(((XYPlot) getPlot()).getRangeOrigin().doubleValue(), ((XYPlot) getPlot()).getCalculatedMinY().doubleValue(), ((XYPlot) getPlot()).getCalculatedMaxY().doubleValue(), rectF.height(), true) + rectF.top;
                path.lineTo(pointF2.x, valToPix);
                path.lineTo(pointF.x, valToPix);
                path.close();
                break;
            default:
                throw new UnsupportedOperationException("Fill direction not yet implemented: " + lineAndPointFormatter.getFillDirection());
        }
        if (lineAndPointFormatter.getFillPaint() != null) {
            canvas.drawPath(path, lineAndPointFormatter.getFillPaint());
        }
        double doubleValue = ((XYPlot) getPlot()).getCalculatedMinX().doubleValue();
        double doubleValue2 = ((XYPlot) getPlot()).getCalculatedMaxX().doubleValue();
        double doubleValue3 = ((XYPlot) getPlot()).getCalculatedMinY().doubleValue();
        double doubleValue4 = ((XYPlot) getPlot()).getCalculatedMaxY().doubleValue();
        for (RectRegion rectRegion : RectRegion.regionsWithin(lineAndPointFormatter.getRegions().elements(), Double.valueOf(doubleValue), Double.valueOf(doubleValue2), Double.valueOf(doubleValue3), Double.valueOf(doubleValue4))) {
            XYRegionFormatter regionFormatter = lineAndPointFormatter.getRegionFormatter(rectRegion);
            RectF rectF2 = rectRegion.getRectF(rectF, Double.valueOf(doubleValue), Double.valueOf(doubleValue2), Double.valueOf(doubleValue3), Double.valueOf(doubleValue4));
            if (rectF2 != null) {
                try {
                    canvas.save(31);
                    canvas.clipPath(path);
                    canvas.drawRect(rectF2, regionFormatter.getPaint());
                } finally {
                    canvas.restore();
                }
            }
        }
        if (lineAndPointFormatter.getLinePaint() != null) {
            canvas.drawPath(path2, lineAndPointFormatter.getLinePaint());
        }
        path.rewind();
    }

    protected void mo200a(Path path, PointF pointF, PointF pointF2) {
        path.lineTo(pointF.x, pointF.y);
    }

    public void doDrawLegendIcon(Canvas canvas, RectF rectF, LineAndPointFormatter lineAndPointFormatter) {
        float centerY = rectF.centerY();
        float centerX = rectF.centerX();
        if (lineAndPointFormatter.getFillPaint() != null) {
            canvas.drawRect(rectF, lineAndPointFormatter.getFillPaint());
        }
        if (lineAndPointFormatter.getLinePaint() != null) {
            canvas.drawLine(rectF.left, rectF.bottom, rectF.right, rectF.top, lineAndPointFormatter.getLinePaint());
        }
        if (lineAndPointFormatter.getVertexPaint() != null) {
            canvas.drawPoint(centerX, centerY, lineAndPointFormatter.getVertexPaint());
        }
    }

    public void onRender(Canvas canvas, RectF rectF) {
        List<XYSeries> seriesListForRenderer = ((XYPlot) getPlot()).getSeriesListForRenderer(getClass());
        if (seriesListForRenderer != null) {
            for (XYSeries xYSeries : seriesListForRenderer) {
                LineAndPointFormatter lineAndPointFormatter = (LineAndPointFormatter) getFormatter(xYSeries);
                Paint linePaint = lineAndPointFormatter.getLinePaint();
                Path path = null;
                ArrayList arrayList = new ArrayList(xYSeries.size());
                int i = 0;
                PointF pointF = null;
                PointF pointF2 = null;
                while (i < xYSeries.size()) {
                    PointF pointF3;
                    PointF pointF4;
                    Path path2;
                    Number y = xYSeries.getY(i);
                    Number x = xYSeries.getX(i);
                    if (y == null || x == null) {
                        pointF3 = null;
                    } else {
                        pointF3 = ValPixConverter.valToPix(x, y, rectF, ((XYPlot) getPlot()).getCalculatedMinX(), ((XYPlot) getPlot()).getCalculatedMaxX(), ((XYPlot) getPlot()).getCalculatedMinY(), ((XYPlot) getPlot()).getCalculatedMaxY());
                        arrayList.add(new Pair(pointF3, Integer.valueOf(i)));
                    }
                    if (linePaint == null || pointF3 == null) {
                        if (pointF2 != null) {
                            m983a(canvas, rectF, path, pointF, pointF2, lineAndPointFormatter);
                        }
                        pointF3 = null;
                        pointF4 = null;
                        path2 = path;
                    } else {
                        if (pointF == null) {
                            path2 = new Path();
                            path2.moveTo(pointF3.x, pointF3.y);
                            pointF4 = pointF3;
                        } else {
                            path2 = path;
                            pointF4 = pointF;
                        }
                        if (pointF2 != null) {
                            mo200a(path2, pointF3, pointF2);
                        }
                    }
                    i++;
                    path = path2;
                    pointF = pointF4;
                    pointF2 = pointF3;
                }
                if (!(linePaint == null || pointF == null)) {
                    m983a(canvas, rectF, path, pointF, pointF2, lineAndPointFormatter);
                }
                Paint vertexPaint = lineAndPointFormatter.getVertexPaint();
                PointLabelFormatter pointLabelFormatter = lineAndPointFormatter.getPointLabelFormatter();
                if (vertexPaint != null || pointLabelFormatter != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        PointLabeler pointLabeler = lineAndPointFormatter.getPointLabeler();
                        if (vertexPaint != null) {
                            canvas.drawPoint(((PointF) pair.first).x, ((PointF) pair.first).y, lineAndPointFormatter.getVertexPaint());
                        }
                        if (!(pointLabelFormatter == null || pointLabeler == null)) {
                            Canvas canvas2 = canvas;
                            canvas2.drawText(pointLabeler.getLabel(xYSeries, ((Integer) pair.second).intValue()), pointLabelFormatter.hOffset + ((PointF) pair.first).x, ((PointF) pair.first).y + pointLabelFormatter.vOffset, pointLabelFormatter.getTextPaint());
                        }
                    }
                }
            }
        }
    }
}
