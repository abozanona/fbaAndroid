package com.ppu.fba.ui;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.ppu.fba.p009d.Log1;

public class am implements OnClickListener {
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
        Log.e("abozanona", "abozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\n");
        //this.f1594a.f1576a.m20a(intent);
        Log1.LogAction("listApps", "click", this.f1597d, null);
    }
}
