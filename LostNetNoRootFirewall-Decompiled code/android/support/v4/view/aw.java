package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class aw {
    public static int m609a(View view) {
        return view.getLayerType();
    }

    static long m610a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void m611a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }
}
