package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;

class SendHitRateLimiter implements RateLimiter {
	private long mLastTrackTime;
	private final int mMaxTokens;
	private final long mMillisecondsPerToken;
	private final Object mTokenLock;
	private double mTokens;

	public SendHitRateLimiter() {
		this(60, 2000);
	}

	public SendHitRateLimiter(int maxTokenCount, long millisecondsPerToken) {
		this.mTokenLock = new Object();
		this.mMaxTokens = maxTokenCount;
		this.mTokens = (double) this.mMaxTokens;
		this.mMillisecondsPerToken = millisecondsPerToken;
	}

	@VisibleForTesting
	void setLastTrackTime(long lastTrackTime) {
		this.mLastTrackTime = lastTrackTime;
	}

	@VisibleForTesting
	void setTokensAvailable(long tokens) {
		this.mTokens = (double) tokens;
	}

	public boolean tokenAvailable() {
		boolean r6z;
		Object r7_Object = this.mTokenLock;
		synchronized(r7_Object) {
			long timeNow = System.currentTimeMillis();
			if (this.mTokens < ((double) this.mMaxTokens)) {
				double tokensDue = ((double) (timeNow - this.mLastTrackTime)) / ((double) this.mMillisecondsPerToken);
				if (tokensDue > 0.0d) {
					this.mTokens = Math.min((double) this.mMaxTokens, this.mTokens + tokensDue);
				}
			}
			this.mLastTrackTime = timeNow;
			if (this.mTokens >= 1.0d) {
				this.mTokens -= 1.0d;
				r6z = true;
			} else {
				Log.w("No more tokens available.");
				r6z = false;
			}
		}
		return r6z;
	}
}
