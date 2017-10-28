package com.androidplot.pie;

import android.content.Context;
import android.util.AttributeSet;
import com.androidplot.Plot;
import com.androidplot.Plot.RenderMode;
import com.androidplot.ui.AnchorPosition;
import com.androidplot.ui.SizeLayoutType;
import com.androidplot.ui.SizeMetrics;
import com.androidplot.ui.XLayoutStyle;
import com.androidplot.ui.YLayoutStyle;
import com.androidplot.util.PixelUtils;

public class PieChart extends Plot {
    private PieWidget f471a;

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PieChart(Context context, String str) {
        super(context, str);
    }

    public PieChart(Context context, String str, RenderMode renderMode) {
        super(context, str, renderMode);
    }

    protected final void mo152a() {
        this.f471a = new PieWidget(getLayoutManager(), this, new SizeMetrics(PixelUtils.dpToPix(18.0f), SizeLayoutType.FILL, PixelUtils.dpToPix(10.0f), SizeLayoutType.FILL));
        this.f471a.position(PixelUtils.dpToPix(0.0f), XLayoutStyle.ABSOLUTE_FROM_CENTER, PixelUtils.dpToPix(0.0f), YLayoutStyle.ABSOLUTE_FROM_CENTER, AnchorPosition.CENTER);
        this.f471a.setPadding(10.0f, 10.0f, 10.0f, 10.0f);
    }

    public void addSegment(Segment segment, SegmentFormatter segmentFormatter) {
        addSeries(segment, segmentFormatter);
    }

    public PieWidget getPieWidget() {
        return this.f471a;
    }

    public void removeSegment(Segment segment) {
        removeSeries(segment);
    }

    public void setPieWidget(PieWidget pieWidget) {
        this.f471a = pieWidget;
    }
}
