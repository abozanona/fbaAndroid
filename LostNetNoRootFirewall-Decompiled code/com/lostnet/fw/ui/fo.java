package com.lostnet.fw.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class fo implements OnClickListener {
    final /* synthetic */ UninstallActivity f1862a;

    fo(UninstallActivity uninstallActivity) {
        this.f1862a = uninstallActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1862a.setResult(-1);
        this.f1862a.f1553a.dismiss();
        this.f1862a.finish();
    }
}
