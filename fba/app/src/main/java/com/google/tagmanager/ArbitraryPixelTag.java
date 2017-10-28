package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ArbitraryPixelTag extends TrackingTag {
	private static final String ADDITIONAL_PARAMS;
	static final String ARBITRARY_PIXEL_UNREPEATABLE;
	private static final String ID;
	private static final String UNREPEATABLE;
	private static final String URL;
	private static final Set<String> unrepeatableIds;
	private final Context mContext;
	private final HitSenderProvider mHitSenderProvider;

	public static interface HitSenderProvider {
		public HitSender get();
	}

	class AnonymousClass_1 implements ArbitraryPixelTag.HitSenderProvider {
		final /* synthetic */ Context val$context;

		AnonymousClass_1(Context r1_Context) {
			this.val$context = r1_Context;
		}

		public HitSender get() {
			return DelayedHitSender.getInstance(this.val$context);
		}
	}


	static {
		ID = FunctionType.ARBITRARY_PIXEL.toString();
		URL = Key.URL.toString();
		ADDITIONAL_PARAMS = Key.ADDITIONAL_PARAMS.toString();
		UNREPEATABLE = Key.UNREPEATABLE.toString();
		ARBITRARY_PIXEL_UNREPEATABLE = "gtm_" + ID + "_unrepeatable";
		unrepeatableIds = new HashSet();
	}

	public ArbitraryPixelTag(Context context) {
		this(context, new AnonymousClass_1(context));
	}

	@VisibleForTesting
	ArbitraryPixelTag(Context context, HitSenderProvider hitSenderProvider) {
		String r0_String = ID;
		String[] r1_String_A = new String[1];
		r1_String_A[0] = URL;
		super(r0_String, r1_String_A);
		this.mHitSenderProvider = hitSenderProvider;
		this.mContext = context;
	}

	public static String getFunctionId() {
		return ID;
	}

	private synchronized boolean idProcessed(String unrepeatableId) {
		boolean r0z = true;
		synchronized(this) {
			if (idInCache(unrepeatableId)) {
			} else if (idInSharedPreferences(unrepeatableId)) {
				unrepeatableIds.add(unrepeatableId);
			} else {
				r0z = false;
			}
		}
		return r0z;
	}

	@VisibleForTesting
	void clearCache() {
		unrepeatableIds.clear();
	}

	public void evaluateTrackingTag(Map<String, Value> tag) {
		String unrepeatableId;
		unrepeatableId = (tag.get(UNREPEATABLE) != null) ? Types.valueToString((Value) tag.get(UNREPEATABLE)) : null;
		if (unrepeatableId == null || !idProcessed(unrepeatableId)) {
			Builder uriBuilder = Uri.parse(Types.valueToString((Value) tag.get(URL))).buildUpon();
			Value additionalParamsList = (Value) tag.get(ADDITIONAL_PARAMS);
			if (additionalParamsList != null) {
				Object l = Types.valueToObject(additionalParamsList);
				if (!((l instanceof List))) {
					Log.e("ArbitraryPixel: additional params not a list: not sending partial hit: " + uriBuilder.build().toString());
					return;
				} else {
					Iterator r4_Iterator = ((List) l).iterator();
					while (r4_Iterator.hasNext()) {
						Object m = r4_Iterator.next();
						if (!((m instanceof Map))) {
							Log.e("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + uriBuilder.build().toString());
							return;
						} else {
							Iterator i$ = ((Map) m).entrySet().iterator();
							while (i$.hasNext()) {
								Entry<Object, Object> entry = (Entry) i$.next();
								uriBuilder.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
							}
						}
					}
				}
			}
			String uri = uriBuilder.build().toString();
			this.mHitSenderProvider.get().sendHit(uri);
			Log.v("ArbitraryPixel: url = " + uri);
			if (unrepeatableId != null) {
				Class r16_Class = ArbitraryPixelTag.class;
				synchronized(r16_Class) {
					unrepeatableIds.add(unrepeatableId);
					SharedPreferencesUtil.saveAsync(this.mContext, ARBITRARY_PIXEL_UNREPEATABLE, unrepeatableId, "true");
				}
			}
		}
	}

	@VisibleForTesting
	boolean idInCache(String unrepeatableId) {
		return unrepeatableIds.contains(unrepeatableId);
	}

	@VisibleForTesting
	boolean idInSharedPreferences(String unrepeatableId) {
		return this.mContext.getSharedPreferences(ARBITRARY_PIXEL_UNREPEATABLE, 0).contains(unrepeatableId);
	}
}
