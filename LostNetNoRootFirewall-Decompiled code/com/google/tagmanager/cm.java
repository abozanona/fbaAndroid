package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.SimpleNetworkDispatcher.DispatchListener;

@VisibleForTesting
class cm implements DispatchListener {
    final /* synthetic */ ck f1034a;

    cm(ck ckVar) {
        this.f1034a = ckVar;
    }

    public void onHitDispatched(ay ayVar) {
        this.f1034a.m1502a(ayVar.m1381a());
    }

    public void onHitPermanentDispatchFailure(ay ayVar) {
        this.f1034a.m1502a(ayVar.m1381a());
        bs.m1445e("Permanent failure dispatching hitId: " + ayVar.m1381a());
    }

    public void onHitTransientDispatchFailure(ay ayVar) {
        long b = ayVar.m1383b();
        if (b == 0) {
            this.f1034a.m1503a(ayVar.m1381a(), this.f1034a.f1032h.mo652a());
        } else if (b + 14400000 < this.f1034a.f1032h.mo652a()) {
            this.f1034a.m1502a(ayVar.m1381a());
            bs.m1445e("Giving up on failed hitId: " + ayVar.m1381a());
        }
    }
}
