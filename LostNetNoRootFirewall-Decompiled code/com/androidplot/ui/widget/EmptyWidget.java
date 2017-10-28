package com.androidplot.ui.widget;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.androidplot.ui.LayoutManager;
import com.androidplot.ui.SizeMetrics;

public class EmptyWidget extends Widget {
    public EmptyWidget(LayoutManager layoutManager, SizeMetrics sizeMetrics) {
        super(layoutManager, sizeMetrics);
    }

    protected void doOnDraw(Canvas canvas, RectF rectF) {
    }
}
