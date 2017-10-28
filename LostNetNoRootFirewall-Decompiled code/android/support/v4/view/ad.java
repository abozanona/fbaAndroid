package android.support.v4.view;

import android.view.MotionEvent;

class ad {
    public static int m537a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static int m538a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m539b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m540c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m541d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
