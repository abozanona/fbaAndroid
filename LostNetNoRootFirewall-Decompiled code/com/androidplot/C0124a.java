package com.androidplot;

final class C0124a implements Runnable {
    private /* synthetic */ Plot f469a;

    C0124a(Plot plot) {
        this.f469a = plot;
    }

    public final void run() {
        this.f469a.f467r = true;
        while (this.f469a.f467r) {
            this.f469a.f468s = false;
            synchronized (this.f469a.f461l) {
                this.f469a.m952a(this.f469a.f461l.getCanvas());
                this.f469a.f461l.swap();
            }
            synchronized (this.f469a.f462m) {
                this.f469a.postInvalidate();
                if (this.f469a.f467r) {
                    try {
                        this.f469a.f462m.wait();
                    } catch (InterruptedException e) {
                        this.f469a.f467r = false;
                    }
                }
            }
        }
        System.out.println("AndroidPlot render thread finished.");
    }
}
