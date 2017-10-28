package com.lostnet.fw.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import com.lostnet.fw.C0328k;
import com.lostnet.fw.C0329l;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.p009d.C0316m;

public class bp extends DialogFragment {
    SharedPreferences f1686a;
    Editor f1687b;
    private String f1688c = null;
    private String f1689d = null;
    private boolean f1690e = true;
    private EditText f1691f;
    private EditText f1692g;
    private CheckBox f1693h;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1686a = C0316m.m2021b();
        this.f1688c = this.f1686a.getString("cloudshark", "www.cloudshark.org");
        this.f1689d = this.f1686a.getString("cloudshark_key", "f450b127b5911af9c44732fe2a4cf417");
        this.f1690e = this.f1686a.getBoolean("cloudshark_https", true);
        this.f1687b = this.f1686a.edit();
        setStyle(0, 16973931);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Builder builder = new Builder(getActivity());
        builder.setIcon(17301659);
        builder.setTitle(getResources().getString(C0330m.cloudshark_title));
        builder.setPositiveButton(17039370, new bq(this));
        builder.setNeutralButton(C0330m.cloudshark_reset, new br(this));
        builder.setNegativeButton(17039360, new bs(this));
        View inflate = LayoutInflater.from(getActivity()).inflate(C0329l.dialog_cloudshark, null);
        this.f1691f = (EditText) inflate.findViewById(C0328k.cloudsharkInput);
        this.f1692g = (EditText) inflate.findViewById(C0328k.cloudsharkKeyInput);
        this.f1693h = (CheckBox) inflate.findViewById(C0328k.cloudsharkHttpsInput);
        this.f1691f.setText(this.f1688c);
        this.f1692g.setText(this.f1689d);
        this.f1693h.setChecked(this.f1690e);
        builder.setView(inflate);
        return builder.create();
    }
}
