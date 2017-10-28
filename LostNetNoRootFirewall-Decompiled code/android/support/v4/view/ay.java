package android.support.v4.view;

import android.view.View;

class ay {
    public static void m614a(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void m615a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void m616a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    public static void m617a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static int m618b(View view) {
        return view.getImportantForAccessibility();
    }
}
