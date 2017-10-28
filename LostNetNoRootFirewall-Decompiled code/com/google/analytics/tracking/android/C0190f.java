package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.VisibleForTesting;

class C0190f implements C0186k {
    private static C0190f f841e;
    private static Object f842f = new Object();
    protected String f843a;
    protected String f844b;
    protected String f845c;
    protected String f846d;

    @VisibleForTesting
    protected C0190f() {
    }

    private C0190f(Context context) {
        PackageManager packageManager = context.getPackageManager();
        this.f845c = context.getPackageName();
        this.f846d = packageManager.getInstallerPackageName(this.f845c);
        String str = this.f845c;
        String str2 = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                str = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                str2 = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            Log.m1076e("Error retrieving package info: appName set to " + str);
        }
        this.f843a = str;
        this.f844b = str2;
    }

    @VisibleForTesting
    static void m1186a() {
        synchronized (f842f) {
            f841e = null;
        }
    }

    public static void m1187a(Context context) {
        synchronized (f842f) {
            if (f841e == null) {
                f841e = new C0190f(context);
            }
        }
    }

    public static C0190f m1188b() {
        return f841e;
    }

    public boolean m1189a(String str) {
        return Fields.APP_NAME.equals(str) || Fields.APP_VERSION.equals(str) || Fields.APP_ID.equals(str) || Fields.APP_INSTALLER_ID.equals(str);
    }

    public String mo562b(String str) {
        return str == null ? null : str.equals(Fields.APP_NAME) ? this.f843a : str.equals(Fields.APP_VERSION) ? this.f844b : str.equals(Fields.APP_ID) ? this.f845c : str.equals(Fields.APP_INSTALLER_ID) ? this.f846d : null;
    }
}
