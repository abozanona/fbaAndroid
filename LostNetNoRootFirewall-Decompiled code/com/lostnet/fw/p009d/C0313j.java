package com.lostnet.fw.p009d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.lostnet.fw.FirewallApplication;
import com.lostnet.fw.p008c.C0296a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class C0313j {
    public static void m2002a(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(listView.getWidth(), Integer.MIN_VALUE);
            int i = 0;
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                View view = adapter.getView(i2, null, listView);
                view.measure(makeMeasureSpec, 0);
                i += view.getMeasuredHeight();
            }
            LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = ((((listView.getDividerHeight() * (adapter.getCount() - 1)) + i) + ((listView.getListPaddingBottom() + listView.getListPaddingTop()) * adapter.getCount())) + listView.getPaddingBottom()) + listView.getPaddingTop();
            listView.setLayoutParams(layoutParams);
            listView.requestLayout();
        }
    }

    public static boolean m2003a() {
        Context a = FirewallApplication.m1851a();
        String packageName = a.getPackageName();
        try {
            SharedPreferences sharedPreferences = a.getSharedPreferences("updater", 0);
            long j = sharedPreferences.getLong("lastChecked", 0);
            int i = sharedPreferences.getInt("lastVersion", 0);
            long c = C0296a.m1930c();
            if (j == 0 || j - c > 43200000) {
                String str = "http://s3.amazonaws.com/lostnet/" + packageName + ".txt";
                C0315l.m2018a("isUpToDate", str);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(str).openStream()));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                Integer valueOf = Integer.valueOf(readLine);
                i = valueOf != null ? valueOf.intValue() : 0;
                C0315l.m2018a("isUpToDate", "Last version: " + i);
                Editor edit = sharedPreferences.edit();
                edit.putLong("lastChecked", c);
                edit.putInt("lastVersion", i);
                edit.apply();
            }
            int i2 = a.getPackageManager().getPackageInfo(packageName, 0).versionCode;
            C0315l.m2018a("isUpToDate", "Current version: " + i2);
            return i != 0 && i <= i2;
        } catch (Exception e) {
            C0315l.m2018a("isUpToDate", e.getClass().getCanonicalName());
            String message = e.getMessage();
            if (message == null) {
                return true;
            }
            C0315l.m2018a("isUpToDate", message);
            return true;
        }
    }

    public static boolean m2004a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager.checkSignatures(context.getPackageName(), "com.lostnet.fw.pro") == 0 || packageManager.checkSignatures(context.getPackageName(), "com.lostnet.fw.test") == 0;
    }

    public static boolean m2005a(String str) {
        try {
            return FirewallApplication.m1851a().getPackageManager().getPackageInfo(str, 1) != null;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
