package com.ppu.fba.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.p009d.Log1;

class aa implements OnClickListener {
    final /* synthetic */ C0361z f1556a;
    final /* synthetic */ Context f1557b;
    final /* synthetic */ int f1558c;
    final /* synthetic */ String f1559d;

    aa(C0361z c0361z, Context context, int i, String str) {
        this.f1556a = c0361z;
        this.f1557b = context;
        this.f1558c = i;
        this.f1559d = str;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f1557b, DetailsAppActivity.class);
        intent.putExtra("id", this.f1558c);
        this.f1556a.f1909a.startActivity(intent);
        Log1.LogAction(("listCntApps", "click", this.f1559d, null));
    }
}
