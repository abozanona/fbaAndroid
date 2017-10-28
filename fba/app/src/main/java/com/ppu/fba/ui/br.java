package com.ppu.fba.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class br implements OnClickListener {
    final /* synthetic */ bp f1695a;

    br(bp bpVar) {
        this.f1695a = bpVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1695a.f1688c = "www.cloudshark.org";
        this.f1695a.f1689d = "f450b127b5911af9c44732fe2a4cf417";
        this.f1695a.f1690e = true;
        this.f1695a.f1687b.putString("cloudshark", this.f1695a.f1688c);
        this.f1695a.f1687b.putString("cloudshark_key", this.f1695a.f1689d);
        this.f1695a.f1687b.putBoolean("cloudshark_https", this.f1695a.f1690e);
        this.f1695a.f1687b.apply();
        this.f1695a.f1691f.setText(this.f1695a.f1688c);
        this.f1695a.f1692g.setText(this.f1695a.f1689d);
        this.f1695a.f1693h.setChecked(this.f1695a.f1690e);
        this.f1695a.dismiss();
    }
}
