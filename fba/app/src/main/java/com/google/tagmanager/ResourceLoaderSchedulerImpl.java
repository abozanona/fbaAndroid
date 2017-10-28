package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Container.ResourceLoaderScheduler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class ResourceLoaderSchedulerImpl implements ResourceLoaderScheduler {
	private static final boolean MAY_INTERRUPT_IF_RUNNING = true;
	private LoadCallback<Resource> mCallback;
	private boolean mClosed;
	private final String mContainerId;
	private final Context mContext;
	private CtfeHost mCtfeHost;
	private String mCtfeUrlPathAndQuery;
	private final ScheduledExecutorService mExecutor;
	private ScheduledFuture<?> mFuture;
	private final ResourceLoaderFactory mResourceLoaderFactory;

	static interface ScheduledExecutorServiceFactory {
		public ScheduledExecutorService createExecutorService();
	}

	static interface ResourceLoaderFactory {
		public ResourceLoader createResourceLoader(CtfeHost r1_CtfeHost);
	}


	public ResourceLoaderSchedulerImpl(Context context, String containerId, CtfeHost ctfeHost) {
		this(context, containerId, ctfeHost, null, null);
	}

	@VisibleForTesting
	ResourceLoaderSchedulerImpl(Context context, String containerId, CtfeHost ctfeHost, ScheduledExecutorServiceFactory executorServiceFactory, ResourceLoaderFactory resourceLoaderFactory) {
		this.mCtfeHost = ctfeHost;
		this.mContext = context;
		this.mContainerId = containerId;
		if (executorServiceFactory == null) {
			executorServiceFactory = new ScheduledExecutorServiceFactory() {
						public ScheduledExecutorService createExecutorService() {
							return Executors.newSingleThreadScheduledExecutor();
						}
					};
		}
		this.mExecutor = executorServiceFactory.createExecutorService();
		if (resourceLoaderFactory == null) {
			this.mResourceLoaderFactory = new ResourceLoaderFactory() {
			public ResourceLoader createResourceLoader(CtfeHost ctfeHost) {
				return new ResourceLoader(mContext, mContainerId, ctfeHost);
			}
		};
			return;
		} else {
			this.mResourceLoaderFactory = resourceLoaderFactory;
		}
	}

	private ResourceLoader createResourceLoader(String previousVersion) {
		ResourceLoader resourceLoader = this.mResourceLoaderFactory.createResourceLoader(this.mCtfeHost);
		resourceLoader.setLoadCallback(this.mCallback);
		resourceLoader.setCtfeURLPathAndQuery(this.mCtfeUrlPathAndQuery);
		resourceLoader.setPreviousVersion(previousVersion);
		return resourceLoader;
	}

	private synchronized void ensureNotClosed() {
		synchronized(this) {
			if (this.mClosed) {
				throw new IllegalStateException("called method after closed");
			}
		}
	}

	public synchronized void close() {
		synchronized(this) {
			ensureNotClosed();
			if (this.mFuture != null) {
				this.mFuture.cancel(false);
			}
			this.mExecutor.shutdown();
			this.mClosed = true;
		}
	}

	public synchronized void loadAfterDelay(long delayInMillis, String previousVersion) {
		synchronized(this) {
			Log.v("loadAfterDelay: containerId=" + this.mContainerId + " delay=" + delayInMillis);
			ensureNotClosed();
			if (this.mCallback == null) {
				throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
			} else {
				if (this.mFuture != null) {
					this.mFuture.cancel(MAY_INTERRUPT_IF_RUNNING);
				}
				this.mFuture = this.mExecutor.schedule(createResourceLoader(previousVersion), delayInMillis, TimeUnit.MILLISECONDS);
			}
		}
	}

	public synchronized void setCtfeURLPathAndQuery(String urlPathAndQuery) {
		synchronized(this) {
			ensureNotClosed();
			this.mCtfeUrlPathAndQuery = urlPathAndQuery;
		}
	}

	public synchronized void setLoadCallback(LoadCallback<Resource> callback) {
		synchronized(this) {
			ensureNotClosed();
			this.mCallback = callback;
		}
	}
}
