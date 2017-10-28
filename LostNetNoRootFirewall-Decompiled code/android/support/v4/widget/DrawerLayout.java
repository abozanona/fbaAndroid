package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0085n;
import android.support.v4.view.C0090s;
import android.support.v4.view.ak;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.vending.licensing.APKExpansionPolicy;

public class DrawerLayout extends ViewGroup {
    private static final int[] f357a = new int[]{16842931};
    private int f358b;
    private int f359c;
    private float f360d;
    private Paint f361e;
    private final C0122y f362f;
    private final C0122y f363g;
    private final C0101d f364h;
    private final C0101d f365i;
    private int f366j;
    private boolean f367k;
    private boolean f368l;
    private int f369m;
    private int f370n;
    private boolean f371o;
    private boolean f372p;
    private C0098a f373q;
    private float f374r;
    private float f375s;
    private Drawable f376t;
    private Drawable f377u;

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new C0100c();
        int f354a = 0;
        int f355b = 0;
        int f356c = 0;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f354a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f354a);
        }
    }

    static String m753b(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    private boolean m755d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((C0099b) getChildAt(i).getLayoutParams()).f401c) {
                return true;
            }
        }
        return false;
    }

    private boolean m756e() {
        return m757f() != null;
    }

    private View m757f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m774g(childAt) && m777j(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    private static boolean m758k(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public int m759a(View view) {
        int e = m772e(view);
        return e == 3 ? this.f369m : e == 5 ? this.f370n : 0;
    }

    View m760a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((C0099b) childAt.getLayoutParams()).f402d) {
                return childAt;
            }
        }
        return null;
    }

    View m761a(int i) {
        int a = C0085n.m722a(i, ak.m563e(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m772e(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    public void m762a(int i, int i2) {
        int a = C0085n.m722a(i2, ak.m563e(this));
        if (a == 3) {
            this.f369m = i;
        } else if (a == 5) {
            this.f370n = i;
        }
        if (i != 0) {
            (a == 3 ? this.f362f : this.f363g).m942e();
        }
        View a2;
        switch (i) {
            case 1:
                a2 = m761a(a);
                if (a2 != null) {
                    m776i(a2);
                    return;
                }
                return;
            case 2:
                a2 = m761a(a);
                if (a2 != null) {
                    m775h(a2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    void m763a(int i, int i2, View view) {
        int i3 = 1;
        int a = this.f362f.m924a();
        int a2 = this.f363g.m924a();
        if (!(a == 1 || a2 == 1)) {
            i3 = (a == 2 || a2 == 2) ? 2 : 0;
        }
        if (view != null && i2 == 0) {
            C0099b c0099b = (C0099b) view.getLayoutParams();
            if (c0099b.f400b == 0.0f) {
                m768b(view);
            } else if (c0099b.f400b == 1.0f) {
                m770c(view);
            }
        }
        if (i3 != this.f366j) {
            this.f366j = i3;
            if (this.f373q != null) {
                this.f373q.m794a(i3);
            }
        }
    }

    void m764a(View view, float f) {
        if (this.f373q != null) {
            this.f373q.m796a(view, f);
        }
    }

    void m765a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0099b c0099b = (C0099b) childAt.getLayoutParams();
            if (m774g(childAt) && (!z || c0099b.f401c)) {
                i = m766a(childAt, 3) ? i | this.f362f.m929a(childAt, -childAt.getWidth(), childAt.getTop()) : i | this.f363g.m929a(childAt, getWidth(), childAt.getTop());
                c0099b.f401c = false;
            }
        }
        this.f364h.m816a();
        this.f365i.m816a();
        if (i != 0) {
            invalidate();
        }
    }

    boolean m766a(View view, int i) {
        return (m772e(view) & i) == i;
    }

    public void m767b() {
        m765a(false);
    }

    void m768b(View view) {
        C0099b c0099b = (C0099b) view.getLayoutParams();
        if (c0099b.f402d) {
            c0099b.f402d = false;
            if (this.f373q != null) {
                this.f373q.m797b(view);
            }
            sendAccessibilityEvent(32);
        }
    }

    void m769b(View view, float f) {
        C0099b c0099b = (C0099b) view.getLayoutParams();
        if (f != c0099b.f400b) {
            c0099b.f400b = f;
            m764a(view, f);
        }
    }

    void m770c(View view) {
        C0099b c0099b = (C0099b) view.getLayoutParams();
        if (!c0099b.f402d) {
            c0099b.f402d = true;
            if (this.f373q != null) {
                this.f373q.m795a(view);
            }
            view.sendAccessibilityEvent(32);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0099b) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((C0099b) getChildAt(i).getLayoutParams()).f400b);
        }
        this.f360d = f;
        if ((this.f362f.m930a(true) | this.f363g.m930a(true)) != 0) {
            ak.m559b(this);
        }
    }

    float m771d(View view) {
        return ((C0099b) view.getLayoutParams()).f400b;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean f = m773f(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && m758k(childAt) && m774g(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (m766a(childAt, 3)) {
                        i = childAt.getRight();
                        if (i <= i2) {
                            i = i2;
                        }
                        i2 = i;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        i = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.f360d > 0.0f && f) {
            this.f361e.setColor((((int) (((float) ((this.f359c & -16777216) >>> 24)) * this.f360d)) << 24) | (this.f359c & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.f361e);
        } else if (this.f376t != null && m766a(view, 3)) {
            i = this.f376t.getIntrinsicWidth();
            i2 = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i2) / ((float) this.f362f.m931b()), 1.0f));
            this.f376t.setBounds(i2, view.getTop(), i + i2, view.getBottom());
            this.f376t.setAlpha((int) (255.0f * r2));
            this.f376t.draw(canvas);
        } else if (this.f377u != null && m766a(view, 5)) {
            i = this.f377u.getIntrinsicWidth();
            i2 = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.f363g.m931b()), 1.0f));
            this.f377u.setBounds(i2 - i, view.getTop(), i2, view.getBottom());
            this.f377u.setAlpha((int) (255.0f * r2));
            this.f377u.draw(canvas);
        }
        return drawChild;
    }

    int m772e(View view) {
        return C0085n.m722a(((C0099b) view.getLayoutParams()).f399a, ak.m563e(this));
    }

    boolean m773f(View view) {
        return ((C0099b) view.getLayoutParams()).f399a == 0;
    }

    boolean m774g(View view) {
        return (C0085n.m722a(((C0099b) view.getLayoutParams()).f399a, ak.m563e(view)) & 7) != 0;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0099b(-1, -1);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0099b(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0099b ? new C0099b((C0099b) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0099b((MarginLayoutParams) layoutParams) : new C0099b(layoutParams);
    }

    public void m775h(View view) {
        if (m774g(view)) {
            if (this.f368l) {
                C0099b c0099b = (C0099b) view.getLayoutParams();
                c0099b.f400b = 1.0f;
                c0099b.f402d = true;
            } else if (m766a(view, 3)) {
                this.f362f.m929a(view, 0, view.getTop());
            } else {
                this.f363g.m929a(view, getWidth() - view.getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void m776i(View view) {
        if (m774g(view)) {
            if (this.f368l) {
                C0099b c0099b = (C0099b) view.getLayoutParams();
                c0099b.f400b = 0.0f;
                c0099b.f402d = false;
            } else if (m766a(view, 3)) {
                this.f362f.m929a(view, -view.getWidth(), view.getTop());
            } else {
                this.f363g.m929a(view, getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public boolean m777j(View view) {
        if (m774g(view)) {
            return ((C0099b) view.getLayoutParams()).f400b > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f368l = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f368l = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.view.C0097z.m746a(r8);
        r3 = r7.f362f;
        r3 = r3.m928a(r8);
        r4 = r7.f363g;
        r4 = r4.m928a(r8);
        r3 = r3 | r4;
        switch(r0) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0063;
            case 2: goto L_0x004e;
            case 3: goto L_0x0063;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r3 != 0) goto L_0x0025;
    L_0x0019:
        if (r0 != 0) goto L_0x0025;
    L_0x001b:
        r0 = r7.m755d();
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r0 = r7.f372p;
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        return r2;
    L_0x0027:
        r0 = r8.getX();
        r4 = r8.getY();
        r7.f374r = r0;
        r7.f375s = r4;
        r5 = r7.f360d;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x006b;
    L_0x003a:
        r5 = r7.f362f;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.m941d(r0, r4);
        r0 = r7.m773f(r0);
        if (r0 == 0) goto L_0x006b;
    L_0x0048:
        r0 = r1;
    L_0x0049:
        r7.f371o = r2;
        r7.f372p = r2;
        goto L_0x0017;
    L_0x004e:
        r0 = r7.f362f;
        r4 = 3;
        r0 = r0.m938c(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0057:
        r0 = r7.f364h;
        r0.m816a();
        r0 = r7.f365i;
        r0.m816a();
        r0 = r2;
        goto L_0x0017;
    L_0x0063:
        r7.m765a(r1);
        r7.f371o = r2;
        r7.f372p = r2;
        goto L_0x0016;
    L_0x006b:
        r0 = r2;
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m756e()) {
            return super.onKeyDown(i, keyEvent);
        }
        C0090s.m729b(keyEvent);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View f = m757f();
        if (f != null && m759a(f) == 0) {
            m767b();
        }
        return f != null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f367k = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0099b c0099b = (C0099b) childAt.getLayoutParams();
                if (m773f(childAt)) {
                    childAt.layout(c0099b.leftMargin, c0099b.topMargin, c0099b.leftMargin + childAt.getMeasuredWidth(), c0099b.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m766a(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * c0099b.f400b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * c0099b.f400b));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != c0099b.f400b ? 1 : null;
                    int i8;
                    switch (c0099b.f399a & 112) {
                        case 16:
                            int i9 = i4 - i2;
                            i8 = (i9 - measuredHeight) / 2;
                            if (i8 < c0099b.topMargin) {
                                i8 = c0099b.topMargin;
                            } else if (i8 + measuredHeight > i9 - c0099b.bottomMargin) {
                                i8 = (i9 - c0099b.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                            break;
                        case 80:
                            i8 = i4 - i2;
                            childAt.layout(i7, (i8 - c0099b.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i8 - c0099b.bottomMargin);
                            break;
                        default:
                            childAt.layout(i7, c0099b.topMargin, measuredWidth + i7, measuredHeight + c0099b.topMargin);
                            break;
                    }
                    if (obj != null) {
                        m769b(childAt, f);
                    }
                    int i10 = c0099b.f400b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.f367k = false;
        this.f368l = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r12, int r13) {
        /*
        r11 = this;
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r4 = 0;
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = android.view.View.MeasureSpec.getMode(r12);
        r5 = android.view.View.MeasureSpec.getMode(r13);
        r2 = android.view.View.MeasureSpec.getSize(r12);
        r0 = android.view.View.MeasureSpec.getSize(r13);
        if (r3 != r10) goto L_0x001b;
    L_0x0019:
        if (r5 == r10) goto L_0x0046;
    L_0x001b:
        r6 = r11.isInEditMode();
        if (r6 == 0) goto L_0x0048;
    L_0x0021:
        if (r3 != r7) goto L_0x0040;
    L_0x0023:
        if (r5 != r7) goto L_0x0044;
    L_0x0025:
        r1 = r0;
    L_0x0026:
        r11.setMeasuredDimension(r2, r1);
        r5 = r11.getChildCount();
        r3 = r4;
    L_0x002e:
        if (r3 >= r5) goto L_0x0109;
    L_0x0030:
        r6 = r11.getChildAt(r3);
        r0 = r6.getVisibility();
        r7 = 8;
        if (r0 != r7) goto L_0x0050;
    L_0x003c:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x002e;
    L_0x0040:
        if (r3 != 0) goto L_0x0023;
    L_0x0042:
        r2 = r1;
        goto L_0x0023;
    L_0x0044:
        if (r5 == 0) goto L_0x0026;
    L_0x0046:
        r1 = r0;
        goto L_0x0026;
    L_0x0048:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "DrawerLayout must be measured with MeasureSpec.EXACTLY.";
        r0.<init>(r1);
        throw r0;
    L_0x0050:
        r0 = r6.getLayoutParams();
        r0 = (android.support.v4.widget.C0099b) r0;
        r7 = r11.m773f(r6);
        if (r7 == 0) goto L_0x0077;
    L_0x005c:
        r7 = r0.leftMargin;
        r7 = r2 - r7;
        r8 = r0.rightMargin;
        r7 = r7 - r8;
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r10);
        r8 = r0.topMargin;
        r8 = r1 - r8;
        r0 = r0.bottomMargin;
        r0 = r8 - r0;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r10);
        r6.measure(r7, r0);
        goto L_0x003c;
    L_0x0077:
        r7 = r11.m774g(r6);
        if (r7 == 0) goto L_0x00da;
    L_0x007d:
        r7 = r11.m772e(r6);
        r7 = r7 & 7;
        r8 = r4 & r7;
        if (r8 == 0) goto L_0x00bc;
    L_0x0087:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child drawer has absolute gravity ";
        r1 = r1.append(r2);
        r2 = m753b(r7);
        r1 = r1.append(r2);
        r2 = " but this ";
        r1 = r1.append(r2);
        r2 = "DrawerLayout";
        r1 = r1.append(r2);
        r2 = " already has a ";
        r1 = r1.append(r2);
        r2 = "drawer view along that edge";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00bc:
        r7 = r11.f358b;
        r8 = r0.leftMargin;
        r7 = r7 + r8;
        r8 = r0.rightMargin;
        r7 = r7 + r8;
        r8 = r0.width;
        r7 = getChildMeasureSpec(r12, r7, r8);
        r8 = r0.topMargin;
        r9 = r0.bottomMargin;
        r8 = r8 + r9;
        r0 = r0.height;
        r0 = getChildMeasureSpec(r13, r8, r0);
        r6.measure(r7, r0);
        goto L_0x003c;
    L_0x00da:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child ";
        r1 = r1.append(r2);
        r1 = r1.append(r6);
        r2 = " at index ";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r2 = " does not have a valid layout_gravity - must be Gravity.LEFT, ";
        r1 = r1.append(r2);
        r2 = "Gravity.RIGHT or Gravity.NO_GRAVITY";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0109:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f354a != 0) {
            View a = m761a(savedState.f354a);
            if (a != null) {
                m775h(a);
            }
        }
        m762a(savedState.f355b, 3);
        m762a(savedState.f356c, 5);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m774g(childAt)) {
                C0099b c0099b = (C0099b) childAt.getLayoutParams();
                if (c0099b.f402d) {
                    savedState.f354a = c0099b.f399a;
                    break;
                }
            }
        }
        savedState.f355b = this.f369m;
        savedState.f356c = this.f370n;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f362f.m933b(motionEvent);
        this.f363g.m933b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f374r = x;
                this.f375s = y;
                this.f371o = false;
                this.f372p = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View d = this.f362f.m941d((int) x, (int) y);
                if (d != null && m773f(d)) {
                    x -= this.f374r;
                    y -= this.f375s;
                    int d2 = this.f362f.m940d();
                    if ((x * x) + (y * y) < ((float) (d2 * d2))) {
                        View a = m760a();
                        if (a != null) {
                            z = m759a(a) == 2;
                            m765a(z);
                            this.f371o = false;
                            break;
                        }
                    }
                }
                z = true;
                m765a(z);
                this.f371o = false;
            case 3:
                m765a(true);
                this.f371o = false;
                this.f372p = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f371o = z;
        if (z) {
            m765a(true);
        }
    }

    public void requestLayout() {
        if (!this.f367k) {
            super.requestLayout();
        }
    }

    public void setDrawerListener(C0098a c0098a) {
        this.f373q = c0098a;
    }

    public void setDrawerLockMode(int i) {
        m762a(i, 3);
        m762a(i, 5);
    }

    public void setScrimColor(int i) {
        this.f359c = i;
        invalidate();
    }
}
