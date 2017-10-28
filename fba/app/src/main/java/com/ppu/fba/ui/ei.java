package com.ppu.fba.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ei implements OnClickListener {
    final /* synthetic */ int f1809a;
    final /* synthetic */ eg f1810b;

    ei(eg egVar, int i) {
        this.f1810b = egVar;
        this.f1809a = i;
    }

    public void onClick(View view) {
        this.f1810b.f1801b.f1512V.setSelection(this.f1809a);
        this.f1810b.f1801b.f1512V.onDetachedFromWindow();
    }
}
