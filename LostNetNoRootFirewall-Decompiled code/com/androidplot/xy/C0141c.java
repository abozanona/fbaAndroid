package com.androidplot.xy;

import android.graphics.RectF;
import com.androidplot.util.ValPixConverter;

final class C0141c {
    public XYSeries f768a;
    public int f769b;
    public int f770c = ((int) this.f775h);
    public int f771d;
    public C0140b f772e;
    private double f773f;
    private double f774g;
    private float f775h;
    private float f776i;
    private /* synthetic */ BarRenderer f777j;

    public C0141c(BarRenderer barRenderer, XYSeries xYSeries, int i, RectF rectF) {
        this.f777j = barRenderer;
        this.f768a = xYSeries;
        this.f769b = i;
        this.f774g = xYSeries.getX(i).doubleValue();
        this.f775h = ValPixConverter.valToPix(this.f774g, ((XYPlot) barRenderer.getPlot()).getCalculatedMinX().doubleValue(), ((XYPlot) barRenderer.getPlot()).getCalculatedMaxX().doubleValue(), rectF.width(), false) + rectF.left;
        if (xYSeries.getY(i) != null) {
            this.f773f = xYSeries.getY(i).doubleValue();
            this.f776i = ValPixConverter.valToPix(this.f773f, ((XYPlot) barRenderer.getPlot()).getCalculatedMinY().doubleValue(), ((XYPlot) barRenderer.getPlot()).getCalculatedMaxY().doubleValue(), rectF.height(), true) + rectF.top;
            this.f771d = (int) this.f776i;
            return;
        }
        this.f773f = 0.0d;
        this.f776i = rectF.bottom;
        this.f771d = (int) this.f776i;
    }

    public final BarFormatter m1021a() {
        return (BarFormatter) this.f777j.getFormatter(this.f768a);
    }
}
