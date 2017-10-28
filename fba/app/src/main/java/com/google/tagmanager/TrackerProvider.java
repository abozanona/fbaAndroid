package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Logger;
import com.google.analytics.tracking.android.Logger.LogLevel;
import com.google.analytics.tracking.android.Tracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Logger.LogLevel;
import com.google.tagmanager.protobuf.WireFormat;

class TrackerProvider {
	private Context mContext;
	private GoogleAnalytics mGoogleAnalytics;

	static /* synthetic */ class AnonymousClass_1 {
		static final /* synthetic */ int[] $SwitchMap$com$google$tagmanager$Logger$LogLevel;

		static {
			$SwitchMap$com$google$tagmanager$Logger$LogLevel = new int[LogLevel.values().length];
			try {
				$SwitchMap$com$google$tagmanager$Logger$LogLevel[LogLevel.NONE.ordinal()] = 1;
			} catch (NoSuchFieldError e) {
			}
			try {
				$SwitchMap$com$google$tagmanager$Logger$LogLevel[LogLevel.ERROR.ordinal()] = 2;
			} catch (NoSuchFieldError e_2) {
			}
			try {
				$SwitchMap$com$google$tagmanager$Logger$LogLevel[LogLevel.WARNING.ordinal()] = 3;
			} catch (NoSuchFieldError e_3) {
			}
			try {
				$SwitchMap$com$google$tagmanager$Logger$LogLevel[LogLevel.INFO.ordinal()] = 4;
			} catch (NoSuchFieldError e_4) {
			}
			try {
				$SwitchMap$com$google$tagmanager$Logger$LogLevel[LogLevel.DEBUG.ordinal()] = 5;
			} catch (NoSuchFieldError e_5) {
			}
			$SwitchMap$com$google$tagmanager$Logger$LogLevel[LogLevel.VERBOSE.ordinal()] = 6;
		}
	}

	static class LoggerImpl implements Logger {
		LoggerImpl() {
		}

		private static LogLevel toAnalyticsLogLevel(LogLevel logLevel) {
			switch(TrackerProvider.AnonymousClass_1.$SwitchMap$com$google$tagmanager$Logger$LogLevel[logLevel.ordinal()]) {
			case WireFormat.WIRETYPE_FIXED64:
			case WireFormat.WIRETYPE_LENGTH_DELIMITED:
				return LogLevel.ERROR;
			case WireFormat.WIRETYPE_START_GROUP:
				return LogLevel.WARNING;
			case WireFormat.WIRETYPE_END_GROUP:
			case WireFormat.WIRETYPE_FIXED32:
				return LogLevel.INFO;
			case Value.MACRO_REFERENCE_FIELD_NUMBER:
				return LogLevel.VERBOSE;
			}
			return LogLevel.ERROR;
		}

		public void error(Exception exception) {
			Log.e("", exception);
		}

		public void error(String message) {
			Log.e(message);
		}

		public LogLevel getLogLevel() {
			LogLevel logLevel = Log.getLogLevel();
			return (logLevel == null) ? LogLevel.ERROR : toAnalyticsLogLevel(logLevel);
		}

		public void info(String message) {
			Log.i(message);
		}

		public void setLogLevel(LogLevel logLevel) {
			Log.w("GA uses GTM logger. Please use TagManager.getLogger().setLogLevel(LogLevel) instead.");
		}

		public void verbose(String message) {
			Log.v(message);
		}

		public void warn(String message) {
			Log.w(message);
		}
	}


	TrackerProvider(Context context) {
		this.mContext = context;
	}

	@VisibleForTesting
	TrackerProvider(GoogleAnalytics ga) {
		this.mGoogleAnalytics = ga;
		this.mGoogleAnalytics.setLogger(new LoggerImpl());
	}

	private synchronized void initTrackProviderIfNecessary() {
		synchronized(this) {
			if (this.mGoogleAnalytics == null) {
				this.mGoogleAnalytics = GoogleAnalytics.getInstance(this.mContext);
				this.mGoogleAnalytics.setLogger(new LoggerImpl());
			}
		}
	}

	public void close(Tracker tracker) {
		this.mGoogleAnalytics.closeTracker(tracker.getName());
	}

	public Tracker getTracker(String trackingId) {
		initTrackProviderIfNecessary();
		return this.mGoogleAnalytics.getTracker(trackingId);
	}
}
