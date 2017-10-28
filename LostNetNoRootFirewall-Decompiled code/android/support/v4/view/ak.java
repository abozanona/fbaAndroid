package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.view.View;

public class ak {
    static final at f329a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            f329a = new as();
        } else if (i >= 17) {
            f329a = new ar();
        } else if (i >= 16) {
            f329a = new aq();
        } else if (i >= 14) {
            f329a = new ap();
        } else if (i >= 11) {
            f329a = new ao();
        } else if (i >= 9) {
            f329a = new an();
        } else {
            f329a = new al();
        }
    }

    public static int m552a(View view) {
        return f329a.mo69a(view);
    }

    public static void m553a(View view, int i, int i2, int i3, int i4) {
        f329a.mo70a(view, i, i2, i3, i4);
    }

    public static void m554a(View view, int i, Paint paint) {
        f329a.mo71a(view, i, paint);
    }

    public static void m555a(View view, Paint paint) {
        f329a.mo72a(view, paint);
    }

    public static void m556a(View view, C0072a c0072a) {
        f329a.mo73a(view, c0072a);
    }

    public static void m557a(View view, Runnable runnable) {
        f329a.mo74a(view, runnable);
    }

    public static boolean m558a(View view, int i) {
        return f329a.mo75a(view, i);
    }

    public static void m559b(View view) {
        f329a.mo76b(view);
    }

    public static void m560b(View view, int i) {
        f329a.mo77b(view, i);
    }

    public static int m561c(View view) {
        return f329a.mo78c(view);
    }

    public static int m562d(View view) {
        return f329a.mo79d(view);
    }

    public static int m563e(View view) {
        return f329a.mo80e(view);
    }

    public static boolean m564f(View view) {
        return f329a.mo81f(view);
    }
}
