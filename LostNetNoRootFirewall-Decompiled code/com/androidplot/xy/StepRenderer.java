package com.androidplot.xy;

import android.graphics.Path;
import android.graphics.PointF;

public class StepRenderer extends LineAndPointRenderer {
    public StepRenderer(XYPlot xYPlot) {
        super(xYPlot);
    }

    protected final void mo200a(Path path, PointF pointF, PointF pointF2) {
        path.lineTo(pointF.x, pointF2.y);
        path.lineTo(pointF.x, pointF.y);
    }
}
