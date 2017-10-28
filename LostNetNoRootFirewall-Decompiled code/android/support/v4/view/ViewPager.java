package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p001b.C0028a;
import android.support.v4.widget.C0102e;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.google.android.vending.licensing.APKExpansionPolicy;
import com.google.tagmanager.protobuf.CodedOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager extends ViewGroup {
    private static final int[] f263a = new int[]{16842931};
    private static final bs af = new bs();
    private static final Comparator f264c = new bf();
    private static final Interpolator f265d = new bg();
    private boolean f266A;
    private boolean f267B;
    private int f268C;
    private int f269D;
    private int f270E;
    private float f271F;
    private float f272G;
    private float f273H;
    private float f274I;
    private int f275J = -1;
    private VelocityTracker f276K;
    private int f277L;
    private int f278M;
    private int f279N;
    private int f280O;
    private boolean f281P;
    private C0102e f282Q;
    private C0102e f283R;
    private boolean f284S = true;
    private boolean f285T = false;
    private boolean f286U;
    private int f287V;
    private bn f288W;
    private bn f289Z;
    private bm aa;
    private bo ab;
    private Method ac;
    private int ad;
    private ArrayList ae;
    private final Runnable ag = new bh(this);
    private int ah = 0;
    private int f290b;
    private final ArrayList f291e = new ArrayList();
    private final bj f292f = new bj();
    private final Rect f293g = new Rect();
    private ae f294h;
    private int f295i;
    private int f296j = -1;
    private Parcelable f297k = null;
    private ClassLoader f298l = null;
    private Scroller f299m;
    private bp f300n;
    private int f301o;
    private Drawable f302p;
    private int f303q;
    private int f304r;
    private float f305s = -3.4028235E38f;
    private float f306t = Float.MAX_VALUE;
    private int f307u;
    private int f308v;
    private boolean f309w;
    private boolean f310x;
    private boolean f311y;
    private int f312z = 1;

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR = C0028a.m263a(new bq());
        int f260a;
        Parcelable f261b;
        ClassLoader f262c;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f260a = parcel.readInt();
            this.f261b = parcel.readParcelable(classLoader);
            this.f262c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f260a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f260a);
            parcel.writeParcelable(this.f261b, i);
        }
    }

    public ViewPager(Context context) {
        super(context);
        m342a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m342a();
    }

    private int m319a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f279N || Math.abs(i2) <= this.f277L) {
            i = (int) ((i >= this.f295i ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f291e.size() <= 0) {
            return i;
        }
        return Math.max(((bj) this.f291e.get(0)).f333b, Math.min(i, ((bj) this.f291e.get(this.f291e.size() - 1)).f333b));
    }

    private Rect m320a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private void m322a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f291e.isEmpty()) {
            bj b = m351b(this.f295i);
            int min = (int) ((b != null ? Math.min(b.f336e, this.f306t) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m327a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.f299m.isFinished()) {
            this.f299m.startScroll(paddingLeft, 0, (int) (m351b(this.f295i).f336e * ((float) i)), 0, this.f299m.getDuration() - this.f299m.timePassed());
        }
    }

    private void m323a(int i, boolean z, int i2, boolean z2) {
        int max;
        bj b = m351b(i);
        if (b != null) {
            max = (int) (Math.max(this.f305s, Math.min(b.f336e, this.f306t)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            m345a(max, 0, i2);
            if (z2 && this.f288W != null) {
                this.f288W.mo100a(i);
            }
            if (z2 && this.f289Z != null) {
                this.f289Z.mo100a(i);
                return;
            }
            return;
        }
        if (z2 && this.f288W != null) {
            this.f288W.mo100a(i);
        }
        if (z2 && this.f289Z != null) {
            this.f289Z.mo100a(i);
        }
        m327a(false);
        scrollTo(max, 0);
        m333d(max);
    }

    private void m325a(bj bjVar, int i, bj bjVar2) {
        float f;
        int i2;
        bj bjVar3;
        int i3;
        int b = this.f294h.mo756b();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.f301o) / ((float) clientWidth) : 0.0f;
        if (bjVar2 != null) {
            clientWidth = bjVar2.f333b;
            int i4;
            if (clientWidth < bjVar.f333b) {
                f = (bjVar2.f336e + bjVar2.f335d) + f2;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= bjVar.f333b && i2 < this.f291e.size()) {
                    bjVar3 = (bj) this.f291e.get(i2);
                    while (i4 > bjVar3.f333b && i2 < this.f291e.size() - 1) {
                        i2++;
                        bjVar3 = (bj) this.f291e.get(i2);
                    }
                    while (i4 < bjVar3.f333b) {
                        f += this.f294h.m242d(i4) + f2;
                        i4++;
                    }
                    bjVar3.f336e = f;
                    f += bjVar3.f335d + f2;
                    i4++;
                }
            } else if (clientWidth > bjVar.f333b) {
                i2 = this.f291e.size() - 1;
                f = bjVar2.f336e;
                i4 = clientWidth - 1;
                while (i4 >= bjVar.f333b && i2 >= 0) {
                    bjVar3 = (bj) this.f291e.get(i2);
                    while (i4 < bjVar3.f333b && i2 > 0) {
                        i2--;
                        bjVar3 = (bj) this.f291e.get(i2);
                    }
                    while (i4 > bjVar3.f333b) {
                        f -= this.f294h.m242d(i4) + f2;
                        i4--;
                    }
                    f -= bjVar3.f335d + f2;
                    bjVar3.f336e = f;
                    i4--;
                }
            }
        }
        int size = this.f291e.size();
        float f3 = bjVar.f336e;
        i2 = bjVar.f333b - 1;
        this.f305s = bjVar.f333b == 0 ? bjVar.f336e : -3.4028235E38f;
        this.f306t = bjVar.f333b == b + -1 ? (bjVar.f336e + bjVar.f335d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            bjVar3 = (bj) this.f291e.get(i3);
            f = f3;
            while (i2 > bjVar3.f333b) {
                f -= this.f294h.m242d(i2) + f2;
                i2--;
            }
            f3 = f - (bjVar3.f335d + f2);
            bjVar3.f336e = f3;
            if (bjVar3.f333b == 0) {
                this.f305s = f3;
            }
            i2--;
        }
        f3 = (bjVar.f336e + bjVar.f335d) + f2;
        i2 = bjVar.f333b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            bjVar3 = (bj) this.f291e.get(i3);
            f = f3;
            while (i2 < bjVar3.f333b) {
                f = (this.f294h.m242d(i2) + f2) + f;
                i2++;
            }
            if (bjVar3.f333b == b - 1) {
                this.f306t = (bjVar3.f335d + f) - 1.0f;
            }
            bjVar3.f336e = f;
            f3 = f + (bjVar3.f335d + f2);
            i2++;
        }
        this.f285T = false;
    }

    private void m326a(MotionEvent motionEvent) {
        int b = C0097z.m748b(motionEvent);
        if (C0097z.m749b(motionEvent, b) == this.f275J) {
            b = b == 0 ? 1 : 0;
            this.f271F = C0097z.m750c(motionEvent, b);
            this.f275J = C0097z.m749b(motionEvent, b);
            if (this.f276K != null) {
                this.f276K.clear();
            }
        }
    }

    private void m327a(boolean z) {
        int scrollX;
        boolean z2 = this.ah == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f299m.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f299m.getCurrX();
            int currY = this.f299m.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.f311y = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.f291e.size(); scrollX++) {
            bj bjVar = (bj) this.f291e.get(scrollX);
            if (bjVar.f334c) {
                bjVar.f334c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            ak.m557a((View) this, this.ag);
        } else {
            this.ag.run();
        }
    }

    private boolean m328a(float f, float f2) {
        return (f < ((float) this.f269D) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f269D)) && f2 < 0.0f);
    }

    private void m330b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ak.m554a(getChildAt(i), z ? 2 : 0, null);
        }
    }

    private boolean m331b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f271F - f;
        this.f271F = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f305s;
        float f5 = ((float) clientWidth) * this.f306t;
        bj bjVar = (bj) this.f291e.get(0);
        bj bjVar2 = (bj) this.f291e.get(this.f291e.size() - 1);
        if (bjVar.f333b != 0) {
            f4 = bjVar.f336e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (bjVar2.f333b != this.f294h.mo756b() - 1) {
            f2 = bjVar2.f336e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.f282Q.m828a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f283R.m828a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f271F += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m333d((int) f4);
        return z3;
    }

    private void m332c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean m333d(int i) {
        if (this.f291e.size() == 0) {
            this.f286U = false;
            m344a(0, 0.0f, 0);
            if (this.f286U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        bj i2 = m337i();
        int clientWidth = getClientWidth();
        int i3 = this.f301o + clientWidth;
        float f = ((float) this.f301o) / ((float) clientWidth);
        int i4 = i2.f333b;
        float f2 = ((((float) i) / ((float) clientWidth)) - i2.f336e) / (i2.f335d + f);
        clientWidth = (int) (((float) i3) * f2);
        this.f286U = false;
        m344a(i4, f2, clientWidth);
        if (this.f286U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void m335g() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((bk) getChildAt(i).getLayoutParams()).f337a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void m336h() {
        if (this.ad != 0) {
            if (this.ae == null) {
                this.ae = new ArrayList();
            } else {
                this.ae.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ae.add(getChildAt(i));
            }
            Collections.sort(this.ae, af);
        }
    }

    private bj m337i() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.f301o) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        bj bjVar = null;
        while (i2 < this.f291e.size()) {
            int i3;
            bj bjVar2;
            bj bjVar3 = (bj) this.f291e.get(i2);
            bj bjVar4;
            if (obj != null || bjVar3.f333b == i + 1) {
                bjVar4 = bjVar3;
                i3 = i2;
                bjVar2 = bjVar4;
            } else {
                bjVar3 = this.f292f;
                bjVar3.f336e = (f2 + f3) + f;
                bjVar3.f333b = i + 1;
                bjVar3.f335d = this.f294h.m242d(bjVar3.f333b);
                bjVar4 = bjVar3;
                i3 = i2 - 1;
                bjVar2 = bjVar4;
            }
            f2 = bjVar2.f336e;
            f3 = (bjVar2.f335d + f2) + f;
            if (obj == null && scrollX < f2) {
                return bjVar;
            }
            if (scrollX < f3 || i3 == this.f291e.size() - 1) {
                return bjVar2;
            }
            f3 = f2;
            i = bjVar2.f333b;
            obj = null;
            f2 = bjVar2.f335d;
            bjVar = bjVar2;
            i2 = i3 + 1;
        }
        return bjVar;
    }

    private void m338j() {
        this.f266A = false;
        this.f267B = false;
        if (this.f276K != null) {
            this.f276K.recycle();
            this.f276K = null;
        }
    }

    private void setScrollState(int i) {
        if (this.ah != i) {
            this.ah = i;
            if (this.ab != null) {
                m330b(i != 0);
            }
            if (this.f288W != null) {
                this.f288W.mo102b(i);
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f310x != z) {
            this.f310x = z;
        }
    }

    float m339a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    bj m340a(int i, int i2) {
        bj bjVar = new bj();
        bjVar.f333b = i;
        bjVar.f332a = this.f294h.mo13a((ViewGroup) this, i);
        bjVar.f335d = this.f294h.m242d(i);
        if (i2 < 0 || i2 >= this.f291e.size()) {
            this.f291e.add(bjVar);
        } else {
            this.f291e.add(i2, bjVar);
        }
        return bjVar;
    }

    bj m341a(View view) {
        for (int i = 0; i < this.f291e.size(); i++) {
            bj bjVar = (bj) this.f291e.get(i);
            if (this.f294h.mo17a(view, bjVar.f332a)) {
                return bjVar;
            }
        }
        return null;
    }

    void m342a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f299m = new Scroller(context, f265d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f270E = ba.m652a(viewConfiguration);
        this.f277L = (int) (400.0f * f);
        this.f278M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f282Q = new C0102e(context);
        this.f283R = new C0102e(context);
        this.f279N = (int) (25.0f * f);
        this.f280O = (int) (2.0f * f);
        this.f268C = (int) (16.0f * f);
        ak.m556a((View) this, new bl(this));
        if (ak.m561c(this) == 0) {
            ak.m560b(this, 1);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m343a(int r19) {
        /*
        r18 = this;
        r3 = 0;
        r2 = 2;
        r0 = r18;
        r4 = r0.f295i;
        r0 = r19;
        if (r4 == r0) goto L_0x033f;
    L_0x000a:
        r0 = r18;
        r2 = r0.f295i;
        r0 = r19;
        if (r2 >= r0) goto L_0x0030;
    L_0x0012:
        r2 = 66;
    L_0x0014:
        r0 = r18;
        r3 = r0.f295i;
        r0 = r18;
        r3 = r0.m351b(r3);
        r0 = r19;
        r1 = r18;
        r1.f295i = r0;
        r4 = r3;
        r3 = r2;
    L_0x0026:
        r0 = r18;
        r2 = r0.f294h;
        if (r2 != 0) goto L_0x0033;
    L_0x002c:
        r18.m336h();
    L_0x002f:
        return;
    L_0x0030:
        r2 = 17;
        goto L_0x0014;
    L_0x0033:
        r0 = r18;
        r2 = r0.f311y;
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r18.m336h();
        goto L_0x002f;
    L_0x003d:
        r2 = r18.getWindowToken();
        if (r2 == 0) goto L_0x002f;
    L_0x0043:
        r0 = r18;
        r2 = r0.f294h;
        r0 = r18;
        r2.mo15a(r0);
        r0 = r18;
        r2 = r0.f312z;
        r5 = 0;
        r0 = r18;
        r6 = r0.f295i;
        r6 = r6 - r2;
        r11 = java.lang.Math.max(r5, r6);
        r0 = r18;
        r5 = r0.f294h;
        r12 = r5.mo756b();
        r5 = r12 + -1;
        r0 = r18;
        r6 = r0.f295i;
        r2 = r2 + r6;
        r13 = java.lang.Math.min(r5, r2);
        r0 = r18;
        r2 = r0.f290b;
        if (r12 == r2) goto L_0x00da;
    L_0x0073:
        r2 = r18.getResources();	 Catch:{ NotFoundException -> 0x00d0 }
        r3 = r18.getId();	 Catch:{ NotFoundException -> 0x00d0 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00d0 }
    L_0x007f:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r18;
        r5 = r0.f290b;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r12);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r18.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r18;
        r4 = r0.f294h;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00d0:
        r2 = move-exception;
        r2 = r18.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x007f;
    L_0x00da:
        r6 = 0;
        r2 = 0;
        r5 = r2;
    L_0x00dd:
        r0 = r18;
        r2 = r0.f291e;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x033c;
    L_0x00e7:
        r0 = r18;
        r2 = r0.f291e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.bj) r2;
        r7 = r2.f333b;
        r0 = r18;
        r8 = r0.f295i;
        if (r7 < r8) goto L_0x01cf;
    L_0x00f9:
        r7 = r2.f333b;
        r0 = r18;
        r8 = r0.f295i;
        if (r7 != r8) goto L_0x033c;
    L_0x0101:
        if (r2 != 0) goto L_0x0339;
    L_0x0103:
        if (r12 <= 0) goto L_0x0339;
    L_0x0105:
        r0 = r18;
        r2 = r0.f295i;
        r0 = r18;
        r2 = r0.m340a(r2, r5);
        r10 = r2;
    L_0x0110:
        if (r10 == 0) goto L_0x0180;
    L_0x0112:
        r9 = 0;
        r8 = r5 + -1;
        if (r8 < 0) goto L_0x01d4;
    L_0x0117:
        r0 = r18;
        r2 = r0.f291e;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.bj) r2;
    L_0x0121:
        r14 = r18.getClientWidth();
        if (r14 > 0) goto L_0x01d7;
    L_0x0127:
        r6 = 0;
    L_0x0128:
        r0 = r18;
        r7 = r0.f295i;
        r7 = r7 + -1;
        r16 = r7;
        r7 = r9;
        r9 = r16;
        r17 = r8;
        r8 = r5;
        r5 = r17;
    L_0x0138:
        if (r9 < 0) goto L_0x0142;
    L_0x013a:
        r15 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r15 < 0) goto L_0x0216;
    L_0x013e:
        if (r9 >= r11) goto L_0x0216;
    L_0x0140:
        if (r2 != 0) goto L_0x01e6;
    L_0x0142:
        r6 = r10.f335d;
        r9 = r8 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x017b;
    L_0x014c:
        r0 = r18;
        r2 = r0.f291e;
        r2 = r2.size();
        if (r9 >= r2) goto L_0x024c;
    L_0x0156:
        r0 = r18;
        r2 = r0.f291e;
        r2 = r2.get(r9);
        r2 = (android.support.v4.view.bj) r2;
        r7 = r2;
    L_0x0161:
        if (r14 > 0) goto L_0x024f;
    L_0x0163:
        r2 = 0;
        r5 = r2;
    L_0x0165:
        r0 = r18;
        r2 = r0.f295i;
        r2 = r2 + 1;
        r16 = r2;
        r2 = r7;
        r7 = r9;
        r9 = r16;
    L_0x0171:
        if (r9 >= r12) goto L_0x017b;
    L_0x0173:
        r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r11 < 0) goto L_0x029a;
    L_0x0177:
        if (r9 <= r13) goto L_0x029a;
    L_0x0179:
        if (r2 != 0) goto L_0x025c;
    L_0x017b:
        r0 = r18;
        r0.m325a(r10, r8, r4);
    L_0x0180:
        r0 = r18;
        r4 = r0.f294h;
        r0 = r18;
        r5 = r0.f295i;
        if (r10 == 0) goto L_0x02e8;
    L_0x018a:
        r2 = r10.f332a;
    L_0x018c:
        r0 = r18;
        r4.mo19b(r0, r5, r2);
        r0 = r18;
        r2 = r0.f294h;
        r0 = r18;
        r2.mo18b(r0);
        r5 = r18.getChildCount();
        r2 = 0;
        r4 = r2;
    L_0x01a0:
        if (r4 >= r5) goto L_0x02eb;
    L_0x01a2:
        r0 = r18;
        r6 = r0.getChildAt(r4);
        r2 = r6.getLayoutParams();
        r2 = (android.support.v4.view.bk) r2;
        r2.f342f = r4;
        r7 = r2.f337a;
        if (r7 != 0) goto L_0x01cb;
    L_0x01b4:
        r7 = r2.f339c;
        r8 = 0;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x01cb;
    L_0x01bb:
        r0 = r18;
        r6 = r0.m341a(r6);
        if (r6 == 0) goto L_0x01cb;
    L_0x01c3:
        r7 = r6.f335d;
        r2.f339c = r7;
        r6 = r6.f333b;
        r2.f341e = r6;
    L_0x01cb:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x01a0;
    L_0x01cf:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x00dd;
    L_0x01d4:
        r2 = 0;
        goto L_0x0121;
    L_0x01d7:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r10.f335d;
        r6 = r6 - r7;
        r7 = r18.getPaddingLeft();
        r7 = (float) r7;
        r15 = (float) r14;
        r7 = r7 / r15;
        r6 = r6 + r7;
        goto L_0x0128;
    L_0x01e6:
        r15 = r2.f333b;
        if (r9 != r15) goto L_0x0210;
    L_0x01ea:
        r15 = r2.f334c;
        if (r15 != 0) goto L_0x0210;
    L_0x01ee:
        r0 = r18;
        r15 = r0.f291e;
        r15.remove(r5);
        r0 = r18;
        r15 = r0.f294h;
        r2 = r2.f332a;
        r0 = r18;
        r15.mo16a(r0, r9, r2);
        r5 = r5 + -1;
        r8 = r8 + -1;
        if (r5 < 0) goto L_0x0214;
    L_0x0206:
        r0 = r18;
        r2 = r0.f291e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.bj) r2;
    L_0x0210:
        r9 = r9 + -1;
        goto L_0x0138;
    L_0x0214:
        r2 = 0;
        goto L_0x0210;
    L_0x0216:
        if (r2 == 0) goto L_0x0230;
    L_0x0218:
        r15 = r2.f333b;
        if (r9 != r15) goto L_0x0230;
    L_0x021c:
        r2 = r2.f335d;
        r7 = r7 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x022e;
    L_0x0223:
        r0 = r18;
        r2 = r0.f291e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.bj) r2;
        goto L_0x0210;
    L_0x022e:
        r2 = 0;
        goto L_0x0210;
    L_0x0230:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.m340a(r9, r2);
        r2 = r2.f335d;
        r7 = r7 + r2;
        r8 = r8 + 1;
        if (r5 < 0) goto L_0x024a;
    L_0x023f:
        r0 = r18;
        r2 = r0.f291e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.bj) r2;
        goto L_0x0210;
    L_0x024a:
        r2 = 0;
        goto L_0x0210;
    L_0x024c:
        r7 = 0;
        goto L_0x0161;
    L_0x024f:
        r2 = r18.getPaddingRight();
        r2 = (float) r2;
        r5 = (float) r14;
        r2 = r2 / r5;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r5;
        r5 = r2;
        goto L_0x0165;
    L_0x025c:
        r11 = r2.f333b;
        if (r9 != r11) goto L_0x0332;
    L_0x0260:
        r11 = r2.f334c;
        if (r11 != 0) goto L_0x0332;
    L_0x0264:
        r0 = r18;
        r11 = r0.f291e;
        r11.remove(r7);
        r0 = r18;
        r11 = r0.f294h;
        r2 = r2.f332a;
        r0 = r18;
        r11.mo16a(r0, r9, r2);
        r0 = r18;
        r2 = r0.f291e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0298;
    L_0x0280:
        r0 = r18;
        r2 = r0.f291e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.bj) r2;
    L_0x028a:
        r16 = r6;
        r6 = r2;
        r2 = r16;
    L_0x028f:
        r9 = r9 + 1;
        r16 = r2;
        r2 = r6;
        r6 = r16;
        goto L_0x0171;
    L_0x0298:
        r2 = 0;
        goto L_0x028a;
    L_0x029a:
        if (r2 == 0) goto L_0x02c1;
    L_0x029c:
        r11 = r2.f333b;
        if (r9 != r11) goto L_0x02c1;
    L_0x02a0:
        r2 = r2.f335d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        r0 = r18;
        r2 = r0.f291e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02bf;
    L_0x02af:
        r0 = r18;
        r2 = r0.f291e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.bj) r2;
    L_0x02b9:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x02bf:
        r2 = 0;
        goto L_0x02b9;
    L_0x02c1:
        r0 = r18;
        r2 = r0.m340a(r9, r7);
        r7 = r7 + 1;
        r2 = r2.f335d;
        r6 = r6 + r2;
        r0 = r18;
        r2 = r0.f291e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02e6;
    L_0x02d6:
        r0 = r18;
        r2 = r0.f291e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.bj) r2;
    L_0x02e0:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x02e6:
        r2 = 0;
        goto L_0x02e0;
    L_0x02e8:
        r2 = 0;
        goto L_0x018c;
    L_0x02eb:
        r18.m336h();
        r2 = r18.hasFocus();
        if (r2 == 0) goto L_0x002f;
    L_0x02f4:
        r2 = r18.findFocus();
        if (r2 == 0) goto L_0x0330;
    L_0x02fa:
        r0 = r18;
        r2 = r0.m352b(r2);
    L_0x0300:
        if (r2 == 0) goto L_0x030a;
    L_0x0302:
        r2 = r2.f333b;
        r0 = r18;
        r4 = r0.f295i;
        if (r2 == r4) goto L_0x002f;
    L_0x030a:
        r2 = 0;
    L_0x030b:
        r4 = r18.getChildCount();
        if (r2 >= r4) goto L_0x002f;
    L_0x0311:
        r0 = r18;
        r4 = r0.getChildAt(r2);
        r0 = r18;
        r5 = r0.m341a(r4);
        if (r5 == 0) goto L_0x032d;
    L_0x031f:
        r5 = r5.f333b;
        r0 = r18;
        r6 = r0.f295i;
        if (r5 != r6) goto L_0x032d;
    L_0x0327:
        r4 = r4.requestFocus(r3);
        if (r4 != 0) goto L_0x002f;
    L_0x032d:
        r2 = r2 + 1;
        goto L_0x030b;
    L_0x0330:
        r2 = 0;
        goto L_0x0300;
    L_0x0332:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x0339:
        r10 = r2;
        goto L_0x0110;
    L_0x033c:
        r2 = r6;
        goto L_0x0101;
    L_0x033f:
        r4 = r3;
        r3 = r2;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    protected void m344a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.f287V > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                bk bkVar = (bk) childAt.getLayoutParams();
                if (bkVar.f337a) {
                    int max;
                    switch (bkVar.f338b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        if (this.f288W != null) {
            this.f288W.mo101a(i, f, i2);
        }
        if (this.f289Z != null) {
            this.f289Z.mo101a(i, f, i2);
        }
        if (this.ab != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((bk) childAt2.getLayoutParams()).f337a) {
                    this.ab.m666a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.f286U = true;
    }

    void m345a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m327a(false);
            m354c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float a = (((float) i6) * m339a(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientWidth)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            clientWidth = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            clientWidth = (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.f294h.m242d(this.f295i)) + ((float) this.f301o))) + 1.0f) * 100.0f);
        }
        this.f299m.startScroll(scrollX, scrollY, i4, i5, Math.min(clientWidth, 600));
        ak.m559b(this);
    }

    public void m346a(int i, boolean z) {
        this.f311y = false;
        m347a(i, z, false);
    }

    void m347a(int i, boolean z, boolean z2) {
        m348a(i, z, z2, 0);
    }

    void m348a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f294h == null || this.f294h.mo756b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f295i != i || this.f291e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f294h.mo756b()) {
                i = this.f294h.mo756b() - 1;
            }
            int i3 = this.f312z;
            if (i > this.f295i + i3 || i < this.f295i - i3) {
                for (int i4 = 0; i4 < this.f291e.size(); i4++) {
                    ((bj) this.f291e.get(i4)).f334c = true;
                }
            }
            if (this.f295i != i) {
                z3 = true;
            }
            if (this.f284S) {
                this.f295i = i;
                if (z3 && this.f288W != null) {
                    this.f288W.mo100a(i);
                }
                if (z3 && this.f289Z != null) {
                    this.f289Z.mo100a(i);
                }
                requestLayout();
                return;
            }
            m343a(i);
            m323a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public boolean m349a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return m355c(17);
            case 22:
                return m355c(66);
            case 61:
                return VERSION.SDK_INT >= 11 ? C0090s.m727a(keyEvent) ? m355c(2) : C0090s.m728a(keyEvent, 1) ? m355c(1) : false : false;
            default:
                return false;
        }
    }

    protected boolean m350a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m350a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && ak.m558a(view, -i);
    }

    public void addFocusables(ArrayList arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    bj a = m341a(childAt);
                    if (a != null && a.f333b == this.f295i) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                bj a = m341a(childAt);
                if (a != null && a.f333b == this.f295i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        bk bkVar = (bk) generateLayoutParams;
        bkVar.f337a |= view instanceof bi;
        if (!this.f309w) {
            super.addView(view, i, generateLayoutParams);
        } else if (bkVar == null || !bkVar.f337a) {
            bkVar.f340d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    bj m351b(int i) {
        for (int i2 = 0; i2 < this.f291e.size(); i2++) {
            bj bjVar = (bj) this.f291e.get(i2);
            if (bjVar.f333b == i) {
                return bjVar;
            }
        }
        return null;
    }

    bj m352b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return m341a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    void m353b() {
        int i;
        int b = this.f294h.mo756b();
        this.f290b = b;
        boolean z = this.f291e.size() < (this.f312z * 2) + 1 && this.f291e.size() < b;
        boolean z2 = false;
        int i2 = this.f295i;
        boolean z3 = z;
        int i3 = 0;
        while (i3 < this.f291e.size()) {
            int i4;
            boolean z4;
            boolean z5;
            bj bjVar = (bj) this.f291e.get(i3);
            int a = this.f294h.m224a(bjVar.f332a);
            if (a == -1) {
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = z3;
            } else if (a == -2) {
                this.f291e.remove(i3);
                i3--;
                if (!z2) {
                    this.f294h.mo15a((ViewGroup) this);
                    z2 = true;
                }
                this.f294h.mo16a((ViewGroup) this, bjVar.f333b, bjVar.f332a);
                if (this.f295i == bjVar.f333b) {
                    i4 = i3;
                    z4 = z2;
                    i = Math.max(0, Math.min(this.f295i, b - 1));
                    z5 = true;
                } else {
                    i4 = i3;
                    z4 = z2;
                    i = i2;
                    z5 = true;
                }
            } else if (bjVar.f333b != a) {
                if (bjVar.f333b == this.f295i) {
                    i2 = a;
                }
                bjVar.f333b = a;
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = true;
            } else {
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = z3;
            }
            z3 = z5;
            i2 = i;
            z2 = z4;
            i3 = i4 + 1;
        }
        if (z2) {
            this.f294h.mo18b((ViewGroup) this);
        }
        Collections.sort(this.f291e, f264c);
        if (z3) {
            i = getChildCount();
            for (i3 = 0; i3 < i; i3++) {
                bk bkVar = (bk) getChildAt(i3).getLayoutParams();
                if (!bkVar.f337a) {
                    bkVar.f339c = 0.0f;
                }
            }
            m347a(i2, false, true);
            requestLayout();
        }
    }

    void m354c() {
        m343a(this.f295i);
    }

    public boolean m355c(int i) {
        View view;
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                d = m356d();
            } else {
                if (i == 66 || i == 2) {
                    d = m357e();
                }
                d = false;
            }
        } else if (i == 17) {
            d = (view == null || m320a(this.f293g, findNextFocus).left < m320a(this.f293g, view).left) ? findNextFocus.requestFocus() : m356d();
        } else {
            if (i == 66) {
                d = (view == null || m320a(this.f293g, findNextFocus).left > m320a(this.f293g, view).left) ? findNextFocus.requestFocus() : m357e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f294h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f305s))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f306t))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof bk) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (this.f299m.isFinished() || !this.f299m.computeScrollOffset()) {
            m327a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f299m.getCurrX();
        int currY = this.f299m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m333d(currX)) {
                this.f299m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ak.m559b(this);
    }

    boolean m356d() {
        if (this.f295i <= 0) {
            return false;
        }
        m346a(this.f295i - 1, true);
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m349a(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == CodedOutputStream.DEFAULT_BUFFER_SIZE) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                bj a = m341a(childAt);
                if (a != null && a.f333b == this.f295i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = ak.m552a(this);
        if (a == 0 || (a == 1 && this.f294h != null && this.f294h.mo756b() > 1)) {
            int height;
            int width;
            if (!this.f282Q.m827a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f305s * ((float) width));
                this.f282Q.m826a(height, width);
                i = 0 | this.f282Q.m829a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.f283R.m827a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f306t + 1.0f)) * ((float) height));
                this.f283R.m826a(width, height);
                i |= this.f283R.m829a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.f282Q.m830b();
            this.f283R.m830b();
        }
        if (i != 0) {
            ak.m559b(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f302p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    boolean m357e() {
        if (this.f294h == null || this.f295i >= this.f294h.mo756b() - 1) {
            return false;
        }
        m346a(this.f295i + 1, true);
        return true;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new bk();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new bk(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public ae getAdapter() {
        return this.f294h;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ad == 2) {
            i2 = (i - 1) - i2;
        }
        return ((bk) ((View) this.ae.get(i2)).getLayoutParams()).f342f;
    }

    public int getCurrentItem() {
        return this.f295i;
    }

    public int getOffscreenPageLimit() {
        return this.f312z;
    }

    public int getPageMargin() {
        return this.f301o;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f284S = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ag);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f301o > 0 && this.f302p != null && this.f291e.size() > 0 && this.f294h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f301o) / ((float) width);
            bj bjVar = (bj) this.f291e.get(0);
            float f2 = bjVar.f336e;
            int size = this.f291e.size();
            int i = bjVar.f333b;
            int i2 = ((bj) this.f291e.get(size - 1)).f333b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > bjVar.f333b && i3 < size) {
                    i3++;
                    bjVar = (bj) this.f291e.get(i3);
                }
                if (i4 == bjVar.f333b) {
                    f3 = (bjVar.f336e + bjVar.f335d) * ((float) width);
                    f2 = (bjVar.f336e + bjVar.f335d) + f;
                } else {
                    float d = this.f294h.m242d(i4);
                    f3 = (f2 + d) * ((float) width);
                    f2 += d + f;
                }
                if (((float) this.f301o) + f3 > ((float) scrollX)) {
                    this.f302p.setBounds((int) f3, this.f303q, (int) ((((float) this.f301o) + f3) + 0.5f), this.f304r);
                    this.f302p.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f266A = false;
            this.f267B = false;
            this.f275J = -1;
            if (this.f276K == null) {
                return false;
            }
            this.f276K.recycle();
            this.f276K = null;
            return false;
        }
        if (action != 0) {
            if (this.f266A) {
                return true;
            }
            if (this.f267B) {
                return false;
            }
        }
        switch (action) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                float x = motionEvent.getX();
                this.f273H = x;
                this.f271F = x;
                x = motionEvent.getY();
                this.f274I = x;
                this.f272G = x;
                this.f275J = C0097z.m749b(motionEvent, 0);
                this.f267B = false;
                this.f299m.computeScrollOffset();
                if (this.ah == 2 && Math.abs(this.f299m.getFinalX() - this.f299m.getCurrX()) > this.f280O) {
                    this.f299m.abortAnimation();
                    this.f311y = false;
                    m354c();
                    this.f266A = true;
                    m332c(true);
                    setScrollState(1);
                    break;
                }
                m327a(false);
                this.f266A = false;
                break;
                break;
            case 2:
                action = this.f275J;
                if (action != -1) {
                    action = C0097z.m747a(motionEvent, action);
                    float c = C0097z.m750c(motionEvent, action);
                    float f = c - this.f271F;
                    float abs = Math.abs(f);
                    float d = C0097z.m752d(motionEvent, action);
                    float abs2 = Math.abs(d - this.f274I);
                    if (f == 0.0f || m328a(this.f271F, f) || !m350a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.f270E) && 0.5f * abs > abs2) {
                            this.f266A = true;
                            m332c(true);
                            setScrollState(1);
                            this.f271F = f > 0.0f ? this.f273H + ((float) this.f270E) : this.f273H - ((float) this.f270E);
                            this.f272G = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f270E)) {
                            this.f267B = true;
                        }
                        if (this.f266A && m331b(c)) {
                            ak.m559b(this);
                            break;
                        }
                    }
                    this.f271F = c;
                    this.f272G = d;
                    this.f267B = true;
                    return false;
                }
                break;
            case 6:
                m326a(motionEvent);
                break;
        }
        if (this.f276K == null) {
            this.f276K = VelocityTracker.obtain();
        }
        this.f276K.addMovement(motionEvent);
        return this.f266A;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        bk bkVar;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                bkVar = (bk) childAt.getLayoutParams();
                if (bkVar.f337a) {
                    int i9 = bkVar.f338b & 112;
                    switch (bkVar.f338b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                bkVar = (bk) childAt2.getLayoutParams();
                if (!bkVar.f337a) {
                    bj a = m341a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.f336e * ((float) max))) + paddingLeft;
                        if (bkVar.f340d) {
                            bkVar.f340d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (bkVar.f339c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f303q = paddingTop;
        this.f304r = i6 - paddingBottom;
        this.f287V = i7;
        if (this.f284S) {
            m323a(this.f295i, false, 0, false);
        }
        this.f284S = false;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f269D = Math.min(measuredWidth / 10, this.f268C);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            bk bkVar;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                bkVar = (bk) childAt.getLayoutParams();
                if (bkVar != null && bkVar.f337a) {
                    int i6 = bkVar.f338b & 7;
                    int i7 = bkVar.f338b & 112;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (bkVar.width != -2) {
                        i7 = 1073741824;
                        i3 = bkVar.width != -1 ? bkVar.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (bkVar.height != -2) {
                        i5 = 1073741824;
                        if (bkVar.height != -1) {
                            measuredWidth = bkVar.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f307u = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f308v = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f309w = true;
        m354c();
        this.f309w = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                bkVar = (bk) childAt2.getLayoutParams();
                if (bkVar == null || !bkVar.f337a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (bkVar.f339c * ((float) paddingLeft)), 1073741824), this.f308v);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                bj a = m341a(childAt);
                if (a != null && a.f333b == this.f295i && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.f294h != null) {
                this.f294h.mo14a(savedState.f261b, savedState.f262c);
                m347a(savedState.f260a, false, true);
                return;
            }
            this.f296j = savedState.f260a;
            this.f297k = savedState.f261b;
            this.f298l = savedState.f262c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f260a = this.f295i;
        if (this.f294h != null) {
            savedState.f261b = this.f294h.mo12a();
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m322a(i, i3, this.f301o, this.f301o);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f281P) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f294h == null || this.f294h.mo756b() == 0) {
            return false;
        }
        if (this.f276K == null) {
            this.f276K = VelocityTracker.obtain();
        }
        this.f276K.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                this.f299m.abortAnimation();
                this.f311y = false;
                m354c();
                x = motionEvent.getX();
                this.f273H = x;
                this.f271F = x;
                x = motionEvent.getY();
                this.f274I = x;
                this.f272G = x;
                this.f275J = C0097z.m749b(motionEvent, 0);
                break;
            case 1:
                if (this.f266A) {
                    VelocityTracker velocityTracker = this.f276K;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f278M);
                    a = (int) af.m542a(velocityTracker, this.f275J);
                    this.f311y = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    bj i = m337i();
                    m348a(m319a(i.f333b, ((((float) scrollX) / ((float) clientWidth)) - i.f336e) / i.f335d, a, (int) (C0097z.m750c(motionEvent, C0097z.m747a(motionEvent, this.f275J)) - this.f273H)), true, true, a);
                    this.f275J = -1;
                    m338j();
                    z = this.f283R.m831c() | this.f282Q.m831c();
                    break;
                }
                break;
            case 2:
                if (!this.f266A) {
                    a = C0097z.m747a(motionEvent, this.f275J);
                    float c = C0097z.m750c(motionEvent, a);
                    float abs = Math.abs(c - this.f271F);
                    float d = C0097z.m752d(motionEvent, a);
                    x = Math.abs(d - this.f272G);
                    if (abs > ((float) this.f270E) && abs > x) {
                        this.f266A = true;
                        m332c(true);
                        this.f271F = c - this.f273H > 0.0f ? this.f273H + ((float) this.f270E) : this.f273H - ((float) this.f270E);
                        this.f272G = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f266A) {
                    z = false | m331b(C0097z.m750c(motionEvent, C0097z.m747a(motionEvent, this.f275J)));
                    break;
                }
                break;
            case 3:
                if (this.f266A) {
                    m323a(this.f295i, true, 0, false);
                    this.f275J = -1;
                    m338j();
                    z = this.f283R.m831c() | this.f282Q.m831c();
                    break;
                }
                break;
            case 5:
                a = C0097z.m748b(motionEvent);
                this.f271F = C0097z.m750c(motionEvent, a);
                this.f275J = C0097z.m749b(motionEvent, a);
                break;
            case 6:
                m326a(motionEvent);
                this.f271F = C0097z.m750c(motionEvent, C0097z.m747a(motionEvent, this.f275J));
                break;
        }
        if (z) {
            ak.m559b(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.f309w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(ae aeVar) {
        if (this.f294h != null) {
            this.f294h.m236b(this.f300n);
            this.f294h.mo15a((ViewGroup) this);
            for (int i = 0; i < this.f291e.size(); i++) {
                bj bjVar = (bj) this.f291e.get(i);
                this.f294h.mo16a((ViewGroup) this, bjVar.f333b, bjVar.f332a);
            }
            this.f294h.mo18b((ViewGroup) this);
            this.f291e.clear();
            m335g();
            this.f295i = 0;
            scrollTo(0, 0);
        }
        ae aeVar2 = this.f294h;
        this.f294h = aeVar;
        this.f290b = 0;
        if (this.f294h != null) {
            if (this.f300n == null) {
                this.f300n = new bp();
            }
            this.f294h.m228a(this.f300n);
            this.f311y = false;
            boolean z = this.f284S;
            this.f284S = true;
            this.f290b = this.f294h.mo756b();
            if (this.f296j >= 0) {
                this.f294h.mo14a(this.f297k, this.f298l);
                m347a(this.f296j, false, true);
                this.f296j = -1;
                this.f297k = null;
                this.f298l = null;
            } else if (z) {
                requestLayout();
            } else {
                m354c();
            }
        }
        if (this.aa != null && aeVar2 != aeVar) {
            this.aa.m662a(aeVar2, aeVar);
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ac == null) {
                try {
                    this.ac = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ac.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.f311y = false;
        m347a(i, !this.f284S, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f312z) {
            this.f312z = i;
            m354c();
        }
    }

    void setOnAdapterChangeListener(bm bmVar) {
        this.aa = bmVar;
    }

    public void setOnPageChangeListener(bn bnVar) {
        this.f288W = bnVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.f301o;
        this.f301o = i;
        int width = getWidth();
        m322a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f302p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f302p;
    }
}
