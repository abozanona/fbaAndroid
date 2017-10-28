package android.support.v4.view;

class bh implements Runnable {
    final /* synthetic */ ViewPager f331a;

    bh(ViewPager viewPager) {
        this.f331a = viewPager;
    }

    public void run() {
        this.f331a.setScrollState(0);
        this.f331a.m354c();
    }
}
