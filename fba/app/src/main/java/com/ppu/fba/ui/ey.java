package com.ppu.fba.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.ppu.fba.free.R;
import com.ppu.fba.NativeWrapper;

class ey implements OnClickListener {
    final /* synthetic */ ToolSnifferActivity f1841a;

    ey(ToolSnifferActivity toolSnifferActivity) {
        this.f1841a = toolSnifferActivity;
    }

    public void onClick(View view) {
        this.f1841a.f1543l = 0;
        this.f1841a.f1544m = 0;
        this.f1841a.f1536e.setText(String.valueOf(this.f1841a.f1543l));
        this.f1841a.f1537f.setText(String.valueOf(this.f1841a.f1544m));
        this.f1841a.f1538g.setEnabled(false);
        this.f1841a.f1539h.setEnabled(false);
        this.f1841a.f1540i.setEnabled(false);
        this.f1841a.f1533b.setEnabled(false);
        this.f1841a.f1532a.setText(R.string.cloudshark_capture_stop);
        this.f1841a.f1532a.setOnClickListener(this.f1841a.f1549r);
        this.f1841a.f1542k = true;
        NativeWrapper.jni_dicks(this.f1841a.f1541j);
    }
}
