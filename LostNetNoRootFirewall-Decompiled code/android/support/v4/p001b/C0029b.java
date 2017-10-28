package android.support.v4.p001b;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class C0029b implements Creator {
    final C0030c f224a;

    public C0029b(C0030c c0030c) {
        this.f224a = c0030c;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.f224a.mo98a(parcel, null);
    }

    public Object[] newArray(int i) {
        return this.f224a.mo99a(i);
    }
}
