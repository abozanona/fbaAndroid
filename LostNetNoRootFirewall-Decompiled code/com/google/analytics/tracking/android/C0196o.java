package com.google.analytics.tracking.android;

import android.os.Build.VERSION;
import java.io.File;

class C0196o {
    public static int m1206a() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            Log.m1076e("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }

    static boolean m1207a(String str) {
        if (C0196o.m1206a() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }
}
