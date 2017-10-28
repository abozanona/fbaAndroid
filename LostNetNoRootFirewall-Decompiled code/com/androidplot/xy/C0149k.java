package com.androidplot.xy;

final class C0149k implements PointLabeler {
    C0149k(LineAndPointFormatter lineAndPointFormatter) {
    }

    public final String getLabel(XYSeries xYSeries, int i) {
        return xYSeries.getY(i) + "";
    }
}
