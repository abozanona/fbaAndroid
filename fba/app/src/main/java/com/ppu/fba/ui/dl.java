package com.ppu.fba.ui;

import android.view.View;
import android.view.View.OnClickListener;

public class dl implements OnClickListener {
    final /* synthetic */ ProfileSelectActivity f1773a;

    dl(ProfileSelectActivity profileSelectActivity) {
        this.f1773a = profileSelectActivity;
    }

    public void onClick(View view) {
        new bx().show(this.f1773a.getFragmentManager(), "profileAd");
    }
}
