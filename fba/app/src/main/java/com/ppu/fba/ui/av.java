package com.ppu.fba.ui;

import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.C0318o;

class av implements OnClickListener {
    final /* synthetic */ ao f1622a;

    av(ao aoVar) {
        this.f1622a = aoVar;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/html");
        intent.putExtra("android.intent.extra.SUBJECT", this.f1622a.m37c().getString(R.string.message_share_title) + " " + this.f1622a.m37c().getText(R.string.app_name));
        intent.putExtra("android.intent.extra.TEXT", Html.fromHtml("<p>" + this.f1622a.m37c().getString(R.string.message_share) + ":</p><a href='https://play.google.com/store/apps/details?id=" + this.f1622a.m37c().getText(R.string.package_name) + "'>" + this.f1622a.m37c().getText(R.string.app_name) + "</a>"));
        this.f1622a.m30b().startActivityForResult(Intent.createChooser(intent, this.f1622a.m37c().getString(R.string.popup_share_title)), 1);
        C0318o.m2031a(MapBuilder.createEvent("buttons", "share", "attempt", null).build());
    }
}
