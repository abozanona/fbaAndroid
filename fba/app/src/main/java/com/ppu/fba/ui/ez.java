package com.ppu.fba.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.ppu.fba.free.R;
import com.ppu.fba.NativeWrapper;

class ez implements OnClickListener {
    final /* synthetic */ ToolSnifferActivity f1842a;

    ez(ToolSnifferActivity toolSnifferActivity) {
        this.f1842a = toolSnifferActivity;
    }

    public void onClick(View view) {
        NativeWrapper.jni_dickt();
        if (this.f1842a.f1543l > 0) {
            this.f1842a.f1536e.setText(String.valueOf(this.f1842a.f1543l));
            this.f1842a.f1537f.setText(String.valueOf(this.f1842a.f1544m));
            this.f1842a.f1533b.setEnabled(true);
        }
        this.f1842a.f1532a.setText(R.string.cloudshark_capture_start);
        this.f1842a.f1532a.setOnClickListener(this.f1842a.f1548q);
        this.f1842a.f1538g.setEnabled(true);
        this.f1842a.f1539h.setEnabled(true);
        this.f1842a.f1540i.setEnabled(true);
        this.f1842a.f1542k = false;
    }
}
