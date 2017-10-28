package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class HttpNetworkClient implements NetworkClient {
	private HttpClient mClient;

	HttpNetworkClient() {
	}

	private void closeWithClient(HttpClient client) {
		if (client == null || client.getConnectionManager() == null) {
		} else {
			client.getConnectionManager().shutdown();
		}
	}

	private InputStream handleServerResponse(HttpClient client, HttpResponse response) throws IOException {
		int responseCode = response.getStatusLine().getStatusCode();
		if (responseCode == 200) {
			Log.v("Success response");
			return response.getEntity().getContent();
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
		closeWithClient(this.mClient);
	}

	@VisibleForTesting
	HttpClient createNewHttpClient() {
		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(params, NetworkClient.DEFAULT_SOCKET_TIMEOUT_MILLIS);
		HttpConnectionParams.setSoTimeout(params, NetworkClient.DEFAULT_SOCKET_TIMEOUT_MILLIS);
		return new DefaultHttpClient(params);
	}

	@VisibleForTesting
	HttpPost createPostRequest(String url, byte[] content) {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new ByteArrayEntity(content));
		return httpPost;
	}

	public InputStream getInputStream(String url) throws IOException {
		this.mClient = createNewHttpClient();
		HttpClient r1_HttpClient = this.mClient;
		return handleServerResponse(r1_HttpClient, this.mClient.execute(new HttpGet(url)));
	}

	public void sendPostRequest(String url, byte[] content) throws IOException {
		HttpClient client = createNewHttpClient();
		handleServerResponse(client, client.execute(createPostRequest(url, content)));
		closeWithClient(client);
	}
}
