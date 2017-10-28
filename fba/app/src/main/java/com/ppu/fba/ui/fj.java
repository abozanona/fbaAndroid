package com.ppu.fba.ui;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

class fj implements Runnable {
    final /* synthetic */ String f1856a;
    final /* synthetic */ fi f1857b;

    fj(fi fiVar, String str) {
        this.f1857b = fiVar;
        this.f1856a = str;
    }

    public void run() {
        Toast.makeText(this.f1857b.f1855a, "Opening " + this.f1856a, 0).show();
        this.f1857b.f1855a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f1856a)));
    }
}
