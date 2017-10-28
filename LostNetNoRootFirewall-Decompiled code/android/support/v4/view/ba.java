package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class ba {
    static final bd f330a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f330a = new bc();
        } else {
            f330a = new bb();
        }
    }

    public static int m652a(ViewConfiguration viewConfiguration) {
        return f330a.mo94a(viewConfiguration);
    }
}
