package com.lostnet.fw.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import com.lostnet.fw.C0327j;
import com.lostnet.fw.C0329l;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.p009d.C0318o;

public class RestartActivity extends Activity {
    AlertDialog f1502a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0329l.splash_screen);
    }

    public void onStart() {
        super.onStart();
        C0318o.m2030a((Activity) this);
        Builder builder = new Builder(this);
        builder.setTitle(C0330m.app_name);
        builder.setMessage(C0330m.restart_message);
        builder.setCancelable(false);
        builder.setIcon(C0327j.lnf2);
        builder.setPositiveButton(C0330m.restart_button_restart, new dp(this));
        builder.setNegativeButton(C0330m.restart_button_stop, new dq(this));
        this.f1502a = builder.create();
        this.f1502a.show();
    }

    public void onStop() {
        super.onStop();
        C0318o.m2032b(this);
    }
}
