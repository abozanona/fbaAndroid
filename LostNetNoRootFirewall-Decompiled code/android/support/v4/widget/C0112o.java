package android.support.v4.widget;

import android.widget.OverScroller;

class C0112o {
    public static void m892a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public static boolean m893a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public static int m894b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public static int m895c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public static boolean m896d(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public static void m897e(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public static int m898f(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public static int m899g(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }
}
