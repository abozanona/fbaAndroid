package com.ppu.fba.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class dc implements OnClickListener {
    final /* synthetic */ cx f1763a;
    final /* synthetic */ db f1764b;

    dc(db dbVar, cx cxVar) {
        this.f1764b = dbVar;
        this.f1763a = cxVar;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f1764b.f1761a, DetailsAppActivity.class);
        intent.putExtra("id", this.f1763a.f1748a.f1752b);
        this.f1764b.f1761a.startActivity(intent);
    }
}
