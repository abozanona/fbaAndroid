package com.ppu.fba;

import android.app.Application;
import android.content.Context;
import com.ppu.fba.p009d.C0309f;

public class FirewallApplication extends Application {
    private static FirewallApplication f1289a;

    public FirewallApplication() {
        f1289a = this;
    }

    public static Context m1851a() {
        return f1289a;
    }

    public void onCreate() {
        super.onCreate();
        C0309f.m1977a((Context) this);
    }
}
