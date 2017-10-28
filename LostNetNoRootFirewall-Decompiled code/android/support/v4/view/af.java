package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class af {
    static final ai f328a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f328a = new ah();
        } else {
            f328a = new ag();
        }
    }

    public static float m542a(VelocityTracker velocityTracker, int i) {
        return f328a.mo67a(velocityTracker, i);
    }

    public static float m543b(VelocityTracker velocityTracker, int i) {
        return f328a.mo68b(velocityTracker, i);
    }
}
