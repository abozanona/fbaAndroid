package com.google.tagmanager;

import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Iterator;
import java.util.Map;

abstract class Predicate extends FunctionCallImplementation {
	private static final String ARG0;
	private static final String ARG1;

	static {
		ARG0 = Key.ARG0.toString();
		ARG1 = Key.ARG1.toString();
	}

	public Predicate(String functionId) {
		String[] r0_String_A = new String[2];
		r0_String_A[0] = ARG0;
		r0_String_A[1] = ARG1;
		super(functionId, r0_String_A);
	}

	public static String getArg0Key() {
		return ARG0;
	}

	public static String getArg1Key() {
		return ARG1;
	}

	public Value evaluate(Map<String, Value> parameters) {
		boolean result = false;
		Iterator i$ = parameters.values().iterator();
		while (i$.hasNext()) {
			if (((Value) i$.next()) == Types.getDefaultValue()) {
				return Types.objectToValue(Boolean.valueOf(false));
			}
		}
		Value arg0 = (Value) parameters.get(ARG0);
		Value arg1 = (Value) parameters.get(ARG1);
		if (arg0 == null || arg1 == null) {
			return Types.objectToValue(Boolean.valueOf(result));
		} else {
			result = evaluateNoDefaultValues(arg0, arg1, parameters);
			return Types.objectToValue(Boolean.valueOf(result));
		}
	}

	protected abstract boolean evaluateNoDefaultValues(Value r1_Value, Value r2_Value, Map<String, Value> r3_Map_StringValue);

	public boolean isCacheable() {
		return true;
	}
}
