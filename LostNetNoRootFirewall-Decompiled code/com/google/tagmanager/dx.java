package com.google.tagmanager;

class dx implements cu {
    private final long f1119a;
    private final int f1120b;
    private double f1121c;
    private long f1122d;
    private final Object f1123e;

    public dx() {
        this(60, ContainerOpener.DEFAULT_TIMEOUT_IN_MILLIS);
    }

    public dx(int i, long j) {
        this.f1123e = new Object();
        this.f1120b = i;
        this.f1121c = (double) this.f1120b;
        this.f1119a = j;
    }

    public boolean mo670a() {
        boolean z;
        synchronized (this.f1123e) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f1121c < ((double) this.f1120b)) {
                double d = ((double) (currentTimeMillis - this.f1122d)) / ((double) this.f1119a);
                if (d > 0.0d) {
                    this.f1121c = Math.min((double) this.f1120b, d + this.f1121c);
                }
            }
            this.f1122d = currentTimeMillis;
            if (this.f1121c >= 1.0d) {
                this.f1121c -= 1.0d;
                z = true;
            } else {
                bs.m1441b("No more tokens available.");
                z = false;
            }
        }
        return z;
    }
}
