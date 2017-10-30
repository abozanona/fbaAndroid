package com.ppu.fba.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import com.androidplot.Plot.BorderStyle;
import com.androidplot.Series;
import com.androidplot.ui.Formatter;
import com.androidplot.xy.BarFormatter;
import com.androidplot.xy.BarRenderer;
import com.androidplot.xy.BarRenderer.BarWidthStyle;
import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.SimpleXYSeries.ArrayFormat;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYStepMode;
import com.ppu.fba.free.R;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p007b.C0289a;
import com.ppu.fba.p008c.C0296a;
import com.ppu.fba.p008c.C0297b;
import com.ppu.fba.p008c.C0298c;
import com.ppu.fba.p008c.C0299d;
import com.ppu.fba.p008c.C0302g;
import com.ppu.fba.p009d.C0308e;
import com.ppu.fba.p009d.C0312i;
import com.ppu.fba.p009d.C0313j;
import com.ppu.fba.p009d.Log1;
import com.ppu.fba.p009d.Log1;
import java.math.BigInteger;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public class DetailsAppActivity extends Activity {
    Integer f1453a;
    ListView f1454b;
    ListView f1455c;
    ListView f1456d;
    TextView f1457e;
    TextView f1458f;
    volatile BigInteger f1459g = BigInteger.valueOf(0);
    volatile BigInteger f1460h = BigInteger.valueOf(0);
    volatile BigInteger f1461i = BigInteger.valueOf(0);
    volatile BigInteger f1462j = BigInteger.valueOf(0);
    volatile BigInteger f1463k = BigInteger.valueOf(0);
    volatile BigInteger f1464l = BigInteger.valueOf(0);
    CheckBox f1465m;
    CheckBox f1466n;
    CheckBox f1467o;

    private void m2038a(HashMap hashMap, ArrayList arrayList, int i, ArrayList arrayList2) {
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            C0297b c0297b = (C0297b) it.next();
            for (Object num : c0297b.m1942b(this.f1453a.intValue()).keySet()) {
                C0298c c0298c = (C0298c) hashMap.get(num);
                if (c0298c == null) {
                    //c0298c = new C0302g();
                }
                C0298c a = c0297b.m1936a(this.f1453a.intValue(), ((Integer)num).intValue());
                c0298c.f1378a = c0298c.f1378a.add(a.f1378a);
                c0298c.f1379b = c0298c.f1379b.add(a.f1379b);
                c0298c.f1380c += a.f1380c;
                c0298c.f1381d += a.f1381d;
                if (i == 0) {
                    this.f1459g = this.f1459g.add(a.f1378a);
                    this.f1460h = this.f1460h.add(a.f1379b);
                } else if (i == 1) {
                    this.f1461i = this.f1461i.add(a.f1378a);
                    this.f1462j = this.f1462j.add(a.f1379b);
                } else {
                    this.f1463k = this.f1463k.add(a.f1378a);
                    this.f1464l = this.f1464l.add(a.f1379b);
                }
                hashMap.put(num, c0298c);
            }
        }
        arrayList.addAll(hashMap.keySet());
        Collections.sort(arrayList, new bl(this, hashMap));
    }

    public void m2039a(Context context) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        this.f1459g = BigInteger.valueOf(0);
        this.f1460h = BigInteger.valueOf(0);
        this.f1461i = BigInteger.valueOf(0);
        this.f1462j = BigInteger.valueOf(0);
        this.f1463k = BigInteger.valueOf(0);
        this.f1464l = BigInteger.valueOf(0);
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            synchronized (this) {
                long j;
                ArrayList arrayList4 = new ArrayList();
                long b = C0296a.m1929b();
                C0299d c0299d = a.f1297f;
                synchronized (c0299d) {
                    for (j = b; j > b - 24; j--) {
                        arrayList4.add(c0299d.m1952a(j));
                    }
                }
                ArrayList arrayList5 = new ArrayList();
                b = C0296a.m1928a();
                C0299d c0299d2 = a.f1296e;
                synchronized (c0299d2) {
                    for (j = b; j > b - 7; j--) {
                        arrayList5.add(c0299d2.m1952a(j));
                    }
                }
                ArrayList arrayList6 = new ArrayList();
                synchronized (c0299d2) {
                    for (j = b; j > b - 30; j--) {
                        arrayList6.add(c0299d2.m1952a(j));
                    }
                }
                m2038a(hashMap, arrayList, 0, arrayList4);
                m2038a(hashMap2, arrayList2, 1, arrayList5);
                m2038a(hashMap3, arrayList3, 2, arrayList6);
            }
        } else {
            Log1.LogF1("DetailsAppActivity", "NO MANAGER !!!!");
        }
        this.f1454b.setAdapter(new C0349n(this, this, hashMap, arrayList));
        this.f1455c.setAdapter(new C0349n(this, this, hashMap2, arrayList2));
        this.f1456d.setAdapter(new C0349n(this, this, hashMap3, arrayList3));
        this.f1457e.setText(C0312i.m2001a(getApplicationContext(), this.f1459g));
        this.f1458f.setText(C0312i.m2001a(getApplicationContext(), this.f1460h));
        C0313j.m2002a(this.f1454b);
        C0313j.m2002a(this.f1455c);
        C0313j.m2002a(this.f1456d);
        XYPlot xYPlot = (XYPlot) findViewById(R.id.detailsGraphHours);
        XYPlot xYPlot2 = (XYPlot) findViewById(R.id.detailsGraphDays);
        XYPlot xYPlot3 = (XYPlot) findViewById(R.id.detailsGraphMonth);
        List arrayList7 = new ArrayList();
        List arrayList8 = new ArrayList();
        List arrayList9 = new ArrayList();
        List arrayList10 = new ArrayList();
        List arrayList11 = new ArrayList();
        List arrayList12 = new ArrayList();
        long a2 = C0296a.m1928a();
        long b2 = C0296a.m1929b();
        C0298c[] c0298cArr = new C0298c[24];
        C0298c[] c0298cArr2 = new C0298c[7];
        C0298c[] c0298cArr3 = new C0298c[30];
        C0299d c0299d3 = a.f1297f;
        synchronized (c0299d3) {
            int i;
            for (i = 0; i < c0298cArr.length; i++) {
                c0298cArr[i] = c0299d3.m1952a(b2 - ((long) i)).m1935a(this.f1453a.intValue());
            }
        }
        for (int i = c0298cArr.length - 1; i >= 0; i--) {
            arrayList7.add(Double.valueOf(Double.valueOf((double) (b2 - ((long) i))).doubleValue() + 0.05d));
            arrayList7.add(c0298cArr[i].f1378a);
            arrayList8.add(Double.valueOf(Double.valueOf((double) (b2 - ((long) i))).doubleValue() + 0.05d));
            arrayList8.add(c0298cArr[i].f1379b);
        }
        C0299d c0299d4 = a.f1296e;
        synchronized (c0299d4) {
            for (int i = 0; i < c0298cArr2.length; i++) {
                c0298cArr2[i] = c0299d4.m1952a(a2 - ((long) i)).m1935a(this.f1453a.intValue());
            }
        }
        for (int i = c0298cArr2.length - 1; i >= 0; i--) {
            arrayList9.add(Double.valueOf(Double.valueOf((double) (a2 - ((long) i))).doubleValue() + 0.1d));
            arrayList9.add(c0298cArr2[i].f1378a);
            arrayList10.add(Double.valueOf(Double.valueOf((double) (a2 - ((long) i))).doubleValue() + 0.1d));
            arrayList10.add(c0298cArr2[i].f1379b);
        }
        synchronized (c0299d4) {
            for (int i = 0; i < c0298cArr3.length; i++) {
                c0298cArr3[i] = c0299d4.m1952a(a2 - ((long) i)).m1935a(this.f1453a.intValue());
            }
        }
        for (int i = c0298cArr3.length - 1; i >= 0; i--) {
            arrayList11.add(Double.valueOf(Double.valueOf((double) (a2 - ((long) i))).doubleValue() + 0.1d));
            arrayList11.add(c0298cArr3[i].f1378a);
            arrayList12.add(Double.valueOf(Double.valueOf((double) (a2 - ((long) i))).doubleValue() + 0.1d));
            arrayList12.add(c0298cArr3[i].f1379b);
        }
        Series simpleXYSeries = new SimpleXYSeries(arrayList7, ArrayFormat.XY_VALS_INTERLEAVED, "Upload");
        Series simpleXYSeries2 = new SimpleXYSeries(arrayList8, ArrayFormat.XY_VALS_INTERLEAVED, "Download");
        Formatter barFormatter = new BarFormatter(Color.argb(250, 255, 119, 31), -3355444);
        Formatter barFormatter2 = new BarFormatter(Color.argb(250, 132, 191, 16), -3355444);
        //barFormatter.setPointLabeler(null);
        xYPlot.clear();
        xYPlot.setDomainBoundaries(Long.valueOf(b2 - 23), Long.valueOf(b2 + 1), BoundaryMode.FIXED);
        //xYPlot.addSeries(simpleXYSeries, barFormatter);
        //xYPlot.addSeries(simpleXYSeries2, barFormatter2);
        BarRenderer barRenderer = (BarRenderer) xYPlot.getRenderer(BarRenderer.class);
        barRenderer.setBarWidthStyle(BarWidthStyle.VARIABLE_WIDTH);
        barRenderer.setBarGap(4.0f);
        Series simpleXYSeries3 = new SimpleXYSeries(arrayList9, ArrayFormat.XY_VALS_INTERLEAVED, "Upload");
        simpleXYSeries = new SimpleXYSeries(arrayList10, ArrayFormat.XY_VALS_INTERLEAVED, "Download");
        Formatter barFormatter3 = new BarFormatter(Color.argb(250, 255, 119, 31), -3355444);
        barFormatter = new BarFormatter(Color.argb(250, 132, 191, 16), -3355444);
        xYPlot2.clear();
        xYPlot2.setDomainBoundaries(Double.valueOf((((double) a2) - 5.95d) - 1.0d), Double.valueOf((((double) a2) + 0.05d) + 1.0d), BoundaryMode.FIXED);
        //xYPlot2.addSeries(simpleXYSeries3, barFormatter3);
        //xYPlot2.addSeries(simpleXYSeries, barFormatter);
        barRenderer = (BarRenderer) xYPlot2.getRenderer(BarRenderer.class);
        barRenderer.setBarWidthStyle(BarWidthStyle.VARIABLE_WIDTH);
        barRenderer.setBarGap(14.0f);
        simpleXYSeries3 = new SimpleXYSeries(arrayList11, ArrayFormat.XY_VALS_INTERLEAVED, "Upload");
        Series simpleXYSeries4 = new SimpleXYSeries(arrayList12, ArrayFormat.XY_VALS_INTERLEAVED, "Download");
        Formatter barFormatter4 = new BarFormatter(Color.argb(250, 255, 119, 31), -3355444);
        barFormatter3 = new BarFormatter(Color.argb(250, 132, 191, 16), -3355444);
        xYPlot3.clear();
        xYPlot3.setDomainBoundaries(Double.valueOf((((double) a2) - 29.95d) - 1.0d), Double.valueOf((((double) a2) + 0.05d) + 1.0d), BoundaryMode.FIXED);
        //xYPlot3.addSeries(simpleXYSeries3, barFormatter4);
        //xYPlot3.addSeries(simpleXYSeries4, barFormatter3);
        barRenderer = (BarRenderer) xYPlot3.getRenderer(BarRenderer.class);
        barRenderer.setBarWidthStyle(BarWidthStyle.VARIABLE_WIDTH);
        barRenderer.setBarGap(4.0f);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_details_app);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        Integer valueOf = Integer.valueOf(getIntent().getIntExtra("id", 0));
        this.f1453a = valueOf;
        Boolean bool = ("com.ppu.fba.free".equals(getResources().getString(R.string.package_name)) || !C0313j.m2004a((Context) this)) ? Boolean.FALSE : Boolean.TRUE;
        ((TextView) findViewById(R.id.detailsName)).setText(C0308e.m1964a(valueOf.intValue()));
        this.f1457e = (TextView) findViewById(R.id.detailsUpload);
        this.f1458f = (TextView) findViewById(R.id.detailsDownload);
        TextView textView = (TextView) findViewById(R.id.detailsTextBlock);
        this.f1465m = (CheckBox) findViewById(R.id.detailsBackground);
        this.f1466n = (CheckBox) findViewById(R.id.detailsNight);
        this.f1467o = (CheckBox) findViewById(R.id.detailsOffice);
        if (!bool.booleanValue()) {
            textView.setText(R.string.checkboxCommentFree);
            this.f1466n.setEnabled(false);
            this.f1467o.setEnabled(false);
        }
        RadioButton radioButton = (RadioButton) findViewById(R.id.buttonAllow);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.buttonWiFiOnly);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.buttonBlock);
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            C0289a c0289a;
            String c = C0308e.m1970c(valueOf.intValue());
            synchronized (a.f1294c) {
                c0289a = (C0289a) a.f1294c.f1366a.get(valueOf);
                if (c0289a == null) {
                    c0289a = new C0289a(valueOf.intValue());
                    a.f1294c.f1366a.put(valueOf, c0289a);
                }
            }
            int a2 = c0289a.m1919a();
            int b = c0289a.m1921b();
            if ((b & 8) == 8) {
                this.f1465m.setChecked(true);
            }
            if ((b & 16) == 16) {
                this.f1466n.setChecked(true);
            }
            if ((b & 32) == 32) {
                this.f1467o.setChecked(true);
            }
            if (a2 == 2) {
                radioButton3.setChecked(true);
                radioButton2.setChecked(false);
                radioButton.setChecked(false);
                this.f1465m.setEnabled(false);
                this.f1466n.setEnabled(false);
                this.f1467o.setEnabled(false);
            } else if (a2 == 1) {
                radioButton3.setChecked(false);
                radioButton2.setChecked(true);
                radioButton.setChecked(false);
                this.f1465m.setEnabled(true);
                if (bool.booleanValue()) {
                    this.f1466n.setEnabled(true);
                    this.f1467o.setEnabled(true);
                }
            } else {
                radioButton3.setChecked(false);
                radioButton2.setChecked(false);
                radioButton.setChecked(true);
                this.f1465m.setEnabled(true);
                if (bool.booleanValue()) {
                    this.f1466n.setEnabled(true);
                    this.f1467o.setEnabled(true);
                }
            }
            this.f1465m.setOnCheckedChangeListener(new C0338d(this, c0289a, c));
            this.f1466n.setOnCheckedChangeListener(new C0341f(this, c0289a, c));
            this.f1467o.setOnCheckedChangeListener(new C0342g(this, c0289a, c));
            radioButton.setOnClickListener(new C0343h(this, c0289a, bool, c));
            radioButton2.setOnClickListener(new C0344i(this, c0289a, bool, c));
            radioButton3.setOnClickListener(new C0345j(this, c0289a, c));
        }
        ImageView imageView = (ImageView) findViewById(R.id.detailsIcon);
        Bitmap b2 = C0308e.m1967b(valueOf.intValue());
        if (b2 != null) {
            imageView.setImageBitmap(b2);
        }
        ViewPager viewPager = (ViewPager) findViewById(R.id.detailsGraphPager);
        viewPager.setAdapter(new C0351p(this));
        TabHost tabHost = (TabHost) findViewById(R.id.detailsTabHost);
        tabHost.setup();
        TabSpec newTabSpec = tabHost.newTabSpec("one");
        newTabSpec.setContent(R.id.detailsGraphPager);
        newTabSpec.setIndicator(getResources().getString(R.string.title_tab_1day));
        tabHost.addTab(newTabSpec);
        newTabSpec = tabHost.newTabSpec("seven");
        newTabSpec.setContent(R.id.detailsGraphPager);
        newTabSpec.setIndicator(getResources().getString(R.string.title_tab_7days));
        tabHost.addTab(newTabSpec);
        newTabSpec = tabHost.newTabSpec("thirty");
        newTabSpec.setContent(R.id.detailsGraphPager);
        if ("com.ppu.fba.free".equals(getResources().getString(R.string.package_name)) || !C0313j.m2004a((Context) this)) {
            newTabSpec.setIndicator(getResources().getString(R.string.title_tab_30days));
        } else {
            newTabSpec.setIndicator(getResources().getString(R.string.title_tab_30days_pro));
        }
        tabHost.addTab(newTabSpec);
        tabHost.setOnTabChangedListener(new C0346k(this, viewPager));
        viewPager.setOnPageChangeListener(new C0347l(this, tabHost));
        Format bmVar = new bm(this);
        XYPlot xYPlot = (XYPlot) findViewById(R.id.detailsGraphHours);
        XYPlot xYPlot2 = (XYPlot) findViewById(R.id.detailsGraphDays);
        XYPlot xYPlot3 = (XYPlot) findViewById(R.id.detailsGraphMonth);
        xYPlot.setDomainStep(XYStepMode.SUBDIVIDE, 13.0d);
        xYPlot.setRangeStep(XYStepMode.SUBDIVIDE, 2.0d);
        xYPlot.setTicksPerRangeLabel(1);
        xYPlot.setBorderStyle(BorderStyle.NONE, null, null);
        xYPlot.getBackgroundPaint().setColor(0);
        xYPlot.getGraphWidget().getGridBackgroundPaint().setColor(0);
        xYPlot.getGraphWidget().getBackgroundPaint().setColor(0);
        xYPlot.getGraphWidget().getDomainGridLinePaint().setColor(0);
        xYPlot.getGraphWidget().getRangeGridLinePaint().setColor(0);
        xYPlot.getGraphWidget().getRangeOriginLabelPaint().setColor(0);
        xYPlot.setPlotMargins(0.0f, 0.0f, 0.0f, 0.0f);
        xYPlot.setPlotPadding(0.0f, 0.0f, 0.0f, 0.0f);
        xYPlot.setGridPadding(0.0f, 0.0f, 0.0f, 0.0f);
        //xYPlot.setPaddingRelative(0, 0, 0, 0);
        xYPlot.getLayoutManager().remove(xYPlot.getLegendWidget());
        xYPlot.getLayoutManager().remove(xYPlot.getRangeLabelWidget());
        xYPlot.getLayoutManager().remove(xYPlot.getDomainLabelWidget());
        xYPlot.getLayoutManager().remove(xYPlot.getTitleWidget());
        xYPlot.getGraphWidget().setDomainLabelOrientation(0.0f);
        xYPlot.setRangeTopMin(Integer.valueOf(1000));
        xYPlot.setRangeBottomMax(Integer.valueOf(0));
        xYPlot.setRangeValueFormat(bmVar);
        xYPlot.setDomainValueFormat(new C0348m(this));
        xYPlot2.setDomainStep(XYStepMode.SUBDIVIDE, 9.0d);
        xYPlot2.setRangeStep(XYStepMode.SUBDIVIDE, 2.0d);
        xYPlot2.setTicksPerRangeLabel(1);
        xYPlot2.setBorderStyle(BorderStyle.NONE, null, null);
        xYPlot2.getBackgroundPaint().setColor(0);
        xYPlot2.getGraphWidget().getGridBackgroundPaint().setColor(0);
        xYPlot2.getGraphWidget().getBackgroundPaint().setColor(0);
        xYPlot2.getGraphWidget().getDomainGridLinePaint().setColor(0);
        xYPlot2.getGraphWidget().getRangeGridLinePaint().setColor(0);
        xYPlot2.getGraphWidget().getRangeOriginLabelPaint().setColor(0);
        xYPlot2.setPlotMargins(0.0f, 0.0f, 0.0f, 0.0f);
        xYPlot2.setPlotPadding(0.0f, 0.0f, 0.0f, 0.0f);
        xYPlot2.setGridPadding(0.0f, 0.0f, 0.0f, 0.0f);
        //xYPlot2.setPaddingRelative(0, 0, 0, 0);
        xYPlot2.getLayoutManager().remove(xYPlot2.getLegendWidget());
        xYPlot2.getLayoutManager().remove(xYPlot2.getRangeLabelWidget());
        xYPlot2.getLayoutManager().remove(xYPlot2.getDomainLabelWidget());
        xYPlot2.getLayoutManager().remove(xYPlot2.getTitleWidget());
        xYPlot2.getGraphWidget().setDomainLabelOrientation(0.0f);
        xYPlot2.setRangeTopMin(Integer.valueOf(1000));
        xYPlot2.setRangeBottomMax(Integer.valueOf(0));
        xYPlot2.setRangeValueFormat(bmVar);
        xYPlot2.setDomainValueFormat(new C0340e(this));
        xYPlot3.setDomainStep(XYStepMode.SUBDIVIDE, 16.0d);
        xYPlot3.setRangeStep(XYStepMode.SUBDIVIDE, 2.0d);
        xYPlot3.setTicksPerRangeLabel(1);
        xYPlot3.setBorderStyle(BorderStyle.NONE, null, null);
        xYPlot3.getBackgroundPaint().setColor(0);
        xYPlot3.getGraphWidget().getGridBackgroundPaint().setColor(0);
        xYPlot3.getGraphWidget().getBackgroundPaint().setColor(0);
        xYPlot3.getGraphWidget().getDomainGridLinePaint().setColor(0);
        xYPlot3.getGraphWidget().getRangeGridLinePaint().setColor(0);
        xYPlot3.getGraphWidget().getRangeOriginLabelPaint().setColor(0);
        xYPlot3.setPlotMargins(0.0f, 0.0f, 0.0f, 0.0f);
        xYPlot3.setPlotPadding(0.0f, 0.0f, 0.0f, 0.0f);
        xYPlot3.setGridPadding(0.0f, 0.0f, 0.0f, 0.0f);
        //xYPlot3.setPaddingRelative(0, 0, 0, 0);
        xYPlot3.getLayoutManager().remove(xYPlot3.getLegendWidget());
        xYPlot3.getLayoutManager().remove(xYPlot3.getRangeLabelWidget());
        xYPlot3.getLayoutManager().remove(xYPlot3.getDomainLabelWidget());
        xYPlot3.getLayoutManager().remove(xYPlot3.getTitleWidget());
        xYPlot3.getGraphWidget().setDomainLabelOrientation(0.0f);
        xYPlot3.setRangeTopMin(Integer.valueOf(1000));
        xYPlot3.setRangeBottomMax(Integer.valueOf(0));
        xYPlot3.setRangeValueFormat(bmVar);
        xYPlot3.setDomainValueFormat(new bk(this));
        tabHost.setCurrentTab(1);
        viewPager.setCurrentItem(1);
        tabHost.setCurrentTab(0);
        viewPager.setCurrentItem(0);
        this.f1454b = (ListView) findViewById(R.id.detailsListHourly);
        this.f1455c = (ListView) findViewById(R.id.detailsListDaily);
        this.f1456d = (ListView) findViewById(R.id.detailsListMonth);
        m2039a(this);
        this.f1457e.setText(C0312i.m2001a(getApplicationContext(), this.f1459g));
        this.f1458f.setText(C0312i.m2001a(getApplicationContext(), this.f1460h));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
