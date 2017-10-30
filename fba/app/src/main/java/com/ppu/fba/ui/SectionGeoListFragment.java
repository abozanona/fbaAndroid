package com.ppu.fba.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import com.ppu.fba.free.R;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p007b.C0292d;
import com.ppu.fba.p007b.C0294f;
import com.ppu.fba.p009d.C0309f;
import com.ppu.fba.p009d.C0313j;
import java.util.HashMap;
import java.util.Objects;

@SuppressLint({"UseSparseArrays"})
public class SectionGeoListFragment extends cd {
    bi f1507P = bi.REGION_ALL;
    bn f1508Q = bn.TODAY;
    Button f1509S;
    private TextView f1510T;
    WebView f1511U;
    ef f1512V;
    ListView Rr;
    private boolean f1513W = false;

    public class WebAppInterface {
        Activity f1503a;
        final /* synthetic */ SectionGeoListFragment f1504b;

        WebAppInterface(SectionGeoListFragment sectionGeoListFragment, Activity activity) {
            this.f1504b = sectionGeoListFragment;
            this.f1503a = activity;
        }

        @JavascriptInterface
        public String getMap() {
            String str = "var gdpData = {";
            FirewallManagerService a = FirewallManagerService.m1852a(null);
            if (a != null) {
                String str2;
                C0294f c0294f = a.f1295d;
                synchronized (c0294f) {
                    str2 = str;
                    Object obj = 1;
                    for (Object str3 : C0309f.m1979b()) {
                        Object obj2;
                        String str4;
                        String str5;
                        if (obj != null) {
                            str5 = str2;
                            obj2 = null;
                            str4 = str5;
                        } else {
                            str5 = str2 + ",";
                            obj2 = obj;
                            str4 = str5;
                        }
                        C0292d c0292d = (C0292d) c0294f.f1370a.get(Integer.valueOf(C0309f.m1982d((String)str3)));
                        str = (c0292d == null || c0292d.f1369c != 2) ? str4 + "\"" + str3 + "\": 0" : str4 + "\"" + str3 + "\": 100";
                        obj = obj2;
                        str2 = str;
                    }
                }
                str = str2;
            }
            return str + "};";
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public View mo749a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = layoutInflater.getContext();
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.activity_list_geo, viewGroup, false);
        ViewPager viewPager = (ViewPager) relativeLayout.findViewById(R.id.geoPager);
        viewPager.setAdapter(new en(this));
        //((DashboardViewPager) m30b().findViewById(R.id.pager)).setChildId(R.id.geoPager);
        TabHost tabHost = (TabHost) relativeLayout.findViewById(R.id.geoTabHost);
        tabHost.setup();
        TabSpec newTabSpec = tabHost.newTabSpec("map");
        newTabSpec.setContent(R.id.geoPager);
        newTabSpec.setIndicator(getContext().getString(R.string.title_section3_map));
        tabHost.addTab(newTabSpec);
        newTabSpec = tabHost.newTabSpec("list");
        newTabSpec.setContent(R.id.geoPager);
        newTabSpec.setIndicator(getContext().getString(R.string.title_section3_list));
        tabHost.addTab(newTabSpec);
        tabHost.setOnTabChangedListener(new be(this, viewPager, layoutInflater));
        viewPager.setOnPageChangeListener(new bf(this, tabHost));
        this.f1511U = (WebView) relativeLayout.findViewById(R.id.webViewCountries);
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.mapEntriesHolder);
        Spinner spinner = (Spinner) relativeLayout.findViewById(R.id.mapType);
        //this.f1512V = new ef(this, m30b());
        this.f1512V.setPadding(0, 0, 0, 0);
        //this.f1512V.setAdapter(new em(this, m30b(), C0309f.m1976a(), new HashMap(), false));
        relativeLayout2.addView(this.f1512V);
        spinner.setOnItemSelectedListener(new bg(this));
        this.f1511U.setBackgroundColor(0);
        this.f1511U.getSettings().setJavaScriptEnabled(true);
        this.f1511U.getSettings().setBuiltInZoomControls(false);
        this.f1511U.setWebChromeClient(new bh(this));
        //this.f1511U.addJavascriptInterface(new WebAppInterface(this, m30b()), "Android");
        this.f1511U.loadUrl("file:///android_asset/worldmap/index.html");
        this.f1511U.setDrawingCacheEnabled(true);
        this.f1509S = (Button) relativeLayout.findViewById(R.id.buttonShare);
        this.f1509S.setOnClickListener(new dz(this));
        this.f1510T = (TextView) relativeLayout.findViewById(R.id.listPro);
        Rr = (ListView) relativeLayout.findViewById(R.id.listItems);
        Rr.setDrawingCacheBackgroundColor(0xFF000000);
        Rr.setScrollbarFadingEnabled(true);
        Rr.setHorizontalFadingEdgeEnabled(true);
        Rr.setVerticalFadingEdgeEnabled(true);
        Rr.setFadingEdgeLength(32);
        this.f1507P = bi.REGION_ALL;
        this.f1508Q = bn.TODAY;
        Spinner spinner2 = (Spinner) relativeLayout.findViewById(R.id.listSpinnerCnts);
        SpinnerAdapter createFromResource = ArrayAdapter.createFromResource(context, R.array.spinner_cnts, R.layout.multiline_spinner_dropdown_item);
        //createFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(createFromResource);
        spinner2.setOnItemSelectedListener(new ea(this));
        spinner2 = (Spinner) relativeLayout.findViewById(R.id.listSpinnerPeriod);
        //createFromResource = ("com.ppu.fba.free".equals(m37c().getString(R.string.package_name)) || !C0313j.m2004a(context)) ? ArrayAdapter.createFromResource(context, R.array.spinner_period, R.multiline_spinner_dropdown_item) : ArrayAdapter.createFromResource(context, R.array.spinner_period_pro, R.multiline_spinner_dropdown_item);
        //createFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(createFromResource);
        spinner2.setOnItemSelectedListener(new eb(this));
        mo750a(context);
        tabHost.setCurrentTab(1);
        viewPager.setCurrentItem(1);
        tabHost.setCurrentTab(0);
        viewPager.setCurrentItem(0);
        new Thread(new ec(this)).start();
        return relativeLayout;
    }

    public ListAdapter mo750a(Context context) {
        switch (dx.f1788a[this.f1507P.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return m2064d(context);
            case 5:
            case 6:
            case 7:
            case 8:
                return m2065e(context);
            default:
                return null;
        }
    }

    public synchronized void mo751a(ListAdapter listAdapter) {
        if (this.f1508Q == bn.THIRTY_DAYS && (Rr == null || "com.ppu.fba.free".equals(getContext().getString(R.string.package_name)) || !C0313j.m2004a(Rr.getContext()))) {
            if (Rr != null) {
                Rr.setVisibility(View.GONE);
            }
            if (this.f1510T != null) {
                this.f1510T.setVisibility(View.VISIBLE);
            }
        } else {
            if (Rr != null) {
                Rr.setVisibility(View.VISIBLE);
            }
            if (this.f1510T != null) {
                this.f1510T.setVisibility(View.GONE);
            }
            if (!(Rr == null || listAdapter == null)) {
                Rr.setAdapter(listAdapter);
            }
            FirewallManagerService a = FirewallManagerService.m1852a(null);
            if (a != null) {
                Object obj;
                C0294f c0294f = a.f1295d;
                synchronized (c0294f) {
                    for (Object c0292d : c0294f.f1370a.values()) {
                        if (((C0292d)c0292d).f1369c == 2) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                }
                if (obj != null) {
                    this.f1509S.setVisibility(View.VISIBLE);
                } else {
                    this.f1509S.setVisibility(View.GONE);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.ListAdapter m2064d(android.content.Context r11) {
        /*
        r10 = this;
        r4 = new java.util.HashMap;
        r4.<init>();
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0 = 0;
        r5 = com.ppu.fba.FirewallManagerService.m1852a(r0);
        if (r5 == 0) goto L_0x0222;
    L_0x0011:
        monitor-enter(r10);
        r4.clear();	 Catch:{ all -> 0x00dd }
        r0 = com.ppu.fba.ui.dx.f1788a;	 Catch:{ all -> 0x00dd }
        r1 = r10.f1507P;	 Catch:{ all -> 0x00dd }
        r1 = r1.ordinal();	 Catch:{ all -> 0x00dd }
        r0 = r0[r1];	 Catch:{ all -> 0x00dd }
        switch(r0) {
            case 1: goto L_0x00e0;
            case 2: goto L_0x0022;
            case 3: goto L_0x00e0;
            case 4: goto L_0x00e0;
            default: goto L_0x0022;
        };	 Catch:{ all -> 0x00dd }
    L_0x0022:
        r6 = new java.util.ArrayList;	 Catch:{ all -> 0x00dd }
        r6.<init>();	 Catch:{ all -> 0x00dd }
        r0 = com.ppu.fba.ui.dx.f1789b;	 Catch:{ all -> 0x00dd }
        r1 = r10.f1508Q;	 Catch:{ all -> 0x00dd }
        r1 = r1.ordinal();	 Catch:{ all -> 0x00dd }
        r0 = r0[r1];	 Catch:{ all -> 0x00dd }
        switch(r0) {
            case 1: goto L_0x00fd;
            case 2: goto L_0x011e;
            case 3: goto L_0x013f;
            default: goto L_0x0034;
        };	 Catch:{ all -> 0x00dd }
    L_0x0034:
        r3 = r5.f1295d;	 Catch:{ all -> 0x00dd }
        monitor-enter(r3);	 Catch:{ all -> 0x00dd }
        r5 = r6.iterator();	 Catch:{ all -> 0x00da }
    L_0x003b:
        r0 = r5.hasNext();	 Catch:{ all -> 0x00da }
        if (r0 == 0) goto L_0x0189;
    L_0x0041:
        r0 = r5.next();	 Catch:{ all -> 0x00da }
        r0 = (com.ppu.fba.p008c.C0297b) r0;	 Catch:{ all -> 0x00da }
        r1 = r0.m1943b();	 Catch:{ all -> 0x00da }
        r6 = r1.iterator();	 Catch:{ all -> 0x00da }
    L_0x004f:
        r1 = r6.hasNext();	 Catch:{ all -> 0x00da }
        if (r1 == 0) goto L_0x003b;
    L_0x0055:
        r1 = r6.next();	 Catch:{ all -> 0x00da }
        r1 = (java.lang.Integer) r1;	 Catch:{ all -> 0x00da }
        r2 = r3.f1370a;	 Catch:{ all -> 0x00da }
        r2 = r2.get(r1);	 Catch:{ all -> 0x00da }
        r2 = (com.ppu.fba.p007b.C0292d) r2;	 Catch:{ all -> 0x00da }
        r7 = r1.intValue();	 Catch:{ all -> 0x00da }
        r7 = com.ppu.fba.p009d.C0309f.m1974a(r7);	 Catch:{ all -> 0x00da }
        r7 = com.ppu.fba.p009d.C0309f.m1975a(r7);	 Catch:{ all -> 0x00da }
        r8 = com.ppu.fba.ui.dx.f1788a;	 Catch:{ all -> 0x00da }
        r9 = r10.f1507P;	 Catch:{ all -> 0x00da }
        r9 = r9.ordinal();	 Catch:{ all -> 0x00da }
        r8 = r8[r9];	 Catch:{ all -> 0x00da }
        switch(r8) {
            case 3: goto L_0x0178;
            case 4: goto L_0x0180;
            default: goto L_0x007c;
        };	 Catch:{ all -> 0x00da }
    L_0x007c:
        r1 = r1.intValue();	 Catch:{ all -> 0x00da }
        r2 = r0.m1946c(r1);	 Catch:{ all -> 0x00da }
        r1 = r4.get(r7);	 Catch:{ all -> 0x00da }
        r1 = (com.ppu.fba.p008c.C0298c) r1;	 Catch:{ all -> 0x00da }
        if (r1 != 0) goto L_0x00b3;
    L_0x008c:
        r1 = r10.f1507P;	 Catch:{ all -> 0x00da }
        r8 = com.ppu.fba.ui.bi.REGION_SEEN;	 Catch:{ all -> 0x00da }
        if (r1 != r8) goto L_0x00ae;
    L_0x0092:
        r1 = r2.f1380c;	 Catch:{ all -> 0x00da }
        if (r1 != 0) goto L_0x00ae;
    L_0x0096:
        r1 = r2.f1381d;	 Catch:{ all -> 0x00da }
        if (r1 != 0) goto L_0x00ae;
    L_0x009a:
        r1 = r2.f1378a;	 Catch:{ all -> 0x00da }
        r8 = java.math.BigInteger.ZERO;	 Catch:{ all -> 0x00da }
        r1 = r1.equals(r8);	 Catch:{ all -> 0x00da }
        if (r1 == 0) goto L_0x00ae;
    L_0x00a4:
        r1 = r2.f1379b;	 Catch:{ all -> 0x00da }
        r8 = java.math.BigInteger.ZERO;	 Catch:{ all -> 0x00da }
        r1 = r1.equals(r8);	 Catch:{ all -> 0x00da }
        if (r1 != 0) goto L_0x004f;
    L_0x00ae:
        r1 = new com.ppu.fba.c.g;	 Catch:{ all -> 0x00da }
        r1.<init>();	 Catch:{ all -> 0x00da }
    L_0x00b3:
        r8 = r1.f1378a;	 Catch:{ all -> 0x00da }
        r9 = r2.f1378a;	 Catch:{ all -> 0x00da }
        r8 = r8.add(r9);	 Catch:{ all -> 0x00da }
        r1.f1378a = r8;	 Catch:{ all -> 0x00da }
        r8 = r1.f1379b;	 Catch:{ all -> 0x00da }
        r9 = r2.f1379b;	 Catch:{ all -> 0x00da }
        r8 = r8.add(r9);	 Catch:{ all -> 0x00da }
        r1.f1379b = r8;	 Catch:{ all -> 0x00da }
        r8 = r1.f1380c;	 Catch:{ all -> 0x00da }
        r9 = r2.f1380c;	 Catch:{ all -> 0x00da }
        r8 = r8 + r9;
        r1.f1380c = r8;	 Catch:{ all -> 0x00da }
        r8 = r1.f1381d;	 Catch:{ all -> 0x00da }
        r2 = r2.f1381d;	 Catch:{ all -> 0x00da }
        r2 = r2 + r8;
        r1.f1381d = r2;	 Catch:{ all -> 0x00da }
        r4.put(r7, r1);	 Catch:{ all -> 0x00da }
        goto L_0x004f;
    L_0x00da:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00da }
        throw r0;	 Catch:{ all -> 0x00dd }
    L_0x00dd:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x00dd }
        throw r0;
    L_0x00e0:
        r0 = com.ppu.fba.p009d.C0309f.m1976a();	 Catch:{ all -> 0x00dd }
        r1 = r0.iterator();	 Catch:{ all -> 0x00dd }
    L_0x00e8:
        r0 = r1.hasNext();	 Catch:{ all -> 0x00dd }
        if (r0 == 0) goto L_0x0022;
    L_0x00ee:
        r0 = r1.next();	 Catch:{ all -> 0x00dd }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x00dd }
        r2 = new com.ppu.fba.c.g;	 Catch:{ all -> 0x00dd }
        r2.<init>();	 Catch:{ all -> 0x00dd }
        r4.put(r0, r2);	 Catch:{ all -> 0x00dd }
        goto L_0x00e8;
    L_0x00fd:
        r2 = com.ppu.fba.p008c.C0296a.m1929b();	 Catch:{ all -> 0x00dd }
        r7 = r5.f1297f;	 Catch:{ all -> 0x00dd }
        monitor-enter(r7);	 Catch:{ all -> 0x00dd }
        r0 = r2;
    L_0x0105:
        r8 = 24;
        r8 = r2 - r8;
        r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r8 <= 0) goto L_0x0118;
    L_0x010d:
        r8 = r7.m1952a(r0);	 Catch:{ all -> 0x011b }
        r6.add(r8);	 Catch:{ all -> 0x011b }
        r8 = 1;
        r0 = r0 - r8;
        goto L_0x0105;
    L_0x0118:
        monitor-exit(r7);	 Catch:{ all -> 0x011b }
        goto L_0x0034;
    L_0x011b:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x011b }
        throw r0;	 Catch:{ all -> 0x00dd }
    L_0x011e:
        r2 = com.ppu.fba.p008c.C0296a.m1928a();	 Catch:{ all -> 0x00dd }
        r7 = r5.f1296e;	 Catch:{ all -> 0x00dd }
        monitor-enter(r7);	 Catch:{ all -> 0x00dd }
        r0 = r2;
    L_0x0126:
        r8 = 10;
        r8 = r2 - r8;
        r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r8 <= 0) goto L_0x0139;
    L_0x012e:
        r8 = r7.m1952a(r0);	 Catch:{ all -> 0x013c }
        r6.add(r8);	 Catch:{ all -> 0x013c }
        r8 = 1;
        r0 = r0 - r8;
        goto L_0x0126;
    L_0x0139:
        monitor-exit(r7);	 Catch:{ all -> 0x013c }
        goto L_0x0034;
    L_0x013c:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x013c }
        throw r0;	 Catch:{ all -> 0x00dd }
    L_0x013f:
        r2 = com.ppu.fba.p008c.C0296a.m1928a();	 Catch:{ all -> 0x00dd }
        r0 = "com.ppu.fba.free";
        r1 = r10.m37c();	 Catch:{ all -> 0x00dd }
        r7 = com.ppu.fba.R.string.package_name;	 Catch:{ all -> 0x00dd }
        r1 = r1.getString(r7);	 Catch:{ all -> 0x00dd }
        r0 = r0.equals(r1);	 Catch:{ all -> 0x00dd }
        if (r0 != 0) goto L_0x0034;
    L_0x0155:
        r0 = com.ppu.fba.p009d.C0313j.m2004a(r11);	 Catch:{ all -> 0x00dd }
        if (r0 == 0) goto L_0x0034;
    L_0x015b:
        r7 = r5.f1296e;	 Catch:{ all -> 0x00dd }
        monitor-enter(r7);	 Catch:{ all -> 0x00dd }
        r0 = r2;
    L_0x015f:
        r8 = 30;
        r8 = r2 - r8;
        r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r8 <= 0) goto L_0x0172;
    L_0x0167:
        r8 = r7.m1952a(r0);	 Catch:{ all -> 0x0175 }
        r6.add(r8);	 Catch:{ all -> 0x0175 }
        r8 = 1;
        r0 = r0 - r8;
        goto L_0x015f;
    L_0x0172:
        monitor-exit(r7);	 Catch:{ all -> 0x0175 }
        goto L_0x0034;
    L_0x0175:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0175 }
        throw r0;	 Catch:{ all -> 0x00dd }
    L_0x0178:
        if (r2 == 0) goto L_0x007c;
    L_0x017a:
        r2 = r2.f1369c;	 Catch:{ all -> 0x00da }
        if (r2 == 0) goto L_0x007c;
    L_0x017e:
        goto L_0x004f;
    L_0x0180:
        if (r2 == 0) goto L_0x004f;
    L_0x0182:
        r2 = r2.f1369c;	 Catch:{ all -> 0x00da }
        r8 = 2;
        if (r2 == r8) goto L_0x007c;
    L_0x0187:
        goto L_0x004f;
    L_0x0189:
        monitor-exit(r3);	 Catch:{ all -> 0x00da }
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x00dd }
        r1 = r4.keySet();	 Catch:{ all -> 0x00dd }
        r0.<init>(r1);	 Catch:{ all -> 0x00dd }
        r1 = r10.f1507P;	 Catch:{ all -> 0x00dd }
        r2 = com.ppu.fba.ui.bi.REGION_ALLOWED;	 Catch:{ all -> 0x00dd }
        if (r1 == r2) goto L_0x019f;
    L_0x0199:
        r1 = r10.f1507P;	 Catch:{ all -> 0x00dd }
        r2 = com.ppu.fba.ui.bi.REGION_BLOCKED;	 Catch:{ all -> 0x00dd }
        if (r1 != r2) goto L_0x0207;
    L_0x019f:
        r5 = r0.iterator();	 Catch:{ all -> 0x00dd }
    L_0x01a3:
        r0 = r5.hasNext();	 Catch:{ all -> 0x00dd }
        if (r0 == 0) goto L_0x0207;
    L_0x01a9:
        r0 = r5.next();	 Catch:{ all -> 0x00dd }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x00dd }
        r2 = 1;
        r1 = com.ppu.fba.p009d.C0309f.m1978b(r0);	 Catch:{ all -> 0x00dd }
        r6 = r1.iterator();	 Catch:{ all -> 0x00dd }
    L_0x01b8:
        r1 = r6.hasNext();	 Catch:{ all -> 0x00dd }
        if (r1 == 0) goto L_0x022b;
    L_0x01be:
        r1 = r6.next();	 Catch:{ all -> 0x00dd }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x00dd }
        r1 = com.ppu.fba.p009d.C0309f.m1982d(r1);	 Catch:{ all -> 0x00dd }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x00dd }
        r7 = r3.f1370a;	 Catch:{ all -> 0x00dd }
        r1 = r1.intValue();	 Catch:{ all -> 0x00dd }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x00dd }
        r1 = r7.get(r1);	 Catch:{ all -> 0x00dd }
        r1 = (com.ppu.fba.p007b.C0292d) r1;	 Catch:{ all -> 0x00dd }
        r7 = com.ppu.fba.ui.dx.f1788a;	 Catch:{ all -> 0x00dd }
        r8 = r10.f1507P;	 Catch:{ all -> 0x00dd }
        r8 = r8.ordinal();	 Catch:{ all -> 0x00dd }
        r7 = r7[r8];	 Catch:{ all -> 0x00dd }
        switch(r7) {
            case 3: goto L_0x01f2;
            case 4: goto L_0x01fb;
            default: goto L_0x01e9;
        };	 Catch:{ all -> 0x00dd }
    L_0x01e9:
        r1 = r2;
    L_0x01ea:
        if (r1 != 0) goto L_0x0205;
    L_0x01ec:
        if (r1 == 0) goto L_0x01a3;
    L_0x01ee:
        r4.remove(r0);	 Catch:{ all -> 0x00dd }
        goto L_0x01a3;
    L_0x01f2:
        if (r1 == 0) goto L_0x01f8;
    L_0x01f4:
        r1 = r1.f1369c;	 Catch:{ all -> 0x00dd }
        if (r1 != 0) goto L_0x01e9;
    L_0x01f8:
        r2 = 0;
        r1 = r2;
        goto L_0x01ea;
    L_0x01fb:
        if (r1 == 0) goto L_0x01e9;
    L_0x01fd:
        r1 = r1.f1369c;	 Catch:{ all -> 0x00dd }
        r7 = 2;
        if (r1 != r7) goto L_0x01e9;
    L_0x0202:
        r2 = 0;
        r1 = r2;
        goto L_0x01ea;
    L_0x0205:
        r2 = r1;
        goto L_0x01b8;
    L_0x0207:
        r3 = new java.util.ArrayList;	 Catch:{ all -> 0x00dd }
        r0 = r4.keySet();	 Catch:{ all -> 0x00dd }
        r3.<init>(r0);	 Catch:{ all -> 0x00dd }
        r0 = new com.ppu.fba.ui.ed;	 Catch:{ all -> 0x00dd }
        r0.<init>(r10, r4);	 Catch:{ all -> 0x00dd }
        java.util.Collections.sort(r3, r0);	 Catch:{ all -> 0x00dd }
        monitor-exit(r10);	 Catch:{ all -> 0x00dd }
        r0 = new com.ppu.fba.ui.em;
        r5 = 1;
        r1 = r10;
        r2 = r11;
        r0.<init>(r1, r2, r3, r4, r5);
    L_0x0221:
        return r0;
    L_0x0222:
        r0 = "SectionGeoListFragment";
        r1 = "NO MANAGER !!!!";
        com.ppu.fba.p009d.Log1.LogF1(r0, r1);
        r0 = 0;
        goto L_0x0221;
    L_0x022b:
        r1 = r2;
        goto L_0x01ec;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ppu.fba.ui.SectionGeoListFragment.d(android.content.Context):android.widget.ListAdapter");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.ListAdapter m2065e(android.content.Context r15) {
        /*
        r14 = this;
        r0 = 0;
        r13 = 2;
        r11 = 1;
        r4 = new java.util.HashMap;
        r4.<init>();
        r3 = new java.util.ArrayList;
        r3.<init>();
        r2 = com.ppu.fba.FirewallManagerService.m1852a(r0);
        if (r2 == 0) goto L_0x01fa;
    L_0x0014:
        monitor-enter(r14);
        r4.clear();	 Catch:{ all -> 0x00dc }
        r0 = com.ppu.fba.ui.dx.f1788a;	 Catch:{ all -> 0x00dc }
        r1 = r14.f1507P;	 Catch:{ all -> 0x00dc }
        r1 = r1.ordinal();	 Catch:{ all -> 0x00dc }
        r0 = r0[r1];	 Catch:{ all -> 0x00dc }
        switch(r0) {
            case 5: goto L_0x00df;
            case 6: goto L_0x0025;
            case 7: goto L_0x00df;
            case 8: goto L_0x00df;
            default: goto L_0x0025;
        };	 Catch:{ all -> 0x00dc }
    L_0x0025:
        r7 = new java.util.ArrayList;	 Catch:{ all -> 0x00dc }
        r7.<init>();	 Catch:{ all -> 0x00dc }
        r0 = com.ppu.fba.ui.dx.f1789b;	 Catch:{ all -> 0x00dc }
        r1 = r14.f1508Q;	 Catch:{ all -> 0x00dc }
        r1 = r1.ordinal();	 Catch:{ all -> 0x00dc }
        r0 = r0[r1];	 Catch:{ all -> 0x00dc }
        switch(r0) {
            case 1: goto L_0x00fc;
            case 2: goto L_0x011b;
            case 3: goto L_0x013a;
            default: goto L_0x0037;
        };	 Catch:{ all -> 0x00dc }
    L_0x0037:
        r5 = r2.f1295d;	 Catch:{ all -> 0x00dc }
        monitor-enter(r5);	 Catch:{ all -> 0x00dc }
        r6 = r7.iterator();	 Catch:{ all -> 0x00d9 }
    L_0x003e:
        r0 = r6.hasNext();	 Catch:{ all -> 0x00d9 }
        if (r0 == 0) goto L_0x0181;
    L_0x0044:
        r0 = r6.next();	 Catch:{ all -> 0x00d9 }
        r0 = (com.ppu.fba.p008c.C0297b) r0;	 Catch:{ all -> 0x00d9 }
        r1 = r0.m1943b();	 Catch:{ all -> 0x00d9 }
        r7 = r1.iterator();	 Catch:{ all -> 0x00d9 }
    L_0x0052:
        r1 = r7.hasNext();	 Catch:{ all -> 0x00d9 }
        if (r1 == 0) goto L_0x003e;
    L_0x0058:
        r1 = r7.next();	 Catch:{ all -> 0x00d9 }
        r1 = (java.lang.Integer) r1;	 Catch:{ all -> 0x00d9 }
        r2 = r5.f1370a;	 Catch:{ all -> 0x00d9 }
        r2 = r2.get(r1);	 Catch:{ all -> 0x00d9 }
        r2 = (com.ppu.fba.p007b.C0292d) r2;	 Catch:{ all -> 0x00d9 }
        r8 = r1.intValue();	 Catch:{ all -> 0x00d9 }
        r8 = com.ppu.fba.p009d.C0309f.m1974a(r8);	 Catch:{ all -> 0x00d9 }
        r9 = com.ppu.fba.ui.dx.f1788a;	 Catch:{ all -> 0x00d9 }
        r10 = r14.f1507P;	 Catch:{ all -> 0x00d9 }
        r10 = r10.ordinal();	 Catch:{ all -> 0x00d9 }
        r9 = r9[r10];	 Catch:{ all -> 0x00d9 }
        switch(r9) {
            case 7: goto L_0x0171;
            case 8: goto L_0x0179;
            default: goto L_0x007b;
        };	 Catch:{ all -> 0x00d9 }
    L_0x007b:
        r1 = r1.intValue();	 Catch:{ all -> 0x00d9 }
        r2 = r0.m1946c(r1);	 Catch:{ all -> 0x00d9 }
        r1 = r4.get(r8);	 Catch:{ all -> 0x00d9 }
        r1 = (com.ppu.fba.p008c.C0298c) r1;	 Catch:{ all -> 0x00d9 }
        if (r1 != 0) goto L_0x00b2;
    L_0x008b:
        r1 = r14.f1507P;	 Catch:{ all -> 0x00d9 }
        r9 = com.ppu.fba.ui.bi.COUNTRY_SEEN;	 Catch:{ all -> 0x00d9 }
        if (r1 != r9) goto L_0x00ad;
    L_0x0091:
        r1 = r2.f1380c;	 Catch:{ all -> 0x00d9 }
        if (r1 != 0) goto L_0x00ad;
    L_0x0095:
        r1 = r2.f1381d;	 Catch:{ all -> 0x00d9 }
        if (r1 != 0) goto L_0x00ad;
    L_0x0099:
        r1 = r2.f1378a;	 Catch:{ all -> 0x00d9 }
        r9 = java.math.BigInteger.ZERO;	 Catch:{ all -> 0x00d9 }
        r1 = r1.equals(r9);	 Catch:{ all -> 0x00d9 }
        if (r1 == 0) goto L_0x00ad;
    L_0x00a3:
        r1 = r2.f1379b;	 Catch:{ all -> 0x00d9 }
        r9 = java.math.BigInteger.ZERO;	 Catch:{ all -> 0x00d9 }
        r1 = r1.equals(r9);	 Catch:{ all -> 0x00d9 }
        if (r1 != 0) goto L_0x0052;
    L_0x00ad:
        r1 = new com.ppu.fba.c.g;	 Catch:{ all -> 0x00d9 }
        r1.<init>();	 Catch:{ all -> 0x00d9 }
    L_0x00b2:
        r9 = r1.f1378a;	 Catch:{ all -> 0x00d9 }
        r10 = r2.f1378a;	 Catch:{ all -> 0x00d9 }
        r9 = r9.add(r10);	 Catch:{ all -> 0x00d9 }
        r1.f1378a = r9;	 Catch:{ all -> 0x00d9 }
        r9 = r1.f1379b;	 Catch:{ all -> 0x00d9 }
        r10 = r2.f1379b;	 Catch:{ all -> 0x00d9 }
        r9 = r9.add(r10);	 Catch:{ all -> 0x00d9 }
        r1.f1379b = r9;	 Catch:{ all -> 0x00d9 }
        r9 = r1.f1380c;	 Catch:{ all -> 0x00d9 }
        r10 = r2.f1380c;	 Catch:{ all -> 0x00d9 }
        r9 = r9 + r10;
        r1.f1380c = r9;	 Catch:{ all -> 0x00d9 }
        r9 = r1.f1381d;	 Catch:{ all -> 0x00d9 }
        r2 = r2.f1381d;	 Catch:{ all -> 0x00d9 }
        r2 = r2 + r9;
        r1.f1381d = r2;	 Catch:{ all -> 0x00d9 }
        r4.put(r8, r1);	 Catch:{ all -> 0x00d9 }
        goto L_0x0052;
    L_0x00d9:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x00d9 }
        throw r0;	 Catch:{ all -> 0x00dc }
    L_0x00dc:
        r0 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x00dc }
        throw r0;
    L_0x00df:
        r0 = com.ppu.fba.p009d.C0309f.m1979b();	 Catch:{ all -> 0x00dc }
        r1 = r0.iterator();	 Catch:{ all -> 0x00dc }
    L_0x00e7:
        r0 = r1.hasNext();	 Catch:{ all -> 0x00dc }
        if (r0 == 0) goto L_0x0025;
    L_0x00ed:
        r0 = r1.next();	 Catch:{ all -> 0x00dc }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x00dc }
        r5 = new com.ppu.fba.c.g;	 Catch:{ all -> 0x00dc }
        r5.<init>();	 Catch:{ all -> 0x00dc }
        r4.put(r0, r5);	 Catch:{ all -> 0x00dc }
        goto L_0x00e7;
    L_0x00fc:
        r5 = com.ppu.fba.p008c.C0296a.m1929b();	 Catch:{ all -> 0x00dc }
        r8 = r2.f1297f;	 Catch:{ all -> 0x00dc }
        monitor-enter(r8);	 Catch:{ all -> 0x00dc }
        r0 = r5;
    L_0x0104:
        r9 = 24;
        r9 = r5 - r9;
        r9 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r9 <= 0) goto L_0x0115;
    L_0x010c:
        r9 = r8.m1952a(r0);	 Catch:{ all -> 0x0118 }
        r7.add(r9);	 Catch:{ all -> 0x0118 }
        r0 = r0 - r11;
        goto L_0x0104;
    L_0x0115:
        monitor-exit(r8);	 Catch:{ all -> 0x0118 }
        goto L_0x0037;
    L_0x0118:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0118 }
        throw r0;	 Catch:{ all -> 0x00dc }
    L_0x011b:
        r5 = com.ppu.fba.p008c.C0296a.m1928a();	 Catch:{ all -> 0x00dc }
        r8 = r2.f1296e;	 Catch:{ all -> 0x00dc }
        monitor-enter(r8);	 Catch:{ all -> 0x00dc }
        r0 = r5;
    L_0x0123:
        r9 = 10;
        r9 = r5 - r9;
        r9 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r9 <= 0) goto L_0x0134;
    L_0x012b:
        r9 = r8.m1952a(r0);	 Catch:{ all -> 0x0137 }
        r7.add(r9);	 Catch:{ all -> 0x0137 }
        r0 = r0 - r11;
        goto L_0x0123;
    L_0x0134:
        monitor-exit(r8);	 Catch:{ all -> 0x0137 }
        goto L_0x0037;
    L_0x0137:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0137 }
        throw r0;	 Catch:{ all -> 0x00dc }
    L_0x013a:
        r5 = com.ppu.fba.p008c.C0296a.m1928a();	 Catch:{ all -> 0x00dc }
        r0 = "com.ppu.fba.free";
        r1 = r14.m37c();	 Catch:{ all -> 0x00dc }
        r8 = com.ppu.fba.R.string.package_name;	 Catch:{ all -> 0x00dc }
        r1 = r1.getString(r8);	 Catch:{ all -> 0x00dc }
        r0 = r0.equals(r1);	 Catch:{ all -> 0x00dc }
        if (r0 != 0) goto L_0x0037;
    L_0x0150:
        r0 = com.ppu.fba.p009d.C0313j.m2004a(r15);	 Catch:{ all -> 0x00dc }
        if (r0 == 0) goto L_0x0037;
    L_0x0156:
        r8 = r2.f1296e;	 Catch:{ all -> 0x00dc }
        monitor-enter(r8);	 Catch:{ all -> 0x00dc }
        r0 = r5;
    L_0x015a:
        r9 = 30;
        r9 = r5 - r9;
        r9 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r9 <= 0) goto L_0x016b;
    L_0x0162:
        r9 = r8.m1952a(r0);	 Catch:{ all -> 0x016e }
        r7.add(r9);	 Catch:{ all -> 0x016e }
        r0 = r0 - r11;
        goto L_0x015a;
    L_0x016b:
        monitor-exit(r8);	 Catch:{ all -> 0x016e }
        goto L_0x0037;
    L_0x016e:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x016e }
        throw r0;	 Catch:{ all -> 0x00dc }
    L_0x0171:
        if (r2 == 0) goto L_0x007b;
    L_0x0173:
        r2 = r2.f1369c;	 Catch:{ all -> 0x00d9 }
        if (r2 == 0) goto L_0x007b;
    L_0x0177:
        goto L_0x0052;
    L_0x0179:
        if (r2 == 0) goto L_0x0052;
    L_0x017b:
        r2 = r2.f1369c;	 Catch:{ all -> 0x00d9 }
        if (r2 == r13) goto L_0x007b;
    L_0x017f:
        goto L_0x0052;
    L_0x0181:
        monitor-exit(r5);	 Catch:{ all -> 0x00d9 }
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x00dc }
        r1 = r4.keySet();	 Catch:{ all -> 0x00dc }
        r0.<init>(r1);	 Catch:{ all -> 0x00dc }
        r1 = r14.f1507P;	 Catch:{ all -> 0x00dc }
        r2 = com.ppu.fba.ui.bi.COUNTRY_ALLOWED;	 Catch:{ all -> 0x00dc }
        if (r1 == r2) goto L_0x0197;
    L_0x0191:
        r1 = r14.f1507P;	 Catch:{ all -> 0x00dc }
        r2 = com.ppu.fba.ui.bi.COUNTRY_BLOCKED;	 Catch:{ all -> 0x00dc }
        if (r1 != r2) goto L_0x01e1;
    L_0x0197:
        r2 = r0.iterator();	 Catch:{ all -> 0x00dc }
    L_0x019b:
        r0 = r2.hasNext();	 Catch:{ all -> 0x00dc }
        if (r0 == 0) goto L_0x01e1;
    L_0x01a1:
        r0 = r2.next();	 Catch:{ all -> 0x00dc }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x00dc }
        r1 = com.ppu.fba.p009d.C0309f.m1982d(r0);	 Catch:{ all -> 0x00dc }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x00dc }
        r6 = r5.f1370a;	 Catch:{ all -> 0x00dc }
        r1 = r1.intValue();	 Catch:{ all -> 0x00dc }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x00dc }
        r1 = r6.get(r1);	 Catch:{ all -> 0x00dc }
        r1 = (com.ppu.fba.p007b.C0292d) r1;	 Catch:{ all -> 0x00dc }
        r6 = com.ppu.fba.ui.dx.f1788a;	 Catch:{ all -> 0x00dc }
        r7 = r14.f1507P;	 Catch:{ all -> 0x00dc }
        r7 = r7.ordinal();	 Catch:{ all -> 0x00dc }
        r6 = r6[r7];	 Catch:{ all -> 0x00dc }
        switch(r6) {
            case 7: goto L_0x01cd;
            case 8: goto L_0x01d7;
            default: goto L_0x01cc;
        };	 Catch:{ all -> 0x00dc }
    L_0x01cc:
        goto L_0x019b;
    L_0x01cd:
        if (r1 == 0) goto L_0x019b;
    L_0x01cf:
        r1 = r1.f1369c;	 Catch:{ all -> 0x00dc }
        if (r1 == 0) goto L_0x019b;
    L_0x01d3:
        r4.remove(r0);	 Catch:{ all -> 0x00dc }
        goto L_0x019b;
    L_0x01d7:
        if (r1 == 0) goto L_0x01dd;
    L_0x01d9:
        r1 = r1.f1369c;	 Catch:{ all -> 0x00dc }
        if (r1 == r13) goto L_0x019b;
    L_0x01dd:
        r4.remove(r0);	 Catch:{ all -> 0x00dc }
        goto L_0x019b;
    L_0x01e1:
        r0 = r4.keySet();	 Catch:{ all -> 0x00dc }
        r3.addAll(r0);	 Catch:{ all -> 0x00dc }
        r0 = new com.ppu.fba.ui.dw;	 Catch:{ all -> 0x00dc }
        r0.<init>(r14, r4);	 Catch:{ all -> 0x00dc }
        java.util.Collections.sort(r3, r0);	 Catch:{ all -> 0x00dc }
        monitor-exit(r14);	 Catch:{ all -> 0x00dc }
        r0 = new com.ppu.fba.ui.ee;
        r5 = 1;
        r1 = r14;
        r2 = r15;
        r0.<init>(r1, r2, r3, r4, r5);
    L_0x01f9:
        return r0;
    L_0x01fa:
        r1 = "SectionGeoListFragment";
        r2 = "NO MANAGER !!!!";
        com.ppu.fba.p009d.Log1.LogF1(r1, r2);
        goto L_0x01f9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ppu.fba.ui.SectionGeoListFragment.e(android.content.Context):android.widget.ListAdapter");
    }
}
