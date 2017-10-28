package com.ppu.fba.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.C0318o;

class at implements OnClickListener {
    final /* synthetic */ ao f1619a;

    at(ao aoVar) {
        this.f1619a = aoVar;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://search?q=pname:" + this.f1619a.m37c().getText(R.string.package_name)));
        this.f1619a.m20a(intent);
        C0318o.m2031a(MapBuilder.createEvent("buttons", "update", null, null).build());
    }
}
