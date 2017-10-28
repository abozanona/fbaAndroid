package com.lostnet.fw.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class dp implements OnClickListener {
    final /* synthetic */ RestartActivity f1777a;

    dp(RestartActivity restartActivity) {
        this.f1777a = restartActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1777a.setResult(-1);
        this.f1777a.f1502a.dismiss();
        this.f1777a.finish();
    }
}
