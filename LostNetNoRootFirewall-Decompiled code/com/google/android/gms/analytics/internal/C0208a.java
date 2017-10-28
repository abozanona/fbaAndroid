package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0208a implements Creator {
    C0208a() {
    }

    public Command m1239a(Parcel parcel) {
        return new Command(parcel);
    }

    public Command[] m1240a(int i) {
        return new Command[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1239a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1240a(i);
    }
}
