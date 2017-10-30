package com.ppu.fba.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.C0313j;

@SuppressLint({"UseSparseArrays"})
public class ad extends cd {
    ah f1561P = ah.DOWNLOADED;
    an f1562Q = an.TODAY;
    private TextView f1563T;

    public View mo749a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = layoutInflater.getContext();
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.activity_list_app, viewGroup, false);
        this.f1563T = (TextView) relativeLayout.findViewById(R.id.listPro);
        this.R = (ListView) relativeLayout.findViewById(R.id.listItems);
        this.R.setDrawingCacheBackgroundColor(-16777216);
        this.R.setScrollbarFadingEnabled(true);
        this.R.setHorizontalFadingEdgeEnabled(true);
        this.R.setVerticalFadingEdgeEnabled(true);
        this.R.setFadingEdgeLength(32);
        this.f1561P = ah.ALL;
        this.f1562Q = an.TODAY;
        Spinner spinner = (Spinner) relativeLayout.findViewById(R.id.listSpinnerApps);
        SpinnerAdapter createFromResource = ArrayAdapter.createFromResource(context, R.array.spinner_apps, R.layout.multiline_spinner_dropdown_item);
        createFromResource.setDropDownViewResource(17367049);
        spinner.setAdapter(createFromResource);
        spinner.setSelection(ah.DOWNLOADED.ordinal());
        spinner.setOnItemSelectedListener(new ae(this));
        spinner = (Spinner) relativeLayout.findViewById(R.id.listSpinnerPeriod);
        createFromResource = ("com.ppu.fba.free".equals(m37c().getString(R.string.package_name)) || !C0313j.m2004a(context)) ? ArrayAdapter.createFromResource(context, R.array.spinner_period, R.multiline_spinner_dropdown_item) : ArrayAdapter.createFromResource(context, R.array.spinner_period_pro, R.multiline_spinner_dropdown_item);
        createFromResource.setDropDownViewResource(17367049);
        spinner.setAdapter(createFromResource);
        spinner.setOnItemSelectedListener(new af(this));
        mo750a(context);
        return relativeLayout;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.ListAdapter mo750a(android.content.Context r14) {
        /*
        r13 = this;
        r0 = r14.getApplicationInfo();
        r4 = r0.uid;
        r5 = new java.util.HashMap;
        r5.<init>();
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0 = 0;
        r6 = com.ppu.fba.FirewallManagerService.m1852a(r0);
        if (r6 == 0) goto L_0x023b;
    L_0x0017:
        monitor-enter(r13);
        r5.clear();	 Catch:{ all -> 0x00c3 }
        r0 = com.ppu.fba.ui.dr.f1779a;	 Catch:{ all -> 0x00c3 }
        r1 = r13.f1561P;	 Catch:{ all -> 0x00c3 }
        r1 = r1.ordinal();	 Catch:{ all -> 0x00c3 }
        r0 = r0[r1];	 Catch:{ all -> 0x00c3 }
        switch(r0) {
            case 1: goto L_0x00c6;
            case 2: goto L_0x00c6;
            case 3: goto L_0x00c6;
            case 4: goto L_0x00c6;
            case 5: goto L_0x00e3;
            case 6: goto L_0x0100;
            default: goto L_0x0028;
        };	 Catch:{ all -> 0x00c3 }
    L_0x0028:
        r7 = new java.util.ArrayList;	 Catch:{ all -> 0x00c3 }
        r7.<init>();	 Catch:{ all -> 0x00c3 }
        r0 = com.ppu.fba.ui.dr.f1780b;	 Catch:{ all -> 0x00c3 }
        r1 = r13.f1562Q;	 Catch:{ all -> 0x00c3 }
        r1 = r1.ordinal();	 Catch:{ all -> 0x00c3 }
        r0 = r0[r1];	 Catch:{ all -> 0x00c3 }
        switch(r0) {
            case 1: goto L_0x011d;
            case 2: goto L_0x013e;
            case 3: goto L_0x015f;
            default: goto L_0x003a;
        };	 Catch:{ all -> 0x00c3 }
    L_0x003a:
        r8 = com.ppu.fba.p009d.C0308e.m1969b();	 Catch:{ all -> 0x00c3 }
        r9 = com.ppu.fba.p009d.C0308e.m1971c();	 Catch:{ all -> 0x00c3 }
        r6 = r6.f1294c;	 Catch:{ all -> 0x00c3 }
        monitor-enter(r6);	 Catch:{ all -> 0x00c3 }
        r7 = r7.iterator();	 Catch:{ all -> 0x00c0 }
    L_0x0049:
        r0 = r7.hasNext();	 Catch:{ all -> 0x00c0 }
        if (r0 == 0) goto L_0x01bc;
    L_0x004f:
        r0 = r7.next();	 Catch:{ all -> 0x00c0 }
        r0 = (com.ppu.fba.p008c.C0297b) r0;	 Catch:{ all -> 0x00c0 }
        r1 = r0.m1937a();	 Catch:{ all -> 0x00c0 }
        r10 = r1.iterator();	 Catch:{ all -> 0x00c0 }
    L_0x005d:
        r1 = r10.hasNext();	 Catch:{ all -> 0x00c0 }
        if (r1 == 0) goto L_0x0049;
    L_0x0063:
        r1 = r10.next();	 Catch:{ all -> 0x00c0 }
        r1 = (java.lang.Integer) r1;	 Catch:{ all -> 0x00c0 }
        r2 = r6.f1366a;	 Catch:{ all -> 0x00c0 }
        r2 = r2.get(r1);	 Catch:{ all -> 0x00c0 }
        r2 = (com.ppu.fba.p007b.C0289a) r2;	 Catch:{ all -> 0x00c0 }
        r3 = 0;
        if (r2 == 0) goto L_0x0078;
    L_0x0074:
        r3 = r2.m1919a();	 Catch:{ all -> 0x00c0 }
    L_0x0078:
        r11 = com.ppu.fba.ui.dr.f1779a;	 Catch:{ all -> 0x00c0 }
        r12 = r13.f1561P;	 Catch:{ all -> 0x00c0 }
        r12 = r12.ordinal();	 Catch:{ all -> 0x00c0 }
        r11 = r11[r12];	 Catch:{ all -> 0x00c0 }
        switch(r11) {
            case 2: goto L_0x01a8;
            case 3: goto L_0x01ae;
            case 4: goto L_0x01b5;
            case 5: goto L_0x0198;
            case 6: goto L_0x01a0;
            default: goto L_0x0085;
        };	 Catch:{ all -> 0x00c0 }
    L_0x0085:
        r2 = r5.get(r1);	 Catch:{ all -> 0x00c0 }
        r2 = (com.ppu.fba.p008c.C0298c) r2;	 Catch:{ all -> 0x00c0 }
        if (r2 != 0) goto L_0x0092;
    L_0x008d:
        r2 = new com.ppu.fba.c.g;	 Catch:{ all -> 0x00c0 }
        r2.<init>();	 Catch:{ all -> 0x00c0 }
    L_0x0092:
        r3 = r1.intValue();	 Catch:{ all -> 0x00c0 }
        r3 = r0.m1935a(r3);	 Catch:{ all -> 0x00c0 }
        r11 = r2.f1378a;	 Catch:{ all -> 0x00c0 }
        r12 = r3.f1378a;	 Catch:{ all -> 0x00c0 }
        r11 = r11.add(r12);	 Catch:{ all -> 0x00c0 }
        r2.f1378a = r11;	 Catch:{ all -> 0x00c0 }
        r11 = r2.f1379b;	 Catch:{ all -> 0x00c0 }
        r12 = r3.f1379b;	 Catch:{ all -> 0x00c0 }
        r11 = r11.add(r12);	 Catch:{ all -> 0x00c0 }
        r2.f1379b = r11;	 Catch:{ all -> 0x00c0 }
        r11 = r2.f1380c;	 Catch:{ all -> 0x00c0 }
        r12 = r3.f1380c;	 Catch:{ all -> 0x00c0 }
        r11 = r11 + r12;
        r2.f1380c = r11;	 Catch:{ all -> 0x00c0 }
        r11 = r2.f1381d;	 Catch:{ all -> 0x00c0 }
        r3 = r3.f1381d;	 Catch:{ all -> 0x00c0 }
        r3 = r3 + r11;
        r2.f1381d = r3;	 Catch:{ all -> 0x00c0 }
        r5.put(r1, r2);	 Catch:{ all -> 0x00c0 }
        goto L_0x005d;
    L_0x00c0:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x00c0 }
        throw r0;	 Catch:{ all -> 0x00c3 }
    L_0x00c3:
        r0 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x00c3 }
        throw r0;
    L_0x00c6:
        r0 = com.ppu.fba.p009d.C0308e.m1965a();	 Catch:{ all -> 0x00c3 }
        r1 = r0.iterator();	 Catch:{ all -> 0x00c3 }
    L_0x00ce:
        r0 = r1.hasNext();	 Catch:{ all -> 0x00c3 }
        if (r0 == 0) goto L_0x0028;
    L_0x00d4:
        r0 = r1.next();	 Catch:{ all -> 0x00c3 }
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x00c3 }
        r2 = new com.ppu.fba.c.g;	 Catch:{ all -> 0x00c3 }
        r2.<init>();	 Catch:{ all -> 0x00c3 }
        r5.put(r0, r2);	 Catch:{ all -> 0x00c3 }
        goto L_0x00ce;
    L_0x00e3:
        r0 = com.ppu.fba.p009d.C0308e.m1969b();	 Catch:{ all -> 0x00c3 }
        r1 = r0.iterator();	 Catch:{ all -> 0x00c3 }
    L_0x00eb:
        r0 = r1.hasNext();	 Catch:{ all -> 0x00c3 }
        if (r0 == 0) goto L_0x0028;
    L_0x00f1:
        r0 = r1.next();	 Catch:{ all -> 0x00c3 }
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x00c3 }
        r2 = new com.ppu.fba.c.g;	 Catch:{ all -> 0x00c3 }
        r2.<init>();	 Catch:{ all -> 0x00c3 }
        r5.put(r0, r2);	 Catch:{ all -> 0x00c3 }
        goto L_0x00eb;
    L_0x0100:
        r0 = com.ppu.fba.p009d.C0308e.m1971c();	 Catch:{ all -> 0x00c3 }
        r1 = r0.iterator();	 Catch:{ all -> 0x00c3 }
    L_0x0108:
        r0 = r1.hasNext();	 Catch:{ all -> 0x00c3 }
        if (r0 == 0) goto L_0x0028;
    L_0x010e:
        r0 = r1.next();	 Catch:{ all -> 0x00c3 }
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x00c3 }
        r2 = new com.ppu.fba.c.g;	 Catch:{ all -> 0x00c3 }
        r2.<init>();	 Catch:{ all -> 0x00c3 }
        r5.put(r0, r2);	 Catch:{ all -> 0x00c3 }
        goto L_0x0108;
    L_0x011d:
        r2 = com.ppu.fba.p008c.C0296a.m1929b();	 Catch:{ all -> 0x00c3 }
        r8 = r6.f1297f;	 Catch:{ all -> 0x00c3 }
        monitor-enter(r8);	 Catch:{ all -> 0x00c3 }
        r0 = r2;
    L_0x0125:
        r9 = 24;
        r9 = r2 - r9;
        r9 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r9 <= 0) goto L_0x0138;
    L_0x012d:
        r9 = r8.m1952a(r0);	 Catch:{ all -> 0x013b }
        r7.add(r9);	 Catch:{ all -> 0x013b }
        r9 = 1;
        r0 = r0 - r9;
        goto L_0x0125;
    L_0x0138:
        monitor-exit(r8);	 Catch:{ all -> 0x013b }
        goto L_0x003a;
    L_0x013b:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x013b }
        throw r0;	 Catch:{ all -> 0x00c3 }
    L_0x013e:
        r2 = com.ppu.fba.p008c.C0296a.m1928a();	 Catch:{ all -> 0x00c3 }
        r8 = r6.f1296e;	 Catch:{ all -> 0x00c3 }
        monitor-enter(r8);	 Catch:{ all -> 0x00c3 }
        r0 = r2;
    L_0x0146:
        r9 = 7;
        r9 = r2 - r9;
        r9 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r9 <= 0) goto L_0x0159;
    L_0x014e:
        r9 = r8.m1952a(r0);	 Catch:{ all -> 0x015c }
        r7.add(r9);	 Catch:{ all -> 0x015c }
        r9 = 1;
        r0 = r0 - r9;
        goto L_0x0146;
    L_0x0159:
        monitor-exit(r8);	 Catch:{ all -> 0x015c }
        goto L_0x003a;
    L_0x015c:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x015c }
        throw r0;	 Catch:{ all -> 0x00c3 }
    L_0x015f:
        r2 = com.ppu.fba.p008c.C0296a.m1928a();	 Catch:{ all -> 0x00c3 }
        r0 = "com.ppu.fba.free";
        r1 = r13.m37c();	 Catch:{ all -> 0x00c3 }
        r8 = com.ppu.fba.R.string.package_name;	 Catch:{ all -> 0x00c3 }
        r1 = r1.getString(r8);	 Catch:{ all -> 0x00c3 }
        r0 = r0.equals(r1);	 Catch:{ all -> 0x00c3 }
        if (r0 != 0) goto L_0x003a;
    L_0x0175:
        r0 = com.ppu.fba.p009d.C0313j.m2004a(r14);	 Catch:{ all -> 0x00c3 }
        if (r0 == 0) goto L_0x003a;
    L_0x017b:
        r8 = r6.f1296e;	 Catch:{ all -> 0x00c3 }
        monitor-enter(r8);	 Catch:{ all -> 0x00c3 }
        r0 = r2;
    L_0x017f:
        r9 = 30;
        r9 = r2 - r9;
        r9 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r9 <= 0) goto L_0x0192;
    L_0x0187:
        r9 = r8.m1952a(r0);	 Catch:{ all -> 0x0195 }
        r7.add(r9);	 Catch:{ all -> 0x0195 }
        r9 = 1;
        r0 = r0 - r9;
        goto L_0x017f;
    L_0x0192:
        monitor-exit(r8);	 Catch:{ all -> 0x0195 }
        goto L_0x003a;
    L_0x0195:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0195 }
        throw r0;	 Catch:{ all -> 0x00c3 }
    L_0x0198:
        r2 = r8.contains(r1);	 Catch:{ all -> 0x00c0 }
        if (r2 != 0) goto L_0x0085;
    L_0x019e:
        goto L_0x005d;
    L_0x01a0:
        r2 = r9.contains(r1);	 Catch:{ all -> 0x00c0 }
        if (r2 != 0) goto L_0x0085;
    L_0x01a6:
        goto L_0x005d;
    L_0x01a8:
        if (r2 == 0) goto L_0x0085;
    L_0x01aa:
        if (r3 == 0) goto L_0x0085;
    L_0x01ac:
        goto L_0x005d;
    L_0x01ae:
        if (r2 == 0) goto L_0x005d;
    L_0x01b0:
        r2 = 1;
        if (r3 == r2) goto L_0x0085;
    L_0x01b3:
        goto L_0x005d;
    L_0x01b5:
        if (r2 == 0) goto L_0x005d;
    L_0x01b7:
        r2 = 2;
        if (r3 == r2) goto L_0x0085;
    L_0x01ba:
        goto L_0x005d;
    L_0x01bc:
        monitor-exit(r6);	 Catch:{ all -> 0x00c0 }
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x00c3 }
        r1 = r5.keySet();	 Catch:{ all -> 0x00c3 }
        r0.<init>(r1);	 Catch:{ all -> 0x00c3 }
        r3 = r0.iterator();	 Catch:{ all -> 0x00c3 }
    L_0x01ca:
        r0 = r3.hasNext();	 Catch:{ all -> 0x00c3 }
        if (r0 == 0) goto L_0x0223;
    L_0x01d0:
        r0 = r3.next();	 Catch:{ all -> 0x00c3 }
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x00c3 }
        r1 = r6.f1366a;	 Catch:{ all -> 0x00c3 }
        r2 = r0.intValue();	 Catch:{ all -> 0x00c3 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x00c3 }
        r1 = r1.get(r2);	 Catch:{ all -> 0x00c3 }
        r1 = (com.ppu.fba.p007b.C0289a) r1;	 Catch:{ all -> 0x00c3 }
        r2 = 0;
        if (r1 == 0) goto L_0x01ed;
    L_0x01e9:
        r2 = r1.m1919a();	 Catch:{ all -> 0x00c3 }
    L_0x01ed:
        r7 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x00c3 }
        r7 = r0.equals(r7);	 Catch:{ all -> 0x00c3 }
        if (r7 == 0) goto L_0x01fb;
    L_0x01f7:
        r5.remove(r0);	 Catch:{ all -> 0x00c3 }
        goto L_0x01ca;
    L_0x01fb:
        r7 = com.ppu.fba.ui.dr.f1779a;	 Catch:{ all -> 0x00c3 }
        r8 = r13.f1561P;	 Catch:{ all -> 0x00c3 }
        r8 = r8.ordinal();	 Catch:{ all -> 0x00c3 }
        r7 = r7[r8];	 Catch:{ all -> 0x00c3 }
        switch(r7) {
            case 2: goto L_0x0209;
            case 3: goto L_0x0211;
            case 4: goto L_0x021a;
            default: goto L_0x0208;
        };	 Catch:{ all -> 0x00c3 }
    L_0x0208:
        goto L_0x01ca;
    L_0x0209:
        if (r1 == 0) goto L_0x01ca;
    L_0x020b:
        if (r2 == 0) goto L_0x01ca;
    L_0x020d:
        r5.remove(r0);	 Catch:{ all -> 0x00c3 }
        goto L_0x01ca;
    L_0x0211:
        if (r1 == 0) goto L_0x0216;
    L_0x0213:
        r1 = 1;
        if (r2 == r1) goto L_0x01ca;
    L_0x0216:
        r5.remove(r0);	 Catch:{ all -> 0x00c3 }
        goto L_0x01ca;
    L_0x021a:
        if (r1 == 0) goto L_0x021f;
    L_0x021c:
        r1 = 2;
        if (r2 == r1) goto L_0x01ca;
    L_0x021f:
        r5.remove(r0);	 Catch:{ all -> 0x00c3 }
        goto L_0x01ca;
    L_0x0223:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00c3 }
        r0 = r5.keySet();	 Catch:{ all -> 0x00c3 }
        r1.<init>(r0);	 Catch:{ all -> 0x00c3 }
        r0 = new com.ppu.fba.ui.ag;	 Catch:{ all -> 0x00c3 }
        r0.<init>(r13, r5);	 Catch:{ all -> 0x00c3 }
        java.util.Collections.sort(r1, r0);	 Catch:{ all -> 0x00c3 }
        monitor-exit(r13);	 Catch:{ all -> 0x00c3 }
        r0 = new com.ppu.fba.ui.ai;
        r0.<init>(r13, r14, r5, r1);
    L_0x023a:
        return r0;
    L_0x023b:
        r0 = "SectionAppsListFragment";
        r1 = "NO MANAGER !!!!";
        com.ppu.fba.p009d.Log1.LogF1(r0, r1);
        r0 = 0;
        goto L_0x023a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ppu.fba.ui.ad.a(android.content.Context):android.widget.ListAdapter");
    }

    public synchronized void mo751a(ListAdapter listAdapter) {
        if (this.f1562Q == an.THIRTY_DAYS && (this.R == null || "com.ppu.fba.free".equals(m37c().getString(R.string.package_name)) || !C0313j.m2004a(this.R.getContext()))) {
            if (this.R != null) {
                this.R.setVisibility(8);
            }
            if (this.f1563T != null) {
                this.f1563T.setVisibility(0);
            }
        } else {
            if (this.R != null) {
                this.R.setVisibility(0);
            }
            if (this.f1563T != null) {
                this.f1563T.setVisibility(8);
            }
            if (!(this.R == null || listAdapter == null)) {
                this.R.setAdapter(listAdapter);
            }
        }
    }
}
