package com.google.analytics.tracking.android;

import com.google.analytics.tracking.android.Logger.LogLevel;
import com.google.android.gms.common.util.VisibleForTesting;

public class Log {
    private static GoogleAnalytics sGaInstance;

    private Log() {
    }

    @VisibleForTesting
    static void clearGaInstance() {
        sGaInstance = null;
    }

    public static void m1075e(Exception exception) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.error(exception);
        }
    }

    public static void m1076e(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.error(str);
        }
    }

    private static Logger getLogger() {
        if (sGaInstance == null) {
            sGaInstance = GoogleAnalytics.getInstance();
        }
        return sGaInstance != null ? sGaInstance.getLogger() : null;
    }

    public static void m1077i(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.info(str);
        }
    }

    public static boolean isVerbose() {
        return getLogger() != null ? LogLevel.VERBOSE.equals(getLogger().getLogLevel()) : false;
    }

    public static void m1078v(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.verbose(str);
        }
    }

    public static void m1079w(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.warn(str);
        }
    }
}
