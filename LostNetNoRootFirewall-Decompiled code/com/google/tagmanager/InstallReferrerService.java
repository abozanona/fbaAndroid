package com.google.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.analytics.tracking.android.CampaignTrackingService;
import com.google.android.gms.common.util.VisibleForTesting;

public final class InstallReferrerService extends IntentService {
    @VisibleForTesting
    Context contextOverride;
    @VisibleForTesting
    CampaignTrackingService gaService;

    public InstallReferrerService() {
        super("InstallReferrerService");
    }

    public InstallReferrerService(String str) {
        super(str);
    }

    private void forwardToGoogleAnalytics(Context context, Intent intent) {
        if (this.gaService == null) {
            this.gaService = new CampaignTrackingService();
        }
        this.gaService.processIntent(context, intent);
    }

    protected void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        Context applicationContext = this.contextOverride != null ? this.contextOverride : getApplicationContext();
        bi.m1416a(applicationContext, stringExtra);
        forwardToGoogleAnalytics(applicationContext, intent);
    }
}
