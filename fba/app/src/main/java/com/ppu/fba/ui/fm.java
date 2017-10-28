package com.ppu.fba.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.C0318o;

class fm implements OnClickListener {
    final /* synthetic */ ToolsActivity f1860a;

    fm(ToolsActivity toolsActivity) {
        this.f1860a = toolsActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("market://search?q=pname:" + this.f1860a.getResources().getString(R.string.package_upgrade)));
        this.f1860a.startActivity(intent);
        C0318o.m2031a(MapBuilder.createEvent("buttons", "upgrade", "tools", null).build());
    }
}
