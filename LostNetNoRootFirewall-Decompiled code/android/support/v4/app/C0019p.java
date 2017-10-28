package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.p002c.C0038d;
import android.support.v4.p002c.C0039e;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

final class C0019p extends C0017n {
    static final Interpolator f184A = new DecelerateInterpolator(1.5f);
    static final Interpolator f185B = new AccelerateInterpolator(2.5f);
    static final Interpolator f186C = new AccelerateInterpolator(1.5f);
    static boolean f187a = false;
    static final boolean f188b;
    static final Interpolator f189z = new DecelerateInterpolator(2.5f);
    ArrayList f190c;
    Runnable[] f191d;
    boolean f192e;
    ArrayList f193f;
    ArrayList f194g;
    ArrayList f195h;
    ArrayList f196i;
    ArrayList f197j;
    ArrayList f198k;
    ArrayList f199l;
    ArrayList f200m;
    int f201n = 0;
    C0012h f202o;
    C0008m f203p;
    Fragment f204q;
    boolean f205r;
    boolean f206s;
    boolean f207t;
    String f208u;
    boolean f209v;
    Bundle f210w = null;
    SparseArray f211x = null;
    Runnable f212y = new C0020q(this);

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f188b = z;
    }

    C0019p() {
    }

    static Animation m162a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f184A);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    static Animation m163a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f189z);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f184A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private void m164a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0039e("FragmentManager"));
        if (this.f202o != null) {
            try {
                this.f202o.dump("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                m186a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public static int m165b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public static int m166c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private void m167t() {
        if (this.f206s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f208u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f208u);
        }
    }

    public int m168a(C0005b c0005b) {
        int size;
        synchronized (this) {
            if (this.f199l == null || this.f199l.size() <= 0) {
                if (this.f198k == null) {
                    this.f198k = new ArrayList();
                }
                size = this.f198k.size();
                if (f187a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0005b);
                }
                this.f198k.add(c0005b);
            } else {
                size = ((Integer) this.f199l.remove(this.f199l.size() - 1)).intValue();
                if (f187a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + c0005b);
                }
                this.f198k.set(size, c0005b);
            }
        }
        return size;
    }

    public Fragment m169a(int i) {
        int size;
        Fragment fragment;
        if (this.f194g != null) {
            for (size = this.f194g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f194g.get(size);
                if (fragment != null && fragment.f55w == i) {
                    return fragment;
                }
            }
        }
        if (this.f193f != null) {
            for (size = this.f193f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f193f.get(size);
                if (fragment != null && fragment.f55w == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment m170a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f193f.size()) {
            m164a(new IllegalStateException("Fragement no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.f193f.get(i);
        if (fragment != null) {
            return fragment;
        }
        m164a(new IllegalStateException("Fragement no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public Fragment mo9a(String str) {
        int size;
        Fragment fragment;
        if (!(this.f194g == null || str == null)) {
            for (size = this.f194g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f194g.get(size);
                if (fragment != null && str.equals(fragment.f57y)) {
                    return fragment;
                }
            }
        }
        if (!(this.f193f == null || str == null)) {
            for (size = this.f193f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f193f.get(size);
                if (fragment != null && str.equals(fragment.f57y)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public C0004y mo10a() {
        return new C0005b(this);
    }

    Animation m173a(Fragment fragment, int i, boolean z, int i2) {
        Animation a = fragment.m15a(i, z, fragment.f24G);
        if (a != null) {
            return a;
        }
        if (fragment.f24G != 0) {
            a = AnimationUtils.loadAnimation(this.f202o, fragment.f24G);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = C0019p.m165b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return C0019p.m163a(this.f202o, 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return C0019p.m163a(this.f202o, 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return C0019p.m163a(this.f202o, 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return C0019p.m163a(this.f202o, 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return C0019p.m162a(this.f202o, 0.0f, 1.0f);
            case 6:
                return C0019p.m162a(this.f202o, 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f202o.getWindow() != null) {
                    i2 = this.f202o.getWindow().getAttributes().windowAnimations;
                }
                return i2 == 0 ? null : null;
        }
    }

    void m174a(int i, int i2, int i3, boolean z) {
        if (this.f202o == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || this.f201n != i) {
            this.f201n = i;
            if (this.f193f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f193f.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.f193f.get(i4);
                    if (fragment != null) {
                        m182a(fragment, i, i2, i3, false);
                        if (fragment.f30M != null) {
                            a = i5 | fragment.f30M.mo1a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m201d();
                }
                if (this.f205r && this.f202o != null && this.f201n == 5) {
                    this.f202o.m154c();
                    this.f205r = false;
                }
            }
        }
    }

    public void m175a(int i, C0005b c0005b) {
        synchronized (this) {
            if (this.f198k == null) {
                this.f198k = new ArrayList();
            }
            int size = this.f198k.size();
            if (i < size) {
                if (f187a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0005b);
                }
                this.f198k.set(i, c0005b);
            } else {
                while (size < i) {
                    this.f198k.add(null);
                    if (this.f199l == null) {
                        this.f199l = new ArrayList();
                    }
                    if (f187a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f199l.add(Integer.valueOf(size));
                    size++;
                }
                if (f187a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0005b);
                }
                this.f198k.add(c0005b);
            }
        }
    }

    void m176a(int i, boolean z) {
        m174a(i, 0, 0, z);
    }

    public void m177a(Configuration configuration) {
        if (this.f194g != null) {
            for (int i = 0; i < this.f194g.size(); i++) {
                Fragment fragment = (Fragment) this.f194g.get(i);
                if (fragment != null) {
                    fragment.m21a(configuration);
                }
            }
        }
    }

    public void m178a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f38f < 0) {
            m164a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.f38f);
    }

    void m179a(Parcelable parcelable, ArrayList arrayList) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f59a != null) {
                int i;
                Fragment fragment;
                int i2;
                if (arrayList != null) {
                    for (i = 0; i < arrayList.size(); i++) {
                        fragment = (Fragment) arrayList.get(i);
                        if (f187a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f59a[fragment.f38f];
                        fragmentState.f72k = fragment;
                        fragment.f37e = null;
                        fragment.f50r = 0;
                        fragment.f48p = false;
                        fragment.f44l = false;
                        fragment.f41i = null;
                        if (fragmentState.f71j != null) {
                            fragmentState.f71j.setClassLoader(this.f202o.getClassLoader());
                            fragment.f37e = fragmentState.f71j.getSparseParcelableArray("android:view_state");
                        }
                    }
                }
                this.f193f = new ArrayList(fragmentManagerState.f59a.length);
                if (this.f195h != null) {
                    this.f195h.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.f59a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.f59a[i2];
                    if (fragmentState2 != null) {
                        Fragment a = fragmentState2.m73a(this.f202o, this.f204q);
                        if (f187a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a);
                        }
                        this.f193f.add(a);
                        fragmentState2.f72k = null;
                    } else {
                        this.f193f.add(null);
                        if (this.f195h == null) {
                            this.f195h = new ArrayList();
                        }
                        if (f187a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f195h.add(Integer.valueOf(i2));
                    }
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        fragment = (Fragment) arrayList.get(i3);
                        if (fragment.f42j >= 0) {
                            if (fragment.f42j < this.f193f.size()) {
                                fragment.f41i = (Fragment) this.f193f.get(fragment.f42j);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.f42j);
                                fragment.f41i = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.f60b != null) {
                    this.f194g = new ArrayList(fragmentManagerState.f60b.length);
                    for (i = 0; i < fragmentManagerState.f60b.length; i++) {
                        fragment = (Fragment) this.f193f.get(fragmentManagerState.f60b[i]);
                        if (fragment == null) {
                            m164a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f60b[i]));
                        }
                        fragment.f44l = true;
                        if (f187a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + fragment);
                        }
                        if (this.f194g.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f194g.add(fragment);
                    }
                } else {
                    this.f194g = null;
                }
                if (fragmentManagerState.f61c != null) {
                    this.f196i = new ArrayList(fragmentManagerState.f61c.length);
                    for (i2 = 0; i2 < fragmentManagerState.f61c.length; i2++) {
                        C0005b a2 = fragmentManagerState.f61c[i2].m10a(this);
                        if (f187a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a2.f148o + "): " + a2);
                            a2.m133a("  ", new PrintWriter(new C0039e("FragmentManager")), false);
                        }
                        this.f196i.add(a2);
                        if (a2.f148o >= 0) {
                            m175a(a2.f148o, a2);
                        }
                    }
                    return;
                }
                this.f196i = null;
            }
        }
    }

    public void m180a(Fragment fragment) {
        if (!fragment.f28K) {
            return;
        }
        if (this.f192e) {
            this.f209v = true;
            return;
        }
        fragment.f28K = false;
        m182a(fragment, this.f201n, 0, 0, false);
    }

    public void m181a(Fragment fragment, int i, int i2) {
        if (f187a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f50r);
        }
        boolean z = !fragment.m28a();
        if (!fragment.f18A || z) {
            if (this.f194g != null) {
                this.f194g.remove(fragment);
            }
            if (fragment.f21D && fragment.f22E) {
                this.f205r = true;
            }
            fragment.f44l = false;
            fragment.f45m = true;
            m182a(fragment, z ? 0 : 1, i, i2, false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m182a(android.support.v4.app.Fragment r10, int r11, int r12, int r13, boolean r14) {
        /*
        r9 = this;
        r8 = 4;
        r6 = 3;
        r3 = 0;
        r5 = 1;
        r7 = 0;
        r0 = r10.f44l;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r10.f18A;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r11 <= r5) goto L_0x0010;
    L_0x000f:
        r11 = r5;
    L_0x0010:
        r0 = r10.f45m;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r10.f33a;
        if (r11 <= r0) goto L_0x001a;
    L_0x0018:
        r11 = r10.f33a;
    L_0x001a:
        r0 = r10.f28K;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r10.f33a;
        if (r0 >= r8) goto L_0x0025;
    L_0x0022:
        if (r11 <= r6) goto L_0x0025;
    L_0x0024:
        r11 = r6;
    L_0x0025:
        r0 = r10.f33a;
        if (r0 >= r11) goto L_0x0240;
    L_0x0029:
        r0 = r10.f47o;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r10.f48p;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r10.f34b;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r10.f34b = r7;
        r2 = r10.f35c;
        r0 = r9;
        r1 = r10;
        r4 = r3;
        r0.m182a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r10.f33a;
        switch(r0) {
            case 0: goto L_0x0048;
            case 1: goto L_0x0126;
            case 2: goto L_0x01ef;
            case 3: goto L_0x01ef;
            case 4: goto L_0x0210;
            default: goto L_0x0045;
        };
    L_0x0045:
        r10.f33a = r11;
        goto L_0x0031;
    L_0x0048:
        r0 = f187a;
        if (r0 == 0) goto L_0x0064;
    L_0x004c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0064:
        r0 = r10.f36d;
        if (r0 == 0) goto L_0x009d;
    L_0x0068:
        r0 = r10.f36d;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r10.f37e = r0;
        r0 = r10.f36d;
        r1 = "android:target_state";
        r0 = r9.m170a(r0, r1);
        r10.f41i = r0;
        r0 = r10.f41i;
        if (r0 == 0) goto L_0x008a;
    L_0x0080:
        r0 = r10.f36d;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r10.f43k = r0;
    L_0x008a:
        r0 = r10.f36d;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r10.f29L = r0;
        r0 = r10.f29L;
        if (r0 != 0) goto L_0x009d;
    L_0x0098:
        r10.f28K = r5;
        if (r11 <= r6) goto L_0x009d;
    L_0x009c:
        r11 = r6;
    L_0x009d:
        r0 = r9.f202o;
        r10.f52t = r0;
        r0 = r9.f204q;
        r10.f54v = r0;
        r0 = r9.f204q;
        if (r0 == 0) goto L_0x00d9;
    L_0x00a9:
        r0 = r9.f204q;
        r0 = r0.f53u;
    L_0x00ad:
        r10.f51s = r0;
        r10.f23F = r3;
        r0 = r9.f202o;
        r10.m18a(r0);
        r0 = r10.f23F;
        if (r0 != 0) goto L_0x00de;
    L_0x00ba:
        r0 = new android.support.v4.app.at;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00d9:
        r0 = r9.f202o;
        r0 = r0.f164b;
        goto L_0x00ad;
    L_0x00de:
        r0 = r10.f54v;
        if (r0 != 0) goto L_0x00e7;
    L_0x00e2:
        r0 = r9.f202o;
        r0.m148a(r10);
    L_0x00e7:
        r0 = r10.f20C;
        if (r0 != 0) goto L_0x00f0;
    L_0x00eb:
        r0 = r10.f36d;
        r10.m50g(r0);
    L_0x00f0:
        r10.f20C = r3;
        r0 = r10.f47o;
        if (r0 == 0) goto L_0x0126;
    L_0x00f6:
        r0 = r10.f36d;
        r0 = r10.m31b(r0);
        r1 = r10.f36d;
        r0 = r10.m32b(r0, r7, r1);
        r10.f26I = r0;
        r0 = r10.f26I;
        if (r0 == 0) goto L_0x0239;
    L_0x0108:
        r0 = r10.f26I;
        r10.f27J = r0;
        r0 = r10.f26I;
        r0 = android.support.v4.app.ad.m98a(r0);
        r10.f26I = r0;
        r0 = r10.f58z;
        if (r0 == 0) goto L_0x011f;
    L_0x0118:
        r0 = r10.f26I;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x011f:
        r0 = r10.f26I;
        r1 = r10.f36d;
        r10.m25a(r0, r1);
    L_0x0126:
        if (r11 <= r5) goto L_0x01ef;
    L_0x0128:
        r0 = f187a;
        if (r0 == 0) goto L_0x0144;
    L_0x012c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0144:
        r0 = r10.f47o;
        if (r0 != 0) goto L_0x01df;
    L_0x0148:
        r0 = r10.f56x;
        if (r0 == 0) goto L_0x0397;
    L_0x014c:
        r0 = r9.f203p;
        r1 = r10.f56x;
        r0 = r0.mo8a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x019b;
    L_0x0158:
        r1 = r10.f49q;
        if (r1 != 0) goto L_0x019b;
    L_0x015c:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "No view found for id 0x";
        r2 = r2.append(r3);
        r3 = r10.f56x;
        r3 = java.lang.Integer.toHexString(r3);
        r2 = r2.append(r3);
        r3 = " (";
        r2 = r2.append(r3);
        r3 = r10.m37c();
        r4 = r10.f56x;
        r3 = r3.getResourceName(r4);
        r2 = r2.append(r3);
        r3 = ") for fragment ";
        r2 = r2.append(r3);
        r2 = r2.append(r10);
        r2 = r2.toString();
        r1.<init>(r2);
        r9.m164a(r1);
    L_0x019b:
        r10.f25H = r0;
        r1 = r10.f36d;
        r1 = r10.m31b(r1);
        r2 = r10.f36d;
        r1 = r10.m32b(r1, r0, r2);
        r10.f26I = r1;
        r1 = r10.f26I;
        if (r1 == 0) goto L_0x023d;
    L_0x01af:
        r1 = r10.f26I;
        r10.f27J = r1;
        r1 = r10.f26I;
        r1 = android.support.v4.app.ad.m98a(r1);
        r10.f26I = r1;
        if (r0 == 0) goto L_0x01cd;
    L_0x01bd:
        r1 = r9.m173a(r10, r12, r5, r13);
        if (r1 == 0) goto L_0x01c8;
    L_0x01c3:
        r2 = r10.f26I;
        r2.startAnimation(r1);
    L_0x01c8:
        r1 = r10.f26I;
        r0.addView(r1);
    L_0x01cd:
        r0 = r10.f58z;
        if (r0 == 0) goto L_0x01d8;
    L_0x01d1:
        r0 = r10.f26I;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x01d8:
        r0 = r10.f26I;
        r1 = r10.f36d;
        r10.m25a(r0, r1);
    L_0x01df:
        r0 = r10.f36d;
        r10.m53h(r0);
        r0 = r10.f26I;
        if (r0 == 0) goto L_0x01ed;
    L_0x01e8:
        r0 = r10.f36d;
        r10.m22a(r0);
    L_0x01ed:
        r10.f36d = r7;
    L_0x01ef:
        if (r11 <= r6) goto L_0x0210;
    L_0x01f1:
        r0 = f187a;
        if (r0 == 0) goto L_0x020d;
    L_0x01f5:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x020d:
        r10.m65s();
    L_0x0210:
        if (r11 <= r8) goto L_0x0045;
    L_0x0212:
        r0 = f187a;
        if (r0 == 0) goto L_0x022e;
    L_0x0216:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x022e:
        r10.f46n = r5;
        r10.m66t();
        r10.f36d = r7;
        r10.f37e = r7;
        goto L_0x0045;
    L_0x0239:
        r10.f27J = r7;
        goto L_0x0126;
    L_0x023d:
        r10.f27J = r7;
        goto L_0x01df;
    L_0x0240:
        r0 = r10.f33a;
        if (r0 <= r11) goto L_0x0045;
    L_0x0244:
        r0 = r10.f33a;
        switch(r0) {
            case 1: goto L_0x024b;
            case 2: goto L_0x02cb;
            case 3: goto L_0x02aa;
            case 4: goto L_0x0289;
            case 5: goto L_0x0265;
            default: goto L_0x0249;
        };
    L_0x0249:
        goto L_0x0045;
    L_0x024b:
        if (r11 >= r5) goto L_0x0045;
    L_0x024d:
        r0 = r9.f207t;
        if (r0 == 0) goto L_0x025c;
    L_0x0251:
        r0 = r10.f34b;
        if (r0 == 0) goto L_0x025c;
    L_0x0255:
        r0 = r10.f34b;
        r10.f34b = r7;
        r0.clearAnimation();
    L_0x025c:
        r0 = r10.f34b;
        if (r0 == 0) goto L_0x0338;
    L_0x0260:
        r10.f35c = r11;
        r11 = r5;
        goto L_0x0045;
    L_0x0265:
        r0 = 5;
        if (r11 >= r0) goto L_0x0289;
    L_0x0268:
        r0 = f187a;
        if (r0 == 0) goto L_0x0284;
    L_0x026c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0284:
        r10.m68v();
        r10.f46n = r3;
    L_0x0289:
        if (r11 >= r8) goto L_0x02aa;
    L_0x028b:
        r0 = f187a;
        if (r0 == 0) goto L_0x02a7;
    L_0x028f:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02a7:
        r10.m69w();
    L_0x02aa:
        if (r11 >= r6) goto L_0x02cb;
    L_0x02ac:
        r0 = f187a;
        if (r0 == 0) goto L_0x02c8;
    L_0x02b0:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02c8:
        r10.m70x();
    L_0x02cb:
        r0 = 2;
        if (r11 >= r0) goto L_0x024b;
    L_0x02ce:
        r0 = f187a;
        if (r0 == 0) goto L_0x02ea;
    L_0x02d2:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02ea:
        r0 = r10.f26I;
        if (r0 == 0) goto L_0x02fd;
    L_0x02ee:
        r0 = r9.f202o;
        r0 = r0.isFinishing();
        if (r0 != 0) goto L_0x02fd;
    L_0x02f6:
        r0 = r10.f37e;
        if (r0 != 0) goto L_0x02fd;
    L_0x02fa:
        r9.m204e(r10);
    L_0x02fd:
        r10.m71y();
        r0 = r10.f26I;
        if (r0 == 0) goto L_0x0330;
    L_0x0304:
        r0 = r10.f25H;
        if (r0 == 0) goto L_0x0330;
    L_0x0308:
        r0 = r9.f201n;
        if (r0 <= 0) goto L_0x0394;
    L_0x030c:
        r0 = r9.f207t;
        if (r0 != 0) goto L_0x0394;
    L_0x0310:
        r0 = r9.m173a(r10, r12, r3, r13);
    L_0x0314:
        if (r0 == 0) goto L_0x0329;
    L_0x0316:
        r1 = r10.f26I;
        r10.f34b = r1;
        r10.f35c = r11;
        r1 = new android.support.v4.app.r;
        r1.<init>(r9, r10);
        r0.setAnimationListener(r1);
        r1 = r10.f26I;
        r1.startAnimation(r0);
    L_0x0329:
        r0 = r10.f25H;
        r1 = r10.f26I;
        r0.removeView(r1);
    L_0x0330:
        r10.f25H = r7;
        r10.f26I = r7;
        r10.f27J = r7;
        goto L_0x024b;
    L_0x0338:
        r0 = f187a;
        if (r0 == 0) goto L_0x0354;
    L_0x033c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0354:
        r0 = r10.f20C;
        if (r0 != 0) goto L_0x035b;
    L_0x0358:
        r10.m72z();
    L_0x035b:
        r10.f23F = r3;
        r10.m62p();
        r0 = r10.f23F;
        if (r0 != 0) goto L_0x0383;
    L_0x0364:
        r0 = new android.support.v4.app.at;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0383:
        if (r14 != 0) goto L_0x0045;
    L_0x0385:
        r0 = r10.f20C;
        if (r0 != 0) goto L_0x038e;
    L_0x0389:
        r9.m202d(r10);
        goto L_0x0045;
    L_0x038e:
        r10.f52t = r7;
        r10.f51s = r7;
        goto L_0x0045;
    L_0x0394:
        r0 = r7;
        goto L_0x0314;
    L_0x0397:
        r0 = r7;
        goto L_0x019b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.p.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    public void m183a(Fragment fragment, boolean z) {
        if (this.f194g == null) {
            this.f194g = new ArrayList();
        }
        if (f187a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m198c(fragment);
        if (!fragment.f18A) {
            if (this.f194g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.f194g.add(fragment);
            fragment.f44l = true;
            fragment.f45m = false;
            if (fragment.f21D && fragment.f22E) {
                this.f205r = true;
            }
            if (z) {
                m192b(fragment);
            }
        }
    }

    public void m184a(C0012h c0012h, C0008m c0008m, Fragment fragment) {
        if (this.f202o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f202o = c0012h;
        this.f203p = c0008m;
        this.f204q = fragment;
    }

    public void m185a(Runnable runnable, boolean z) {
        if (!z) {
            m167t();
        }
        synchronized (this) {
            if (this.f207t || this.f202o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f190c == null) {
                this.f190c = new ArrayList();
            }
            this.f190c.add(runnable);
            if (this.f190c.size() == 1) {
                this.f202o.f163a.removeCallbacks(this.f212y);
                this.f202o.f163a.post(this.f212y);
            }
        }
    }

    public void m186a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f193f != null) {
            size = this.f193f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f193f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.m26a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f194g != null) {
            size = this.f194g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f194g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f197j != null) {
            size = this.f197j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f197j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f196i != null) {
            size = this.f196i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0005b c0005b = (C0005b) this.f196i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0005b.toString());
                    c0005b.m132a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f198k != null) {
                int size2 = this.f198k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0005b = (C0005b) this.f198k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0005b);
                    }
                }
            }
            if (this.f199l != null && this.f199l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f199l.toArray()));
            }
        }
        if (this.f190c != null) {
            i = this.f190c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f190c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mActivity=");
        printWriter.println(this.f202o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f203p);
        if (this.f204q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f204q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f201n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f206s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f207t);
        if (this.f205r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f205r);
        }
        if (this.f208u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f208u);
        }
        if (this.f195h != null && this.f195h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f195h.toArray()));
        }
    }

    boolean m187a(Handler handler, String str, int i, int i2) {
        if (this.f196i == null) {
            return false;
        }
        int size;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.f196i.size() - 1;
            if (size < 0) {
                return false;
            }
            ((C0005b) this.f196i.remove(size)).m136b(true);
            m208f();
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                C0005b c0005b;
                size2 = this.f196i.size() - 1;
                while (size2 >= 0) {
                    c0005b = (C0005b) this.f196i.get(size2);
                    if ((str != null && str.equals(c0005b.m137c())) || (i >= 0 && i == c0005b.f148o)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        c0005b = (C0005b) this.f196i.get(size2);
                        if ((str == null || !str.equals(c0005b.m137c())) && (i < 0 || i != c0005b.f148o)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.f196i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size2 = this.f196i.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f196i.remove(size2));
            }
            int size3 = arrayList.size() - 1;
            int i3 = 0;
            while (i3 <= size3) {
                if (f187a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i3));
                }
                ((C0005b) arrayList.get(i3)).m136b(i3 == size3);
                i3++;
            }
            m208f();
        }
        return true;
    }

    public boolean m188a(Menu menu) {
        if (this.f194g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f194g.size(); i++) {
            Fragment fragment = (Fragment) this.f194g.get(i);
            if (fragment != null && fragment.m40c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m189a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f194g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f194g.size()) {
                fragment = (Fragment) this.f194g.get(i2);
                if (fragment != null && fragment.m35b(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f197j != null) {
            while (i < this.f197j.size()) {
                fragment = (Fragment) this.f197j.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.m63q();
                }
                i++;
            }
        }
        this.f197j = arrayList;
        return z;
    }

    public boolean m190a(MenuItem menuItem) {
        if (this.f194g == null) {
            return false;
        }
        for (int i = 0; i < this.f194g.size(); i++) {
            Fragment fragment = (Fragment) this.f194g.get(i);
            if (fragment != null && fragment.m41c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m191b(int i) {
        synchronized (this) {
            this.f198k.set(i, null);
            if (this.f199l == null) {
                this.f199l = new ArrayList();
            }
            if (f187a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f199l.add(Integer.valueOf(i));
        }
    }

    void m192b(Fragment fragment) {
        m182a(fragment, this.f201n, 0, 0, false);
    }

    public void m193b(Fragment fragment, int i, int i2) {
        if (f187a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.f58z) {
            fragment.f58z = true;
            if (fragment.f26I != null) {
                Animation a = m173a(fragment, i, false, i2);
                if (a != null) {
                    fragment.f26I.startAnimation(a);
                }
                fragment.f26I.setVisibility(8);
            }
            if (fragment.f44l && fragment.f21D && fragment.f22E) {
                this.f205r = true;
            }
            fragment.m27a(true);
        }
    }

    void m194b(C0005b c0005b) {
        if (this.f196i == null) {
            this.f196i = new ArrayList();
        }
        this.f196i.add(c0005b);
        m208f();
    }

    public void m195b(Menu menu) {
        if (this.f194g != null) {
            for (int i = 0; i < this.f194g.size(); i++) {
                Fragment fragment = (Fragment) this.f194g.get(i);
                if (fragment != null) {
                    fragment.m43d(menu);
                }
            }
        }
    }

    public boolean mo11b() {
        return m206e();
    }

    public boolean m197b(MenuItem menuItem) {
        if (this.f194g == null) {
            return false;
        }
        for (int i = 0; i < this.f194g.size(); i++) {
            Fragment fragment = (Fragment) this.f194g.get(i);
            if (fragment != null && fragment.m45d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void m198c(Fragment fragment) {
        if (fragment.f38f < 0) {
            if (this.f195h == null || this.f195h.size() <= 0) {
                if (this.f193f == null) {
                    this.f193f = new ArrayList();
                }
                fragment.m17a(this.f193f.size(), this.f204q);
                this.f193f.add(fragment);
            } else {
                fragment.m17a(((Integer) this.f195h.remove(this.f195h.size() - 1)).intValue(), this.f204q);
                this.f193f.set(fragment.f38f, fragment);
            }
            if (f187a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    public void m199c(Fragment fragment, int i, int i2) {
        if (f187a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f58z) {
            fragment.f58z = false;
            if (fragment.f26I != null) {
                Animation a = m173a(fragment, i, true, i2);
                if (a != null) {
                    fragment.f26I.startAnimation(a);
                }
                fragment.f26I.setVisibility(0);
            }
            if (fragment.f44l && fragment.f21D && fragment.f22E) {
                this.f205r = true;
            }
            fragment.m27a(false);
        }
    }

    public boolean m200c() {
        m167t();
        mo11b();
        return m187a(this.f202o.f163a, null, -1, 0);
    }

    void m201d() {
        if (this.f193f != null) {
            for (int i = 0; i < this.f193f.size(); i++) {
                Fragment fragment = (Fragment) this.f193f.get(i);
                if (fragment != null) {
                    m180a(fragment);
                }
            }
        }
    }

    void m202d(Fragment fragment) {
        if (fragment.f38f >= 0) {
            if (f187a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f193f.set(fragment.f38f, null);
            if (this.f195h == null) {
                this.f195h = new ArrayList();
            }
            this.f195h.add(Integer.valueOf(fragment.f38f));
            this.f202o.m150a(fragment.f39g);
            fragment.m61o();
        }
    }

    public void m203d(Fragment fragment, int i, int i2) {
        if (f187a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.f18A) {
            fragment.f18A = true;
            if (fragment.f44l) {
                if (this.f194g != null) {
                    if (f187a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f194g.remove(fragment);
                }
                if (fragment.f21D && fragment.f22E) {
                    this.f205r = true;
                }
                fragment.f44l = false;
                m182a(fragment, 1, i, i2, false);
            }
        }
    }

    void m204e(Fragment fragment) {
        if (fragment.f27J != null) {
            if (this.f211x == null) {
                this.f211x = new SparseArray();
            } else {
                this.f211x.clear();
            }
            fragment.f27J.saveHierarchyState(this.f211x);
            if (this.f211x.size() > 0) {
                fragment.f37e = this.f211x;
                this.f211x = null;
            }
        }
    }

    public void m205e(Fragment fragment, int i, int i2) {
        if (f187a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f18A) {
            fragment.f18A = false;
            if (!fragment.f44l) {
                if (this.f194g == null) {
                    this.f194g = new ArrayList();
                }
                if (this.f194g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f187a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f194g.add(fragment);
                fragment.f44l = true;
                if (fragment.f21D && fragment.f22E) {
                    this.f205r = true;
                }
                m182a(fragment, this.f201n, i, i2, false);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m206e() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.f192e;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.f202o;
        r3 = r3.f163a;
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0024;
    L_0x001c:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0024:
        r1 = r2;
    L_0x0025:
        monitor-enter(r6);
        r3 = r6.f190c;	 Catch:{ all -> 0x0097 }
        if (r3 == 0) goto L_0x0032;
    L_0x002a:
        r3 = r6.f190c;	 Catch:{ all -> 0x0097 }
        r3 = r3.size();	 Catch:{ all -> 0x0097 }
        if (r3 != 0) goto L_0x005a;
    L_0x0032:
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r0 = r6.f209v;
        if (r0 == 0) goto L_0x00a5;
    L_0x0037:
        r3 = r2;
        r4 = r2;
    L_0x0039:
        r0 = r6.f193f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x009e;
    L_0x0041:
        r0 = r6.f193f;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x0056;
    L_0x004b:
        r5 = r0.f30M;
        if (r5 == 0) goto L_0x0056;
    L_0x004f:
        r0 = r0.f30M;
        r0 = r0.mo1a();
        r4 = r4 | r0;
    L_0x0056:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0039;
    L_0x005a:
        r1 = r6.f190c;	 Catch:{ all -> 0x0097 }
        r3 = r1.size();	 Catch:{ all -> 0x0097 }
        r1 = r6.f191d;	 Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x0069;
    L_0x0064:
        r1 = r6.f191d;	 Catch:{ all -> 0x0097 }
        r1 = r1.length;	 Catch:{ all -> 0x0097 }
        if (r1 >= r3) goto L_0x006d;
    L_0x0069:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0097 }
        r6.f191d = r1;	 Catch:{ all -> 0x0097 }
    L_0x006d:
        r1 = r6.f190c;	 Catch:{ all -> 0x0097 }
        r4 = r6.f191d;	 Catch:{ all -> 0x0097 }
        r1.toArray(r4);	 Catch:{ all -> 0x0097 }
        r1 = r6.f190c;	 Catch:{ all -> 0x0097 }
        r1.clear();	 Catch:{ all -> 0x0097 }
        r1 = r6.f202o;	 Catch:{ all -> 0x0097 }
        r1 = r1.f163a;	 Catch:{ all -> 0x0097 }
        r4 = r6.f212y;	 Catch:{ all -> 0x0097 }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x0097 }
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r6.f192e = r0;
        r1 = r2;
    L_0x0086:
        if (r1 >= r3) goto L_0x009a;
    L_0x0088:
        r4 = r6.f191d;
        r4 = r4[r1];
        r4.run();
        r4 = r6.f191d;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x0086;
    L_0x0097:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        throw r0;
    L_0x009a:
        r6.f192e = r2;
        r1 = r0;
        goto L_0x0025;
    L_0x009e:
        if (r4 != 0) goto L_0x00a5;
    L_0x00a0:
        r6.f209v = r2;
        r6.m201d();
    L_0x00a5:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.p.e():boolean");
    }

    Bundle m207f(Fragment fragment) {
        Bundle bundle;
        if (this.f210w == null) {
            this.f210w = new Bundle();
        }
        fragment.m55i(this.f210w);
        if (this.f210w.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f210w;
            this.f210w = null;
        }
        if (fragment.f26I != null) {
            m204e(fragment);
        }
        if (fragment.f37e != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f37e);
        }
        if (!fragment.f29L) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.f29L);
        }
        return bundle;
    }

    void m208f() {
        if (this.f200m != null) {
            for (int i = 0; i < this.f200m.size(); i++) {
                ((C0018o) this.f200m.get(i)).m161a();
            }
        }
    }

    ArrayList m209g() {
        ArrayList arrayList = null;
        if (this.f193f != null) {
            for (int i = 0; i < this.f193f.size(); i++) {
                Fragment fragment = (Fragment) this.f193f.get(i);
                if (fragment != null && fragment.f19B) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.f20C = true;
                    fragment.f42j = fragment.f41i != null ? fragment.f41i.f38f : -1;
                    if (f187a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return arrayList;
    }

    Parcelable m210h() {
        BackStackState[] backStackStateArr = null;
        m206e();
        if (f188b) {
            this.f206s = true;
        }
        if (this.f193f == null || this.f193f.size() <= 0) {
            return null;
        }
        int size = this.f193f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f193f.get(i);
            if (fragment != null) {
                if (fragment.f38f < 0) {
                    m164a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.f38f));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.f33a <= 0 || fragmentState.f71j != null) {
                    fragmentState.f71j = fragment.f36d;
                } else {
                    fragmentState.f71j = m207f(fragment);
                    if (fragment.f41i != null) {
                        if (fragment.f41i.f38f < 0) {
                            m164a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f41i));
                        }
                        if (fragmentState.f71j == null) {
                            fragmentState.f71j = new Bundle();
                        }
                        m178a(fragmentState.f71j, "android:target_state", fragment.f41i);
                        if (fragment.f43k != 0) {
                            fragmentState.f71j.putInt("android:target_req_state", fragment.f43k);
                        }
                    }
                }
                if (f187a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f71j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.f194g != null) {
                i = this.f194g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.f194g.get(i2)).f38f;
                        if (iArr[i2] < 0) {
                            m164a(new IllegalStateException("Failure saving state: active " + this.f194g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f187a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f194g.get(i2));
                        }
                    }
                    if (this.f196i != null) {
                        i = this.f196i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState(this, (C0005b) this.f196i.get(i2));
                                if (f187a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f196i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.f59a = fragmentStateArr;
                    fragmentManagerState.f60b = iArr;
                    fragmentManagerState.f61c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.f196i != null) {
                i = this.f196i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState(this, (C0005b) this.f196i.get(i2));
                        if (f187a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f196i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f59a = fragmentStateArr;
            fragmentManagerState.f60b = iArr;
            fragmentManagerState.f61c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f187a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    public void m211i() {
        this.f206s = false;
    }

    public void m212j() {
        this.f206s = false;
        m176a(1, false);
    }

    public void m213k() {
        this.f206s = false;
        m176a(2, false);
    }

    public void m214l() {
        this.f206s = false;
        m176a(4, false);
    }

    public void m215m() {
        this.f206s = false;
        m176a(5, false);
    }

    public void m216n() {
        m176a(4, false);
    }

    public void m217o() {
        this.f206s = true;
        m176a(3, false);
    }

    public void m218p() {
        m176a(2, false);
    }

    public void m219q() {
        m176a(1, false);
    }

    public void m220r() {
        this.f207t = true;
        m206e();
        m176a(0, false);
        this.f202o = null;
        this.f203p = null;
        this.f204q = null;
    }

    public void m221s() {
        if (this.f194g != null) {
            for (int i = 0; i < this.f194g.size(); i++) {
                Fragment fragment = (Fragment) this.f194g.get(i);
                if (fragment != null) {
                    fragment.m67u();
                }
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f204q != null) {
            C0038d.m309a(this.f204q, stringBuilder);
        } else {
            C0038d.m309a(this.f202o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
