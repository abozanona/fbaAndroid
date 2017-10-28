package com.google.tagmanager;

import android.content.SharedPreferences.Editor;

final class ee implements Runnable {
    final /* synthetic */ Editor f1143a;

    ee(Editor editor) {
        this.f1143a = editor;
    }

    public void run() {
        this.f1143a.commit();
    }
}
