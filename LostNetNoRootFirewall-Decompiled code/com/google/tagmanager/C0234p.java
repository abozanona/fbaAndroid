package com.google.tagmanager;

import com.google.tagmanager.Container.RefreshFailure;
import com.google.tagmanager.Container.RefreshType;
import com.google.tagmanager.LoadCallback.Failure;
import com.google.tagmanager.proto.Resource.ResourceWithMetadata;

class C0234p implements LoadCallback {
    final /* synthetic */ C0220m f1190a;
    final /* synthetic */ Container f1191b;

    C0234p(Container container, C0220m c0220m) {
        this.f1191b = container;
        this.f1190a = c0220m;
    }

    private RefreshFailure m1722b(Failure failure) {
        switch (C0264r.f1280a[failure.ordinal()]) {
            case 1:
                return RefreshFailure.NO_SAVED_CONTAINER;
            case 2:
                return RefreshFailure.IO_ERROR;
            case 3:
                return RefreshFailure.SERVER_ERROR;
            default:
                return RefreshFailure.UNKNOWN_ERROR;
        }
    }

    public void mo676a() {
        this.f1191b.callRefreshBegin(RefreshType.SAVED);
    }

    public void mo677a(Failure failure) {
        this.f1191b.callRefreshFailure(RefreshType.SAVED, m1722b(failure));
        if (this.f1191b.isDefault()) {
            this.f1191b.loadAfterDelay(0);
        }
    }

    public void m1725a(ResourceWithMetadata resourceWithMetadata) {
        if (this.f1191b.isDefault()) {
            this.f1191b.initEvaluators(resourceWithMetadata.getResource(), false);
            bs.m1445e("setting refresh time to saved time: " + resourceWithMetadata.getTimeStamp());
            this.f1191b.mLastRefreshTime = resourceWithMetadata.getTimeStamp();
            this.f1191b.loadAfterDelay(Math.max(0, Math.min(43200000, (this.f1191b.mLastRefreshTime + 43200000) - this.f1190a.mo652a())));
        }
        this.f1191b.callRefreshSuccess(RefreshType.SAVED);
    }
}
