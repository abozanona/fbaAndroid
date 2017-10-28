package android.support.v4.app;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList f74a;
    private Context f75b;
    private C0017n f76c;
    private int f77d;
    private OnTabChangeListener f78e;
    private C0027x f79f;
    private boolean f80g;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new C0026w();
        String f73a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f73a = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f73a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f73a);
        }
    }

    private C0004y m74a(String str, C0004y c0004y) {
        C0027x c0027x = null;
        int i = 0;
        while (i < this.f74a.size()) {
            C0027x c0027x2 = (C0027x) this.f74a.get(i);
            if (!c0027x2.f220a.equals(str)) {
                c0027x2 = c0027x;
            }
            i++;
            c0027x = c0027x2;
        }
        if (c0027x == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f79f != c0027x) {
            if (c0004y == null) {
                c0004y = this.f76c.mo10a();
            }
            if (!(this.f79f == null || this.f79f.f223d == null)) {
                c0004y.mo5a(this.f79f.f223d);
            }
            if (c0027x != null) {
                if (c0027x.f223d == null) {
                    c0027x.f223d = Fragment.m12a(this.f75b, c0027x.f221b.getName(), c0027x.f222c);
                    c0004y.mo4a(this.f77d, c0027x.f223d, c0027x.f220a);
                } else {
                    c0004y.mo7b(c0027x.f223d);
                }
            }
            this.f79f = c0027x;
        }
        return c0004y;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        C0004y c0004y = null;
        for (int i = 0; i < this.f74a.size(); i++) {
            C0027x c0027x = (C0027x) this.f74a.get(i);
            c0027x.f223d = this.f76c.mo9a(c0027x.f220a);
            if (!(c0027x.f223d == null || c0027x.f223d.m47e())) {
                if (c0027x.f220a.equals(currentTabTag)) {
                    this.f79f = c0027x;
                } else {
                    if (c0004y == null) {
                        c0004y = this.f76c.mo10a();
                    }
                    c0004y.mo5a(c0027x.f223d);
                }
            }
        }
        this.f80g = true;
        C0004y a = m74a(currentTabTag, c0004y);
        if (a != null) {
            a.mo3a();
            this.f76c.mo11b();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f80g = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f73a);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f73a = getCurrentTabTag();
        return savedState;
    }

    public void onTabChanged(String str) {
        if (this.f80g) {
            C0004y a = m74a(str, null);
            if (a != null) {
                a.mo3a();
            }
        }
        if (this.f78e != null) {
            this.f78e.onTabChanged(str);
        }
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.f78e = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}
