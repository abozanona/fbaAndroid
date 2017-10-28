package com.google.tagmanager;

import com.google.tagmanager.ResourceUtil.ExpandedFunctionCall;
import com.google.tagmanager.ResourceUtil.ExpandedRule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class du {
    private final Set f1111a = new HashSet();
    private final Map f1112b = new HashMap();
    private final Map f1113c = new HashMap();
    private final Map f1114d = new HashMap();
    private final Map f1115e = new HashMap();
    private ExpandedFunctionCall f1116f;

    public Set m1606a() {
        return this.f1111a;
    }

    public void m1607a(ExpandedFunctionCall expandedFunctionCall) {
        this.f1116f = expandedFunctionCall;
    }

    public void m1608a(ExpandedRule expandedRule) {
        this.f1111a.add(expandedRule);
    }

    public void m1609a(ExpandedRule expandedRule, ExpandedFunctionCall expandedFunctionCall) {
        List list = (List) this.f1112b.get(expandedRule);
        if (list == null) {
            list = new ArrayList();
            this.f1112b.put(expandedRule, list);
        }
        list.add(expandedFunctionCall);
    }

    public void m1610a(ExpandedRule expandedRule, String str) {
        List list = (List) this.f1114d.get(expandedRule);
        if (list == null) {
            list = new ArrayList();
            this.f1114d.put(expandedRule, list);
        }
        list.add(str);
    }

    public Map m1611b() {
        return this.f1112b;
    }

    public void m1612b(ExpandedRule expandedRule, ExpandedFunctionCall expandedFunctionCall) {
        List list = (List) this.f1113c.get(expandedRule);
        if (list == null) {
            list = new ArrayList();
            this.f1113c.put(expandedRule, list);
        }
        list.add(expandedFunctionCall);
    }

    public void m1613b(ExpandedRule expandedRule, String str) {
        List list = (List) this.f1115e.get(expandedRule);
        if (list == null) {
            list = new ArrayList();
            this.f1115e.put(expandedRule, list);
        }
        list.add(str);
    }

    public Map m1614c() {
        return this.f1114d;
    }

    public Map m1615d() {
        return this.f1115e;
    }

    public Map m1616e() {
        return this.f1113c;
    }

    public ExpandedFunctionCall m1617f() {
        return this.f1116f;
    }
}
