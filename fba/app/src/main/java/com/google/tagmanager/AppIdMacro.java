package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class AppIdMacro extends FunctionCallImplementation {
	private static final String ID;
	private final Context mContext;

	static {
		ID = FunctionType.APP_ID.toString();
	}

	public AppIdMacro(Context context) {
		super(ID, new String[0]);
		this.mContext = context;
	}

	public static String getFunctionId() {
		return ID;
	}

	public Value evaluate(Map<String, Value> parameters) {
		return Types.objectToValue(this.mContext.getPackageName());
	}

	public boolean isCacheable() {
		return true;
	}
}
