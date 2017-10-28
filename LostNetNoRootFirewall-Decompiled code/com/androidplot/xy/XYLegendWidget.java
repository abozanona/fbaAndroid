package com.androidplot.xy;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.androidplot.ui.LayoutManager;
import com.androidplot.ui.SeriesAndFormatterList;
import com.androidplot.ui.SizeMetrics;
import com.androidplot.ui.TableModel;
import com.androidplot.ui.widget.Widget;
import com.androidplot.util.FontUtils;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeSet;

public class XYLegendWidget extends Widget {
    private XYPlot f682a;
    private Paint f683b = new Paint();
    private Paint f684c;
    private TableModel f685d;
    private boolean f686e = true;
    private boolean f687f = true;
    private SizeMetrics f688g;

    static {
        C0148j c0148j = new C0148j();
    }

    public XYLegendWidget(LayoutManager layoutManager, XYPlot xYPlot, SizeMetrics sizeMetrics, TableModel tableModel, SizeMetrics sizeMetrics2) {
        super(layoutManager, sizeMetrics);
        this.f683b.setColor(-3355444);
        this.f683b.setAntiAlias(true);
        this.f684c = new Paint();
        this.f684c.setStyle(Style.STROKE);
        this.f682a = xYPlot;
        setTableModel(tableModel);
        this.f688g = sizeMetrics2;
    }

    private RectF m995a(RectF rectF) {
        float height = rectF.top + (rectF.height() / 2.0f);
        RectF rectF2 = this.f688g.getRectF(rectF);
        rectF2.offsetTo(rectF.left + 1.0f, height - (rectF2.height() / 2.0f));
        return rectF2;
    }

    private void m996a(Canvas canvas, RectF rectF) {
        Paint gridBackgroundPaint = this.f682a.getGraphWidget().getGridBackgroundPaint();
        if (this.f686e && gridBackgroundPaint != null) {
            canvas.drawRect(rectF, gridBackgroundPaint);
        }
    }

    private void m997a(Canvas canvas, RectF rectF, RectF rectF2, String str) {
        Paint gridBackgroundPaint = this.f682a.getGraphWidget().getGridBackgroundPaint();
        if (this.f687f && gridBackgroundPaint != null) {
            this.f684c.setColor(gridBackgroundPaint.getColor());
            canvas.drawRect(rectF2, this.f684c);
        }
        canvas.drawText(str, rectF2.right + 2.0f, (rectF.top + (rectF.height() / 2.0f)) + (FontUtils.getFontHeight(this.f683b) / 2.0f), this.f683b);
    }

    protected synchronized void doOnDraw(Canvas canvas, RectF rectF) {
        if (!this.f682a.isEmpty()) {
            TreeSet treeSet = new TreeSet(new C0148j());
            int i = 0;
            for (XYSeriesRenderer xYSeriesRenderer : this.f682a.getRendererList()) {
                SeriesAndFormatterList seriesAndFormatterListForRenderer = this.f682a.getSeriesAndFormatterListForRenderer(xYSeriesRenderer.getClass());
                if (seriesAndFormatterListForRenderer != null) {
                    i += seriesAndFormatterListForRenderer.size();
                }
                treeSet.addAll(xYSeriesRenderer.getUniqueRegionFormatters().entrySet());
            }
            Iterator iterator = this.f685d.getIterator(rectF, treeSet.size() + i);
            for (XYSeriesRenderer xYSeriesRenderer2 : this.f682a.getRendererList()) {
                SeriesAndFormatterList seriesAndFormatterListForRenderer2 = this.f682a.getSeriesAndFormatterListForRenderer(xYSeriesRenderer2.getClass());
                if (seriesAndFormatterListForRenderer2 != null) {
                    for (int i2 = 0; i2 < seriesAndFormatterListForRenderer2.size() && iterator.hasNext(); i2++) {
                        RectF rectF2 = (RectF) iterator.next();
                        XYSeriesFormatter xYSeriesFormatter = (XYSeriesFormatter) seriesAndFormatterListForRenderer2.getFormatter(i2);
                        String title = ((XYSeries) seriesAndFormatterListForRenderer2.getSeries(i2)).getTitle();
                        RectF a = m995a(rectF2);
                        m996a(canvas, a);
                        xYSeriesRenderer2.drawSeriesLegendIcon(canvas, a, xYSeriesFormatter);
                        m997a(canvas, rectF2, a, title);
                    }
                }
            }
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (!iterator.hasNext()) {
                    break;
                }
                RectF rectF3 = (RectF) iterator.next();
                XYRegionFormatter xYRegionFormatter = (XYRegionFormatter) entry.getKey();
                String str = (String) entry.getValue();
                RectF a2 = m995a(rectF3);
                m996a(canvas, a2);
                canvas.drawRect(a2, xYRegionFormatter.getPaint());
                m997a(canvas, rectF3, a2, str);
            }
        }
    }

    public SizeMetrics getIconSizeMetrics() {
        return this.f688g;
    }

    public TableModel getTableModel() {
        return this.f685d;
    }

    public Paint getTextPaint() {
        return this.f683b;
    }

    public boolean isDrawIconBackgroundEnabled() {
        return this.f686e;
    }

    public boolean isDrawIconBorderEnabled() {
        return this.f687f;
    }

    public void setDrawIconBackgroundEnabled(boolean z) {
        this.f686e = z;
    }

    public void setDrawIconBorderEnabled(boolean z) {
        this.f687f = z;
    }

    public void setIconSizeMetrics(SizeMetrics sizeMetrics) {
        this.f688g = sizeMetrics;
    }

    public synchronized void setTableModel(TableModel tableModel) {
        this.f685d = tableModel;
    }

    public void setTextPaint(Paint paint) {
        this.f683b = paint;
    }
}
