package com.androidplot.xy;

import android.graphics.RectF;
import com.androidplot.util.ValPixConverter;

public class XYStepCalculator {
    public static XYStep getStep(XYPlot xYPlot, XYAxisType xYAxisType, RectF rectF, Number number, Number number2) {
        switch (C0147i.f787a[xYAxisType.ordinal()]) {
            case 1:
                return getStep(xYPlot.getDomainStepMode(), rectF.width(), xYPlot.getDomainStepValue(), number, number2);
            case 2:
                return getStep(xYPlot.getRangeStepMode(), rectF.height(), xYPlot.getRangeStepValue(), number, number2);
            default:
                return null;
        }
    }

    public static XYStep getStep(XYStepMode xYStepMode, float f, double d, Number number, Number number2) {
        float valPerPix;
        float f2 = 0.0f;
        switch (C0147i.f788b[xYStepMode.ordinal()]) {
            case 1:
                valPerPix = (float) (d / ValPixConverter.valPerPix(number.doubleValue(), number2.doubleValue(), f));
                f2 = f / valPerPix;
                break;
            case 2:
                valPerPix = new Double(d).floatValue();
                f2 = f / valPerPix;
                d = ValPixConverter.valPerPix(number.doubleValue(), number2.doubleValue(), f) * ((double) valPerPix);
                break;
            case 3:
                f2 = new Double(d).floatValue();
                valPerPix = f / (f2 - 1.0f);
                d = ValPixConverter.valPerPix(number.doubleValue(), number2.doubleValue(), f) * ((double) valPerPix);
                break;
            default:
                d = 0.0d;
                valPerPix = 0.0f;
                break;
        }
        return new XYStep(f2, valPerPix, d);
    }
}
