package com.google.analytics.tracking.android;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class C0207z {
    private final Map f893a;
    private final long f894b;
    private final String f895c;
    private final List f896d;

    public C0207z(Map map, long j, String str, List list) {
        this.f893a = map;
        this.f894b = j;
        this.f895c = str;
        this.f896d = list;
    }

    public Map m1235a() {
        return this.f893a;
    }

    public long m1236b() {
        return this.f894b;
    }

    public String m1237c() {
        return this.f895c;
    }

    public List m1238d() {
        return this.f896d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PATH: ");
        stringBuilder.append(this.f895c);
        if (this.f893a != null) {
            stringBuilder.append("  PARAMS: ");
            for (Entry entry : this.f893a.entrySet()) {
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append((String) entry.getValue());
                stringBuilder.append(",  ");
            }
        }
        return stringBuilder.toString();
    }
}
