package android.support.v4.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ak;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.vending.licensing.APKExpansionPolicy;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    static final C0118u f379a;
    private int f380b;
    private int f381c;
    private Drawable f382d;
    private final int f383e;
    private boolean f384f;
    private View f385g;
    private float f386h;
    private float f387i;
    private int f388j;
    private boolean f389k;
    private int f390l;
    private float f391m;
    private float f392n;
    private C0116s f393o;
    private final C0122y f394p;
    private boolean f395q;
    private boolean f396r;
    private final Rect f397s;
    private final ArrayList f398t;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new C0117t();
        boolean f378a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f378a = parcel.readInt() != 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f378a ? 1 : 0);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            f379a = new C0121x();
        } else if (i >= 16) {
            f379a = new C0120w();
        } else {
            f379a = new C0119v();
        }
    }

    private void m779a(float f) {
        int i = 0;
        C0115r c0115r = (C0115r) this.f385g.getLayoutParams();
        int i2 = (!c0115r.f416c || c0115r.leftMargin > 0) ? 0 : 1;
        int childCount = getChildCount();
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt != this.f385g) {
                int i3 = (int) ((1.0f - this.f387i) * ((float) this.f390l));
                this.f387i = f;
                childAt.offsetLeftAndRight(i3 - ((int) ((1.0f - f) * ((float) this.f390l))));
                if (i2 != 0) {
                    m781a(childAt, 1.0f - this.f387i, this.f381c);
                }
            }
            i++;
        }
    }

    private void m781a(View view, float f, int i) {
        C0115r c0115r = (C0115r) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (c0115r.f417d == null) {
                c0115r.f417d = new Paint();
            }
            c0115r.f417d.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (ak.m562d(view) != 2) {
                ak.m554a(view, 2, c0115r.f417d);
            }
            m785d(view);
        } else if (ak.m562d(view) != 0) {
            if (c0115r.f417d != null) {
                c0115r.f417d.setColorFilter(null);
            }
            Runnable c0114q = new C0114q(this, view);
            this.f398t.add(c0114q);
            ak.m557a((View) this, c0114q);
        }
    }

    private boolean m782a(View view, int i) {
        if (!this.f396r && !m788a(0.0f, i)) {
            return false;
        }
        this.f395q = false;
        return true;
    }

    private boolean m783b(View view, int i) {
        if (!this.f396r && !m788a(1.0f, i)) {
            return false;
        }
        this.f395q = true;
        return true;
    }

    private static boolean m784c(View view) {
        if (ak.m564f(view)) {
            return true;
        }
        if (VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        return background != null ? background.getOpacity() == -1 : false;
    }

    private void m785d(View view) {
        f379a.mo150a(this, view);
    }

    void m786a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    void m787a(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view == null || !m784c(view)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i4 = view.getLeft();
            i3 = view.getRight();
            i2 = view.getTop();
            i = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                int i6 = (Math.max(paddingLeft, childAt.getLeft()) < i4 || Math.max(paddingTop, childAt.getTop()) < i2 || Math.min(width, childAt.getRight()) > i3 || Math.min(height, childAt.getBottom()) > i) ? 0 : 4;
                childAt.setVisibility(i6);
                i5++;
            } else {
                return;
            }
        }
    }

    boolean m788a(float f, int i) {
        if (!this.f384f) {
            return false;
        }
        C0115r c0115r = (C0115r) this.f385g.getLayoutParams();
        if (!this.f394p.m929a(this.f385g, (int) (((float) (c0115r.leftMargin + getPaddingLeft())) + (((float) this.f388j) * f)), this.f385g.getTop())) {
            return false;
        }
        m786a();
        ak.m559b(this);
        return true;
    }

    public boolean m789b() {
        return m783b(this.f385g, 0);
    }

    boolean m790b(View view) {
        if (view == null) {
            return false;
        }
        boolean z = this.f384f && ((C0115r) view.getLayoutParams()).f416c && this.f386h > 0.0f;
        return z;
    }

    public boolean m791c() {
        return m782a(this.f385g, 0);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0115r) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (!this.f394p.m930a(true)) {
            return;
        }
        if (this.f384f) {
            ak.m559b(this);
        } else {
            this.f394p.m943f();
        }
    }

    public boolean m792d() {
        return !this.f384f || this.f386h == 1.0f;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && this.f382d != null) {
            int intrinsicWidth = this.f382d.getIntrinsicWidth();
            int left = childAt.getLeft();
            this.f382d.setBounds(left - intrinsicWidth, childAt.getTop(), left, childAt.getBottom());
            this.f382d.draw(canvas);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        C0115r c0115r = (C0115r) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.f384f || c0115r.f415b || this.f385g == null)) {
            canvas.getClipBounds(this.f397s);
            this.f397s.right = Math.min(this.f397s.right, this.f385g.getLeft());
            canvas.clipRect(this.f397s);
        }
        if (VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view, j);
        } else if (!c0115r.f416c || this.f386h <= 0.0f) {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas, view, j);
        } else {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), c0115r.f417d);
                drawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                drawChild = super.drawChild(canvas, view, j);
            }
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    public boolean m793e() {
        return this.f384f;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0115r();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0115r(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new C0115r((MarginLayoutParams) layoutParams) : new C0115r(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.f381c;
    }

    public int getParallaxDistance() {
        return this.f390l;
    }

    public int getSliderFadeColor() {
        return this.f380b;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f396r = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f396r = true;
        int size = this.f398t.size();
        for (int i = 0; i < size; i++) {
            ((C0114q) this.f398t.get(i)).run();
        }
        this.f398t.clear();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r3 = android.support.v4.view.C0097z.m746a(r8);
        r0 = r7.f384f;
        if (r0 != 0) goto L_0x002d;
    L_0x000a:
        if (r3 != 0) goto L_0x002d;
    L_0x000c:
        r0 = r7.getChildCount();
        if (r0 <= r1) goto L_0x002d;
    L_0x0012:
        r0 = r7.getChildAt(r1);
        if (r0 == 0) goto L_0x002d;
    L_0x0018:
        r4 = r7.f394p;
        r5 = r8.getX();
        r5 = (int) r5;
        r6 = r8.getY();
        r6 = (int) r6;
        r0 = r4.m936b(r0, r5, r6);
        if (r0 != 0) goto L_0x0041;
    L_0x002a:
        r0 = r1;
    L_0x002b:
        r7.f395q = r0;
    L_0x002d:
        r0 = r7.f384f;
        if (r0 == 0) goto L_0x0037;
    L_0x0031:
        r0 = r7.f389k;
        if (r0 == 0) goto L_0x0043;
    L_0x0035:
        if (r3 == 0) goto L_0x0043;
    L_0x0037:
        r0 = r7.f394p;
        r0.m942e();
        r2 = super.onInterceptTouchEvent(r8);
    L_0x0040:
        return r2;
    L_0x0041:
        r0 = r2;
        goto L_0x002b;
    L_0x0043:
        r0 = 3;
        if (r3 == r0) goto L_0x0048;
    L_0x0046:
        if (r3 != r1) goto L_0x004e;
    L_0x0048:
        r0 = r7.f394p;
        r0.m942e();
        goto L_0x0040;
    L_0x004e:
        switch(r3) {
            case 0: goto L_0x005e;
            case 1: goto L_0x0051;
            case 2: goto L_0x0082;
            default: goto L_0x0051;
        };
    L_0x0051:
        r0 = r2;
    L_0x0052:
        r3 = r7.f394p;
        r3 = r3.m928a(r8);
        if (r3 != 0) goto L_0x005c;
    L_0x005a:
        if (r0 == 0) goto L_0x0040;
    L_0x005c:
        r2 = r1;
        goto L_0x0040;
    L_0x005e:
        r7.f389k = r2;
        r0 = r8.getX();
        r3 = r8.getY();
        r7.f391m = r0;
        r7.f392n = r3;
        r4 = r7.f394p;
        r5 = r7.f385g;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r4.m936b(r5, r0, r3);
        if (r0 == 0) goto L_0x0051;
    L_0x0078:
        r0 = r7.f385g;
        r0 = r7.m790b(r0);
        if (r0 == 0) goto L_0x0051;
    L_0x0080:
        r0 = r1;
        goto L_0x0052;
    L_0x0082:
        r0 = r8.getX();
        r3 = r8.getY();
        r4 = r7.f391m;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r7.f392n;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r7.f394p;
        r4 = r4.m940d();
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x0051;
    L_0x00a3:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0051;
    L_0x00a7:
        r0 = r7.f394p;
        r0.m942e();
        r7.f389k = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f396r) {
            float f = (this.f384f && this.f395q) ? 1.0f : 0.0f;
            this.f386h = f;
        }
        int i6 = 0;
        int i7 = paddingLeft;
        while (i6 < childCount) {
            int i8;
            int i9;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                i8 = i7;
            } else {
                C0115r c0115r = (C0115r) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (c0115r.f415b) {
                    int min = (Math.min(paddingLeft, (i5 - paddingRight) - this.f383e) - i7) - (c0115r.leftMargin + c0115r.rightMargin);
                    this.f388j = min;
                    c0115r.f416c = ((c0115r.leftMargin + i7) + min) + (measuredWidth / 2) > i5 - paddingRight;
                    i8 = (c0115r.leftMargin + ((int) (((float) min) * this.f386h))) + i7;
                    i9 = 0;
                } else if (!this.f384f || this.f390l == 0) {
                    i9 = 0;
                    i8 = paddingLeft;
                } else {
                    i9 = (int) ((1.0f - this.f386h) * ((float) this.f390l));
                    i8 = paddingLeft;
                }
                i9 = i8 - i9;
                childAt.layout(i9, paddingTop, i9 + measuredWidth, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft += childAt.getWidth();
            }
            i6++;
            i7 = i8;
        }
        if (this.f396r) {
            if (this.f384f) {
                if (this.f390l != 0) {
                    m779a(this.f386h);
                }
                if (((C0115r) this.f385g.getLayoutParams()).f416c) {
                    m781a(this.f385g, this.f386h, this.f380b);
                }
            } else {
                for (i9 = 0; i9 < childCount; i9++) {
                    m781a(getChildAt(i9), 0.0f, this.f380b);
                }
            }
            m787a(this.f385g);
        }
        this.f396r = false;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = 300;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (!isInEditMode()) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode == Integer.MIN_VALUE) {
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            if (mode == 0) {
                i3 = mode2;
                i4 = 300;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        }
        switch (i3) {
            case Integer.MIN_VALUE:
                size2 = 0;
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                mode2 = size2;
                break;
            default:
                size2 = 0;
                mode2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f385g = null;
        int i5 = 0;
        int i6 = size2;
        float f = 0.0f;
        while (i5 < childCount) {
            float f2;
            int i7;
            boolean z2;
            View childAt = getChildAt(i5);
            C0115r c0115r = (C0115r) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                c0115r.f416c = false;
                size2 = paddingLeft;
                f2 = f;
                i7 = i6;
                z2 = z;
            } else {
                if (c0115r.f414a > 0.0f) {
                    f += c0115r.f414a;
                    if (c0115r.width == 0) {
                        size2 = paddingLeft;
                        f2 = f;
                        i7 = i6;
                        z2 = z;
                    }
                }
                mode = c0115r.leftMargin + c0115r.rightMargin;
                mode = c0115r.width == -2 ? MeasureSpec.makeMeasureSpec(i4 - mode, Integer.MIN_VALUE) : c0115r.width == -1 ? MeasureSpec.makeMeasureSpec(i4 - mode, 1073741824) : MeasureSpec.makeMeasureSpec(c0115r.width, 1073741824);
                i7 = c0115r.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE) : c0115r.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(c0115r.height, 1073741824);
                childAt.measure(mode, i7);
                mode = childAt.getMeasuredWidth();
                i7 = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && i7 > i6) {
                    i6 = Math.min(i7, mode2);
                }
                i7 = paddingLeft - mode;
                boolean z3 = i7 < 0;
                c0115r.f415b = z3;
                z3 |= z;
                if (c0115r.f415b) {
                    this.f385g = childAt;
                }
                size2 = i7;
                i7 = i6;
                float f3 = f;
                z2 = z3;
                f2 = f3;
            }
            i5++;
            z = z2;
            i6 = i7;
            f = f2;
            paddingLeft = size2;
        }
        if (z || f > 0.0f) {
            int i8 = i4 - this.f383e;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    c0115r = (C0115r) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (c0115r.width != 0 || c0115r.f414a <= 0.0f) ? null : 1;
                        i7 = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.f385g) {
                            if (c0115r.f414a > 0.0f) {
                                mode = c0115r.width == 0 ? c0115r.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE) : c0115r.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(c0115r.height, 1073741824) : MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                if (z) {
                                    size2 = i4 - (c0115r.rightMargin + c0115r.leftMargin);
                                    i5 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                    if (i7 != size2) {
                                        childAt2.measure(i5, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((c0115r.f414a * ((float) Math.max(0, paddingLeft))) / f)) + i7, 1073741824), mode);
                                }
                            }
                        } else if (c0115r.width < 0 && (i7 > i8 || c0115r.f414a > 0.0f)) {
                            size2 = obj != null ? c0115r.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE) : c0115r.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(c0115r.height, 1073741824) : MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i8, 1073741824), size2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, i6);
        this.f384f = z;
        if (this.f394p.m924a() != 0 && !z) {
            this.f394p.m943f();
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f378a) {
            m789b();
        } else {
            m791c();
        }
        this.f395q = savedState.f378a;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f378a = m793e() ? m792d() : this.f395q;
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f396r = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f384f) {
            return super.onTouchEvent(motionEvent);
        }
        this.f394p.m933b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f391m = x;
                this.f392n = y;
                return true;
            case 1:
                if (!m790b(this.f385g)) {
                    return true;
                }
                x = motionEvent.getX();
                y = motionEvent.getY();
                float f = x - this.f391m;
                float f2 = y - this.f392n;
                int d = this.f394p.m940d();
                if ((f * f) + (f2 * f2) >= ((float) (d * d)) || !this.f394p.m936b(this.f385g, (int) x, (int) y)) {
                    return true;
                }
                m782a(this.f385g, 0);
                return true;
            default:
                return true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f384f) {
            this.f395q = view == this.f385g;
        }
    }

    public void setCoveredFadeColor(int i) {
        this.f381c = i;
    }

    public void setPanelSlideListener(C0116s c0116s) {
        this.f393o = c0116s;
    }

    public void setParallaxDistance(int i) {
        this.f390l = i;
        requestLayout();
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f382d = drawable;
    }

    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setSliderFadeColor(int i) {
        this.f380b = i;
    }
}
