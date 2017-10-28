package com.androidplot.xy;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.androidplot.util.Configurator;

public class XYRegionFormatter {
    private Paint f754a = new Paint();

    public XYRegionFormatter(int i) {
        this.f754a.setStyle(Style.FILL);
        this.f754a.setAntiAlias(true);
        this.f754a.setColor(i);
    }

    public XYRegionFormatter(Context context, int i) {
        this.f754a.setStyle(Style.FILL);
        this.f754a.setAntiAlias(true);
        if (getClass().equals(XYRegionFormatter.class)) {
            Configurator.configure(context, (Object) this, i);
        }
    }

    public int getColor() {
        return this.f754a.getColor();
    }

    public Paint getPaint() {
        return this.f754a;
    }

    public void setColor(int i) {
        this.f754a.setColor(i);
    }
}
