package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.HitTypes;
import com.google.analytics.tracking.android.Tracker;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class eu extends eq {
    private static final String f1168a = FunctionType.UNIVERSAL_ANALYTICS.toString();
    private static final String f1169b = Key.ACCOUNT.toString();
    private static final String f1170c = Key.ANALYTICS_PASS_THROUGH.toString();
    private static final String f1171d = Key.ANALYTICS_FIELDS.toString();
    private static final String f1172e = Key.TRACK_TRANSACTION.toString();
    private static final String f1173f = Key.TRANSACTION_DATALAYER_MAP.toString();
    private static final String f1174g = Key.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static Map f1175h;
    private static Map f1176i;
    private final Set f1177j;
    private final en f1178k;
    private final DataLayer f1179l;

    public eu(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new en(context));
    }

    @VisibleForTesting
    eu(Context context, DataLayer dataLayer, en enVar) {
        super(f1168a, new String[0]);
        this.f1179l = dataLayer;
        this.f1178k = enVar;
        this.f1177j = new HashSet();
        this.f1177j.add("");
        this.f1177j.add("0");
        this.f1177j.add("false");
    }

    private String m1693a(String str) {
        Object obj = this.f1179l.get(str);
        return obj == null ? null : obj.toString();
    }

    private Map m1694a(Value value) {
        if (value.getType() != Type.MAP) {
            return null;
        }
        Map hashMap = new HashMap(value.getMapKeyCount());
        for (int i = 0; i < value.getMapKeyCount(); i++) {
            hashMap.put(es.m1668a(value.getMapKey(i)), es.m1668a(value.getMapValue(i)));
        }
        return hashMap;
    }

    private void m1695a(Tracker tracker, Map map) {
        ((Value) map.get(f1169b)).getString();
        String a = m1693a("transactionId");
        if (a == null) {
            bs.m1438a("Cannot find transactionId in data layer.");
            return;
        }
        List<Map> linkedList = new LinkedList();
        try {
            Map b = m1699b((Value) map.get(f1171d));
            b.put(Fields.HIT_TYPE, HitTypes.TRANSACTION);
            for (Entry entry : m1700c(map).entrySet()) {
                m1696a(b, (String) entry.getValue(), m1693a((String) entry.getKey()));
            }
            linkedList.add(b);
            List<Map> b2 = m1698b();
            if (b2 != null) {
                for (Map map2 : b2) {
                    if (map2.get("name") == null) {
                        bs.m1438a("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map b3 = m1699b((Value) map.get(f1171d));
                    b3.put(Fields.HIT_TYPE, HitTypes.ITEM);
                    b3.put(Fields.TRANSACTION_ID, a);
                    for (Entry entry2 : m1701d(map).entrySet()) {
                        m1696a(b3, (String) entry2.getValue(), (String) map2.get(entry2.getKey()));
                    }
                    linkedList.add(b3);
                }
            }
            for (Map map22 : linkedList) {
                tracker.send(map22);
            }
        } catch (Throwable e) {
            bs.m1439a("Unable to send transaction", e);
        }
    }

    private void m1696a(Map map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private boolean m1697a(Map map, String str) {
        Value value = (Value) map.get(str);
        return value == null ? false : value.getBoolean();
    }

    private List m1698b() {
        Object obj = this.f1179l.get("transactionProducts");
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                if (!(obj2 instanceof Map)) {
                    throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                }
            }
            return (List) obj;
        }
        throw new IllegalArgumentException("transactionProducts should be of type List.");
    }

    private Map m1699b(Value value) {
        if (value == null || value.getType() != Type.MAP) {
            return new HashMap();
        }
        Map a = m1694a(value);
        String str = (String) a.get(Fields.ANONYMIZE_IP);
        if (str != null && this.f1177j.contains(str.toLowerCase())) {
            a.remove(Fields.ANONYMIZE_IP);
        }
        return a;
    }

    private Map m1700c(Map map) {
        Value value = (Value) map.get(f1173f);
        if (value != null) {
            return m1694a(value);
        }
        if (f1175h == null) {
            Map hashMap = new HashMap();
            hashMap.put("transactionId", Fields.TRANSACTION_ID);
            hashMap.put("transactionAffiliation", Fields.TRANSACTION_AFFILIATION);
            hashMap.put("transactionTax", Fields.TRANSACTION_TAX);
            hashMap.put("transactionShipping", Fields.TRANSACTION_SHIPPING);
            hashMap.put("transactionTotal", Fields.TRANSACTION_REVENUE);
            hashMap.put("transactionCurrency", Fields.CURRENCY_CODE);
            f1175h = hashMap;
        }
        return f1175h;
    }

    private Map m1701d(Map map) {
        Value value = (Value) map.get(f1174g);
        if (value != null) {
            return m1694a(value);
        }
        if (f1176i == null) {
            Map hashMap = new HashMap();
            hashMap.put("name", Fields.ITEM_NAME);
            hashMap.put("sku", Fields.ITEM_SKU);
            hashMap.put("category", Fields.ITEM_CATEGORY);
            hashMap.put("price", Fields.ITEM_PRICE);
            hashMap.put("quantity", Fields.ITEM_QUANTITY);
            hashMap.put("currency", Fields.CURRENCY_CODE);
            f1176i = hashMap;
        }
        return f1176i;
    }

    public void mo593b(Map map) {
        Tracker a = this.f1178k.m1654a("_GTM_DEFAULT_TRACKER_");
        if (m1697a(map, f1170c)) {
            a.send(m1699b((Value) map.get(f1171d)));
        } else if (m1697a(map, f1172e)) {
            m1695a(a, map);
        } else {
            bs.m1441b("Ignoring unknown tag.");
        }
        this.f1178k.m1655a(a);
    }
}
