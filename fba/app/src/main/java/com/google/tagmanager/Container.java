package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.CustomFunctionCall.CustomEvaluator;
import com.google.tagmanager.LoadCallback.Failure;
import com.google.tagmanager.PreviewManager.PreviewMode;
import com.google.tagmanager.ResourceUtil.ExpandedResource;
import com.google.tagmanager.ResourceUtil.InvalidResourceException;
import com.google.tagmanager.TagManager.RefreshMode;
import com.google.tagmanager.proto.Resource.ResourceWithMetadata;
import com.google.tagmanager.protobuf.WireFormat;
import java.util.HashMap;
import java.util.Map;

public class Container {
	static final boolean ENABLE_CONTAINER_DEBUG_MODE = false;
	@VisibleForTesting
	static final int MAX_NUMBER_OF_TOKENS = 30;
	static final int MINIMUM_REFRESH_PERIOD_BURST_MODE_MS = 5000;
	static final long MINIMUM_REFRESH_PERIOD_MS = 900000;
	static final long REFRESH_PERIOD_ON_FAILURE_MS = 3600000;
	static final long REFRESH_PERIOD_ON_SUCCESS_MS = 43200000;
	private Clock mClock;
	private final String mContainerId;
	private final Context mContext;
	private CtfeHost mCtfeHost;
	private volatile String mCtfeServerAddress;
	private volatile String mCtfeUrlPathAndQuery;
	@VisibleForTesting
	LoadCallback<ResourceWithMetadata> mDiskLoadCallback;
	private Map<String, FunctionCallMacroHandler> mFunctionCallMacroHandlers;
	private Map<String, FunctionCallTagHandler> mFunctionCallTagHandlers;
	private volatile Resource mLastLoadedResource;
	private volatile long mLastRefreshMethodCalledTime;
	private volatile long mLastRefreshTime;
	@VisibleForTesting
	LoadCallback<Resource> mNetworkLoadCallback;
	private ResourceLoaderScheduler mNetworkLoadScheduler;
	private volatile int mNumTokens;
	private volatile int mResourceFormatVersion;
	private ResourceStorage mResourceStorage;
	private volatile String mResourceVersion;
	private Runtime mRuntime;
	private final TagManager mTagManager;
	private Callback mUserCallback;

	class AnonymousClass_2 implements LoadCallback<ResourceWithMetadata> {
		final /* synthetic */ Clock val$clock;

		AnonymousClass_2(Clock r2_Clock) {
			this.val$clock = r2_Clock;
		}

		private Container.RefreshFailure failureToRefreshFailure(Failure failure) {
			switch(Container.AnonymousClass_4.$SwitchMap$com$google$tagmanager$LoadCallback$Failure[failure.ordinal()]) {
			case WireFormat.WIRETYPE_FIXED64:
				return Container.RefreshFailure.NO_SAVED_CONTAINER;
			case WireFormat.WIRETYPE_LENGTH_DELIMITED:
				return Container.RefreshFailure.IO_ERROR;
			case WireFormat.WIRETYPE_START_GROUP:
				return Container.RefreshFailure.SERVER_ERROR;
			}
			return Container.RefreshFailure.UNKNOWN_ERROR;
		}

		public void onFailure(Failure failure) {
			callRefreshFailure(Container.RefreshType.SAVED, failureToRefreshFailure(failure));
			if (isDefault()) {
				loadAfterDelay(0);
			}
		}

		public void onSuccess(ResourceWithMetadata resource) {
			if (isDefault()) {
				initEvaluators(resource.getResource(), ENABLE_CONTAINER_DEBUG_MODE);
				Log.v("setting refresh time to saved time: " + resource.getTimeStamp());
				mLastRefreshTime = resource.getTimeStamp();
				loadAfterDelay(Math.max(0, Math.min(REFRESH_PERIOD_ON_SUCCESS_MS, (mLastRefreshTime + 43200000) - this.val$clock.currentTimeMillis())));
			}
			callRefreshSuccess(Container.RefreshType.SAVED);
		}

		public void startLoad() {
			callRefreshBegin(Container.RefreshType.SAVED);
		}
	}

	class AnonymousClass_3 implements LoadCallback<Resource> {
		final /* synthetic */ Clock val$clock;

		AnonymousClass_3(Clock r2_Clock) {
			this.val$clock = r2_Clock;
		}

