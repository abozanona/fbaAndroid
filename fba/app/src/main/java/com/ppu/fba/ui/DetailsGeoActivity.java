package com.ppu.fba.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import com.ppu.fba.p007b.C0292d;
import com.ppu.fba.p007b.C0294f;
import com.ppu.fba.p008c.C0296a;
import com.ppu.fba.p008c.C0297b;
import com.ppu.fba.p008c.C0298c;
import com.ppu.fba.p008c.C0299d;
import com.ppu.fba.p008c.C0302g;
import com.ppu.fba.p009d.C0309f;
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
public class DetailsGeoActivity extends Activity {
    ArrayList f1468a;
    ListView f1469b;
    ListView f1470c;
    ListView f1471d;
    TextView f1472e;
    TextView f1473f;
    volatile BigInteger f1474g = BigInteger.valueOf(0);
    volatile BigInteger f1475h = BigInteger.valueOf(0);
    volatile BigInteger f1476i = BigInteger.valueOf(0);
    volatile BigInteger f1477j = BigInteger.valueOf(0);
    volatile BigInteger f1478k = BigInteger.valueOf(0);
    volatile BigInteger f1479l = BigInteger.valueOf(0);

    private void m2040a(HashMap hashMap, ArrayList arrayList, int i, ArrayList arrayList2) {
        int i2 = getApplicationInfo().uid;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            C0297b c0297b = (C0297b) it.next();
            Iterator it2 = this.f1468a.iterator();
            while (it2.hasNext()) {
                Integer valueOf = Integer.valueOf(C0309f.m1982d((String) it2.next()));
                for (Object num : c0297b.m1948d(valueOf.intValue()).keySet()) {
                    if (((Integer)num).intValue() != i2) {
                        C0298c c0298c = (C0298c) hashMap.get(num);
                        if (c0298c == null) {
                            //c0298c = new C0302g();
                        }
                        C0298c b = c0297b.m1941b(valueOf.intValue(), ((Integer)num).intValue());
                        c0298c.f1378a = c0298c.f1378a.add(b.f1378a);
                        c0298c.f1379b = c0298c.f1379b.add(b.f1379b);
                        c0298c.f1380c += b.f1380c;
                        c0298c.f1381d += b.f1381d;
                        if (i == 0) {
                            this.f1476i = this.f1476i.add(b.f1378a);
                            this.f1477j = this.f1477j.add(b.f1379b);
                        } else if (i == 1) {
                            this.f1474g = this.f1474g.add(b.f1378a);
                            this.f1475h = this.f1475h.add(b.f1379b);
                        } else {
                            this.f1478k = this.f1478k.add(b.f1378a);
                            this.f1479l = this.f1479l.add(b.f1379b);
                        }
                        hashMap.put(num, c0298c);
                    }
                }
            }
        }
        arrayList.addAll(hashMap.keySet());
        Collections.sort(arrayList, new C0359x(this, hashMap));
    }

    public void m2041a(Context context) {
        int i;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        this.f1474g = BigInteger.valueOf(0);
        this.f1475h = BigInteger.valueOf(0);
        this.f1476i = BigInteger.valueOf(0);
        this.f1477j = BigInteger.valueOf(0);
        this.f1478k = BigInteger.valueOf(0);
        this.f1479l = BigInteger.valueOf(0);
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            synchronized (this) {
                long j;
                ArrayList arrayList4 = new ArrayList();
                long a2 = C0296a.m1928a();
                C0299d c0299d = a.f1296e;
                synchronized (c0299d) {
                    for (j = a2; j > a2 - 10; j--) {
                        arrayList4.add(c0299d.m1952a(j));
                    }
                }
                ArrayList arrayList5 = new ArrayList();
                long b = C0296a.m1929b();
                C0299d c0299d2 = a.f1297f;
                synchronized (c0299d2) {
                    for (j = b; j > b - 24; j--) {
                        arrayList5.add(c0299d2.m1952a(j));
                    }
                }
                ArrayList arrayList6 = new ArrayList();
                synchronized (c0299d) {
                    for (j = a2; j > a2 - 30; j--) {
                        arrayList6.add(c0299d.m1952a(j));
                    }
                }
                m2040a(hashMap, arrayList, 0, arrayList5);
                m2040a(hashMap2, arrayList2, 1, arrayList4);
                m2040a(hashMap3, arrayList3, 2, arrayList6);
            }
        } else {
            Log1.LogF1("DetailsAppActivity", "NO MANAGER !!!!");
        }
        this.f1470c.setAdapter(new C0361z(this, this, hashMap, arrayList));
        this.f1469b.setAdapter(new C0361z(this, this, hashMap2, arrayList2));
        this.f1471d.setAdapter(new C0361z(this, this, hashMap3, arrayList3));
        this.f1472e.setText(C0312i.m2001a(getApplicationContext(), this.f1474g));
        this.f1473f.setText(C0312i.m2001a(getApplicationContext(), this.f1475h));
        C0313j.m2002a(this.f1470c);
        C0313j.m2002a(this.f1469b);
        C0313j.m2002a(this.f1471d);
        XYPlot xYPlot = (XYPlot) findViewById(R.id.detailsGraphHours);
        XYPlot xYPlot2 = (XYPlot) findViewById(R.id.detailsGraphDays);
        XYPlot xYPlot3 = (XYPlot) findViewById(R.id.detailsGraphMonth);
        List arrayList7 = new ArrayList();
        List arrayList8 = new ArrayList();
        List arrayList9 = new ArrayList();
        List arrayList10 = new ArrayList();
        List arrayList11 = new ArrayList();
        List arrayList12 = new ArrayList();
        long a3 = C0296a.m1928a();
        long b2 = C0296a.m1929b();
        C0298c[] c0298cArr = new C0298c[24];
        C0298c[] c0298cArr2 = new C0298c[7];
        C0298c[] c0298cArr3 = new C0298c[30];
        C0299d c0299d3 = a.f1297f;
        for (i = 0; i < c0298cArr.length; i++) {
            //c0298cArr[i] = new C0302g();
        }
        synchronized (c0299d3) {
            Iterator it = this.f1468a.iterator();
            while (it.hasNext()) {
                Integer valueOf = Integer.valueOf(C0309f.m1982d((String) it.next()));
                for (i = 0; i < c0298cArr.length; i++) {
                    c0298cArr[i].m1949a(c0299d3.m1952a(b2 - ((long) i)).m1946c(valueOf.intValue()));
                }
            }
        }
        for (i = c0298cArr.length - 1; i >= 0; i--) {
            arrayList7.add(Double.valueOf(Double.valueOf((double) (b2 - ((long) i))).doubleValue() + 0.05d));
            arrayList7.add(c0298cArr[i].f1378a);
            arrayList8.add(Double.valueOf(Double.valueOf((double) (b2 - ((long) i))).doubleValue() + 0.05d));
            arrayList8.add(c0298cArr[i].f1379b);
        }
        C0299d c0299d4 = a.f1296e;
        for (i = 0; i < c0298cArr2.length; i++) {
            //c0298cArr2[i] = new C0302g();
        }
        synchronized (c0299d4) {
            Iterator it2 = this.f1468a.iterator();
            while (it2.hasNext()) {
                Integer valueOf2 = Integer.valueOf(C0309f.m1982d((String) it2.next()));
                for (i = 0; i < c0298cArr2.length; i++) {
                    c0298cArr2[i].m1949a(c0299d4.m1952a(a3 - ((long) i)).m1946c(valueOf2.intValue()));
                }
            }
        }
        for (i = c0298cArr2.length - 1; i >= 0; i--) {
            arrayList9.add(Double.valueOf(Double.valueOf((double) (a3 - ((long) i))).doubleValue() + 0.1d));
            arrayList9.add(c0298cArr2[i].f1378a);
            arrayList10.add(Double.valueOf(Double.valueOf((double) (a3 - ((long) i))).doubleValue() + 0.1d));
            arrayList10.add(c0298cArr2[i].f1379b);
        }
        for (i = 0; i < c0298cArr3.length; i++) {
            //c0298cArr3[i] = new C0302g();
        }
        synchronized (c0299d4) {
            //it2 = this.f1468a.iterator();
            //while (it2.hasNext()) {
            //    Integer valueOf3 = Integer.valueOf(C0309f.m1982d((String) it2.next()));
            //    for (i = 0; i < c0298cArr3.length; i++) {
            //        c0298cArr3[i].m1949a(c0299d4.m1952a(a3 - ((long) i)).m1946c(valueOf3.intValue()));
            //    }
            //}
        }
        for (i = c0298cArr3.length - 1; i >= 0; i--) {
            arrayList11.add(Double.valueOf(Double.valueOf((double) (a3 - ((long) i))).doubleValue() + 0.1d));
            arrayList11.add(c0298cArr3[i].f1378a);
            arrayList12.add(Double.valueOf(Double.valueOf((double) (a3 - ((long) i))).doubleValue() + 0.1d));
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
        xYPlot2.setDomainBoundaries(Double.valueOf((((double) a3) - 5.95d) - 1.0d), Double.valueOf((((double) a3) + 0.05d) + 1.0d), BoundaryMode.FIXED);
        //xYPlot2.addSeries(simpleXYSeries3, barFormatter3);
        //xYPlot2.addSeries(simpleXYSeries, barFormatter);
        barRenderer = (BarRenderer) xYPlot2.getRenderer(BarRenderer.class);
        barRenderer.setBarWidthStyle(BarWidthStyle.VARIABLE_WIDTH);
        barRenderer.setBarGap(8.0f);
        simpleXYSeries3 = new SimpleXYSeries(arrayList11, ArrayFormat.XY_VALS_INTERLEAVED, "Upload");
        Series simpleXYSeries4 = new SimpleXYSeries(arrayList12, ArrayFormat.XY_VALS_INTERLEAVED, "Download");
        Formatter barFormatter4 = new BarFormatter(Color.argb(250, 255, 119, 31), -3355444);
        barFormatter3 = new BarFormatter(Color.argb(250, 132, 191, 16), -3355444);
        xYPlot3.clear();
        xYPlot3.setDomainBoundaries(Double.valueOf((((double) a3) - 29.95d) - 1.0d), Double.valueOf((((double) a3) + 0.05d) + 1.0d), BoundaryMode.FIXED);
        //xYPlot3.addSeries(simpleXYSeries3, barFormatter4);
        //xYPlot3.addSeries(simpleXYSeries4, barFormatter3);
        barRenderer = (BarRenderer) xYPlot3.getRenderer(BarRenderer.class);
        barRenderer.setBarWidthStyle(BarWidthStyle.VARIABLE_WIDTH);
        barRenderer.setBarGap(4.0f);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_details_geo);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        String stringExtra = getIntent().getStringExtra("name");
        this.f1468a = getIntent().getStringArrayListExtra("codes");
        if (this.f1468a.size() == 1) {
            getActionBar().setTitle(R.string.title_activity_details_country);
        } else {
            getActionBar().setTitle(R.string.title_activity_details_region);
        }
        ((TextView) findViewById(R.id.detailsName)).setText(stringExtra);
        this.f1472e = (TextView) findViewById(R.id.detailsUpload);
        this.f1473f = (TextView) findViewById(R.id.detailsDownload);
        ((RadioButton) findViewById(R.id.buttonWiFiOnly)).setVisibility(View.GONE);
        RadioButton radioButton = (RadioButton) findViewById(R.id.buttonAllow);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.buttonBlock);
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            int i;
            C0294f c0294f = a.f1295d;
            synchronized (c0294f) {
                Iterator it = this.f1468a.iterator();
                int i2 = -1;
                while (it.hasNext()) {
                    C0292d c0292d = (C0292d) c0294f.f1370a.get(Integer.valueOf(C0309f.m1982d((String) it.next())));
                    if ((i2 != -1 && i2 != 0) || c0292d != null) {
                        if (i2 != -1 && i2 != 0 && c0292d == null) {
                            i = -1;
                            break;
                        } else if (i2 == -1) {
                            i2 = c0292d.f1369c;
                        } else if (i2 != c0292d.f1369c) {
                            i = -1;
                            break;
                        }
                    } else {
                        i2 = 0;
                    }
                }
                i = i2;
            }
            if (i == 2) {
                radioButton2.setChecked(true);
                radioButton.setChecked(false);
            } else if (i == 0) {
                radioButton2.setChecked(false);
                radioButton.setChecked(true);
            }
            radioButton.setOnClickListener(new C0352q(this, stringExtra));
            radioButton2.setOnClickListener(new C0353r(this, stringExtra));
        }
        ImageView imageView = (ImageView) findViewById(R.id.detailsIcon);
        if (this.f1468a.size() == 1) {
            imageView.setImageDrawable(C0309f.m1984e((String) this.f1468a.get(0)));
        } else {
            imageView.setVisibility(View.GONE);
        }
        ViewPager viewPager = (ViewPager) findViewById(R.id.detailsGraphPager);
        viewPager.setAdapter(new ab(this));
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
        tabHost.setOnTabChangedListener(new C0354s(this, viewPager));
        viewPager.setOnPageChangeListener(new C0355t(this, tabHost));
        Format boVar = new bo(this);
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
        xYPlot.setRangeValueFormat(boVar);
        xYPlot.setDomainValueFormat(new C0356u(this));
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
        xYPlot2.setRangeValueFormat(boVar);
        xYPlot2.setDomainValueFormat(new C0357v(this));
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
        xYPlot3.setRangeValueFormat(boVar);
        xYPlot3.setDomainValueFormat(new C0358w(this));
        tabHost.setCurrentTab(1);
        viewPager.setCurrentItem(1);
        tabHost.setCurrentTab(0);
        viewPager.setCurrentItem(0);
        this.f1470c = (ListView) findViewById(R.id.detailsListHourly);
        this.f1469b = (ListView) findViewById(R.id.detailsListDaily);
        this.f1471d = (ListView) findViewById(R.id.detailsListMonth);
        m2041a(this);
        this.f1472e.setText(C0312i.m2001a(getApplicationContext(), this.f1476i));
        this.f1473f.setText(C0312i.m2001a(getApplicationContext(), this.f1477j));
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
