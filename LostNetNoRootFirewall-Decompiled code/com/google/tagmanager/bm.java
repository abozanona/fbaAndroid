package com.google.tagmanager;

import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.ResourceUtil.ExpandedFunctionCall;
import com.google.tagmanager.ResourceUtil.ExpandedResource;
import com.google.tagmanager.ResourceUtil.ExpandedResourceBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class bm {
    public static ExpandedResource m1425a(String str) {
        Value b = m1427b(new JSONObject(str));
        ExpandedResourceBuilder newBuilder = ExpandedResource.newBuilder();
        for (int i = 0; i < b.getMapKeyCount(); i++) {
            newBuilder.addMacro(ExpandedFunctionCall.newBuilder().addProperty(Key.INSTANCE_NAME.toString(), b.getMapKey(i)).addProperty(Key.FUNCTION.toString(), es.m1666a(C0232n.m1717b())).addProperty(C0232n.m1718c(), b.getMapValue(i)).build());
        }
        return newBuilder.build();
    }

    @VisibleForTesting
    static Object m1426a(Object obj) {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, m1426a(jSONObject.get(str)));
            }
            return hashMap;
        }
    }

    private static Value m1427b(Object obj) {
        return es.m1687f(m1426a(obj));
    }
}
