package com.androidplot.ui;

public class PositionMetrics implements Comparable {
    private XPositionMetric f527a;
    private YPositionMetric f528b;
    private AnchorPosition f529c;

    public PositionMetrics(float f, XLayoutStyle xLayoutStyle, float f2, YLayoutStyle yLayoutStyle, AnchorPosition anchorPosition) {
        setXPositionMetric(new XPositionMetric(f, xLayoutStyle));
        setYPositionMetric(new YPositionMetric(f2, yLayoutStyle));
        setAnchor(anchorPosition);
    }

    public int compareTo(PositionMetrics positionMetrics) {
        return 0;
    }

    public AnchorPosition getAnchor() {
        return this.f529c;
    }

    public XPositionMetric getXPositionMetric() {
        return this.f527a;
    }

    public YPositionMetric getYPositionMetric() {
        return this.f528b;
    }

    public void setAnchor(AnchorPosition anchorPosition) {
        this.f529c = anchorPosition;
    }

    public void setXPositionMetric(XPositionMetric xPositionMetric) {
        this.f527a = xPositionMetric;
    }

    public void setYPositionMetric(YPositionMetric yPositionMetric) {
        this.f528b = yPositionMetric;
    }
}
