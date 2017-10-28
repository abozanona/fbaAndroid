package com.lostnet.fw.ui;

import android.support.v4.view.br;
import android.widget.TabHost;

class cq extends br {
    final /* synthetic */ TabHost f1740a;
    final /* synthetic */ LogsActivity f1741b;

    cq(LogsActivity logsActivity, TabHost tabHost) {
        this.f1741b = logsActivity;
        this.f1740a = tabHost;
    }

    public void mo100a(int i) {
        this.f1740a.setCurrentTab(i);
        if (i == 0 || i != 1) {
        }
    }
}
