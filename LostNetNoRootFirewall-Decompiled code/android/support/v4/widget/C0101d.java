package android.support.v4.widget;

import android.view.View;

class C0101d extends aa {
    final /* synthetic */ DrawerLayout f403a;
    private final int f404b;
    private C0122y f405c;
    private final Runnable f406d;

    private void m813b() {
        int i = 3;
        if (this.f404b == 3) {
            i = 5;
        }
        View a = this.f403a.m761a(i);
        if (a != null) {
            this.f403a.m776i(a);
        }
    }

    public int mo124a(View view) {
        return view.getWidth();
    }

    public int mo125a(View view, int i, int i2) {
        if (this.f403a.m766a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.f403a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    public void m816a() {
        this.f403a.removeCallbacks(this.f406d);
    }

    public void mo126a(int i) {
        this.f403a.m763a(this.f404b, i, this.f405c.m937c());
    }

    public void mo127a(int i, int i2) {
        this.f403a.postDelayed(this.f406d, 160);
    }

    public void mo128a(View view, float f, float f2) {
        int i;
        float d = this.f403a.m771d(view);
        int width = view.getWidth();
        if (this.f403a.m766a(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
        } else {
            i = this.f403a.getWidth();
            if (f < 0.0f || (f == 0.0f && d > 0.5f)) {
                i -= width;
            }
        }
        this.f405c.m927a(i, view.getTop());
        this.f403a.invalidate();
    }

    public void mo129a(View view, int i, int i2, int i3, int i4) {
        int width = view.getWidth();
        float width2 = this.f403a.m766a(view, 3) ? ((float) (width + i)) / ((float) width) : ((float) (this.f403a.getWidth() - i)) / ((float) width);
        this.f403a.m769b(view, width2);
        view.setVisibility(width2 == 0.0f ? 4 : 0);
        this.f403a.invalidate();
    }

    public boolean mo130a(View view, int i) {
        return this.f403a.m774g(view) && this.f403a.m766a(view, this.f404b) && this.f403a.m759a(view) == 0;
    }

    public int mo131b(View view, int i, int i2) {
        return view.getTop();
    }

    public void mo132b(int i, int i2) {
        View a = (i & 1) == 1 ? this.f403a.m761a(3) : this.f403a.m761a(5);
        if (a != null && this.f403a.m759a(a) == 0) {
            this.f405c.m925a(a, i2);
        }
    }

    public void mo133b(View view, int i) {
        ((C0099b) view.getLayoutParams()).f401c = false;
        m813b();
    }

    public boolean mo134b(int i) {
        return false;
    }
}
