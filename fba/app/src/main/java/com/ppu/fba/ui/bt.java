package com.ppu.fba.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.ppu.fba.free.R;
import com.ppu.fba.FirewallApplication;

public class bt extends DialogFragment {
    TextView f1697a;
    SharedPreferences f1698b;
    Editor f1699c;
    private String f1700d = null;
    private String f1701e = null;
    private TextView f1702f;
    private TextView f1703g;
    private TextView f1704h;
    private TextView f1705i;
    private TextView f1706j;

    public bt(TextView textView) {
        this.f1697a = textView;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1698b = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a());
        this.f1699c = this.f1698b.edit();
        this.f1700d = this.f1698b.getString("officeWifi", null);
        this.f1701e = null;
        WifiManager wifiManager = (WifiManager) FirewallApplication.m1851a().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                this.f1701e = connectionInfo.getSSID();
            }
        }
        if (!(this.f1701e == null || this.f1700d == null || !this.f1701e.equals(this.f1700d))) {
            this.f1701e = null;
        }
        setStyle(0, 16973931);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Builder builder = new Builder(getActivity());
        builder.setIcon(17301659);
        builder.setTitle(getResources().getString(R.string.office_wifi_pro));
        if (this.f1701e != null) {
            builder.setPositiveButton(R.string.prefs_office_wifi, new bu(this));
        }
        if (this.f1700d != null) {
            builder.setNeutralButton(R.string.prefs_office_wifi_forget, new bv(this));
        }
        builder.setNegativeButton(17039360, new bw(this));
        View inflate = LayoutInflater.from(getActivity()).inflate(R.dialog_office_wifi, null);
        this.f1702f = (TextView) inflate.findViewById(R.id.officeWifiNo);
        this.f1703g = (TextView) inflate.findViewById(R.id.officeWifiSavedTitle);
        this.f1704h = (TextView) inflate.findViewById(R.id.officeWifiSaved);
        this.f1705i = (TextView) inflate.findViewById(R.id.officeWifiCurrentTitle);
        this.f1706j = (TextView) inflate.findViewById(R.id.officeWifiCurrent);
        if (this.f1700d == null && this.f1701e == null) {
            this.f1702f.setVisibility(0);
        }
        if (this.f1700d == null) {
            this.f1703g.setVisibility(8);
            this.f1704h.setVisibility(8);
            this.f1704h.setText(R.string.office_wifi_none);
        } else {
            this.f1704h.setText(this.f1700d);
        }
        if (this.f1701e == null) {
            this.f1705i.setVisibility(8);
            this.f1706j.setVisibility(8);
        } else {
            this.f1706j.setText(this.f1701e);
        }
        builder.setView(inflate);
        return builder.create();
    }
}
