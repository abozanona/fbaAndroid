package com.androidplot.ui;

import com.androidplot.Series;
import com.androidplot.xy.XYSeriesFormatter;

public abstract class RenderBundle {
    private Series f530a;
    private XYSeriesFormatter f531b;

    public RenderBundle(Series series, XYSeriesFormatter xYSeriesFormatter) {
        this.f531b = xYSeriesFormatter;
        this.f530a = series;
    }

    public XYSeriesFormatter getFormatter() {
        return this.f531b;
    }

    public Series getSeries() {
        return this.f530a;
    }

    public void setFormatter(XYSeriesFormatter xYSeriesFormatter) {
        this.f531b = xYSeriesFormatter;
    }

    public void setSeries(Series series) {
        this.f530a = series;
    }
}
