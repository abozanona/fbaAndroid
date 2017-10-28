package com.androidplot.xy;

import android.graphics.Canvas;
import android.graphics.RectF;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BarRenderer extends XYSeriesRenderer {
    BarRenderStyle f613a = BarRenderStyle.OVERLAID;
    private BarWidthStyle f614b = BarWidthStyle.FIXED_WIDTH;
    private float f615c = 5.0f;
    private float f616d = 1.0f;

    public class BarComparator implements Comparator {
        private /* synthetic */ BarRenderer f610a;

        public BarComparator(BarRenderer barRenderer) {
            this.f610a = barRenderer;
        }

        public int compare(C0141c c0141c, C0141c c0141c2) {
            switch (C0139a.f760b[this.f610a.f613a.ordinal()]) {
                case 1:
                    return Integer.valueOf(c0141c.f771d).compareTo(Integer.valueOf(c0141c2.f771d));
                case 2:
                    return c0141c.f768a.getTitle().compareToIgnoreCase(c0141c2.f768a.getTitle());
                case 3:
                    return c0141c.f768a.getTitle().compareToIgnoreCase(c0141c2.f768a.getTitle());
                default:
                    return 0;
            }
        }
    }

    public enum BarRenderStyle {
        OVERLAID,
        STACKED,
        SIDE_BY_SIDE
    }

    public enum BarWidthStyle {
        FIXED_WIDTH,
        VARIABLE_WIDTH
    }

    public BarRenderer(XYPlot xYPlot) {
        super(xYPlot);
    }

    public void doDrawLegendIcon(Canvas canvas, RectF rectF, BarFormatter barFormatter) {
        canvas.drawRect(rectF, barFormatter.getFillPaint());
        canvas.drawRect(rectF, barFormatter.getBorderPaint());
    }

    public void onRender(Canvas canvas, RectF rectF) {
        List<XYSeries> seriesListForRenderer = ((XYPlot) getPlot()).getSeriesListForRenderer(getClass());
        TreeMap treeMap = new TreeMap();
        if (seriesListForRenderer != null) {
            C0140b c0140b;
            C0140b c0140b2;
            for (XYSeries xYSeries : seriesListForRenderer) {
                for (int i = 0; i < xYSeries.size(); i++) {
                    if (xYSeries.getX(i) != null) {
                        C0141c c0141c = new C0141c(this, xYSeries, i, rectF);
                        if (treeMap.containsKey(Integer.valueOf(c0141c.f770c))) {
                            c0140b = (C0140b) treeMap.get(Integer.valueOf(c0141c.f770c));
                        } else {
                            c0140b = new C0140b(this, c0141c.f770c, rectF);
                            treeMap.put(Integer.valueOf(c0141c.f770c), c0140b);
                        }
                        c0141c.f772e = c0140b;
                        c0140b.f761a.add(c0141c);
                    }
                }
            }
            c0140b = null;
            for (Entry value : treeMap.entrySet()) {
                c0140b2 = (C0140b) value.getValue();
                c0140b2.f767g = c0140b;
                c0140b = c0140b2;
            }
            int i2 = (int) this.f616d;
            int width = (int) ((rectF.width() - ((float) ((treeMap.size() - 1) * i2))) / ((float) (treeMap.size() - 1)));
            int i3 = width < 0 ? 0 : width;
            int i4 = i2 > i3 ? i3 / 2 : i2;
            for (Number number : treeMap.keySet()) {
                c0140b2 = (C0140b) treeMap.get(number);
                switch (C0139a.f759a[this.f614b.ordinal()]) {
                    case 1:
                        c0140b2.f764d = c0140b2.f762b - ((int) (this.f615c / 2.0f));
                        c0140b2.f763c = (int) this.f615c;
                        c0140b2.f765e = c0140b2.f764d + c0140b2.f763c;
                        break;
                    case 2:
                        if (c0140b2.f767g != null && ((c0140b2.f762b - c0140b2.f767g.f762b) - i4) - 1 <= ((int) (((double) i3) * 1.5d))) {
                            c0140b2.f764d = (c0140b2.f767g.f765e + i4) + 1;
                            if (c0140b2.f764d > c0140b2.f762b) {
                                c0140b2.f764d = c0140b2.f762b;
                            }
                            c0140b2.f765e = c0140b2.f762b + (i3 / 2);
                            c0140b2.f763c = c0140b2.f765e - c0140b2.f764d;
                            break;
                        }
                        c0140b2.f764d = c0140b2.f762b - (i3 / 2);
                        c0140b2.f763c = i3;
                        c0140b2.f765e = c0140b2.f764d + c0140b2.f763c;
                        break;
                        break;
                }
                C0141c c0141c2;
                PointLabeler pointLabeler;
                Iterator it;
                int i5;
                BarFormatter a;
                PointLabelFormatter pointLabelFormatter;
                switch (C0139a.f760b[this.f613a.ordinal()]) {
                    case 1:
                        Collections.sort(c0140b2.f761a, new BarComparator(this));
                        Iterator it2 = c0140b2.f761a.iterator();
                        while (it2.hasNext()) {
                            c0141c2 = (C0141c) it2.next();
                            BarFormatter a2 = c0141c2.m1021a();
                            PointLabelFormatter pointLabelFormatter2 = a2.getPointLabelFormatter();
                            pointLabeler = a2 != null ? a2.getPointLabeler() : null;
                            if (c0141c2.f772e.f763c >= 2) {
                                canvas.drawRect((float) c0141c2.f772e.f764d, (float) c0141c2.f771d, (float) c0141c2.f772e.f765e, c0141c2.f772e.f766f.bottom, a2.getFillPaint());
                            }
                            canvas.drawRect((float) c0141c2.f772e.f764d, (float) c0141c2.f771d, (float) c0141c2.f772e.f765e, c0141c2.f772e.f766f.bottom, a2.getBorderPaint());
                            if (!(pointLabelFormatter2 == null || pointLabeler == null)) {
                                canvas.drawText(pointLabeler.getLabel(c0141c2.f768a, c0141c2.f769b), ((float) c0141c2.f770c) + pointLabelFormatter2.hOffset, ((float) c0141c2.f771d) + pointLabelFormatter2.vOffset, pointLabelFormatter2.getTextPaint());
                            }
                        }
                        break;
                    case 2:
                        int size = c0140b2.f763c / c0140b2.f761a.size();
                        width = c0140b2.f764d;
                        Collections.sort(c0140b2.f761a, new BarComparator(this));
                        it = c0140b2.f761a.iterator();
                        i5 = width;
                        while (it.hasNext()) {
                            c0141c2 = (C0141c) it.next();
                            a = c0141c2.m1021a();
                            pointLabelFormatter = a.getPointLabelFormatter();
                            pointLabeler = a != null ? a.getPointLabeler() : null;
                            if (c0141c2.f772e.f763c >= 2) {
                                canvas.drawRect((float) i5, (float) c0141c2.f771d, (float) (i5 + size), c0141c2.f772e.f766f.bottom, a.getFillPaint());
                            }
                            canvas.drawRect((float) i5, (float) c0141c2.f771d, (float) (i5 + size), c0141c2.f772e.f766f.bottom, a.getBorderPaint());
                            if (!(pointLabelFormatter == null || pointLabeler == null)) {
                                canvas.drawText(pointLabeler.getLabel(c0141c2.f768a, c0141c2.f769b), ((float) ((size / 2) + i5)) + pointLabelFormatter.hOffset, ((float) c0141c2.f771d) + pointLabelFormatter.vOffset, pointLabelFormatter.getTextPaint());
                            }
                            i5 += size;
                        }
                        break;
                    case 3:
                        width = (int) c0140b2.f766f.bottom;
                        Collections.sort(c0140b2.f761a, new BarComparator(this));
                        it = c0140b2.f761a.iterator();
                        int i6 = width;
                        while (it.hasNext()) {
                            c0141c2 = (C0141c) it.next();
                            a = c0141c2.m1021a();
                            pointLabelFormatter = a.getPointLabelFormatter();
                            PointLabeler pointLabeler2 = a != null ? a.getPointLabeler() : null;
                            i5 = i6 - (((int) c0141c2.f772e.f766f.bottom) - c0141c2.f771d);
                            if (c0141c2.f772e.f763c >= 2) {
                                canvas.drawRect((float) c0141c2.f772e.f764d, (float) i5, (float) c0141c2.f772e.f765e, (float) i6, a.getFillPaint());
                            }
                            canvas.drawRect((float) c0141c2.f772e.f764d, (float) i5, (float) c0141c2.f772e.f765e, (float) i6, a.getBorderPaint());
                            if (!(pointLabelFormatter == null || pointLabeler2 == null)) {
                                canvas.drawText(pointLabeler2.getLabel(c0141c2.f768a, c0141c2.f769b), ((float) c0141c2.f770c) + pointLabelFormatter.hOffset, ((float) c0141c2.f771d) + pointLabelFormatter.vOffset, pointLabelFormatter.getTextPaint());
                            }
                            i6 = i5;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void setBarGap(float f) {
        this.f616d = f;
    }

    public void setBarRenderStyle(BarRenderStyle barRenderStyle) {
        this.f613a = barRenderStyle;
    }

    public void setBarWidth(float f) {
        this.f615c = f;
    }

    public void setBarWidthStyle(BarWidthStyle barWidthStyle) {
        this.f614b = barWidthStyle;
    }

    public void setBarWidthStyle(BarWidthStyle barWidthStyle, float f) {
        setBarWidthStyle(barWidthStyle);
        switch (C0139a.f759a[barWidthStyle.ordinal()]) {
            case 1:
                setBarWidth(f);
                return;
            case 2:
                setBarGap(f);
                return;
            default:
                return;
        }
    }
}
