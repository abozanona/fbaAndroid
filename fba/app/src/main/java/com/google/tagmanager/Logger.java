package com.google.tagmanager;

public interface Logger {
	public static enum LogLevel {
		VERBOSE,
		DEBUG,
		INFO,
		WARNING,
		ERROR,
		NONE;

	}


	public void d(String r1_String);

	public void d(String r1_String, Throwable r2_Throwable);

	public void e(String r1_String);

	public void e(String r1_String, Throwable r2_Throwable);

	public LogLevel getLogLevel();

	public void i(String r1_String);

	public void i(String r1_String, Throwable r2_Throwable);

	public void setLogLevel(LogLevel r1_LogLevel);

	public void v(String r1_String);

	public void v(String r1_String, Throwable r2_Throwable);

	public void w(String r1_String);

	public void w(String r1_String, Throwable r2_Throwable);
}
