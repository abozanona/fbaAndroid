package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.ae;
import android.view.View;
import android.view.ViewGroup;

public abstract class C0023t extends ae {
    private final C0017n f217a;
    private C0004y f218b = null;
    private Fragment f219c = null;

    public C0023t(C0017n c0017n) {
        this.f217a = c0017n;
    }

    private static String m243a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public Parcelable mo12a() {
        return null;
    }

    public abstract Fragment mo757a(int i);

    public Object mo13a(ViewGroup viewGroup, int i) {
        if (this.f218b == null) {
            this.f218b = this.f217a.mo10a();
        }
        long b = m251b(i);
        Fragment a = this.f217a.mo9a(C0023t.m243a(viewGroup.getId(), b));
        if (a != null) {
            this.f218b.mo7b(a);
        } else {
            a = mo757a(i);
            this.f218b.mo4a(viewGroup.getId(), a, C0023t.m243a(viewGroup.getId(), b));
        }
        if (a != this.f219c) {
            a.m34b(false);
            a.m39c(false);
        }
        return a;
    }

    public void mo14a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void mo15a(ViewGroup viewGroup) {
    }

    public void mo16a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f218b == null) {
            this.f218b = this.f217a.mo10a();
        }
        this.f218b.mo5a((Fragment) obj);
    }

    public boolean mo17a(View view, Object obj) {
        return ((Fragment) obj).m52h() == view;
    }

    public long m251b(int i) {
        return (long) i;
    }

    public void mo18b(ViewGroup viewGroup) {
        if (this.f218b != null) {
            this.f218b.mo6b();
            this.f218b = null;
            this.f217a.mo11b();
        }
    }

    public void mo19b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f219c) {
            if (this.f219c != null) {
                this.f219c.m34b(false);
                this.f219c.m39c(false);
            }
            if (fragment != null) {
                fragment.m34b(true);
                fragment.m39c(true);
            }
            this.f219c = fragment;
        }
    }
}
