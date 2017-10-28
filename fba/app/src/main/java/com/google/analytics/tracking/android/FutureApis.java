package com.google.analytics.tracking.android;

import android.os.Build.VERSION;
import java.io.File;

class FutureApis {
	private FutureApis() {
	}

	static boolean setOwnerOnlyReadWrite(String path) {
		boolean r3z = false;
		if (version() < 9) {
			return false;
		} else {
			File file = new File(path);
			file.setReadable(r3z, r3z);
			file.setWritable(r3z, r3z);
			file.setReadable(true, true);
			file.setWritable(true, true);
			return true;
		}
	}

	public static int version() {
		try {
			return Integer.parseInt(VERSION.SDK);
		} catch (NumberFormatException e) {
			Log.e("Invalid version number: " + VERSION.SDK);
			return 0;
		}
	}
}