		private Container.RefreshFailure failureToRefreshFailure(Failure failure) {
			switch(Container.AnonymousClass_4.$SwitchMap$com$google$tagmanager$LoadCallback$Failure[failure.ordinal()]) {
			case WireFormat.WIRETYPE_FIXED64:
				return Container.RefreshFailure.NO_NETWORK;
			case WireFormat.WIRETYPE_LENGTH_DELIMITED:
				return Container.RefreshFailure.NETWORK_ERROR;
			case WireFormat.WIRETYPE_START_GROUP:
				return Container.RefreshFailure.SERVER_ERROR;
			}
			return Container.RefreshFailure.UNKNOWN_ERROR;
		}

		public void onFailure(Failure failure) {
			loadAfterDelay(REFRESH_PERIOD_ON_FAILURE_MS);
			callRefreshFailure(Container.RefreshType.NETWORK, failureToRefreshFailure(failure));
		}

		public void onSuccess(Resource resource) {
			Container r1_Container = ;
			synchronized(r1_Container) {
				if (resource != null) {
					initEvaluators(resource, ENABLE_CONTAINER_DEBUG_MODE);
				} else if (mLastLoadedResource == null) {
					onFailure(Failure.SERVER_ERROR);
					return;
				} else {
					resource = mLastLoadedResource;
				}
				mLastRefreshTime = this.val$clock.currentTimeMillis();
				Log.v("setting refresh time to current time: " + mLastRefreshTime);
				if (!isContainerPreview()) {
					saveResourceToDisk(resource);
				}
				loadAfterDelay(REFRESH_PERIOD_ON_SUCCESS_MS);
				callRefreshSuccess(Container.RefreshType.NETWORK);
			}
		}

		public void startLoad() {
			callRefreshBegin(Container.RefreshType.NETWORK);
		}
	}

	static /* synthetic */ class AnonymousClass_4 {
		static final /* synthetic */ int[] $SwitchMap$com$google$tagmanager$LoadCallback$Failure;

		static {
			$SwitchMap$com$google$tagmanager$LoadCallback$Failure = new int[Failure.values().length];
			try {
				$SwitchMap$com$google$tagmanager$LoadCallback$Failure[Failure.NOT_AVAILABLE.ordinal()] = 1;
			} catch (NoSuchFieldError e) {
			}
			try {
				$SwitchMap$com$google$tagmanager$LoadCallback$Failure[Failure.IO_ERROR.ordinal()] = 2;
			} catch (NoSuchFieldError e_2) {
			}
			$SwitchMap$com$google$tagmanager$LoadCallback$Failure[Failure.SERVER_ERROR.ordinal()] = 3;
		}
	}

	public static interface Callback {
		public void containerRefreshBegin(Container r1_Container, Container.RefreshType r2_Container_RefreshType);

		public void containerRefreshFailure(Container r1_Container, Container.RefreshType r2_Container_RefreshType, Container.RefreshFailure r3_Container_RefreshFailure);

		public void containerRefreshSuccess(Container r1_Container, Container.RefreshType r2_Container_RefreshType);
	}

	public static interface FunctionCallMacroHandler {
		public Object getValue(String r1_String, Map<String, Object> r2_Map_StringObject);
	}

	private class FunctionCallMacroHandlerAdapter implements CustomEvaluator {
		private FunctionCallMacroHandlerAdapter() {
		}

		public Object evaluate(String key, Map<String, Object> parameters) {
			Container.FunctionCallMacroHandler handler = getFunctionCallMacroHandler(key);
			return (handler == null) ? null : handler.getValue(key, parameters);
		}
	}

	public static interface FunctionCallTagHandler {
		public void execute(String r1_String, Map<String, Object> r2_Map_StringObject);
	}

	private class FunctionCallTagHandlerAdapter implements CustomEvaluator {
		private FunctionCallTagHandlerAdapter() {
		}

		public Object evaluate(String key, Map<String, Object> parameters) {
			getFunctionCallTagHandler(key).execute(key, parameters);
			return Types.getDefaultString();
		}
	}

	public static enum RefreshFailure {
		NO_SAVED_CONTAINER,
		IO_ERROR,
		NO_NETWORK,
		NETWORK_ERROR,
		SERVER_ERROR,
		UNKNOWN_ERROR;

	}

	public static enum RefreshType {
		SAVED,
		NETWORK;

	}

	static interface ResourceLoaderScheduler {
		public void close();

		public void loadAfterDelay(long r1j, String r3_String);

		public void setCtfeURLPathAndQuery(String r1_String);

		public void setLoadCallback(LoadCallback<Resource> r1_LoadCallback_Resource);
	}

	static interface ResourceStorage {
		public void close();

		public ExpandedResource loadExpandedResourceFromJsonAsset(String r1_String);

		public Resource loadResourceFromContainerAsset(String r1_String);

		public void loadResourceFromDiskInBackground();

