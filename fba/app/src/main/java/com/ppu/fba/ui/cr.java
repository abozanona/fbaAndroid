package com.ppu.fba.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.C0310g;
import com.ppu.fba.p009d.Log1;

class cr implements OnClickListener {
    final /* synthetic */ LogsActivity f1742a;

    cr(LogsActivity logsActivity) {
        this.f1742a = logsActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("market://search?q=pname:" + this.f1742a.getResources().getString(R.string.package_name)));
        this.f1742a.startActivity(intent);
        Log1.LogAction(("buttons", "upgTha", null, null));
        C0310g.m1988b();
    }
}
