package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Container.Callback;
import com.google.tagmanager.DataLayer.Listener;
import com.google.tagmanager.PreviewManager.PreviewMode;
import com.google.tagmanager.protobuf.WireFormat;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
	private static TagManager sInstance;
	private final ContainerProvider mContainerProvider;
	private final ConcurrentMap<String, Container> mContainers;
	private final Context mContext;
	private volatile String mCtfeServerAddr;
	private final DataLayer mDataLayer;
	private volatile RefreshMode mRefreshMode;

	@VisibleForTesting
	static interface ContainerProvider {
		public Container newContainer(Context r1_Context, String r2_String, TagManager r3_TagManager);
	}

	static /* synthetic */ class AnonymousClass_3 {
		static final /* synthetic */ int[] $SwitchMap$com$google$tagmanager$PreviewManager$PreviewMode;

		static {
			$SwitchMap$com$google$tagmanager$PreviewManager$PreviewMode = new int[PreviewMode.values().length];
			try {
				$SwitchMap$com$google$tagmanager$PreviewManager$PreviewMode[PreviewMode.NONE.ordinal()] = 1;
			} catch (NoSuchFieldError e) {
			}
			try {
				$SwitchMap$com$google$tagmanager$PreviewManager$PreviewMode[PreviewMode.CONTAINER.ordinal()] = 2;
			} catch (NoSuchFieldError e_2) {
			}
			$SwitchMap$com$google$tagmanager$PreviewManager$PreviewMode[PreviewMode.CONTAINER_DEBUG.ordinal()] = 3;
		}
	}

	static class ContainerOpenException extends RuntimeException {
		private final String mContainerId;

		private ContainerOpenException(String containerId) {
			super("Container already open: " + containerId);
			this.mContainerId = containerId;
		}

		public String getContainerId() {
			return this.mContainerId;
		}
	}

	@Deprecated
	public static interface Logger extends Logger {
	}

	public static enum RefreshMode {
		STANDARD,
		DEFAULT_CONTAINER;

	}


	@VisibleForTesting
	TagManager(Context context, ContainerProvider containerProvider, DataLayer dataLayer) {
		if (context == null) {
			throw new NullPointerException("context cannot be null");
		} else {
			this.mContext = context.getApplicationContext();
			this.mContainerProvider = containerProvider;
			this.mRefreshMode = RefreshMode.STANDARD;
			this.mContainers = new ConcurrentHashMap();
			this.mDataLayer = dataLayer;
			this.mDataLayer.registerListener(new Listener() {
			public void changed(Map<Object, Object> update) {
				Object eventValue = update.get(HitTypes.EVENT);
				if (eventValue != null) {
					refreshTagsInAllContainers(eventValue.toString());
				}
			}
		});
			this.mDataLayer.registerListener(new AdwordsClickReferrerListener(this.mContext));
		}
	}

	public static TagManager getInstance(Context context) {
		TagManager r1_TagManager;
		Class r2_Class = TagManager.class;
		synchronized(r2_Class) {
			if (sInstance == null) {
				sInstance = new TagManager(context, new ContainerProvider() {
			public Container newContainer(Context context, String containerId, TagManager tagManager) {
				return new Container(context, containerId, tagManager);
			}
		}, new DataLayer());
			}
			r1_TagManager = sInstance;
		}
		return r1_TagManager;
	}

	private void refreshTagsInAllContainers(String eventName) {
		Iterator i$ = this.mContainers.values().iterator();
		while (i$.hasNext()) {
			((Container) i$.next()).evaluateTags(eventName);
		}
	}

	public Container getContainer(String containerId) {
		return (Container) this.mContainers.get(containerId);
	}

	public Context getContext() {
		return this.mContext;
	}

	public DataLayer getDataLayer() {
		return this.mDataLayer;
	}

	public Logger getLogger() {
		return Log.getLogger();
	}

	public RefreshMode getRefreshMode() {
		return this.mRefreshMode;
	}

	public Container openContainer(String containerId, Callback callback) {
		Container container = this.mContainerProvider.newContainer(this.mContext, containerId, this);
		if (this.mContainers.putIfAbsent(containerId, container) != null) {
			throw new IllegalArgumentException("Container id:" + containerId + " has already been opened.");
		} else {
			if (this.mCtfeServerAddr != null) {
				container.setCtfeServerAddress(this.mCtfeServerAddr);
			}
			container.load(callback);
			return container;
		}
	}

	boolean removeContainer(String containerId) {
		return this.mContainers.remove(containerId) != null;
	}

	@VisibleForTesting
	void setCtfeServerAddress(String addr) {
		this.mCtfeServerAddr = addr;
	}

	public void setLogger(Logger logger) {
		Log.setLogger(logger);
	}

	synchronized boolean setPreviewData(Uri data) {
		boolean r6z;
		synchronized(this) {
			PreviewManager previewManager = PreviewManager.getInstance();
			if (previewManager.setPreviewData(data)) {
				String previewContainerId = previewManager.getContainerId();
				switch(AnonymousClass_3.$SwitchMap$com$google$tagmanager$PreviewManager$PreviewMode[previewManager.getPreviewMode().ordinal()]) {
				case WireFormat.WIRETYPE_FIXED64:
					Container exitPreviewContainer = (Container) this.mContainers.get(previewContainerId);
					if (exitPreviewContainer != null) {
						exitPreviewContainer.setCtfeUrlPathAndQuery(null);
						exitPreviewContainer.refresh();
					}
					break;
				case WireFormat.WIRETYPE_LENGTH_DELIMITED:
				case WireFormat.WIRETYPE_START_GROUP:
					Iterator i$ = this.mContainers.entrySet().iterator();
					while (i$.hasNext()) {
						Entry<String, Container> entry = (Entry) i$.next();
						Container container = (Container) entry.getValue();
						if (((String) entry.getKey()).equals(previewContainerId)) {
							container.setCtfeUrlPathAndQuery(previewManager.getCTFEUrlPath());
							container.refresh();
						} else if (container.getCtfeUrlPathAndQuery() != null) {
							container.setCtfeUrlPathAndQuery(null);
							container.refresh();
						}
					}
					break;
				}
				r6z = true;
			} else {
				r6z = false;
			}
		}
		return r6z;
	}

	public void setRefreshMode(RefreshMode mode) {
		this.mRefreshMode = mode;
	}
}
