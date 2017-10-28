package android.support.v4.widget;

import android.support.v4.view.C0097z;
import android.support.v4.view.af;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.google.android.vending.licensing.APKExpansionPolicy;
import java.util.Arrays;

public class C0122y {
    private static final Interpolator f420v = new C0123z();
    private int f421a;
    private int f422b;
    private int f423c;
    private float[] f424d;
    private float[] f425e;
    private float[] f426f;
    private float[] f427g;
    private int[] f428h;
    private int[] f429i;
    private int[] f430j;
    private int f431k;
    private VelocityTracker f432l;
    private float f433m;
    private float f434n;
    private int f435o;
    private int f436p;
    private C0107j f437q;
    private final aa f438r;
    private View f439s;
    private boolean f440t;
    private final ViewGroup f441u;
    private final Runnable f442w;

    private float m906a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private float m907a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int m908a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f441u.getWidth();
        int i4 = width / 2;
        float a = (m906a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        return Math.min(i4 > 0 ? Math.round(Math.abs(a / ((float) i4)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    private int m909a(View view, int i, int i2, int i3, int i4) {
        int b = m915b(i3, (int) this.f434n, (int) this.f433m);
        int b2 = m915b(i4, (int) this.f434n, (int) this.f433m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m908a(i2, b2, this.f438r.m805b(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m908a(i, b, this.f438r.mo124a(view)))));
    }

    private void m910a(float f, float f2) {
        this.f440t = true;
        this.f438r.mo128a(this.f439s, f, f2);
        this.f440t = false;
        if (this.f421a == 1) {
            m932b(0);
        }
    }

    private void m911a(float f, float f2, int i) {
        m921e(i);
        float[] fArr = this.f424d;
        this.f426f[i] = f;
        fArr[i] = f;
        fArr = this.f425e;
        this.f427g[i] = f2;
        fArr[i] = f2;
        this.f428h[i] = m920e((int) f, (int) f2);
        this.f431k |= 1 << i;
    }

    private boolean m912a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f428h[i] & i2) != i2 || (this.f436p & i2) == 0 || (this.f430j[i] & i2) == i2 || (this.f429i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f422b) && abs2 <= ((float) this.f422b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f438r.mo134b(i2)) {
            return (this.f429i[i] & i2) == 0 && abs > ((float) this.f422b);
        } else {
            int[] iArr = this.f430j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
    }

    private boolean m913a(int i, int i2, int i3, int i4) {
        int left = this.f439s.getLeft();
        int top = this.f439s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f437q.m867g();
            m932b(0);
            return false;
        }
        this.f437q.m860a(left, top, i5, i6, m909a(this.f439s, i5, i6, i3, i4));
        m932b(2);
        return true;
    }

    private boolean m914a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f438r.mo124a(view) > 0;
        boolean z2 = this.f438r.m805b(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f422b * this.f422b)) : z ? Math.abs(f) > ((float) this.f422b) : z2 ? Math.abs(f2) > ((float) this.f422b) : false;
    }

    private int m915b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private void m916b(float f, float f2, int i) {
        int i2 = 1;
        if (!m912a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m912a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m912a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m912a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f429i;
            iArr[i] = iArr[i] | i2;
            this.f438r.mo132b(i2, i);
        }
    }

    private void m917b(int i, int i2, int i3, int i4) {
        int a;
        int b;
        int left = this.f439s.getLeft();
        int top = this.f439s.getTop();
        if (i3 != 0) {
            a = this.f438r.mo125a(this.f439s, i, i3);
            this.f439s.offsetLeftAndRight(a - left);
        } else {
            a = i;
        }
        if (i4 != 0) {
            b = this.f438r.mo131b(this.f439s, i2, i4);
            this.f439s.offsetTopAndBottom(b - top);
        } else {
            b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f438r.mo129a(this.f439s, a, b, a - left, b - top);
        }
    }

