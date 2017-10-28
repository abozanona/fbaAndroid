package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class EqualsPredicate extends StringPredicate {
	private static final String ID;

	static {
		ID = FunctionType.EQUALS.toString();
	}

	public EqualsPredicate() {
		super(ID);
	}

	public static String getFunctionId() {
		return ID;
	}

	protected boolean evaluateString(String arg0, String arg1, Map<String, Value> parameters) {
		return arg0.equals(arg1);
	}
}
