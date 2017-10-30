package com.ppu.fba.ui;

import android.widget.Toast;

public class fk implements Runnable {
    final /* synthetic */ fi f1858a;

    fk(fi fiVar) {
        this.f1858a = fiVar;
    }

    public void run() {
        Toast.makeText(this.f1858a.f1855a, "Failed to upload to CloudShark.", 0).show();
    }
}
