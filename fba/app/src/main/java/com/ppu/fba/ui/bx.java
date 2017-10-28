package com.ppu.fba.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.C0316m;
import com.ppu.fba.p009d.C0317n;
import java.util.ArrayList;
import java.util.List;

public class bx extends DialogFragment {
    SharedPreferences f1710a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1710a = C0316m.m2021b();
        setStyle(0, 16973931);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Resources resources = getResources();
        Builder builder = new Builder(getActivity());
        builder.setTitle(resources.getString(R.string.profile_add_title));
        String string = resources.getString(R.string.profile_add_from_scratch);
        String[] a = C0317n.m2024a();
        if (a == null) {
            dismiss();
            return builder.create();
        }
        View inflate = LayoutInflater.from(getActivity()).inflate(R.dialog_profile_add, null);
        EditText editText = (EditText) inflate.findViewById(R.id.profileAddInput);
        TextView textView = (TextView) inflate.findViewById(R.id.profileAddComment);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.profileAddSpinner);
        if (a.length > 0) {
            textView.setVisibility(0);
            spinner.setVisibility(0);
            List arrayList = new ArrayList();
            arrayList.add(string);
            for (Object add : a) {
                arrayList.add(add);
            }
            spinner.setAdapter(new ArrayAdapter(getActivity(), 17367049, arrayList));
        } else {
            textView.setVisibility(8);
            spinner.setVisibility(8);
        }
        builder.setPositiveButton(R.string.button_ok, new by(this, editText, a, spinner, string));
        builder.setNegativeButton(17039360, new bz(this));
        builder.setView(inflate);
        return builder.create();
    }

    public void onStop() {
        super.onStop();
        ((ProfileSelectActivity) getActivity()).m2053a();
    }
}
