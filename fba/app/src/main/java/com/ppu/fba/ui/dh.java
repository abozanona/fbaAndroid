package com.ppu.fba.ui;

import android.support.v4.view.PagerAdapter;
import android.view.View;

public class dh extends PagerAdapter {
    final /* synthetic */ LogsActivity f1769a;

    dh(LogsActivity logsActivity) {
        this.f1769a = logsActivity;
    }

    public Object mo754a(View view, int i) {
        try {
            return this.f1769a.findViewById(((Integer) this.f1769a.f1481a.get(i)).intValue());
        } catch (Exception e) {
            return null;
        }
    }

    public void mo755a(View view, int i, Object obj) {
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == ((View) obj);
    }

    public int getCount() {
        return this.f1769a.f1481a.size();
    }
}
