package com.ppu.fba.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.ppu.fba.p009d.C0310g;
import java.util.ArrayList;

public class C0336b implements OnClickListener {
    final /* synthetic */ DashboardActivity f1639a;
    final /* synthetic */ ArrayList f1640b;

    C0336b(DashboardActivity dashboardActivity, ArrayList arrayList) {
        this.f1639a = dashboardActivity;
        this.f1640b = arrayList;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f1640b.size() > 0) {
            C0310g.m1994f();
        }
    }
}
