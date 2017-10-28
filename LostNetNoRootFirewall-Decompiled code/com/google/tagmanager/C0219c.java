package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Map;

class C0219c implements ae {
    private final Context f1021a;

    public C0219c(Context context) {
        this.f1021a = context;
    }

    public void mo631a(Map map) {
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null) {
            obj = map.get("gtm");
            if (obj != null && (obj instanceof Map)) {
                obj = ((Map) obj).get("url");
                if (obj != null && (obj instanceof String)) {
                    String queryParameter = Uri.parse((String) obj).getQueryParameter("referrer");
                    if (queryParameter != null) {
                        bi.m1419c(this.f1021a, queryParameter);
                        return;
                    }
                    return;
                }
            }
        }
        obj = obj2;
        if (obj != null) {
        }
    }
}
