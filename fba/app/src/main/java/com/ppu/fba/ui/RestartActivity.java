package com.ppu.fba.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;

import com.ppu.fba.free.R;
import com.ppu.fba.p009d.C0318o;

public class RestartActivity extends Activity {
    AlertDialog f1502a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.splash_screen);
    }

    public void onStart() {
        super.onStart();
        C0318o.m2030a((Activity) this);
        Builder builder = new Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setMessage(R.string.restart_message);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.lnf2);
        builder.setPositiveButton(R.string.restart_button_restart, new dp(this));
        builder.setNegativeButton(R.string.restart_button_stop, new dq(this));
        this.f1502a = builder.create();
        this.f1502a.show();
    }

    public void onStop() {
        super.onStop();
        C0318o.m2032b(this);
    }
}