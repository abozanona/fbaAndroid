package android.support.v4.view;

import android.database.DataSetObserver;

class bp extends DataSetObserver {
    final /* synthetic */ ViewPager f344a;

    private bp(ViewPager viewPager) {
        this.f344a = viewPager;
    }

    public void onChanged() {
        this.f344a.m353b();
    }

    public void onInvalidated() {
        this.f344a.m353b();
    }
}
