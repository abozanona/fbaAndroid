package com.lostnet.fw.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.p009d.C0318o;
import java.util.ArrayList;

class ej implements OnClickListener {
    final /* synthetic */ Context f1811a;
    final /* synthetic */ String f1812b;
    final /* synthetic */ ArrayList f1813c;
    final /* synthetic */ eg f1814d;

    ej(eg egVar, Context context, String str, ArrayList arrayList) {
        this.f1814d = egVar;
        this.f1811a = context;
        this.f1812b = str;
        this.f1813c = arrayList;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f1811a, DetailsGeoActivity.class);
        intent.putExtra("name", this.f1812b);
        intent.putStringArrayListExtra("codes", this.f1813c);
        this.f1814d.f1801b.m20a(intent);
        C0318o.m2031a(MapBuilder.createEvent("listGeo", "click", this.f1812b, null).build());
    }
}
