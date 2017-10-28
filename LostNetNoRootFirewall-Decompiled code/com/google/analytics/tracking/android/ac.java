package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.Map;

class ac implements Runnable {
    final /* synthetic */ Map f808a;
    final /* synthetic */ ab f809b;

    ac(ab abVar, Map map) {
        this.f809b = abVar;
        this.f808a = map;
    }

    public void run() {
        if (TextUtils.isEmpty((CharSequence) this.f808a.get(Fields.CLIENT_ID))) {
            this.f808a.put(Fields.CLIENT_ID, this.f809b.f805f);
        }
        if (!GoogleAnalytics.getInstance(this.f809b.f807i).getAppOptOut() && !this.f809b.m1098c(this.f808a)) {
            if (!TextUtils.isEmpty(this.f809b.f804e)) {
                GAUsage.m1070a().m1072a(true);
                this.f808a.putAll(new MapBuilder().setCampaignParamsFromUrl(this.f809b.f804e).build());
                GAUsage.m1070a().m1072a(false);
                this.f809b.f804e = null;
            }
            this.f809b.m1100d(this.f808a);
            this.f809b.f806h.mo575a(ah.m1118a(this.f808a), Long.valueOf((String) this.f808a.get("&ht")).longValue(), this.f809b.m1094b(this.f808a), this.f809b.f803d);
        }
    }
}
