package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public class C0097z {
    static final ac f353a;

    static {
        if (VERSION.SDK_INT >= 5) {
            f353a = new ab();
        } else {
            f353a = new aa();
        }
    }

    public static int m746a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m747a(MotionEvent motionEvent, int i) {
        return f353a.mo63a(motionEvent, i);
    }

    public static int m748b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m749b(MotionEvent motionEvent, int i) {
        return f353a.mo64b(motionEvent, i);
    }

    public static float m750c(MotionEvent motionEvent, int i) {
        return f353a.mo65c(motionEvent, i);
    }

    public static int m751c(MotionEvent motionEvent) {
        return f353a.mo62a(motionEvent);
    }

    public static float m752d(MotionEvent motionEvent, int i) {
        return f353a.mo66d(motionEvent, i);
    }
}
