package com.ppu.fba.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;

public abstract class ck extends Activity {

    protected abstract void mo752a();

    public void m2069a(String str) {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected Dialog onCreateDialog(int i) {
        return new Builder(this).setTitle("Application Not Licensed").setCancelable(false).setMessage("This application is not licensed. Please purchase it on Google Play").setPositiveButton("Buy App", new cm(this)).setNegativeButton("Exit", new cl(this)).create();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
