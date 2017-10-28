package com.androidplot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.androidplot.ui.AnchorPosition;
import com.androidplot.ui.BoxModel;
import com.androidplot.ui.Formatter;
import com.androidplot.ui.LayoutManager;
import com.androidplot.ui.Resizable;
import com.androidplot.ui.SeriesAndFormatterList;
import com.androidplot.ui.SeriesRenderer;
import com.androidplot.ui.SizeLayoutType;
import com.androidplot.ui.SizeMetrics;
import com.androidplot.ui.TextOrientationType;
import com.androidplot.ui.XLayoutStyle;
import com.androidplot.ui.YLayoutStyle;
import com.androidplot.ui.widget.TextLabelWidget;
import com.androidplot.util.Configurator;
import com.androidplot.util.DisplayDimensions;
import com.androidplot.util.PixelUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class Plot extends View implements Resizable {
    private static final String f450a = Plot.class.getName();
    private BoxModel f451b;
    private BorderStyle f452c;
    private float f453d;
    private float f454e;
    private Paint f455f;
    private Paint f456g;
    private LayoutManager f457h;
    private TextLabelWidget f458i;
    private DisplayDimensions f459j;
    private RenderMode f460k;
    private final BufferedCanvas f461l;
    private final Object f462m;
    private LinkedList f463n;
    private LinkedHashMap f464o;
    private final ArrayList f465p;
    private Thread f466q;
    private boolean f467r;
    private boolean f468s;

    public enum BorderStyle {
        ROUNDED,
        SQUARE,
        NONE
    }

    public class BufferedCanvas {
        volatile Bitmap f446a;
        private volatile Bitmap f447b;
        private Canvas f448c;

        private BufferedCanvas(Plot plot, byte b) {
            this.f448c = new Canvas();
        }

        public final Bitmap getBitmap() {
            return this.f446a;
        }

        public final synchronized Canvas getCanvas() {
            Canvas canvas;
            if (this.f447b != null) {
                this.f448c.setBitmap(this.f447b);
                canvas = this.f448c;
            } else {
                canvas = null;
            }
            return canvas;
        }

        public final synchronized void resize(int i, int i2) {
            if (i2 <= 0 || i <= 0) {
                this.f447b = null;
                this.f446a = null;
            } else {
                this.f447b = Bitmap.createBitmap(i2, i, Config.ARGB_4444);
                this.f446a = Bitmap.createBitmap(i2, i, Config.ARGB_4444);
            }
        }

        public final synchronized void swap() {
            Bitmap bitmap = this.f447b;
            this.f447b = this.f446a;
            this.f446a = bitmap;
        }
    }

    public enum RenderMode {
        USE_BACKGROUND_THREAD,
        USE_MAIN_THREAD
    }

    public Plot(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f451b = new BoxModel(3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f);
        this.f452c = BorderStyle.SQUARE;
        this.f453d = 15.0f;
        this.f454e = 15.0f;
        this.f459j = new DisplayDimensions();
        this.f460k = RenderMode.USE_MAIN_THREAD;
        this.f461l = new BufferedCanvas();
        this.f462m = new Object();
        this.f467r = false;
        this.f468s = true;
        this.f465p = new ArrayList();
        this.f464o = new LinkedHashMap();
        this.f463n = new LinkedList();
        this.f455f = new Paint();
        this.f455f.setColor(Color.rgb(150, 150, 150));
        this.f455f.setStyle(Style.STROKE);
        this.f455f.setStrokeWidth(1.0f);
        this.f455f.setAntiAlias(true);
        this.f456g = new Paint();
        this.f456g.setColor(-12303292);
        this.f456g.setStyle(Style.FILL);
        m944a(context, attributeSet);
    }

    public Plot(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f451b = new BoxModel(3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f);
        this.f452c = BorderStyle.SQUARE;
        this.f453d = 15.0f;
        this.f454e = 15.0f;
        this.f459j = new DisplayDimensions();
        this.f460k = RenderMode.USE_MAIN_THREAD;
        this.f461l = new BufferedCanvas();
        this.f462m = new Object();
        this.f467r = false;
        this.f468s = true;
        this.f465p = new ArrayList();
        this.f464o = new LinkedHashMap();
        this.f463n = new LinkedList();
        this.f455f = new Paint();
        this.f455f.setColor(Color.rgb(150, 150, 150));
        this.f455f.setStyle(Style.STROKE);
        this.f455f.setStrokeWidth(1.0f);
        this.f455f.setAntiAlias(true);
        this.f456g = new Paint();
        this.f456g.setColor(-12303292);
        this.f456g.setStyle(Style.FILL);
        m944a(context, attributeSet);
    }

    public Plot(Context context, String str) {
        this(context, str, RenderMode.USE_MAIN_THREAD);
    }

    public Plot(Context context, String str, RenderMode renderMode) {
        super(context);
        this.f451b = new BoxModel(3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f);
        this.f452c = BorderStyle.SQUARE;
        this.f453d = 15.0f;
        this.f454e = 15.0f;
        this.f459j = new DisplayDimensions();
        this.f460k = RenderMode.USE_MAIN_THREAD;
        this.f461l = new BufferedCanvas();
        this.f462m = new Object();
        this.f467r = false;
        this.f468s = true;
        this.f465p = new ArrayList();
        this.f464o = new LinkedHashMap();
        this.f463n = new LinkedList();
        this.f455f = new Paint();
        this.f455f.setColor(Color.rgb(150, 150, 150));
        this.f455f.setStyle(Style.STROKE);
        this.f455f.setStrokeWidth(1.0f);
        this.f455f.setAntiAlias(true);
        this.f456g = new Paint();
        this.f456g.setColor(-12303292);
        this.f456g.setStyle(Style.FILL);
        this.f460k = renderMode;
        m944a(null, null);
        setTitle(str);
    }

    private void m944a(Context context, AttributeSet attributeSet) {
        PixelUtils.init(getContext());
        this.f457h = new LayoutManager();
        this.f458i = new TextLabelWidget(this.f457h, new SizeMetrics(25.0f, SizeLayoutType.ABSOLUTE, 100.0f, SizeLayoutType.ABSOLUTE), TextOrientationType.HORIZONTAL);
        this.f458i.position(0.0f, XLayoutStyle.RELATIVE_TO_CENTER, 0.0f, YLayoutStyle.ABSOLUTE_FROM_TOP, AnchorPosition.TOP_MIDDLE);
        mo152a();
        this.f457h.moveToTop(this.f458i);
        if (!(context == null || attributeSet == null || attributeSet == null)) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < attributeSet.getAttributeCount(); i++) {
                String attributeName = attributeSet.getAttributeName(i);
                if (attributeName.toUpperCase().startsWith("androidplot".toUpperCase())) {
                    hashMap.put(attributeName.substring("androidplot".length() + 1), attributeSet.getAttributeValue(i));
                }
            }
            Configurator.configure(getContext(), (Object) this, hashMap);
        }
        this.f457h.onPostInit();
        Log.d(f450a, "AndroidPlot RenderMode: " + this.f460k);
        if (this.f460k == RenderMode.USE_BACKGROUND_THREAD) {
            this.f466q = new Thread(new C0124a(this));
        }
    }

    private void m948b(Canvas canvas) {
        Iterator it = this.f465p.iterator();
        while (it.hasNext()) {
            ((PlotListener) it.next()).onAfterDraw(this, canvas);
        }
    }

    protected abstract void mo152a();

    protected final synchronized void m952a(Canvas canvas) {
        try {
            RectF rectF;
            notifyListenersBeforeDraw(canvas);
            canvas.drawColor(0, Mode.CLEAR);
            if (this.f456g != null) {
                rectF = this.f459j.marginatedRect;
                switch (this.f452c) {
                    case ROUNDED:
                        canvas.drawRoundRect(rectF, this.f453d, this.f454e, this.f456g);
                        break;
                    case SQUARE:
                        canvas.drawRect(rectF, this.f456g);
                        break;
                }
            }
            this.f457h.draw(canvas);
            if (getBorderPaint() != null) {
                rectF = this.f459j.marginatedRect;
                switch (this.f452c) {
                    case ROUNDED:
                        canvas.drawRoundRect(rectF, this.f453d, this.f454e, this.f455f);
                        break;
                    case SQUARE:
                        canvas.drawRect(rectF, this.f455f);
                        break;
                }
            }
        } catch (Throwable e) {
            Log.e(f450a, "Exception while rendering Plot.", e);
            e.printStackTrace();
        } catch (Throwable e2) {
            Log.e(f450a, "Exception while rendering Plot.", e2);
        } catch (Throwable th) {
            this.f468s = true;
            m948b(canvas);
        }
        this.f468s = true;
        m948b(canvas);
    }

    public synchronized boolean addListener(PlotListener plotListener) {
        boolean z;
        z = !this.f465p.contains(plotListener) && this.f465p.add(plotListener);
        return z;
    }

    public synchronized boolean addSeries(Series series, Formatter formatter) {
        boolean z;
        SeriesAndFormatterList seriesAndFormatterList;
        Class rendererClass = formatter.getRendererClass();
        SeriesAndFormatterList seriesAndFormatterList2 = (SeriesAndFormatterList) this.f464o.get(rendererClass);
        if (seriesAndFormatterList2 == null) {
            if (getRenderer(rendererClass) == null) {
                this.f463n.add(formatter.getRendererInstance(this));
            }
            seriesAndFormatterList2 = new SeriesAndFormatterList();
            this.f464o.put(rendererClass, seriesAndFormatterList2);
            seriesAndFormatterList = seriesAndFormatterList2;
        } else {
            seriesAndFormatterList = seriesAndFormatterList2;
        }
        if (series instanceof PlotListener) {
            addListener((PlotListener) series);
        }
        if (seriesAndFormatterList.contains(series)) {
            z = false;
        } else {
            seriesAndFormatterList.add(series, formatter);
            z = true;
        }
        return z;
    }

    public void clear() {
        Iterator it = this.f464o.values().iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public Paint getBackgroundPaint() {
        return this.f456g;
    }

    public Paint getBorderPaint() {
        return this.f455f;
    }

    public DisplayDimensions getDisplayDimensions() {
        return this.f459j;
    }

    public Formatter getFormatter(Series series, Class cls) {
        return (Formatter) ((SeriesAndFormatterList) this.f464o.get(cls)).getFormatter(series);
    }

    public LayoutManager getLayoutManager() {
        return this.f457h;
    }

    public float getPlotMarginBottom() {
        return this.f451b.getMarginBottom();
    }

    public float getPlotMarginLeft() {
        return this.f451b.getMarginLeft();
    }

    public float getPlotMarginRight() {
        return this.f451b.getMarginRight();
    }

    public float getPlotMarginTop() {
        return this.f451b.getMarginTop();
    }

    public float getPlotPaddingBottom() {
        return this.f451b.getPaddingBottom();
    }

    public float getPlotPaddingLeft() {
        return this.f451b.getPaddingLeft();
    }

    public float getPlotPaddingRight() {
        return this.f451b.getPaddingRight();
    }

    public float getPlotPaddingTop() {
        return this.f451b.getPaddingTop();
    }

    public RenderMode getRenderMode() {
        return this.f460k;
    }

    public SeriesRenderer getRenderer(Class cls) {
        Iterator it = this.f463n.iterator();
        while (it.hasNext()) {
            SeriesRenderer seriesRenderer = (SeriesRenderer) it.next();
            if (seriesRenderer.getClass() == cls) {
                return seriesRenderer;
            }
        }
        return null;
    }

    public List getRendererList() {
        return this.f463n;
    }

    public SeriesAndFormatterList getSeriesAndFormatterListForRenderer(Class cls) {
        return (SeriesAndFormatterList) this.f464o.get(cls);
    }

    public List getSeriesListForRenderer(Class cls) {
        SeriesAndFormatterList seriesAndFormatterList = (SeriesAndFormatterList) this.f464o.get(cls);
        return seriesAndFormatterList == null ? null : seriesAndFormatterList.getSeriesList();
    }

    public Set getSeriesSet() {
        Set linkedHashSet = new LinkedHashSet();
        for (SeriesRenderer seriesRenderer : getRendererList()) {
            List<Series> seriesListForRenderer = getSeriesListForRenderer(seriesRenderer.getClass());
            if (seriesListForRenderer != null) {
                for (Series add : seriesListForRenderer) {
                    linkedHashSet.add(add);
                }
            }
        }
        return linkedHashSet;
    }

    public String getTitle() {
        return getTitleWidget().getText();
    }

    public TextLabelWidget getTitleWidget() {
        return this.f458i;
    }

    public boolean isEmpty() {
        return this.f464o.isEmpty();
    }

    public synchronized void layout(DisplayDimensions displayDimensions) {
        this.f459j = displayDimensions;
        this.f457h.layout(this.f459j);
    }

    public void notifyListenersBeforeDraw(Canvas canvas) {
        Iterator it = this.f465p.iterator();
        while (it.hasNext()) {
            ((PlotListener) it.next()).onBeforeDraw(this, canvas);
        }
    }

    protected void onDetachedFromWindow() {
        synchronized (this.f462m) {
            this.f467r = false;
            this.f462m.notify();
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.f460k == RenderMode.USE_BACKGROUND_THREAD) {
            synchronized (this.f461l) {
                Bitmap bitmap = this.f461l.f446a;
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, null);
                }
            }
        } else if (this.f460k == RenderMode.USE_MAIN_THREAD) {
            m952a(canvas);
        } else {
            throw new IllegalArgumentException("Unsupported Render Mode: " + this.f460k);
        }
    }

    protected synchronized void onSizeChanged(int i, int i2, int i3, int i4) {
        PixelUtils.init(getContext());
        if (VERSION.SDK_INT >= 11 && isHardwareAccelerated()) {
            setLayerType(1, null);
        }
        if (this.f460k == RenderMode.USE_BACKGROUND_THREAD) {
            this.f461l.resize(i2, i);
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) i, (float) i2);
        RectF marginatedRect = this.f451b.getMarginatedRect(rectF);
        layout(new DisplayDimensions(rectF, marginatedRect, this.f451b.getPaddedRect(marginatedRect)));
        super.onSizeChanged(i, i2, i3, i4);
        if (!(this.f466q == null || this.f466q.isAlive())) {
            this.f466q.start();
        }
    }

    public void redraw() {
        if (this.f460k == RenderMode.USE_BACKGROUND_THREAD) {
            if (this.f468s) {
                synchronized (this.f462m) {
                    this.f462m.notify();
                }
            }
        } else if (this.f460k != RenderMode.USE_MAIN_THREAD) {
            throw new IllegalArgumentException("Unsupported Render Mode: " + this.f460k);
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    public synchronized boolean removeListener(PlotListener plotListener) {
        return this.f465p.remove(plotListener);
    }

    public synchronized void removeSeries(Series series) {
        for (Class cls : this.f464o.keySet()) {
            ((SeriesAndFormatterList) this.f464o.get(cls)).remove(series);
        }
        Iterator it = this.f464o.values().iterator();
        while (it.hasNext()) {
            if (((SeriesAndFormatterList) it.next()).size() <= 0) {
                it.remove();
            }
        }
        if (series instanceof PlotListener) {
            removeListener((PlotListener) series);
        }
    }

    public synchronized boolean removeSeries(Series series, Class cls) {
        boolean remove;
        remove = ((SeriesAndFormatterList) this.f464o.get(cls)).remove(series);
        if (((SeriesAndFormatterList) this.f464o.get(cls)).size() <= 0) {
            this.f464o.remove(cls);
        }
        if (series instanceof PlotListener) {
            removeListener((PlotListener) series);
        }
        return remove;
    }

    public void setBackgroundPaint(Paint paint) {
        this.f456g = paint;
    }

    public void setBorderPaint(Paint paint) {
        if (paint == null) {
            this.f455f = null;
            return;
        }
        this.f455f = new Paint(paint);
        this.f455f.setStyle(Style.STROKE);
    }

    public void setBorderStyle(BorderStyle borderStyle, Float f, Float f2) {
        if (borderStyle == BorderStyle.ROUNDED) {
            if (f == null || f2 == null) {
                throw new IllegalArgumentException("radiusX and radiusY cannot be null when using BorderStyle.ROUNDED");
            }
            this.f453d = f.floatValue();
            this.f454e = f2.floatValue();
        }
        this.f452c = borderStyle;
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        this.f457h = layoutManager;
    }

    public void setMarkupEnabled(boolean z) {
        this.f457h.setMarkupEnabled(z);
    }

    public void setPlotMarginBottom(float f) {
        this.f451b.setMarginBottom(f);
    }

    public void setPlotMarginLeft(float f) {
        this.f451b.setMarginLeft(f);
    }

    public void setPlotMarginRight(float f) {
        this.f451b.setMarginRight(f);
    }

    public void setPlotMarginTop(float f) {
        this.f451b.setMarginTop(f);
    }

    public void setPlotMargins(float f, float f2, float f3, float f4) {
        setPlotMarginLeft(f);
        setPlotMarginTop(f2);
        setPlotMarginRight(f3);
        setPlotMarginBottom(f4);
    }

    public void setPlotPadding(float f, float f2, float f3, float f4) {
        setPlotPaddingLeft(f);
        setPlotPaddingTop(f2);
        setPlotPaddingRight(f3);
        setPlotPaddingBottom(f4);
    }

    public void setPlotPaddingBottom(float f) {
        this.f451b.setPaddingBottom(f);
    }

    public void setPlotPaddingLeft(float f) {
        this.f451b.setPaddingLeft(f);
    }

    public void setPlotPaddingRight(float f) {
        this.f451b.setPaddingRight(f);
    }

    public void setPlotPaddingTop(float f) {
        this.f451b.setPaddingTop(f);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.f460k = renderMode;
    }

    public void setTitle(String str) {
        this.f458i.setText(str);
    }

    public void setTitleWidget(TextLabelWidget textLabelWidget) {
        this.f458i = textLabelWidget;
    }
}
