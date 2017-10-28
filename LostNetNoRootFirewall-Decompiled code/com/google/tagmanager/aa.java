package com.google.tagmanager;

import com.google.tagmanager.Container.Callback;
import com.google.tagmanager.Container.RefreshFailure;
import com.google.tagmanager.Container.RefreshType;

class aa implements Callback {
    final /* synthetic */ ContainerOpener f940a;
    private final long f941b;

    public aa(ContainerOpener containerOpener, long j) {
        this.f940a = containerOpener;
        this.f941b = j;
    }

    private boolean m1326a() {
        return this.f941b < this.f940a.mContainer.getLastRefreshTime();
    }

    public void containerRefreshBegin(Container container, RefreshType refreshType) {
    }

    public void containerRefreshFailure(Container container, RefreshType refreshType, RefreshFailure refreshFailure) {
        if (refreshType == RefreshType.NETWORK) {
            this.f940a.callNotifiers(container);
        }
    }

    public void containerRefreshSuccess(Container container, RefreshType refreshType) {
        if (refreshType == RefreshType.NETWORK || m1326a()) {
            this.f940a.callNotifiers(container);
        }
    }
}
