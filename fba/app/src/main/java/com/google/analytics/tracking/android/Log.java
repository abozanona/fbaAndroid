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

	public static void e(Exception e) {
		Logger l = getLogger();
		if (l != null) {
			l.error(e);
		}
	}

	public static void e(String msg) {
		Logger l = getLogger();
		if (l != null) {
			l.error(msg);
		}
	}

	private static Logger getLogger() {
		if (sGaInstance == null) {
			sGaInstance = GoogleAnalytics.getInstance();
		}
		return (sGaInstance != null) ? sGaInstance.getLogger() : null;
	}

	public static void i(String msg) {
		Logger l = getLogger();
		if (l != null) {
			l.info(msg);
		}
	}

	public static boolean isVerbose() {
		return (getLogger() != null) ? LogLevel.VERBOSE.equals(getLogger().getLogLevel()) : false;
	}

	public static void v(String msg) {
		Logger l = getLogger();
		if (l != null) {
			l.verbose(msg);
		}
	}

	public static void w(String msg) {
		Logger l = getLogger();
		if (l != null) {
			l.warn(msg);
		}
	}
}
