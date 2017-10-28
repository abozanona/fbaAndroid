package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0117t implements Creator {
    C0117t() {
    }

    public SavedState m900a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m901a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m900a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m901a(i);
    }
}
