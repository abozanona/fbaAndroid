package com.lostnet.fw.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class fp implements OnClickListener {
    final /* synthetic */ UninstallActivity f1863a;

    fp(UninstallActivity uninstallActivity) {
        this.f1863a = uninstallActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1863a.setResult(0);
        this.f1863a.f1553a.dismiss();
        this.f1863a.finish();
    }
}
