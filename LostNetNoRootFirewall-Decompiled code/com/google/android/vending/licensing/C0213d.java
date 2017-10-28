package com.google.android.vending.licensing;

import android.util.Log;

class C0213d implements Runnable {
    final /* synthetic */ LicenseChecker f903a;
    final /* synthetic */ C0212c f904b;

    C0213d(C0212c c0212c, LicenseChecker licenseChecker) {
        this.f904b = c0212c;
        this.f903a = licenseChecker;
    }

    public void run() {
        Log.i("LicenseChecker", "Check timed out.");
        this.f904b.f900a.handleServiceConnectionError(this.f904b.f901b);
        this.f904b.f900a.finishCheck(this.f904b.f901b);
    }
}
