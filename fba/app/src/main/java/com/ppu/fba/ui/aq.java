package com.ppu.fba.ui;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.widget.CompoundButton;
import com.ppu.fba.FirewallApplication;
import com.ppu.fba.widget.C0362a;
import com.ppu.fba.widget.WidgetOnOffProvider;

class aq extends AsyncTask {
    final /* synthetic */ ap f1614a;
    final /* synthetic */ CompoundButton f1615b;
    final /* synthetic */ boolean f1616c;

    aq(ap apVar, boolean z, CompoundButton compoundButton) {
        this.f1614a = apVar;
        this.f1616c = z;
        this.f1615b = compoundButton;
    }

    public Object doInBackground(Object... objArr) {
        return null;
    }

    public void onPostExecute(Object obj) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a()).edit();
        edit.putBoolean("status_on", this.f1616c);
        edit.commit();
        this.f1615b.setEnabled(true);
        Intent intent = new Intent(this.f1614a.f1613b, WidgetOnOffProvider.class);
        intent.setAction("com.ppu.fba.widget.WidgetOnOffProvider.REFRESH");
        this.f1614a.f1613b.sendBroadcast(intent);
        intent = new Intent(this.f1614a.f1613b, C0362a.class);
        intent.setAction("com.ppu.fba.widget.WidgetGraphBlockedProvider.REFRESH");
        this.f1614a.f1613b.sendBroadcast(intent);
    }
}
