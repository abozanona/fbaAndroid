package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class bk extends LayoutParams {
    public boolean f337a;
    public int f338b;
    float f339c = 0.0f;
    boolean f340d;
    int f341e;
    int f342f;

    public bk() {
        super(-1, -1);
    }

    public bk(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f263a);
        this.f338b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
