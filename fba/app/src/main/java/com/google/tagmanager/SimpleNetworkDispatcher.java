package com.google.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class SimpleNetworkDispatcher implements Dispatcher {
	private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
	private final Context ctx;
	private DispatchListener dispatchListener;
	private final HttpClient httpClient;
	private final String userAgent;

	public static interface DispatchListener {
		public void onHitDispatched(Hit r1_Hit);

		public void onHitPermanentDispatchFailure(Hit r1_Hit);

		public void onHitTransientDispatchFailure(Hit r1_Hit);
	}


	@VisibleForTesting
	SimpleNetworkDispatcher(HttpClient httpClient, Context ctx, DispatchListener dispatchListener) {
		this.ctx = ctx.getApplicationContext();
		this.userAgent = createUserAgentString("GoogleTagManager", "3.01", VERSION.RELEASE, getUserAgentLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
		this.httpClient = httpClient;
		this.dispatchListener = dispatchListener;
	}

	/* JADX WARNING: inconsistent code */
	/*
	private org.apache.http.HttpEntityEnclosingRequest constructGtmRequest(java.net.URL r6_url) {
		r5_this = this;
		r1_request = 0;
		r2 = new org.apache.http.message.BasicHttpEntityEnclosingRequest;	 //Catch:{ URISyntaxException -> 0x0019 }
		r3 = "GET";
		r4 = r6_url.toURI();	 //Catch:{ URISyntaxException -> 0x0019 }
		r4 = r4.toString();	 //Catch:{ URISyntaxException -> 0x0019 }
		r2.<init>(r3, r4);	 //Catch:{ URISyntaxException -> 0x0019 }
		r3 = "User-Agent";
		r4 = r5.userAgent;	 //Catch:{ URISyntaxException -> 0x0040 }
		r2_request.addHeader(r3, r4);	 //Catch:{ URISyntaxException -> 0x0040 }
		r1_request = r2_request;
	L_0x0018:
		return r1_request;
	L_0x0019:
		r0 = move-exception;
	L_0x001a:
		r3 = new java.lang.StringBuilder;
		r3.<init>();
		r4 = "Exception sending hit: ";
		r3 = r3.append(r4);
		r4 = r0_e.getClass();
		r4 = r4.getSimpleName();
		r3 = r3.append(r4);
		r3 = r3.toString();
		com.google.tagmanager.Log.w(r3);
		r3 = r0_e.getMessage();
		com.google.tagmanager.Log.w(r3);
		goto L_0x0018;
	L_0x0040:
		r0_e = move-exception;
		r1_request = r2_request;
		goto L_0x001a;
	}
	*/
	private HttpEntityEnclosingRequest constructGtmRequest(URL url) {
		HttpEntityEnclosingRequest request;
		request = null;
		try {
			request = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString());
			request.addHeader("User-Agent", this.userAgent);
			return request;
		} catch (URISyntaxException e) {
			e = e;
		}
	}

	static String getUserAgentLanguage(Locale locale) {
		if (locale == null) {
			return null;
		} else {
			if (locale.getLanguage() != null) {
				if (locale.getLanguage().length() != 0) {
					StringBuilder lang = new StringBuilder();
					lang.append(locale.getLanguage().toLowerCase());
					if (locale.getCountry() == null || locale.getCountry().length() == 0) {
						return lang.toString();
					} else {
						lang.append("-").append(locale.getCountry().toLowerCase());
						return lang.toString();
					}
				}
				return null;
			}
			return null;
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

	public void dispatchHits(List<Hit> hits) {
		Hit hit;
		int maxHits = Math.min(hits.size(), 40);
		boolean firstSend = true;
		int i = 0;
		while (i < maxHits) {
			hit = (Hit) hits.get(i);
			URL url = getUrl(hit);
			if (url == null) {
				Log.w("No destination: discarding hit.");
				this.dispatchListener.onHitPermanentDispatchFailure(hit);
			} else {
				HttpEntityEnclosingRequest request = constructGtmRequest(url);
				if (request == null) {
					this.dispatchListener.onHitPermanentDispatchFailure(hit);
				} else {
					HttpHost targetHost = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
					request.addHeader("Host", targetHost.toHostString());
					logDebugInformation(request);
					if (firstSend) {
						NetworkReceiver.sendRadioPoweredBroadcast(this.ctx);
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
						this.dispatchListener.onHitTransientDispatchFailure(hit);
					} else {
						this.dispatchListener.onHitDispatched(hit);
					}
				}
			}
			i++;
		}
	}

	@VisibleForTesting
	URL getUrl(Hit hit) {
		try {
			return new URL(hit.getHitUrl());
		} catch (MalformedURLException e) {
			Log.e("Error trying to parse the GTM url.");
			return null;
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
}
