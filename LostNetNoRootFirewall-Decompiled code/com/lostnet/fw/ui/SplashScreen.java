package com.lostnet.fw.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.tagmanager.ContainerOpener;
import com.lostnet.fw.C0329l;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.FirewallApplication;
import com.lostnet.fw.NativeWrapper;
import com.lostnet.fw.p008c.C0296a;
import com.lostnet.fw.p009d.C0310g;
import com.lostnet.fw.p009d.C0311h;
import com.lostnet.fw.p009d.C0313j;
import com.lostnet.fw.p009d.C0315l;
import com.lostnet.fw.p009d.C0316m;
import com.lostnet.fw.p009d.C0318o;

public class SplashScreen extends ck {
    int f1530a = 1;
    Boolean f1531b;

    protected void mo752a() {
        int i = 0;
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("lf");
            if (stringExtra != null) {
                if (stringExtra.equals("wgb")) {
                    C0318o.m2031a(MapBuilder.createEvent("widget", "gb", "la", null).build());
                } else if (stringExtra.equals("notif")) {
                    C0318o.m2031a(MapBuilder.createEvent("notif", "click", null, null).build());
                    this.f1530a = 2;
                }
            }
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a());
        int i2 = 10000;
        try {
            i2 = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
            i = i2;
            i2 = defaultSharedPreferences.getInt("lastRunVersion", 0);
        } catch (Exception e) {
            int i3 = i;
            i = i2;
            i2 = i3;
        }
        if (i2 < i) {
            C0311h.m1998a(this);
        }
        new Thread(new ca(this)).start();
        new Thread(new cb(this)).start();
        C0316m.m2020a();
        if (this.f1531b.booleanValue()) {
            if (!C0310g.m1990c() || C0313j.m2005a("com.lostnet.fw.free")) {
                onActivityResult(17, -1, null);
                return;
            }
            intent = new Intent(this, ImportActivity.class);
            intent.setFlags(536870912);
            startActivityForResult(intent, 17);
        } else if (C0313j.m2005a("com.lostnet.fw.pro")) {
            C0318o.m2029a();
            startActivityForResult(new Intent(this, UninstallActivity.class), 17);
        } else {
            onActivityResult(17, -1, null);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 17) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 != -1) {
            finish();
        } else {
            new Handler().postDelayed(new cc(this), ContainerOpener.DEFAULT_TIMEOUT_IN_MILLIS);
            C0315l.m2018a("SplashScreen", "before geoip_load\n");
            NativeWrapper.jni_dickf(getFilesDir().getPath() + "/" + "GeoLite2-Country.mmdb");
            C0315l.m2018a("SplashScreen", "after geoip_load\n");
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a());
            Editor edit = defaultSharedPreferences.edit();
            boolean z = defaultSharedPreferences.getBoolean("ad_blocking_on", true);
            if (z) {
                edit.putBoolean("ad_blocking_on", z);
            }
            z = defaultSharedPreferences.getBoolean("malware_shield_on", this.f1531b.booleanValue());
            if (this.f1531b.booleanValue() && z) {
                edit.putBoolean("malware_shield_on", z);
            } else if (!this.f1531b.booleanValue()) {
            }
            Long valueOf = Long.valueOf(defaultSharedPreferences.getLong("night_start", -1));
            Long valueOf2 = Long.valueOf(defaultSharedPreferences.getLong("night_end", -1));
            if (valueOf.longValue() == -1 || valueOf2.longValue() == -1) {
                valueOf2 = Long.valueOf(79200000 - C0296a.m1931d());
                valueOf = Long.valueOf(28800000 - C0296a.m1931d());
                edit.putLong("night_start", valueOf2.longValue());
                edit.putLong("night_end", valueOf.longValue());
            }
            try {
                String str = "lastRunVersion";
                edit.putInt(str, getPackageManager().getPackageInfo(getPackageName(), 0).versionCode);
            } catch (Exception e) {
            }
            edit.apply();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0329l.splash_screen);
        if ("com.lostnet.fw.free".equals(getResources().getString(C0330m.package_name)) || !C0313j.m2004a((Context) this)) {
            this.f1531b = Boolean.FALSE;
        } else {
            this.f1531b = Boolean.TRUE;
        }
    }

    public void onStart() {
        super.onStart();
        C0318o.m2030a((Activity) this);
        mo752a();
    }

    public void onStop() {
        super.onStop();
        C0318o.m2032b(this);
    }
}
