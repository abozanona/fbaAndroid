package com.lostnet.fw.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ff implements OnClickListener {
    final /* synthetic */ ToolSnifferActivity f1851a;

    ff(ToolSnifferActivity toolSnifferActivity) {
        this.f1851a = toolSnifferActivity;
    }

    public void onClick(View view) {
        new bp().show(this.f1851a.getFragmentManager(), "cloudshark");
    }
}
