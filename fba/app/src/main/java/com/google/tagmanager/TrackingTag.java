package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

abstract class TrackingTag extends FunctionCallImplementation {
	public TrackingTag(String functionId, String ... requiredKeys) {
		super(functionId, requiredKeys);
	}

	public Value evaluate(Map<String, Value> parameters) {
		evaluateTrackingTag(parameters);
		return Types.getDefaultValue();
	}

	public abstract void evaluateTrackingTag(Map<String, Value> r1_Map_StringValue);

	public boolean isCacheable() {
		return false;
	}
}