    private void m918c(MotionEvent motionEvent) {
        int c = C0097z.m751c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = C0097z.m749b(motionEvent, i);
            float c2 = C0097z.m750c(motionEvent, i);
            float d = C0097z.m752d(motionEvent, i);
            this.f426f[b] = c2;
            this.f427g[b] = d;
        }
    }

    private void m919d(int i) {
        if (this.f424d != null) {
            this.f424d[i] = 0.0f;
            this.f425e[i] = 0.0f;
            this.f426f[i] = 0.0f;
            this.f427g[i] = 0.0f;
            this.f428h[i] = 0;
            this.f429i[i] = 0;
            this.f430j[i] = 0;
            this.f431k &= (1 << i) ^ -1;
        }
    }

    private int m920e(int i, int i2) {
        int i3 = 0;
        if (i < this.f441u.getLeft() + this.f435o) {
            i3 = 1;
        }
        if (i2 < this.f441u.getTop() + this.f435o) {
            i3 |= 4;
        }
        if (i > this.f441u.getRight() - this.f435o) {
            i3 |= 2;
        }
        return i2 > this.f441u.getBottom() - this.f435o ? i3 | 8 : i3;
    }

    private void m921e(int i) {
        if (this.f424d == null || this.f424d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f424d != null) {
                System.arraycopy(this.f424d, 0, obj, 0, this.f424d.length);
                System.arraycopy(this.f425e, 0, obj2, 0, this.f425e.length);
                System.arraycopy(this.f426f, 0, obj3, 0, this.f426f.length);
                System.arraycopy(this.f427g, 0, obj4, 0, this.f427g.length);
                System.arraycopy(this.f428h, 0, obj5, 0, this.f428h.length);
                System.arraycopy(this.f429i, 0, obj6, 0, this.f429i.length);
                System.arraycopy(this.f430j, 0, obj7, 0, this.f430j.length);
            }
            this.f424d = obj;
            this.f425e = obj2;
            this.f426f = obj3;
            this.f427g = obj4;
            this.f428h = obj5;
            this.f429i = obj6;
            this.f430j = obj7;
        }
    }

    private void m922g() {
        if (this.f424d != null) {
            Arrays.fill(this.f424d, 0.0f);
            Arrays.fill(this.f425e, 0.0f);
            Arrays.fill(this.f426f, 0.0f);
            Arrays.fill(this.f427g, 0.0f);
            Arrays.fill(this.f428h, 0);
            Arrays.fill(this.f429i, 0);
            Arrays.fill(this.f430j, 0);
            this.f431k = 0;
        }
    }

    private void m923h() {
        this.f432l.computeCurrentVelocity(1000, this.f433m);
        m910a(m907a(af.m542a(this.f432l, this.f423c), this.f434n, this.f433m), m907a(af.m543b(this.f432l, this.f423c), this.f434n, this.f433m));
    }

    public int m924a() {
        return this.f421a;
    }

    public void m925a(View view, int i) {
        if (view.getParent() != this.f441u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f441u + ")");
        }
        this.f439s = view;
        this.f423c = i;
        this.f438r.mo133b(view, i);
        m932b(1);
    }

    public boolean m926a(int i) {
        return (this.f431k & (1 << i)) != 0;
    }

    public boolean m927a(int i, int i2) {
        if (this.f440t) {
            return m913a(i, i2, (int) af.m542a(this.f432l, this.f423c), (int) af.m543b(this.f432l, this.f423c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean m928a(MotionEvent motionEvent) {
        int a = C0097z.m746a(motionEvent);
        int b = C0097z.m748b(motionEvent);
        if (a == 0) {
            m942e();
        }
        if (this.f432l == null) {
            this.f432l = VelocityTracker.obtain();
        }
        this.f432l.addMovement(motionEvent);
        float y;
        int b2;
        switch (a) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                float x = motionEvent.getX();
                y = motionEvent.getY();
                b2 = C0097z.m749b(motionEvent, 0);
                m911a(x, y, b2);
                View d = m941d((int) x, (int) y);
                if (d == this.f439s && this.f421a == 2) {
                    m935b(d, b2);
                }
                a = this.f428h[b2];
                if ((this.f436p & a) != 0) {
                    this.f438r.mo127a(a & this.f436p, b2);
                    break;
                }
                break;
            case 1:
            case 3:
                m942e();
                break;
            case 2:
                b = C0097z.m751c(motionEvent);
                a = 0;
                while (a < b) {
                    b2 = C0097z.m749b(motionEvent, a);
                    float c = C0097z.m750c(motionEvent, a);
                    float d2 = C0097z.m752d(motionEvent, a);
                    float f = c - this.f424d[b2];
                    float f2 = d2 - this.f425e[b2];
                    m916b(f, f2, b2);
                    if (this.f421a != 1) {
                        View d3 = m941d((int) c, (int) d2);
                        if (d3 == null || !m914a(d3, f, f2) || !m935b(d3, b2)) {
                            a++;
                        }
                    }
                    m918c(motionEvent);
                    break;
                }
                m918c(motionEvent);
                break;
            case 5:
                a = C0097z.m749b(motionEvent, b);
                float c2 = C0097z.m750c(motionEvent, b);
                y = C0097z.m752d(motionEvent, b);
                m911a(c2, y, a);
                if (this.f421a != 0) {
                    if (this.f421a == 2) {
                        View d4 = m941d((int) c2, (int) y);
                        if (d4 == this.f439s) {
                            m935b(d4, a);
                            break;
                        }
                    }
                }
                b = this.f428h[a];
                if ((this.f436p & b) != 0) {
                    this.f438r.mo127a(b & this.f436p, a);
                    break;
                }
                break;
            case 6:
                m919d(C0097z.m749b(motionEvent, b));
                break;
        }
        return this.f421a == 1;
    }

    public boolean m929a(View view, int i, int i2) {
        this.f439s = view;
        this.f423c = -1;
        return m913a(i, i2, 0, 0);
    }

    public boolean m930a(boolean z) {
        if (this.f421a == 2) {
            boolean a;
            boolean f = this.f437q.m866f();
            int b = this.f437q.m862b();
            int c = this.f437q.m863c();
            int left = b - this.f439s.getLeft();
            int top = c - this.f439s.getTop();
            if (left != 0) {
                this.f439s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f439s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f438r.mo129a(this.f439s, b, c, left, top);
            }
            if (f && b == this.f437q.m864d() && c == this.f437q.m865e()) {
                this.f437q.m867g();
                a = this.f437q.m861a();
            } else {
                a = f;
            }
            if (!a) {
                if (z) {
                    this.f441u.post(this.f442w);
                } else {
                    m932b(0);
                }
            }
        }
        return this.f421a == 2;
    }

    public int m931b() {
        return this.f435o;
    }

    void m932b(int i) {
        if (this.f421a != i) {
            this.f421a = i;
            this.f438r.mo126a(i);
            if (i == 0) {
                this.f439s = null;
            }
        }
    }

    public void m933b(MotionEvent motionEvent) {
        int i = 0;
        int a = C0097z.m746a(motionEvent);
        int b = C0097z.m748b(motionEvent);
        if (a == 0) {
            m942e();
        }
        if (this.f432l == null) {
            this.f432l = VelocityTracker.obtain();
        }
        this.f432l.addMovement(motionEvent);
        float x;
        float y;
        View d;
        int i2;
        switch (a) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = C0097z.m749b(motionEvent, 0);
                d = m941d((int) x, (int) y);
                m911a(x, y, i);
                m935b(d, i);
                i2 = this.f428h[i];
                if ((this.f436p & i2) != 0) {
                    this.f438r.mo127a(i2 & this.f436p, i);
                    return;
                }
                return;
            case 1:
                if (this.f421a == 1) {
                    m923h();
                }
                m942e();
                return;
            case 2:
                if (this.f421a == 1) {
                    i = C0097z.m747a(motionEvent, this.f423c);
                    x = C0097z.m750c(motionEvent, i);
                    i2 = (int) (x - this.f426f[this.f423c]);
                    i = (int) (C0097z.m752d(motionEvent, i) - this.f427g[this.f423c]);
                    m917b(this.f439s.getLeft() + i2, this.f439s.getTop() + i, i2, i);
                    m918c(motionEvent);
                    return;
                }
                i2 = C0097z.m751c(motionEvent);
                while (i < i2) {
                    a = C0097z.m749b(motionEvent, i);
                    float c = C0097z.m750c(motionEvent, i);
                    float d2 = C0097z.m752d(motionEvent, i);
                    float f = c - this.f424d[a];
                    float f2 = d2 - this.f425e[a];
                    m916b(f, f2, a);
                    if (this.f421a != 1) {
                        d = m941d((int) c, (int) d2);
                        if (!m914a(d, f, f2) || !m935b(d, a)) {
                            i++;
                        }
                    }
                    m918c(motionEvent);
                    return;
                }
                m918c(motionEvent);
                return;
            case 3:
                if (this.f421a == 1) {
                    m910a(0.0f, 0.0f);
                }
                m942e();
                return;
            case 5:
                i = C0097z.m749b(motionEvent, b);
                x = C0097z.m750c(motionEvent, b);
                y = C0097z.m752d(motionEvent, b);
                m911a(x, y, i);
                if (this.f421a == 0) {
                    m935b(m941d((int) x, (int) y), i);
                    i2 = this.f428h[i];
                    if ((this.f436p & i2) != 0) {
                        this.f438r.mo127a(i2 & this.f436p, i);
                        return;
                    }
                    return;
                } else if (m939c((int) x, (int) y)) {
                    m935b(this.f439s, i);
                    return;
                } else {
                    return;
                }
            case 6:
                a = C0097z.m749b(motionEvent, b);
                if (this.f421a == 1 && a == this.f423c) {
                    b = C0097z.m751c(motionEvent);
                    while (i < b) {
                        int b2 = C0097z.m749b(motionEvent, i);
                        if (b2 != this.f423c) {
                            if (m941d((int) C0097z.m750c(motionEvent, i), (int) C0097z.m752d(motionEvent, i)) == this.f439s && m935b(this.f439s, b2)) {
                                i = this.f423c;
                                if (i == -1) {
                                    m923h();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m923h();
                    }
                }
                m919d(a);
                return;
            default:
                return;
        }
    }

    public boolean m934b(int i, int i2) {
        if (!m926a(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f426f[i2] - this.f424d[i2];
        float f2 = this.f427g[i2] - this.f425e[i2];
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f422b * this.f422b)) : z ? Math.abs(f) > ((float) this.f422b) : z2 ? Math.abs(f2) > ((float) this.f422b) : false;
    }

    boolean m935b(View view, int i) {
        if (view == this.f439s && this.f423c == i) {
            return true;
        }
        if (view == null || !this.f438r.mo130a(view, i)) {
            return false;
        }
        this.f423c = i;
        m925a(view, i);
        return true;
    }

    public boolean m936b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View m937c() {
        return this.f439s;
    }

    public boolean m938c(int i) {
        int length = this.f424d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m934b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m939c(int i, int i2) {
        return m936b(this.f439s, i, i2);
    }

    public int m940d() {
        return this.f422b;
    }

    public View m941d(int i, int i2) {
        for (int childCount = this.f441u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f441u.getChildAt(this.f438r.m810c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void m942e() {
        this.f423c = -1;
        m922g();
        if (this.f432l != null) {
            this.f432l.recycle();
            this.f432l = null;
        }
    }

    public void m943f() {
        m942e();
        if (this.f421a == 2) {
            int b = this.f437q.m862b();
            int c = this.f437q.m863c();
            this.f437q.m867g();
            int b2 = this.f437q.m862b();
            int c2 = this.f437q.m863c();
            this.f438r.mo129a(this.f439s, b2, c2, b2 - b, c2 - c);
        }
        m932b(0);
    }
}
