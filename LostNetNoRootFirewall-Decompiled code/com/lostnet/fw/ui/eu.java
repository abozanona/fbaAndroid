package com.lostnet.fw.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.p009d.C0318o;

class eu implements OnClickListener {
    final /* synthetic */ SettingsActivity f1836a;

    eu(SettingsActivity settingsActivity) {
        this.f1836a = settingsActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("market://search?q=pname:" + this.f1836a.getResources().getString(C0330m.package_upgrade)));
        this.f1836a.startActivity(intent);
        C0318o.m2031a(MapBuilder.createEvent("buttons", "upgrade", null, null).build());
    }
}
