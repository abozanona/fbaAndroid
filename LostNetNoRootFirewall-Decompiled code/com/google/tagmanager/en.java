package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

class en {
    private GoogleAnalytics f1152a;
    private Context f1153b;

    en(Context context) {
        this.f1153b = context;
    }

    private synchronized void m1653a() {
        if (this.f1152a == null) {
            this.f1152a = GoogleAnalytics.getInstance(this.f1153b);
            this.f1152a.setLogger(new ep());
        }
    }

    public Tracker m1654a(String str) {
        m1653a();
        return this.f1152a.getTracker(str);
    }

    public void m1655a(Tracker tracker) {
        this.f1152a.closeTracker(tracker.getName());
    }
}
