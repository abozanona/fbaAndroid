package android.support.v4.view.p003a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class C0063m implements C0062s {
    final /* synthetic */ C0058j f317a;
    final /* synthetic */ C0061l f318b;

    C0063m(C0061l c0061l, C0058j c0058j) {
        this.f318b = c0061l;
        this.f317a = c0058j;
    }

    public Object mo56a(int i) {
        C0046a a = this.f317a.m485a(i);
        return a == null ? null : a.m359a();
    }

    public List mo57a(String str, int i) {
        List a = this.f317a.m487a(str, i);
        List arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0046a) a.get(i2)).m359a());
        }
        return arrayList;
    }

    public boolean mo58a(int i, int i2, Bundle bundle) {
        return this.f317a.m488a(i, i2, bundle);
    }
}
