package com.google.android.vending.licensing;

import android.util.Log;
import com.google.android.vending.licensing.ILicenseResultListener.Stub;

class C0212c extends Stub {
    final /* synthetic */ LicenseChecker f900a;
    private final C0215f f901b;
    private Runnable f902c;

    public C0212c(LicenseChecker licenseChecker, C0215f c0215f) {
        this.f900a = licenseChecker;
        this.f901b = c0215f;
        this.f902c = new C0213d(this, licenseChecker);
        m1242a();
    }

    private void m1242a() {
        Log.i("LicenseChecker", "Start monitoring timeout.");
        this.f900a.mHandler.postDelayed(this.f902c, 10000);
    }

    private void m1243b() {
        Log.i("LicenseChecker", "Clearing timeout.");
        this.f900a.mHandler.removeCallbacks(this.f902c);
    }

    public void verifyLicense(int i, String str, String str2) {
        this.f900a.mHandler.post(new C0214e(this, i, str, str2));
    }
}
