package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Logger.LogLevel;

final class Log {
	@VisibleForTesting
	static Logger sLogger;

	static {
		sLogger = new DefaultLogger();
	}

	Log() {
	}

	public static void d(String message) {
		sLogger.d(message);
	}

	public static void d(String message, Throwable t) {
		sLogger.d(message, t);
	}

	public static void e(String message) {
		sLogger.e(message);
	}

	public static void e(String message, Throwable t) {
		sLogger.e(message, t);
	}

	public static LogLevel getLogLevel() {
		return sLogger.getLogLevel();
	}

	public static Logger getLogger() {
		return (sLogger.getClass() == NoOpLogger.class) ? null : sLogger;
	}

	public static void i(String message) {
		sLogger.i(message);
	}

	public static void i(String message, Throwable t) {
		sLogger.i(message, t);
	}

	public static void setLogger(Logger logger) {
		if (logger == null) {
			sLogger = new NoOpLogger();
			return;
		} else {
			sLogger = logger;
		}
	}

	public static void v(String message) {
		sLogger.v(message);
	}

	public static void v(String message, Throwable t) {
		sLogger.v(message, t);
	}

	public static void w(String message) {
		sLogger.w(message);
	}

	public static void w(String message, Throwable t) {
		sLogger.w(message, t);
	}
}
