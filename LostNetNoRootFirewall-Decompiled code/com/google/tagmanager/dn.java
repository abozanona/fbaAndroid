package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.CustomFunctionCall.CustomEvaluator;
import com.google.tagmanager.ResourceUtil.ExpandedFunctionCall;
import com.google.tagmanager.ResourceUtil.ExpandedResource;
import com.google.tagmanager.ResourceUtil.ExpandedRule;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class dn {
    private static final ci f1091a = new ci(es.m1686f(), true);
    private final ExpandedResource f1092b;
    private final aq f1093c;
    private final Map f1094d;
    private final Map f1095e;
    private final Map f1096f;
    private final C0218k f1097g;
    private final C0218k f1098h;
    private final Set f1099i;
    private final Map f1100j;
    private volatile String f1101k;

    public dn(Context context, ExpandedResource expandedResource, DataLayer dataLayer, CustomEvaluator customEvaluator, CustomEvaluator customEvaluator2, aq aqVar) {
        if (expandedResource == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.f1092b = expandedResource;
        this.f1099i = new HashSet(expandedResource.getRules());
        this.f1093c = aqVar;
        this.f1097g = new CacheFactory().m1276a(1048576, new C0224do(this));
        this.f1098h = new CacheFactory().m1276a(1048576, new dp(this));
        this.f1094d = new HashMap();
        m1598b(new ArbitraryPixelTag(context));
        m1598b(new CustomFunctionCall(customEvaluator2));
        m1598b(new eu(context, dataLayer));
        this.f1095e = new HashMap();
        m1599c(new ac());
        m1599c(new an());
        m1599c(new ao());
        m1599c(new au());
        m1599c(new av());
        m1599c(new bq());
        m1599c(new br());
        m1599c(new cw());
        m1599c(new eg());
        this.f1096f = new HashMap();
        m1595a(new C0216a(context));
        m1595a(new C0217b());
        m1595a(new C0221d(context));
        m1595a(new C0225e(context));
        m1595a(new C0226f(context));
        m1595a(new C0227g(context));
        m1595a(new C0232n());
        m1595a(new CustomFunctionCall(customEvaluator));
        m1595a(new ag(dataLayer));
        m1595a(new aj(context));
        m1595a(new ak());
        m1595a(new am());
        m1595a(new ar(this));
        m1595a(new aw());
        m1595a(new ax());
        m1595a(new bh(context));
        m1595a(new bj());
        m1595a(new bp());
        m1595a(new bu(context));
        m1595a(new cj());
        m1595a(new co());
        m1595a(new ct());
        m1595a(new cv());
        m1595a(new cx(context));
        m1595a(new dv());
        m1595a(new dw());
        m1595a(new em());
        this.f1100j = new HashMap();
        for (ExpandedRule expandedRule : this.f1099i) {
            if (aqVar.mo636a()) {
                m1588a(expandedRule.getAddMacros(), expandedRule.getAddMacroRuleNames(), "add macro");
                m1588a(expandedRule.getRemoveMacros(), expandedRule.getRemoveMacroRuleNames(), "remove macro");
                m1588a(expandedRule.getAddTags(), expandedRule.getAddTagRuleNames(), "add tag");
                m1588a(expandedRule.getRemoveTags(), expandedRule.getRemoveTagRuleNames(), "remove tag");
            }
            int i = 0;
            while (i < expandedRule.getAddMacros().size()) {
                ExpandedFunctionCall expandedFunctionCall = (ExpandedFunctionCall) expandedRule.getAddMacros().get(i);
                String str = "Unknown";
                if (aqVar.mo636a() && i < expandedRule.getAddMacroRuleNames().size()) {
                    str = (String) expandedRule.getAddMacroRuleNames().get(i);
                }
                du a = m1586a(this.f1100j, m1587a(expandedFunctionCall));
                a.m1608a(expandedRule);
                a.m1609a(expandedRule, expandedFunctionCall);
                a.m1610a(expandedRule, str);
                i++;
            }
            i = 0;
            while (i < expandedRule.getRemoveMacros().size()) {
                expandedFunctionCall = (ExpandedFunctionCall) expandedRule.getRemoveMacros().get(i);
                str = "Unknown";
                if (aqVar.mo636a() && i < expandedRule.getRemoveMacroRuleNames().size()) {
                    str = (String) expandedRule.getRemoveMacroRuleNames().get(i);
                }
                a = m1586a(this.f1100j, m1587a(expandedFunctionCall));
                a.m1608a(expandedRule);
                a.m1612b(expandedRule, expandedFunctionCall);
                a.m1613b(expandedRule, str);
                i++;
            }
        }
        for (Entry entry : this.f1092b.getAllMacros().entrySet()) {
            for (ExpandedFunctionCall expandedFunctionCall2 : (List) entry.getValue()) {
                if (!es.m1682e((Value) expandedFunctionCall2.getProperties().get(Key.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    m1586a(this.f1100j, (String) entry.getKey()).m1607a(expandedFunctionCall2);
                }
            }
        }
    }

    private ci m1582a(Value value, Set set, ev evVar) {
        if (!value.getContainsReferences()) {
            return new ci(value, true);
        }
        Builder a;
        int i;
        ci a2;
        switch (ds.f1110a[value.getType().ordinal()]) {
            case 1:
                a = ResourceUtil.m1306a(value);
                for (i = 0; i < value.getListItemCount(); i++) {
                    a2 = m1582a(value.getListItem(i), set, evVar.mo646a(i));
                    if (a2 == f1091a) {
                        return f1091a;
                    }
                    a.addListItem((Value) a2.m1496a());
                }
                return new ci(a.build(), false);
            case 2:
                a = ResourceUtil.m1306a(value);
                if (value.getMapKeyCount() != value.getMapValueCount()) {
                    bs.m1438a("Invalid serving value: " + value.toString());
                    return f1091a;
                }
                for (i = 0; i < value.getMapKeyCount(); i++) {
                    a2 = m1582a(value.getMapKey(i), set, evVar.mo647b(i));
                    ci a3 = m1582a(value.getMapValue(i), set, evVar.mo648c(i));
                    if (a2 == f1091a || a3 == f1091a) {
                        return f1091a;
                    }
                    a.addMapKey((Value) a2.m1496a());
                    a.addMapValue((Value) a3.m1496a());
                }
                return new ci(a.build(), false);
            case 3:
                if (set.contains(value.getMacroReference())) {
                    bs.m1438a("Macro cycle detected.  Current macro reference: " + value.getMacroReference() + "." + "  Previous macro references: " + set.toString() + ".");
                    return f1091a;
                }
                set.add(value.getMacroReference());
                a2 = ew.m1705a(m1583a(value.getMacroReference(), set, evVar.mo645a()), value.getEscapingList());
                set.remove(value.getMacroReference());
                return a2;
            case 4:
                a = ResourceUtil.m1306a(value);
                for (i = 0; i < value.getTemplateTokenCount(); i++) {
                    a2 = m1582a(value.getTemplateToken(i), set, evVar.mo649d(i));
                    if (a2 == f1091a) {
                        return f1091a;
                    }
                    a.addTemplateToken((Value) a2.m1496a());
                }
                return new ci(a.build(), false);
            default:
                bs.m1438a("Unknown type: " + value.getType());
                return f1091a;
        }
    }

    private ci m1583a(String str, Set set, bt btVar) {
        ci ciVar = (ci) this.f1098h.mo627a(str);
        if (ciVar != null && !this.f1093c.mo636a()) {
            return ciVar;
        }
        du duVar = (du) this.f1100j.get(str);
        if (duVar == null) {
            bs.m1438a("Invalid macro: " + str);
            return f1091a;
        }
        ExpandedFunctionCall f;
        ci a = m1592a(str, duVar.m1606a(), duVar.m1611b(), duVar.m1614c(), duVar.m1616e(), duVar.m1615d(), set, btVar.mo639b());
        if (((Set) a.m1496a()).isEmpty()) {
            f = duVar.m1617f();
        } else {
            if (((Set) a.m1496a()).size() > 1) {
                bs.m1441b("Multiple macros active for macroName " + str);
            }
            f = (ExpandedFunctionCall) ((Set) a.m1496a()).iterator().next();
        }
        if (f == null) {
            return f1091a;
        }
        ci a2 = m1584a(this.f1096f, f, set, btVar.mo638a());
        boolean z = a.m1497b() && a2.m1497b();
        ciVar = a2 == f1091a ? f1091a : new ci(a2.m1496a(), z);
        if (!ciVar.m1497b()) {
            return ciVar;
        }
        this.f1098h.mo628a(str, ciVar);
        return ciVar;
    }

    private ci m1584a(Map map, ExpandedFunctionCall expandedFunctionCall, Set set, cy cyVar) {
        boolean z = true;
        Value value = (Value) expandedFunctionCall.getProperties().get(Key.FUNCTION.toString());
        if (value == null) {
            bs.m1438a("No function id in properties");
            return f1091a;
        }
        String functionId = value.getFunctionId();
        as asVar = (as) map.get(functionId);
        if (asVar == null) {
            bs.m1438a(functionId + " has no backing implementation.");
            return f1091a;
        }
        ci ciVar = (ci) this.f1097g.mo627a(expandedFunctionCall);
        if (ciVar != null && !this.f1093c.mo636a()) {
            return ciVar;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : expandedFunctionCall.getProperties().entrySet()) {
            ci a = m1582a((Value) entry.getValue(), set, cyVar.mo640a((String) entry.getKey()).mo642a((Value) entry.getValue()));
            if (a == f1091a) {
                return f1091a;
            }
            boolean z3;
            if (a.m1497b()) {
                expandedFunctionCall.updateCacheableProperty((String) entry.getKey(), (Value) a.m1496a());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), a.m1496a());
            z2 = z3;
        }
        if (asVar.m1254a(hashMap.keySet())) {
            if (!(z2 && asVar.mo592a())) {
                z = false;
            }
            ciVar = new ci(asVar.mo591a(hashMap), z);
            if (z) {
                this.f1097g.mo628a(expandedFunctionCall, ciVar);
            }
            cyVar.mo641a((Value) ciVar.m1496a());
            return ciVar;
        }
        bs.m1438a("Incorrect keys for function " + functionId + " required " + asVar.m1256e() + " had " + hashMap.keySet());
        return f1091a;
    }

    private ci m1585a(Set set, Set set2, dt dtVar, dm dmVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (ExpandedRule expandedRule : set) {
            db a = dmVar.mo643a();
            ci a2 = m1591a(expandedRule, set2, a);
            if (((Boolean) a2.m1496a()).booleanValue()) {
                dtVar.mo669a(expandedRule, hashSet, hashSet2, a);
            }
            boolean z2 = z && a2.m1497b();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        dmVar.mo644a(hashSet);
        return new ci(hashSet, z);
    }

    private static du m1586a(Map map, String str) {
        du duVar = (du) map.get(str);
        if (duVar != null) {
            return duVar;
        }
        duVar = new du();
        map.put(str, duVar);
        return duVar;
    }

    private static String m1587a(ExpandedFunctionCall expandedFunctionCall) {
        return es.m1668a((Value) expandedFunctionCall.getProperties().get(Key.INSTANCE_NAME.toString()));
    }

    private static void m1588a(List list, List list2, String str) {
        if (list.size() != list2.size()) {
            bs.m1443c("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void m1589a(Map map, as asVar) {
        if (map.containsKey(asVar.m1255d())) {
            throw new IllegalArgumentException("Duplicate function type name: " + asVar.m1255d());
        }
        map.put(asVar.m1255d(), asVar);
    }

    @VisibleForTesting
    ci m1590a(ExpandedFunctionCall expandedFunctionCall, Set set, cy cyVar) {
        ci a = m1584a(this.f1095e, expandedFunctionCall, set, cyVar);
        Object e = es.m1682e((Value) a.m1496a());
        cyVar.mo641a(es.m1687f(e));
        return new ci(e, a.m1497b());
    }

    @VisibleForTesting
    ci m1591a(ExpandedRule expandedRule, Set set, db dbVar) {
        boolean z = true;
        for (ExpandedFunctionCall a : expandedRule.getNegativePredicates()) {
            ci a2 = m1590a(a, set, dbVar.mo595a());
            if (((Boolean) a2.m1496a()).booleanValue()) {
                dbVar.mo596a(es.m1687f(Boolean.valueOf(false)));
                return new ci(Boolean.valueOf(false), a2.m1497b());
            }
            boolean z2 = z && a2.m1497b();
            z = z2;
        }
        for (ExpandedFunctionCall a3 : expandedRule.getPositivePredicates()) {
            a2 = m1590a(a3, set, dbVar.mo597b());
            if (((Boolean) a2.m1496a()).booleanValue()) {
                z = z && a2.m1497b();
            } else {
                dbVar.mo596a(es.m1687f(Boolean.valueOf(false)));
                return new ci(Boolean.valueOf(false), a2.m1497b());
            }
        }
        dbVar.mo596a(es.m1687f(Boolean.valueOf(true)));
        return new ci(Boolean.valueOf(true), z);
    }

    @VisibleForTesting
    ci m1592a(String str, Set set, Map map, Map map2, Map map3, Map map4, Set set2, dm dmVar) {
        return m1585a(set, set2, new dq(this, map, map2, map3, map4), dmVar);
    }

    @VisibleForTesting
    ci m1593a(Set set, dm dmVar) {
        return m1585a(set, new HashSet(), new dr(this), dmVar);
    }

    synchronized String m1594a() {
        return this.f1101k;
    }

    @VisibleForTesting
    void m1595a(as asVar) {
        m1589a(this.f1096f, asVar);
    }

    public synchronized void m1596a(String str) {
        m1600c(str);
        ap b = this.f1093c.mo637b(str);
        af b2 = b.mo633b();
        for (ExpandedFunctionCall a : (Set) m1593a(this.f1099i, b2.mo630b()).m1496a()) {
            m1584a(this.f1094d, a, new HashSet(), b2.mo629a());
        }
        b.mo634c();
        m1600c(null);
    }

    public ci m1597b(String str) {
        ap a = this.f1093c.mo635a(str);
        ci a2 = m1583a(str, new HashSet(), a.mo632a());
        a.mo634c();
        return a2;
    }

    @VisibleForTesting
    void m1598b(as asVar) {
        m1589a(this.f1094d, asVar);
    }

    @VisibleForTesting
    void m1599c(as asVar) {
        m1589a(this.f1095e, asVar);
    }

    @VisibleForTesting
    synchronized void m1600c(String str) {
        this.f1101k = str;
    }
}
