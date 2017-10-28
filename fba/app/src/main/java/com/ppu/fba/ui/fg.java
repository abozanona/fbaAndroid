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
import com.ppu.fba.p009d.C0308e;
import java.util.ArrayList;

class fg extends BaseAdapter {
    final /* synthetic */ ToolSnifferActivity f1852a;
    private final ArrayList f1853b;

    public fg(ToolSnifferActivity toolSnifferActivity, Context context, ArrayList arrayList) {
        this.f1852a = toolSnifferActivity;
        this.f1853b = arrayList;
    }

    public int getCount() {
        return this.f1853b.size();
    }

    public Object getItem(int i) {
        return this.f1853b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        Integer num = (Integer) this.f1853b.get(i);
        int intValue = num.intValue();
        view = (RelativeLayout) view;
        View view2 = (view == null || ((Integer) view.getTag()).equals(num)) ? view : null;
        if (view2 == null) {
            view2 = (RelativeLayout) LayoutInflater.from(context).inflate(R.list_view_item_spinner, viewGroup, false);
            view2.setTag(num);
        }
        View view3 = view2;
        ImageView imageView = (ImageView) view3.findViewById(R.id.itemIcon);
        TextView textView = (TextView) view3.findViewById(R.id.itemName);
        CharSequence a = C0308e.m1964a(intValue);
        Bitmap b = C0308e.m1967b(intValue);
        if (b != null) {
            imageView.setImageBitmap(b);
        }
        if (a != null) {
            textView.setText(a);
        }
        view3.setTag(num);
        return view3;
    }
}
