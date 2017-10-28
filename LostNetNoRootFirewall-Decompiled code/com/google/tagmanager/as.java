package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class as {
    private final Set f915a;
    private final String f916b;

    public as(String str, String... strArr) {
        this.f916b = str;
        this.f915a = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.f915a.add(add);
        }
    }

    public abstract Value mo591a(Map map);

    public abstract boolean mo592a();

    boolean m1254a(Set set) {
        return set.containsAll(this.f915a);
    }

    public String m1255d() {
        return this.f916b;
    }

    public Set m1256e() {
        return this.f915a;
    }
}
