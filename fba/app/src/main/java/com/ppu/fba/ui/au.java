package com.ppu.fba.ui;

import android.os.AsyncTask;
import android.widget.Button;
import com.ppu.fba.p009d.C0313j;

class au extends AsyncTask {
    final /* synthetic */ ao f1620a;
    final /* synthetic */ Button f1621b;

    au(ao aoVar, Button button) {
        this.f1620a = aoVar;
        this.f1621b = button;
    }

    protected Boolean m2084a(Object... objArr) {
        return Boolean.valueOf(C0313j.m2003a());
    }

    protected void m2085a(Boolean bool) {
        if (!bool.booleanValue()) {
            this.f1621b.setVisibility(0);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m2084a(objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m2085a((Boolean) obj);
    }
}
