package com.ppu.fba.ui;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v4.app.C0012h;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.android.vending.licensing.APKExpansionPolicy;
import com.ppu.fba.free.R;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p009d.C0304a;
import com.ppu.fba.p009d.C0308e;
import com.ppu.fba.p009d.C0309f;
import com.ppu.fba.p009d.C0310g;
import com.ppu.fba.p009d.C0318o;
import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity implements TabListener {
    C0337c f1447n;
    ao f1448o;
    ad f1449p;
    SectionGeoListFragment f1450q;
    DashboardViewPager f1451r;

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 == -1) {
                C0318o.m2031a(MapBuilder.createEvent("buttons", "share", "success", null).build());
            }
        } else if (i == 2 && i2 == -1) {
            C0318o.m2031a(MapBuilder.createEvent("buttons", "shareMap", "success", null).build());
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_dashboard);
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        synchronized (this) {
            this.f1448o = new ao();
            this.f1449p = new ad();
            this.f1450q = new SectionGeoListFragment();
        }
        this.f1447n = new C0337c(this, m156e());
        this.f1451r = (DashboardViewPager) findViewById(R.id.pager);
        this.f1451r.setAdapter(this.f1447n);
        this.f1451r.setOnPageChangeListener(new C0335a(this, actionBar));
        for (int i = 0; i < this.f1447n.mo756b(); i++) {
            Tab newTab = actionBar.newTab();
            switch (i) {
                case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                    newTab.setTag(this.f1448o);
                    break;
                case 1:
                    newTab.setTag(this.f1449p);
                    break;
                case 2:
                    newTab.setTag(this.f1450q);
                    break;
                default:
                    break;
            }
            newTab.setText(this.f1447n.mo758c(i));
            newTab.setTabListener(this);
            actionBar.addTab(newTab);
        }
        C0304a.m1960a(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        C0308e.m1973e();
        C0309f.m1985e();
    }

    public void onLowMemory() {
        super.onLowMemory();
        C0308e.m1973e();
        C0309f.m1985e();
    }

    public void onStart() {
        super.onStart();
        C0318o.m2030a((Activity) this);
        C0308e.m1972d();
        C0309f.m1983d();
        if (C0310g.m1987a(this)) {
            FirewallManagerService.m1852a((Context) this);
            this.f1448o.m2057c(this);
        } else if (FirewallManagerService.m1852a(null) == null) {
            AlertDialog create = new Builder(this).create();
            create.setCancelable(false);
            create.setTitle(getResources().getString(R.string.popup_vpn_title));
            create.setMessage(getResources().getString(R.string.popup_vpn_content));
            create.setButton(-1, getResources().getString(R.string.button_ok), new bd(this));
            create.show();
        } else {
            this.f1448o.m2057c(this);
        }
    }

    public void onStop() {
        super.onStop();
        C0318o.m2032b(this);
    }

    public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {
    }

    public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {
        this.f1451r.setCurrentItem(tab.getPosition());
        ad tag = tab.getTag();
        if (tag != null) {
            tag.m2056b(this);
        }
        if (tag == this.f1449p && C0310g.m1993e()) {
            ArrayList arrayList = new ArrayList();
            LayoutInflater layoutInflater = getLayoutInflater();
            Builder builder = new Builder(this);
            builder.setCancelable(false);
            builder.setTitle(R.string.popup_click_apps_title);
            View inflate = layoutInflater.inflate(R.layout.dialog_warn_dont, null);
            ((TextView) inflate.findViewById(R.id.dialogText)).setText(R.string.popup_click_apps_content);
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.dialogCheckbox);
            checkBox.setText(R.string.popup_click_apps_checkbox);
            checkBox.setOnCheckedChangeListener(new bj(this, arrayList));
            builder.setView(inflate);
            builder.setPositiveButton(R.string.button_ok, new C0336b(this, arrayList));
            builder.create().show();
        }
    }

    public void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction) {
    }
}
