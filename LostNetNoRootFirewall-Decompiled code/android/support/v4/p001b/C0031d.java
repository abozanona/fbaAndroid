package android.support.v4.p001b;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class C0031d implements ClassLoaderCreator {
    private final C0030c f225a;

    public C0031d(C0030c c0030c) {
        this.f225a = c0030c;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.f225a.mo98a(parcel, null);
    }

    public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f225a.mo98a(parcel, classLoader);
    }

    public Object[] newArray(int i) {
        return this.f225a.mo99a(i);
    }
}
