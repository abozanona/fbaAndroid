package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.VisibleForTesting;

class AppFieldsDefaultProvider implements DefaultProvider {
	private static AppFieldsDefaultProvider sInstance;
	private static Object sInstanceLock;
	protected String mAppId;
	protected String mAppInstallerId;
	protected String mAppName;
	protected String mAppVersion;

	static {
		sInstanceLock = new Object();
	}

	@VisibleForTesting
	protected AppFieldsDefaultProvider() {
	}

	private AppFieldsDefaultProvider(Context c) {
		PackageInfo packageInfo;
		PackageManager pm = c.getPackageManager();
		this.mAppId = c.getPackageName();
		this.mAppInstallerId = pm.getInstallerPackageName(this.mAppId);
		String appName = this.mAppId;
		String appVersion = null;
		try {
			packageInfo = pm.getPackageInfo(c.getPackageName(), 0);
			if (packageInfo != null) {
				appName = pm.getApplicationLabel(packageInfo.applicationInfo).toString();
				appVersion = packageInfo.versionName;
			}
		} catch (NameNotFoundException e) {
			Log.e("Error retrieving package info: appName set to " + appName);
		}
		this.mAppName = appName;
		this.mAppVersion = appVersion;
	}

	@VisibleForTesting
	static void dropInstance() {
		Object r1_Object = sInstanceLock;
		synchronized(r1_Object) {
			sInstance = null;
		}
	}

	public static AppFieldsDefaultProvider getProvider() {
		return sInstance;
	}

	public static void initializeProvider(Context c) {
		Object r1_Object = sInstanceLock;
		synchronized(r1_Object) {
			if (sInstance == null) {
				sInstance = new AppFieldsDefaultProvider(c);
			}
		}
	}

	public String getValue(String field) {
		if (field == null) {
			return null;
		} else if (field.equals(Fields.APP_NAME)) {
			return this.mAppName;
		} else if (field.equals(Fields.APP_VERSION)) {
			return this.mAppVersion;
		} else if (field.equals(Fields.APP_ID)) {
			return this.mAppId;
		} else {
			if (field.equals(Fields.APP_INSTALLER_ID)) {
				return this.mAppInstallerId;
			}
			return null;
		}
	}

	public boolean providesField(String field) {
		return Fields.APP_NAME.equals(field) || Fields.APP_VERSION.equals(field) || Fields.APP_ID.equals(field) || Fields.APP_INSTALLER_ID.equals(field);
	}
}
