package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class EventMacro extends FunctionCallImplementation {
	private static final String ID;
	private final Runtime mRuntime;

	static {
		ID = FunctionType.EVENT.toString();
	}

	public EventMacro(Runtime runtime) {
		super(ID, new String[0]);
		this.mRuntime = runtime;
	}

	public static String getFunctionId() {
		return ID;
	}

	public Value evaluate(Map<String, Value> parameters) {
		String currentEventName = this.mRuntime.getCurrentEventName();
		return (currentEventName == null) ? Types.getDefaultValue() : Types.objectToValue(currentEventName);
	}

	public boolean isCacheable() {
		return false;
	}
}