		public void saveResourceToDiskInBackground(ResourceWithMetadata r1_ResourceWithMetadata);

		public void setLoadCallback(LoadCallback<ResourceWithMetadata> r1_LoadCallback_ResourceWithMetadata);
	}


	Container(Context context, String containerId, TagManager tagManager) {
		this(context, containerId, tagManager, new ResourceStorageImpl(context, containerId));
	}

	@VisibleForTesting
	Container(Context context, String containerId, TagManager tagManager, ResourceStorage resourceStorage) {
		this.mResourceVersion = "";
		this.mResourceFormatVersion = 0;
		this.mCtfeHost = new CtfeHost();
		this.mContext = context;
		this.mContainerId = containerId;
		this.mTagManager = tagManager;
		this.mResourceStorage = resourceStorage;
		this.mNumTokens = 30;
		this.mFunctionCallMacroHandlers = new HashMap();
		this.mFunctionCallTagHandlers = new HashMap();
		createInitialContainer();
	}

	private synchronized void callRefreshBegin(RefreshType refreshType) {
		synchronized(this) {
			if (this.mUserCallback != null) {
				this.mUserCallback.containerRefreshBegin(this, refreshType);
			}
		}
	}

	private synchronized void callRefreshFailure(RefreshType refreshType, RefreshFailure refreshFailure) {
		synchronized(this) {
			if (this.mUserCallback != null) {
				this.mUserCallback.containerRefreshFailure(this, refreshType, refreshFailure);
			}
		}
	}

	private synchronized void callRefreshSuccess(RefreshType refreshType) {
		synchronized(this) {
			Log.v("calling containerRefreshSuccess(" + refreshType + "): mUserCallback = " + this.mUserCallback);
			if (this.mUserCallback != null) {
				this.mUserCallback.containerRefreshSuccess(this, refreshType);
			}
		}
	}

	private void createInitialContainer() {
		String containerFile = "tagmanager/" + this.mContainerId;
		Resource resource = this.mResourceStorage.loadResourceFromContainerAsset(containerFile);
		if (resource != null) {
			initEvaluators(resource, true);
			return;
		} else {
			ExpandedResource expandedResource = this.mResourceStorage.loadExpandedResourceFromJsonAsset(containerFile + ".json");
			if (expandedResource == null) {
				Log.w("No default container found; creating an empty container.");
				expandedResource = ExpandedResource.newBuilder().build();
			}
			initEvaluatorsWithExpandedResource(expandedResource);
		}
	}

	private synchronized Runtime getRuntime() {
		Runtime r0_Runtime;
		synchronized(this) {
			r0_Runtime = this.mRuntime;
		}
		return r0_Runtime;
	}

	private void initEvaluators(Resource resource, boolean isDefaultResource) {
		try {
			ExpandedResource expandedResource = ResourceUtil.getExpandedResource(resource);
			if (!isDefaultResource) {
				this.mLastLoadedResource = resource;
			}
			initEvaluatorsWithExpandedResource(expandedResource);
		} catch (InvalidResourceException e) {
			Log.e("Not loading resource: " + resource + " because it is invalid: " + e.toString());
		}
	}

	private void initEvaluatorsWithExpandedResource(ExpandedResource expandedResource) {
		this.mResourceVersion = expandedResource.getVersion();
		this.mResourceFormatVersion = expandedResource.getResourceFormatVersion();
		EventInfoDistributor eventInfoDistributor = createEventInfoDistributor(this.mResourceVersion);
		setRuntime(new Runtime(this.mContext, expandedResource, this.mTagManager.getDataLayer(), new FunctionCallMacroHandlerAdapter(null), new FunctionCallTagHandlerAdapter(null), eventInfoDistributor));
	}

	private boolean isContainerPreview() {
		PreviewManager previewManager = PreviewManager.getInstance();
		if ((previewManager.getPreviewMode() == PreviewMode.CONTAINER || previewManager.getPreviewMode() == PreviewMode.CONTAINER_DEBUG) && this.mContainerId.equals(previewManager.getContainerId())) {
			return true;
		}
		return ENABLE_CONTAINER_DEBUG_MODE;
	}

	private boolean isDefaultContainerRefreshMode() {
		return (this.mTagManager.getRefreshMode() == RefreshMode.DEFAULT_CONTAINER) ? true : ENABLE_CONTAINER_DEBUG_MODE;
	}

	private synchronized void saveResourceToDisk(Resource resource) {
		synchronized(this) {
			if (this.mResourceStorage != null) {
				this.mResourceStorage.saveResourceToDiskInBackground(ResourceWithMetadata.newBuilder().setTimeStamp(getLastRefreshTime()).setResource(resource).build());
			}
		}
	}

