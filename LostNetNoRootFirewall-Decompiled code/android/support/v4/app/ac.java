package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.p000a.C0000a;
import android.support.v4.p000a.C0001b;
import android.support.v4.p002c.C0038d;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class ac implements C0001b {
    final int f88a;
    final Bundle f89b;
    aa f90c;
    C0000a f91d;
    boolean f92e;
    boolean f93f;
    Object f94g;
    boolean f95h;
    boolean f96i;
    boolean f97j;
    boolean f98k;
    boolean f99l;
    boolean f100m;
    ac f101n;
    final /* synthetic */ ab f102o;

    void m90a() {
        if (this.f96i && this.f97j) {
            this.f95h = true;
        } else if (!this.f95h) {
            this.f95h = true;
            if (ab.f81a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (this.f91d == null && this.f90c != null) {
                this.f91d = this.f90c.m76a(this.f88a, this.f89b);
            }
            if (this.f91d == null) {
                return;
            }
            if (!this.f91d.getClass().isMemberClass() || Modifier.isStatic(this.f91d.getClass().getModifiers())) {
                if (!this.f100m) {
                    this.f91d.m2a(this.f88a, this);
                    this.f100m = true;
                }
                this.f91d.m1a();
                return;
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f91d);
        }
    }

    void m91a(C0000a c0000a, Object obj) {
        String str;
        if (this.f90c != null) {
            if (this.f102o.f85e != null) {
                String str2 = this.f102o.f85e.f164b.f208u;
                this.f102o.f85e.f164b.f208u = "onLoadFinished";
                str = str2;
            } else {
                str = null;
            }
            try {
                if (ab.f81a) {
                    Log.v("LoaderManager", "  onLoadFinished in " + c0000a + ": " + c0000a.m0a(obj));
                }
                this.f90c.m78a(c0000a, obj);
                this.f93f = true;
            } finally {
                if (this.f102o.f85e != null) {
                    this.f102o.f85e.f164b.f208u = str;
                }
            }
        }
    }

    public void m92a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f88a);
        printWriter.print(" mArgs=");
        printWriter.println(this.f89b);
        printWriter.print(str);
        printWriter.print("mCallbacks=");
        printWriter.println(this.f90c);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.f91d);
        if (this.f91d != null) {
            this.f91d.m4a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f92e || this.f93f) {
            printWriter.print(str);
            printWriter.print("mHaveData=");
            printWriter.print(this.f92e);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.f93f);
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.f94g);
        }
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.f95h);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.f98k);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f99l);
        printWriter.print(str);
        printWriter.print("mRetaining=");
        printWriter.print(this.f96i);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.f97j);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.f100m);
        if (this.f101n != null) {
            printWriter.print(str);
            printWriter.println("Pending Loader ");
            printWriter.print(this.f101n);
            printWriter.println(":");
            this.f101n.m92a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    void m93b() {
        if (ab.f81a) {
            Log.v("LoaderManager", "  Retaining: " + this);
        }
        this.f96i = true;
        this.f97j = this.f95h;
        this.f95h = false;
        this.f90c = null;
    }

    void m94c() {
        if (this.f96i) {
            if (ab.f81a) {
                Log.v("LoaderManager", "  Finished Retaining: " + this);
            }
            this.f96i = false;
            if (!(this.f95h == this.f97j || this.f95h)) {
                m96e();
            }
        }
        if (this.f95h && this.f92e && !this.f98k) {
            m91a(this.f91d, this.f94g);
        }
    }

    void m95d() {
        if (this.f95h && this.f98k) {
            this.f98k = false;
            if (this.f92e) {
                m91a(this.f91d, this.f94g);
            }
        }
    }

    void m96e() {
        if (ab.f81a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.f95h = false;
        if (!this.f96i && this.f91d != null && this.f100m) {
            this.f100m = false;
            this.f91d.m3a((C0001b) this);
            this.f91d.m6c();
        }
    }

    void m97f() {
        String str;
        aa aaVar = null;
        if (ab.f81a) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.f99l = true;
        boolean z = this.f93f;
        this.f93f = false;
        if (this.f90c != null && this.f91d != null && this.f92e && z) {
            if (ab.f81a) {
                Log.v("LoaderManager", "  Reseting: " + this);
            }
            if (this.f102o.f85e != null) {
                String str2 = this.f102o.f85e.f164b.f208u;
                this.f102o.f85e.f164b.f208u = "onLoaderReset";
                str = str2;
            } else {
                str = null;
            }
            try {
                this.f90c.m77a(this.f91d);
            } finally {
                aaVar = this.f102o.f85e;
                if (aaVar != null) {
                    aaVar = this.f102o.f85e.f164b;
                    aaVar.f208u = str;
                }
            }
        }
        this.f90c = aaVar;
        this.f94g = aaVar;
        this.f92e = false;
        if (this.f91d != null) {
            if (this.f100m) {
                this.f100m = false;
                this.f91d.m3a((C0001b) this);
            }
            this.f91d.m8e();
        }
        if (this.f101n != null) {
            this.f101n.m97f();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.f88a);
        stringBuilder.append(" : ");
        C0038d.m309a(this.f91d, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
