package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.google.analytics.tracking.android.GAUsage.Field;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Tracker {
    static final long MAX_TOKENS = 120000;
    static final long NUM_TOKENS_PER_HIT = 2000;
    private final C0190f mAppFieldsDefaultProvider;
    private final C0191g mClientIdDefaultProvider;
    private final aq mHandler;
    private long mLastTrackTime;
    private final String mName;
    private final Map mParams;
    private final an mScreenResolutionDefaultProvider;
    private long mTokens;

    Tracker(String str, String str2, aq aqVar) {
        this(str, str2, aqVar, C0191g.m1196b(), an.m1158a(), C0190f.m1188b());
    }

    @VisibleForTesting
    Tracker(String str, String str2, aq aqVar, C0191g c0191g, an anVar, C0190f c0190f) {
        this.mParams = new HashMap();
        this.mTokens = MAX_TOKENS;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Tracker name cannot be empty.");
        }
        this.mName = str;
        this.mHandler = aqVar;
        this.mParams.put(Fields.TRACKING_ID, str2);
        this.mParams.put(Fields.USE_SECURE, "1");
        this.mClientIdDefaultProvider = c0191g;
        this.mScreenResolutionDefaultProvider = anVar;
        this.mAppFieldsDefaultProvider = c0190f;
    }

    public String get(String str) {
        GAUsage.m1070a().m1071a(Field.GET);
        return TextUtils.isEmpty(str) ? null : this.mParams.containsKey(str) ? (String) this.mParams.get(str) : str.equals(Fields.LANGUAGE) ? ar.m1180a(Locale.getDefault()) : (this.mClientIdDefaultProvider == null || !this.mClientIdDefaultProvider.m1200a(str)) ? (this.mScreenResolutionDefaultProvider == null || !this.mScreenResolutionDefaultProvider.m1161a(str)) ? (this.mAppFieldsDefaultProvider == null || !this.mAppFieldsDefaultProvider.m1189a(str)) ? null : this.mAppFieldsDefaultProvider.mo562b(str) : this.mScreenResolutionDefaultProvider.mo562b(str) : this.mClientIdDefaultProvider.mo562b(str);
    }

    public String getName() {
        GAUsage.m1070a().m1071a(Field.GET_TRACKER_NAME);
        return this.mName;
    }

    public void send(Map map) {
        GAUsage.m1070a().m1071a(Field.SEND);
        Map hashMap = new HashMap();
        hashMap.putAll(this.mParams);
        if (map != null) {
            hashMap.putAll(map);
        }
        if (TextUtils.isEmpty((CharSequence) hashMap.get(Fields.TRACKING_ID))) {
            Log.m1079w(String.format("Missing tracking id (%s) parameter.", new Object[]{Fields.TRACKING_ID}));
        }
        String str = (String) hashMap.get(Fields.HIT_TYPE);
        if (TextUtils.isEmpty(str)) {
            Log.m1079w(String.format("Missing hit type (%s) parameter.", new Object[]{Fields.HIT_TYPE}));
            str = "";
        }
        if (str.equals(HitTypes.TRANSACTION) || str.equals(HitTypes.ITEM) || tokensAvailable()) {
            this.mHandler.sendHit(hashMap);
        } else {
            Log.m1079w("Too many hits sent too quickly, rate limiting invoked.");
        }
    }

    public void set(String str, String str2) {
        GAUsage.m1070a().m1071a(Field.SET);
        if (str2 == null) {
            this.mParams.remove(str);
        } else {
            this.mParams.put(str, str2);
        }
    }

    @VisibleForTesting
    void setLastTrackTime(long j) {
        this.mLastTrackTime = j;
    }

    @VisibleForTesting
    void setTokens(long j) {
        this.mTokens = j;
    }

    @VisibleForTesting
    synchronized boolean tokensAvailable() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mTokens < MAX_TOKENS) {
            long j = currentTimeMillis - this.mLastTrackTime;
            if (j > 0) {
                this.mTokens = Math.min(MAX_TOKENS, j + this.mTokens);
            }
        }
        this.mLastTrackTime = currentTimeMillis;
        if (this.mTokens >= 2000) {
            this.mTokens -= 2000;
            z = true;
        } else {
            Log.m1079w("Excessive tracking detected.  Tracking call ignored.");
            z = false;
        }
        return z;
    }
}
