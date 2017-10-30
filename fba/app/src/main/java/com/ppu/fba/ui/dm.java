package com.ppu.fba.ui;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class dm implements OnCheckedChangeListener {
    final /* synthetic */ ProfileSelectActivity f1774a;

    dm(ProfileSelectActivity profileSelectActivity) {
        this.f1774a = profileSelectActivity;
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        this.f1774a.f1501j = this.f1774a.f1494c[i];
    }
}
