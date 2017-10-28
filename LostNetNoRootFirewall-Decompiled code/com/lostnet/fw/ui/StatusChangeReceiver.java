package com.lostnet.fw.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Switch;
import com.lostnet.fw.FirewallApplication;
import com.lostnet.fw.p009d.C0315l;
import com.lostnet.fw.widget.C0362a;
import com.lostnet.fw.widget.WidgetOnOffProvider;

public class StatusChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.lostnet.fw.ui.StatusChangeReceiver.CHANGE")) {
            Context a = FirewallApplication.m1851a();
            C0315l.m2018a("StatusChangeReceiver", "onReceieve");
            Intent intent2 = new Intent(a, WidgetOnOffProvider.class);
            intent2.setAction("com.lostnet.fw.widget.WidgetOnOffProvider.REFRESH");
            a.sendBroadcast(intent2);
            intent2 = new Intent(a, C0362a.class);
            intent2.setAction("com.lostnet.fw.widget.WidgetGraphBlockedProvider.REFRESH");
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
