package com.google.analytics.tracking.android;

import android.text.TextUtils;

class Hit {
	private final long mHitId;
	private String mHitString;
	private final long mHitTime;
	private String mHitUrlScheme;

	Hit(String hitString, long hitId, long hitTime) {
		this.mHitUrlScheme = "https:";
		this.mHitString = hitString;
		this.mHitId = hitId;
		this.mHitTime = hitTime;
	}

	long getHitId() {
		return this.mHitId;
	}

	String getHitParams() {
		return this.mHitString;
	}

	long getHitTime() {
		return this.mHitTime;
	}

	String getHitUrlScheme() {
		return this.mHitUrlScheme;
	}

	void setHitString(String hitString) {
		this.mHitString = hitString;
	}

	void setHitUrl(String hitUrl) {
		if (hitUrl == null || TextUtils.isEmpty(hitUrl.trim()) || !hitUrl.toLowerCase().startsWith("http:")) {
		} else {
			this.mHitUrlScheme = "http:";
		}
	}
}
