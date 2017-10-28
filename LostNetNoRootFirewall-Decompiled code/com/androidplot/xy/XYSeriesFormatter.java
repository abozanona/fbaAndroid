package com.androidplot.xy;

import com.androidplot.ui.Formatter;
import com.androidplot.ui.SeriesRenderer;
import com.androidplot.util.ZHash;
import com.androidplot.util.ZIndexable;

public abstract class XYSeriesFormatter extends Formatter {
    private ZHash f601a = new ZHash();

    public void addRegion(RectRegion rectRegion, XYRegionFormatter xYRegionFormatter) {
        this.f601a.addToBottom(rectRegion, xYRegionFormatter);
    }

    public XYRegionFormatter getRegionFormatter(RectRegion rectRegion) {
        return (XYRegionFormatter) this.f601a.get(rectRegion);
    }

    public ZIndexable getRegions() {
        return this.f601a;
    }

    public abstract SeriesRenderer getRendererInstance(XYPlot xYPlot);

    public void removeRegion(RectRegion rectRegion) {
        this.f601a.remove(rectRegion);
    }
}
