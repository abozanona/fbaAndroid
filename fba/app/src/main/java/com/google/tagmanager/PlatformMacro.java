package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class PlatformMacro extends FunctionCallImplementation {
	private static final String ID;
	private static final Value PLATFORM;

	static {
		ID = FunctionType.PLATFORM.toString();
		PLATFORM = Types.objectToValue("Android");
	}

	public PlatformMacro() {
		super(ID, new String[0]);
	}

	public static String getFunctionId() {
		return ID;
	}

	public Value evaluate(Map<String, Value> parameters) {
		return PLATFORM;
	}

	public boolean isCacheable() {
		return true;
	}
}
