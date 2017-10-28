package com.lostnet.fw.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;
import com.lostnet.fw.p009d.C0317n;

class by implements OnClickListener {
    final /* synthetic */ EditText f1711a;
    final /* synthetic */ String[] f1712b;
    final /* synthetic */ Spinner f1713c;
    final /* synthetic */ String f1714d;
    final /* synthetic */ bx f1715e;

    by(bx bxVar, EditText editText, String[] strArr, Spinner spinner, String str) {
        this.f1715e = bxVar;
        this.f1711a = editText;
        this.f1712b = strArr;
        this.f1713c = spinner;
        this.f1714d = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        String obj = this.f1711a.getText().toString();
        String str = null;
        if (this.f1712b.length > 0) {
            str = (String) this.f1713c.getSelectedItem();
        }
        if (str == null || !this.f1714d.equals(str)) {
            C0317n.m2026b(obj, str);
        } else {
            C0317n.m2022a(obj);
        }
        this.f1715e.dismiss();
    }
}
