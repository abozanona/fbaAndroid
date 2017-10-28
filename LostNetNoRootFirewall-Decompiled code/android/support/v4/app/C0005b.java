package android.support.v4.app;

import android.support.v4.p002c.C0039e;
import android.util.Log;
import com.google.android.vending.licensing.APKExpansionPolicy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class C0005b extends C0004y implements Runnable {
    final C0019p f134a;
    C0006c f135b;
    C0006c f136c;
    int f137d;
    int f138e;
    int f139f;
    int f140g;
    int f141h;
    int f142i;
    int f143j;
    boolean f144k;
    boolean f145l = true;
    String f146m;
    boolean f147n;
    int f148o = -1;
    int f149p;
    CharSequence f150q;
    int f151r;
    CharSequence f152s;

    public C0005b(C0019p c0019p) {
        this.f134a = c0019p;
    }

    private void m125a(int i, Fragment fragment, String str, int i2) {
        fragment.f51s = this.f134a;
        if (str != null) {
            if (fragment.f57y == null || str.equals(fragment.f57y)) {
                fragment.f57y = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f57y + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.f55w == 0 || fragment.f55w == i) {
                fragment.f55w = i;
                fragment.f56x = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f55w + " now " + i);
            }
        }
        C0006c c0006c = new C0006c();
        c0006c.f155c = i2;
        c0006c.f156d = fragment;
        m131a(c0006c);
    }

    public int mo3a() {
        return m127a(false);
    }

    int m127a(boolean z) {
        if (this.f147n) {
            throw new IllegalStateException("commit already called");
        }
        if (C0019p.f187a) {
            Log.v("FragmentManager", "Commit: " + this);
            m132a("  ", null, new PrintWriter(new C0039e("FragmentManager")), null);
        }
        this.f147n = true;
        if (this.f144k) {
            this.f148o = this.f134a.m168a(this);
        } else {
            this.f148o = -1;
        }
        this.f134a.m185a((Runnable) this, z);
        return this.f148o;
    }

    public C0004y mo4a(int i, Fragment fragment, String str) {
        m125a(i, fragment, str, 1);
        return this;
    }

    public C0004y mo5a(Fragment fragment) {
        C0006c c0006c = new C0006c();
        c0006c.f155c = 6;
        c0006c.f156d = fragment;
        m131a(c0006c);
        return this;
    }

    void m130a(int i) {
        if (this.f144k) {
            if (C0019p.f187a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0006c c0006c = this.f135b; c0006c != null; c0006c = c0006c.f153a) {
                Fragment fragment;
                if (c0006c.f156d != null) {
                    fragment = c0006c.f156d;
                    fragment.f50r += i;
                    if (C0019p.f187a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0006c.f156d + " to " + c0006c.f156d.f50r);
                    }
                }
                if (c0006c.f161i != null) {
                    for (int size = c0006c.f161i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) c0006c.f161i.get(size);
                        fragment.f50r += i;
                        if (C0019p.f187a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f50r);
                        }
                    }
                }
            }
        }
    }

    void m131a(C0006c c0006c) {
        if (this.f135b == null) {
            this.f136c = c0006c;
            this.f135b = c0006c;
        } else {
            c0006c.f154b = this.f136c;
            this.f136c.f153a = c0006c;
            this.f136c = c0006c;
        }
        c0006c.f157e = this.f138e;
        c0006c.f158f = this.f139f;
        c0006c.f159g = this.f140g;
        c0006c.f160h = this.f141h;
        this.f137d++;
    }

    public void m132a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m133a(str, printWriter, true);
    }

    public void m133a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f146m);
            printWriter.print(" mIndex=");
            printWriter.print(this.f148o);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f147n);
            if (this.f142i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f142i));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f143j));
            }
            if (!(this.f138e == 0 && this.f139f == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f138e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f139f));
            }
            if (!(this.f140g == 0 && this.f141h == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f140g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f141h));
            }
            if (!(this.f149p == 0 && this.f150q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f149p));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f150q);
            }
            if (!(this.f151r == 0 && this.f152s == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f151r));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f152s);
            }
        }
        if (this.f135b != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            C0006c c0006c = this.f135b;
            while (c0006c != null) {
                String str3;
                switch (c0006c.f155c) {
                    case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + c0006c.f155c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(c0006c.f156d);
                if (z) {
                    if (!(c0006c.f157e == 0 && c0006c.f158f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0006c.f157e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0006c.f158f));
                    }
                    if (!(c0006c.f159g == 0 && c0006c.f160h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0006c.f159g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0006c.f160h));
                    }
                }
                if (c0006c.f161i != null && c0006c.f161i.size() > 0) {
                    for (int i2 = 0; i2 < c0006c.f161i.size(); i2++) {
                        printWriter.print(str2);
                        if (c0006c.f161i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0006c.f161i.get(i2));
                    }
                }
                c0006c = c0006c.f153a;
                i++;
            }
        }
    }

    public int mo6b() {
        return m127a(true);
    }

    public C0004y mo7b(Fragment fragment) {
        C0006c c0006c = new C0006c();
        c0006c.f155c = 7;
        c0006c.f156d = fragment;
        m131a(c0006c);
        return this;
    }

    public void m136b(boolean z) {
        if (C0019p.f187a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m132a("  ", null, new PrintWriter(new C0039e("FragmentManager")), null);
        }
        m130a(-1);
        for (C0006c c0006c = this.f136c; c0006c != null; c0006c = c0006c.f154b) {
            Fragment fragment;
            switch (c0006c.f155c) {
                case 1:
                    fragment = c0006c.f156d;
                    fragment.f24G = c0006c.f160h;
                    this.f134a.m181a(fragment, C0019p.m166c(this.f142i), this.f143j);
                    break;
                case 2:
                    fragment = c0006c.f156d;
                    if (fragment != null) {
                        fragment.f24G = c0006c.f160h;
                        this.f134a.m181a(fragment, C0019p.m166c(this.f142i), this.f143j);
                    }
                    if (c0006c.f161i == null) {
                        break;
                    }
                    for (int i = 0; i < c0006c.f161i.size(); i++) {
                        fragment = (Fragment) c0006c.f161i.get(i);
                        fragment.f24G = c0006c.f159g;
                        this.f134a.m183a(fragment, false);
                    }
                    break;
                case 3:
                    fragment = c0006c.f156d;
                    fragment.f24G = c0006c.f159g;
                    this.f134a.m183a(fragment, false);
                    break;
                case 4:
                    fragment = c0006c.f156d;
                    fragment.f24G = c0006c.f159g;
                    this.f134a.m199c(fragment, C0019p.m166c(this.f142i), this.f143j);
                    break;
                case 5:
                    fragment = c0006c.f156d;
                    fragment.f24G = c0006c.f160h;
                    this.f134a.m193b(fragment, C0019p.m166c(this.f142i), this.f143j);
                    break;
                case 6:
                    fragment = c0006c.f156d;
                    fragment.f24G = c0006c.f159g;
                    this.f134a.m205e(fragment, C0019p.m166c(this.f142i), this.f143j);
                    break;
                case 7:
                    fragment = c0006c.f156d;
                    fragment.f24G = c0006c.f159g;
                    this.f134a.m203d(fragment, C0019p.m166c(this.f142i), this.f143j);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0006c.f155c);
            }
        }
        if (z) {
            this.f134a.m174a(this.f134a.f201n, C0019p.m166c(this.f142i), this.f143j, true);
        }
        if (this.f148o >= 0) {
            this.f134a.m191b(this.f148o);
            this.f148o = -1;
        }
    }

    public String m137c() {
        return this.f146m;
    }

    public void run() {
        if (C0019p.f187a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f144k || this.f148o >= 0) {
            m130a(1);
            for (C0006c c0006c = this.f135b; c0006c != null; c0006c = c0006c.f153a) {
                Fragment fragment;
                switch (c0006c.f155c) {
                    case 1:
                        fragment = c0006c.f156d;
                        fragment.f24G = c0006c.f157e;
                        this.f134a.m183a(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2;
                        fragment = c0006c.f156d;
                        if (this.f134a.f194g != null) {
                            fragment2 = fragment;
                            for (int i = 0; i < this.f134a.f194g.size(); i++) {
                                fragment = (Fragment) this.f134a.f194g.get(i);
                                if (C0019p.f187a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment2 == null || fragment.f56x == fragment2.f56x) {
                                    if (fragment == fragment2) {
                                        fragment2 = null;
                                        c0006c.f156d = null;
                                    } else {
                                        if (c0006c.f161i == null) {
                                            c0006c.f161i = new ArrayList();
                                        }
                                        c0006c.f161i.add(fragment);
                                        fragment.f24G = c0006c.f158f;
                                        if (this.f144k) {
                                            fragment.f50r++;
                                            if (C0019p.f187a) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f50r);
                                            }
                                        }
                                        this.f134a.m181a(fragment, this.f142i, this.f143j);
                                    }
                                }
                            }
                        } else {
                            fragment2 = fragment;
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.f24G = c0006c.f157e;
                        this.f134a.m183a(fragment2, false);
                        break;
                    case 3:
                        fragment = c0006c.f156d;
                        fragment.f24G = c0006c.f158f;
                        this.f134a.m181a(fragment, this.f142i, this.f143j);
                        break;
                    case 4:
                        fragment = c0006c.f156d;
                        fragment.f24G = c0006c.f158f;
                        this.f134a.m193b(fragment, this.f142i, this.f143j);
                        break;
                    case 5:
                        fragment = c0006c.f156d;
                        fragment.f24G = c0006c.f157e;
                        this.f134a.m199c(fragment, this.f142i, this.f143j);
                        break;
                    case 6:
                        fragment = c0006c.f156d;
                        fragment.f24G = c0006c.f158f;
                        this.f134a.m203d(fragment, this.f142i, this.f143j);
                        break;
                    case 7:
                        fragment = c0006c.f156d;
                        fragment.f24G = c0006c.f157e;
                        this.f134a.m205e(fragment, this.f142i, this.f143j);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0006c.f155c);
                }
            }
            this.f134a.m174a(this.f134a.f201n, this.f142i, this.f143j, true);
            if (this.f144k) {
                this.f134a.m194b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f148o >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f148o);
        }
        if (this.f146m != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f146m);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
