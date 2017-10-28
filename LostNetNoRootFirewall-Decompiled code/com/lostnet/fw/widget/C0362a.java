package com.lostnet.fw.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.lostnet.fw.C0328k;
import com.lostnet.fw.C0329l;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.FirewallApplication;
import com.lostnet.fw.FirewallManagerService;
import com.lostnet.fw.p008c.C0296a;
import com.lostnet.fw.p008c.C0298c;
import com.lostnet.fw.p008c.C0299d;
import com.lostnet.fw.p009d.C0315l;
import com.lostnet.fw.p010e.C0320a;
import java.util.ArrayList;

public class C0362a extends AppWidgetProvider {
    private static C0320a f1912a;

    private static synchronized Bitmap m2154a() {
        Bitmap b;
        synchronized (C0362a.class) {
            if (f1912a == null) {
                f1912a = new C0320a(12);
            }
            FirewallManagerService a = FirewallManagerService.m1852a(FirewallApplication.m1851a());
            if (a != null) {
                ArrayList arrayList = new ArrayList();
                C0299d c0299d = a.f1297f;
                if (c0299d != null) {
                    synchronized (c0299d) {
                        long b2 = C0296a.m1929b();
                        for (long j = b2; j > b2 - 12; j--) {
                            C0298c b3 = c0299d.m1954b(j);
                            if (b3 != null) {
                                arrayList.add(Integer.valueOf(b3.f1380c));
                            } else {
                                arrayList.add(Integer.valueOf(17));
                            }
                        }
                    }
                    f1912a.m2035a(arrayList);
                }
            }
            b = f1912a.m2036b(146, 72);
        }
        return b;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.lostnet.fw.widget.WidgetGraphBlockedProvider.REFRESH")) {
            C0315l.m2018a("WidgetGraphBlockedProvider", "REFRESH");
            Context a = FirewallApplication.m1851a();
            int[] appWidgetIds = AppWidgetManager.getInstance(a).getAppWidgetIds(new ComponentName(a, WidgetOnOffProvider.class));
            Intent intent2 = new Intent(a, WidgetOnOffProvider.class);
            intent2.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            intent2.putExtra("appWidgetIds", appWidgetIds);
            C0315l.m2018a("WidgetGraphBlockedProvider", "REFRESH: end");
            super.onReceive(context, intent2);
            return;
        }
        C0315l.m2018a("WidgetGraphBlockedProvider", "update");
        super.onReceive(context, intent);
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        C0315l.m2018a("WidgetGraphBlockedProvider", "onUpdate");
        Resources resources = FirewallApplication.m1851a().getResources();
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, C0362a.class));
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C0329l.widget_graph_blocked_layout);
        remoteViews.setImageViewBitmap(C0328k.imageGraph, C0362a.m2154a());
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setComponent(new ComponentName(resources.getString(C0330m.package_name), "com.lostnet.fw.ui.SplashScreen"));
        intent.setFlags(268435456);
        intent.putExtra("lf", "wgb");
        remoteViews.setOnClickPendingIntent(C0328k.imageGraph, PendingIntent.getActivity(context, 0, intent, 0));
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }
}
