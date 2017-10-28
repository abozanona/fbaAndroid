package com.androidplot.xy;

import com.androidplot.ui.SeriesAndFormatterList;
import com.androidplot.ui.SeriesRenderer;
import java.util.Hashtable;

public abstract class XYSeriesRenderer extends SeriesRenderer {
    public XYSeriesRenderer(XYPlot xYPlot) {
        super(xYPlot);
    }

    public Hashtable getUniqueRegionFormatters() {
        Hashtable hashtable = new Hashtable();
        SeriesAndFormatterList seriesAndFormatterList = getSeriesAndFormatterList();
        if (seriesAndFormatterList != null) {
            for (XYSeriesFormatter xYSeriesFormatter : seriesAndFormatterList.getFormatterList()) {
                for (RectRegion rectRegion : xYSeriesFormatter.getRegions().elements()) {
                    hashtable.put(xYSeriesFormatter.getRegionFormatter(rectRegion), rectRegion.getLabel());
                }
            }
        }
        return hashtable;
    }
}
