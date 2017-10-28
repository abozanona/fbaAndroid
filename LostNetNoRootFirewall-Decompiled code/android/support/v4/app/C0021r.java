package android.support.v4.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class C0021r implements AnimationListener {
    final /* synthetic */ Fragment f214a;
    final /* synthetic */ C0019p f215b;

    C0021r(C0019p c0019p, Fragment fragment) {
        this.f215b = c0019p;
        this.f214a = fragment;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f214a.f34b != null) {
            this.f214a.f34b = null;
            this.f215b.m182a(this.f214a, this.f214a.f35c, 0, 0, false);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
