package com.lostnet.fw.ui;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.lostnet.fw.C0328k;
import com.lostnet.fw.C0329l;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.FirewallApplication;
import com.lostnet.fw.p009d.C0316m;
import com.lostnet.fw.p009d.C0318o;

public class SettingsActivity extends Activity {
    RelativeLayout f1514a;
    RelativeLayout f1515b;
    RelativeLayout f1516c;
    RelativeLayout f1517d;
    RelativeLayout f1518e;
    RelativeLayout f1519f;
    TextView f1520g;
    TextView f1521h;
    Integer f1522i;
    Integer f1523j;
    Integer f1524k;
    Integer f1525l;
    ev f1526m = new ev(this);

    private void m2066a() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new eo(this), this.f1522i.intValue(), this.f1523j.intValue(), DateFormat.is24HourFormat(this));
        timePickerDialog.setTitle(C0330m.night_start);
        timePickerDialog.show();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 17) {
            super.onActivityResult(i, i2, intent);
        }
        switch (i) {
            case 17:
                this.f1520g.setText(C0316m.m2021b().getString("currentProfile", null));
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0329l.activity_settings);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        Button button = (Button) findViewById(C0328k.buttonUpgrade);
        ListView listView = (ListView) findViewById(C0328k.settingsList);
        listView.setAdapter(this.f1526m);
        LayoutInflater layoutInflater = getLayoutInflater();
        this.f1514a = (RelativeLayout) layoutInflater.inflate(C0329l.activity_settings_text, null);
        this.f1515b = (RelativeLayout) layoutInflater.inflate(C0329l.activity_settings_switch, null);
        this.f1516c = (RelativeLayout) layoutInflater.inflate(C0329l.activity_settings_switch, null);
        this.f1517d = (RelativeLayout) layoutInflater.inflate(C0329l.activity_settings_switch, null);
        this.f1518e = (RelativeLayout) layoutInflater.inflate(C0329l.activity_settings_text, null);
        this.f1519f = (RelativeLayout) layoutInflater.inflate(C0329l.activity_settings_text, null);
        TextView textView = (TextView) this.f1514a.findViewById(C0328k.textLabel);
        this.f1520g = (TextView) this.f1514a.findViewById(C0328k.textValue);
        Switch switchR = (Switch) this.f1515b.findViewById(C0328k.switchSwitch);
        TextView textView2 = (TextView) this.f1515b.findViewById(C0328k.switchText);
        TextView textView3 = (TextView) this.f1515b.findViewById(C0328k.switchComment);
        Switch switchR2 = (Switch) this.f1516c.findViewById(C0328k.switchSwitch);
        TextView textView4 = (TextView) this.f1516c.findViewById(C0328k.switchText);
        TextView textView5 = (TextView) this.f1516c.findViewById(C0328k.switchComment);
        Switch switchR3 = (Switch) this.f1517d.findViewById(C0328k.switchSwitch);
        TextView textView6 = (TextView) this.f1517d.findViewById(C0328k.switchText);
        TextView textView7 = (TextView) this.f1517d.findViewById(C0328k.switchComment);
        TextView textView8 = (TextView) this.f1519f.findViewById(C0328k.textLabel);
        this.f1521h = (TextView) this.f1519f.findViewById(C0328k.textValue);
        TextView textView9 = (TextView) this.f1518e.findViewById(C0328k.textLabel);
        TextView textView10 = (TextView) this.f1518e.findViewById(C0328k.textValue);
        switchR.setEnabled(true);
        textView2.setEnabled(true);
        textView3.setEnabled(true);
        boolean z = !"com.lostnet.fw.free".equals(getResources().getString(C0330m.package_name));
        if (z) {
            button.setVisibility(8);
            button.setEnabled(false);
            switchR2.setEnabled(true);
            textView4.setEnabled(true);
            textView5.setEnabled(true);
            textView4.setText(C0330m.malware_shield_pro);
            switchR3.setEnabled(true);
            textView6.setEnabled(true);
            textView7.setEnabled(true);
            textView6.setText(C0330m.switch_notifications_pro);
            textView7.setText(C0330m.switch_notifications_summary_pro);
            textView8.setText(C0330m.night_pro);
            textView8.setEnabled(true);
            this.f1521h.setEnabled(true);
            textView9.setText(C0330m.office_wifi_pro);
            textView9.setEnabled(true);
            textView10.setEnabled(true);
        } else {
            button.setVisibility(0);
            button.setEnabled(true);
            textView4.setText(C0330m.malware_shield);
            textView6.setText(C0330m.switch_notifications);
            textView7.setText(C0330m.switch_notifications_summary);
            textView8.setText(C0330m.night);
            textView8.setEnabled(false);
            this.f1521h.setEnabled(false);
            textView9.setText(C0330m.office_wifi);
            textView9.setEnabled(false);
            textView10.setEnabled(false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a());
        textView.setText(C0330m.profile);
        this.f1520g.setText(C0316m.m2021b().getString("currentProfile", ""));
        switchR.setChecked(defaultSharedPreferences.getBoolean("ad_blocking_on", false));
        textView2.setText(C0330m.ad_blocking);
        textView3.setText(C0330m.ad_blocking_comment);
        switchR2.setChecked(defaultSharedPreferences.getBoolean("malware_shield_on", false));
        textView5.setText(C0330m.malware_shield_comment);
        switchR3.setChecked(defaultSharedPreferences.getBoolean("notifications_on", true));
        this.f1522i = Integer.valueOf(defaultSharedPreferences.getInt("nightStartsHour", 22));
        this.f1523j = Integer.valueOf(defaultSharedPreferences.getInt("nightStartsMin", 0));
        this.f1524k = Integer.valueOf(defaultSharedPreferences.getInt("nightEndsHour", 8));
        this.f1525l = Integer.valueOf(defaultSharedPreferences.getInt("nightEndsMin", 0));
        this.f1521h.setText(getResources().getText(C0330m.night_from) + " " + defaultSharedPreferences.getString("nightStarts", String.format("%02d", new Object[]{this.f1522i}) + ":" + String.format("%02d", new Object[]{this.f1523j})) + " " + getResources().getText(C0330m.night_till) + " " + defaultSharedPreferences.getString("nightEnds", String.format("%02d", new Object[]{this.f1524k}) + ":" + String.format("%02d", new Object[]{this.f1525l})));
        textView10.setText(defaultSharedPreferences.getString("officeWifi", getResources().getString(C0330m.office_wifi_none)));
        listView.setOnItemClickListener(new eq(this, z, textView10));
        OnCheckedChangeListener erVar = new er(this);
        switchR.setTag("ad_blocking_on");
        switchR.setOnCheckedChangeListener(erVar);
        switchR2.setTag("malware_shield_on");
        switchR2.setOnCheckedChangeListener(erVar);
        switchR3.setOnCheckedChangeListener(new et(this));
        button.setOnClickListener(new eu(this));
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
