package com.lostnet.fw.p010e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.FirewallApplication;
import java.util.ArrayList;

public class C0320a {
    private int f1426a;
    private ArrayList f1427b;
    private int f1428c = -1;
    private int f1429d = -1;
    private Bitmap f1430e;
    private Canvas f1431f;
    private Paint f1432g = new Paint();
    private Paint f1433h;
    private Paint f1434i;
    private Paint f1435j;
    private Paint f1436k;
    private Paint f1437l;

    public C0320a(int i) {
        this.f1426a = i;
        this.f1432g.setColor(-65536);
        this.f1432g.setAntiAlias(true);
        this.f1432g.setShader(new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, Color.argb(250, 192, 0, 0), Color.argb(250, 192, 92, 0), TileMode.MIRROR));
        this.f1433h = new Paint();
        this.f1433h.setColor(-65536);
        this.f1433h.setAntiAlias(true);
        this.f1433h.setShader(new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, Color.argb(250, 128, 0, 0), Color.argb(250, 128, 64, 0), TileMode.MIRROR));
        this.f1434i = new Paint();
        this.f1434i.setColor(-65536);
        this.f1434i.setAntiAlias(true);
        this.f1434i.setShader(new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, Color.argb(250, 0, 192, 0), Color.argb(250, 92, 192, 0), TileMode.MIRROR));
        this.f1435j = new Paint();
        this.f1435j.setColor(-65536);
        this.f1435j.setAntiAlias(true);
        this.f1435j.setShader(new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, Color.argb(250, 0, 128, 0), Color.argb(250, 64, 128, 0), TileMode.MIRROR));
        this.f1436k = new Paint();
        this.f1436k.setColor(-7829368);
        this.f1436k.setStyle(Style.STROKE);
        this.f1436k.setAntiAlias(true);
        this.f1437l = new Paint();
        this.f1437l.setColor(-16777216);
        this.f1437l.setStyle(Style.FILL);
        this.f1437l.setAntiAlias(true);
        this.f1437l.setShader(new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, Color.argb(250, 0, 0, 16), Color.argb(250, 16, 16, 32), TileMode.MIRROR));
    }

    private void m2033a() {
        int i = 0;
        Resources resources = FirewallApplication.m1851a().getResources();
        this.f1430e.prepareToDraw();
        RectF rectF = new RectF(0.0f, 0.0f, (float) (this.f1428c - 1), (float) (this.f1429d - 1));
        this.f1431f.drawRoundRect(rectF, 7.0f, 7.0f, this.f1437l);
        this.f1431f.drawRoundRect(rectF, 7.0f, 7.0f, this.f1436k);
        if (this.f1427b == null || this.f1427b.size() < 1) {
            this.f1431f.drawText(resources.getString(C0330m.widget_graph_blocked_none), 10.0f, 20.0f, this.f1432g);
            return;
        }
        int i2;
        int i3 = 0;
        int i4 = 0;
        for (i2 = 0; i2 < this.f1427b.size(); i2++) {
            int intValue = ((Integer) this.f1427b.get(i2)).intValue();
            i3 += intValue;
            if (i4 < intValue) {
                i4 = intValue;
            }
        }
        while (i < this.f1427b.size()) {
            i2 = this.f1428c / (this.f1426a + 2);
            int i5 = (this.f1428c * (this.f1426a - i)) / (this.f1426a + 2);
            int i6 = ((int) (((double) i2) * 0.1d)) + i5;
            i2 = ((int) (((double) i2) * 0.9d)) + i5;
            intValue = ((int) (((double) this.f1429d) * 0.9d)) - ((int) (((((double) this.f1429d) * 0.8d) * ((double) ((Integer) this.f1427b.get(i)).intValue())) / ((double) i4)));
            i5 = ((int) (((double) this.f1429d) * 0.9d)) + 2;
            this.f1431f.drawRect(new Rect(i6, intValue, i2, i5), this.f1433h);
            this.f1431f.drawRect(new Rect(i6 + 1, intValue + 1, i2 - 1, i5), this.f1432g);
            i++;
        }
        String string = resources.getString(C0330m.widget_graph_blocked_str1);
        String str = i3 + " " + resources.getString(C0330m.widget_graph_blocked_str2);
        String str2 = this.f1426a + " " + resources.getString(C0330m.widget_graph_blocked_str3);
        this.f1431f.drawText(string, 6.0f, 16.0f, this.f1434i);
        this.f1431f.drawText(str, 6.0f, 28.0f, this.f1434i);
        this.f1431f.drawText(str2, 6.0f, 40.0f, this.f1434i);
    }

    public synchronized void m2034a(int i, int i2) {
        this.f1428c = i;
        this.f1429d = i2;
        m2033a();
    }

    public void m2035a(ArrayList arrayList) {
        this.f1427b = arrayList;
    }

    public synchronized Bitmap m2036b(int i, int i2) {
        if (this.f1430e != null && this.f1428c == i && this.f1429d == i2) {
            m2033a();
        } else {
            this.f1430e = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            this.f1431f = new Canvas(this.f1430e);
            m2034a(i, i2);
        }
        return this.f1430e;
    }
}
