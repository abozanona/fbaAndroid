package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import com.google.analytics.tracking.android.GAUsage.Field;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class GoogleAnalytics extends aq {
    private static GoogleAnalytics sInstance;
    private volatile Boolean mAppOptOut;
    private Context mContext;
    private Tracker mDefaultTracker;
    private boolean mDryRun;
    private Logger mLogger;
    private C0183e mThread;
    private final Map mTrackers;

    @VisibleForTesting
    protected GoogleAnalytics(Context context) {
        this(context, ab.m1087a(context));
    }

    private GoogleAnalytics(Context context, C0183e c0183e) {
        this.mAppOptOut = Boolean.valueOf(false);
        this.mTrackers = new HashMap();
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.mThread = c0183e;
        C0190f.m1187a(this.mContext);
        an.m1159a(this.mContext);
        C0191g.m1194a(this.mContext);
        this.mLogger = new C0193j();
    }

    @VisibleForTesting
    static void clearDefaultProviders() {
        C0190f.m1186a();
        an.m1160b();
        C0191g.m1193a();
    }

    @VisibleForTesting
    static void clearInstance() {
        synchronized (GoogleAnalytics.class) {
            sInstance = null;
            clearDefaultProviders();
        }
    }

    static GoogleAnalytics getInstance() {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            googleAnalytics = sInstance;
        }
        return googleAnalytics;
    }

    public static GoogleAnalytics getInstance(Context context) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (sInstance == null) {
                sInstance = new GoogleAnalytics(context);
            }
            googleAnalytics = sInstance;
        }
        return googleAnalytics;
    }

    @VisibleForTesting
    static GoogleAnalytics getNewInstance(Context context, C0183e c0183e) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (sInstance != null) {
                sInstance.close();
            }
            sInstance = new GoogleAnalytics(context, c0183e);
            googleAnalytics = sInstance;
        }
        return googleAnalytics;
    }

    @VisibleForTesting
    void close() {
    }

    public void closeTracker(String str) {
        synchronized (this) {
            GAUsage.m1070a().m1071a(Field.CLOSE_TRACKER);
            if (((Tracker) this.mTrackers.remove(str)) == this.mDefaultTracker) {
                this.mDefaultTracker = null;
            }
        }
    }

    public boolean getAppOptOut() {
        GAUsage.m1070a().m1071a(Field.GET_APP_OPT_OUT);
        return this.mAppOptOut.booleanValue();
    }

    public Tracker getDefaultTracker() {
        Tracker tracker;
        synchronized (this) {
            GAUsage.m1070a().m1071a(Field.GET_DEFAULT_TRACKER);
            tracker = this.mDefaultTracker;
        }
        return tracker;
    }

    public Logger getLogger() {
        return this.mLogger;
    }

    public Tracker getTracker(String str) {
        return getTracker(str, str);
    }

    public Tracker getTracker(String str, String str2) {
        Tracker tracker;
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Tracker name cannot be empty");
            }
            tracker = (Tracker) this.mTrackers.get(str);
            if (tracker == null) {
                tracker = new Tracker(str, str2, this);
                this.mTrackers.put(str, tracker);
                if (this.mDefaultTracker == null) {
                    this.mDefaultTracker = tracker;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                tracker.set(Fields.TRACKING_ID, str2);
            }
            GAUsage.m1070a().m1071a(Field.GET_TRACKER);
        }
        return tracker;
    }

    public boolean isDryRunEnabled() {
        GAUsage.m1070a().m1071a(Field.GET_DRY_RUN);
        return this.mDryRun;
    }

    void sendHit(Map map) {
        synchronized (this) {
            if (map == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            ar.m1182a(map, Fields.LANGUAGE, ar.m1180a(Locale.getDefault()));
            ar.m1182a(map, Fields.SCREEN_RESOLUTION, an.m1158a().mo562b(Fields.SCREEN_RESOLUTION));
            map.put("&_u", GAUsage.m1070a().m1074c());
            GAUsage.m1070a().m1073b();
            this.mThread.mo547a(map);
        }
    }

    public void setAppOptOut(boolean z) {
        GAUsage.m1070a().m1071a(Field.SET_APP_OPT_OUT);
        this.mAppOptOut = Boolean.valueOf(z);
        if (this.mAppOptOut.booleanValue()) {
            this.mThread.mo548b();
        }
    }

    public void setDefaultTracker(Tracker tracker) {
        synchronized (this) {
            GAUsage.m1070a().m1071a(Field.SET_DEFAULT_TRACKER);
            this.mDefaultTracker = tracker;
        }
    }

    public void setDryRun(boolean z) {
        GAUsage.m1070a().m1071a(Field.SET_DRY_RUN);
        this.mDryRun = z;
    }

    public void setLogger(Logger logger) {
        GAUsage.m1070a().m1071a(Field.SET_LOGGER);
        this.mLogger = logger;
    }
}
