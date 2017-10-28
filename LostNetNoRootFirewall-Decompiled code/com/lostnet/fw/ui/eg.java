package com.lostnet.fw.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lostnet.fw.C0328k;
import com.lostnet.fw.C0329l;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.FirewallManagerService;
import com.lostnet.fw.p007b.C0292d;
import com.lostnet.fw.p007b.C0294f;
import com.lostnet.fw.p008c.C0298c;
import com.lostnet.fw.p009d.C0309f;
import com.lostnet.fw.p009d.C0312i;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

abstract class eg extends BaseAdapter {
    private final boolean f1800a;
    final /* synthetic */ SectionGeoListFragment f1801b;

    public eg(SectionGeoListFragment sectionGeoListFragment, boolean z) {
        this.f1801b = sectionGeoListFragment;
        this.f1800a = z;
    }

    protected abstract View mo765a(int i, View view, ViewGroup viewGroup, boolean z);

    protected View m2133a(Drawable drawable, String str, C0298c c0298c, ArrayList arrayList, int i, View view, ViewGroup viewGroup, boolean z) {
        Context context = viewGroup.getContext();
        View view2 = (RelativeLayout) view;
        if (view2 != null) {
            if (view2.getTag() == null || (view2.getTag() instanceof ArrayList)) {
                view2.setTag(arrayList);
            } else if (view2.getTag() != null) {
                return view;
            }
        }
        TextView textView = null;
        TextView textView2 = null;
        if (view2 == null) {
            LayoutInflater from = LayoutInflater.from(context);
            if (c0298c == null) {
                view2 = (RelativeLayout) from.inflate(C0329l.list_view_item_geo_nocounters, viewGroup, false);
            } else {
                RelativeLayout relativeLayout = (RelativeLayout) from.inflate(C0329l.list_view_item_geo, viewGroup, false);
            }
            view2.setDrawingCacheBackgroundColor(-16777216);
            view2.setTag(arrayList);
        }
        View view3 = view2;
        RadioButton radioButton = (RadioButton) view3.findViewById(C0328k.buttonAllow);
        RadioButton radioButton2 = (RadioButton) view3.findViewById(C0328k.buttonBlock);
        ImageView imageView = (ImageView) view3.findViewById(C0328k.itemIcon);
        TextView textView3 = (TextView) view3.findViewById(C0328k.itemName);
        if (c0298c != null) {
            textView = (TextView) view3.findViewById(C0328k.itemUpload);
            textView2 = (TextView) view3.findViewById(C0328k.itemDownload);
        }
        if (str == null) {
            textView3.setText("<" + this.f1801b.m37c().getString(C0330m.unknown_country) + ">");
        } else {
            textView3.setText(str);
        }
        if (z) {
            textView3.setOnClickListener(new eh(this, i));
            imageView.setOnClickListener(new ei(this, i));
        }
        if (drawable == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setDrawingCacheBackgroundColor(-16777216);
            imageView.setDrawingCacheEnabled(true);
            imageView.setImageDrawable(drawable);
        }
        if (c0298c != null) {
            BigInteger bigInteger = c0298c != null ? c0298c.f1378a : BigInteger.ZERO;
            BigInteger bigInteger2 = c0298c != null ? c0298c.f1379b : BigInteger.ZERO;
            CharSequence a = C0312i.m2001a(context, bigInteger);
            CharSequence a2 = C0312i.m2001a(context, bigInteger2);
            textView.setText(a);
            textView2.setText(a2);
        }
        int i2 = -1;
        FirewallManagerService a3 = FirewallManagerService.m1852a(null);
        if (a3 != null) {
            C0294f c0294f = a3.f1295d;
            synchronized (c0294f) {
                Iterator it = arrayList.iterator();
                int i3 = -1;
                while (it.hasNext()) {
                    C0292d c0292d = (C0292d) c0294f.f1370a.get(Integer.valueOf(C0309f.m1982d((String) it.next())));
                    if ((i3 != -1 && i3 != 0) || c0292d != null) {
                        if (i3 != -1 && i3 != 0 && c0292d == null) {
                            i2 = -1;
                            break;
                        } else if (i3 == -1) {
                            i3 = c0292d.f1369c;
                        } else if (i3 != c0292d.f1369c) {
                            i2 = -1;
                            break;
                        }
                    } else {
                        i3 = 0;
                    }
                }
                i2 = i3;
            }
        }
        radioButton.setOnCheckedChangeListener(null);
        radioButton2.setOnCheckedChangeListener(null);
        if (i2 == 0) {
            radioButton.setChecked(true);
        } else if (i2 == 2) {
            radioButton2.setChecked(true);
        }
        radioButton.setOnCheckedChangeListener(new el(this.f1801b, arrayList, 0, drawable == null, str));
        radioButton2.setOnCheckedChangeListener(new el(this.f1801b, arrayList, 2, drawable == null, str));
        if (this.f1800a) {
            view3.setOnClickListener(new ej(this, context, str, arrayList));
        }
        return view3;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return mo765a(i, view, viewGroup, true);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return mo765a(i, view, viewGroup, false);
    }
}
