package com.lostnet.fw.p009d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.lostnet.fw.FirewallApplication;

public class C0310g {
    private static boolean f1414a = false;
    private static boolean f1415b = false;

    public static boolean m1986a() {
        return FirewallApplication.m1851a().getSharedPreferences("experience", 0).getBoolean("hadRadeClicked", false);
    }

    public static boolean m1987a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("experience", 0);
        if (sharedPreferences.getBoolean("warned", false)) {
            return true;
        }
        Editor edit = sharedPreferences.edit();
        edit.putBoolean("warned", true);
        edit.commit();
        return false;
    }

    public static void m1988b() {
        Editor edit = FirewallApplication.m1851a().getSharedPreferences("experience", 0).edit();
        edit.putBoolean("hadRateClicked", true);
        edit.commit();
    }

    public static void m1989b(Context context) {
        Editor edit = context.getSharedPreferences("experience", 0).edit();
        edit.putBoolean("notified", true);
        edit.commit();
    }

    public static boolean m1990c() {
        return !FirewallApplication.m1851a().getSharedPreferences("experience", 0).getBoolean("hadFirstRun", false);
    }

    public static boolean m1991c(Context context) {
        if (!f1414a) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("experience", 0);
        return sharedPreferences.getBoolean("status_on", false) && sharedPreferences.getBoolean("notified", false);
    }

    public static void m1992d() {
        Editor edit = FirewallApplication.m1851a().getSharedPreferences("experience", 0).edit();
        edit.putBoolean("hadFirstRun", true);
        edit.commit();
    }

    public static boolean m1993e() {
        if (f1414a) {
            return false;
        }
        f1414a = true;
        return !FirewallApplication.m1851a().getSharedPreferences("experience", 0).getBoolean("dontWarnClickApps", false);
    }

    public static void m1994f() {
        Editor edit = FirewallApplication.m1851a().getSharedPreferences("experience", 0).edit();
        edit.putBoolean("dontWarnClickApps", true);
        edit.commit();
    }

    public static boolean m1995g() {
        if (f1415b) {
            return false;
        }
        f1415b = true;
        return !FirewallApplication.m1851a().getSharedPreferences("experience", 0).getBoolean("dontWarnClickCnts", false);
    }

    public static void m1996h() {
        Editor edit = FirewallApplication.m1851a().getSharedPreferences("experience", 0).edit();
        edit.putBoolean("dontWarnClickCnts", true);
        edit.commit();
    }
}
