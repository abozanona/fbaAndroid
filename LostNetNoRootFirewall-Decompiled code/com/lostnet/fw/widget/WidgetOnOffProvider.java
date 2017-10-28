package com.lostnet.fw.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.widget.RemoteViews;
import com.google.analytics.tracking.android.MapBuilder;
import com.lostnet.fw.C0288a;
import com.lostnet.fw.C0327j;
import com.lostnet.fw.C0328k;
import com.lostnet.fw.C0329l;
import com.lostnet.fw.FirewallApplication;
import com.lostnet.fw.FirewallManagerService;
import com.lostnet.fw.p009d.C0315l;
import com.lostnet.fw.p009d.C0318o;

public class WidgetOnOffProvider extends AppWidgetProvider {
    public void onReceive(Context context, Intent intent) {
        Context a;
        int[] appWidgetIds;
        Intent intent2;
        if (intent.getAction().equals("com.lostnet.fw.widget.WidgetOnOffProvider.REFRESH")) {
            C0315l.m2018a("WidgetOnOffProvider", "REFRESH");
            a = FirewallApplication.m1851a();
            appWidgetIds = AppWidgetManager.getInstance(a).getAppWidgetIds(new ComponentName(a, WidgetOnOffProvider.class));
            intent2 = new Intent(a, WidgetOnOffProvider.class);
            intent2.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            intent2.putExtra("appWidgetIds", appWidgetIds);
            C0315l.m2018a("WidgetOnOffProvider", "REFRESH: end");
            super.onReceive(context, intent2);
        } else if (intent.getAction().equals("com.lostnet.fw.widget.WidgetOnOffProvider.ACTION_ON")) {
            C0315l.m2018a("WidgetOnOffProvider", "ACTION_ON");
            a = FirewallApplication.m1851a();
            appWidgetIds = intent.getIntArrayExtra("appWidgetIds");
            r2 = PreferenceManager.getDefaultSharedPreferences(a).edit();
            r2.putBoolean("status_on", true);
            r2.commit();
            C0318o.m2031a(MapBuilder.createEvent("widget", "onoff", "on", null).build());
            r2 = FirewallManagerService.m1852a(a);
            if (r2 != null) {
                r2.m1863a(new C0288a(1));
            }
            intent2 = new Intent(a, WidgetOnOffProvider.class);
            intent2.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            intent2.putExtra("appWidgetIds", appWidgetIds);
            C0315l.m2018a("WidgetOnOffProvider", "ACTION_ON: end");
            super.onReceive(context, intent2);
        } else if (intent.getAction().equals("com.lostnet.fw.widget.WidgetOnOffProvider.ACTION_OFF")) {
            C0315l.m2018a("WidgetOnOffProvider", "ACTION_OFF");
            a = FirewallApplication.m1851a();
            appWidgetIds = intent.getIntArrayExtra("appWidgetIds");
            r2 = PreferenceManager.getDefaultSharedPreferences(a).edit();
            r2.putBoolean("status_on", false);
            r2.commit();
            C0318o.m2031a(MapBuilder.createEvent("widget", "onoff", "off", null).build());
            r2 = FirewallManagerService.m1852a(a);
            if (r2 != null) {
                r2.m1863a(new C0288a(2));
            }
            intent2 = new Intent(a, WidgetOnOffProvider.class);
            intent2.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            intent2.putExtra("appWidgetIds", appWidgetIds);
            C0315l.m2018a("WidgetOnOffProvider", "ACTION_OFF: end");
            super.onReceive(context, intent2);
        } else {
            C0315l.m2018a("WidgetOnOffProvider", "update");
            super.onReceive(context, intent);
        }
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        Context a = FirewallApplication.m1851a();
        boolean z = PreferenceManager.getDefaultSharedPreferences(a).getBoolean("status_on", true);
        FirewallManagerService.m1852a(a);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, WidgetOnOffProvider.class));
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C0329l.widget_onoff_layout);
        Intent intent = new Intent(a, WidgetOnOffProvider.class);
        intent.putExtra("appWidgetIds", appWidgetIds);
        if (z) {
            remoteViews.setImageViewResource(C0328k.imageIcon, C0327j.widget_on);
            intent.setAction("com.lostnet.fw.widget.WidgetOnOffProvider.ACTION_OFF");
        } else {
            remoteViews.setImageViewResource(C0328k.imageIcon, C0327j.widget_off);
            intent.setAction("com.lostnet.fw.widget.WidgetOnOffProvider.ACTION_ON");
        }
        remoteViews.setOnClickPendingIntent(C0328k.imageIcon, PendingIntent.getBroadcast(a, 0, intent, 134217728));
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }
}
