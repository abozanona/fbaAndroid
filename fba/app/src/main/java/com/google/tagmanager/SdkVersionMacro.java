package com.google.tagmanager;

import android.os.Build.VERSION;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class SdkVersionMacro extends FunctionCallImplementation {
	private static final String ID;

	static {
		ID = FunctionType.SDK_VERSION.toString();
	}

	public SdkVersionMacro() {
		super(ID, new String[0]);
	}

	public static String getFunctionId() {
		return ID;
	}

	public Value evaluate(Map<String, Value> parameters) {
		return Types.objectToValue(Integer.valueOf(VERSION.SDK_INT));
	}

	public boolean isCacheable() {
		return true;
	}
}
