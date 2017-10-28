package com.google.tagmanager;

import android.util.Log;
import com.google.tagmanager.Logger.LogLevel;

class ah implements Logger {
    private LogLevel f951a = LogLevel.WARNING;

    ah() {
    }

    public void mo609d(String str) {
        if (this.f951a.ordinal() <= LogLevel.DEBUG.ordinal()) {
            Log.d("GoogleTagManager", str);
        }
    }

    public void mo610d(String str, Throwable th) {
        if (this.f951a.ordinal() <= LogLevel.DEBUG.ordinal()) {
            Log.d("GoogleTagManager", str, th);
        }
    }

    public void mo611e(String str) {
        if (this.f951a.ordinal() <= LogLevel.ERROR.ordinal()) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void mo612e(String str, Throwable th) {
        if (this.f951a.ordinal() <= LogLevel.ERROR.ordinal()) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public LogLevel getLogLevel() {
        return this.f951a;
    }

    public void mo614i(String str) {
        if (this.f951a.ordinal() <= LogLevel.INFO.ordinal()) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void mo615i(String str, Throwable th) {
        if (this.f951a.ordinal() <= LogLevel.INFO.ordinal()) {
            Log.i("GoogleTagManager", str, th);
        }
    }

    public void setLogLevel(LogLevel logLevel) {
        this.f951a = logLevel;
    }

    public void mo617v(String str) {
        if (this.f951a.ordinal() <= LogLevel.VERBOSE.ordinal()) {
            Log.v("GoogleTagManager", str);
        }
    }

    public void mo618v(String str, Throwable th) {
        if (this.f951a.ordinal() <= LogLevel.VERBOSE.ordinal()) {
            Log.v("GoogleTagManager", str, th);
        }
    }

    public void mo619w(String str) {
        if (this.f951a.ordinal() <= LogLevel.WARNING.ordinal()) {
            Log.w("GoogleTagManager", str);
        }
    }

    public void mo620w(String str, Throwable th) {
        if (this.f951a.ordinal() <= LogLevel.WARNING.ordinal()) {
            Log.w("GoogleTagManager", str, th);
        }
    }
}
