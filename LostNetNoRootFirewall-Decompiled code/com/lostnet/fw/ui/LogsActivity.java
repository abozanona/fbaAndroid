package com.lostnet.fw.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import com.lostnet.fw.C0328k;
import com.lostnet.fw.C0329l;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.p009d.C0310g;
import com.lostnet.fw.p009d.C0318o;
import java.util.ArrayList;

public class LogsActivity extends Activity {
    private ArrayList f1481a = new ArrayList();
    private int f1482b = -1;
    private int f1483c = -1;
    private int f1484d = -1;
    private int f1485e = -1;
    private int f1486f = -1;
    private cw f1487g;
    private ct f1488h;
    private cv f1489i;
    private cs f1490j;
    private cu f1491k;

    protected void onCreate(Bundle bundle) {
        int i;
        int i2;
        super.onCreate(bundle);
        setContentView(C0329l.logs);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        ListView listView = (ListView) findViewById(C0328k.logsListMalware);
        ListAdapter dgVar = new dg(this, this);
        if (dgVar.getCount() != 0) {
            listView.setAdapter(dgVar);
            this.f1482b = 0;
            this.f1481a.add(Integer.valueOf(C0328k.logsSlideMalware));
            i = 1;
        } else {
            i = 0;
        }
        listView = (ListView) findViewById(C0328k.logsListApps);
        ListAdapter deVar = new de(this, this);
        if (deVar.getCount() != 0) {
            listView.setAdapter(deVar);
            this.f1483c = i;
            this.f1481a.add(Integer.valueOf(C0328k.logsSlideApps));
            i++;
        }
        listView = (ListView) findViewById(C0328k.logsListCnts);
        deVar = new df(this, this);
        if (deVar.getCount() != 0) {
            listView.setAdapter(deVar);
            this.f1484d = i;
            this.f1481a.add(Integer.valueOf(C0328k.logsSlideCnts));
            i++;
        }
        listView = (ListView) findViewById(C0328k.logsListAds);
        deVar = new dd(this, this);
        if (deVar.getCount() != 0) {
            listView.setAdapter(deVar);
            this.f1485e = i;
            this.f1481a.add(Integer.valueOf(C0328k.logsSlideAds));
            i2 = i + 1;
        } else {
            i2 = i;
        }
        TabHost tabHost = (TabHost) findViewById(C0328k.logsTabHost);
        if (i2 == 0) {
            ((RelativeLayout) findViewById(C0328k.logsListEmpty)).setVisibility(0);
            tabHost.setVisibility(8);
            return;
        }
        ((Button) findViewById(C0328k.listEmptyButton)).setOnClickListener(new co(this));
        ViewPager viewPager = (ViewPager) findViewById(C0328k.logsSlidePager);
        viewPager.setAdapter(new dh(this));
        Resources resources = getResources();
        tabHost.setup();
        if (this.f1482b != -1) {
            TabSpec newTabSpec = tabHost.newTabSpec("malware");
            newTabSpec.setContent(C0328k.logsSlidePager);
            newTabSpec.setIndicator(resources.getString(C0330m.logs_malware));
            tabHost.addTab(newTabSpec);
            this.f1487g = new cw(this, findViewById(C0328k.logsSlideMalware));
            this.f1487g.m2104a();
        }
        if (this.f1483c != -1) {
            newTabSpec = tabHost.newTabSpec("apps");
            newTabSpec.setContent(C0328k.logsSlidePager);
            newTabSpec.setIndicator(resources.getString(C0330m.logs_apps));
            tabHost.addTab(newTabSpec);
            this.f1488h = new ct(this, findViewById(C0328k.logsSlideApps));
            this.f1488h.m2104a();
        }
        if (this.f1484d != -1) {
            newTabSpec = tabHost.newTabSpec("geo");
            newTabSpec.setContent(C0328k.logsSlidePager);
            newTabSpec.setIndicator(resources.getString(C0330m.logs_geo));
            tabHost.addTab(newTabSpec);
            this.f1489i = new cv(this, findViewById(C0328k.logsSlideCnts));
            this.f1489i.m2104a();
        }
        if (this.f1485e != -1) {
            newTabSpec = tabHost.newTabSpec("ads");
            newTabSpec.setContent(C0328k.logsSlidePager);
            newTabSpec.setIndicator(resources.getString(C0330m.logs_ads));
            tabHost.addTab(newTabSpec);
            this.f1490j = new cs(this, findViewById(C0328k.logsSlideAds));
            this.f1490j.m2104a();
        }
        if (this.f1486f != -1) {
            newTabSpec = tabHost.newTabSpec("cached");
            newTabSpec.setContent(C0328k.logsSlidePager);
            newTabSpec.setIndicator(resources.getString(C0330m.logs_cached));
            tabHost.addTab(newTabSpec);
            this.f1491k = new cu(this, findViewById(C0328k.logsSlideCached));
            this.f1491k.m2104a();
        }
        tabHost.setOnTabChangedListener(new cp(this, viewPager));
        viewPager.setOnPageChangeListener(new cq(this, tabHost));
        if (i2 != 0) {
            tabHost.setCurrentTab(1);
            viewPager.setCurrentItem(1);
        }
        tabHost.setCurrentTab(0);
        viewPager.setCurrentItem(0);
        tabHost.requestLayout();
        if (!C0310g.m1986a()) {
            Button button = (Button) findViewById(C0328k.buttonUpgrade);
            button.setText(C0330m.button_pro_rate);
            button.setOnClickListener(new cr(this));
            button.setVisibility(0);
        }
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
        C0318o.m2030a((Activity) this);
    }

    public void onStop() {
        super.onStop();
        C0318o.m2032b(this);
    }
}
