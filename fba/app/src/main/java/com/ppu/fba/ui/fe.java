package com.ppu.fba.ui;

import android.view.View;
import android.view.View.OnClickListener;

class fe implements OnClickListener {
    final /* synthetic */ ToolSnifferActivity f1850a;

    fe(ToolSnifferActivity toolSnifferActivity) {
        this.f1850a = toolSnifferActivity;
    }

    public void onClick(View view) {
        new fi(this.f1850a).execute(new Object[0]);
    }
}
