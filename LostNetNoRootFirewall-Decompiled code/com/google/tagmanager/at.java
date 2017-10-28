package com.google.tagmanager;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.io.File;

class at {
    public static int m1370a() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            bs.m1438a("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }

    @TargetApi(9)
    static boolean m1371a(String str) {
        if (m1370a() < 9) {
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
