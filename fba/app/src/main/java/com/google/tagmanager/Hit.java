package com.google.tagmanager;

import android.text.TextUtils;

class Hit {
	private final long mHitFirstDispatchTime;
	private final long mHitId;
	private final long mHitTime;
	private String mHitUrl;

	Hit(long hitId, long hitTime) {
		this.mHitId = hitId;
		this.mHitTime = hitTime;
		this.mHitFirstDispatchTime = 0;
	}

	Hit(long hitId, long hitTime, long firstDispatchTime) {
		this.mHitId = hitId;
		this.mHitTime = hitTime;
		this.mHitFirstDispatchTime = firstDispatchTime;
	}

	long getHitFirstDispatchTime() {
		return this.mHitFirstDispatchTime;
	}

	long getHitId() {
		return this.mHitId;
	}

	long getHitTime() {
		return this.mHitTime;
	}

	String getHitUrl() {
		return this.mHitUrl;
	}

	void setHitUrl(String hitUrl) {
		if (hitUrl == null || TextUtils.isEmpty(hitUrl.trim())) {
		} else {
			this.mHitUrl = hitUrl;
		}
	}
}
