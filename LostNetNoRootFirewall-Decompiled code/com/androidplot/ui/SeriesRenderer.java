package com.androidplot.ui;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region.Op;
import com.androidplot.Plot;
import com.androidplot.Series;

public abstract class SeriesRenderer {
    private Plot f473a;

    public SeriesRenderer(Plot plot) {
        this.f473a = plot;
    }

    protected abstract void doDrawLegendIcon(Canvas canvas, RectF rectF, Formatter formatter);

    public void drawSeriesLegendIcon(Canvas canvas, RectF rectF, Formatter formatter) {
        try {
            canvas.save(31);
            canvas.clipRect(rectF, Op.INTERSECT);
            doDrawLegendIcon(canvas, rectF, formatter);
        } finally {
            canvas.restore();
        }
    }

    public Formatter getFormatter(Series series) {
        return this.f473a.getFormatter(series, getClass());
    }

    public Plot getPlot() {
        return this.f473a;
    }

    public SeriesAndFormatterList getSeriesAndFormatterList() {
        return this.f473a.getSeriesAndFormatterListForRenderer(getClass());
    }

    public abstract void onRender(Canvas canvas, RectF rectF);

    public void render(Canvas canvas, RectF rectF) {
        onRender(canvas, rectF);
    }

    public void setPlot(Plot plot) {
        this.f473a = plot;
    }
}
