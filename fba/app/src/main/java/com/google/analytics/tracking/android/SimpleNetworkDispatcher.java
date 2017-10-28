package com.google.analytics.tracking.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class SimpleNetworkDispatcher implements Dispatcher {
	private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
	private final Context ctx;
	private GoogleAnalytics gaInstance;
	private final HttpClient httpClient;
	private URL mOverrideHostUrl;
	private final String userAgent;

	SimpleNetworkDispatcher(HttpClient httpClient, Context ctx) {
		this(httpClient, GoogleAnalytics.getInstance(ctx), ctx);
	}

	@VisibleForTesting
	SimpleNetworkDispatcher(HttpClient httpClient, GoogleAnalytics gaInstance, Context ctx) {
		this.ctx = ctx.getApplicationContext();
		this.userAgent = createUserAgentString("GoogleAnalytics", "3.0", VERSION.RELEASE, Utils.getLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
		this.httpClient = httpClient;
		this.gaInstance = gaInstance;
	}

	private HttpEntityEnclosingRequest buildRequest(String params, String path) {
		if (TextUtils.isEmpty(params)) {
			Log.w("Empty hit, discarding.");
			return null;
		} else {
			HttpEntityEnclosingRequest request;
			String full = path + "?" + params;
			if (full.length() < 2036) {
				request = new BasicHttpEntityEnclosingRequest("GET", full);
			} else {
				request = new BasicHttpEntityEnclosingRequest("POST", path);
				try {
					request.setEntity(new StringEntity(params));
				} catch (UnsupportedEncodingException e) {
					Log.w("Encoding error, discarding hit");
					return null;
				}
			}
			request.addHeader("User-Agent", this.userAgent);
			return request;
		}
	}

	private void logDebugInformation(HttpEntityEnclosingRequest request) {
		StringBuffer httpHeaders = new StringBuffer();
		Header[] arr$ = request.getAllHeaders();
		int len$ = arr$.length;
		int i$ = 0;
		while (i$ < len$) {
			httpHeaders.append(arr$[i$].toString()).append("\n");
			i$++;
		}
		httpHeaders.append(request.getRequestLine().toString()).append("\n");
		if (request.getEntity() != null) {
			InputStream is;
			try {
				is = request.getEntity().getContent();
				if (is != null) {
					int avail = is.available();
					if (avail > 0) {
						byte[] b = new byte[avail];
						is.read(b);
						httpHeaders.append("POST:\n");
						httpHeaders.append(new String(b)).append("\n");
					}
				}
			} catch (IOException e) {
				Log.v("Error Writing hit to log...");
			}
		}
		Log.v(httpHeaders.toString());
	}

	public void close() {
		this.httpClient.getConnectionManager().shutdown();
	}

	String createUserAgentString(String product, String version, String release, String language, String model, String id) {
		String r0_String = USER_AGENT_TEMPLATE;
		Object[] r1_Object_A = new Object[6];
		r1_Object_A[0] = product;
		r1_Object_A[1] = version;
		r1_Object_A[2] = release;
		r1_Object_A[3] = language;
		r1_Object_A[4] = model;
		r1_Object_A[5] = id;
		return String.format(r0_String, r1_Object_A);
	}

	public int dispatchHits(List<Hit> hits) {
		int hitsDispatched = 0;
		int maxHits = Math.min(hits.size(), 40);
		boolean firstSend = true;
		int i = 0;
		while (i < maxHits) {
			Hit hit = (Hit) hits.get(i);
			URL url = getUrl(hit);
			if (url == null) {
				if (Log.isVerbose()) {
					Log.w("No destination: discarding hit: " + hit.getHitParams());
				} else {
					Log.w("No destination: discarding hit.");
				}
				hitsDispatched++;
			} else {
				String params;
				HttpHost targetHost = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
				String path = url.getPath();
				params = (TextUtils.isEmpty(hit.getHitParams())) ? "" : HitBuilder.postProcessHit(hit, System.currentTimeMillis());
				HttpEntityEnclosingRequest request = buildRequest(params, path);
				if (request == null) {
					hitsDispatched++;
				} else {
					request.addHeader("Host", targetHost.toHostString());
					if (Log.isVerbose()) {
						logDebugInformation(request);
					}
					if (params.length() > 8192) {
						Log.w("Hit too long (> 8192 bytes)--not sent");
					} else if (this.gaInstance.isDryRunEnabled()) {
						Log.i("Dry run enabled. Hit not actually sent.");
					} else {
						if (firstSend) {
							GANetworkReceiver.sendRadioPoweredBroadcast(this.ctx);
							firstSend = false;
						}
						HttpResponse response = this.httpClient.execute(targetHost, request);
						int statusCode = response.getStatusLine().getStatusCode();
						HttpEntity entity = response.getEntity();
						if (entity != null) {
							entity.consumeContent();
						}
						if (statusCode != 200) {
							Log.w("Bad response: " + response.getStatusLine().getStatusCode());
						}
					}
					hitsDispatched++;
				}
			}
			i++;
		}
		return hitsDispatched;
	}

	@VisibleForTesting
	URL getUrl(Hit hit) {
		if (this.mOverrideHostUrl != null) {
			return this.mOverrideHostUrl;
		} else {
			try {
				return new URL(("http:".equals(hit.getHitUrlScheme())) ? "http://www.google-analytics.com/collect" : "https://ssl.google-analytics.com/collect");
			} catch (MalformedURLException e) {
				Log.e("Error trying to parse the hardcoded host url. This really shouldn't happen.");
				return null;
			}
		}
	}

	public boolean okToDispatch() {
		NetworkInfo network = ((ConnectivityManager) this.ctx.getSystemService("connectivity")).getActiveNetworkInfo();
		if (network == null || !network.isConnected()) {
			Log.v("...no network connectivity");
			return false;
		} else {
			return true;
		}
	}

	@VisibleForTesting
	public void overrideHostUrl(String hostUrl) {
		try {
			this.mOverrideHostUrl = new URL(hostUrl);
		} catch (MalformedURLException e) {
			this.mOverrideHostUrl = null;
		}
	}
}
