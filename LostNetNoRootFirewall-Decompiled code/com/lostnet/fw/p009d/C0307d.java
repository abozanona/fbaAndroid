package com.lostnet.fw.p009d;

import android.app.Dialog;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;

final class C0307d implements OnClickListener {
    final /* synthetic */ Editor f1392a;
    final /* synthetic */ Dialog f1393b;

    C0307d(Editor editor, Dialog dialog) {
        this.f1392a = editor;
        this.f1393b = dialog;
    }

    public void onClick(View view) {
        if (this.f1392a != null) {
            this.f1392a.putBoolean("dontshowagain", true);
            this.f1392a.commit();
        }
        this.f1393b.dismiss();
    }
}
