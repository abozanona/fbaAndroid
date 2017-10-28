package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.ResourceUtil.ExpandedResource;
import com.google.tagmanager.ResourceUtil.InvalidResourceException;
import com.google.tagmanager.TagManager.RefreshMode;
import com.google.tagmanager.proto.Resource.ResourceWithMetadata;
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
    private C0220m mClock;
    private final String mContainerId;
    private final Context mContext;
    private ad mCtfeHost;
    private volatile String mCtfeServerAddress;
    private volatile String mCtfeUrlPathAndQuery;
    @VisibleForTesting
    LoadCallback mDiskLoadCallback;
    private Map mFunctionCallMacroHandlers;
    private Map mFunctionCallTagHandlers;
    private volatile Resource mLastLoadedResource;
    private volatile long mLastRefreshMethodCalledTime;
    private volatile long mLastRefreshTime;
    @VisibleForTesting
    LoadCallback mNetworkLoadCallback;
    private C0222u mNetworkLoadScheduler;
    private volatile int mNumTokens;
    private volatile int mResourceFormatVersion;
    private C0223v mResourceStorage;
    private volatile String mResourceVersion;
    private dn mRuntime;
    private final TagManager mTagManager;
    private Callback mUserCallback;

    public interface Callback {
        void containerRefreshBegin(Container container, RefreshType refreshType);

        void containerRefreshFailure(Container container, RefreshType refreshType, RefreshFailure refreshFailure);

        void containerRefreshSuccess(Container container, RefreshType refreshType);
    }

    public interface FunctionCallMacroHandler {
        Object getValue(String str, Map map);
    }

    public interface FunctionCallTagHandler {
        void execute(String str, Map map);
    }

    public enum RefreshFailure {
        NO_SAVED_CONTAINER,
        IO_ERROR,
        NO_NETWORK,
        NETWORK_ERROR,
        SERVER_ERROR,
        UNKNOWN_ERROR
    }

    public enum RefreshType {
        SAVED,
        NETWORK
    }

    Container(Context context, String str, TagManager tagManager) {
        this(context, str, tagManager, new di(context, str));
    }

    @VisibleForTesting
    Container(Context context, String str, TagManager tagManager, C0223v c0223v) {
        this.mResourceVersion = "";
        this.mResourceFormatVersion = 0;
        this.mCtfeHost = new ad();
        this.mContext = context;
        this.mContainerId = str;
        this.mTagManager = tagManager;
        this.mResourceStorage = c0223v;
        this.mNumTokens = MAX_NUMBER_OF_TOKENS;
        this.mFunctionCallMacroHandlers = new HashMap();
        this.mFunctionCallTagHandlers = new HashMap();
        createInitialContainer();
    }

    private synchronized void callRefreshBegin(RefreshType refreshType) {
        if (this.mUserCallback != null) {
            this.mUserCallback.containerRefreshBegin(this, refreshType);
        }
    }

    private synchronized void callRefreshFailure(RefreshType refreshType, RefreshFailure refreshFailure) {
        if (this.mUserCallback != null) {
            this.mUserCallback.containerRefreshFailure(this, refreshType, refreshFailure);
        }
    }

    private synchronized void callRefreshSuccess(RefreshType refreshType) {
        bs.m1445e("calling containerRefreshSuccess(" + refreshType + "): mUserCallback = " + this.mUserCallback);
        if (this.mUserCallback != null) {
            this.mUserCallback.containerRefreshSuccess(this, refreshType);
        }
    }

    private void createInitialContainer() {
        String str = "tagmanager/" + this.mContainerId;
        Resource a = this.mResourceStorage.mo662a(str);
        if (a != null) {
            initEvaluators(a, true);
            return;
        }
        ExpandedResource b = this.mResourceStorage.mo666b(str + ".json");
        if (b == null) {
            bs.m1441b("No default container found; creating an empty container.");
            b = ExpandedResource.newBuilder().build();
        }
        initEvaluatorsWithExpandedResource(b);
    }

    private synchronized dn getRuntime() {
        return this.mRuntime;
    }

    private void initEvaluators(Resource resource, boolean z) {
        try {
            ExpandedResource a = ResourceUtil.m1309a(resource);
            if (!z) {
                this.mLastLoadedResource = resource;
            }
            initEvaluatorsWithExpandedResource(a);
        } catch (InvalidResourceException e) {
            bs.m1438a("Not loading resource: " + resource + " because it is invalid: " + e.toString());
        }
    }

    private void initEvaluatorsWithExpandedResource(ExpandedResource expandedResource) {
        this.mResourceVersion = expandedResource.getVersion();
        this.mResourceFormatVersion = expandedResource.getResourceFormatVersion();
        ExpandedResource expandedResource2 = expandedResource;
        setRuntime(new dn(this.mContext, expandedResource2, this.mTagManager.getDataLayer(), new C0265s(), new C0266t(), createEventInfoDistributor(this.mResourceVersion)));
    }

    private boolean isContainerPreview() {
        cq a = cq.m1525a();
        return (a.m1529b() == cr.CONTAINER || a.m1529b() == cr.CONTAINER_DEBUG) && this.mContainerId.equals(a.m1531d());
    }

    private boolean isDefaultContainerRefreshMode() {
        return this.mTagManager.getRefreshMode() == RefreshMode.DEFAULT_CONTAINER;
    }

    private synchronized void saveResourceToDisk(Resource resource) {
        if (this.mResourceStorage != null) {
            this.mResourceStorage.mo665a(ResourceWithMetadata.newBuilder().setTimeStamp(getLastRefreshTime()).setResource(resource).build());
        }
    }

    private synchronized void setRuntime(dn dnVar) {
        this.mRuntime = dnVar;
    }

    private boolean useAvailableToken(long j) {
        if (this.mLastRefreshMethodCalledTime == 0) {
            this.mNumTokens--;
            return true;
        }
        long j2 = j - this.mLastRefreshMethodCalledTime;
        if (j2 < 5000) {
            return false;
        }
        if (this.mNumTokens < MAX_NUMBER_OF_TOKENS) {
            this.mNumTokens = Math.min(MAX_NUMBER_OF_TOKENS, ((int) Math.floor((double) (j2 / MINIMUM_REFRESH_PERIOD_MS))) + this.mNumTokens);
        }
        if (this.mNumTokens <= 0) {
            return false;
        }
        this.mNumTokens--;
        return true;
    }

    public synchronized void close() {
        try {
            if (this.mNetworkLoadScheduler != null) {
                this.mNetworkLoadScheduler.mo656a();
            }
            this.mNetworkLoadScheduler = null;
            if (this.mResourceStorage != null) {
                this.mResourceStorage.mo667b();
            }
            this.mResourceStorage = null;
            this.mUserCallback = null;
            this.mTagManager.removeContainer(this.mContainerId);
        } catch (Exception e) {
            bs.m1438a("Calling close() threw an exception: " + e.getMessage());
        }
        this.mRuntime = null;
    }

    @VisibleForTesting
    aq createEventInfoDistributor(String str) {
        if (cq.m1525a().m1529b().equals(cr.CONTAINER_DEBUG)) {
        }
        return new cb();
    }

    @VisibleForTesting
    void evaluateTags(String str) {
        getRuntime().m1596a(str);
    }

    public boolean getBoolean(String str) {
        dn runtime = getRuntime();
        if (runtime == null) {
            bs.m1438a("getBoolean called for closed container.");
            return es.m1674c().booleanValue();
        }
        try {
            return es.m1682e((Value) runtime.m1597b(str).m1496a()).booleanValue();
        } catch (Exception e) {
            bs.m1438a("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return es.m1674c().booleanValue();
        }
    }

    public String getContainerId() {
        return this.mContainerId;
    }

    String getCtfeUrlPathAndQuery() {
        return this.mCtfeUrlPathAndQuery;
    }

    public double getDouble(String str) {
        dn runtime = getRuntime();
        if (runtime == null) {
            bs.m1438a("getDouble called for closed container.");
            return es.m1673b().doubleValue();
        }
        try {
            return es.m1679d((Value) runtime.m1597b(str).m1496a()).doubleValue();
        } catch (Exception e) {
            bs.m1438a("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return es.m1673b().doubleValue();
        }
    }

    public synchronized FunctionCallMacroHandler getFunctionCallMacroHandler(String str) {
        return (FunctionCallMacroHandler) this.mFunctionCallMacroHandlers.get(str);
    }

    public synchronized FunctionCallTagHandler getFunctionCallTagHandler(String str) {
        return (FunctionCallTagHandler) this.mFunctionCallTagHandlers.get(str);
    }

    public long getLastRefreshTime() {
        return this.mLastRefreshTime;
    }

    public long getLong(String str) {
        dn runtime = getRuntime();
        if (runtime == null) {
            bs.m1438a("getLong called for closed container.");
            return es.m1667a().longValue();
        }
        try {
            return es.m1675c((Value) runtime.m1597b(str).m1496a()).longValue();
        } catch (Exception e) {
            bs.m1438a("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return es.m1667a().longValue();
        }
    }

    @VisibleForTesting
    String getResourceVersion() {
        return this.mResourceVersion;
    }

    public String getString(String str) {
        dn runtime = getRuntime();
        if (runtime == null) {
            bs.m1438a("getString called for closed container.");
            return es.m1685e();
        }
        try {
            return es.m1668a((Value) runtime.m1597b(str).m1496a());
        } catch (Exception e) {
            bs.m1438a("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return es.m1685e();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    void load(Callback callback) {
        load(callback, new dd(this.mContext, this.mContainerId, this.mCtfeHost), new C0233o(this));
    }

    @VisibleForTesting
    synchronized void load(Callback callback, C0222u c0222u, C0220m c0220m) {
        if (this.mDiskLoadCallback != null) {
            throw new RuntimeException("Container already loaded: container ID: " + this.mContainerId);
        }
        this.mClock = c0220m;
        this.mUserCallback = callback;
        this.mDiskLoadCallback = new C0234p(this, c0220m);
        if (isDefaultContainerRefreshMode()) {
            bs.m1443c("Container is in DEFAULT_CONTAINER mode. Use default container.");
        } else {
            this.mResourceStorage.mo664a(this.mDiskLoadCallback);
            this.mNetworkLoadCallback = new C0263q(this, c0220m);
            c0222u.mo658a(this.mNetworkLoadCallback);
            if (isContainerPreview()) {
                this.mCtfeUrlPathAndQuery = cq.m1525a().m1530c();
                c0222u.mo659a(this.mCtfeUrlPathAndQuery);
            }
            if (this.mCtfeServerAddress != null) {
                this.mCtfeHost.m1334a(this.mCtfeServerAddress);
            }
            this.mNetworkLoadScheduler = c0222u;
            this.mResourceStorage.mo663a();
        }
    }

    @VisibleForTesting
    synchronized void loadAfterDelay(long j) {
        if (!(this.mNetworkLoadScheduler == null || isDefaultContainerRefreshMode())) {
            this.mNetworkLoadScheduler.mo657a(j, this.mLastLoadedResource == null ? null : this.mLastLoadedResource.getVersion());
        }
    }

    public synchronized void refresh() {
        if (getRuntime() == null) {
            bs.m1441b("refresh called for closed container");
        } else {
            try {
                if (isDefaultContainerRefreshMode()) {
                    bs.m1441b("Container is in DEFAULT_CONTAINER mode. Refresh request is ignored.");
                } else {
                    long a = this.mClock.mo652a();
                    if (useAvailableToken(a)) {
                        bs.m1445e("Container refresh requested");
                        loadAfterDelay(0);
                        this.mLastRefreshMethodCalledTime = a;
                    } else {
                        bs.m1445e("Container refresh was called too often. Ignored.");
                    }
                }
            } catch (Exception e) {
                bs.m1438a("Calling refresh() throws an exception: " + e.getMessage());
            }
        }
    }

    public synchronized void registerFunctionCallMacroHandler(String str, FunctionCallMacroHandler functionCallMacroHandler) {
        this.mFunctionCallMacroHandlers.put(str, functionCallMacroHandler);
    }

    public synchronized void registerFunctionCallTagHandler(String str, FunctionCallTagHandler functionCallTagHandler) {
        this.mFunctionCallTagHandlers.put(str, functionCallTagHandler);
    }

    @VisibleForTesting
    synchronized void setCtfeServerAddress(String str) {
        this.mCtfeServerAddress = str;
        if (str != null) {
            this.mCtfeHost.m1334a(str);
        }
    }

    @VisibleForTesting
    synchronized void setCtfeUrlPathAndQuery(String str) {
        this.mCtfeUrlPathAndQuery = str;
        if (this.mNetworkLoadScheduler != null) {
            this.mNetworkLoadScheduler.mo659a(str);
        }
    }
}
