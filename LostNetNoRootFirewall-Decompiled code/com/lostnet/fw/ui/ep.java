package com.lostnet.fw.ui;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.TimePicker;
import com.lostnet.fw.C0288a;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.FirewallApplication;
import com.lostnet.fw.FirewallManagerService;

class ep implements OnTimeSetListener {
    final /* synthetic */ int f1827a;
    final /* synthetic */ int f1828b;
    final /* synthetic */ eo f1829c;

    ep(eo eoVar, int i, int i2) {
        this.f1829c = eoVar;
        this.f1827a = i;
        this.f1828b = i2;
    }

    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a()).edit();
        this.f1829c.f1826a.f1522i = Integer.valueOf(this.f1827a);
        this.f1829c.f1826a.f1523j = Integer.valueOf(this.f1828b);
        this.f1829c.f1826a.f1524k = Integer.valueOf(i);
        this.f1829c.f1826a.f1525l = Integer.valueOf(i2);
        String str = String.format("%02d", new Object[]{this.f1829c.f1826a.f1522i}) + ":" + String.format("%02d", new Object[]{this.f1829c.f1826a.f1523j});
        this.f1829c.f1826a.f1521h.setText(this.f1829c.f1826a.getResources().getText(C0330m.night_from) + " " + str + " " + this.f1829c.f1826a.getResources().getText(C0330m.night_till) + " " + (String.format("%02d", new Object[]{this.f1829c.f1826a.f1524k}) + ":" + String.format("%02d", new Object[]{this.f1829c.f1826a.f1525l})));
        edit.putInt("nightStartsHour", this.f1829c.f1826a.f1522i.intValue());
        edit.putInt("nightStartsMin", this.f1829c.f1826a.f1523j.intValue());
        edit.putInt("nightEndsHour", this.f1829c.f1826a.f1524k.intValue());
        edit.putInt("nightEndsMin", this.f1829c.f1826a.f1525l.intValue());
        edit.apply();
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            a.f1307r = this.f1829c.f1826a.f1522i.intValue();
            a.f1308s = this.f1829c.f1826a.f1523j.intValue();
            a.f1309t = this.f1829c.f1826a.f1524k.intValue();
            a.f1310u = this.f1829c.f1826a.f1525l.intValue();
            a.m1863a(new C0288a(5));
        }
    }
}
