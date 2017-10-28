package com.google.analytics.tracking.android;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.common.util.VisibleForTesting;

class ScreenResolutionDefaultProvider implements DefaultProvider {
	private static ScreenResolutionDefaultProvider sInstance;
	private static Object sInstanceLock;
	private final Context mContext;

	static {
		sInstanceLock = new Object();
	}

	@VisibleForTesting
	protected ScreenResolutionDefaultProvider(Context c) {
		this.mContext = c;
	}

	@VisibleForTesting
	static void dropInstance() {
		Object r1_Object = sInstanceLock;
		synchronized(r1_Object) {
			sInstance = null;
		}
	}

	public static ScreenResolutionDefaultProvider getProvider() {
		ScreenResolutionDefaultProvider r0_ScreenResolutionDefaultProvider;
		Object r1_Object = sInstanceLock;
		synchronized(r1_Object) {
			r0_ScreenResolutionDefaultProvider = sInstance;
		}
		return r0_ScreenResolutionDefaultProvider;
	}

	public static void initializeProvider(Context c) {
		Object r1_Object = sInstanceLock;
		synchronized(r1_Object) {
			if (sInstance == null) {
				sInstance = new ScreenResolutionDefaultProvider(c);
			}
		}
	}

	protected String getScreenResolutionString() {
		DisplayMetrics dm = this.mContext.getResources().getDisplayMetrics();
		return dm.widthPixels + "x" + dm.heightPixels;
	}

	public String getValue(String field) {
		if (field == null) {
			return null;
		} else {
			if (field.equals(Fields.SCREEN_RESOLUTION)) {
				return getScreenResolutionString();
			}
			return null;
		}
	}

	public boolean providesField(String field) {
		return Fields.SCREEN_RESOLUTION.equals(field);
	}
}
