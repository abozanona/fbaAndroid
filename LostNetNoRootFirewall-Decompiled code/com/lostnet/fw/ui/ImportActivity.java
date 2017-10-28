package com.lostnet.fw.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import com.lostnet.fw.C0329l;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.p009d.C0310g;
import com.lostnet.fw.p009d.C0313j;
import com.lostnet.fw.p009d.C0318o;

public class ImportActivity extends Activity {
    AlertDialog f1480a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0329l.splash_screen);
    }

    public void onStart() {
        super.onStart();
        C0318o.m2030a((Activity) this);
        C0310g.m1992d();
        if (C0313j.m2005a("com.lostnet.fw.free")) {
            Builder builder = new Builder(this);
            builder.setTitle(C0330m.import_title);
            builder.setMessage(C0330m.import_message);
            builder.setCancelable(false);
            builder.setPositiveButton(C0330m.button_yes, new ci(this, this));
            builder.setNegativeButton(C0330m.button_no, new cj(this));
            this.f1480a = builder.create();
            this.f1480a.show();
            return;
        }
        setResult(-1);
        finish();
    }

    public void onStop() {
        super.onStop();
        C0318o.m2032b(this);
    }
}
