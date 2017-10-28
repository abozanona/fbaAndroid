package com.lostnet.fw.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class cj implements OnClickListener {
    final /* synthetic */ ImportActivity f1733a;

    cj(ImportActivity importActivity) {
        this.f1733a = importActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1733a.f1480a.dismiss();
        this.f1733a.finish();
    }
}
