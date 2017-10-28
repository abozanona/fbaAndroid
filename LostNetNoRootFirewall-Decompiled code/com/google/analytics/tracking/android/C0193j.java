package com.google.analytics.tracking.android;

import android.util.Log;
import com.google.analytics.tracking.android.Logger.LogLevel;

class C0193j implements Logger {
    private LogLevel f854a = LogLevel.INFO;

    C0193j() {
    }

    private String m1204a(String str) {
        return Thread.currentThread().toString() + ": " + str;
    }

    public void error(Exception exception) {
        if (this.f854a.ordinal() <= LogLevel.ERROR.ordinal()) {
            Log.e("GAV3", null, exception);
        }
    }

    public void error(String str) {
        if (this.f854a.ordinal() <= LogLevel.ERROR.ordinal()) {
            Log.e("GAV3", m1204a(str));
        }
    }

    public LogLevel getLogLevel() {
        return this.f854a;
    }

    public void info(String str) {
        if (this.f854a.ordinal() <= LogLevel.INFO.ordinal()) {
            Log.i("GAV3", m1204a(str));
        }
    }

    public void setLogLevel(LogLevel logLevel) {
        this.f854a = logLevel;
    }

    public void verbose(String str) {
        if (this.f854a.ordinal() <= LogLevel.VERBOSE.ordinal()) {
            Log.v("GAV3", m1204a(str));
        }
    }

    public void warn(String str) {
        if (this.f854a.ordinal() <= LogLevel.WARNING.ordinal()) {
            Log.w("GAV3", m1204a(str));
        }
    }
}
