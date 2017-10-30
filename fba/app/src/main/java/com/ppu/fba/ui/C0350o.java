package com.ppu.fba.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.p009d.C0309f;
import com.ppu.fba.p009d.Log1;
import java.util.ArrayList;

class C0350o implements OnClickListener {
    final /* synthetic */ C0349n f1887a;
    final /* synthetic */ Context f1888b;
    final /* synthetic */ String f1889d;

    C0350o(C0349n c0349n, Context context, String str) {
        this.f1887a = c0349n;
        this.f1888b = context;
        this.f1889d = str;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f1888b, DetailsGeoActivity.class);
        intent.putExtra("name", C0309f.m1980c(this.f1889d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1889d);
        intent.putStringArrayListExtra("codes", arrayList);
        this.f1887a.f1884a.startActivity(intent);
        Log1.LogAction(("listAppCnts", "click", this.f1889d, null));
    }
}
