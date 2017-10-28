package android.support.v4.p001b;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public class C0028a {
    public static Creator m263a(C0030c c0030c) {
        if (VERSION.SDK_INT >= 13) {
            C0032e.m266a(c0030c);
        }
        return new C0029b(c0030c);
    }
}
