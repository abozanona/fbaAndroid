package com.google.tagmanager;

import com.google.tagmanager.ResourceUtil.ExpandedRule;
import java.util.List;
import java.util.Map;
import java.util.Set;

class dq implements dt {
    final /* synthetic */ Map f1104a;
    final /* synthetic */ Map f1105b;
    final /* synthetic */ Map f1106c;
    final /* synthetic */ Map f1107d;
    final /* synthetic */ dn f1108e;

    dq(dn dnVar, Map map, Map map2, Map map3, Map map4) {
        this.f1108e = dnVar;
        this.f1104a = map;
        this.f1105b = map2;
        this.f1106c = map3;
        this.f1107d = map4;
    }

    public void mo669a(ExpandedRule expandedRule, Set set, Set set2, db dbVar) {
        List list = (List) this.f1104a.get(expandedRule);
        List list2 = (List) this.f1105b.get(expandedRule);
        if (list != null) {
            set.addAll(list);
            dbVar.mo598c().translateAndAddAll(list, list2);
        }
        list = (List) this.f1106c.get(expandedRule);
        list2 = (List) this.f1107d.get(expandedRule);
        if (list != null) {
            set2.addAll(list);
            dbVar.mo599d().translateAndAddAll(list, list2);
        }
    }
}
