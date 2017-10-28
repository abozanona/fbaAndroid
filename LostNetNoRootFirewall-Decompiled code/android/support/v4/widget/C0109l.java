package android.support.v4.widget;

import android.widget.Scroller;

class C0109l implements C0108k {
    C0109l() {
    }

    public void mo142a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public boolean mo143a(Object obj) {
        return ((Scroller) obj).isFinished();
    }

    public int mo144b(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    public int mo145c(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    public boolean mo146d(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    public void mo147e(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    public int mo148f(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    public int mo149g(Object obj) {
        return ((Scroller) obj).getFinalY();
    }
}
