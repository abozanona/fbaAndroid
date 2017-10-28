package com.lostnet.fw.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.provider.Settings.Secure;
import com.google.android.vending.licensing.AESObfuscator;
import com.google.android.vending.licensing.LicenseChecker;
import com.google.android.vending.licensing.LicenseCheckerCallback;
import com.google.android.vending.licensing.ServerManagedPolicy;
import com.lostnet.fw.C0330m;

public abstract class ck extends Activity {
    private static final byte[] f1527a = new byte[]{(byte) -67, (byte) 82, (byte) 106, (byte) -20, (byte) 67, (byte) -29, (byte) 27, (byte) 13, (byte) 110, (byte) 81, (byte) -65, Byte.MAX_VALUE, (byte) 88, (byte) -58, (byte) -10, (byte) -110, (byte) 36, (byte) 74, (byte) -4, (byte) -82};
    private LicenseChecker f1528b;
    private LicenseCheckerCallback f1529c;

    protected abstract void mo752a();

    public void m2069a(String str) {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = Secure.getString(getContentResolver(), "android_id");
        this.f1529c = new cn();
        this.f1528b = new LicenseChecker(this, new ServerManagedPolicy(this, new AESObfuscator(f1527a, getResources().getString(C0330m.package_name), string)), "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA8H3zdOKZFAGfnzzMq6FaBAezs8LOmkBlw7stZ4IWPAEzlfKc4yPLNf81SFzMvLUZqq/w0n4yaqhmUnkckjwp2Ll5v1WRU4y5BOwIskCoL/eV5E0BKp3/G4soqngGhpocz8m5u/etVn+pOJFW7fHx4dvuVwuJ0TzR6zUDaXSPzebW0YCuIRVuzsAeohRe0BUHNU43WqEQkiXEMU2D8ULn+v+Z3MzEaSnUTVV0rsK9xYUhhEH0RGknozflJstCAXlIiDa34Kou2NIRgVisJ2dZWPwDvBMazQCzAnOiVGtdf5nKFmNCOC8p18k0l+Pbv2I5jcR+wMqB01M1rx4gF9wm1wIDAQAB");
    }

    protected Dialog onCreateDialog(int i) {
        return new Builder(this).setTitle("Application Not Licensed").setCancelable(false).setMessage("This application is not licensed. Please purchase it on Google Play").setPositiveButton("Buy App", new cm(this)).setNegativeButton("Exit", new cl(this)).create();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f1528b.onDestroy();
    }
}
