package com.ppu.fba.ui;

import android.view.View;
import android.view.View.OnClickListener;

public class eh implements OnClickListener {
    final /* synthetic */ int f1807a;
    final /* synthetic */ eg f1808b;

    eh(eg egVar, int i) {
        this.f1808b = egVar;
        this.f1807a = i;
    }

    public void onClick(View view) {
        this.f1808b.f1801b.f1512V.setSelection(this.f1807a);
        this.f1808b.f1801b.f1512V.onDetachedFromWindow();
    }
}
