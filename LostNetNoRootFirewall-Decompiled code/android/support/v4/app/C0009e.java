package android.support.v4.app;

import android.view.View;

class C0009e implements C0008m {
    final /* synthetic */ Fragment f162a;

    C0009e(Fragment fragment) {
        this.f162a = fragment;
    }

    public View mo8a(int i) {
        if (this.f162a.f26I != null) {
            return this.f162a.f26I.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }
}
