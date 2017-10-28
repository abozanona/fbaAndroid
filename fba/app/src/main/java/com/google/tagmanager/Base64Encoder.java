package com.google.tagmanager;

import android.os.Build.VERSION;
import android.util.Base64;
import com.google.android.gms.common.util.VisibleForTesting;

class Base64Encoder {
	public static final int DEFAULT = 0;
	public static final int NO_PADDING = 1;
	public static final int URL_SAFE = 2;

	Base64Encoder() {
	}

	public static byte[] decode(String s, int flags) {
		boolean websafeDesired = true;
		if (getSdkVersion() >= 8) {
			int newFlags = URL_SAFE;
			if ((flags & 1) != 0) {
				newFlags |= 1;
			}
			if ((flags & 2) != 0) {
				newFlags |= 8;
			}
			return Base64.decode(s, newFlags);
		} else {
			if ((flags & 1) == 0) {
				int r1i = 1;
			} else {
				boolean paddingDesired = false;
			}
			if ((flags & 2) != 0) {
				return (!websafeDesired) ? Base64.decodeWebSafe(s) : Base64.decode(s);
			} else {
				websafeDesired = false;
				if (!websafeDesired) {
				}
			}
		}
	}

	public static String encodeToString(byte[] input, int flags) {
		boolean websafeDesired = true;
		if (getSdkVersion() >= 8) {
			int newFlags = URL_SAFE;
			if ((flags & 1) != 0) {
				newFlags |= 1;
			}
			if ((flags & 2) != 0) {
				newFlags |= 8;
			}
			return Base64.encodeToString(input, newFlags);
		} else {
			boolean paddingDesired;
			paddingDesired = (flags & 1) == 0;
			if ((flags & 2) != 0) {
				return (!websafeDesired) ? Base64.encodeWebSafe(input, paddingDesired) : Base64.encode(input, paddingDesired);
			} else {
				websafeDesired = false;
				if (!websafeDesired) {
				}
			}
		}
	}

	@VisibleForTesting
	static int getSdkVersion() {
		return VERSION.SDK_INT;
	}
}
