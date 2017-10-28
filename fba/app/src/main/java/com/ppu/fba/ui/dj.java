package com.ppu.fba.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.ppu.fba.C0288a;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p009d.C0317n;

class dj implements OnClickListener {
    final /* synthetic */ ProfileSelectActivity f1771a;

    dj(ProfileSelectActivity profileSelectActivity) {
        this.f1771a = profileSelectActivity;
    }

    public void onClick(View view) {
        String a = this.f1771a.f1501j;
        if (this.f1771a.f1501j.equals(this.f1771a.f1500i)) {
            if (this.f1771a.f1501j.equals(this.f1771a.f1494c[0])) {
                this.f1771a.f1501j = this.f1771a.f1494c[1];
            } else {
                this.f1771a.f1501j = this.f1771a.f1494c[0];
            }
            this.f1771a.f1500i = this.f1771a.f1501j;
            this.f1771a.f1493b.putString("currentProfile", this.f1771a.f1501j);
            this.f1771a.f1493b.commit();
            FirewallManagerService a2 = FirewallManagerService.m1852a(null);
            if (a2 != null) {
                a2.m1863a(new C0288a(9));
            }
        } else {
            this.f1771a.f1501j = this.f1771a.f1500i;
        }
        C0317n.m2028d(a);
        this.f1771a.m2053a();
    }
}
