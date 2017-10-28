package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class HitBuilder {
	HitBuilder() {
	}

	static String encode(String input) {
		try {
			return URLEncoder.encode(input, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new AssertionError("URL encoding failed for: " + input);
		}
	}

	static Map<String, String> generateHitParams(Map<String, String> hit) {
		Map<String, String> params = new HashMap();
		Iterator i$ = hit.entrySet().iterator();
		while (i$.hasNext()) {
			Entry<String, String> entry = (Entry) i$.next();
			if (!((String) entry.getKey()).startsWith("&") || entry.getValue() == null) {
			} else {
				String urlParam = ((String) entry.getKey()).substring(1);
				if (!TextUtils.isEmpty(urlParam)) {
					params.put(urlParam, entry.getValue());
				}
			}
		}
		return params;
	}

	static String postProcessHit(Hit hit, long currentTimeMillis) {
		StringBuilder builder = new StringBuilder();
		builder.append(hit.getHitParams());
		if (hit.getHitTime() > 0) {
			long queueTime = currentTimeMillis - hit.getHitTime();
			if (queueTime >= 0) {
				builder.append("&qt").append("=").append(queueTime);
			}
		}
		builder.append("&z").append("=").append(hit.getHitId());
		return builder.toString();
	}
}
