package com.lostnet.fw.ui;

import com.google.android.vending.licensing.LicenseCheckerCallback;

class cn implements LicenseCheckerCallback {
    final /* synthetic */ ck f1736a;

    private cn(ck ckVar) {
        this.f1736a = ckVar;
    }

    public void allow(int i) {
        if (!this.f1736a.isFinishing()) {
            this.f1736a.mo752a();
        }
    }

    public void applicationError(int i) {
        if (!this.f1736a.isFinishing()) {
            this.f1736a.m2069a("Error: " + i);
            this.f1736a.mo752a();
        }
    }

    public void dontAllow(int i) {
        if (!this.f1736a.isFinishing()) {
            this.f1736a.showDialog(0);
        }
    }
}
