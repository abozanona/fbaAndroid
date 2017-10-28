package android.support.v4.view.p003a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class C0066o implements C0065v {
    final /* synthetic */ C0058j f319a;
    final /* synthetic */ C0064n f320b;

    C0066o(C0064n c0064n, C0058j c0058j) {
        this.f320b = c0064n;
        this.f319a = c0058j;
    }

    public Object mo59a(int i) {
        C0046a a = this.f319a.m485a(i);
        return a == null ? null : a.m359a();
    }

    public List mo60a(String str, int i) {
        List a = this.f319a.m487a(str, i);
        List arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0046a) a.get(i2)).m359a());
        }
        return arrayList;
    }

    public boolean mo61a(int i, int i2, Bundle bundle) {
        return this.f319a.m488a(i, i2, bundle);
    }
}
