package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.List;

class NoopDispatcher implements Dispatcher {
	NoopDispatcher() {
	}

	public void close() {
	}

	public int dispatchHits(List<Hit> hits) {
		if (hits == null) {
			return 0;
		} else {
			int maxHits = Math.min(hits.size(), 40);
			if (Log.isVerbose()) {
				Log.v("Hits not actually being sent as dispatch is false...");
				int i = 0;
				while (i < maxHits) {
					String modifiedHit;
					String logMessage;
					modifiedHit = (TextUtils.isEmpty(((Hit) hits.get(i)).getHitParams())) ? "" : HitBuilder.postProcessHit((Hit) hits.get(i), System.currentTimeMillis());
					if (TextUtils.isEmpty(modifiedHit)) {
						logMessage = "Hit couldn't be read, wouldn't be sent:";
					} else if (modifiedHit.length() <= 2036) {
						logMessage = "GET would be sent:";
					} else if (modifiedHit.length() > 8192) {
						logMessage = "Would be too big:";
					} else {
						logMessage = "POST would be sent:";
					}
					Log.v(logMessage + modifiedHit);
					i++;
				}
				return maxHits;
			}
			return maxHits;
		}
	}

	public boolean okToDispatch() {
		return true;
	}

	public void overrideHostUrl(String hostOverride) {
	}
}
