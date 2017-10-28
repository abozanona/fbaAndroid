package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p002c.C0033l;
import android.support.v4.p002c.C0038d;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final C0033l f17P = new C0033l();
    boolean f18A;
    boolean f19B;
    boolean f20C;
    boolean f21D;
    boolean f22E = true;
    boolean f23F;
    int f24G;
    ViewGroup f25H;
    View f26I;
    View f27J;
    boolean f28K;
    boolean f29L = true;
    ab f30M;
    boolean f31N;
    boolean f32O;
    int f33a = 0;
    View f34b;
    int f35c;
    Bundle f36d;
    SparseArray f37e;
    int f38f = -1;
    String f39g;
    Bundle f40h;
    Fragment f41i;
    int f42j = -1;
    int f43k;
    boolean f44l;
    boolean f45m;
    boolean f46n;
    boolean f47o;
    boolean f48p;
    boolean f49q;
    int f50r;
    C0019p f51s;
    C0012h f52t;
    C0019p f53u;
    Fragment f54v;
    int f55w;
    int f56x;
    String f57y;
    boolean f58z;

    public class SavedState implements Parcelable {
        public static final Creator CREATOR = new C0011g();
        final Bundle f16a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.f16a = parcel.readBundle();
            if (classLoader != null && this.f16a != null) {
                this.f16a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f16a);
        }
    }

    public static Fragment m11a(Context context, String str) {
        return m12a(context, str, null);
    }

    public static Fragment m12a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) f17P.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f17P.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.f40h = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new C0010f("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new C0010f("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new C0010f("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean m13b(Context context, String str) {
        try {
            Class cls = (Class) f17P.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f17P.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public View mo749a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation m15a(int i, boolean z, int i2) {
        return null;
    }

    public void m16a(int i, int i2, Intent intent) {
    }

    final void m17a(int i, Fragment fragment) {
        this.f38f = i;
        if (fragment != null) {
            this.f39g = fragment.f39g + ":" + this.f38f;
        } else {
            this.f39g = "android:fragment:" + this.f38f;
        }
    }

    public void m18a(Activity activity) {
        this.f23F = true;
    }

    public void m19a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f23F = true;
    }

    public void m20a(Intent intent) {
        if (this.f52t == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f52t.m149a(this, intent, -1);
    }

    void m21a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f53u != null) {
            this.f53u.m177a(configuration);
        }
    }

    final void m22a(Bundle bundle) {
        if (this.f37e != null) {
            this.f27J.restoreHierarchyState(this.f37e);
            this.f37e = null;
        }
        this.f23F = false;
        m46e(bundle);
        if (!this.f23F) {
            throw new at("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void m23a(Menu menu) {
    }

    public void m24a(Menu menu, MenuInflater menuInflater) {
    }

    public void m25a(View view, Bundle bundle) {
    }

    public void m26a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f55w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f56x));
        printWriter.print(" mTag=");
        printWriter.println(this.f57y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f33a);
        printWriter.print(" mIndex=");
        printWriter.print(this.f38f);
        printWriter.print(" mWho=");
        printWriter.print(this.f39g);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f50r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f44l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f45m);
        printWriter.print(" mResumed=");
        printWriter.print(this.f46n);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f47o);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f48p);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f58z);
        printWriter.print(" mDetached=");
        printWriter.print(this.f18A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f22E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f21D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f19B);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f20C);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f29L);
        if (this.f51s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f51s);
        }
        if (this.f52t != null) {
            printWriter.print(str);
            printWriter.print("mActivity=");
            printWriter.println(this.f52t);
        }
        if (this.f54v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f54v);
        }
        if (this.f40h != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f40h);
        }
        if (this.f36d != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f36d);
        }
        if (this.f37e != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f37e);
        }
        if (this.f41i != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f41i);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f43k);
        }
        if (this.f24G != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f24G);
        }
        if (this.f25H != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f25H);
        }
        if (this.f26I != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f26I);
        }
        if (this.f27J != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f26I);
        }
        if (this.f34b != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f34b);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f35c);
        }
        if (this.f30M != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f30M.m81a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f53u != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f53u + ":");
            this.f53u.m186a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void m27a(boolean z) {
    }

    final boolean m28a() {
        return this.f50r > 0;
    }

    public boolean m29a(MenuItem menuItem) {
        return false;
    }

    public final C0012h m30b() {
        return this.f52t;
    }

    public LayoutInflater m31b(Bundle bundle) {
        return this.f52t.getLayoutInflater();
    }

    View m32b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f53u != null) {
            this.f53u.m211i();
        }
        return mo749a(layoutInflater, viewGroup, bundle);
    }

    public void m33b(Menu menu) {
    }

    public void m34b(boolean z) {
        if (this.f22E != z) {
            this.f22E = z;
            if (this.f21D && m44d() && !m51g()) {
                this.f52t.m154c();
            }
        }
    }

    boolean m35b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f58z) {
            return false;
        }
        if (this.f21D && this.f22E) {
            z = true;
            m24a(menu, menuInflater);
        }
        return this.f53u != null ? z | this.f53u.m189a(menu, menuInflater) : z;
    }

    public boolean m36b(MenuItem menuItem) {
        return false;
    }

    public final Resources m37c() {
        if (this.f52t != null) {
            return this.f52t.getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void m38c(Bundle bundle) {
        this.f23F = true;
    }

    public void m39c(boolean z) {
        if (!this.f29L && z && this.f33a < 4) {
            this.f51s.m180a(this);
        }
        this.f29L = z;
        this.f28K = !z;
    }

    boolean m40c(Menu menu) {
        boolean z = false;
        if (this.f58z) {
            return false;
        }
        if (this.f21D && this.f22E) {
            z = true;
            m23a(menu);
        }
        return this.f53u != null ? z | this.f53u.m188a(menu) : z;
    }

    boolean m41c(MenuItem menuItem) {
        if (!this.f58z) {
            if (this.f21D && this.f22E && m29a(menuItem)) {
                return true;
            }
            if (this.f53u != null && this.f53u.m190a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m42d(Bundle bundle) {
        this.f23F = true;
    }

    void m43d(Menu menu) {
        if (!this.f58z) {
            if (this.f21D && this.f22E) {
                m33b(menu);
            }
            if (this.f53u != null) {
                this.f53u.m195b(menu);
            }
        }
    }

    public final boolean m44d() {
        return this.f52t != null && this.f44l;
    }

    boolean m45d(MenuItem menuItem) {
        if (!this.f58z) {
            if (m36b(menuItem)) {
                return true;
            }
            if (this.f53u != null && this.f53u.m197b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m46e(Bundle bundle) {
        this.f23F = true;
    }

    public final boolean m47e() {
        return this.f18A;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void m48f(Bundle bundle) {
    }

    public final boolean m49f() {
        return (!m44d() || m51g() || this.f26I == null || this.f26I.getWindowToken() == null || this.f26I.getVisibility() != 0) ? false : true;
    }

    void m50g(Bundle bundle) {
        if (this.f53u != null) {
            this.f53u.m211i();
        }
        this.f23F = false;
        m38c(bundle);
        if (!this.f23F) {
            throw new at("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.f53u == null) {
                    m64r();
                }
                this.f53u.m179a(parcelable, null);
                this.f53u.m212j();
            }
        }
    }

    public final boolean m51g() {
        return this.f58z;
    }

    public View m52h() {
        return this.f26I;
    }

    void m53h(Bundle bundle) {
        if (this.f53u != null) {
            this.f53u.m211i();
        }
        this.f23F = false;
        m42d(bundle);
        if (!this.f23F) {
            throw new at("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f53u != null) {
            this.f53u.m213k();
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void m54i() {
        this.f23F = true;
        if (!this.f31N) {
            this.f31N = true;
            if (!this.f32O) {
                this.f32O = true;
                this.f30M = this.f52t.m146a(this.f39g, this.f31N, false);
            }
            if (this.f30M != null) {
                this.f30M.m83b();
            }
        }
    }

    void m55i(Bundle bundle) {
        m48f(bundle);
        if (this.f53u != null) {
            Parcelable h = this.f53u.m210h();
            if (h != null) {
                bundle.putParcelable("android:support:fragments", h);
            }
        }
    }

    public void mo748j() {
        this.f23F = true;
    }

    public void m57k() {
        this.f23F = true;
    }

    public void m58l() {
        this.f23F = true;
    }

    public void m59m() {
        this.f23F = true;
    }

    public void m60n() {
        this.f23F = true;
        if (!this.f32O) {
            this.f32O = true;
            this.f30M = this.f52t.m146a(this.f39g, this.f31N, false);
        }
        if (this.f30M != null) {
            this.f30M.m89h();
        }
    }

    void m61o() {
        this.f38f = -1;
        this.f39g = null;
        this.f44l = false;
        this.f45m = false;
        this.f46n = false;
        this.f47o = false;
        this.f48p = false;
        this.f49q = false;
        this.f50r = 0;
        this.f51s = null;
        this.f52t = null;
        this.f55w = 0;
        this.f56x = 0;
        this.f57y = null;
        this.f58z = false;
        this.f18A = false;
        this.f20C = false;
        this.f30M = null;
        this.f31N = false;
        this.f32O = false;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f23F = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        m30b().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.f23F = true;
    }

    public void m62p() {
        this.f23F = true;
    }

    public void m63q() {
    }

    void m64r() {
        this.f53u = new C0019p();
        this.f53u.m184a(this.f52t, new C0009e(this), this);
    }

    void m65s() {
        if (this.f53u != null) {
            this.f53u.m211i();
            this.f53u.m206e();
        }
        this.f23F = false;
        m54i();
        if (this.f23F) {
            if (this.f53u != null) {
                this.f53u.m214l();
            }
            if (this.f30M != null) {
                this.f30M.m88g();
                return;
            }
            return;
        }
        throw new at("Fragment " + this + " did not call through to super.onStart()");
    }

    void m66t() {
        if (this.f53u != null) {
            this.f53u.m211i();
            this.f53u.m206e();
        }
        this.f23F = false;
        mo748j();
        if (!this.f23F) {
            throw new at("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f53u != null) {
            this.f53u.m215m();
            this.f53u.m206e();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0038d.m309a(this, stringBuilder);
        if (this.f38f >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f38f);
        }
        if (this.f55w != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f55w));
        }
        if (this.f57y != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f57y);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    void m67u() {
        onLowMemory();
        if (this.f53u != null) {
            this.f53u.m221s();
        }
    }

    void m68v() {
        if (this.f53u != null) {
            this.f53u.m216n();
        }
        this.f23F = false;
        m57k();
        if (!this.f23F) {
            throw new at("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void m69w() {
        if (this.f53u != null) {
            this.f53u.m217o();
        }
        this.f23F = false;
        m58l();
        if (!this.f23F) {
            throw new at("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void m70x() {
        if (this.f53u != null) {
            this.f53u.m218p();
        }
        if (this.f31N) {
            this.f31N = false;
            if (!this.f32O) {
                this.f32O = true;
                this.f30M = this.f52t.m146a(this.f39g, this.f31N, false);
            }
            if (this.f30M == null) {
                return;
            }
            if (this.f52t.f170h) {
                this.f30M.m85d();
            } else {
                this.f30M.m84c();
            }
        }
    }

    void m71y() {
        if (this.f53u != null) {
            this.f53u.m219q();
        }
        this.f23F = false;
        m59m();
        if (!this.f23F) {
            throw new at("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f30M != null) {
            this.f30M.m87f();
        }
    }

    void m72z() {
        if (this.f53u != null) {
            this.f53u.m220r();
        }
        this.f23F = false;
        m60n();
        if (!this.f23F) {
            throw new at("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }
}
