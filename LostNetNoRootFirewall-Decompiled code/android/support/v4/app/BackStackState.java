package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator CREATOR = new C0007d();
    final int[] f7a;
    final int f8b;
    final int f9c;
    final String f10d;
    final int f11e;
    final int f12f;
    final CharSequence f13g;
    final int f14h;
    final CharSequence f15i;

    public BackStackState(Parcel parcel) {
        this.f7a = parcel.createIntArray();
        this.f8b = parcel.readInt();
        this.f9c = parcel.readInt();
        this.f10d = parcel.readString();
        this.f11e = parcel.readInt();
        this.f12f = parcel.readInt();
        this.f13g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f14h = parcel.readInt();
        this.f15i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public BackStackState(C0019p c0019p, C0005b c0005b) {
        int i = 0;
        for (C0006c c0006c = c0005b.f135b; c0006c != null; c0006c = c0006c.f153a) {
            if (c0006c.f161i != null) {
                i += c0006c.f161i.size();
            }
        }
        this.f7a = new int[(i + (c0005b.f137d * 7))];
        if (c0005b.f144k) {
            i = 0;
            for (C0006c c0006c2 = c0005b.f135b; c0006c2 != null; c0006c2 = c0006c2.f153a) {
                int i2 = i + 1;
                this.f7a[i] = c0006c2.f155c;
                int i3 = i2 + 1;
                this.f7a[i2] = c0006c2.f156d != null ? c0006c2.f156d.f38f : -1;
                int i4 = i3 + 1;
                this.f7a[i3] = c0006c2.f157e;
                i2 = i4 + 1;
                this.f7a[i4] = c0006c2.f158f;
                i4 = i2 + 1;
                this.f7a[i2] = c0006c2.f159g;
                i2 = i4 + 1;
                this.f7a[i4] = c0006c2.f160h;
                if (c0006c2.f161i != null) {
                    int size = c0006c2.f161i.size();
                    i4 = i2 + 1;
                    this.f7a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f7a[i4] = ((Fragment) c0006c2.f161i.get(i2)).f38f;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f7a[i2] = 0;
                }
            }
            this.f8b = c0005b.f142i;
            this.f9c = c0005b.f143j;
            this.f10d = c0005b.f146m;
            this.f11e = c0005b.f148o;
            this.f12f = c0005b.f149p;
            this.f13g = c0005b.f150q;
            this.f14h = c0005b.f151r;
            this.f15i = c0005b.f152s;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C0005b m10a(C0019p c0019p) {
        C0005b c0005b = new C0005b(c0019p);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f7a.length) {
            C0006c c0006c = new C0006c();
            int i3 = i2 + 1;
            c0006c.f155c = this.f7a[i2];
            if (C0019p.f187a) {
                Log.v("FragmentManager", "Instantiate " + c0005b + " op #" + i + " base fragment #" + this.f7a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f7a[i3];
            if (i2 >= 0) {
                c0006c.f156d = (Fragment) c0019p.f193f.get(i2);
            } else {
                c0006c.f156d = null;
            }
            i3 = i4 + 1;
            c0006c.f157e = this.f7a[i4];
            i4 = i3 + 1;
            c0006c.f158f = this.f7a[i3];
            i3 = i4 + 1;
            c0006c.f159g = this.f7a[i4];
            int i5 = i3 + 1;
            c0006c.f160h = this.f7a[i3];
            i4 = i5 + 1;
            int i6 = this.f7a[i5];
            if (i6 > 0) {
                c0006c.f161i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (C0019p.f187a) {
                        Log.v("FragmentManager", "Instantiate " + c0005b + " set remove fragment #" + this.f7a[i4]);
                    }
                    i5 = i4 + 1;
                    c0006c.f161i.add((Fragment) c0019p.f193f.get(this.f7a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            c0005b.m131a(c0006c);
            i++;
            i2 = i4;
        }
        c0005b.f142i = this.f8b;
        c0005b.f143j = this.f9c;
        c0005b.f146m = this.f10d;
        c0005b.f148o = this.f11e;
        c0005b.f144k = true;
        c0005b.f149p = this.f12f;
        c0005b.f150q = this.f13g;
        c0005b.f151r = this.f14h;
        c0005b.f152s = this.f15i;
        c0005b.m130a(1);
        return c0005b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f7a);
        parcel.writeInt(this.f8b);
        parcel.writeInt(this.f9c);
        parcel.writeString(this.f10d);
        parcel.writeInt(this.f11e);
        parcel.writeInt(this.f12f);
        TextUtils.writeToParcel(this.f13g, parcel, 0);
        parcel.writeInt(this.f14h);
        TextUtils.writeToParcel(this.f15i, parcel, 0);
    }
}
