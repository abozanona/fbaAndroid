package android.support.v4.view;

import android.os.Parcel;
import android.support.v4.p001b.C0030c;
import android.support.v4.view.ViewPager.SavedState;

final class bq implements C0030c {
    bq() {
    }

    public /* synthetic */ Object mo98a(Parcel parcel, ClassLoader classLoader) {
        return m669b(parcel, classLoader);
    }

    public /* synthetic */ Object[] mo99a(int i) {
        return m670b(i);
    }

    public SavedState m669b(Parcel parcel, ClassLoader classLoader) {
        return new SavedState(parcel, classLoader);
    }

    public SavedState[] m670b(int i) {
        return new SavedState[i];
    }
}
