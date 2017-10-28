package com.google.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;

class CacheFactory {
    @VisibleForTesting
    final CacheSizeManager f929a = new C0231l(this);

    public interface CacheSizeManager {
        int sizeOf(Object obj, Object obj2);
    }

    @VisibleForTesting
    int m1275a() {
        return VERSION.SDK_INT;
    }

    public C0218k m1276a(int i, CacheSizeManager cacheSizeManager) {
        if (i > 0) {
            return m1275a() < 12 ? new ef(i, cacheSizeManager) : new bn(i, cacheSizeManager);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }
}
