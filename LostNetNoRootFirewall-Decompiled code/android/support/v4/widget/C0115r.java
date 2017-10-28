package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class C0115r extends MarginLayoutParams {
    private static final int[] f413e = new int[]{16843137};
    public float f414a = 0.0f;
    boolean f415b;
    boolean f416c;
    Paint f417d;

    public C0115r() {
        super(-1, -1);
    }

    public C0115r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f413e);
        this.f414a = obtainStyledAttributes.getFloat(0, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public C0115r(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public C0115r(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }
}
