package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0024u implements Creator {
    C0024u() {
    }

    public FragmentState m254a(Parcel parcel) {
        return new FragmentState(parcel);
    }

    public FragmentState[] m255a(int i) {
        return new FragmentState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m254a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m255a(i);
    }
}
