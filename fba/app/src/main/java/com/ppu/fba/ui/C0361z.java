package com.ppu.fba.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ppu.fba.free.R;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p007b.C0289a;
import com.ppu.fba.p008c.C0298c;
import com.ppu.fba.p009d.C0308e;
import com.ppu.fba.p009d.C0312i;
import java.util.ArrayList;
import java.util.HashMap;

class C0361z extends BaseAdapter {
    final /* synthetic */ DetailsGeoActivity f1909a;
    private final HashMap f1910b;
    private final ArrayList f1911c;

    public C0361z(DetailsGeoActivity detailsGeoActivity, Context context, HashMap hashMap, ArrayList arrayList) {
        this.f1909a = detailsGeoActivity;
        this.f1910b = hashMap;
        this.f1911c = arrayList;
    }

    public int getCount() {
        return this.f1911c.size();
    }

    public Object getItem(int i) {
        return this.f1911c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0289a c0289a;
        Context context = viewGroup.getContext();
        Integer num = (Integer) this.f1911c.get(i);
        int intValue = num.intValue();
        CharSequence a = C0308e.m1964a(intValue);
        String c = C0308e.m1970c(intValue);
        C0298c c0298c = (C0298c) this.f1910b.get(num);
        FirewallManagerService a2 = FirewallManagerService.m1852a(null);
        if (a2 != null) {
            synchronized (a2.f1294c) {
                c0289a = (C0289a) a2.f1294c.f1366a.get(num);
            }
        } else {
            c0289a = null;
        }
        if (c0289a == null) {
            c0289a = new C0289a(intValue);
        }
        view = (RelativeLayout) view;
        View view2 = (view == null || ((Integer) view.getTag()).equals(num)) ? view : null;
        if (view2 == null) {
            view2 = (RelativeLayout) LayoutInflater.from(context).inflate(R.list_view_item_short, viewGroup, false);
            view2.setTag(num);
        }
        View view3 = view2;
        ImageView imageView = (ImageView) view3.findViewById(R.id.itemIcon);
        TextView textView = (TextView) view3.findViewById(R.id.itemName);
        TextView textView2 = (TextView) view3.findViewById(R.id.itemUpload);
        TextView textView3 = (TextView) view3.findViewById(R.id.itemDownload);
        Bitmap b = C0308e.m1967b(intValue);
        if (b != null) {
            imageView.setImageBitmap(b);
        }
        if (a != null) {
            textView.setText(a);
        }
        textView2.setText(C0312i.m2001a(context, c0298c.f1378a));
        textView3.setText(C0312i.m2001a(context, c0298c.f1379b));
        view3.setOnClickListener(new aa(this, context, intValue, c));
        return view3;
    }
}
