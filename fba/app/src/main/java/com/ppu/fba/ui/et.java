package com.ppu.fba.ui;

import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ppu.fba.FirewallApplication;
import com.ppu.fba.p009d.Log1;

public class et implements OnCheckedChangeListener {
    final /* synthetic */ SettingsActivity f1835a;

    et(SettingsActivity settingsActivity) {
        this.f1835a = settingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a()).edit();
        edit.putBoolean("notifications_on", z);
        edit.apply();
        Log1.LogAction("settings", "switch", "notifications", null);
    }
}
