package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class C0120w extends C0119v {
    private Method f418a;
    private Field f419b;

    C0120w() {
        try {
            this.f418a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
        } catch (Throwable e) {
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
        }
        try {
            this.f419b = View.class.getDeclaredField("mRecreateDisplayList");
            this.f419b.setAccessible(true);
        } catch (Throwable e2) {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
        }
    }

    public void mo150a(SlidingPaneLayout slidingPaneLayout, View view) {
        if (this.f418a == null || this.f419b == null) {
            view.invalidate();
            return;
        }
        try {
            this.f419b.setBoolean(view, true);
            this.f418a.invoke(view, (Object[]) null);
        } catch (Throwable e) {
            Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
        }
        super.mo150a(slidingPaneLayout, view);
    }
}
