package com.ppu.fba.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.ppu.fba.free.R;

class cm implements OnClickListener {
    final /* synthetic */ ck f1735a;

    cm(ck ckVar) {
        this.f1735a = ckVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1735a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://market.android.com/details?id=" + this.f1735a.getResources().getString(R.string.package_name))));
        this.f1735a.finish();
    }
}
