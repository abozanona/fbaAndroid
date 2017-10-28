package com.androidplot.xy;

import android.graphics.Paint;
import com.androidplot.ui.PositionMetric;
import com.androidplot.ui.YLayoutStyle;
import com.androidplot.ui.YPositionMetric;

public class XValueMarker extends ValueMarker {
    public XValueMarker(Number number, String str) {
        super(number, str, new YPositionMetric(3.0f, YLayoutStyle.ABSOLUTE_FROM_TOP));
    }

    public XValueMarker(Number number, String str, YPositionMetric yPositionMetric, int i, int i2) {
        super(number, str, (PositionMetric) yPositionMetric, i, i2);
    }

    public XValueMarker(Number number, String str, YPositionMetric yPositionMetric, Paint paint, Paint paint2) {
        super(number, str, (PositionMetric) yPositionMetric, paint, paint2);
    }
}
