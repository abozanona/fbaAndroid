package com.ppu.fba.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import com.ppu.fba.free.R;
import com.ppu.fba.FirewallApplication;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p004a.C0287e;
import com.ppu.fba.p007b.C0289a;
import com.ppu.fba.p007b.C0291c;
import com.ppu.fba.p007b.C0292d;
import com.ppu.fba.p007b.C0294f;
import com.ppu.fba.p009d.C0313j;
import com.ppu.fba.p009d.Log1;
import java.util.ArrayList;

public class ao extends cd {
    public static volatile Switch f1602P;
    ScrollView f1603Q;
    RelativeLayout f1604S;
    View f1605T;
    Button f1606U;
    TextView f1607V;
    TextView f1608W;
    TextView f1609X;
    TextView f1610Y;
    TextView f1611Z;
    TextView aa;
    du ab;

    public View mo749a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.fragment_dashboard, viewGroup, false);
        Context a = FirewallApplication.m1851a();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a);
        f1602P = (Switch) inflate.findViewById(R.id.dashboardSwitch);
        f1602P.setChecked(defaultSharedPreferences.getBoolean("status_on", true));
        this.f1603Q = (ScrollView) inflate.findViewById(R.id.dashboardScroll);
        f1602P.setOnCheckedChangeListener(new ap(this, a));
        ((Button) inflate.findViewById(R.id.dashboardSettings)).setOnClickListener(new ar(this));
        ((Button) inflate.findViewById(R.id.dashboardTools)).setOnClickListener(new as(this));
        inflate.findViewById(R.id.dashboardSeparator2);
        Button button = (Button) inflate.findViewById(R.id.dashboardUpdate);
        button.setOnClickListener(new at(this));
        new au(this, button).execute(new Object[]{new Object()});
        this.f1605T = inflate.findViewById(R.id.dashboardSeparator1);
        this.f1606U = (Button) inflate.findViewById(R.id.dashboardShare);
        this.f1606U.setOnClickListener(new av(this));
        this.ab = new du(this, inflate);
        this.f1607V = (TextView) inflate.findViewById(R.id.dashboardCounterCountries);
        this.f1608W = (TextView) inflate.findViewById(R.id.dashboardCounterApps);
        this.f1609X = (TextView) inflate.findViewById(R.id.dashboardCounterAppsWifi);
        this.f1610Y = (TextView) inflate.findViewById(R.id.dashboardCounterAppsBackground);
        this.f1611Z = (TextView) inflate.findViewById(R.id.dashboardCounterAppsNight);
        this.aa = (TextView) inflate.findViewById(R.id.dashboardCounterAppsOffice);
        synchronized (this) {
            this.f1604S = (RelativeLayout) inflate.findViewById(R.id.dashboardEmptyView);
            this.R = (ListView) inflate.findViewById(R.id.dashboardSuggestionsList);
        }
        m2057c(viewGroup.getContext());
        new ds(this).execute(new Object[0]);
        return inflate;
    }

    public ListAdapter mo750a(Context context) {
        ArrayList arrayList = null;
        Log1.LogF1("SectionDashboard", "updateSync");
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            arrayList = C0287e.m1914a(context, a.f1294c, a.f1295d);
        }
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        return new aw(this, context, arrayList);
    }

    public synchronized void mo751a(ListAdapter listAdapter) {
        int i = 0;
        synchronized (this) {
            Log1.LogF1("SectionDashboard", "updateSyncUI");
            if (!(this.R == null || listAdapter == null)) {
                if (f1602P.isEnabled()) {
                    f1602P.setChecked(PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a()).getBoolean("status_on", true));
                }
                if (listAdapter.getCount() > 0) {
                    this.f1604S.setVisibility(0);
                    this.R.setEmptyView(this.f1604S);
                } else {
                    this.f1604S.setVisibility(4);
                }
                this.R.setAdapter(listAdapter);
                C0313j.m2002a(this.R);
                this.f1603Q.recomputeViewAttributes(this.R);
                this.f1603Q.requestLayout();
                new dt(this).execute(new Object[0]);
            }
            FirewallManagerService a = FirewallManagerService.m1852a(null);
            int i2;
            if (a != null) {
                int i3;
                int i4;
                C0294f c0294f = a.f1295d;
                if (c0294f != null) {
                    synchronized (c0294f) {
                        i3 = 0;
                        for (Integer num : c0294f.f1370a.keySet()) {
                            i3 = ((C0292d) c0294f.f1370a.get(num)).f1369c != 0 ? i3 + 1 : i3;
                        }
                    }
                    this.f1607V.setText(String.valueOf(i3));
                    i4 = i3;
                } else {
                    i4 = 0;
                }
                C0291c c0291c = a.f1294c;
                if (c0291c != null) {
                    int i5;
                    int i6;
                    int i7;
                    synchronized (c0291c) {
                        i3 = 0;
                        i5 = 0;
                        i6 = 0;
                        i7 = 0;
                        for (Integer num2 : c0291c.f1366a.keySet()) {
                            C0289a c0289a = (C0289a) c0291c.f1366a.get(num2);
                            if (c0289a != null) {
                                int a2 = c0289a.m1919a();
                                int b = c0289a.m1921b();
                                if (a2 == 2) {
                                    a2 = i + 1;
                                } else if (a2 == 1) {
                                    i7++;
                                    a2 = i;
                                } else {
                                    a2 = i;
                                }
                                if ((b & 8) != 0) {
                                    i6++;
                                }
                                i3 = (b & 32) != 0 ? i3 + 1 : i3;
                                i5 = (b & 16) != 0 ? i5 + 1 : i5;
                                i = a2;
                            }
                        }
                    }
                    this.f1608W.setText(String.valueOf(i));
                    this.f1609X.setText(String.valueOf(i7));
                    this.f1610Y.setText(String.valueOf(i6));
                    this.f1611Z.setText(String.valueOf(i5));
                    this.aa.setText(String.valueOf(i3));
                }
                i2 = i;
                i = i4;
            } else {
                i2 = 0;
            }
            if (i == 0 && r0 == 0) {
                this.f1605T.setVisibility(0);
                this.f1606U.setVisibility(8);
            } else {
                this.f1606U.setVisibility(0);
                this.f1605T.setVisibility(8);
            }
            this.ab.m2104a();
        }
    }
}
