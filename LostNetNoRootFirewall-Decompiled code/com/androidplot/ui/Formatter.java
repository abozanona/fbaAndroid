package com.androidplot.ui;

import android.content.Context;
import com.androidplot.Plot;
import com.androidplot.util.Configurator;

public abstract class Formatter {
    public Formatter configure(Context context, int i) {
        Configurator.configure(context, (Object) this, i);
        return this;
    }

    public abstract Class getRendererClass();

    public abstract SeriesRenderer getRendererInstance(Plot plot);
}
