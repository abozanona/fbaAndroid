package com.google.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.net.URLEncoder;

class ai implements az {
    private static ai f952a;
    private static final Object f953b = new Object();
    private String f954c;
    private String f955d;
    private cu f956e;
    private ba f957f;

    private ai(Context context) {
        this(bb.m1389a(context), new dx());
    }

    @VisibleForTesting
    ai(ba baVar, cu cuVar) {
        this.f957f = baVar;
        this.f956e = cuVar;
    }

    public static az m1351a(Context context) {
        az azVar;
        synchronized (f953b) {
            if (f952a == null) {
                f952a = new ai(context);
            }
            azVar = f952a;
        }
        return azVar;
    }

    public boolean mo621a(String str) {
        if (this.f956e.mo670a()) {
            if (!(this.f954c == null || this.f955d == null)) {
                try {
                    str = this.f954c + "?" + this.f955d + "=" + URLEncoder.encode(str, "UTF-8");
                    bs.m1445e("Sending wrapped url hit: " + str);
                } catch (Throwable e) {
                    bs.m1442b("Error wrapping URL for testing.", e);
                    return false;
                }
            }
            this.f957f.mo624a(str);
            return true;
        }
        bs.m1441b("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
