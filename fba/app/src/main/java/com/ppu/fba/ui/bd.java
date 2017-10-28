package com.ppu.fba.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.ppu.fba.FirewallManagerService;

class bd implements OnClickListener {
    final /* synthetic */ DashboardActivity f1656a;

    bd(DashboardActivity dashboardActivity) {
        this.f1656a = dashboardActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (FirewallManagerService.m1852a(this.f1656a) != null) {
            synchronized (this.f1656a) {
                if (this.f1656a.f1448o != null) {
                    this.f1656a.f1448o.m2057c(this.f1656a);
                }
                if (this.f1656a.f1449p != null) {
                    this.f1656a.f1449p.m2057c(this.f1656a);
                }
                if (this.f1656a.f1450q != null) {
                    this.f1656a.f1450q.m2057c(this.f1656a);
                }
            }
        }
    }
}
