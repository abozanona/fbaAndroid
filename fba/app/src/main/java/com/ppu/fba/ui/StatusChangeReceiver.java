package com.ppu.fba.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Switch;
import com.ppu.fba.FirewallApplication;
import com.ppu.fba.p009d.C0315l;
import com.ppu.fba.widget.C0362a;
import com.ppu.fba.widget.WidgetOnOffProvider;

public class StatusChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.ppu.fba.ui.StatusChangeReceiver.CHANGE")) {
            Context a = FirewallApplication.m1851a();
            C0315l.m2018a("StatusChangeReceiver", "onReceieve");
            Intent intent2 = new Intent(a, WidgetOnOffProvider.class);
            intent2.setAction("com.ppu.fba.widget.WidgetOnOffProvider.REFRESH");
            a.sendBroadcast(intent2);
            intent2 = new Intent(a, C0362a.class);
            intent2.setAction("com.ppu.fba.widget.WidgetGraphBlockedProvider.REFRESH");
            a.sendBroadcast(intent2);
            Switch switchR = ao.f1602P;
            if (switchR != null) {
                C0315l.m2018a("StatusChangeReceiver", "onReceieve: mid");
                new ew(this, switchR).execute(new Object[]{new Object()});
                C0315l.m2018a("StatusChangeReceiver", "onReceieve: end");
            }
        }
    }
}
