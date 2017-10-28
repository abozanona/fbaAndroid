package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.google.analytics.tracking.android.GAUsage.Field;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Tracker {
	static final long MAX_TOKENS = 120000;
	static final long NUM_TOKENS_PER_HIT = 2000;
	private final AppFieldsDefaultProvider mAppFieldsDefaultProvider;
	private final ClientIdDefaultProvider mClientIdDefaultProvider;
	private final TrackerHandler mHandler;
	private long mLastTrackTime;
	private final String mName;
	private final Map<String, String> mParams;
	private final ScreenResolutionDefaultProvider mScreenResolutionDefaultProvider;
	private long mTokens;

	Tracker(String name, String trackingId, TrackerHandler handler) {
		this(name, trackingId, handler, ClientIdDefaultProvider.getProvider(), ScreenResolutionDefaultProvider.getProvider(), AppFieldsDefaultProvider.getProvider());
	}

	@VisibleForTesting
	Tracker(String name, String trackingId, TrackerHandler handler, ClientIdDefaultProvider clientIdDefaultProvider, ScreenResolutionDefaultProvider screenResolutionDefaultProvider, AppFieldsDefaultProvider appFieldsDefaultProvider) {
		this.mParams = new HashMap();
		this.mTokens = 120000;
		if (TextUtils.isEmpty(name)) {
			throw new IllegalArgumentException("Tracker name cannot be empty.");
		} else {
			this.mName = name;
			this.mHandler = handler;
			this.mParams.put(Fields.TRACKING_ID, trackingId);
			this.mParams.put(Fields.USE_SECURE, "1");
			this.mClientIdDefaultProvider = clientIdDefaultProvider;
			this.mScreenResolutionDefaultProvider = screenResolutionDefaultProvider;
			this.mAppFieldsDefaultProvider = appFieldsDefaultProvider;
		}
	}

	public String get(String key) {
		GAUsage.getInstance().setUsage(Field.GET);
		if (TextUtils.isEmpty(key)) {
			return null;
		} else if (this.mParams.containsKey(key)) {
			return (String) this.mParams.get(key);
		} else if (key.equals(Fields.LANGUAGE)) {
			return Utils.getLanguage(Locale.getDefault());
		} else if (this.mClientIdDefaultProvider == null || !this.mClientIdDefaultProvider.providesField(key)) {
			if (this.mScreenResolutionDefaultProvider == null || !this.mScreenResolutionDefaultProvider.providesField(key)) {
				if (this.mAppFieldsDefaultProvider != null) {
					if (this.mAppFieldsDefaultProvider.providesField(key)) {
						return this.mAppFieldsDefaultProvider.getValue(key);
					}
					return null;
				}
				return null;
			} else {
				return this.mScreenResolutionDefaultProvider.getValue(key);
			}
		} else {
			return this.mClientIdDefaultProvider.getValue(key);
		}
	}

	public String getName() {
		GAUsage.getInstance().setUsage(Field.GET_TRACKER_NAME);
		return this.mName;
	}

	public void send(Map<String, String> params) {
		Object[] r3_Object_A;
		GAUsage.getInstance().setUsage(Field.SEND);
		Map<String, String> paramsToSend = new HashMap();
		paramsToSend.putAll(this.mParams);
		if (params != null) {
			paramsToSend.putAll(params);
		}
		if (TextUtils.isEmpty((CharSequence) paramsToSend.get(Fields.TRACKING_ID))) {
			r3_Object_A = new Object[1];
			r3_Object_A[0] = Fields.TRACKING_ID;
			Log.w(String.format("Missing tracking id (%s) parameter.", r3_Object_A));
		}
		String hitType = (String) paramsToSend.get(Fields.HIT_TYPE);
		if (TextUtils.isEmpty(hitType)) {
			r3_Object_A = new Object[1];
			r3_Object_A[0] = Fields.HIT_TYPE;
			Log.w(String.format("Missing hit type (%s) parameter.", r3_Object_A));
			hitType = "";
		}
		if (hitType.equals(HitTypes.TRANSACTION) || hitType.equals(HitTypes.ITEM) || tokensAvailable()) {
			this.mHandler.sendHit(paramsToSend);
			return;
		} else {
			Log.w("Too many hits sent too quickly, rate limiting invoked.");
		}
	}

	public void set(String key, String value) {
		GAUsage.getInstance().setUsage(Field.SET);
		if (value == null) {
			this.mParams.remove(key);
			return;
		} else {
			this.mParams.put(key, value);
		}
	}

	@VisibleForTesting
	void setLastTrackTime(long lastTrackTime) {
		this.mLastTrackTime = lastTrackTime;
	}

	@VisibleForTesting
	void setTokens(long tokens) {
		this.mTokens = tokens;
	}

	@VisibleForTesting
	synchronized boolean tokensAvailable() {
		boolean r4z;
		synchronized(this) {
			long timeNow = System.currentTimeMillis();
			if (this.mTokens < 120000) {
				long timeElapsed = timeNow - this.mLastTrackTime;
				if (timeElapsed > 0) {
					this.mTokens = Math.min(MAX_TOKENS, this.mTokens + timeElapsed);
				}
			}
			this.mLastTrackTime = timeNow;
			if (this.mTokens >= 2000) {
				this.mTokens -= 2000;
				r4z = true;
			} else {
				Log.w("Excessive tracking detected.  Tracking call ignored.");
				r4z = false;
			}
		}
		return r4z;
	}
}
