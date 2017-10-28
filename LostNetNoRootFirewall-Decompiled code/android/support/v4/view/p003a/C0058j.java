package android.support.v4.view.p003a;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

public class C0058j {
    private static final C0059k f315a;
    private final Object f316b;

    static {
        if (VERSION.SDK_INT >= 19) {
            f315a = new C0064n();
        } else if (VERSION.SDK_INT >= 16) {
            f315a = new C0061l();
        } else {
            f315a = new C0060p();
        }
    }

    public C0058j() {
        this.f316b = f315a.mo55a(this);
    }

    public C0058j(Object obj) {
        this.f316b = obj;
    }

    public C0046a m485a(int i) {
        return null;
    }

    public Object m486a() {
        return this.f316b;
    }

    public List m487a(String str, int i) {
        return null;
    }

    public boolean m488a(int i, int i2, Bundle bundle) {
        return false;
    }
}
