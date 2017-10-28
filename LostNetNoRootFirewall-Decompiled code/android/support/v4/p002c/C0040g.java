package android.support.v4.p002c;

import java.util.Iterator;

final class C0040g implements Iterator {
    final int f243a;
    int f244b;
    int f245c;
    boolean f246d = false;
    final /* synthetic */ C0035f f247e;

    C0040g(C0035f c0035f, int i) {
        this.f247e = c0035f;
        this.f243a = i;
        this.f244b = c0035f.mo20a();
    }

    public boolean hasNext() {
        return this.f245c < this.f244b;
    }

    public Object next() {
        Object a = this.f247e.mo22a(this.f245c, this.f243a);
        this.f245c++;
        this.f246d = true;
        return a;
    }

    public void remove() {
        if (this.f246d) {
            this.f245c--;
            this.f244b--;
            this.f246d = false;
            this.f247e.mo24a(this.f245c);
            return;
        }
        throw new IllegalStateException();
    }
}
