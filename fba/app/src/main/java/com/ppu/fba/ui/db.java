package com.ppu.fba.ui;

import android.content.Context;
import android.content.res.Resources;
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
import com.ppu.fba.p008c.C0296a;
import com.ppu.fba.p008c.C0297b;
import com.ppu.fba.p008c.C0298c;
import com.ppu.fba.p008c.C0299d;
import com.ppu.fba.p009d.C0308e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

abstract class db extends BaseAdapter {
    final /* synthetic */ LogsActivity f1761a;
    private final ArrayList f1762b;

    public db(LogsActivity logsActivity, Context context) {
        this.f1761a = logsActivity;
        boolean c = mo764c();
        Long valueOf = Long.valueOf(C0296a.m1929b());
        HashMap hashMap = new HashMap();
        FirewallManagerService a = FirewallManagerService.m1852a(null);
        if (a != null) {
            C0299d c0299d = a.f1297f;
            synchronized (c0299d) {
                for (long longValue = valueOf.longValue(); longValue > valueOf.longValue() - 24; longValue--) {
                    C0297b a2 = c0299d.m1952a(longValue);
                    for (Integer num : a2.m1937a()) {
                        long a3 = mo763a(a2.m1935a(num.intValue()));
                        if (a3 != 0) {
                            cy cyVar = new cy(logsActivity);
                            cyVar.f1752b = num.intValue();
                            cyVar.f1751a = longValue;
                            cz czVar = (cz) hashMap.get(cyVar);
                            cz czVar2 = czVar == null ? new cz(logsActivity) : czVar;
                            czVar2.f1754a = a3 + czVar2.f1754a;
                            if (c) {
                                HashMap b = a2.m1942b(num.intValue());
                                for (Integer num2 : b.keySet()) {
                                    if (mo763a((C0298c) b.get(num2)) != 0) {
                                        czVar2.f1755b.add(num2);
                                    }
                                }
                            }
                            hashMap.put(cyVar, czVar2);
                        }
                    }
                }
            }
        }
        this.f1762b = new ArrayList();
        for (cy cyVar2 : hashMap.keySet()) {
            cx cxVar = new cx(logsActivity);
            cxVar.f1748a = cyVar2;
            cxVar.f1749b = (cz) hashMap.get(cyVar2);
            this.f1762b.add(cxVar);
        }
        Collections.sort(this.f1762b, new da(logsActivity, null));
    }

    protected int m2112a() {
        return R.string.logs_blocked2_1;
    }

    protected abstract long mo763a(C0298c c0298c);

    protected int m2114b() {
        return R.string.logs_blocked2_2;
    }

    protected abstract boolean mo764c();

    public int getCount() {
        return this.f1762b.size();
    }

    public Object getItem(int i) {
        return this.f1762b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        cx cxVar = (cx) this.f1762b.get(i);
        view = (RelativeLayout) view;
        View view2 = (view == null || ((cx) view.getTag()).equals(cxVar)) ? view : null;
        if (view2 == null) {
            view2 = (RelativeLayout) LayoutInflater.from(context).inflate(R.list_view_item_log, viewGroup, false);
            view2.setTag(cxVar);
        }
        View view3 = view2;
        ImageView imageView = (ImageView) view3.findViewById(R.id.itemIcon);
        TextView textView = (TextView) view3.findViewById(R.id.itemName);
        TextView textView2 = (TextView) view3.findViewById(R.id.itemComment);
        long j = cxVar.f1748a.f1751a % 24;
        ((TextView) view3.findViewById(R.id.itemWhen)).setText(String.format("%02d:%02d\n-\n%02d:%02d", new Object[]{Long.valueOf(j), Integer.valueOf(0), Long.valueOf(j), Integer.valueOf(59)}));
        Bitmap b = C0308e.m1967b(cxVar.f1748a.f1752b);
        if (b != null) {
            imageView.setImageBitmap(b);
        }
        Resources resources = this.f1761a.getResources();
        textView.setText(C0308e.m1964a(cxVar.f1748a.f1752b));
        if (mo764c()) {
            textView2.setText(resources.getString(R.string.logs_blocked_1) + " " + cxVar.f1749b.f1754a + " " + resources.getString(R.string.logs_blocked_2) + " " + cxVar.f1749b.f1755b.size() + " " + resources.getString(R.string.logs_blocked_3));
        } else {
            textView2.setText(resources.getString(m2112a()) + " " + cxVar.f1749b.f1754a + " " + resources.getString(m2114b()));
        }
        view3.setOnClickListener(new dc(this, cxVar));
        return view3;
    }
}
