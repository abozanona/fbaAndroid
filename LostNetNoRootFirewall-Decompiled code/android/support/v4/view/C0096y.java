package android.support.v4.view;

import android.view.KeyEvent;

class C0096y {
    public static int m743a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m744a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m745b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
