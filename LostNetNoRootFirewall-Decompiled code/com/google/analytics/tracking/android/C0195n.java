package com.google.analytics.tracking.android;

import java.util.TimerTask;

class C0195n extends TimerTask {
    final /* synthetic */ EasyTracker f856a;

    private C0195n(EasyTracker easyTracker) {
        this.f856a = easyTracker;
    }

    public void run() {
        this.f856a.mIsInForeground = false;
    }
}
