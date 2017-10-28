package com.ppu.fba.ui;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

class C0339do implements OnCheckedChangeListener {
    final /* synthetic */ ProfileSelectActivity f1776a;

    C0339do(ProfileSelectActivity profileSelectActivity) {
        this.f1776a = profileSelectActivity;
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        this.f1776a.f1501j = this.f1776a.f1494c[i];
    }
}
