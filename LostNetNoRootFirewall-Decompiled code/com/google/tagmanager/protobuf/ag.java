package com.google.tagmanager.protobuf;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class ag extends AbstractMap {
    private final int f1218a;
    private List f1219b;
    private Map f1220c;
    private boolean f1221d;
    private volatile an f1222e;

    private ag(int i) {
        this.f1218a = i;
        this.f1219b = Collections.emptyList();
        this.f1220c = Collections.emptyMap();
    }

    private int m1782a(Comparable comparable) {
        int compareTo;
        int i = 0;
        int size = this.f1219b.size() - 1;
        if (size >= 0) {
            compareTo = comparable.compareTo(((al) this.f1219b.get(size)).m1803a());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i <= size) {
            int i2 = (i + size) / 2;
            compareTo = comparable.compareTo(((al) this.f1219b.get(i2)).m1803a());
            if (compareTo < 0) {
                compareTo = i2 - 1;
                size = i;
            } else if (compareTo <= 0) {
                return i2;
            } else {
                int i3 = size;
                size = i2 + 1;
                compareTo = i3;
            }
            i = size;
            size = compareTo;
        }
        return -(i + 1);
    }

    static ag m1783a(int i) {
        return new ah(i);
    }

    private Object m1787c(int i) {
        m1789e();
        Object value = ((al) this.f1219b.remove(i)).getValue();
        if (!this.f1220c.isEmpty()) {
            Iterator it = m1790f().entrySet().iterator();
            this.f1219b.add(new al(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private void m1789e() {
        if (this.f1221d) {
            throw new UnsupportedOperationException();
        }
    }

    private SortedMap m1790f() {
        m1789e();
        if (this.f1220c.isEmpty() && !(this.f1220c instanceof TreeMap)) {
            this.f1220c = new TreeMap();
        }
        return (SortedMap) this.f1220c;
    }

    private void m1791g() {
        m1789e();
        if (this.f1219b.isEmpty() && !(this.f1219b instanceof ArrayList)) {
            this.f1219b = new ArrayList(this.f1218a);
        }
    }

    public Object m1792a(Comparable comparable, Object obj) {
        m1789e();
        int a = m1782a(comparable);
        if (a >= 0) {
            return ((al) this.f1219b.get(a)).setValue(obj);
        }
        m1791g();
        int i = -(a + 1);
        if (i >= this.f1218a) {
            return m1790f().put(comparable, obj);
        }
        if (this.f1219b.size() == this.f1218a) {
            al alVar = (al) this.f1219b.remove(this.f1218a - 1);
            m1790f().put(alVar.m1803a(), alVar.getValue());
        }
        this.f1219b.add(i, new al(this, comparable, obj));
        return null;
    }

    public void mo716a() {
        if (!this.f1221d) {
            this.f1220c = this.f1220c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f1220c);
            this.f1221d = true;
        }
    }

    public Entry m1794b(int i) {
        return (Entry) this.f1219b.get(i);
    }

    public boolean m1795b() {
        return this.f1221d;
    }

    public int m1796c() {
        return this.f1219b.size();
    }

    public void clear() {
        m1789e();
        if (!this.f1219b.isEmpty()) {
            this.f1219b.clear();
        }
        if (!this.f1220c.isEmpty()) {
            this.f1220c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m1782a(comparable) >= 0 || this.f1220c.containsKey(comparable);
    }

    public Iterable m1797d() {
        return this.f1220c.isEmpty() ? ai.m1799a() : this.f1220c.entrySet();
    }

    public Set entrySet() {
        if (this.f1222e == null) {
            this.f1222e = new an();
        }
        return this.f1222e;
    }

    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = m1782a(comparable);
        return a >= 0 ? ((al) this.f1219b.get(a)).getValue() : this.f1220c.get(comparable);
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m1792a((Comparable) obj, obj2);
    }

    public Object remove(Object obj) {
        m1789e();
        Comparable comparable = (Comparable) obj;
        int a = m1782a(comparable);
        return a >= 0 ? m1787c(a) : this.f1220c.isEmpty() ? null : this.f1220c.remove(comparable);
    }

    public int size() {
        return this.f1219b.size() + this.f1220c.size();
    }
}
