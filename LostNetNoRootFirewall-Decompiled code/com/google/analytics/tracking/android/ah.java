package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class ah {
    static String m1116a(ag agVar, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(agVar.m1110a());
        if (agVar.m1114c() > 0) {
            long c = j - agVar.m1114c();
            if (c >= 0) {
                stringBuilder.append("&qt").append("=").append(c);
            }
        }
        stringBuilder.append("&z").append("=").append(agVar.m1112b());
        return stringBuilder.toString();
    }

    static String m1117a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + str);
        }
    }

    static Map m1118a(Map map) {
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (((String) entry.getKey()).startsWith("&") && entry.getValue() != null) {
                CharSequence substring = ((String) entry.getKey()).substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    hashMap.put(substring, entry.getValue());
                }
            }
        }
        return hashMap;
    }
}
