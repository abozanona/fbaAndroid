package com.ppu.fba.ui;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.Log1;

public class at implements OnClickListener {
    final /* synthetic */ ao f1619a;

    at(ao aoVar) {
        this.f1619a = aoVar;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Log.e("abozanona", "abozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\n");
        //intent.setData(Uri.parse("market://search?q=pname:" + this.f1619a.m37c().getText(R.string.package_name)));
        Log.e("abozanona", "abozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\nabozanona\n");
        //this.f1619a.m20a(intent);
        Log1.LogAction("buttons", "update", null, null);
    }
}
