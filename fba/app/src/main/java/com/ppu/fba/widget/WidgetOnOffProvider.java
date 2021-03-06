package com.ppu.fba.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.RemoteViews;

import com.ppu.fba.C0288a;
import com.ppu.fba.FirewallApplication;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.Log1;

public class WidgetOnOffProvider extends AppWidgetProvider {
    public void onReceive(Context context, Intent intent) {
        Context a;
        int[] appWidgetIds;
        Intent intent2;
        if (intent.getAction().equals("com.ppu.fba.widget.WidgetOnOffProvider.REFRESH")) {
            Log1.LogF1("WidgetOnOffProvider", "REFRESH");
            a = FirewallApplication.m1851a();
            appWidgetIds = AppWidgetManager.getInstance(a).getAppWidgetIds(new ComponentName(a, WidgetOnOffProvider.class));
            intent2 = new Intent(a, WidgetOnOffProvider.class);
            intent2.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            intent2.putExtra("appWidgetIds", appWidgetIds);
            Log1.LogF1("WidgetOnOffProvider", "REFRESH: end");
            super.onReceive(context, intent2);
        } else if (intent.getAction().equals("com.ppu.fba.widget.WidgetOnOffProvider.ACTION_ON")) {
            Log1.LogF1("WidgetOnOffProvider", "ACTION_ON");
            a = FirewallApplication.m1851a();
            appWidgetIds = intent.getIntArrayExtra("appWidgetIds");
            //todo abozanona
            SharedPreferences.Editor r2;
            r2 = PreferenceManager.getDefaultSharedPreferences(a).edit();
            r2.putBoolean("status_on", true);
            r2.commit();
            Log1.LogAction("widget", "onoff", "on", null);
            FirewallManagerService r22;
            r22 = FirewallManagerService.m1852a(a);
            if (r22 != null) {
                r22.m1863a(new C0288a(1));
            }
            intent2 = new Intent(a, WidgetOnOffProvider.class);
            intent2.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            intent2.putExtra("appWidgetIds", appWidgetIds);
            Log1.LogF1("WidgetOnOffProvider", "ACTION_ON: end");
            super.onReceive(context, intent2);
        } else if (intent.getAction().equals("com.ppu.fba.widget.WidgetOnOffProvider.ACTION_OFF")) {
            Log1.LogF1("WidgetOnOffProvider", "ACTION_OFF");
            a = FirewallApplication.m1851a();
            appWidgetIds = intent.getIntArrayExtra("appWidgetIds");
            //todo abozanona
            SharedPreferences.Editor r2;
            r2 = PreferenceManager.getDefaultSharedPreferences(a).edit();
            r2.putBoolean("status_on", false);
            r2.commit();
            Log1.LogAction("widget", "onoff", "off", null);
            FirewallManagerService r22;
            r22 = FirewallManagerService.m1852a(a);
            if (r22 != null) {
                r22.m1863a(new C0288a(2));
            }
            intent2 = new Intent(a, WidgetOnOffProvider.class);
            intent2.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            intent2.putExtra("appWidgetIds", appWidgetIds);
            Log1.LogF1("WidgetOnOffProvider", "ACTION_OFF: end");
            super.onReceive(context, intent2);
        } else {
            Log1.LogF1("WidgetOnOffProvider", "update");
            super.onReceive(context, intent);
        }
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        Context a = FirewallApplication.m1851a();
        boolean z = PreferenceManager.getDefaultSharedPreferences(a).getBoolean("status_on", true);
        FirewallManagerService.m1852a(a);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, WidgetOnOffProvider.class));
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_onoff_layout);
        Intent intent = new Intent(a, WidgetOnOffProvider.class);
        intent.putExtra("appWidgetIds", appWidgetIds);
        if (z) {
            remoteViews.setImageViewResource(R.id.imageIcon, R.drawable.widget_on);
            intent.setAction("com.ppu.fba.widget.WidgetOnOffProvider.ACTION_OFF");
        } else {
            remoteViews.setImageViewResource(R.id.imageIcon, R.drawable.widget_off);
            intent.setAction("com.ppu.fba.widget.WidgetOnOffProvider.ACTION_ON");
        }
        remoteViews.setOnClickPendingIntent(R.id.imageIcon, PendingIntent.getBroadcast(a, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT));
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }
}
