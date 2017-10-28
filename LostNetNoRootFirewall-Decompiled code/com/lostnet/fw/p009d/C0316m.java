package com.lostnet.fw.p009d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.FirewallApplication;

public class C0316m {
    public static void m2020a() {
        Context a = FirewallApplication.m1851a();
        SharedPreferences sharedPreferences = a.getSharedPreferences("settings", 1);
        if (sharedPreferences.getString("currentProfile", null) == null) {
            String string = a.getResources().getString(C0330m.profile_default);
            Editor edit = sharedPreferences.edit();
            edit.putString("currentProfile", string);
            edit.apply();
            C0317n.m2025b(string);
        }
        if (sharedPreferences.getString("cloudshark", null) == null) {
            edit = sharedPreferences.edit();
            edit.putString("cloudshark", "www.cloudshark.org");
            edit.apply();
        }
        if (sharedPreferences.getString("cloudshark_key", null) == null) {
            edit = sharedPreferences.edit();
            edit.putString("cloudshark_key", "f450b127b5911af9c44732fe2a4cf417");
            edit.apply();
        }
        sharedPreferences.getBoolean("cloudshark_https", true);
        Editor edit2 = sharedPreferences.edit();
        edit2.putBoolean("cloudshark_https", true);
        edit2.apply();
    }

    public static SharedPreferences m2021b() {
        return FirewallApplication.m1851a().getSharedPreferences("settings", 1);
    }
}
