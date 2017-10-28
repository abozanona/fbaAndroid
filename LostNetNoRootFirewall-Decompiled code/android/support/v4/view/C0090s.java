package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public class C0090s {
    static final C0091w f352a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f352a = new C0094v();
        } else {
            f352a = new C0092t();
        }
    }

    public static boolean m727a(KeyEvent keyEvent) {
        return f352a.mo122b(keyEvent.getMetaState());
    }

    public static boolean m728a(KeyEvent keyEvent, int i) {
        return f352a.mo121a(keyEvent.getMetaState(), i);
    }

    public static void m729b(KeyEvent keyEvent) {
        f352a.mo120a(keyEvent);
    }
}
