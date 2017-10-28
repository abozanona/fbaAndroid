package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class ConstantMacro extends FunctionCallImplementation {
	private static final String ID;
	private static final String VALUE;

	static {
		ID = FunctionType.CONSTANT.toString();
		VALUE = Key.VALUE.toString();
	}

	public ConstantMacro() {
		String r0_String = ID;
		String[] r1_String_A = new String[1];
		r1_String_A[0] = VALUE;
		super(r0_String, r1_String_A);
	}

	public static String getFunctionId() {
		return ID;
	}

	public static String getValueKey() {
		return VALUE;
	}

	public Value evaluate(Map<String, Value> parameters) {
		return (Value) parameters.get(VALUE);
	}

	public boolean isCacheable() {
		return true;
	}
}
