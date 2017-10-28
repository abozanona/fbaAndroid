package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

class ao extends an {
    ao() {
    }

    long mo82a() {
        return aw.m610a();
    }

    public void mo71a(View view, int i, Paint paint) {
        aw.m611a(view, i, paint);
    }

    public void mo72a(View view, Paint paint) {
        mo71a(view, mo79d(view), paint);
        view.invalidate();
    }

    public int mo79d(View view) {
        return aw.m609a(view);
    }
}
