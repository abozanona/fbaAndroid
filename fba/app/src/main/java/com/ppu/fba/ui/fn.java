package com.ppu.fba.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.android.vending.licensing.APKExpansionPolicy;

class fn extends BaseAdapter {
    final /* synthetic */ ToolsActivity f1861a;

    public fn(ToolsActivity toolsActivity) {
        this.f1861a = toolsActivity;
    }

    public int getCount() {
        return 1;
    }

    public Object getItem(int i) {
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                return this.f1861a.f1551a;
            default:
                return null;
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view != null) {
            return view;
        }
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                return this.f1861a.f1551a;
            default:
                return null;
        }
    }
}
