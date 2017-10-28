package com.google.tagmanager;

import com.google.tagmanager.Container.Callback;
import com.google.tagmanager.Container.RefreshFailure;
import com.google.tagmanager.Container.RefreshType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

public class ContainerOpener {
	public static final long DEFAULT_TIMEOUT_IN_MILLIS = 2000;
	private static final Map<String, List<Notifier>> mContainerIdNotifiersMap;
	private Clock mClock;
	private volatile Container mContainer;
	private final String mContainerId;
	private boolean mHaveNotified;
	private Notifier mNotifier;
	private final TagManager mTagManager;
	private final long mTimeoutInMillis;

	public static interface Notifier {
		public void containerAvailable(Container r1_Container);
	}

	static class AnonymousClass_2 implements ContainerOpener.Notifier {
		final /* synthetic */ ContainerOpener.ContainerFutureImpl val$future;

		AnonymousClass_2(ContainerOpener.ContainerFutureImpl r1_ContainerOpener_ContainerFutureImpl) {
			this.val$future = r1_ContainerOpener_ContainerFutureImpl;
		}

		public void containerAvailable(Container container) {
			this.val$future.setContainer(container);
		}
	}

	public static interface ContainerFuture {
		public Container get();

		public boolean isDone();
	}

	private static class ContainerFutureImpl implements ContainerOpener.ContainerFuture {
		private volatile Container mContainer;
		private Semaphore mContainerIsReady;
		private volatile boolean mHaveGotten;

		private ContainerFutureImpl() {
			this.mContainerIsReady = new Semaphore(0);
		}

		public Container get() {
			if (this.mHaveGotten) {
				return this.mContainer;
			} else {
				try {
					this.mContainerIsReady.acquire();
				} catch (InterruptedException e) {
				}
				this.mHaveGotten = true;
				return this.mContainer;
			}
		}

		public boolean isDone() {
			return this.mHaveGotten || this.mContainerIsReady.availablePermits() > 0;
		}

		public void setContainer(Container container) {
			this.mContainer = container;
			this.mContainerIsReady.release();
		}
	}

	public static enum OpenType {
		PREFER_NON_DEFAULT,
		PREFER_FRESH;

	}

	private class WaitForFresh implements Callback {
		private final long mOldestTimeToBeFresh;

		public WaitForFresh(long oldestTimeToBeFresh) {
			this.mOldestTimeToBeFresh = oldestTimeToBeFresh;
		}

		private boolean isFresh() {
			return (this.mOldestTimeToBeFresh > mContainer.getLastRefreshTime() ? 1 : (this.mOldestTimeToBeFresh == mContainer.getLastRefreshTime() ? 0 : -1)) < 0;
		}

		public void containerRefreshBegin(Container container, RefreshType refreshType) {
		}

		public void containerRefreshFailure(Container container, RefreshType refreshType, RefreshFailure refreshFailure) {
			if (refreshType == RefreshType.NETWORK) {
				callNotifiers(container);
			}
		}

		public void containerRefreshSuccess(Container container, RefreshType refreshType) {
			if (refreshType == RefreshType.NETWORK || isFresh()) {
				callNotifiers(container);
			}
		}
	}

	private class WaitForNonDefaultRefresh implements Callback {
		public void containerRefreshBegin(Container container, RefreshType refreshType) {
		}

		public void containerRefreshFailure(Container container, RefreshType refreshType, RefreshFailure refreshFailure) {
			if (refreshType == RefreshType.NETWORK) {
				callNotifiers(container);
			}
		}

		public void containerRefreshSuccess(Container container, RefreshType refreshType) {
			callNotifiers(container);
		}
	}


	static {
		mContainerIdNotifiersMap = new HashMap();
	}

	private ContainerOpener(TagManager tagManager, String containerId, Long timeoutInMillis, Notifier notifier) {
		this.mClock = new Clock() {
			public long currentTimeMillis() {
				return System.currentTimeMillis();
			}
		};
		this.mTagManager = tagManager;
		this.mContainerId = containerId;
		this.mTimeoutInMillis = (timeoutInMillis != null) ? Math.max(1, timeoutInMillis.longValue()) : DEFAULT_TIMEOUT_IN_MILLIS;
		this.mNotifier = notifier;
	}

	private synchronized void callNotifiers(Container container) {
		synchronized(this) {
			try {
				if (!(this.mHaveNotified)) {
					List<Notifier> notifiers;
					Class r5_Class = ContainerOpener.class;
					synchronized(r5_Class) {
						notifiers = (List) mContainerIdNotifiersMap.remove(this.mContainerId);
					}
					if (notifiers != null) {
						Iterator i$ = notifiers.iterator();
						while (i$.hasNext()) {
							((Notifier) i$.next()).containerAvailable(container);
						}
					}
					this.mHaveNotified = true;
				}
			} catch (Throwable th) {
			}
		}
	}

	private void open(RefreshType refreshType) {
		long loadStartTime = this.mClock.currentTimeMillis();
		boolean callNotifierImmediately = false;
		Class r7_Class = ContainerOpener.class;
		synchronized(r7_Class) {
			this.mContainer = this.mTagManager.getContainer(this.mContainerId);
			List<Notifier> notifiers;
			if (this.mContainer == null) {
				notifiers = new ArrayList();
				notifiers.add(this.mNotifier);
				this.mNotifier = null;
				mContainerIdNotifiersMap.put(this.mContainerId, notifiers);
				this.mContainer = this.mTagManager.openContainer(this.mContainerId, (refreshType == RefreshType.SAVED) ? new WaitForNonDefaultRefresh() : new WaitForFresh(loadStartTime - 43200000));
			} else {
				notifiers = mContainerIdNotifiersMap.get(this.mContainerId);
				if (notifiers == null) {
					callNotifierImmediately = true;
				} else {
					notifiers.add(this.mNotifier);
					this.mNotifier = null;
					return;
				}
			}
			if (callNotifierImmediately) {
				this.mNotifier.containerAvailable(this.mContainer);
				this.mNotifier = null;
				return;
			} else {
				setTimer(Math.max(1, this.mTimeoutInMillis - (this.mClock.currentTimeMillis() - loadStartTime)));
			}
		}
	}

	public static ContainerFuture openContainer(TagManager tagManager, String containerId, OpenType openType, Long timeoutInMillis) {
		ContainerFutureImpl future = new ContainerFutureImpl();
		openContainer(tagManager, containerId, openType, timeoutInMillis, new AnonymousClass_2(future));
		return future;
	}

	public static void openContainer(TagManager tagManager, String containerId, OpenType openType, Long timeoutInMillis, Notifier notifier) {
		if (tagManager == null) {
			throw new NullPointerException("TagManager cannot be null.");
		} else if (containerId == null) {
			throw new NullPointerException("ContainerId cannot be null.");
		} else if (openType == null) {
			throw new NullPointerException("OpenType cannot be null.");
		} else if (notifier == null) {
			throw new NullPointerException("Notifier cannot be null.");
		} else {
			new ContainerOpener(tagManager, containerId, timeoutInMillis, notifier).open((openType == OpenType.PREFER_FRESH) ? RefreshType.NETWORK : RefreshType.SAVED);
		}
	}

	private void setTimer(long timeoutInMillis) {
		Timer r1_Timer = new Timer("ContainerOpener");
		r1_Timer.schedule(new TimerTask() {
			public void run() {
				Log.i("Timer expired.");
				callNotifiers(mContainer);
			}
		}, timeoutInMillis);
	}
}
