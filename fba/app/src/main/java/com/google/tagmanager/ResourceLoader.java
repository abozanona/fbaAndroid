package com.google.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.analytics.containertag.proto.Serving.OptionalResource;
import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.LoadCallback.Failure;
import com.google.tagmanager.PreviewManager.PreviewMode;
import java.io.FileNotFoundException;
import java.io.IOException;

class ResourceLoader implements Runnable {
	private static final String CTFE_URL_PREFIX = "/r?id=";
	private static final String CTFE_URL_SUFFIX = "&v=a50788154";
	private static final String PREVIOUS_CONTAINER_VERSION_QUERY_NAME = "pv";
	@VisibleForTesting
	static final String SDK_VERSION = "a50788154";
	private LoadCallback<Resource> mCallback;
	private final NetworkClientFactory mClientFactory;
	private final String mContainerId;
	private final Context mContext;
	private volatile CtfeHost mCtfeHost;
	private volatile String mCtfeUrlPathAndQuery;
	private final String mDefaultCtfeUrlPathAndQuery;
	private volatile String mPreviousVersion;

	public ResourceLoader(Context context, String containerId, CtfeHost ctfeHost) {
		this(context, containerId, new NetworkClientFactory(), ctfeHost);
	}

	@VisibleForTesting
	ResourceLoader(Context context, String containerId, NetworkClientFactory factory, CtfeHost ctfeHost) {
		this.mContext = context;
		this.mClientFactory = factory;
		this.mContainerId = containerId;
		this.mCtfeHost = ctfeHost;
		this.mDefaultCtfeUrlPathAndQuery = CTFE_URL_PREFIX + containerId;
		this.mCtfeUrlPathAndQuery = this.mDefaultCtfeUrlPathAndQuery;
		this.mPreviousVersion = null;
	}

	private void loadResource() {
		String url;
		NetworkClient networkClient;
		Throwable e;
		if (!okToLoad()) {
			this.mCallback.onFailure(Failure.NOT_AVAILABLE);
			return;
		} else {
			OptionalResource resource;
			Log.v("Start loading resource from network ...");
			url = getCtfeUrl();
			networkClient = this.mClientFactory.createNetworkClient();
			try {
				resource = OptionalResource.parseFrom(networkClient.getInputStream(url), ProtoExtensionRegistry.getRegistry());
				Log.v("Successfully loaded resource: " + resource);
				if (!resource.hasResource()) {
					Log.v("No change for container: " + this.mContainerId);
				}
				this.mCallback.onSuccess((resource.hasResource()) ? resource.getResource() : null);
				networkClient.close();
				Log.v("Load resource from network finished.");
			} catch (FileNotFoundException e_2) {
				Log.w("No data is retrieved from the given url: " + url + ". Make sure container_id: " + this.mContainerId + " is correct.");
				this.mCallback.onFailure(Failure.SERVER_ERROR);
				networkClient.close();
			} catch (IOException e_3) {
				e = e_3;
				Log.w("Error when loading resources from url: " + url + " " + e.getMessage(), e);
				this.mCallback.onFailure(Failure.IO_ERROR);
				networkClient.close();
			}
		}
	}

	private boolean okToLoad() {
		NetworkInfo network = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
		if (network == null || !network.isConnected()) {
			Log.v("...no network connectivity");
			return false;
		} else {
			return true;
		}
	}

	@VisibleForTesting
	String getCtfeUrl() {
		String url = this.mCtfeHost.getCtfeServerAddress() + this.mCtfeUrlPathAndQuery + CTFE_URL_SUFFIX;
		if (this.mPreviousVersion == null || this.mPreviousVersion.trim().equals("")) {
			if (!PreviewManager.getInstance().getPreviewMode().equals(PreviewMode.CONTAINER_DEBUG)) {
			}
		} else {
			url = url + "&pv=" + this.mPreviousVersion;
			return (!PreviewManager.getInstance().getPreviewMode().equals(PreviewMode.CONTAINER_DEBUG)) ? url : url + "&gtm_debug=x";
		}
	}

	public void run() {
		if (this.mCallback == null) {
			throw new IllegalStateException("callback must be set before execute");
		} else {
			this.mCallback.startLoad();
			loadResource();
		}
	}

	@VisibleForTesting
	void setCtfeURLPathAndQuery(String urlPathAndQuery) {
		if (urlPathAndQuery == null) {
			this.mCtfeUrlPathAndQuery = this.mDefaultCtfeUrlPathAndQuery;
			return;
		} else {
			Log.d("Setting CTFE URL path: " + urlPathAndQuery);
			this.mCtfeUrlPathAndQuery = urlPathAndQuery;
		}
	}

	void setLoadCallback(LoadCallback<Resource> callback) {
		this.mCallback = callback;
	}

	@VisibleForTesting
	void setPreviousVersion(String version) {
		Log.d("Setting previous container version: " + version);
		this.mPreviousVersion = version;
	}
}
