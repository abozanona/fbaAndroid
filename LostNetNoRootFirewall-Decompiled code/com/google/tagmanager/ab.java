package com.google.tagmanager;

import com.google.tagmanager.Container.Callback;
import com.google.tagmanager.Container.RefreshFailure;
import com.google.tagmanager.Container.RefreshType;

class ab implements Callback {
    final /* synthetic */ ContainerOpener f942a;

    public ab(ContainerOpener containerOpener) {
        this.f942a = containerOpener;
    }

    public void containerRefreshBegin(Container container, RefreshType refreshType) {
    }

    public void containerRefreshFailure(Container container, RefreshType refreshType, RefreshFailure refreshFailure) {
        if (refreshType == RefreshType.NETWORK) {
            this.f942a.callNotifiers(container);
        }
    }

    public void containerRefreshSuccess(Container container, RefreshType refreshType) {
        this.f942a.callNotifiers(container);
    }
}
