package com.ppu.fba.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class fd implements OnCheckedChangeListener {
    final /* synthetic */ ToolSnifferActivity f1849a;

    fd(ToolSnifferActivity toolSnifferActivity) {
        this.f1849a = toolSnifferActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            Integer num = (Integer) this.f1849a.f1540i.getSelectedItem();
            if (num != null) {
                this.f1849a.f1541j = num.intValue();
            }
        }
    }
}
