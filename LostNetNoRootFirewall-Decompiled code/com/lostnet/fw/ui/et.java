package com.lostnet.fw.ui;

import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.FirewallApplication;
import com.lostnet.fw.p009d.C0318o;

class et implements OnCheckedChangeListener {
    final /* synthetic */ SettingsActivity f1835a;

    et(SettingsActivity settingsActivity) {
        this.f1835a = settingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a()).edit();
        edit.putBoolean("notifications_on", z);
        edit.apply();
        C0318o.m2031a(MapBuilder.createEvent("settings", "switch", "notifications", null).build());
    }
}
