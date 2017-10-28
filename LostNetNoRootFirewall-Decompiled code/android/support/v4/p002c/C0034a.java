package android.support.v4.p002c;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C0034a extends C0033l implements Map {
    C0035f f233a;

    private C0035f m277b() {
        if (this.f233a == null) {
            this.f233a = new C0036b(this);
        }
        return this.f233a;
    }

    public Set entrySet() {
        return m277b().m293d();
    }

    public Set keySet() {
        return m277b().m294e();
    }

    public void putAll(Map map) {
        m273a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection values() {
        return m277b().m295f();
    }
}
