package com.google.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class bb extends Thread implements ba {
    private static bb f982d;
    private final LinkedBlockingQueue f983a = new LinkedBlockingQueue();
    private volatile boolean f984b = false;
    private volatile boolean f985c = false;
    private volatile bd f986e;
    private final Context f987f;

    private bb(Context context) {
        super("GAThread");
        if (context != null) {
            this.f987f = context.getApplicationContext();
        } else {
            this.f987f = context;
        }
        start();
    }

    static bb m1389a(Context context) {
        if (f982d == null) {
            f982d = new bb(context);
        }
        return f982d;
    }

    private String m1392a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void mo623a(Runnable runnable) {
        this.f983a.add(runnable);
    }

    public void mo624a(String str) {
        m1396a(str, System.currentTimeMillis());
    }

    @VisibleForTesting
    void m1396a(String str, long j) {
        mo623a(new bc(this, this, j, str));
    }

    public void run() {
        while (!this.f985c) {
            try {
                Runnable runnable = (Runnable) this.f983a.take();
                if (!this.f984b) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                bs.m1443c(e.toString());
            } catch (Throwable th) {
                bs.m1438a("Error on GAThread: " + m1392a(th));
                bs.m1438a("Google Analytics is shutting down.");
                this.f984b = true;
            }
        }
    }
}
