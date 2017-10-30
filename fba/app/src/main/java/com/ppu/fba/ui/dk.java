package com.ppu.fba.ui;

import android.view.View;
import android.view.View.OnClickListener;

public class dk implements OnClickListener {
    final /* synthetic */ ProfileSelectActivity f1772a;

    dk(ProfileSelectActivity profileSelectActivity) {
        this.f1772a = profileSelectActivity;
    }

    public void onClick(View view) {
        this.f1772a.setResult(0);
        this.f1772a.finish();
    }
}
