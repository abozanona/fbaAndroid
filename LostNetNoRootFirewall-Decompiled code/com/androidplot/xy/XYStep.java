package com.androidplot.xy;

public class XYStep {
    private final float f755a;
    private final float f756b;
    private final double f757c;

    public XYStep(float f, float f2, double d) {
        this.f755a = f;
        this.f756b = f2;
        this.f757c = d;
    }

    public double getStepCount() {
        return (double) this.f755a;
    }

    public float getStepPix() {
        return this.f756b;
    }

    public double getStepVal() {
        return this.f757c;
    }
}
