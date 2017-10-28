package com.google.analytics.tracking.android;

class C0198q implements C0189d {
    final /* synthetic */ GAServiceManager f859a;

    C0198q(GAServiceManager gAServiceManager) {
        this.f859a = gAServiceManager;
    }

    public void mo573a(boolean z) {
        this.f859a.updatePowerSaveMode(z, this.f859a.connected);
    }
}
