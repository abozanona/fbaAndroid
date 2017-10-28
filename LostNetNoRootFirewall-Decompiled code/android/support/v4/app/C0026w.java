package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0026w implements Creator {
    C0026w() {
    }

    public SavedState m256a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m257a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m256a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m257a(i);
    }
}
