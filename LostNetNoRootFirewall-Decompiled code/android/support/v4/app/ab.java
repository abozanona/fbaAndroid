package android.support.v4.app;

import android.support.v4.p002c.C0038d;
import android.support.v4.p002c.C0045m;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class ab extends C0003z {
    static boolean f81a = false;
    final C0045m f82b = new C0045m();
    final C0045m f83c = new C0045m();
    final String f84d;
    C0012h f85e;
    boolean f86f;
    boolean f87g;

    ab(String str, C0012h c0012h, boolean z) {
        this.f84d = str;
        this.f85e = c0012h;
        this.f86f = z;
    }

    void m80a(C0012h c0012h) {
        this.f85e = c0012h;
    }

    public void m81a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f82b.m316b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f82b.m316b(); i2++) {
                ac acVar = (ac) this.f82b.m317b(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f82b.m314a(i2));
                printWriter.print(": ");
                printWriter.println(acVar.toString());
                acVar.m92a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f83c.m316b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f83c.m316b()) {
                acVar = (ac) this.f83c.m317b(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f83c.m314a(i));
                printWriter.print(": ");
                printWriter.println(acVar.toString());
                acVar.m92a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean mo1a() {
        int b = this.f82b.m316b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            ac acVar = (ac) this.f82b.m317b(i);
            int i2 = (!acVar.f95h || acVar.f93f) ? 0 : 1;
            z |= i2;
        }
        return z;
    }

    void m83b() {
        if (f81a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f86f) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f86f = true;
        for (int b = this.f82b.m316b() - 1; b >= 0; b--) {
            ((ac) this.f82b.m317b(b)).m90a();
        }
    }

    void m84c() {
        if (f81a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f86f) {
            for (int b = this.f82b.m316b() - 1; b >= 0; b--) {
                ((ac) this.f82b.m317b(b)).m96e();
            }
            this.f86f = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m85d() {
        if (f81a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f86f) {
            this.f87g = true;
            this.f86f = false;
            for (int b = this.f82b.m316b() - 1; b >= 0; b--) {
                ((ac) this.f82b.m317b(b)).m93b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m86e() {
        if (this.f87g) {
            if (f81a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f87g = false;
            for (int b = this.f82b.m316b() - 1; b >= 0; b--) {
                ((ac) this.f82b.m317b(b)).m94c();
            }
        }
    }

    void m87f() {
        for (int b = this.f82b.m316b() - 1; b >= 0; b--) {
            ((ac) this.f82b.m317b(b)).f98k = true;
        }
    }

    void m88g() {
        for (int b = this.f82b.m316b() - 1; b >= 0; b--) {
            ((ac) this.f82b.m317b(b)).m95d();
        }
    }

    void m89h() {
        int b;
        if (!this.f87g) {
            if (f81a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f82b.m316b() - 1; b >= 0; b--) {
                ((ac) this.f82b.m317b(b)).m97f();
            }
            this.f82b.m318c();
        }
        if (f81a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f83c.m316b() - 1; b >= 0; b--) {
            ((ac) this.f83c.m317b(b)).m97f();
        }
        this.f83c.m318c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0038d.m309a(this.f85e, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
