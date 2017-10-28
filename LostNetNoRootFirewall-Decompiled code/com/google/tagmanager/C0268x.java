package com.google.tagmanager;

import com.google.tagmanager.ContainerOpener.Notifier;

final class C0268x implements Notifier {
    final /* synthetic */ C0270z f1284a;

    C0268x(C0270z c0270z) {
        this.f1284a = c0270z;
    }

    public void containerAvailable(Container container) {
        this.f1284a.m1850a(container);
    }
}
