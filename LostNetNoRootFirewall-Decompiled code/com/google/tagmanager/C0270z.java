package com.google.tagmanager;

import com.google.tagmanager.ContainerOpener.ContainerFuture;
import java.util.concurrent.Semaphore;

class C0270z implements ContainerFuture {
    private volatile boolean f1286a;
    private volatile Container f1287b;
    private Semaphore f1288c;

    private C0270z() {
        this.f1288c = new Semaphore(0);
    }

    public void m1850a(Container container) {
        this.f1287b = container;
        this.f1288c.release();
    }

    public Container get() {
        if (this.f1286a) {
            return this.f1287b;
        }
        try {
            this.f1288c.acquire();
        } catch (InterruptedException e) {
        }
        this.f1286a = true;
        return this.f1287b;
    }

    public boolean isDone() {
        return this.f1286a || this.f1288c.availablePermits() > 0;
    }
}
