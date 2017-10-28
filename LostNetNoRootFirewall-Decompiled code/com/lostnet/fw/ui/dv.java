package com.lostnet.fw.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lostnet.fw.p009d.C0310g;
import java.util.ArrayList;

class dv implements OnClickListener {
    final /* synthetic */ ArrayList f1784a;
    final /* synthetic */ be f1785b;

    dv(be beVar, ArrayList arrayList) {
        this.f1785b = beVar;
        this.f1784a = arrayList;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f1784a.size() > 0) {
            C0310g.m1996h();
        }
    }
}
