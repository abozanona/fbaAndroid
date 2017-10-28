package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class HttpUrlConnectionNetworkClient implements NetworkClient {
	private HttpURLConnection mConnection;

	HttpUrlConnectionNetworkClient() {
	}

	private void closeURLConnection(HttpURLConnection connection) {
		if (connection != null) {
			connection.disconnect();
		}
	}

	private InputStream handleServerResponse(HttpURLConnection connection) throws IOException {
		int responseCode = connection.getResponseCode();
		if (responseCode == 200) {
			return connection.getInputStream();
		} else {
			String errorMessage = "Bad response: " + responseCode;
			if (responseCode == 404) {
				throw new FileNotFoundException(errorMessage);
			} else {
				throw new IOException(errorMessage);
			}
		}
	}

	public void close() {
		closeURLConnection(this.mConnection);
	}

	public InputStream getInputStream(String urlStr) throws IOException {
		this.mConnection = getUrlConnection(urlStr);
		return handleServerResponse(this.mConnection);
	}

	@VisibleForTesting
	HttpURLConnection getUrlConnection(String urlStr) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(urlStr).openConnection();
		connection.setReadTimeout(NetworkClient.DEFAULT_SOCKET_TIMEOUT_MILLIS);
		connection.setConnectTimeout(NetworkClient.DEFAULT_SOCKET_TIMEOUT_MILLIS);
		return connection;
	}

	public void sendPostRequest(String urlStr, byte[] content) throws IOException {
		HttpURLConnection connection = getUrlConnection(urlStr);
		try {
			connection.setRequestProperty("Content-Length", Integer.toString(content.length));
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.connect();
			OutputStream sendToServer = connection.getOutputStream();
			sendToServer.write(content);
			sendToServer.flush();
			sendToServer.close();
			handleServerResponse(connection);
			closeURLConnection(connection);
		} catch (Throwable th) {
		}
	}
}
