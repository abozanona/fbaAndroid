package com.ppu.fba.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import com.ppu.fba.free.R;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.C0310g;
import com.ppu.fba.p009d.Log1;

public class UninstallActivity extends Activity {
    AlertDialog f1553a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.splash_screen);
    }

    public void onStart() {
        super.onStart();
        C0310g.m1992d();
        Builder builder = new Builder(this);
        builder.setTitle(R.string.uninstall_title);
        builder.setMessage(R.string.uninstall_message);
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.uninstall_button_anyway, new fo(this));
        builder.setNegativeButton(R.string.uninstall_button_exit, new fp(this));
        this.f1553a = builder.create();
        this.f1553a.show();
    }

    public void onStop() {
        super.onStop();
    }
}
