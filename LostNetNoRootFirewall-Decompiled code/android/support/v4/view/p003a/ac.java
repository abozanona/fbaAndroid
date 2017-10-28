package android.support.v4.view.p003a;

import android.view.accessibility.AccessibilityRecord;

class ac {
    public static Object m396a() {
        return AccessibilityRecord.obtain();
    }

    public static void m397a(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    public static void m398a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    public static void m399b(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    public static void m400c(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
