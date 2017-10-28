package com.google.analytics.tracking.android;

interface ParameterLoader {
	public boolean getBoolean(String r1_String);

	public Double getDoubleFromString(String r1_String);

	public int getInt(String r1_String, int r2i);

	public String getString(String r1_String);

	public boolean isBooleanKeyPresent(String r1_String);

	public void setResourcePackageName(String r1_String);
}
