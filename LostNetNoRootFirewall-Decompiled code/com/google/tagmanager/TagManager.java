package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Container.Callback;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager sInstance;
    private final el mContainerProvider;
    private final ConcurrentMap mContainers;
    private final Context mContext;
    private volatile String mCtfeServerAddr;
    private final DataLayer mDataLayer;
    private volatile RefreshMode mRefreshMode;

    @Deprecated
    public interface Logger extends Logger {
    }

    public enum RefreshMode {
        STANDARD,
        DEFAULT_CONTAINER
    }

    @VisibleForTesting
    TagManager(Context context, el elVar, DataLayer dataLayer) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.mContainerProvider = elVar;
        this.mRefreshMode = RefreshMode.STANDARD;
        this.mContainers = new ConcurrentHashMap();
        this.mDataLayer = dataLayer;
        this.mDataLayer.registerListener(new ei(this));
        this.mDataLayer.registerListener(new C0219c(this.mContext));
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (sInstance == null) {
                sInstance = new TagManager(context, new ej(), new DataLayer());
            }
            tagManager = sInstance;
        }
        return tagManager;
    }

    private void refreshTagsInAllContainers(String str) {
        for (Container evaluateTags : this.mContainers.values()) {
            evaluateTags.evaluateTags(str);
        }
    }

    public Container getContainer(String str) {
        return (Container) this.mContainers.get(str);
    }

    public Context getContext() {
        return this.mContext;
    }

    public DataLayer getDataLayer() {
        return this.mDataLayer;
    }

    public Logger getLogger() {
        return bs.m1436a();
    }

    public RefreshMode getRefreshMode() {
        return this.mRefreshMode;
    }

    public Container openContainer(String str, Callback callback) {
        Container a = this.mContainerProvider.mo674a(this.mContext, str, this);
        if (this.mContainers.putIfAbsent(str, a) != null) {
            throw new IllegalArgumentException("Container id:" + str + " has already been opened.");
        }
        if (this.mCtfeServerAddr != null) {
            a.setCtfeServerAddress(this.mCtfeServerAddr);
        }
        a.load(callback);
        return a;
    }

    boolean removeContainer(String str) {
        return this.mContainers.remove(str) != null;
    }

    @VisibleForTesting
    void setCtfeServerAddress(String str) {
        this.mCtfeServerAddr = str;
    }

    public void setLogger(Logger logger) {
        bs.m1437a(logger);
    }

    synchronized boolean setPreviewData(Uri uri) {
        boolean z;
        cq a = cq.m1525a();
        if (a.m1528a(uri)) {
            String d = a.m1531d();
            switch (ek.f1150a[a.m1529b().ordinal()]) {
                case 1:
                    Container container = (Container) this.mContainers.get(d);
                    if (container != null) {
                        container.setCtfeUrlPathAndQuery(null);
                        container.refresh();
                        break;
                    }
                    break;
                case 2:
                case 3:
                    for (Entry entry : this.mContainers.entrySet()) {
                        Container container2 = (Container) entry.getValue();
                        if (((String) entry.getKey()).equals(d)) {
                            container2.setCtfeUrlPathAndQuery(a.m1530c());
                            container2.refresh();
                        } else if (container2.getCtfeUrlPathAndQuery() != null) {
                            container2.setCtfeUrlPathAndQuery(null);
                            container2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public void setRefreshMode(RefreshMode refreshMode) {
        this.mRefreshMode = refreshMode;
    }
}
