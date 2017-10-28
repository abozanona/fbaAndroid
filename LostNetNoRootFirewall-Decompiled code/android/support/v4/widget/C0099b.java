package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class C0099b extends MarginLayoutParams {
    public int f399a = 0;
    float f400b;
    boolean f401c;
    boolean f402d;

    public C0099b(int i, int i2) {
        super(i, i2);
    }

    public C0099b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f357a);
        this.f399a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    public C0099b(C0099b c0099b) {
        super(c0099b);
        this.f399a = c0099b.f399a;
    }

    public C0099b(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public C0099b(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }
}
