package com.ppu.fba.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ppu.fba.free.R;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p007b.C0292d;
import com.ppu.fba.p008c.C0298c;
import com.ppu.fba.p009d.C0309f;
import com.ppu.fba.p009d.C0312i;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class C0349n extends BaseAdapter {
    final /* synthetic */ DetailsAppActivity f1884a;
    private final HashMap f1885b;
    private final ArrayList f1886c;

    public C0349n(DetailsAppActivity detailsAppActivity, Context context, HashMap hashMap, ArrayList arrayList) {
        this.f1884a = detailsAppActivity;
        this.f1885b = hashMap;
        this.f1886c = arrayList;
    }

    public int getCount() {
        return this.f1886c.size();
    }

    public Object getItem(int i) {
        return this.f1886c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0292d c0292d;
        Context context = viewGroup.getContext();
        Integer num = (Integer) this.f1886c.get(i);
        int intValue = num.intValue();
        String a = C0309f.m1974a(intValue);
        C0298c c0298c = (C0298c) this.f1885b.get(num);
        FirewallManagerService a2 = FirewallManagerService.m1852a(null);
        if (a2 != null) {
            synchronized (a2.f1295d) {
                c0292d = (C0292d) a2.f1295d.f1370a.get(num);
            }
        } else {
            c0292d = null;
        }
        if (c0292d == null) {
            c0292d = new C0292d(a, intValue);
        }
        view = (RelativeLayout) view;
        View view2 = (view == null || ((Integer) view.getTag()).equals(num)) ? view : null;
        if (view2 == null) {
            view2 = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.list_view_item_short, viewGroup, false);
            view2.setTag(num);
        }
        View view3 = view2;
        ImageView imageView = (ImageView) view3.findViewById(R.id.itemIcon);
        TextView textView = (TextView) view3.findViewById(R.id.itemName);
        TextView textView2 = (TextView) view3.findViewById(R.id.itemUpload);
        TextView textView3 = (TextView) view3.findViewById(R.id.itemDownload);
        CharSequence c = C0309f.m1980c(a);
        Drawable e = C0309f.m1984e(a);
        if (e != null) {
            imageView.setImageDrawable(e);
        }
        if (c != null) {
            textView.setText(c);
        }
        BigInteger bigInteger = c0298c.f1378a;
        BigInteger bigInteger2 = c0298c.f1379b;
        CharSequence a3 = C0312i.m2001a(this.f1884a.getApplicationContext(), bigInteger);
        CharSequence a4 = C0312i.m2001a(this.f1884a.getApplicationContext(), bigInteger2);
        textView2.setText(a3);
        textView3.setText(a4);
        view3.setOnClickListener(new C0350o(this, context, a));
        return view3;
    }
}
