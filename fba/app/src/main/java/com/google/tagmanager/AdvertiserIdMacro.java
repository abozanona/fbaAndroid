package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class AdvertiserIdMacro extends FunctionCallImplementation {
	private static final String ID;
	private final Context mContext;

	static {
		ID = FunctionType.ADVERTISER_ID.toString();
	}

	public AdvertiserIdMacro(Context context) {
		super(ID, new String[0]);
		this.mContext = context;
	}

	public static String getFunctionId() {
		return ID;
	}

	public Value evaluate(Map<String, Value> parameters) {
		return Types.getDefaultValue();
	}

	public boolean isCacheable() {
		return true;
	}
}
