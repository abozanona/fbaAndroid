package com.lostnet.fw.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lostnet.fw.C0288a;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.FirewallManagerService;

class bv implements OnClickListener {
    final /* synthetic */ bt f1708a;

    bv(bt btVar) {
        this.f1708a = btVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1708a.f1699c.putString("officeWifi", null);
        this.f1708a.f1699c.apply();
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            a.f1306q = null;
            a.m1863a(new C0288a(5));
        }
        this.f1708a.f1697a.setText(C0330m.office_wifi_none);
        this.f1708a.dismiss();
    }
}
