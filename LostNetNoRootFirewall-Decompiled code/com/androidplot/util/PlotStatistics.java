package com.androidplot.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import com.androidplot.Plot;
import com.androidplot.PlotListener;

public class PlotStatistics implements PlotListener {
    private long f580a;
    private long f581b = 0;
    private long f582c = 0;
    private long f583d = 0;
    private long f584e = 0;
    private long f585f;
    private long f586g = 0;
    private long f587h = 0;
    private String f588i = "";
    private Paint f589j = new Paint();
    private boolean f590k;

    public PlotStatistics(long j, boolean z) {
        this.f589j.setTextAlign(Align.CENTER);
        this.f589j.setColor(-1);
        this.f589j.setTextSize(30.0f);
        m980a();
        this.f580a = j;
        this.f590k = z;
    }

    private void m980a() {
        this.f581b = 0;
        this.f582c = 999999999;
        this.f586g = 0;
        this.f587h = 0;
    }

    public void onAfterDraw(Plot plot, Canvas canvas) {
        this.f584e = System.currentTimeMillis() - this.f583d;
        if (this.f584e < this.f582c) {
            this.f582c = this.f584e;
        }
        if (this.f584e > this.f581b) {
            this.f581b = this.f584e;
        }
        this.f587h += this.f584e;
        this.f586g++;
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f585f;
        if (j >= this.f580a) {
            float f = this.f586g > 0 ? (float) (this.f587h / this.f586g) : 0.0f;
            String str = "%.2f";
            Object[] objArr = new Object[1];
            objArr[0] = Float.valueOf(this.f586g > 0 ? (1000.0f / ((float) j)) * ((float) this.f586g) : 0.0f);
            String format = String.format(str, objArr);
            String str2 = "%.2f";
            Object[] objArr2 = new Object[1];
            objArr2[0] = Float.valueOf(this.f586g > 0 ? 1000.0f / f : 0.0f);
            this.f588i = "FPS (potential): " + String.format(str2, objArr2) + " FPS (actual): " + format + " Latency (ms) Avg: " + this.f584e + " \nMin: " + this.f582c + " Max: " + this.f581b;
            this.f585f = currentTimeMillis;
            m980a();
        }
        RectF rectF = plot.getDisplayDimensions().canvasRect;
        if (this.f590k) {
            canvas.drawText(this.f588i, rectF.centerX(), rectF.centerY(), this.f589j);
        }
    }

    public void onBeforeDraw(Plot plot, Canvas canvas) {
        this.f583d = System.currentTimeMillis();
    }

    public void setAnnotatePlotEnabled(boolean z) {
        this.f590k = z;
    }
}