	private synchronized void setRuntime(Runtime runtime) {
		synchronized(this) {
			this.mRuntime = runtime;
		}
	}

	private boolean useAvailableToken(long currentTime) {
		if (this.mLastRefreshMethodCalledTime == 0) {
			this.mNumTokens--;
			return true;
		} else {
			long timeElapsed = currentTime - this.mLastRefreshMethodCalledTime;
			if (timeElapsed < 5000) {
				return false;
			} else {
				if (this.mNumTokens < 30) {
					this.mNumTokens = Math.min(MAX_NUMBER_OF_TOKENS, this.mNumTokens + ((int) Math.floor((double) (timeElapsed / 900000))));
				}
				if (this.mNumTokens > 0) {
					this.mNumTokens--;
					return true;
				} else {
					return false;
				}
			}
		}
	}

	public synchronized void close() {
		synchronized(this) {
			try {
				if (this.mNetworkLoadScheduler != null) {
					this.mNetworkLoadScheduler.close();
				}
				this.mNetworkLoadScheduler = null;
				if (this.mResourceStorage != null) {
					this.mResourceStorage.close();
				}
				this.mResourceStorage = null;
				this.mUserCallback = null;
				this.mTagManager.removeContainer(this.mContainerId);
			} catch (Exception e) {
				Exception e_2 = e;
				Log.e("Calling close() threw an exception: " + e_2.getMessage());
			}
			this.mRuntime = null;
		}
	}

	@VisibleForTesting
	EventInfoDistributor createEventInfoDistributor(String resourceVersion) {
		return (PreviewManager.getInstance().getPreviewMode().equals(PreviewMode.CONTAINER_DEBUG)) ? new NoopEventInfoDistributor() : new NoopEventInfoDistributor();
	}

	@VisibleForTesting
	void evaluateTags(String currentEventName) {
		getRuntime().evaluateTags(currentEventName);
	}

