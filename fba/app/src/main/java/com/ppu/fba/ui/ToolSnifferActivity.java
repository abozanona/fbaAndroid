package com.ppu.fba.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import com.ppu.fba.free.R;
import com.ppu.fba.NativeWrapper;
import com.ppu.fba.p009d.C0308e;
import com.ppu.fba.p009d.Log1;
import java.util.ArrayList;
import java.util.Collections;

public class ToolSnifferActivity extends Activity {
    Button f1532a;
    Button f1533b;
    Button f1534c;
    TextView f1535d;
    TextView f1536e;
    TextView f1537f;
    RadioButton f1538g;
    RadioButton f1539h;
    Spinner f1540i;
    int f1541j = -1;
    volatile boolean f1542k = false;
    int f1543l = 0;
    int f1544m = 0;
    int f1545n = 0;
    boolean f1546o = false;
    Handler f1547p;
    OnClickListener f1548q = new ey(this);
    OnClickListener f1549r = new ez(this);
    private Runnable f1550s = new ex(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.activity_tool_sniffer);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        if ("com.ppu.fba.free".equals(getResources().getString(R.string.package_name))) {
            this.f1545n = 10;
            NativeWrapper.jni_dickw(this.f1545n);
        }
        this.f1538g = (RadioButton) findViewById(R.id.snifferRadioAll);
        this.f1539h = (RadioButton) findViewById(R.id.snifferRadioApp);
        this.f1540i = (Spinner) findViewById(R.id.snifferSpinner);
        Object arrayList = new ArrayList();
        arrayList.addAll(C0308e.m1965a());
        Collections.sort(arrayList, new fa(this));
        this.f1540i.setAdapter(new fg(this, this, arrayList));
        this.f1540i.setOnItemSelectedListener(new fb(this));
        this.f1538g.setOnCheckedChangeListener(new fc(this));
        this.f1539h.setOnCheckedChangeListener(new fd(this));
        this.f1532a = (Button) findViewById(R.id.snifferStartStop);
        this.f1532a.setOnClickListener(this.f1548q);
        this.f1533b = (Button) findViewById(R.id.snifferView);
        this.f1533b.setOnClickListener(new fe(this));
        this.f1534c = (Button) findViewById(R.id.snifferConfigure);
        this.f1534c.setOnClickListener(new ff(this));
        this.f1535d = (TextView) findViewById(R.id.snifferIntro);
        if ("com.ppu.fba.free".equals(getResources().getString(R.string.package_name))) {
            this.f1535d.setText(R.string.tool_sniffer_intro);
        } else {
            this.f1535d.setText(R.string.tool_sniffer_intro_pro);
        }
        this.f1536e = (TextView) findViewById(R.id.snifferCounterPackets);
        this.f1537f = (TextView) findViewById(R.id.snifferCounterBytes);
        this.f1538g.setChecked(true);
        this.f1539h.setChecked(false);
        this.f1547p = new Handler();
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

    protected void onStart() {
        super.onStart();
        this.f1546o = false;
        this.f1547p.post(this.f1550s);
    }

    public void onStop() {
        super.onStop();
        this.f1542k = false;
        this.f1546o = true;
    }
}
