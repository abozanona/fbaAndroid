package com.google.tagmanager;

import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.tagmanager.Container.RefreshFailure;
import com.google.tagmanager.Container.RefreshType;
import com.google.tagmanager.LoadCallback.Failure;

class C0263q implements LoadCallback {
    final /* synthetic */ C0220m f1278a;
    final /* synthetic */ Container f1279b;

    C0263q(Container container, C0220m c0220m) {
        this.f1279b = container;
        this.f1278a = c0220m;
    }

    private RefreshFailure m1844b(Failure failure) {
        switch (C0264r.f1280a[failure.ordinal()]) {
            case 1:
                return RefreshFailure.NO_NETWORK;
            case 2:
                return RefreshFailure.NETWORK_ERROR;
            case 3:
                return RefreshFailure.SERVER_ERROR;
            default:
                return RefreshFailure.UNKNOWN_ERROR;
        }
    }

    public void mo676a() {
        this.f1279b.callRefreshBegin(RefreshType.NETWORK);
    }

    public void m1846a(Resource resource) {
        synchronized (this.f1279b) {
            if (resource != null) {
                this.f1279b.initEvaluators(resource, false);
            } else if (this.f1279b.mLastLoadedResource == null) {
                mo677a(Failure.SERVER_ERROR);
                return;
            } else {
                resource = this.f1279b.mLastLoadedResource;
            }
            this.f1279b.mLastRefreshTime = this.f1278a.mo652a();
            bs.m1445e("setting refresh time to current time: " + this.f1279b.mLastRefreshTime);
            if (!this.f1279b.isContainerPreview()) {
                this.f1279b.saveResourceToDisk(resource);
            }
            this.f1279b.loadAfterDelay(43200000);
            this.f1279b.callRefreshSuccess(RefreshType.NETWORK);
        }
    }

    public void mo677a(Failure failure) {
        this.f1279b.loadAfterDelay(3600000);
        this.f1279b.callRefreshFailure(RefreshType.NETWORK, m1844b(failure));
    }
}
