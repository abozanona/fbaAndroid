package com.androidplot.util;

import android.util.Log;
import com.androidplot.Plot;
import java.util.Arrays;
import java.util.List;

public class Redrawer implements Runnable {
    private static final String f591a = Redrawer.class.getName();
    private List f592b;
    private long f593c;
    private boolean f594d;
    private boolean f595e;

    public Redrawer(Plot plot, float f, boolean z) {
        this(Arrays.asList(new Plot[]{plot}), f, z);
    }

    public Redrawer(List list, float f, boolean z) {
        this.f592b = list;
        setMaxRefreshRate(f);
        new Thread(this).start();
        if (z) {
            run();
        }
    }

    public synchronized void finish() {
        this.f594d = false;
        this.f595e = false;
        notify();
    }

    public synchronized void pause() {
        this.f594d = false;
        notify();
        Log.d(f591a, "Redrawer paused.");
    }

    public void run() {
        this.f595e = true;
        while (this.f595e) {
            try {
                if (this.f594d) {
                    for (Plot redraw : this.f592b) {
                        redraw.redraw();
                    }
                    synchronized (this) {
                        wait(this.f593c);
                    }
                } else {
                    synchronized (this) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                Log.d(f591a, "Redrawer thread exited.");
                return;
            } catch (Throwable th) {
                Log.d(f591a, "Redrawer thread exited.");
            }
        }
        Log.d(f591a, "Redrawer thread exited.");
    }

    public void setMaxRefreshRate(float f) {
        this.f593c = (long) (1000.0f / f);
        Log.d(f591a, "Set Redrawer refresh rate to " + f + "( " + this.f593c + " ms)");
    }

    public synchronized void start() {
        this.f594d = true;
        notify();
        Log.d(f591a, "Redrawer started.");
    }
}
