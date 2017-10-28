package com.ppu.fba;

import android.os.AsyncTask;

public class C0288a {
    private int f1358a;
    private String f1359b;
    private Object f1360c;
    private Runnable f1361d;
    private AsyncTask f1362e;

    public C0288a(int i) {
        this.f1358a = i;
    }

    public C0288a(int i, AsyncTask asyncTask) {
        this.f1358a = i;
        this.f1362e = asyncTask;
    }

    public C0288a(int i, String str) {
        this.f1358a = i;
        this.f1359b = str;
    }

    public int m1916a() {
        return this.f1358a;
    }

    public String m1917b() {
        return this.f1359b;
    }

    public void m1918c() {
        if (this.f1360c != null) {
            try {
                synchronized (this.f1360c) {
                    this.f1360c.notifyAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.f1361d != null) {
            this.f1361d.run();
        }
        if (this.f1362e != null) {
            this.f1362e.execute(new Object[]{new Object()});
        }
    }
}
