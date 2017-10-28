package android.support.v4.view;

import android.view.MotionEvent;

class aa implements ac {
    aa() {
    }

    public int mo62a(MotionEvent motionEvent) {
        return 1;
    }

    public int mo63a(MotionEvent motionEvent, int i) {
        return i == 0 ? 0 : -1;
    }

    public int mo64b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float mo65c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float mo66d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
}
