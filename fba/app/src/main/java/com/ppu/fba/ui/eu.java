package com.ppu.fba.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.Log1;

class eu implements OnClickListener {
    final /* synthetic */ SettingsActivity f1836a;

    eu(SettingsActivity settingsActivity) {
        this.f1836a = settingsActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("market://search?q=pname:" + this.f1836a.getResources().getString(R.string.package_upgrade)));
        this.f1836a.startActivity(intent);
        Log1.LogAction(("buttons", "upgrade", null, null));
    }
}
