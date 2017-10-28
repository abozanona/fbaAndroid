package com.google.tagmanager;

import com.google.tagmanager.Container.RefreshType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

public class ContainerOpener {
    public static final long DEFAULT_TIMEOUT_IN_MILLIS = 2000;
    private static final Map mContainerIdNotifiersMap = new HashMap();
    private C0220m mClock = new C0267w(this);
    private volatile Container mContainer;
    private final String mContainerId;
    private boolean mHaveNotified;
    private Notifier mNotifier;
    private final TagManager mTagManager;
    private final long mTimeoutInMillis;

    public interface ContainerFuture {
        Container get();

        boolean isDone();
    }

    public interface Notifier {
        void containerAvailable(Container container);
    }

    public enum OpenType {
        PREFER_NON_DEFAULT,
        PREFER_FRESH
    }

    private ContainerOpener(TagManager tagManager, String str, Long l, Notifier notifier) {
        this.mTagManager = tagManager;
        this.mContainerId = str;
        this.mTimeoutInMillis = l != null ? Math.max(1, l.longValue()) : DEFAULT_TIMEOUT_IN_MILLIS;
        this.mNotifier = notifier;
    }

    private synchronized void callNotifiers(Container container) {
        if (!this.mHaveNotified) {
            List<Notifier> list;
            synchronized (ContainerOpener.class) {
                list = (List) mContainerIdNotifiersMap.remove(this.mContainerId);
            }
            if (list != null) {
                for (Notifier containerAvailable : list) {
                    containerAvailable.containerAvailable(container);
                }
            }
            this.mHaveNotified = true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void open(com.google.tagmanager.Container.RefreshType r11) {
        /*
        r10 = this;
        r9 = 0;
        r0 = r10.mClock;
        r2 = r0.mo652a();
        r0 = 0;
        r4 = com.google.tagmanager.ContainerOpener.class;
        monitor-enter(r4);
        r1 = r10.mTagManager;	 Catch:{ all -> 0x0058 }
        r5 = r10.mContainerId;	 Catch:{ all -> 0x0058 }
        r1 = r1.getContainer(r5);	 Catch:{ all -> 0x0058 }
        r10.mContainer = r1;	 Catch:{ all -> 0x0058 }
        r1 = r10.mContainer;	 Catch:{ all -> 0x0058 }
        if (r1 != 0) goto L_0x005b;
    L_0x0019:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0058 }
        r1.<init>();	 Catch:{ all -> 0x0058 }
        r5 = r10.mNotifier;	 Catch:{ all -> 0x0058 }
        r1.add(r5);	 Catch:{ all -> 0x0058 }
        r5 = 0;
        r10.mNotifier = r5;	 Catch:{ all -> 0x0058 }
        r5 = mContainerIdNotifiersMap;	 Catch:{ all -> 0x0058 }
        r6 = r10.mContainerId;	 Catch:{ all -> 0x0058 }
        r5.put(r6, r1);	 Catch:{ all -> 0x0058 }
        r5 = r10.mTagManager;	 Catch:{ all -> 0x0058 }
        r6 = r10.mContainerId;	 Catch:{ all -> 0x0058 }
        r1 = com.google.tagmanager.Container.RefreshType.SAVED;	 Catch:{ all -> 0x0058 }
        if (r11 != r1) goto L_0x004d;
    L_0x0035:
        r1 = new com.google.tagmanager.ab;	 Catch:{ all -> 0x0058 }
        r1.<init>(r10);	 Catch:{ all -> 0x0058 }
    L_0x003a:
        r1 = r5.openContainer(r6, r1);	 Catch:{ all -> 0x0058 }
        r10.mContainer = r1;	 Catch:{ all -> 0x0058 }
    L_0x0040:
        monitor-exit(r4);	 Catch:{ all -> 0x0058 }
        if (r0 == 0) goto L_0x0073;
    L_0x0043:
        r0 = r10.mNotifier;
        r1 = r10.mContainer;
        r0.containerAvailable(r1);
        r10.mNotifier = r9;
    L_0x004c:
        return;
    L_0x004d:
        r1 = new com.google.tagmanager.aa;	 Catch:{ all -> 0x0058 }
        r7 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r7 = r2 - r7;
        r1.<init>(r10, r7);	 Catch:{ all -> 0x0058 }
        goto L_0x003a;
    L_0x0058:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0058 }
        throw r0;
    L_0x005b:
        r0 = mContainerIdNotifiersMap;	 Catch:{ all -> 0x0058 }
        r1 = r10.mContainerId;	 Catch:{ all -> 0x0058 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0058 }
        r0 = (java.util.List) r0;	 Catch:{ all -> 0x0058 }
        if (r0 != 0) goto L_0x0069;
    L_0x0067:
        r0 = 1;
        goto L_0x0040;
    L_0x0069:
        r1 = r10.mNotifier;	 Catch:{ all -> 0x0058 }
        r0.add(r1);	 Catch:{ all -> 0x0058 }
        r0 = 0;
        r10.mNotifier = r0;	 Catch:{ all -> 0x0058 }
        monitor-exit(r4);	 Catch:{ all -> 0x0058 }
        goto L_0x004c;
    L_0x0073:
        r0 = r10.mTimeoutInMillis;
        r4 = r10.mClock;
        r4 = r4.mo652a();
        r2 = r4 - r2;
        r0 = r0 - r2;
        r2 = 1;
        r0 = java.lang.Math.max(r2, r0);
        r10.setTimer(r0);
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.tagmanager.ContainerOpener.open(com.google.tagmanager.Container$RefreshType):void");
    }

    public static ContainerFuture openContainer(TagManager tagManager, String str, OpenType openType, Long l) {
        ContainerFuture c0270z = new C0270z();
        openContainer(tagManager, str, openType, l, new C0268x(c0270z));
        return c0270z;
    }

    public static void openContainer(TagManager tagManager, String str, OpenType openType, Long l, Notifier notifier) {
        if (tagManager == null) {
            throw new NullPointerException("TagManager cannot be null.");
        } else if (str == null) {
            throw new NullPointerException("ContainerId cannot be null.");
        } else if (openType == null) {
            throw new NullPointerException("OpenType cannot be null.");
        } else if (notifier == null) {
            throw new NullPointerException("Notifier cannot be null.");
        } else {
            new ContainerOpener(tagManager, str, l, notifier).open(openType == OpenType.PREFER_FRESH ? RefreshType.NETWORK : RefreshType.SAVED);
        }
    }

    private void setTimer(long j) {
        new Timer("ContainerOpener").schedule(new C0269y(this), j);
    }
}
