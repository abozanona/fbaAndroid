package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0007d implements Creator {
    C0007d() {
    }

    public BackStackState m138a(Parcel parcel) {
        return new BackStackState(parcel);
    }

    public BackStackState[] m139a(int i) {
        return new BackStackState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m138a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m139a(i);
    }
}
