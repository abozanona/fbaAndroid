package com.google.tagmanager;

import java.io.IOException;
import java.io.InputStream;

interface NetworkClient {
	public static final int DEFAULT_CONNECTION_TIMEOUT_MILLIS = 20000;
	public static final int DEFAULT_SOCKET_TIMEOUT_MILLIS = 20000;

	public void close();

	public InputStream getInputStream(String r1_String) throws IOException;

	public void sendPostRequest(String r1_String, byte[] r2_byte_A) throws IOException;
}
