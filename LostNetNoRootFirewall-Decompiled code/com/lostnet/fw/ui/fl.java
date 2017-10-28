package com.lostnet.fw.ui;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.google.android.vending.licensing.APKExpansionPolicy;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.FirewallApplication;

class fl implements OnItemClickListener {
    final /* synthetic */ ToolsActivity f1859a;

    fl(ToolsActivity toolsActivity) {
        this.f1859a = toolsActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        boolean z = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a()).getBoolean("status_on", true);
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                if (z) {
                    this.f1859a.startActivity(new Intent(this.f1859a, ToolSnifferActivity.class));
                    return;
                }
                Toast.makeText(this.f1859a, C0330m.turn_on, 1).show();
                return;
            default:
                return;
        }
    }
}
