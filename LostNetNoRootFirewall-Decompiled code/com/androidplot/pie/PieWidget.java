package com.androidplot.pie;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.androidplot.ui.LayoutManager;
import com.androidplot.ui.SizeMetrics;
import com.androidplot.ui.widget.Widget;

public class PieWidget extends Widget {
    private PieChart f487a;

    public PieWidget(LayoutManager layoutManager, PieChart pieChart, SizeMetrics sizeMetrics) {
        super(layoutManager, sizeMetrics);
        this.f487a = pieChart;
    }

    protected void doOnDraw(Canvas canvas, RectF rectF) {
        for (PieRenderer render : this.f487a.getRendererList()) {
            render.render(canvas, rectF);
        }
    }
}
