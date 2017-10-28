package com.ppu.fba.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ar implements OnClickListener {
    final /* synthetic */ ao f1617a;

    ar(ao aoVar) {
        this.f1617a = aoVar;
    }

    public void onClick(View view) {
        this.f1617a.m20a(new Intent(this.f1617a.m30b(), SettingsActivity.class));
    }
}
