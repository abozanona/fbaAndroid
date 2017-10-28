package com.google.tagmanager;

import java.util.TimerTask;

class C0269y extends TimerTask {
    final /* synthetic */ ContainerOpener f1285a;

    C0269y(ContainerOpener containerOpener) {
        this.f1285a = containerOpener;
    }

    public void run() {
        bs.m1443c("Timer expired.");
        this.f1285a.callNotifiers(this.f1285a.mContainer);
    }
}
