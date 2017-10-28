package android.support.v4.view;

import android.os.Build.VERSION;

public class C0085n {
    static final C0086o f351a;

    static {
        if (VERSION.SDK_INT >= 17) {
            f351a = new C0088q();
        } else {
            f351a = new C0087p();
        }
    }

    public static int m722a(int i, int i2) {
        return f351a.mo119a(i, i2);
    }
}
