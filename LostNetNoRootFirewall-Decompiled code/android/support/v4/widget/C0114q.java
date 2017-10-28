package android.support.v4.widget;

import android.support.v4.view.ak;
import android.view.View;

class C0114q implements Runnable {
    final View f411a;
    final /* synthetic */ SlidingPaneLayout f412b;

    C0114q(SlidingPaneLayout slidingPaneLayout, View view) {
        this.f412b = slidingPaneLayout;
        this.f411a = view;
    }

    public void run() {
        if (this.f411a.getParent() == this.f412b) {
            ak.m554a(this.f411a, 0, null);
            this.f412b.m785d(this.f411a);
        }
        this.f412b.f398t.remove(this);
    }
}
