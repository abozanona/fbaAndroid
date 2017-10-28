package com.google.android.vending.licensing;

import android.os.IBinder;
import android.os.Parcel;

class C0211b implements ILicensingService {
    private IBinder f899a;

    C0211b(IBinder iBinder) {
        this.f899a = iBinder;
    }

    public IBinder asBinder() {
        return this.f899a;
    }

    public void checkLicense(long j, String str, ILicenseResultListener iLicenseResultListener) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.vending.licensing.ILicensingService");
            obtain.writeLong(j);
            obtain.writeString(str);
            if (iLicenseResultListener != null) {
                iBinder = iLicenseResultListener.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f899a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
