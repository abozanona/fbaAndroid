package com.lostnet.fw.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.vending.licensing.APKExpansionPolicy;
import com.lostnet.fw.C0328k;
import com.lostnet.fw.C0329l;
import com.lostnet.fw.FirewallManagerService;
import com.lostnet.fw.p007b.C0289a;
import com.lostnet.fw.p008c.C0298c;
import com.lostnet.fw.p009d.C0308e;
import com.lostnet.fw.p009d.C0312i;
import java.util.ArrayList;
import java.util.HashMap;

class ai extends BaseAdapter {
    final /* synthetic */ ad f1576a;
    private final HashMap f1577b;
    private final ArrayList f1578c;

    public ai(ad adVar, Context context, HashMap hashMap, ArrayList arrayList) {
        this.f1576a = adVar;
        this.f1577b = hashMap;
        this.f1578c = arrayList;
    }

    public int getCount() {
        return this.f1578c.size();
    }

    public Object getItem(int i) {
        return this.f1578c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        View view3;
        Context context = viewGroup.getContext();
        Integer num = (Integer) this.f1578c.get(i);
        int intValue = num.intValue();
        String c = C0308e.m1970c(intValue);
        C0298c c0298c = (C0298c) this.f1577b.get(num);
        View view4 = (RelativeLayout) view;
        if (view4 == null) {
            view2 = view4;
        } else if (((Integer) view4.getTag()).equals(num)) {
            return view;
        } else {
            view2 = null;
        }
        C0289a c0289a = null;
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            c0289a = (C0289a) a.f1294c.f1366a.get(num);
        }
        if (c0289a == null) {
            c0289a = new C0289a(intValue);
        }
        if (view2 == null) {
            View view5 = (RelativeLayout) LayoutInflater.from(context).inflate(C0329l.list_view_item_app, viewGroup, false);
            view5.setTag(num);
            view5.setDrawingCacheBackgroundColor(-16777216);
            radioButton = (RadioButton) view5.findViewById(C0328k.buttonAllow);
            radioButton2 = (RadioButton) view5.findViewById(C0328k.buttonWiFiOnly);
            radioButton3 = (RadioButton) view5.findViewById(C0328k.buttonBlock);
            radioButton.setOnClickListener(new aj(this, c0289a, context, num, c));
            radioButton2.setOnClickListener(new ak(this, c0289a, context, num, c));
            radioButton3.setOnClickListener(new al(this, c0289a, context, num, c));
            view3 = view5;
        } else {
            radioButton3 = (RadioButton) view2.findViewById(C0328k.buttonBlock);
            radioButton2 = (RadioButton) view2.findViewById(C0328k.buttonWiFiOnly);
            view3 = view2;
            radioButton = (RadioButton) view2.findViewById(C0328k.buttonAllow);
        }
        switch (c0289a.m1919a()) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                radioButton.setChecked(true);
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                break;
            case 1:
                radioButton.setChecked(false);
                radioButton2.setChecked(true);
                radioButton3.setChecked(false);
                break;
            case 2:
                radioButton.setChecked(false);
                radioButton2.setChecked(false);
                radioButton3.setChecked(true);
                break;
        }
        ImageView imageView = (ImageView) view3.findViewById(C0328k.itemIcon);
        TextView textView = (TextView) view3.findViewById(C0328k.itemName);
        TextView textView2 = (TextView) view3.findViewById(C0328k.itemUpload);
        TextView textView3 = (TextView) view3.findViewById(C0328k.itemDownload);
        View findViewById = view3.findViewById(C0328k.itemOffice);
        if ((c0289a.m1921b() & 32) != 0) {
            findViewById.setVisibility(0);
        }
        findViewById = view3.findViewById(C0328k.itemNight);
        if ((c0289a.m1921b() & 16) != 0) {
            findViewById.setVisibility(0);
        }
        findViewById = view3.findViewById(C0328k.itemBackground);
        if ((c0289a.m1921b() & 8) != 0) {
            findViewById.setVisibility(0);
        }
        CharSequence a2 = C0308e.m1964a(c0289a.f1363a);
        Bitmap b = C0308e.m1967b(c0289a.f1363a);
        if (b != null) {
            imageView.setDrawingCacheBackgroundColor(-16777216);
            imageView.setDrawingCacheEnabled(true);
            imageView.setImageBitmap(b);
        }
        if (a2 != null) {
            textView.setText(a2);
        }
        textView2.setText(C0312i.m2001a(context, c0298c.f1378a));
        textView3.setText(C0312i.m2001a(context, c0298c.f1379b));
        view3.setTag(num);
        view3.setOnClickListener(new am(this, context, intValue, c));
        return view3;
    }
}
