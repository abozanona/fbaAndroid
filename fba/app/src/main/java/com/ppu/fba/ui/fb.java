package com.ppu.fba.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class fb implements OnItemSelectedListener {
    final /* synthetic */ ToolSnifferActivity f1847a;

    fb(ToolSnifferActivity toolSnifferActivity) {
        this.f1847a = toolSnifferActivity;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        this.f1847a.f1539h.setChecked(true);
        this.f1847a.f1538g.setChecked(false);
        if (view != null) {
            Integer num = (Integer) view.getTag();
            if (num != null) {
                this.f1847a.f1541j = num.intValue();
            }
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
        this.f1847a.f1538g.setChecked(true);
        this.f1847a.f1539h.setChecked(false);
        this.f1847a.f1541j = -1;
    }
}