	public boolean getBoolean(String key) {
		Runtime runtime = getRuntime();
		if (runtime == null) {
			Log.e("getBoolean called for closed container.");
			return Types.getDefaultBoolean().booleanValue();
		} else {
			try {
				return Types.valueToBoolean((Value) runtime.evaluateMacroReference(key).getObject()).booleanValue();
			} catch (Exception e) {
				Log.e("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
				return Types.getDefaultBoolean().booleanValue();
			}
		}
	}

	public String getContainerId() {
		return this.mContainerId;
	}

	String getCtfeUrlPathAndQuery() {
		return this.mCtfeUrlPathAndQuery;
	}

	public double getDouble(String key) {
		Runtime runtime = getRuntime();
		if (runtime == null) {
			Log.e("getDouble called for closed container.");
			return Types.getDefaultDouble().doubleValue();
		} else {
			try {
				return Types.valueToDouble((Value) runtime.evaluateMacroReference(key).getObject()).doubleValue();
			} catch (Exception e) {
				Log.e("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
				return Types.getDefaultDouble().doubleValue();
			}
		}
	}

	public synchronized FunctionCallMacroHandler getFunctionCallMacroHandler(String customMacroName) {
		FunctionCallMacroHandler r0_FunctionCallMacroHandler;
		synchronized(this) {
			r0_FunctionCallMacroHandler = (FunctionCallMacroHandler) this.mFunctionCallMacroHandlers.get(customMacroName);
		}
		return r0_FunctionCallMacroHandler;
	}

	public synchronized FunctionCallTagHandler getFunctionCallTagHandler(String customTagName) {
		FunctionCallTagHandler r0_FunctionCallTagHandler;
		synchronized(this) {
			r0_FunctionCallTagHandler = (FunctionCallTagHandler) this.mFunctionCallTagHandlers.get(customTagName);
		}
		return r0_FunctionCallTagHandler;
	}

	public long getLastRefreshTime() {
		return this.mLastRefreshTime;
	}

	public long getLong(String key) {
		Runtime runtime = getRuntime();
		if (runtime == null) {
			Log.e("getLong called for closed container.");
			return Types.getDefaultInt64().longValue();
		} else {
			try {
				return Types.valueToInt64((Value) runtime.evaluateMacroReference(key).getObject()).longValue();
			} catch (Exception e) {
				Log.e("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
				return Types.getDefaultInt64().longValue();
			}
		}
	}

	@VisibleForTesting
	String getResourceVersion() {
		return this.mResourceVersion;
	}

	public String getString(String key) {
		Runtime runtime = getRuntime();
		if (runtime == null) {
			Log.e("getString called for closed container.");
			return Types.getDefaultString();
		} else {
			try {
				return Types.valueToString((Value) runtime.evaluateMacroReference(key).getObject());
			} catch (Exception e) {
				Log.e("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
				return Types.getDefaultString();
			}
		}
	}

	public boolean isDefault() {
		return ((getLastRefreshTime() > 0 ? 1 : (getLastRefreshTime() == 0 ? 0 : -1)) == 0) ? true : ENABLE_CONTAINER_DEBUG_MODE;
	}

	void load(Callback callback) {
		Clock systemClock = new Clock() {
					public long currentTimeMillis() {
						return System.currentTimeMillis();
					}
				};
		load(callback, new ResourceLoaderSchedulerImpl(this.mContext, this.mContainerId, this.mCtfeHost), systemClock);
	}

	@VisibleForTesting
	synchronized void load(Callback callback, ResourceLoaderScheduler scheduler, Clock clock) {
		synchronized(this) {
			if (this.mDiskLoadCallback != null) {
				throw new RuntimeException("Container already loaded: container ID: " + this.mContainerId);
			} else {
				this.mClock = clock;
				this.mUserCallback = callback;
				this.mDiskLoadCallback = new AnonymousClass_2(clock);
				if (isDefaultContainerRefreshMode()) {
					Log.i("Container is in DEFAULT_CONTAINER mode. Use default container.");
				} else {
					this.mResourceStorage.setLoadCallback(this.mDiskLoadCallback);
					this.mNetworkLoadCallback = new AnonymousClass_3(clock);
					scheduler.setLoadCallback(this.mNetworkLoadCallback);
					if (isContainerPreview()) {
						this.mCtfeUrlPathAndQuery = PreviewManager.getInstance().getCTFEUrlPath();
						scheduler.setCtfeURLPathAndQuery(this.mCtfeUrlPathAndQuery);
					}
					if (this.mCtfeServerAddress != null) {
						this.mCtfeHost.setCtfeServerAddress(this.mCtfeServerAddress);
					}
					this.mNetworkLoadScheduler = scheduler;
					this.mResourceStorage.loadResourceFromDiskInBackground();
				}
			}
		}
	}

	@VisibleForTesting
	synchronized void loadAfterDelay(long delay) {
		synchronized(this) {
			if (this.mNetworkLoadScheduler == null || isDefaultContainerRefreshMode()) {
			} else {
				this.mNetworkLoadScheduler.loadAfterDelay(delay, (this.mLastLoadedResource == null) ? null : this.mLastLoadedResource.getVersion());
			}
		}
	}

	public synchronized void refresh() {
		synchronized(this) {
			if (getRuntime() == null) {
				Log.w("refresh called for closed container");
			} else {
				try {
					if (isDefaultContainerRefreshMode()) {
						Log.w("Container is in DEFAULT_CONTAINER mode. Refresh request is ignored.");
					} else {
						long currentTime = this.mClock.currentTimeMillis();
						if (useAvailableToken(currentTime)) {
							Log.v("Container refresh requested");
							loadAfterDelay(0);
							this.mLastRefreshMethodCalledTime = currentTime;
						} else {
							Log.v("Container refresh was called too often. Ignored.");
						}
					}
				} catch (Exception e) {
					Exception e_2 = e;
					Log.e("Calling refresh() throws an exception: " + e_2.getMessage());
				}
			}
		}
	}

	public synchronized void registerFunctionCallMacroHandler(String customMacroName, FunctionCallMacroHandler customMacroHandler) {
		synchronized(this) {
			this.mFunctionCallMacroHandlers.put(customMacroName, customMacroHandler);
		}
	}

	public synchronized void registerFunctionCallTagHandler(String customTagName, FunctionCallTagHandler customTagHandler) {
		synchronized(this) {
			this.mFunctionCallTagHandlers.put(customTagName, customTagHandler);
		}
	}

	@VisibleForTesting
	synchronized void setCtfeServerAddress(String addr) {
		synchronized(this) {
			this.mCtfeServerAddress = addr;
			if (addr != null) {
				this.mCtfeHost.setCtfeServerAddress(addr);
			}
		}
	}

	@VisibleForTesting
	synchronized void setCtfeUrlPathAndQuery(String ctfeUrlPathAndQuery) {
		synchronized(this) {
			this.mCtfeUrlPathAndQuery = ctfeUrlPathAndQuery;
			if (this.mNetworkLoadScheduler != null) {
				this.mNetworkLoadScheduler.setCtfeURLPathAndQuery(ctfeUrlPathAndQuery);
			}
		}
	}
}
