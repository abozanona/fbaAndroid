package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;

class aj implements ai {
    private final Context f817a;
    private String f818b;

    public aj(Context context) {
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        this.f817a = context.getApplicationContext();
    }

    private int m1124a(String str, String str2) {
        if (this.f817a == null) {
            return 0;
        }
        return this.f817a.getResources().getIdentifier(str, str2, this.f818b != null ? this.f818b : this.f817a.getPackageName());
    }

    public int mo552a(String str, int i) {
        int a = m1124a(str, "integer");
        if (a != 0) {
            try {
                i = Integer.parseInt(this.f817a.getString(a));
            } catch (NumberFormatException e) {
                Log.m1079w("NumberFormatException parsing " + this.f817a.getString(a));
            }
        }
        return i;
    }

    public String mo553a(String str) {
        int a = m1124a(str, "string");
        return a == 0 ? null : this.f817a.getString(a);
    }

    public Double mo554b(String str) {
        Double d = null;
        String a = mo553a(str);
        if (!TextUtils.isEmpty(a)) {
            try {
                d = Double.valueOf(Double.parseDouble(a));
            } catch (NumberFormatException e) {
                Log.m1079w("NumberFormatException parsing " + a);
            }
        }
        return d;
    }

    public boolean mo555c(String str) {
        int a = m1124a(str, "bool");
        return a == 0 ? false : "true".equalsIgnoreCase(this.f817a.getString(a));
    }

    public void mo556d(String str) {
        this.f818b = str;
    }
}
