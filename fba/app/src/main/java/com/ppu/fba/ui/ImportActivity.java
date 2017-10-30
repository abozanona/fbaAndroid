package com.ppu.fba.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import com.ppu.fba.free.R;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.C0310g;
import com.ppu.fba.p009d.C0313j;
import com.ppu.fba.p009d.Log1;

public class ImportActivity extends Activity {
    AlertDialog f1480a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.splash_screen);
    }

    public void onStart() {
        super.onStart();
        C0310g.m1992d();
        if (C0313j.m2005a("com.ppu.fba.free")) {
            Builder builder = new Builder(this);
            builder.setTitle(R.string.import_title);
            builder.setMessage(R.string.import_message);
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.button_yes, new ci(this, this));
            builder.setNegativeButton(R.string.button_no, new cj(this));
            this.f1480a = builder.create();
            this.f1480a.show();
            return;
        }
        setResult(-1);
        finish();
    }

    public void onStop() {
        super.onStop();
    }
}
