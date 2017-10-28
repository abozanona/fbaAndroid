package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

class bs implements Comparator {
    bs() {
    }

    public int m674a(View view, View view2) {
        bk bkVar = (bk) view.getLayoutParams();
        bk bkVar2 = (bk) view2.getLayoutParams();
        return bkVar.f337a != bkVar2.f337a ? bkVar.f337a ? 1 : -1 : bkVar.f341e - bkVar2.f341e;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m674a((View) obj, (View) obj2);
    }
}
