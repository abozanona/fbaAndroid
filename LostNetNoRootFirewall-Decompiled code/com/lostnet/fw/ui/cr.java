package com.lostnet.fw.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.p009d.C0310g;
import com.lostnet.fw.p009d.C0318o;

class cr implements OnClickListener {
    final /* synthetic */ LogsActivity f1742a;

    cr(LogsActivity logsActivity) {
        this.f1742a = logsActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("market://search?q=pname:" + this.f1742a.getResources().getString(C0330m.package_name)));
        this.f1742a.startActivity(intent);
        C0318o.m2031a(MapBuilder.createEvent("buttons", "upgTha", null, null).build());
        C0310g.m1988b();
    }
}
