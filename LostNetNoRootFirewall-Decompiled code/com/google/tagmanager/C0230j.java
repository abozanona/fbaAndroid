package com.google.tagmanager;

import android.os.Build.VERSION;
import android.util.Base64;
import com.google.android.gms.common.util.VisibleForTesting;

class C0230j {
    @VisibleForTesting
    static int m1714a() {
        return VERSION.SDK_INT;
    }

    public static String m1715a(byte[] bArr, int i) {
        Object obj = 1;
        if (C0230j.m1714a() >= 8) {
            int i2 = 2;
            if ((i & 1) != 0) {
                i2 = 3;
            }
            if ((i & 2) != 0) {
                i2 |= 8;
            }
            return Base64.encodeToString(bArr, i2);
        }
        boolean z = (i & 1) == 0;
        if ((i & 2) == 0) {
            obj = null;
        }
        return obj != null ? Base64.m1272b(bArr, z) : Base64.m1266a(bArr, z);
    }

    public static byte[] m1716a(String str, int i) {
        if (C0230j.m1714a() >= 8) {
            int i2 = 2;
            if ((i & 1) != 0) {
                i2 = 3;
            }
            if ((i & 2) != 0) {
                i2 |= 8;
            }
            return Base64.decode(str, i2);
        }
        if ((i & 1) == 0) {
        }
        return ((i & 2) != 0 ? 1 : null) != null ? Base64.m1273b(str) : Base64.m1267a(str);
    }
}
