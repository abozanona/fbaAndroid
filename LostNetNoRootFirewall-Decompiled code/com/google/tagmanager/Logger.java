package com.google.tagmanager;

public interface Logger {

    public enum LogLevel {
        VERBOSE,
        DEBUG,
        INFO,
        WARNING,
        ERROR,
        NONE
    }

    void mo609d(String str);

    void mo610d(String str, Throwable th);

    void mo611e(String str);

    void mo612e(String str, Throwable th);

    LogLevel getLogLevel();

    void mo614i(String str);

    void mo615i(String str, Throwable th);

    void setLogLevel(LogLevel logLevel);

    void mo617v(String str);

    void mo618v(String str, Throwable th);

    void mo619w(String str);

    void mo620w(String str, Throwable th);
}
