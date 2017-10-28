package com.google.tagmanager;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Container.ResourceStorage;
import com.google.tagmanager.LoadCallback.Failure;
import com.google.tagmanager.PreviewManager.PreviewMode;
import com.google.tagmanager.ResourceUtil.ExpandedResource;
import com.google.tagmanager.proto.Resource.ResourceWithMetadata;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ResourceStorageImpl implements ResourceStorage {
	private static final String SAVED_RESOURCE_FILENAME_PREFIX = "resource_";
	private static final String SAVED_RESOURCE_SUB_DIR = "google_tagmanager";
	private LoadCallback<ResourceWithMetadata> mCallback;
	private final String mContainerId;
	private final Context mContext;
	private final ExecutorService mExecutor;

	class AnonymousClass_2 implements Runnable {
		final /* synthetic */ ResourceWithMetadata val$resource;

		AnonymousClass_2(ResourceWithMetadata r2_ResourceWithMetadata) {
			this.val$resource = r2_ResourceWithMetadata;
		}

		public void run() {
			saveResourceToDisk(this.val$resource);
		}
	}


	ResourceStorageImpl(Context context, String containerId) {
		this.mContext = context;
		this.mContainerId = containerId;
		this.mExecutor = Executors.newSingleThreadExecutor();
	}

	private String stringFromInputStream(InputStream is) throws IOException {
		Writer writer = new StringWriter();
		char[] buffer = new char[1024];
		Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		while (true) {
			int n = reader.read(buffer);
			if (n != -1) {
				writer.write(buffer, 0, n);
			} else {
				return writer.toString();
			}
		}
	}

	public synchronized void close() {
		synchronized(this) {
			this.mExecutor.shutdown();
		}
	}

	@VisibleForTesting
	File getResourceFile() {
		String fileName = SAVED_RESOURCE_FILENAME_PREFIX + this.mContainerId;
		return new File(this.mContext.getDir(SAVED_RESOURCE_SUB_DIR, 0), fileName);
	}

	public ExpandedResource loadExpandedResourceFromJsonAsset(String assetFile) {
		ExpandedResource r3_ExpandedResource = null;
		Log.v("loading default container from " + assetFile);
		AssetManager assets = this.mContext.getAssets();
		if (assets == null) {
			Log.w("Looking for default JSON container in package, but no assets were found.");
		} else {
			InputStream is;
			try {
				is = assets.open(assetFile);
				r3_ExpandedResource = JsonUtils.expandedResourceFromJsonString(stringFromInputStream(is));
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
					}
				}
			} catch (Throwable th) {
				if (false) {
					null.close();
				}
			}
		}
		return r3_ExpandedResource;
	}

	public Resource loadResourceFromContainerAsset(String assetFile) {
		InputStream is;
		Resource result;
		Log.v("Loading default container from " + assetFile);
		AssetManager assets = this.mContext.getAssets();
		if (assets == null) {
			Log.e("No assets found in package");
			return null;
		} else {
			try {
				is = assets.open(assetFile);
				result = Resource.parseFrom(is, ProtoExtensionRegistry.getRegistry());
				Log.v("Parsed default container: " + result);
				try {
					is.close();
					return result;
				} catch (IOException e) {
					return result;
				}
			} catch (IOException e_2) {
				Log.w("No asset file: " + assetFile + " found.");
				return null;
			}
		}
	}

	@VisibleForTesting
	void loadResourceFromDisk() {
		InputStream stream;
		if (this.mCallback == null) {
			throw new IllegalStateException("callback must be set before execute");
		} else {
			this.mCallback.startLoad();
			Log.v("Start loading resource from disk ...");
			if ((PreviewManager.getInstance().getPreviewMode() == PreviewMode.CONTAINER || PreviewManager.getInstance().getPreviewMode() == PreviewMode.CONTAINER_DEBUG) && this.mContainerId.equals(PreviewManager.getInstance().getContainerId())) {
				this.mCallback.onFailure(Failure.NOT_AVAILABLE);
				return;
			}
			try {
				stream = new FileInputStream(getResourceFile());
				this.mCallback.onSuccess(ResourceWithMetadata.parseFrom(stream, ProtoExtensionRegistry.getRegistry()));
				stream.close();
				Log.v("Load resource from disk finished.");
			} catch (FileNotFoundException e) {
				Log.d("resource not on disk");
				this.mCallback.onFailure(Failure.NOT_AVAILABLE);
			}
		}
	}

	public void loadResourceFromDiskInBackground() {
		this.mExecutor.execute(new Runnable() {
			public void run() {
				loadResourceFromDisk();
			}
		});
	}

	@VisibleForTesting
	boolean saveResourceToDisk(ResourceWithMetadata resource) {
		File file;
		OutputStream stream;
		boolean r4z = false;
		file = getResourceFile();
		try {
			stream = new FileOutputStream(file);
			resource.writeTo(stream);
			r4z = true;
			stream.close();
			stream = stream;
		} catch (FileNotFoundException e) {
			Log.e("Error opening resource file for writing");
		}
		return r4z;
	}

	public void saveResourceToDiskInBackground(ResourceWithMetadata resource) {
		this.mExecutor.execute(new AnonymousClass_2(resource));
	}

	public void setLoadCallback(LoadCallback<ResourceWithMetadata> callback) {
		this.mCallback = callback;
	}
}
