package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;

class al implements at {
    al() {
    }

    public int mo69a(View view) {
        return 2;
    }

    long mo82a() {
        return 10;
    }

    public void mo70a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidateDelayed(mo82a(), i, i2, i3, i4);
    }

    public void mo71a(View view, int i, Paint paint) {
    }

    public void mo72a(View view, Paint paint) {
    }

    public void mo73a(View view, C0072a c0072a) {
    }

    public void mo74a(View view, Runnable runnable) {
        view.postDelayed(runnable, mo82a());
    }

    public boolean mo75a(View view, int i) {
        return false;
    }

    public void mo76b(View view) {
        view.postInvalidateDelayed(mo82a());
    }

    public void mo77b(View view, int i) {
    }

    public int mo78c(View view) {
        return 0;
    }

    public int mo79d(View view) {
        return 0;
    }

    public int mo80e(View view) {
        return 0;
    }

    public boolean mo81f(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }
}
