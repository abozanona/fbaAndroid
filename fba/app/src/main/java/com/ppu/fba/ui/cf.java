package com.ppu.fba.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class cf implements OnClickListener {
    final /* synthetic */ ce f1728a;

    cf(ce ceVar) {
        this.f1728a = ceVar;
    }

    public void onClick(View view) {
        this.f1728a.b.startActivity(new Intent(this.f1728a.b, LogsActivity.class));
    }
}
