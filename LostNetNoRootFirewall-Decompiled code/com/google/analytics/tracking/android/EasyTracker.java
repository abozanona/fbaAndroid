package com.google.analytics.tracking.android;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.analytics.tracking.android.GAUsage.Field;
import com.google.analytics.tracking.android.Logger.LogLevel;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class EasyTracker extends Tracker {
    private static final int DEFAULT_SAMPLE_RATE = 100;
    private static final String EASY_TRACKER_NAME = "easy_tracker";
    static final int NUM_MILLISECONDS_TO_WAIT_FOR_OPEN_ACTIVITY = 1000;
    private static EasyTracker sInstance;
    private static String sResourcePackageName;
    private int mActivitiesActive;
    private final Map mActivityNameMap;
    private C0185i mClock;
    private Context mContext;
    private final GoogleAnalytics mGoogleAnalytics;
    private boolean mIsAutoActivityTracking;
    private boolean mIsInForeground;
    private boolean mIsReportUncaughtExceptionsEnabled;
    private long mLastOnStopTime;
    private ai mParameterFetcher;
    private ServiceManager mServiceManager;
    private long mSessionTimeout;
    private boolean mStartSessionOnNextSend;
    private Timer mTimer;
    private TimerTask mTimerTask;

    private EasyTracker(Context context) {
        this(context, new aj(context), GoogleAnalytics.getInstance(context), GAServiceManager.getInstance(), null);
    }

    private EasyTracker(Context context, ai aiVar, GoogleAnalytics googleAnalytics, ServiceManager serviceManager, aq aqVar) {
        String str = EASY_TRACKER_NAME;
        if (aqVar == null) {
            aqVar = googleAnalytics;
        }
        super(str, null, aqVar);
        this.mIsAutoActivityTracking = false;
        this.mActivitiesActive = 0;
        this.mActivityNameMap = new HashMap();
        this.mIsInForeground = false;
        this.mStartSessionOnNextSend = false;
        if (sResourcePackageName != null) {
            aiVar.mo556d(sResourcePackageName);
        }
        this.mGoogleAnalytics = googleAnalytics;
        setContext(context, aiVar, serviceManager);
        this.mClock = new C0194m(this);
    }

    private synchronized void clearExistingTimer() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    private String getActivityName(Activity activity) {
        String canonicalName = activity.getClass().getCanonicalName();
        if (this.mActivityNameMap.containsKey(canonicalName)) {
            return (String) this.mActivityNameMap.get(canonicalName);
        }
        String a = this.mParameterFetcher.mo553a(canonicalName);
        if (a == null) {
            a = canonicalName;
        }
        this.mActivityNameMap.put(canonicalName, a);
        return a;
    }

    public static EasyTracker getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new EasyTracker(context);
        }
        return sInstance;
    }

    private LogLevel getLogLevelFromString(String str) {
        try {
            return LogLevel.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @VisibleForTesting
    static EasyTracker getNewInstance(Context context, ai aiVar, GoogleAnalytics googleAnalytics, ServiceManager serviceManager, aq aqVar) {
        sInstance = new EasyTracker(context, aiVar, googleAnalytics, serviceManager, aqVar);
        return sInstance;
    }

    private void loadParameters() {
        Log.m1078v("Starting EasyTracker.");
        String a = this.mParameterFetcher.mo553a("ga_trackingId");
        if (TextUtils.isEmpty(a)) {
            a = this.mParameterFetcher.mo553a("ga_api_key");
        }
        set(Fields.TRACKING_ID, a);
        Log.m1078v("[EasyTracker] trackingId loaded: " + a);
        a = this.mParameterFetcher.mo553a("ga_appName");
        if (!TextUtils.isEmpty(a)) {
            Log.m1078v("[EasyTracker] app name loaded: " + a);
            set(Fields.APP_NAME, a);
        }
        a = this.mParameterFetcher.mo553a("ga_appVersion");
        if (a != null) {
            Log.m1078v("[EasyTracker] app version loaded: " + a);
            set(Fields.APP_VERSION, a);
        }
        a = this.mParameterFetcher.mo553a("ga_logLevel");
        if (a != null) {
            LogLevel logLevelFromString = getLogLevelFromString(a);
            if (logLevelFromString != null) {
                Log.m1078v("[EasyTracker] log level loaded: " + logLevelFromString);
                this.mGoogleAnalytics.getLogger().setLogLevel(logLevelFromString);
            }
        }
        Double b = this.mParameterFetcher.mo554b("ga_sampleFrequency");
        if (b == null) {
            b = new Double((double) this.mParameterFetcher.mo552a("ga_sampleRate", DEFAULT_SAMPLE_RATE));
        }
        if (b.doubleValue() != 100.0d) {
            set(Fields.SAMPLE_RATE, Double.toString(b.doubleValue()));
        }
        Log.m1078v("[EasyTracker] sample rate loaded: " + b);
        int a2 = this.mParameterFetcher.mo552a("ga_dispatchPeriod", 1800);
        Log.m1078v("[EasyTracker] dispatch period loaded: " + a2);
        this.mServiceManager.setLocalDispatchPeriod(a2);
        this.mSessionTimeout = (long) (this.mParameterFetcher.mo552a("ga_sessionTimeout", 30) * NUM_MILLISECONDS_TO_WAIT_FOR_OPEN_ACTIVITY);
        Log.m1078v("[EasyTracker] session timeout loaded: " + this.mSessionTimeout);
        boolean z = this.mParameterFetcher.mo555c("ga_autoActivityTracking") || this.mParameterFetcher.mo555c("ga_auto_activity_tracking");
        this.mIsAutoActivityTracking = z;
        Log.m1078v("[EasyTracker] auto activity tracking loaded: " + this.mIsAutoActivityTracking);
        z = this.mParameterFetcher.mo555c("ga_anonymizeIp");
        if (z) {
            set(Fields.ANONYMIZE_IP, "1");
            Log.m1078v("[EasyTracker] anonymize ip loaded: " + z);
        }
        this.mIsReportUncaughtExceptionsEnabled = this.mParameterFetcher.mo555c("ga_reportUncaughtExceptions");
        if (this.mIsReportUncaughtExceptionsEnabled) {
            Thread.setDefaultUncaughtExceptionHandler(new ExceptionReporter(this, this.mServiceManager, Thread.getDefaultUncaughtExceptionHandler(), this.mContext));
            Log.m1078v("[EasyTracker] report uncaught exceptions loaded: " + this.mIsReportUncaughtExceptionsEnabled);
        }
        this.mGoogleAnalytics.setDryRun(this.mParameterFetcher.mo555c("ga_dryRun"));
    }

    private void setContext(Context context, ai aiVar, ServiceManager serviceManager) {
        if (context == null) {
            Log.m1076e("Context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.mServiceManager = serviceManager;
        this.mParameterFetcher = aiVar;
        loadParameters();
    }

    public static void setResourcePackageName(String str) {
        sResourcePackageName = str;
    }

    public void activityStart(Activity activity) {
        GAUsage.m1070a().m1071a(Field.EASY_TRACKER_ACTIVITY_START);
        clearExistingTimer();
        if (!this.mIsInForeground && this.mActivitiesActive == 0 && checkForNewSession()) {
            this.mStartSessionOnNextSend = true;
        }
        this.mIsInForeground = true;
        this.mActivitiesActive++;
        if (this.mIsAutoActivityTracking) {
            Map hashMap = new HashMap();
            hashMap.put(Fields.HIT_TYPE, HitTypes.APP_VIEW);
            GAUsage.m1070a().m1072a(true);
            set("&cd", getActivityName(activity));
            send(hashMap);
            GAUsage.m1070a().m1072a(false);
        }
    }

    public void activityStop(Activity activity) {
        GAUsage.m1070a().m1071a(Field.EASY_TRACKER_ACTIVITY_STOP);
        this.mActivitiesActive--;
        this.mActivitiesActive = Math.max(0, this.mActivitiesActive);
        this.mLastOnStopTime = this.mClock.mo561a();
        if (this.mActivitiesActive == 0) {
            clearExistingTimer();
            this.mTimerTask = new C0195n();
            this.mTimer = new Timer("waitForActivityStart");
            this.mTimer.schedule(this.mTimerTask, 1000);
        }
    }

    boolean checkForNewSession() {
        return this.mSessionTimeout == 0 || (this.mSessionTimeout > 0 && this.mClock.mo561a() > this.mLastOnStopTime + this.mSessionTimeout);
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.mServiceManager.dispatchLocalHits();
    }

    @VisibleForTesting
    int getActivitiesActive() {
        return this.mActivitiesActive;
    }

    @VisibleForTesting
    void overrideUncaughtExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (this.mIsReportUncaughtExceptionsEnabled) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    public void send(Map map) {
        if (this.mStartSessionOnNextSend) {
            map.put(Fields.SESSION_CONTROL, "start");
            this.mStartSessionOnNextSend = false;
        }
        super.send(map);
    }

    @VisibleForTesting
    void setClock(C0185i c0185i) {
        this.mClock = c0185i;
    }
}
