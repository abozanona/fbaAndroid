package com.ppu.fba.ui;

import android.os.AsyncTask;

class ex implements Runnable {
    final /* synthetic */ ToolSnifferActivity f1840a;

    ex(ToolSnifferActivity toolSnifferActivity) {
        this.f1840a = toolSnifferActivity;
    }

    public void run() {
        new fh(this.f1840a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }
}
