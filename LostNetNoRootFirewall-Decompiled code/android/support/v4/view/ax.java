package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class ax {
    public static void m612a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public static boolean m613a(View view, int i) {
        return view.canScrollHorizontally(i);
    }
}
