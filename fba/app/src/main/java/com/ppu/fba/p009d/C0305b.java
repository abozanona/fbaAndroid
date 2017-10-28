package com.ppu.fba.p009d;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.ppu.fba.free.R;

final class C0305b implements OnClickListener {
    final /* synthetic */ Context f1389a;
    final /* synthetic */ Dialog f1390b;

    C0305b(Context context, Dialog dialog) {
        this.f1389a = context;
        this.f1390b = dialog;
    }

    public void onClick(View view) {
        this.f1389a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.f1389a.getResources().getText(R.string.package_name))));
        this.f1390b.dismiss();
    }
}
