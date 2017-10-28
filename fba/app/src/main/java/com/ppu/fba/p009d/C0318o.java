package com.ppu.fba.p009d;

import android.app.Activity;
import com.google.analytics.tracking.android.EasyTracker;
import com.ppu.fba.FirewallApplication;
import java.util.Map;

public class C0318o {
    private static boolean f1423a = false;
    private static EasyTracker f1424b = null;

    public static void m2029a() {
        f1423a = true;
    }

    public static void m2030a(Activity activity) {
        if (!f1423a) {
            if (f1424b == null) {
                f1424b = EasyTracker.getInstance(FirewallApplication.m1851a());
            }
            f1424b.activityStart(activity);
        }
    }

    public static void m2031a(Map map) {
        if (!f1423a) {
            if (f1424b == null) {
                f1424b = EasyTracker.getInstance(FirewallApplication.m1851a());
            }
            f1424b.send(map);
        }
    }

    public static void m2032b(Activity activity) {
        if (!f1423a) {
            if (f1424b == null) {
                f1424b = EasyTracker.getInstance(FirewallApplication.m1851a());
            }
            f1424b.activityStop(activity);
        }
    }
}
