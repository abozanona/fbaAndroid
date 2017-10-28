package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;

class ParameterLoaderImpl implements ParameterLoader {
	private final Context mContext;
	private String mOverrideResourcePackageName;

	public ParameterLoaderImpl(Context context) {
		if (context == null) {
			throw new NullPointerException("Context cannot be null");
		} else {
			this.mContext = context.getApplicationContext();
		}
	}

	private int getResourceIdForType(String key, String type) {
		if (this.mContext == null) {
			return 0;
		} else {
			return this.mContext.getResources().getIdentifier(key, type, (this.mOverrideResourcePackageName != null) ? this.mOverrideResourcePackageName : this.mContext.getPackageName());
		}
	}

	public boolean getBoolean(String key) {
		int id = getResourceIdForType(key, "bool");
		return (id == 0) ? false : "true".equalsIgnoreCase(this.mContext.getString(id));
	}

	public Double getDoubleFromString(String key) {
		String value = getString(key);
		if (TextUtils.isEmpty(value)) {
			return null;
		} else {
			try {
				return Double.valueOf(Double.parseDouble(value));
			} catch (NumberFormatException e) {
				Log.w("NumberFormatException parsing " + value);
				return null;
			}
		}
	}

	public int getInt(String key, int defaultValue) {
		int id = getResourceIdForType(key, "integer");
		if (id == 0) {
			return defaultValue;
		} else {
			try {
				return Integer.parseInt(this.mContext.getString(id));
			} catch (NumberFormatException e) {
				Log.w("NumberFormatException parsing " + this.mContext.getString(id));
				return defaultValue;
			}
		}
	}

	public String getString(String key) {
		int id = getResourceIdForType(key, "string");
		return (id == 0) ? null : this.mContext.getString(id);
	}

	public boolean isBooleanKeyPresent(String key) {
		return getResourceIdForType(key, "bool") != 0;
	}

	public void setResourcePackageName(String resourcePackageName) {
		this.mOverrideResourcePackageName = resourcePackageName;
	}
}
