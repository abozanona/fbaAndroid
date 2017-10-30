package com.ppu.fba.ui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.C0316m;
import com.ppu.fba.p009d.C0317n;
import com.ppu.fba.p009d.Log1;

public class ProfileSelectActivity extends Activity {
    SharedPreferences f1492a;
    Editor f1493b;
    String[] f1494c;
    Button f1495d;
    Button f1496e;
    Button f1497f;
    Button f1498g;
    RadioGroup f1499h;
    private volatile String f1500i = null;
    private volatile String f1501j = null;

    private void m2052b() {
        this.f1494c = C0317n.m2024a();
        if (this.f1494c == null) {
            finish();
            return;
        }
        if (this.f1494c.length > 1) {
            this.f1496e.setEnabled(true);
        } else {
            this.f1496e.setEnabled(false);
        }
        this.f1499h.setOnCheckedChangeListener(new dn(this));
        this.f1499h.removeAllViews();
        for (int length = this.f1494c.length - 1; length >= 0; length--) {
            Object obj = this.f1494c[length];
            View radioButton = new RadioButton(this.f1499h.getContext());
            radioButton.setText(obj);
            radioButton.setId(length);
            if (this.f1500i != null && obj.equals(this.f1500i)) {
                radioButton.setChecked(true);
            }
            radioButton.setLayoutParams(new LayoutParams(-2, -2));
            this.f1499h.addView(radioButton);
        }
        this.f1499h.setOnCheckedChangeListener(new C0339do(this));
    }

    public void m2053a() {
        m2052b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.dialog_profile_select);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        this.f1492a = C0316m.m2021b();
        this.f1493b = this.f1492a.edit();
        this.f1500i = this.f1492a.getString("currentProfile", null);
        this.f1501j = this.f1500i;
        this.f1494c = C0317n.m2024a();
        if (this.f1494c == null) {
            finish();
            return;
        }
        this.f1495d = (Button) findViewById(R.id.profileSelectAdd);
        this.f1496e = (Button) findViewById(R.id.profileSelectDelete);
        this.f1497f = (Button) findViewById(R.id.profileSelectCancel);
        this.f1498g = (Button) findViewById(R.id.profileSelectOK);
        this.f1498g.setOnClickListener(new di(this));
        this.f1496e.setOnClickListener(new dj(this));
        this.f1497f.setOnClickListener(new dk(this));
        this.f1495d.setOnClickListener(new dl(this));
        this.f1499h = (RadioGroup) findViewById(R.id.profileSelectRadios);
        this.f1499h.setOnCheckedChangeListener(new dm(this));
        m2052b();
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
        if (C0317n.m2024a() == null) {
            finish();
        } else {
        }
    }

    public void onStop() {
        super.onStop();
    }
}
