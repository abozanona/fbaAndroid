package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.widget.DrawerLayout.SavedState;

final class C0100c implements Creator {
    C0100c() {
    }

    public SavedState m811a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m812a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m811a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m812a(i);
    }
}
