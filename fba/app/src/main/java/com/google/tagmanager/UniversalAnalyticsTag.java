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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class UniversalAnalyticsTag extends TrackingTag {
	private static final String ACCOUNT;
	private static final String ANALYTICS_FIELDS;
	private static final String ANALYTICS_PASS_THROUGH;
	private static final String DEFAULT_TRACKING_ID = "_GTM_DEFAULT_TRACKER_";
	private static final String ID;
	private static final String TRACK_TRANSACTION;
	private static final String TRANSACTION_DATALAYER_MAP;
	private static final String TRANSACTION_ITEM_DATALAYER_MAP;
	private static Map<String, String> defaultItemMap;
	private static Map<String, String> defaultTransactionMap;
	private final DataLayer mDataLayer;
	private final TrackerProvider mTrackerProvider;
	private final Set<String> mTurnOffAnonymizeIpValues;

	static {
		ID = FunctionType.UNIVERSAL_ANALYTICS.toString();
		ACCOUNT = Key.ACCOUNT.toString();
		ANALYTICS_PASS_THROUGH = Key.ANALYTICS_PASS_THROUGH.toString();
		ANALYTICS_FIELDS = Key.ANALYTICS_FIELDS.toString();
		TRACK_TRANSACTION = Key.TRACK_TRANSACTION.toString();
		TRANSACTION_DATALAYER_MAP = Key.TRANSACTION_DATALAYER_MAP.toString();
		TRANSACTION_ITEM_DATALAYER_MAP = Key.TRANSACTION_ITEM_DATALAYER_MAP.toString();
	}

	public UniversalAnalyticsTag(Context context, DataLayer dataLayer) {
		this(context, dataLayer, new TrackerProvider(context));
	}

	@VisibleForTesting
	UniversalAnalyticsTag(Context context, DataLayer dataLayer, TrackerProvider trackerProvider) {
		super(ID, new String[0]);
		this.mDataLayer = dataLayer;
		this.mTrackerProvider = trackerProvider;
		this.mTurnOffAnonymizeIpValues = new HashSet();
		this.mTurnOffAnonymizeIpValues.add("");
		this.mTurnOffAnonymizeIpValues.add("0");
		this.mTurnOffAnonymizeIpValues.add("false");
	}

	private void addParam(Map<String, String> itemParams, String gaKey, String value) {
		if (value != null) {
			itemParams.put(gaKey, value);
		}
	}

	private boolean checkBooleanProperty(Map<String, Value> tag, String key) {
		Value value = (Value) tag.get(key);
		return (value == null) ? false : value.getBoolean();
	}

	private Map<String, String> convertToGaFields(Value analyticsFields) {
		if (analyticsFields == null || analyticsFields.getType() != Type.MAP) {
			return new HashMap();
		} else {
			Map<String, String> params = valueToMap(analyticsFields);
			String aip = (String) params.get(Fields.ANONYMIZE_IP);
			if (aip != null) {
				if (this.mTurnOffAnonymizeIpValues.contains(aip.toLowerCase())) {
					params.remove(Fields.ANONYMIZE_IP);
					return params;
				}
				return params;
			}
			return params;
		}
	}

	private String getDataLayerString(String field) {
		Object data = this.mDataLayer.get(field);
		return (data == null) ? null : data.toString();
	}

	public static String getFunctionId() {
		return ID;
	}

	private Map<String, String> getTransactionFields(Map<String, Value> tag) {
		Value map = (Value) tag.get(TRANSACTION_DATALAYER_MAP);
		if (map != null) {
			return valueToMap(map);
		} else {
			if (defaultTransactionMap == null) {
				HashMap<String, String> defaultMap = new HashMap();
				defaultMap.put("transactionId", Fields.TRANSACTION_ID);
				defaultMap.put("transactionAffiliation", Fields.TRANSACTION_AFFILIATION);
				defaultMap.put("transactionTax", Fields.TRANSACTION_TAX);
				defaultMap.put("transactionShipping", Fields.TRANSACTION_SHIPPING);
				defaultMap.put("transactionTotal", Fields.TRANSACTION_REVENUE);
				defaultMap.put("transactionCurrency", Fields.CURRENCY_CODE);
				defaultTransactionMap = defaultMap;
			}
			return defaultTransactionMap;
		}
	}

	private Map<String, String> getTransactionItemFields(Map<String, Value> tag) {
		Value map = (Value) tag.get(TRANSACTION_ITEM_DATALAYER_MAP);
		if (map != null) {
			return valueToMap(map);
		} else {
			if (defaultItemMap == null) {
				HashMap<String, String> defaultMap = new HashMap();
				defaultMap.put("name", Fields.ITEM_NAME);
				defaultMap.put("sku", Fields.ITEM_SKU);
				defaultMap.put("category", Fields.ITEM_CATEGORY);
				defaultMap.put("price", Fields.ITEM_PRICE);
				defaultMap.put("quantity", Fields.ITEM_QUANTITY);
				defaultMap.put("currency", Fields.CURRENCY_CODE);
				defaultItemMap = defaultMap;
			}
			return defaultItemMap;
		}
	}

	private List<Map<String, String>> getTransactionItems() {
		Object data = this.mDataLayer.get("transactionProducts");
		if (data == null) {
			return null;
		} else if (!((data instanceof List))) {
			throw new IllegalArgumentException("transactionProducts should be of type List.");
		} else {
			Iterator i$ = ((List) data).iterator();
			while (i$.hasNext()) {
				if (!((i$.next() instanceof Map))) {
					throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
				}
			}
			return (List) data;
		}
	}

	private void sendTransaction(Tracker tracker, Map<String, Value> tag) {
		String trackingId = ((Value) tag.get(ACCOUNT)).getString();
		String transactionId = getDataLayerString("transactionId");
		if (transactionId == null) {
			Log.e("Cannot find transactionId in data layer.");
			return;
		} else {
			Map<String, String> params;
			Iterator i$;
			Entry<String, String> entry;
			List<Map<String, String>> items;
			List<Map<String, String>> sendQueue = new LinkedList();
			try {
				params = convertToGaFields((Value) tag.get(ANALYTICS_FIELDS));
				params.put(Fields.HIT_TYPE, HitTypes.TRANSACTION);
				i$ = getTransactionFields(tag).entrySet().iterator();
				while (i$.hasNext()) {
					entry = (Entry) i$.next();
					String r18_String = getDataLayerString((String) entry.getKey());
					addParam(params, (String) entry.getValue(), r18_String);
				}
				sendQueue.add(params);
				items = getTransactionItems();
				if (items != null) {
					i$ = items.iterator();
					while (i$.hasNext()) {
						Map<String, String> item = (Map) i$.next();
						if (item.get("name") == null) {
							Log.e("Unable to send transaction item hit due to missing 'name' field.");
							return;
						} else {
							Map<String, String> itemParams = convertToGaFields((Value) tag.get(ANALYTICS_FIELDS));
							itemParams.put(Fields.HIT_TYPE, HitTypes.ITEM);
							itemParams.put(Fields.TRANSACTION_ID, transactionId);
							Iterator i$_2 = getTransactionItemFields(tag).entrySet().iterator();
							while (i$_2.hasNext()) {
								entry = i$_2.next();
								addParam(itemParams, (String) entry.getValue(), (String) item.get(entry.getKey()));
							}
							sendQueue.add(itemParams);
						}
					}
				}
				i$ = sendQueue.iterator();
				while (i$.hasNext()) {
					tracker.send((Map) i$.next());
				}
			} catch (IllegalArgumentException e) {
				Log.e("Unable to send transaction", e);
			}
		}
	}

	private Map<String, String> valueToMap(Value map) {
		if (map.getType() != Type.MAP) {
			return null;
		} else {
			Map<String, String> params = new HashMap(map.getMapKeyCount());
			int i = 0;
			while (i < map.getMapKeyCount()) {
				params.put(Types.valueToString(map.getMapKey(i)), Types.valueToString(map.getMapValue(i)));
				i++;
			}
			return params;
		}
	}

	public void evaluateTrackingTag(Map<String, Value> tag) {
		Tracker tracker = this.mTrackerProvider.getTracker(DEFAULT_TRACKING_ID);
		if (checkBooleanProperty(tag, ANALYTICS_PASS_THROUGH)) {
			tracker.send(convertToGaFields((Value) tag.get(ANALYTICS_FIELDS)));
		} else if (checkBooleanProperty(tag, TRACK_TRANSACTION)) {
			sendTransaction(tracker, tag);
		} else {
			Log.w("Ignoring unknown tag.");
		}
		this.mTrackerProvider.close(tracker);
	}
}
