package com.lostnet.fw.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public abstract class ce extends cg {
    protected OnClickListener f1725a = new cf(this);
    private RelativeLayout f1726e;
    private ImageView f1727f;

    protected ce(Context context, View view, int i, int i2, int i3, int i4) {
        super(context, view, i3, i4);
        this.f1726e = (RelativeLayout) view.findViewById(i);
        this.f1727f = (ImageView) view.findViewById(i2);
        this.c.setOnClickListener(this.f1725a);
        this.f1727f.setOnClickListener(this.f1725a);
        this.d.add(this.f1727f);
        this.d.add(this.f1726e);
    }
}
