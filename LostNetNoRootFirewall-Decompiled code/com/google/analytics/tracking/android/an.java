package com.google.analytics.tracking.android;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.common.util.VisibleForTesting;

class an implements C0186k {
    private static an f831a;
    private static Object f832b = new Object();
    private final Context f833c;

    @VisibleForTesting
    protected an(Context context) {
        this.f833c = context;
    }

    public static an m1158a() {
        an anVar;
        synchronized (f832b) {
            anVar = f831a;
        }
        return anVar;
    }

    public static void m1159a(Context context) {
        synchronized (f832b) {
            if (f831a == null) {
                f831a = new an(context);
            }
        }
    }

    @VisibleForTesting
    static void m1160b() {
        synchronized (f832b) {
            f831a = null;
        }
    }

    public boolean m1161a(String str) {
        return Fields.SCREEN_RESOLUTION.equals(str);
    }

    public String mo562b(String str) {
        return (str != null && str.equals(Fields.SCREEN_RESOLUTION)) ? m1163c() : null;
    }

    protected String m1163c() {
        DisplayMetrics displayMetrics = this.f833c.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }
}
