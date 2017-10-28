package com.ppu.fba.ui;

import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.widget.Switch;
import com.ppu.fba.FirewallApplication;
import com.ppu.fba.p009d.C0315l;

class ew extends AsyncTask {
    final /* synthetic */ Switch f1838a;
    final /* synthetic */ StatusChangeReceiver f1839b;

    ew(StatusChangeReceiver statusChangeReceiver, Switch switchR) {
        this.f1839b = statusChangeReceiver;
        this.f1838a = switchR;
    }

    protected Boolean m2140a(Object... objArr) {
        try {
            Thread.sleep(200);
            return Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a()).getBoolean("status_on", false));
        } catch (InterruptedException e) {
            return null;
        }
    }

    protected void m2141a(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.f1838a.setChecked(true);
            } else {
                this.f1838a.setChecked(false);
            }
            C0315l.m2018a("StatusChangeReceiver", "onReceieve: done");
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m2140a(objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m2141a((Boolean) obj);
    }
}
