package com.androidplot.xy;

import com.androidplot.ui.SeriesRenderer;

public class BezierLineAndPointFormatter extends LineAndPointFormatter {
    public BezierLineAndPointFormatter(Integer num, Integer num2, Integer num3) {
        super(num, num2, num3, null);
    }

    public BezierLineAndPointFormatter(Integer num, Integer num2, Integer num3, FillDirection fillDirection) {
        super(num, num2, num3, null, fillDirection);
    }

    public Class getRendererClass() {
        return BezierLineAndPointRenderer.class;
    }

    public SeriesRenderer getRendererInstance(XYPlot xYPlot) {
        return new BezierLineAndPointRenderer(xYPlot);
    }
}
