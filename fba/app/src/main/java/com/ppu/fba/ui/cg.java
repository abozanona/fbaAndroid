package com.ppu.fba.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.androidplot.Plot.BorderStyle;
import com.androidplot.Series;
import com.androidplot.ui.Formatter;
import com.androidplot.xy.BarFormatter;
import com.androidplot.xy.BarRenderer;
import com.androidplot.xy.BarRenderer.BarWidthStyle;
import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.SimpleXYSeries.ArrayFormat;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYStepMode;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p008c.C0296a;
import com.ppu.fba.p008c.C0298c;
import com.ppu.fba.p008c.C0299d;
import java.text.Format;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class cg {
    private int f1721a;
    protected final Context f1722b;
    protected XYPlot f1723c;
    protected ArrayList f1724d = new ArrayList();

    protected cg(Context context, View view, int i, int i2) {
        this.f1722b = context;
        this.f1721a = i2;
        this.f1723c = (XYPlot) view.findViewById(i);
        Format c0360y = new C0360y();
        this.f1723c.setDomainStep(XYStepMode.SUBDIVIDE, 13.0d);
        this.f1723c.setRangeStep(XYStepMode.SUBDIVIDE, 2.0d);
        this.f1723c.setTicksPerRangeLabel(1);
        this.f1723c.setBorderStyle(BorderStyle.NONE, null, null);
        this.f1723c.getBackgroundPaint().setColor(0);
        this.f1723c.getGraphWidget().getGridBackgroundPaint().setColor(0);
        this.f1723c.getGraphWidget().getBackgroundPaint().setColor(0);
        this.f1723c.getGraphWidget().getDomainGridLinePaint().setColor(0);
        this.f1723c.getGraphWidget().getRangeGridLinePaint().setColor(0);
        this.f1723c.getGraphWidget().getRangeOriginLabelPaint().setColor(0);
        this.f1723c.setPlotMargins(0.0f, 0.0f, 0.0f, 0.0f);
        this.f1723c.setPlotPadding(0.0f, 0.0f, 0.0f, 0.0f);
        this.f1723c.setGridPadding(0.0f, 0.0f, 0.0f, 0.0f);
        this.f1723c.setPaddingRelative(0, 0, 0, 0);
        this.f1723c.getLayoutManager().remove(this.f1723c.getLegendWidget());
        this.f1723c.getLayoutManager().remove(this.f1723c.getRangeLabelWidget());
        this.f1723c.getLayoutManager().remove(this.f1723c.getDomainLabelWidget());
        this.f1723c.getLayoutManager().remove(this.f1723c.getTitleWidget());
        this.f1723c.getGraphWidget().setDomainLabelOrientation(0.0f);
        this.f1723c.setRangeTopMin(Integer.valueOf(1));
        this.f1723c.setRangeBottomMax(Integer.valueOf(0));
        this.f1723c.setRangeValueFormat(c0360y);
        this.f1723c.setDomainValueFormat(new ch(this));
        this.f1724d.add(this.f1723c);
    }

    public abstract long mo762a(C0298c c0298c);

    public void m2104a() {
        long b = C0296a.m1929b();
        List arrayList = new ArrayList();
        C0298c[] c0298cArr = new C0298c[24];
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            int i;
            C0299d c0299d = a.f1297f;
            synchronized (c0299d) {
                for (i = 0; i < c0298cArr.length; i++) {
                    c0298cArr[i] = c0299d.m1954b(b - ((long) i));
                }
            }
            long j = 0;
            for (i = c0298cArr.length - 1; i >= 0; i--) {
                arrayList.add(Double.valueOf(Double.valueOf((double) (b - ((long) i))).doubleValue() + 0.05d));
                long a2 = mo762a(c0298cArr[i]);
                arrayList.add(Long.valueOf(a2));
                j += a2;
            }
            if (j > 0) {
                Iterator it = this.f1724d.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    view.setVisibility(0);
                    view.requestLayout();
                }
            }
        }
        Series simpleXYSeries = new SimpleXYSeries(arrayList, ArrayFormat.XY_VALS_INTERLEAVED, "Blocked");
        Formatter barFormatter = new BarFormatter(Color.argb(250, 255, 32, 0), -3355444);
        barFormatter.setPointLabeler(null);
        this.f1723c.clear();
        if (this.f1721a == 2) {
            this.f1723c.setDomainBoundaries(Long.valueOf(b - 23), Long.valueOf(1 + b), BoundaryMode.FIXED);
            this.f1723c.addSeries(simpleXYSeries, barFormatter);
        }
        BarRenderer barRenderer = (BarRenderer) this.f1723c.getRenderer(BarRenderer.class);
        barRenderer.setBarWidthStyle(BarWidthStyle.VARIABLE_WIDTH);
        barRenderer.setBarGap(4.0f);
        this.f1723c.redraw();
    }
}
