package com.ppu.fba;

class C0303c extends Thread {
    public C0303c(Runnable runnable, String str) {
        super(runnable, str);
        setPriority(10);
        setDaemon(false);
    }
}
