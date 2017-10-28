package com.lostnet.fw.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class fc implements OnCheckedChangeListener {
    final /* synthetic */ ToolSnifferActivity f1848a;

    fc(ToolSnifferActivity toolSnifferActivity) {
        this.f1848a = toolSnifferActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f1848a.f1541j = -1;
        }
    }
}
