package com.ppu.fba.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class bq implements OnClickListener {
    final /* synthetic */ bp f1694a;

    bq(bp bpVar) {
        this.f1694a = bpVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1694a.f1688c = this.f1694a.f1691f.getText().toString();
        this.f1694a.f1689d = this.f1694a.f1692g.getText().toString();
        this.f1694a.f1690e = this.f1694a.f1693h.isChecked();
        this.f1694a.f1687b.putString("cloudshark", this.f1694a.f1688c);
        this.f1694a.f1687b.putString("cloudshark_key", this.f1694a.f1689d);
        this.f1694a.f1687b.putBoolean("cloudshark_https", this.f1694a.f1690e);
        this.f1694a.f1687b.apply();
        this.f1694a.dismiss();
    }
}
