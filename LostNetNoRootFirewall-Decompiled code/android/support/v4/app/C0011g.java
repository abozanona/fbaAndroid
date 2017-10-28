package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment.SavedState;

final class C0011g implements Creator {
    C0011g() {
    }

    public SavedState m142a(Parcel parcel) {
        return new SavedState(parcel, null);
    }

    public SavedState[] m143a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m142a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m143a(i);
    }
}
