package com.ppu.fba.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.ppu.fba.C0288a;
import com.ppu.fba.FirewallManagerService;

public class bu implements OnClickListener {
    final /* synthetic */ bt f1707a;

    bu(bt btVar) {
        this.f1707a = btVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        //this.f1707a.f1699c.putString("officeWifi", this.f1707a.f1701e);
        this.f1707a.f1699c.apply();
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            //a.f1306q = this.f1707a.f1701e;
            a.m1863a(new C0288a(5));
        }
        //this.f1707a.f1697a.setText(this.f1707a.f1701e);
        this.f1707a.dismiss();
    }
}
