package com.ppu.fba.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class DashboardViewPager extends ViewPager {
    int f1452a;

    public DashboardViewPager(Context context) {
        super(context);
    }

    public DashboardViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setChildId(int i) {
        this.f1452a = i;
    }
}
