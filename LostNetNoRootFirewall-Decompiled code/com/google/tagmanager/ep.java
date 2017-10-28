package com.google.tagmanager;

import com.google.analytics.tracking.android.Logger;
import com.google.analytics.tracking.android.Logger.LogLevel;

class ep implements Logger {
    ep() {
    }

    private static LogLevel m1656a(Logger.LogLevel logLevel) {
        switch (eo.f1154a[logLevel.ordinal()]) {
            case 1:
            case 2:
                return LogLevel.ERROR;
            case 3:
                return LogLevel.WARNING;
            case 4:
            case 5:
                return LogLevel.INFO;
            case 6:
                return LogLevel.VERBOSE;
            default:
                return LogLevel.ERROR;
        }
    }

    public void error(Exception exception) {
        bs.m1439a("", exception);
    }

    public void error(String str) {
        bs.m1438a(str);
    }

    public LogLevel getLogLevel() {
        Logger.LogLevel b = bs.m1440b();
        return b == null ? LogLevel.ERROR : m1656a(b);
    }

    public void info(String str) {
        bs.m1443c(str);
    }

    public void setLogLevel(LogLevel logLevel) {
        bs.m1441b("GA uses GTM logger. Please use TagManager.getLogger().setLogLevel(LogLevel) instead.");
    }

    public void verbose(String str) {
        bs.m1445e(str);
    }

    public void warn(String str) {
        bs.m1441b(str);
    }
}
