package com.google.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

class bi {
    @VisibleForTesting
    static Map f997a = new HashMap();
    private static String f998b;

    bi() {
    }

    static String m1414a(Context context, String str, String str2) {
        String str3 = (String) f997a.get(str);
        if (str3 == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str3 = sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
            f997a.put(str, str3);
        }
        return m1415a(str3, str2);
    }

    static String m1415a(String str, String str2) {
        return str2 == null ? str.length() > 0 ? str : null : Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
    }

    static void m1416a(Context context, String str) {
        ed.m1643a(context, "gtm_install_referrer", "referrer", str);
        m1419c(context, str);
    }

    static void m1417a(String str) {
        synchronized (bi.class) {
            f998b = str;
        }
    }

    static String m1418b(Context context, String str) {
        if (f998b == null) {
            synchronized (bi.class) {
                if (f998b == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        f998b = sharedPreferences.getString("referrer", "");
                    } else {
                        f998b = "";
                    }
                }
            }
        }
        return m1415a(f998b, str);
    }

    static void m1419c(Context context, String str) {
        String a = m1415a(str, "conv");
        if (a != null && a.length() > 0) {
            f997a.put(a, str);
            ed.m1643a(context, "gtm_click_referrers", a, str);
        }
    }
}
