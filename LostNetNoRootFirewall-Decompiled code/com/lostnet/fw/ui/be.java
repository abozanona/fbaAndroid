package com.lostnet.fw.ui;

import android.app.AlertDialog.Builder;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import com.lostnet.fw.C0328k;
import com.lostnet.fw.C0329l;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.p009d.C0310g;
import java.util.ArrayList;

class be implements OnTabChangeListener {
    final /* synthetic */ SectionGeoListFragment f1657a;
    final /* synthetic */ ViewPager f1658b;
    final /* synthetic */ LayoutInflater f1659c;

    be(SectionGeoListFragment sectionGeoListFragment, ViewPager viewPager, LayoutInflater layoutInflater) {
        this.f1657a = sectionGeoListFragment;
        this.f1658b = viewPager;
        this.f1659c = layoutInflater;
    }

    public void onTabChanged(String str) {
        if (str.equals("map")) {
            this.f1658b.m346a(0, true);
        } else if (str.equals("list")) {
            this.f1658b.m346a(1, true);
            if (this.f1657a.f1513W && C0310g.m1995g()) {
                ArrayList arrayList = new ArrayList();
                Builder builder = new Builder(this.f1658b.getContext());
                builder.setCancelable(false);
                builder.setTitle(C0330m.popup_click_cnts_title);
                View inflate = this.f1659c.inflate(C0329l.dialog_warn_dont, null);
                ((TextView) inflate.findViewById(C0328k.dialogText)).setText(C0330m.popup_click_cnts_content);
                CheckBox checkBox = (CheckBox) inflate.findViewById(C0328k.dialogCheckbox);
                checkBox.setText(C0330m.popup_click_cnts_checkbox);
                checkBox.setOnCheckedChangeListener(new ek(this.f1657a, arrayList));
                builder.setView(inflate);
                builder.setPositiveButton(C0330m.button_ok, new dv(this, arrayList));
                builder.create().show();
            }
        }
    }
}
