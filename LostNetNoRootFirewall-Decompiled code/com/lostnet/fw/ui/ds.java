package com.lostnet.fw.ui;

import android.os.AsyncTask;
import com.lostnet.fw.p009d.C0313j;

class ds extends AsyncTask {
    final /* synthetic */ ao f1781a;

    ds(ao aoVar) {
        this.f1781a = aoVar;
    }

    protected Object doInBackground(Object... objArr) {
        return null;
    }

    protected void onPostExecute(Object obj) {
        C0313j.m2002a(this.f1781a.R);
        this.f1781a.f1603Q.recomputeViewAttributes(this.f1781a.R);
        this.f1781a.f1603Q.requestLayout();
        this.f1781a.f1603Q.smoothScrollTo(0, 0);
    }
}
