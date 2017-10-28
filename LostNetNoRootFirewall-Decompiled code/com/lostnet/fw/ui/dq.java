package com.lostnet.fw.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class dq implements OnClickListener {
    final /* synthetic */ RestartActivity f1778a;

    dq(RestartActivity restartActivity) {
        this.f1778a = restartActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1778a.setResult(0);
        this.f1778a.f1502a.dismiss();
        this.f1778a.finish();
    }
}
