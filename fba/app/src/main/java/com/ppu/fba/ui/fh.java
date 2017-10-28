package com.ppu.fba.ui;

import android.os.AsyncTask;
import com.ppu.fba.NativeWrapper;

class fh extends AsyncTask {
    final /* synthetic */ ToolSnifferActivity f1854a;

    fh(ToolSnifferActivity toolSnifferActivity) {
        this.f1854a = toolSnifferActivity;
    }

    protected Boolean m2143a(Object... objArr) {
        this.f1854a.f1543l = NativeWrapper.jni_dicku();
        this.f1854a.f1544m = NativeWrapper.jni_dickv();
        return (this.f1854a.f1545n <= 0 || this.f1854a.f1545n > this.f1854a.f1543l) ? Boolean.TRUE : Boolean.FALSE;
    }

    protected void m2144a(Boolean bool) {
        super.onPostExecute(bool);
        if (!bool.booleanValue()) {
            this.f1854a.f1549r.onClick(null);
        }
        this.f1854a.f1536e.setText(String.valueOf(this.f1854a.f1543l));
        this.f1854a.f1537f.setText(String.valueOf(this.f1854a.f1544m));
        if (!this.f1854a.f1546o) {
            this.f1854a.f1547p.postDelayed(this.f1854a.f1550s, 500);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m2143a(objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m2144a((Boolean) obj);
    }
}
