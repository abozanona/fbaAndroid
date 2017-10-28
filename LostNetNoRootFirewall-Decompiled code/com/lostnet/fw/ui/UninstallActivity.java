package com.lostnet.fw.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import com.lostnet.fw.C0329l;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.p009d.C0310g;
import com.lostnet.fw.p009d.C0318o;

public class UninstallActivity extends Activity {
    AlertDialog f1553a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0329l.splash_screen);
    }

    public void onStart() {
        super.onStart();
        C0318o.m2030a((Activity) this);
        C0310g.m1992d();
        Builder builder = new Builder(this);
        builder.setTitle(C0330m.uninstall_title);
        builder.setMessage(C0330m.uninstall_message);
        builder.setCancelable(false);
        builder.setPositiveButton(C0330m.uninstall_button_anyway, new fo(this));
        builder.setNegativeButton(C0330m.uninstall_button_exit, new fp(this));
        this.f1553a = builder.create();
        this.f1553a.show();
    }

    public void onStop() {
        super.onStop();
        C0318o.m2032b(this);
    }
}
