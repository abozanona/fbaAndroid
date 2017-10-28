package android.support.v4.p002c;

import java.util.Map;

class C0036b extends C0035f {
    final /* synthetic */ C0034a f237a;

    C0036b(C0034a c0034a) {
        this.f237a = c0034a;
    }

    protected int mo20a() {
        return this.f237a.h;
    }

    protected int mo21a(Object obj) {
        return obj == null ? this.f237a.m269a() : this.f237a.m271a(obj, obj.hashCode());
    }

    protected Object mo22a(int i, int i2) {
        return this.f237a.g[(i << 1) + i2];
    }

    protected Object mo23a(int i, Object obj) {
        return this.f237a.m272a(i, obj);
    }

    protected void mo24a(int i) {
        this.f237a.m276d(i);
    }

    protected void mo25a(Object obj, Object obj2) {
        this.f237a.put(obj, obj2);
    }

    protected int mo26b(Object obj) {
        return this.f237a.m270a(obj);
    }

    protected Map mo27b() {
        return this.f237a;
    }

    protected void mo28c() {
        this.f237a.clear();
    }
}
