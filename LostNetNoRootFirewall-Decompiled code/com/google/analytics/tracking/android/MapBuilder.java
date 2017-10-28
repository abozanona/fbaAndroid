package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.google.analytics.tracking.android.GAUsage.Field;
import java.util.HashMap;
import java.util.Map;

public class MapBuilder {
    private Map map = new HashMap();

    static String booleanToString(Boolean bool) {
        return bool == null ? null : bool.booleanValue() ? "1" : "0";
    }

    public static MapBuilder createAppView() {
        GAUsage.m1070a().m1071a(Field.CONSTRUCT_APP_VIEW);
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.set(Fields.HIT_TYPE, HitTypes.APP_VIEW);
        return mapBuilder;
    }

    public static MapBuilder createEvent(String str, String str2, String str3, Long l) {
        GAUsage.m1070a().m1071a(Field.CONSTRUCT_EVENT);
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.set(Fields.HIT_TYPE, HitTypes.EVENT);
        mapBuilder.set(Fields.EVENT_CATEGORY, str);
        mapBuilder.set(Fields.EVENT_ACTION, str2);
        mapBuilder.set(Fields.EVENT_LABEL, str3);
        mapBuilder.set(Fields.EVENT_VALUE, l == null ? null : Long.toString(l.longValue()));
        return mapBuilder;
    }

    public static MapBuilder createException(String str, Boolean bool) {
        GAUsage.m1070a().m1071a(Field.CONSTRUCT_EXCEPTION);
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.set(Fields.HIT_TYPE, HitTypes.EXCEPTION);
        mapBuilder.set(Fields.EX_DESCRIPTION, str);
        mapBuilder.set(Fields.EX_FATAL, booleanToString(bool));
        return mapBuilder;
    }

    public static MapBuilder createItem(String str, String str2, String str3, String str4, Double d, Long l, String str5) {
        String str6 = null;
        GAUsage.m1070a().m1071a(Field.CONSTRUCT_ITEM);
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.set(Fields.HIT_TYPE, HitTypes.ITEM);
        mapBuilder.set(Fields.TRANSACTION_ID, str);
        mapBuilder.set(Fields.ITEM_SKU, str3);
        mapBuilder.set(Fields.ITEM_NAME, str2);
        mapBuilder.set(Fields.ITEM_CATEGORY, str4);
        mapBuilder.set(Fields.ITEM_PRICE, d == null ? null : Double.toString(d.doubleValue()));
        String str7 = Fields.ITEM_QUANTITY;
        if (l != null) {
            str6 = Long.toString(l.longValue());
        }
        mapBuilder.set(str7, str6);
        mapBuilder.set(Fields.CURRENCY_CODE, str5);
        return mapBuilder;
    }

    public static MapBuilder createSocial(String str, String str2, String str3) {
        GAUsage.m1070a().m1071a(Field.CONSTRUCT_SOCIAL);
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.set(Fields.HIT_TYPE, HitTypes.SOCIAL);
        mapBuilder.set(Fields.SOCIAL_NETWORK, str);
        mapBuilder.set(Fields.SOCIAL_ACTION, str2);
        mapBuilder.set(Fields.SOCIAL_TARGET, str3);
        return mapBuilder;
    }

    public static MapBuilder createTiming(String str, Long l, String str2, String str3) {
        GAUsage.m1070a().m1071a(Field.CONSTRUCT_TIMING);
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.set(Fields.HIT_TYPE, HitTypes.TIMING);
        mapBuilder.set(Fields.TIMING_CATEGORY, str);
        String str4 = null;
        if (l != null) {
            str4 = Long.toString(l.longValue());
        }
        mapBuilder.set(Fields.TIMING_VALUE, str4);
        mapBuilder.set(Fields.TIMING_VAR, str2);
        mapBuilder.set(Fields.TIMING_LABEL, str3);
        return mapBuilder;
    }

    public static MapBuilder createTransaction(String str, String str2, Double d, Double d2, Double d3, String str3) {
        String str4 = null;
        GAUsage.m1070a().m1071a(Field.CONSTRUCT_TRANSACTION);
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.set(Fields.HIT_TYPE, HitTypes.TRANSACTION);
        mapBuilder.set(Fields.TRANSACTION_ID, str);
        mapBuilder.set(Fields.TRANSACTION_AFFILIATION, str2);
        mapBuilder.set(Fields.TRANSACTION_REVENUE, d == null ? null : Double.toString(d.doubleValue()));
        mapBuilder.set(Fields.TRANSACTION_TAX, d2 == null ? null : Double.toString(d2.doubleValue()));
        String str5 = Fields.TRANSACTION_SHIPPING;
        if (d3 != null) {
            str4 = Double.toString(d3.doubleValue());
        }
        mapBuilder.set(str5, str4);
        mapBuilder.set(Fields.CURRENCY_CODE, str3);
        return mapBuilder;
    }

    public Map build() {
        return new HashMap(this.map);
    }

    public String get(String str) {
        GAUsage.m1070a().m1071a(Field.MAP_BUILDER_GET);
        return (String) this.map.get(str);
    }

    public MapBuilder set(String str, String str2) {
        GAUsage.m1070a().m1071a(Field.MAP_BUILDER_SET);
        if (str != null) {
            this.map.put(str, str2);
        } else {
            Log.m1079w(" MapBuilder.set() called with a null paramName.");
        }
        return this;
    }

    public MapBuilder setAll(Map map) {
        GAUsage.m1070a().m1071a(Field.MAP_BUILDER_SET_ALL);
        if (map != null) {
            this.map.putAll(new HashMap(map));
        }
        return this;
    }

    public MapBuilder setCampaignParamsFromUrl(String str) {
        GAUsage.m1070a().m1071a(Field.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
        String b = ar.m1184b(str);
        if (!TextUtils.isEmpty(b)) {
            Map a = ar.m1181a(b);
            set(Fields.CAMPAIGN_CONTENT, (String) a.get("utm_content"));
            set(Fields.CAMPAIGN_MEDIUM, (String) a.get("utm_medium"));
            set(Fields.CAMPAIGN_NAME, (String) a.get("utm_campaign"));
            set(Fields.CAMPAIGN_SOURCE, (String) a.get("utm_source"));
            set(Fields.CAMPAIGN_KEYWORD, (String) a.get("utm_term"));
            set(Fields.CAMPAIGN_ID, (String) a.get("utm_id"));
            set("&gclid", (String) a.get("gclid"));
            set("&dclid", (String) a.get("dclid"));
            set("&gmob_t", (String) a.get("gmob_t"));
        }
        return this;
    }
}
