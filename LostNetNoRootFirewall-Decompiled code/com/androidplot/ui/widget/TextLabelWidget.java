package com.androidplot.ui.widget;

import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.util.Log;
import com.androidplot.ui.LayoutManager;
import com.androidplot.ui.SizeLayoutType;
import com.androidplot.ui.SizeMetrics;
import com.androidplot.ui.TextOrientationType;
import com.androidplot.util.FontUtils;

public class TextLabelWidget extends Widget {
    private static final String f568a = TextLabelWidget.class.getName();
    private String f569b;
    private Paint f570c;
    private TextOrientationType f571d;
    private boolean f572e;

    public TextLabelWidget(LayoutManager layoutManager, SizeMetrics sizeMetrics) {
        this(layoutManager, sizeMetrics, TextOrientationType.HORIZONTAL);
    }

    public TextLabelWidget(LayoutManager layoutManager, SizeMetrics sizeMetrics, TextOrientationType textOrientationType) {
        super(layoutManager, new SizeMetrics(0.0f, SizeLayoutType.ABSOLUTE, 0.0f, SizeLayoutType.ABSOLUTE));
        this.f572e = true;
        this.f570c = new Paint();
        this.f570c.setColor(-1);
        this.f570c.setAntiAlias(true);
        this.f570c.setTextAlign(Align.CENTER);
        setSize(sizeMetrics);
        this.f571d = textOrientationType;
    }

    public TextLabelWidget(LayoutManager layoutManager, String str, SizeMetrics sizeMetrics, TextOrientationType textOrientationType) {
        this(layoutManager, sizeMetrics, textOrientationType);
        setText(str);
    }

    protected final void mo193a() {
        if (this.f572e) {
            pack();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doOnDraw(android.graphics.Canvas r5, android.graphics.RectF r6) {
        /*
        r4 = this;
        r0 = r4.f569b;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = r4.f569b;
        r0 = r0.length();
        if (r0 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r4.f570c;
        r0 = r0.getFontMetrics();
        r0 = r0.descent;
        r1 = com.androidplot.ui.AnchorPosition.CENTER;
        r1 = com.androidplot.ui.widget.Widget.getAnchorCoordinates(r6, r1);
        r2 = 31;
        r5.save(r2);	 Catch:{ all -> 0x0055 }
        r2 = r1.x;	 Catch:{ all -> 0x0055 }
        r1 = r1.y;	 Catch:{ all -> 0x0055 }
        r5.translate(r2, r1);	 Catch:{ all -> 0x0055 }
        r1 = com.androidplot.ui.widget.C0136a.f573a;	 Catch:{ all -> 0x0055 }
        r2 = r4.f571d;	 Catch:{ all -> 0x0055 }
        r2 = r2.ordinal();	 Catch:{ all -> 0x0055 }
        r1 = r1[r2];	 Catch:{ all -> 0x0055 }
        switch(r1) {
            case 1: goto L_0x005f;
            case 2: goto L_0x005a;
            case 3: goto L_0x006b;
            default: goto L_0x0034;
        };	 Catch:{ all -> 0x0055 }
    L_0x0034:
        r0 = new java.lang.UnsupportedOperationException;	 Catch:{ all -> 0x0055 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0055 }
        r1.<init>();	 Catch:{ all -> 0x0055 }
        r2 = "Orientation ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0055 }
        r2 = r4.f571d;	 Catch:{ all -> 0x0055 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0055 }
        r2 = " not yet implemented for TextLabelWidget.";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0055 }
        r1 = r1.toString();	 Catch:{ all -> 0x0055 }
        r0.<init>(r1);	 Catch:{ all -> 0x0055 }
        throw r0;	 Catch:{ all -> 0x0055 }
    L_0x0055:
        r0 = move-exception;
        r5.restore();
        throw r0;
    L_0x005a:
        r1 = -1028390912; // 0xffffffffc2b40000 float:-90.0 double:NaN;
        r5.rotate(r1);	 Catch:{ all -> 0x0055 }
    L_0x005f:
        r1 = r4.f569b;	 Catch:{ all -> 0x0055 }
        r2 = 0;
        r3 = r4.f570c;	 Catch:{ all -> 0x0055 }
        r5.drawText(r1, r2, r0, r3);	 Catch:{ all -> 0x0055 }
        r5.restore();
        goto L_0x000c;
    L_0x006b:
        r1 = 1119092736; // 0x42b40000 float:90.0 double:5.529052754E-315;
        r5.rotate(r1);	 Catch:{ all -> 0x0055 }
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androidplot.ui.widget.TextLabelWidget.doOnDraw(android.graphics.Canvas, android.graphics.RectF):void");
    }

    public Paint getLabelPaint() {
        return this.f570c;
    }

    public TextOrientationType getOrientation() {
        return this.f571d;
    }

    public String getText() {
        return this.f569b;
    }

    public boolean isAutoPackEnabled() {
        return this.f572e;
    }

    public void onPostInit() {
        if (this.f572e) {
            pack();
        }
    }

    public void pack() {
        Log.d(f568a, "Packing...");
        Rect stringDimensions = FontUtils.getStringDimensions(this.f569b, getLabelPaint());
        if (stringDimensions == null) {
            Log.w(f568a, "Attempt to pack empty text.");
            return;
        }
        switch (C0136a.f573a[this.f571d.ordinal()]) {
            case 1:
                setSize(new SizeMetrics((float) stringDimensions.height(), SizeLayoutType.ABSOLUTE, (float) (stringDimensions.width() + 2), SizeLayoutType.ABSOLUTE));
                break;
            case 2:
            case 3:
                setSize(new SizeMetrics((float) stringDimensions.width(), SizeLayoutType.ABSOLUTE, (float) (stringDimensions.height() + 2), SizeLayoutType.ABSOLUTE));
                break;
        }
        refreshLayout();
    }

    public void setAutoPackEnabled(boolean z) {
        this.f572e = z;
        if (z) {
            pack();
        }
    }

    public void setLabelPaint(Paint paint) {
        this.f570c = paint;
        if (this.f572e) {
            pack();
        }
    }

    public void setOrientation(TextOrientationType textOrientationType) {
        this.f571d = textOrientationType;
        if (this.f572e) {
            pack();
        }
    }

    public void setText(String str) {
        Log.d(f568a, "Setting textLabel to: " + str);
        this.f569b = str;
        if (this.f572e) {
            pack();
        }
    }
}
