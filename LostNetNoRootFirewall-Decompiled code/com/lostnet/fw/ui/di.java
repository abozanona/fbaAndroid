package com.lostnet.fw.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.lostnet.fw.C0288a;
import com.lostnet.fw.FirewallManagerService;

class di implements OnClickListener {
    final /* synthetic */ ProfileSelectActivity f1770a;

    di(ProfileSelectActivity profileSelectActivity) {
        this.f1770a = profileSelectActivity;
    }

    public void onClick(View view) {
        this.f1770a.f1493b.putString("currentProfile", this.f1770a.f1501j);
        this.f1770a.f1493b.commit();
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            a.m1863a(new C0288a(9));
        }
        this.f1770a.setResult(-1);
        this.f1770a.finish();
    }
}
