package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0022s implements Creator {
    C0022s() {
    }

    public FragmentManagerState m222a(Parcel parcel) {
        return new FragmentManagerState(parcel);
    }

    public FragmentManagerState[] m223a(int i) {
        return new FragmentManagerState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m222a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m223a(i);
    }
}
