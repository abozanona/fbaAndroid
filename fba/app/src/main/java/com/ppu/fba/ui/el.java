package com.ppu.fba.ui;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ppu.fba.C0288a;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p007b.C0292d;
import com.ppu.fba.p007b.C0294f;
import com.ppu.fba.p009d.C0309f;
import com.ppu.fba.p009d.Log1;
import java.util.ArrayList;
import java.util.Iterator;

public class el implements OnCheckedChangeListener {
    final /* synthetic */ SectionGeoListFragment f1817a;
    private final ArrayList f1818b;
    private final int f1819c;
    private final boolean f1820d;
    private final String f1821e;

    public el(SectionGeoListFragment sectionGeoListFragment, ArrayList arrayList, int i, boolean z, String str) {
        this.f1817a = sectionGeoListFragment;
        this.f1818b = arrayList;
        this.f1819c = i;
        this.f1820d = z;
        this.f1821e = str;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            String str;
            int i;
            FirewallManagerService a = FirewallManagerService.m1852a(null);
            if (a != null) {
                int i2;
                C0294f c0294f = a.f1295d;
                synchronized (c0294f) {
                    Iterator it = this.f1818b.iterator();
                    i2 = 0;
                    while (it.hasNext()) {
                        str = (String) it.next();
                        int d = C0309f.m1982d(str);
                        C0292d c0292d = (C0292d) c0294f.f1370a.get(Integer.valueOf(d));
                        if (c0292d == null) {
                            c0292d = new C0292d(str, d);
                        } else if (c0292d.f1369c == this.f1819c) {
                        }
                        c0292d.f1369c = this.f1819c;
                        c0292d.f1368b = true;
                        c0294f.f1370a.put(Integer.valueOf(d), c0292d);
                        i2 = 1;
                    }
                }
                if (i2 != 0) {
                    a.m1863a(new C0288a(5));
                }
                i = i2;
            } else {
                i = 0;
            }
            if (i != 0) {
                if (this.f1819c == 2) {
                    this.f1817a.f1509S.setVisibility(View.VISIBLE);
                    str = "Block";
                } else {
                    str = "Allow";
                }
                Log1.LogAction("listCnts", "click" + str, (this.f1820d ? "R:" : "C:") + this.f1821e, null);
                /*
                BaseAdapter baseAdapter = (BaseAdapter) this.f1817a.R.getAdapter();
                if (baseAdapter != null) {
                    baseAdapter.notifyDataSetChanged();
                }
                baseAdapter = (BaseAdapter) this.f1817a.f1512V.getAdapter();
                if (baseAdapter != null) {
                    baseAdapter.notifyDataSetChanged();
                }
                this.f1817a.f1511U.loadUrl("file:///android_asset/worldmap/index.html");
                */
            }
        }
    }
}
