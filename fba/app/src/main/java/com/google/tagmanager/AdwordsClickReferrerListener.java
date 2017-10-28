package com.google.tagmanager;

import android.content.Context;
import com.google.tagmanager.DataLayer.Listener;
import java.util.Map;

class AdwordsClickReferrerListener implements Listener {
	private final Context context;

	public AdwordsClickReferrerListener(Context context) {
		this.context = context;
	}

	/* JADX WARNING: inconsistent code */
	/*
	public void changed(java.util.Map<java.lang.Object, java.lang.Object> r6_update) {
		r5_this = this;
		r4 = "gtm.url";
		r3 = r6_update.get(r4);
		if (r3_url != 0) goto L_0x001c;
	L_0x0008:
		r4 = "gtm";
		r0 = r6_update.get(r4);
		if (r0_gtm == 0) goto L_0x001c;
	L_0x0010:
		r4 = r0_gtm instanceof java.util.Map;
		if (r4 == 0) goto L_0x001c;
	L_0x0014:
		r0_gtm = (java.util.Map) r0_gtm;
		r4 = "url";
		r3_url = r0.get(r4);
	L_0x001c:
		if (r3_url == 0) goto L_0x0022;
	L_0x001e:
		r4 = r3_url instanceof java.lang.String;
		if (r4 != 0) goto L_0x0023;
	L_0x0022:
		return;
	L_0x0023:
		r3_url = (java.lang.String) r3_url;
		r2 = android.net.Uri.parse(r3_url);
		r4 = "referrer";
		r1 = r2_uri.getQueryParameter(r4);
		if (r1_referrer == 0) goto L_0x0022;
	L_0x0031:
		r4 = r5.context;
		com.google.tagmanager.InstallReferrerUtil.addClickReferrer(r4, r1);
		goto L_0x0022;
	}
	*/
	public void changed(Map<Object, Object> r6_Map_ObjectObject) {
		Object url = update.get("gtm.url");
		if (url == null) {
			Object gtm = update.get("gtm");
			if (gtm == null || !((gtm instanceof Map))) {
			} else {
				url = ((Map) gtm).get("url");
			}
		}
	}
}
