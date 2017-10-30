package com.ppu.fba.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.ppu.fba.p004a.C0284b;
import com.ppu.fba.p004a.C0285c;
import com.ppu.fba.p004a.C0286d;
import com.ppu.fba.p009d.C0308e;
import com.ppu.fba.p009d.C0309f;
import com.ppu.fba.p009d.Log1;

public class ax implements OnClickListener {
    final /* synthetic */ aw f1625a;
    final /* synthetic */ C0284b f1626b;
    final /* synthetic */ int f1627c;
    final /* synthetic */ Context f1628d;

    ax(aw awVar, C0284b c0284b, int i, Context context) {
        this.f1625a = awVar;
        this.f1626b = c0284b;
        this.f1627c = i;
        this.f1628d = context;
    }

    public void onClick(View view) {
        C0285c.m1913a(new C0285c(this.f1626b, this.f1627c, C0286d.CANCEL));
        if (this.f1626b == C0284b.APPLICATION) {
            Log1.LogAction("suggApps", "buttonCancel", C0308e.m1970c(this.f1627c), null);
        } else {
            Log1.LogAction("suggCnts", "buttonCancel", C0309f.m1974a(this.f1627c), null);
        }
        this.f1625a.f1623a.m2057c(this.f1628d);
    }
}
