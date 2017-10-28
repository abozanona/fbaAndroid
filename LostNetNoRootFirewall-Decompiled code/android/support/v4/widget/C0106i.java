package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

class C0106i {
    public static Object m853a(Context context) {
        return new EdgeEffect(context);
    }

    public static void m854a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    public static boolean m855a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    public static boolean m856a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    public static boolean m857a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }

    public static void m858b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    public static boolean m859c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }
}
