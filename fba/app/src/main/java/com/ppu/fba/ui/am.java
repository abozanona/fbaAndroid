package com.ppu.fba.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.p009d.C0318o;

class am implements OnClickListener {
    final /* synthetic */ ai f1594a;
    final /* synthetic */ Context f1595b;
    final /* synthetic */ int f1596c;
    final /* synthetic */ String f1597d;

    am(ai aiVar, Context context, int i, String str) {
        this.f1594a = aiVar;
        this.f1595b = context;
        this.f1596c = i;
        this.f1597d = str;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f1595b, DetailsAppActivity.class);
        intent.putExtra("id", this.f1596c);
        this.f1594a.f1576a.m20a(intent);
        C0318o.m2031a(MapBuilder.createEvent("listApps", "click", this.f1597d, null).build());
    }
}
