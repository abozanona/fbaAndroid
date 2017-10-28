package com.google.analytics.tracking.android;

public interface Logger {
	public static enum LogLevel {
		VERBOSE,
		INFO,
		WARNING,
		ERROR;

	}


	public void error(Exception r1_Exception);

	public void error(String r1_String);

	public LogLevel getLogLevel();

	public void info(String r1_String);

	public void setLogLevel(LogLevel r1_LogLevel);

	public void verbose(String r1_String);

	public void warn(String r1_String);
}
