package com.ppu.fba.ui;

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
import com.ppu.fba.free.R;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p004a.C0276a;
import com.ppu.fba.p004a.C0284b;
import com.ppu.fba.p007b.C0289a;
import com.ppu.fba.p007b.C0292d;
import com.ppu.fba.p009d.C0308e;
import com.ppu.fba.p009d.C0309f;
import java.util.ArrayList;

class aw extends BaseAdapter {
    final /* synthetic */ ao f1623a;
    private ArrayList f1624b;

    public aw(ao aoVar, Context context, ArrayList arrayList) {
        this.f1623a = aoVar;
        this.f1624b = arrayList;
    }

    public int getCount() {
        synchronized (this.f1623a) {
        }
        int size = this.f1624b.size();
        return size > 2 ? 2 : size;
    }

    public Object getItem(int i) {
        return this.f1624b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        C0276a c0276a = (C0276a) this.f1624b.get(i);
        int b = c0276a.m1887b();
        C0284b a = c0276a.m1886a();
        view = (RelativeLayout) view;
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(context);
            view = c0276a.m1886a() == C0284b.COUNTRY ? (RelativeLayout) from.inflate(R.list_view_item_suggestion_geo, viewGroup, false) : (RelativeLayout) from.inflate(R.list_view_item_suggestion_app, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.suggestionIcon);
        TextView textView = (TextView) view.findViewById(R.id.suggestionName);
        TextView textView2 = (TextView) view.findViewById(R.id.suggestionComment);
        ((ImageView) view.findViewById(R.id.buttonCancel)).setOnClickListener(new ax(this, a, b, context));
        String a2;
        RadioButton radioButton;
        RadioButton radioButton2;
        FirewallManagerService a3;
        if (c0276a.m1886a() == C0284b.COUNTRY) {
            a2 = C0309f.m1974a(b);
            textView.setText(C0309f.m1980c(a2));
            imageView.setImageDrawable(C0309f.m1984e(a2));
            radioButton = (RadioButton) view.findViewById(R.id.buttonAllow);
            radioButton2 = (RadioButton) view.findViewById(R.id.buttonBlock);
            a3 = FirewallManagerService.m1852a(null);
            if (a3 != null) {
                C0292d c0292d;
                synchronized (a3.f1295d) {
                    C0292d c0292d2 = (C0292d) a3.f1295d.f1370a.get(Integer.valueOf(b));
                    if (c0292d2 == null) {
                        c0292d = new C0292d(C0309f.m1974a(b), b);
                        a3.f1295d.f1370a.put(Integer.valueOf(b), c0292d);
                    } else {
                        c0292d = c0292d2;
                    }
                }
                if (c0292d.f1369c == 2) {
                    radioButton2.setChecked(true);
                    radioButton.setChecked(false);
                } else {
                    radioButton2.setChecked(false);
                    radioButton.setChecked(true);
                }
                radioButton.setOnClickListener(new ay(this, c0292d, context, b, a2));
                radioButton2.setOnClickListener(new az(this, c0292d, context, b, a2));
            }
        } else {
            CharSequence a4 = C0308e.m1964a(b);
            a2 = C0308e.m1970c(b);
            textView.setText(a4);
            Bitmap b2 = C0308e.m1967b(b);
            if (b2 != null) {
                imageView.setImageBitmap(b2);
            }
            radioButton = (RadioButton) view.findViewById(R.id.buttonAllow);
            radioButton2 = (RadioButton) view.findViewById(R.id.buttonWiFiOnly);
            RadioButton radioButton3 = (RadioButton) view.findViewById(R.id.buttonBlock);
            a3 = FirewallManagerService.m1852a(null);
            if (a3 != null) {
                C0289a c0289a;
                synchronized (a3.f1294c) {
                    C0289a c0289a2 = (C0289a) a3.f1294c.f1366a.get(Integer.valueOf(b));
                    if (c0289a2 == null) {
                        c0289a = new C0289a(b);
                        a3.f1294c.f1366a.put(Integer.valueOf(b), c0289a);
                    } else {
                        c0289a = c0289a2;
                    }
                }
                int a5 = c0289a.m1919a();
                if (a5 == 2) {
                    radioButton3.setChecked(true);
                    radioButton2.setChecked(false);
                    radioButton.setChecked(false);
                } else if (a5 == 1) {
                    radioButton3.setChecked(false);
                    radioButton2.setChecked(true);
                    radioButton.setChecked(false);
                } else {
                    radioButton3.setChecked(false);
                    radioButton2.setChecked(false);
                    radioButton.setChecked(true);
                }
                radioButton.setOnClickListener(new ba(this, c0289a, context, b, a2));
                radioButton2.setOnClickListener(new bb(this, c0289a, context, b, a2));
                radioButton3.setOnClickListener(new bc(this, c0289a, context, b, a2));
            }
        }
        textView2.setText(c0276a.m1888c());
        return view;
    }
}
