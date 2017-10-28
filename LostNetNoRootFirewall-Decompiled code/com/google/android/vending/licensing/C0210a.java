package com.google.android.vending.licensing;

import android.os.IBinder;
import android.os.Parcel;

class C0210a implements ILicenseResultListener {
    private IBinder f898a;

    C0210a(IBinder iBinder) {
        this.f898a = iBinder;
    }

    public IBinder asBinder() {
        return this.f898a;
    }

    public void verifyLicense(int i, String str, String str2) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.vending.licensing.ILicenseResultListener");
            obtain.writeInt(i);
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f898a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
