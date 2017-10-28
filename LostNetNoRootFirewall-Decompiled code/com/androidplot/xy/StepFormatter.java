package com.androidplot.xy;

import com.androidplot.ui.SeriesRenderer;

public class StepFormatter extends LineAndPointFormatter {
    public StepFormatter(Integer num, Integer num2) {
        m981a(num);
        m982b(num2);
    }

    public Class getRendererClass() {
        return StepRenderer.class;
    }

    public SeriesRenderer getRendererInstance(XYPlot xYPlot) {
        return new StepRenderer(xYPlot);
    }
}
