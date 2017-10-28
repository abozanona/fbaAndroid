package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class GreaterThanPredicate extends NumberPredicate {
	private static final String ID;

	static {
		ID = FunctionType.GREATER_THAN.toString();
	}

	public GreaterThanPredicate() {
		super(ID);
	}

	public static String getFunctionId() {
		return ID;
	}

	protected boolean evaluateNumber(TypedNumber arg0, TypedNumber arg1, Map<String, Value> parameters) {
		return arg0.compareTo(arg1) > 0;
	}
}
