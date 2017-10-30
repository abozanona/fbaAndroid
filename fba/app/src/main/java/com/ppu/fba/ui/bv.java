package com.ppu.fba.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.ppu.fba.C0288a;
import com.ppu.fba.free.R;
import com.ppu.fba.FirewallManagerService;

public class bv implements OnClickListener {
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
        this.f1708a.f1697a.setText(R.string.office_wifi_none);
        this.f1708a.dismiss();
    }
}
