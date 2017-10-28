package com.ppu.fba.ui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.C0288a;
import com.ppu.fba.FirewallApplication;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p009d.C0318o;

class er implements OnCheckedChangeListener {
    final /* synthetic */ SettingsActivity f1833a;

    er(SettingsActivity settingsActivity) {
        this.f1833a = settingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a());
        boolean z2 = defaultSharedPreferences.getBoolean("status_on", false);
        Editor edit = defaultSharedPreferences.edit();
        edit.putBoolean((String) compoundButton.getTag(), z);
        edit.commit();
        this.f1833a.f1515b.setEnabled(false);
        this.f1833a.f1516c.setEnabled(false);
        if (z2) {
            FirewallManagerService a = FirewallManagerService.m1852a(null);
            if (a != null) {
                a.m1863a(new C0288a(2));
                a.m1863a(new C0288a(1, new es(this)));
            }
        }
        C0318o.m2031a(MapBuilder.createEvent("settings", "switch", "data_caching", null).build());
    }
}
