package com.google.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

class InstallReferrerUtil {
	static final String INTENT_EXTRA_REFERRER = "referrer";
	static final String PREF_KEY_REFERRER = "referrer";
	static final String PREF_NAME_CLICK_REFERRERS = "gtm_click_referrers";
	static final String PREF_NAME_INSTALL_REFERRER = "gtm_install_referrer";
	@VisibleForTesting
	static Map<String, String> clickReferrers;
	private static String installReferrer;

	static {
		clickReferrers = new HashMap();
	}

	InstallReferrerUtil() {
	}

	static void addClickReferrer(Context context, String referrer) {
		String conversionId = extractComponent(referrer, "conv");
		if (conversionId == null || conversionId.length() <= 0) {
		} else {
			clickReferrers.put(conversionId, referrer);
			SharedPreferencesUtil.saveAsync(context, PREF_NAME_CLICK_REFERRERS, conversionId, referrer);
		}
	}

	static void cacheInstallReferrer(String referrer) {
		Class r1_Class = InstallReferrerUtil.class;
		synchronized(r1_Class) {
			installReferrer = referrer;
		}
	}

	static String extractComponent(String referrer, String component) {
		if (component == null) {
			return (referrer.length() > 0) ? referrer : null;
		} else {
			return Uri.parse("http://hostname/?" + referrer).getQueryParameter(component);
		}
	}

	static String getClickReferrer(Context context, String conversionId, String component) {
		String referrer = (String) clickReferrers.get(conversionId);
		if (referrer == null) {
			SharedPreferences settings = context.getSharedPreferences(PREF_NAME_CLICK_REFERRERS, 0);
			referrer = (settings != null) ? settings.getString(conversionId, "") : "";
			clickReferrers.put(conversionId, referrer);
		}
		return extractComponent(referrer, component);
	}

	static String getInstallReferrer(Context context, String component) {
		if (installReferrer == null) {
			Class r2_Class = InstallReferrerUtil.class;
			synchronized(r2_Class) {
				if (installReferrer == null) {
					SharedPreferences settings = context.getSharedPreferences(PREF_NAME_INSTALL_REFERRER, 0);
					if (settings != null) {
						installReferrer = settings.getString(PREF_KEY_REFERRER, "");
					} else {
						installReferrer = "";
					}
				}
			}
		}
		return extractComponent(installReferrer, component);
	}

	static void saveInstallReferrer(Context context, String referrer) {
		SharedPreferencesUtil.saveAsync(context, PREF_NAME_INSTALL_REFERRER, PREF_KEY_REFERRER, referrer);
		addClickReferrer(context, referrer);
	}
}
