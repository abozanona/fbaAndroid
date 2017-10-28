package android.support.v4.app;

import android.os.Build.VERSION;

public class ae {
    private static final ak f103a;

    static {
        if (VERSION.SDK_INT >= 16) {
            f103a = new ao();
        } else if (VERSION.SDK_INT >= 14) {
            f103a = new an();
        } else if (VERSION.SDK_INT >= 11) {
            f103a = new am();
        } else {
            f103a = new al();
        }
    }
}
